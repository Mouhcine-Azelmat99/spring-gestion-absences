package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.*;
import com.mouhcine.SchoolSpringApp.services.IInscriptionService;
import com.mouhcine.SchoolSpringApp.services.INiveauService;
import com.mouhcine.SchoolSpringApp.services.IUtilisateurService;
import com.mouhcine.SchoolSpringApp.utils.ExcelExporter;
import com.mouhcine.SchoolSpringApp.web.models.PersonModel;
import com.mouhcine.SchoolSpringApp.web.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UtilisateurAdminController {

	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	private INiveauService niveauService;

	@Autowired
	private IInscriptionService inscriptionService;

	@Autowired
	private HttpSession httpSession;
	
	
	/** Utilisé pour la journalisation */
	private Logger LOGGER = LoggerFactory.getLogger(getClass());


	public UtilisateurAdminController() {}

	@RequestMapping(value = "showForm", method = RequestMethod.GET)
	public String showForm(@RequestParam int typePerson, Model model) {

		PersonModel pmodel = new PersonModel(typePerson);
		model.addAttribute("personModel", pmodel);

		// Nous avons choisit d'utiliser une classe modèle personnalisée
		// définie par PersonModel pour une meilleur flexibilité
		List<Niveau> niveauxList=niveauService.getAll();
		List<Utilisateur> persons = utilisateurService.getAll();
		List<PersonModel> modelPersons = new ArrayList<PersonModel>();
		// On copie les données des personnes vers le modèle
		for (int i = 0; i < persons.size(); i++) {
			PersonModel pm = new PersonModel();
			if (persons.get(i) instanceof Etudiant) {
				// permet de copier les données d'un objet à l'autre à codition
				// d'avoir les meme attributs (getters/setters)
				BeanUtils.copyProperties((Etudiant) persons.get(i), pm);
				// On fixe le type (cet attribut ne sera pas copié automatiquement)
				pm.setTypePerson(PersonModel.TYPE_STUDENT);

				// Mettre la personne dans le modèle
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof Enseignant) {

				BeanUtils.copyProperties((Enseignant) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
				modelPersons.add(pm);
			}
		}
		model.addAttribute("niveauxList",niveauxList);
		// Mettre la liste des personnes dans le modèle de Spring MVC
		model.addAttribute("personList", modelPersons);

		return "admin/form";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		// Process the user object
		// ...
		return "admin/form";
	}
	@RequestMapping(value = "addPerson", method = RequestMethod.POST)
	public String process(@Valid @ModelAttribute("personModel") PersonModel person, BindingResult bindingResult,
						  Model model, HttpServletRequest rq) {

		// En cas d'erreur de validation
		if (bindingResult.hasErrors()) {
			// rq.setAttribute("typePerson", +person.getTypePerson());
			return "admin/form";
		}

		// Copier les données de l'objet PersonModel vers l'objet Etudiant (cas du
		// formulaire de l'étudiant)
		if (person.getTypePerson() == PersonModel.TYPE_STUDENT) {
			Etudiant etd = new Etudiant();
			BeanUtils.copyProperties(person, etd);
			Inscription inscription = new Inscription();
			LocalDate currentDate = LocalDate.now();
			int currentYear = currentDate.getYear();
			inscription.setAnnee(currentYear);
			inscription.setEtat(1);
			inscription.setEtudiant(etd);
			inscription.setNiveau(person.getNiveau());
			utilisateurService.addUtilisateur(etd);
			inscriptionService.add(inscription);

		}
		// Copier les données de l'objet PersonModel vers l'objet Enseignant (cas du
		// formulaire de l'Enseignant)

		else if (person.getTypePerson() == PersonModel.TYPE_PROF) {
			Enseignant prof = new Enseignant();
			BeanUtils.copyProperties(person, prof);
			utilisateurService.addUtilisateur(prof);

		}
		// Copier les données de l'objet PersonModel vers l'objet CadreAdministrateur
		// (cas du
		// formulaire de CadreAdministrateur)
		else if (person.getTypePerson() == PersonModel.TYPE_CADRE_ADMIN) {
			CadreAdministrateur ca = new CadreAdministrateur();
			BeanUtils.copyProperties(person, ca);
			utilisateurService.addUtilisateur(ca);

		}

		// rediriger vers l'action shwoForm avec le meme type de personne
		return "redirect:/admin/showForm?typePerson=" + person.getTypePerson();
	}

	@RequestMapping(value = "updatePersonForm/{idPerson}", method = RequestMethod.GET)
	public String updatePersonForm(@PathVariable int idPerson, Model model) {
		Utilisateur utl = utilisateurService.getUtilisateurById(Long.valueOf(idPerson));
		System.out.println("user type : "+utl.findType());
		String userType = utl.findType();
		PersonModel pm = new PersonModel();
		if ("Etudiant".equals(userType)) {
			//			BeanUtils.copyProperties((Etudiant) utl, pm);
			System.out.println("user  est etudiant");
			pm.setIdUtilisateur(utl.getIdUtilisateur());
			pm.setCin(utl.getCin());
			pm.setCne(utl.getCne());
			pm.setNom(utl.getNom());
			pm.setPrenom(utl.getPrenom());
			pm.setPrenomArabe(utl.getPrenomArabe());
			pm.setNomArabe(utl.getNomArabe());
			pm.setEmail(utl.getEmail());
			pm.setTelephone(utl.getTelephone());
			pm.setPhoto(utl.getPhoto());
			pm.setTypePerson(PersonModel.TYPE_STUDENT);
		} else if ("Enseignant".equals(userType)) {
			pm.setIdUtilisateur(utl.getIdUtilisateur());
			pm.setCin(utl.getCin());
			pm.setSpecialite(utl.getSpecialite());
			pm.setNom(utl.getNom());
			pm.setPrenom(utl.getPrenom());
			pm.setPrenomArabe(utl.getPrenomArabe());
			pm.setNomArabe(utl.getNomArabe());
			pm.setEmail(utl.getEmail());
			pm.setTelephone(utl.getTelephone());
			pm.setPhoto(utl.getPhoto());
			pm.setTypePerson(PersonModel.TYPE_PROF);
		} else if ("CadreAdministrateur".equals(userType)) {
			pm.setIdUtilisateur(utl.getIdUtilisateur());
			pm.setCin(utl.getCin());
			pm.setGrade(utl.getGrade());
			pm.setNom(utl.getNom());
			pm.setPrenom(utl.getPrenom());
			pm.setPrenomArabe(utl.getPrenomArabe());
			pm.setNomArabe(utl.getNomArabe());
			pm.setEmail(utl.getEmail());
			pm.setTelephone(utl.getTelephone());
			pm.setPhoto(utl.getPhoto());
			pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
		}else{
			System.out.println("user  est utilisteur");
		}
		// Initialiser le modele avec la personne
		model.addAttribute("personModel", pm);

		return "admin/updateForm";
	}

	@PostMapping("updatePerson")
	public String updatePerson(@Valid @ModelAttribute("personModel") PersonModel person, BindingResult bindingResult,
							   Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "admin/updateForm";
		}

		// On copie les données du modèle vers l'objet métier puis on appel le service
		// pour faire la mise à jour
		if (person.getTypePerson() == PersonModel.TYPE_STUDENT) {
			Etudiant etd = new Etudiant();
			BeanUtils.copyProperties(person, etd);

			utilisateurService.updateUtilisateur(etd);

		} else if (person.getTypePerson() == PersonModel.TYPE_PROF) {
			Enseignant prof = new Enseignant();
			BeanUtils.copyProperties(person, prof);
			utilisateurService.updateUtilisateur(prof);

		} else if (person.getTypePerson() == PersonModel.TYPE_CADRE_ADMIN) {
			CadreAdministrateur ca = new CadreAdministrateur();
			BeanUtils.copyProperties(person, ca);
			utilisateurService.updateUtilisateur(ca);

		}

		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");

		return "admin/updateForm";
	}

	@RequestMapping(value = "serachPerson", method = RequestMethod.GET)
	public String serachPerson(@RequestParam String cin, Model model) {

		// On reoit comme paramètre l'id de la personne à mettre à jour
		Utilisateur utl = utilisateurService.getUtilisateurByCin(cin);

		if (utl == null) {

			// Initialiser le modele avec la personne
			model.addAttribute("personModel", new ArrayList<PersonModel>());
		} else {

			// On construit le modèle
			PersonModel pm = new PersonModel();

			// En fonction due type de l'utilisateur à modifier
			// Ceci va nous pemettre d'afficher un formulaire adapté
			// slon le type de la personne
			if (utl instanceof Etudiant) {
				BeanUtils.copyProperties((Etudiant) utl, pm);
				pm.setTypePerson(PersonModel.TYPE_STUDENT);
			} else if (utl instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) utl, pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
			} else if (utl instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) utl, pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);

			}
			List<PersonModel> modelPersons = new ArrayList<PersonModel>();
			modelPersons.add(pm);
			// Initialiser le modele avec la personne
			model.addAttribute("personList", modelPersons);
		}
		return "admin/listPersons";
	}

	@RequestMapping(value = "serachPersonByNom", method = RequestMethod.GET)
	public String serachPersonByNom(@RequestParam String search, Model model) {

		// On reoit comme paramètre l'id de la personne à mettre à jour
		Utilisateur utlByNom = utilisateurService.getUtilisateurByNom(search);
		Utilisateur utlByCin = utilisateurService.getUtilisateurByCin(search);

		if (utlByNom != null) {
			PersonModel pm = new PersonModel();
			if (utlByNom instanceof Etudiant) {
				BeanUtils.copyProperties((Etudiant) utlByNom, pm);
				pm.setTypePerson(PersonModel.TYPE_STUDENT);
			} else if (utlByNom instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) utlByNom, pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
			} else if (utlByNom instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) utlByNom, pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
			}
			List<PersonModel> modelPersons = new ArrayList<PersonModel>();
			modelPersons.add(pm);
			model.addAttribute("personList", modelPersons);
		}else if(utlByCin != null){
			PersonModel pm = new PersonModel();
			if (utlByCin instanceof Etudiant) {
				BeanUtils.copyProperties((Etudiant) utlByCin, pm);
				pm.setTypePerson(PersonModel.TYPE_STUDENT);
			} else if (utlByCin instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) utlByCin, pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
			} else if (utlByCin instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) utlByCin, pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
			}
			List<PersonModel> modelPersons = new ArrayList<PersonModel>();
			modelPersons.add(pm);
			model.addAttribute("personList", modelPersons);
		}else{
			model.addAttribute("personModel", new ArrayList<PersonModel>());
		}

		return "admin/listPersons";
	}


	@RequestMapping("managePersons")
	public String managePersons(Model model) {

		List<Utilisateur> persons = utilisateurService.getAll();
		List<PersonModel> modelPersons = new ArrayList<PersonModel>();

		// Copier les objets metier vers PersonModel plus flexible
		for (int i = 0; i < persons.size(); i++) {
			PersonModel pm = new PersonModel();
			if (persons.get(i) instanceof Etudiant) {
				BeanUtils.copyProperties((Etudiant) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_STUDENT);
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_PROF);
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof CadreAdministrateur) {
				BeanUtils.copyProperties((CadreAdministrateur) persons.get(i), pm);
				pm.setTypePerson(PersonModel.TYPE_CADRE_ADMIN);
				modelPersons.add(pm);
			}
		}

		model.addAttribute("personList", modelPersons);

		return "admin/listPersons";
	}

	@RequestMapping(value = "deletePerson/{idPerson}", method = RequestMethod.GET)
	public String delete(@PathVariable int idPerson) {

		utilisateurService.deleteUtilisateur(Long.valueOf(idPerson));

		return "redirect:/admin/managePersons";
	}

	@GetMapping("exportPersons")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Utilisateur> persons = utilisateurService.getAll();

		ExcelExporter excelExporter = utilisateurService.prepareUtilisateurExport(persons);

		excelExporter.export(response);
	}

}
