package com.mouhcine.SchoolSpringApp.web.controllers;

import com.mouhcine.SchoolSpringApp.bo.Compte;
import com.mouhcine.SchoolSpringApp.services.ICompteService;
import com.mouhcine.SchoolSpringApp.services.IUtilisateurService;
import com.mouhcine.SchoolSpringApp.utils.ExcelExporter;
import com.mouhcine.SchoolSpringApp.web.models.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin") // Très important car, dans Spring security les URL qui commencent par ADMIN
							// sont dédiées
							// à l'admin. Toutes les URL dédinies dans ce controleur définissent des
							// fonctionnalités
							// accessibles uniquement à l'administrateur
public class AccountController {

	@Autowired
	private ICompteService userService; // On obtient par injection automatique le service

	@Autowired
	private IUtilisateurService utilisateurservice; // On obtient par injection automatique le service
	
	//Cette méthode initialise le formulaire de création de compte
	@RequestMapping(value = "createAccountForm/{idPerson}", method = RequestMethod.GET)
	public String createAccountForm(@PathVariable int idPerson, Model model) {
		
		//On crée le model 
		AccountModel accountModel = new AccountModel(Long.valueOf(idPerson));

		//On enregistre le modèle pour le passer à la vue
		model.addAttribute("accountModel", accountModel);

		//On ajoute la liste des roles dans le modele 
		model.addAttribute("roleList", userService.getAllRoles());
		
		//On ajoute également la liste des comptes dans le modèle
		model.addAttribute("accountList", userService.getAllAccounts());

		
		//On affiche la vue
		return "admin/formAccount";
	}

	@GetMapping("manageAccounts")
	public String manageAccounts(@ModelAttribute("accountModel") AccountModel accountModel, Model model) {

		model.addAttribute("accountList", userService.getAllAccounts());

		return "admin/accountList";
	}
	@GetMapping("createAccounts")
	public String createAccounts(@ModelAttribute("accountModel") AccountModel accountModel, Model model) {


		model.addAttribute("personList", utilisateurservice.getAll());

		return "admin/accountCreation";
	}
	
	
	//Cette méthode permet de créer un comote
	@PostMapping("addAccount")
	public String addAccount(HttpServletRequest rq, Model model) {

		
		//La création du compte est implémenter au niveau service
		//Il suffit de passer l'id du role et l'id de personne
		//à la couche service
//		System.out.println("model account = "+accountModel);
		String password = userService.createUser(Long.valueOf(rq.getParameter("roleId")),Long.valueOf(rq.getParameter("utilisateurId")));

		//On affiche le mot de passe dans la vue 
//		accountModel.setPassword(password);
		
		//On affiche également la liste des comptes dans la vue
		model.addAttribute("password", password);
		model.addAttribute("accountList", userService.getAllAccounts());

		
		//On affiche la vue 
		return "/admin/accountList";

	}
	
	@GetMapping("exportAccounts")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=accounts_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<Compte> comptes = userService.getAllAccounts();

		ExcelExporter excelExporter = userService.prepareCompteExport(comptes);

		excelExporter.export(response);
	}
	

}
