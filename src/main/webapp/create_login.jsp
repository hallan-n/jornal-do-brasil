<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <%@include file="head.jsp" %>
        <title>Home</title>
</head>
<body>
    <div class="bg-dark p-4 pb-3">
        <%@include file="header.jsp" %>
    </div>
    <div>
        <div class="container max-width-container">
            <div>
                <div class="row g-0 pt-3 mt-5 border border-3 rounded-2">
                    <div class="col-md-6 mb-md-0 p-md-4 d-flex justify-center flex-column justify-content-center">
                        <h3 class="text-center w-75 mx-auto">Criar conta no Jornal do Bostil</h3>

                        <div class="d-flex justify-content-center form-cabecalho-1">
                            <img src="assets/images/ilustração-formulario.jpg" class="w-75 form-cabecalho-1">
                        </div>
                    </div>

                    <div class="col-md-6 p-4 ps-md-0">
                        <form action="user" method="post">
                            <input type="text" name="txtRegister" hidden>
                            <div class="d-flex flex-column">
                                <input type="hidden" value="register" name="action">
                                <input type="text" class="form-control  p-2 mt-2 shadow-sm border border-1" placeholder="Nome" name="txtName">
                                <input type="text" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Sobrenome" name="txtSurname">
                                <input type="email" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Email" name="txtEmail">
                                <input type="tel" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Telefone" name="txtPhone">
                                <input type="password" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Senha" name="txtPassword">
                                <input type="password" class="form-control p-2  mt-2 shadow-sm border border-1" placeholder="Repetir senha" name="rp_password">
                                <button type="submit" class="btn btn-primary px-4 mt-2">Registrar</button>
                                <div class="d-flex justify-content-between mt-4 flex-wrap">
                                    <div class="d-flex mb-2">
                                        <input class="form-check-input p-2 me-2 shadow-sm" type="checkbox" name="txtAcceptTerms">
                                        <p class="m-0 me-5">Concordo com os termos</p>
                                    </div>
                                    <a href="login.jsp" class="text-decoration-none mb-2">Ja sou cadastrado</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
