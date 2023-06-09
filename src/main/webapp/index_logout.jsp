<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <%@include file="head.jsp" %>
        <title>JDB - Início</title>
        <style>
            hr {
                border: solid white 1px;
                margin: 0;
            }
        </style>
</head>

<body>

    <div class="bg-dark p-4 pb-0">
        <%@include file="header_logout.jsp" %>
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
                            <%-- <div id="carouselExampleCaptions" class="carousel slide">
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
                            </div> --%>

                            <%-- Carrossel --%>

                        </div>
                </div>
            </div>
            <div class="ms-4 mt-3 d-flex flex-wrap" style="max-width: 1300px;">
                <div>${openPubli}</div>
                <c:forEach items="${publications}" var="pub">
                    <div class="p-0">
                    
                        <div class="card">
                            <div style="overflow: hidden; width: 100%; height: 200px;">
                                <img class="card-img-top img-fluid" src="${pub.pathThumb}" alt="Card image cap" style="object-fit: cover;max-width: 300px; height: 200px;">                            
                            </div>
                            <div class="card-body">
                                <h6 class="card-title">${pub.title}</h6>
                                <p class="card-text">${pub.description}</p>
                                
                                <div>
                                    <a href="publication?action=open&id=${pub.fileName}" class="btn btn-primary">Abrir</a>     
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <script src="assets/js/search.js"></script>
    <script src="assets/js/verify.js"></script>
</body>
</html>