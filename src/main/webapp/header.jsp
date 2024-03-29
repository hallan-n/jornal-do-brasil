<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <div>
        <div class="offcanvas offcanvas-start bg-dark text-light" id="offcanvasExample"
            aria-labelledby="offcanvasExampleLabel">
            <div class="offcanvas-body p-5">
                <div class="d-flex flex-row-reverse mb-5">
                    <a type="button" class="btn link-primary text-light" data-bs-dismiss="offcanvas">
                        <span class="material-symbols-outlined">close</span>
                    </a>
                </div>
                <div>
                    <div>
                        <div class="d-flex justify-content-center mb-2">
                            <img class="profileDefault rounded-circle" src="${user.pathProfilePhoto}" alt="profile" width="170px" height="170px" >
                        </div>
                        <div class="text-center">
                            <h5 class="m-0">${user.name} ${user.surname}</h5>
                            <h5 class="m-0">${user.email}</h5>
                        </div>
                    </div>
                    <hr class="my-5">
                    <div>
                        <div class="d-grid gap-2">
                            <a class="btn btn-outline-secondary text-light text-start d-flex align-self-center p-2 rounded-3"
                                href="user?action=profile">
                                <span class="ms-2 material-symbols-outlined">
                                    person
                                </span>
                                <p class="ms-2 m-0">Seu perfil</p>
                            </a>
                            <a class="btn btn-outline-secondary text-light text-start d-flex align-self-center p-2 rounded-3"
                                href="publication?action=listall">
                                <span class="ms-2 material-symbols-outlined">
                                    newspaper
                                </span>
                                <p class="ms-2 m-0">Sua publicações</p>
                            </a>
                            <a class="btn btn-outline-secondary text-light text-start d-flex align-self-center p-2 rounded-3"
                                href="user?action=logout">
                                <span class="ms-2 material-symbols-outlined">
                                    logout
                                </span>
                                <p class="ms-2 m-0">Sair</p>
                            </a>
                        </div>
                    </div>
                    <hr class="my-5">

                    <div class="d-grid mt-4">
                        <a class="btn btn-primary position-relative" href="publication?action=create" role="button">
                            <span
                                class="material-symbols-outlined position-absolute fs-1 top-0 start-50 translate-middle">add_circle</span>
                            <p class="mt-3 mb-2">Criar uma nova publicação</p>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="header" class="container max-width-container">
        <div class="row d-flex justify-content-between align-items-center">
            <div class="col-4 d-flex align-items-center p-0">
                <a href="#" class="btn link-primary d-flex align-items-center text-light text-decoration-none"
                    type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample"
                    aria-controls="offcanvasExample">
                    <span class="material-symbols-outlined fs-1">menu</span>
                </a>

                <a href="publication?action=list" class="btn link-primary d-flex align-items-center">
                    <span><img src="assets/images/brazil.png" alt="logo_brazil" width="50px"></span>
                </a>
            </div>
            <div class="col d-flex justify-content-end p-0" style="max-height: 50px;">
                <input id="inputQuery" class="form-control py-0 me-2 form-cabecalho-1 form-cabecalho-display" type="search" placeholder="Pesquisar..." aria-label="Search" />
                <a id="anchorQuery" href=" " class="btn btn-primary form-cabecalho-1 me-3 form-cabecalho-display">
                    <span class="material-symbols-outlined fs-3">search</span>                   
                </a>
                <a href="user?action=profile" class="btn link-primary d-flex align-items-center text-light text-decoration-none">
                    <span class="material-symbols-outlined fs-2">person</span>
                </a>
            </div>
        </div>
    </div>
</div>

