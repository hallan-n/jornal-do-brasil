<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="head.jsp" %>
    <title>Home</title>
    <style>hr {border: solid white 1px;margin: 0;}</style>
</head>

<body>

    <div class="bg-dark p-4 pb-0">
        <%@include file="header.jsp" %>
            <hr class="m-0 p-0 my-4">
            <div>
                <div class="max-width-container mx-auto pb-2" id="menubar-2">
                    <div id="categoria-max">
                        <ul class="nav nav-pills max-width-container justify-content-center form-cabecalho-1">
                            <li><a href="publication?action=list" class="btn nav-link text-light active nav-item">Inicio</a></li>
                            <li><a href="publication?action=list&category=0" class="btn nav-link text-light nav-item">Política</a></li>
                            <li><a href="publication?action=list&category=1" class="btn nav-link text-light nav-item">Business</a></li>
                            <li><a href="publication?action=list&category=2" class="btn nav-link text-light nav-item">Internacional</a></li>
                            <li><a href="publication?action=list&category=3" class="btn nav-link text-light nav-item">Esportes</a></li>
                            <li><a href="publication?action=list&category=4" class="btn nav-link text-light nav-item">Saúde</a></li>
                            <li><a href="publication?action=list&category=5" class="btn nav-link text-light nav-item">Tecnologia</a></li>
                            <li><a href="publication?action=list&category=6" class="btn nav-link text-light nav-item">Entretenimento</a></li>
                            <li><a href="publication?action=list&category=7" class="btn nav-link text-light nav-item">Estilo</a></li>
                            <li><a href="publication?action=list&category=8" class="btn nav-link text-light nav-item">Gastronomia</a></li>
                        </ul>
                    </div>
                    <div class="form-cabecalho-display">
                        <div class="d-flex justify-content-between">
                            <a class="btn btn-secondary  me-2  mb-3 form-cabecalho-2" data-bs-toggle="dropdown" href="#">Categ...</a>
                            <form class="d-flex form-cabecalho-2 mb-3" role="search">
                                <input class="form-control form-cabecalho-2 me-2" type="search" placeholder="Pesquisar..." aria-label="Search" />
                                <button class="btn btn-primary form-cabecalho-2" type="submit">
                                    <span class="material-symbols-outlined fs-3">search</span>
                                </button>
                            </form>
                            <ul class="dropdown-menu dropdown-menu-dark">
                                <li class="dropdown-item btn py-2"><a href="publication?action=list">Inicio</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=0">Política</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=1">Business</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=2">Internacional</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=3">Esportes</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=4">Saúde</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=5">Tecnologia</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=6">Entretenimento</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=7">Estilo</a></li>
                                <li class="dropdown-item btn py-2"><a href="publication?action=list&category=8">Gastronomia</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
    </div>

    <div class="bg-secondary" style="height: 100vw;">
        <div class="container bg-light px-4 max-width-container" style="height: 100vw;">
            <div class="row">
                <div class="col p-0" style="width: 1300px;">

                    <%-- Carrossel --%>
                        <div>
                            <div id="carouselExampleCaptions" class="carousel slide">
                                <div class="carousel-indicators">
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                                </div>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">

                                        <img src="assets/images/teste.png" class="d-block w-100 img-fluid" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>First slide label</h5>
                                            <p>Some representative placeholder content for the first slide.</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="assets/images/teste.png" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Second slide label</h5>
                                            <p>Some representative placeholder content for the second slide.</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="assets/images/teste.png" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Third slide label</h5>
                                            <p>Some representative placeholder content for the third slide.</p>
                                        </div>
                                    </div>
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Previous</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Next</span>
                                </button>
                            </div>

                            <%-- Carrossel --%>

                        </div>
                </div>
            </div>
            <div class="row mt-3">


                <c:forEach items="${publications}" var="pub">

                    <div class="col p-0 me-3">
                        <div class="card">
                            <img src="assets/images/teste.png" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${pub.title}</h5>
                                <p class="card-text">${pub.description}</p>
                                <div>
                                    <a data-bs-toggle="modal" data-bs-target="#exampleModal2" class="btn btn-primary">Abrir</a>
                                    <a href="publication?action=edit&filename=${pub.fileName}" class="btn btn-warning">Editar</a>
                                    <a class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">Apagar</a>
                                </div>
                            </div>



                            <div class="modal fade " id="exampleModal" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-toggle="dimiss" data-bs-backdrop="static" tabindex="-1">
                                <div class="modal-dialog modal-dialog-centered">
                                    <div class="modal-content border">
                                        <div class="modal-header">
                                            <h3>Deseja apagar esta publicação?</h3>
                                        </div>
                                        <div class="modal-body">
                                            <h5 class="text-justify">ATENÇÃO! Esta publicação será apagada de maneira permanente!</h5>
                                        </div>
                                        <div class="modal-footer d-flex justify-content-end mt-4">
                                            <a href="publication?action=delete&filename=${pub.fileName}" class="btn btn-primary px-5">Sim</a>
                                            <button type="button" class="ms-2 btn btn-secondary px-5" data-bs-dismiss="modal">Cancelar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="modal modal-xl fade " id="exampleModal2" aria-labelledby="exampleModalLabel" aria-hidden="true" data-bs-toggle="dimiss" data-bs-backdrop="static" tabindex="-1">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content border">
                                    <div>

                                    <%@include file="teste.html" %>
                                    </div>

                                    <div class="modal-footer d-flex justify-content-end mt-4">
                                        <button type="button" class="ms-2 btn btn-secondary px-5" data-bs-dismiss="modal">Fechar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>

</html>