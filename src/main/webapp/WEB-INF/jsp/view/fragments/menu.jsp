<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="collapse navbar-collapse" id="navbarNav">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link active"
			aria-current="page"
			href="${pageContext.request.contextPath}/admin/showAdminHome">Home</a></li>

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false"> Gestion des personnes </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=2">Add
						Student</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=1">Add
						Prof</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/showForm?typePerson=3">Add
						Cadre Admin</a></li>

				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/managePersons">Manage
						Persons </a></li>


			</ul></li>




		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false">Gestion des comptes </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
			
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/createAccounts">Create
						Accounts</a></li>
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/manageAccounts">List
						Accounts</a></li>
			

			</ul></li>

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
										 href="#" id="classDropdown" role="button"
										 data-bs-toggle="dropdown" aria-expanded="false">Gestion de Class </a>
			<ul class="dropdown-menu" aria-labelledby="classDropdown">
				<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/filiere">Filieres</a></li>
				<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/niveaux">Niveaux</a></li>
				<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/modules">Modules</a></li>
				<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/elements">Elements</a></li>
			</ul>
		</li>

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
										 href="#" id="classDropdown" role="button"
										 data-bs-toggle="dropdown" aria-expanded="false">Gestion de Etudiants </a>
			<ul class="dropdown-menu" aria-labelledby="classDropdown">
				<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/etudiants">les etudiants</a></li>
				<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/inscriptions">inscriptions</a></li>
			</ul>
		</li>

		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbarScrollingDropdown" role="button"
			data-bs-toggle="dropdown" aria-expanded="false">Export Data </a>
			<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
				<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/exportAccounts">Export
						Accounts</a></li>
			   	<li class="dropdown-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/exportPersons">Export
						Persons</a></li>
			</ul>
		</li>


		<li class="nav-item"><form
				action="${pageContext.request.contextPath}/admin/serachPersonByNom"
				class="d-flex" method="GET">
				<input name="search" class="form-control me-2" type="search"
					placeholder="Saisir CIN ou Nom" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form></li>

		<li class="nav-item"><f:form
				action="${pageContext.request.contextPath}/logout" method="POST">

				<button type="submit" class="btn btn-dark mx-5">logout</button>

			</f:form></li>
		</ul>



</div>


