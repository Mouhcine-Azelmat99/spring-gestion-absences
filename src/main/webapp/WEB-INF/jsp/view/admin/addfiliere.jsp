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
        <h3>Ajoouter des filiéres</h3>
    </div>

    <div>
        <c:if test="${msg !=null}">
            <div class="alert alert-success col-6">${msg}</div>
        </c:if>

        <f:form action="addFiliere" method="POST"  modelAttribute="filiereModel">
<%--            <f:input type="text" class="form-control"--%>
<%--                     placeholder="titre Filiere" path="idFiliere"/>--%>
            <f:input type="text" class="form-control"
                     placeholder="titre Filiere" path="titreFiliere"/>
            <f:input type="text" class="form-control"
                     placeholder="code Filiere" path="codeFiliere"/>
            <label for="anneeaccreditation">annee accreditation</label>
            <f:input type="text" class="form-control" id="anneeaccreditation"
                     placeholder="annee accreditation" path="anneeaccreditation"/>
            <label for="anneeFinaccreditation">annee Fin accreditation</label>
            <f:input type="text" class="form-control" id="anneeFinaccreditation"
                     placeholder="annee Fin accreditation" path="anneeFinaccreditation"/>
            <button class="btn btn-primary" type="submit">Submit</button>
        </f:form>
    </div>
<jsp:include page="../fragments/adminfooter.jsp" />