
<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("email") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@include file="head.jsp" %>
    
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,700,1,0" />

<link rel="stylesheet" href="assets/css/global.css">
<link rel="stylesheet" href="assets/css/header.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>


    <title>JDB - Perfil</title>
</head>

<body>

    <div class="bg-dark p-4 pb-3">
        <header id="header">
            <%@include file="header.jsp" %>
        </header>
    </div>
    <div class="container">
        <div class="mx-auto mt-5 p-5" style="max-width: 1300px;">
            <div class="border border-3 align-items-center p-5 rounded-3 row">
                <div class="col-3">
                    <div>
                        <img class="rounded-circle" src="assets/images/perfil.jpg" alt="..." width="100%">
                    </div>
                    <div class="d-grid mt-3">
                        <button class="btn btn-primary">Editar</button>
                    </div>
                </div>
               
                <div class="col-8 ms-5">
                    <div>
                        <div>
                            <p class="p-0 m-0"><span><strong>Nome: &nbsp;</strong></span>${user.name}</p>
                        </div>
                        <hr class="my-2">
                        <div>
                            <p class="p-0 m-0"><span><strong>Email: &nbsp;</strong></span>${user.email}</p>
                        </div>
                        <hr class="my-2">
                        <div>
                            <p class="p-0 m-0"><span><strong>Telefone: &nbsp;</strong></span>${user.phone}</p>
                        </div>
                        <hr class="my-2">
                        <div>
                            <p class="p-0 m-0"><span><strong>Descrição: &nbsp;</strong></span>${user.description}</p>
                        </div>
                    </div>
                </div>
     
            </div>
            <div class="d-flex justify-content-end mt-3">
                <button class="btn btn-primary px-4">Salvar</button>
            </div>
        </div>
    </div>




    <script src="assets/js/search.js"></script>
    <script src="assets/js/verify.js"></script>
</body>

</html>