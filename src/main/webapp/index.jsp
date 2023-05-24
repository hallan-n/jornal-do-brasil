<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <%@include file="head.jsp" %>
                <title>Home</title>
        </head>

        <body>
            <div class="bg-dark p-4 pb-0">
                <%@include file="header.jsp" %>
                    <hr class="my-4"/>
                    <div>
                        <div class="max-width-container mx-auto pb-2" id="menubar-2">
                            <div id="categoria-max">
                                <ul class="nav nav-pills max-width-container justify-content-center form-cabecalho-1">
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light active" data-bs-toggle="pill" type="bFutton" role="button">Inicio</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Política</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Business</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Internacional</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Esportes</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Saúde</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Tecnologia</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Entretenimento</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Estilo</button>
                                    </li>
                                    <li class="nav-item">
                                        <button class="btn nav-link text-light" data-bs-toggle="pill" type="button" role="button">Gastronomia</button>
                                    </li>
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
                                        <li class="dropdown-item btn py-2"><a>Inicio</a></li>
                                        <li class="dropdown-item btn py-2"><a>Política</a></li>
                                        <li class="dropdown-item btn py-2"><a>Business</a></li>
                                        <li class="dropdown-item btn py-2"><a>Internacional</a></li>
                                        <li class="dropdown-item btn py-2"><a>Esportes</a></li>
                                        <li class="dropdown-item btn py-2"><a>Saúde</a></li>
                                        <li class="dropdown-item btn py-2"><a>Tecnologia</a></li>
                                        <li class="dropdown-item btn py-2"><a>Entretenimento</a></li>
                                        <li class="dropdown-item btn py-2"><a>Estilo</a></li>
                                        <li class="dropdown-item btn py-2"><a>Gastronomia</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>

            <div class="bg-secondary">
                <div class="container bg-light px-4 max-width-container">
                    <div class="row">
                        <div class="col p-0" style="width: 1300px;">
                            <div>
                                <div id="carouselExampleCaptions" class="carousel slide">
                                    <div class="carousel-indicators">
                                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                                    </div>
                                    <div class="carousel-inner">
                                        <div class="carousel-item active">

                                            <img src="assets/images/imagem-1.jpg" class="d-block w-100 img-fluid" alt="...">
                                            <div class="carousel-caption d-none d-md-block">
                                                <h5>First slide label</h5>
                                                <p>Some representative placeholder content for the first slide.</p>
                                            </div>
                                        </div>
                                        <div class="carousel-item">
                                            <img src="assets/images/imagem-1.jpg" class="d-block w-100" alt="...">
                                            <div class="carousel-caption d-none d-md-block">
                                                <h5>Second slide label</h5>
                                                <p>Some representative placeholder content for the second slide.</p>
                                            </div>
                                        </div>
                                        <div class="carousel-item">
                                            <img src="assets/images/imagem-1.jpg" class="d-block w-100" alt="...">
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
                            </div>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col p-0 me-3">
                            <div class="card">
                                <img src="assets/images/imagem-1.jpg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                        of
                                        the card's content.</p>
                                    <a href="#" class="btn btn-primary">Go somewhere</a>
                                </div>
                            </div>
                        </div>
                        <div class="col p-0 me-3">
                            <div class="card">
                                <img src="assets/images/imagem-1.jpg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                        of
                                        the card's content.</p>
                                    <a href="#" class="btn btn-primary">Go somewhere</a>
                                </div>
                            </div>
                        </div>
                        <div class="col p-0 ">
                            <div class="card">
                                <img src="assets/images/imagem-1.jpg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                        of
                                        the card's content.</p>
                                    <a href="#" class="btn btn-primary">Go somewhere</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div>
                        <nav aria-label="Page navigation example ">
                            <ul class="pagination justify-content-center mt-5 mb-0">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </body>

        </html>