<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/adminHeader.jsp" />

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

            <jsp:include page="../fragments/menu.jsp" />

        </div>
    </nav>


    <div>
        <h3>Affecter un Coordinateur a Filiere</h3>
    </div>

    <div>
        <h2>${filiereModel.get().titreFiliere}</h2>
        <form action="affecter" method="post">
            <input type="hidden" name="filiereId" value="${filiereModel.get().idFiliere}">
            <input type="date" name="dateDebut" placeholder="dateDebut" class="form-control">
            <input type="date" name="dateFin" placeholder="dateFin" class="form-control">
            <input type="hidden" name="filiereId" value="${filiereModel.get().idFiliere}">
            <label for="enseignantId">Coordinateur</label>
            <select class="form-control" id="enseignantId" name="enseignantId">
                <c:forEach items="${enseignants}" var="e">
                    <option value="${e.idUtilisateur}">${e.nom} - ${e.prenom} - ${e.specialite}</option>
                </c:forEach>
            </select>
            <button class="btn btn-danger">Sumbit</button>
        </form>
    </div>
<jsp:include page="../fragments/adminfooter.jsp" />