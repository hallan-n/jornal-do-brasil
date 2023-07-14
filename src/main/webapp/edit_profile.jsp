<%
    HttpSession sessao=request.getSession();
    if (sessao.getAttribute("email")==null) {
        response.sendRedirect("login.jsp"); 
    }
%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@include file="head.jsp" %>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,700,1,0" />
        <link rel="stylesheet" href="assets/css/global.css">
        <link rel="stylesheet" href="assets/css/header.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="format-detection" content="telephone=no">
        <title>JDB - Editar perfil</title>
</head>

<body>

    <div class="bg-dark p-4 pb-3">
        <header id="header">
            <%@include file="header.jsp" %>
        </header>
    </div>
    <div class="d-flex justify-content-center">
        <div class="border border-3 align-items-center p-5 rounded-3 d-flex flex-wrap gap-5 justify-content-center mt-5" style="max-width: 900px;">
            <input type="file" name="profile" id="profile" hidden accept="image/*">
            <div>
                <label for="profile">

                    <a class="position-relative" role="button">
                        <img class="rounded-circle" src="assets/images/perfil.jpg" alt="..." width="300px" style="filter: brightness(50%);">
                        <span class="material-symbols-outlined position-absolute fs-1 top-0 start-50 translate-middle text-light">edit_square</span>
                    </a>
                </label>
            </div>
            <form action="user" method="post" onsubmit="return passvalidate()">
                <input type="hidden" name="action" value="edit">
                <div class="d-flex gap-3 flex-wrap justify-content-center">
                    <div>

                        <input value="${user.name}" id="txtName" name="txtName" required type="text" class="form-control p-2 mt-2 shadow-sm border border-1" placeholder="Nome" maxlength="45">
                        <input value="${user.surname}" id="txtSurname" name="txtSurname" required type="text" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Sobrenome" maxlength="45">
                        <p id="msg" class="text-danger mt-2 m-0" style="display: none;">${msg}</p>
                        <input value="${user.email}" id="txtEmail" name="txtEmail" required type="email" class="form-control p-2 mt-2 shadow-sm border border-1" placeholder="Email" maxlength="100">
                        <input value="${user.phone}" id="txtPhone" name="txtPhone" required type="tel" class="form-control p-2 mt-2 shadow-sm border border-1" placeholder="Telefone" maxlength="11">
                    </div>
                    <div>
            
                        <input value="${user.password}" id="txtPassword" name="txtPassword" required type="password" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Senha" maxlength="45">
                        <input value="${user.password}" id="txtPassword2" name="txtPassword2" required type="password" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Repetir senha"
                        maxlength="45">
                        <input value="${user.description}" id="txtDescription" name="txtDescription" type="text" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Descrição" maxlength="200">
                    </div>
                </div>
                <div class="d-flex justify-content-end mt-4">
                    <button type="button" class="btn btn-primary  px-5" data-bs-toggle="modal" data-bs-target="#exampleModal" id="publicar">Salvar</button>
                </div>

            <!-- modal -->
                <div class="modal fade " id="exampleModal" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-toggle="dimiss" data-bs-backdrop="static" tabindex="-1">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content border">
                            <div class="modal-header">
                                <h3>Deseja atualizar seus dados??</h3>
                            </div>
                            <div class="modal-body">
                                <h5 class="text-justify">Certifique-se que todos os dados estão corretos!</h5>
                            </div>
                            <div class="modal-footer d-flex justify-content-end mt-4">
                                <button type="submit" class="btn btn-primary px-5" data-bs-dismiss="modal" id="liveAlertBtn">Sim</button>
                                <button type="button" class="ms-2 btn btn-secondary px-5" data-bs-dismiss="modal">Cancelar</button>
                            </div>
                        </div>
                    </div>
                </div>
            <!-- modal -->
            </form>











        </div>
    </div>




    <script src="assets/js/search.js"></script>
    <script src="assets/js/verify.js"></script>
    <script>
        let msg = document.getElementById("msg");
        if (msg.textContent.length > 6) {
            msg.style.display = "block";
        }
    </script>
</body>

</html>