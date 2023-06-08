<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="pt-BR">

<head>
        <%@include file="head.jsp" %>

        <style>
            @media (max-width: 800px) { #img{ display: none; } }
        </style>
        <title>Home</title>
</head>

<body>
    <div class="bg-dark p-4 pb-3">
        <%@include file="header.jsp" %>
    </div>
    <div>
        <div class="container max-width-container">
            <div>
                <div class="row p-3 mt-5">
                    <div id="img" class="col">
                        <img src="assets/images/ilustração-formulario.jpg" width="100%" alt="ilustração-formulario.jpg">
                    </div>    
                    <form action="user" method="POST" class="col">
                        <input type="hidden" value="create" name="action">
                        <input type="text" name="txtRegister" hidden>
                        <div class="col">
                            <h5>Criar login</h5>
                            <div class="d-flex flex-column">
                                <input name="txtName" required type="text" class="form-control  p-2 mt-2 shadow-sm border border-1" placeholder="Nome" name="txtName">
                                <input name="txtSurname" required type="text" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Sobrenome" name="txtSurname">
                                <input name="txtEmail" required type="email" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Email" name="txtEmail">
                                <input name="txtPhone" required type="tel" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Telefone" name="txtPhone">
                                <input name="txtPassword" required type="password" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Senha" name="txtPassword">
                                <input type="password" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Repetir senha" name="rp_password">
                                <div class="d-flex justify-content-between mt-4 flex-wrap">
                                    <div class="d-flex mb-2">
                                        <input required name="txtAcceptTerms" class="form-check-input p-2 me-2 shadow-lg" type="checkbox">
                                        <p class="m-0 me-5">Concordo com os termos</p>
                                    </div>
                                    <a href="index.jsp" class="text-decoration-none mb-2"><strong>Ja sou cadastrado</strong></a>
                                </div>
                                <button type="submit" class="btn btn-primary px-4 mt-4">Registrar</button>
                            </div>
                        </div>
                    </form>                            
                </div>
            </div>
        </div>
    </div>
</body>
</html>