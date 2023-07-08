
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
    <title>Home</title>
</head>

<body>    
    <div class="bg-dark p-4 pb-3">
        <%@include file="header.jsp" %>
    </div>
    <div class="container-fluid px-0">
        <div class="bg-secondary">
            <hr class="m-0 p-0">
            <div class="px-0 bg-light max-width-container mx-auto" style="height: 100vw;">
                <!-- bg-dark aqui em baixo -->
                <div class="max-width-container mx-auto bg-dark">
                    <div class="d-flex pt-4 justify-content-center flex-wrap">
                        <div>
                            <ul class="nav nav-pills mb-2" id="pills-tab" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active d-flex text-light" id="notificacoes-content-tab"
                                        data-bs-toggle="pill" data-bs-target="#notificacoes-content" type="button"
                                        role="tab" aria-controls="notificacoes-content" aria-selected="false">
                                        <span class="material-symbols-outlined me-2">notifications</span>
                                        <p class="m-0">Notificações</p>
                                    </button>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link d-flex text-light" id="privacidade-content-tab"
                                        data-bs-toggle="pill" data-bs-target="#privacidade-content" type="button"
                                        role="tab" aria-controls="privacidade-content" aria-selected="false">
                                        <span class="material-symbols-outlined me-2">lock</span>
                                        <p class="m-0">Privacidade</p>
                                    </button>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link d-flex text-light" id="seguranca-content-tab"
                                        data-bs-toggle="pill" data-bs-target="#seguranca-content" type="button"
                                        role="tab" aria-controls="seguranca-content" aria-selected="false">
                                        <span class="material-symbols-outlined me-2">security</span>
                                        <p class="m-0">Segurança</p>
                                    </button>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link d-flex text-light" id="tema-content-tab"
                                        data-bs-toggle="pill" data-bs-target="#tema-content" type="button" role="tab"
                                        aria-controls="tema-content" aria-selected="false">
                                        <span class="material-symbols-outlined me-2">dark_mode</span>
                                        <p class="m-0">Tema</p>
                                    </button>
                                </li>
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link d-flex text-light" id="ajuda-content-tab"
                                        data-bs-toggle="pill" data-bs-target="#ajuda-content" type="button" role="tab"
                                        aria-controls="ajuda-content" aria-selected="false">
                                        <span class="material-symbols-outlined me-2">help</span>
                                        <p class="m-0">Ajuda</p>
                                    </button>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="notificacoes-content" role="tabpanel"
                            aria-labelledby="notificacoes-content-tab" tabindex="0">

                            <div>
                                <div class="container max-width-container">
                                    <div class="mx-auto mt-5 align-items-end" style="max-width: 700px;">
                                        <div
                                            class="d-flex justify-content-between align-items-center border border-3 p-4 px-5 rounded-3 ">
                                            <div>
                                                <h5 class="m-0">Notificações de publicações</h5>
                                                <p class="m-0">Mostrar notificações de novas publicações</p>
                                            </div>
                                            <input class="form-check-input p-2" type="checkbox" name="" id="">
                                        </div>
                                        <div
                                            class="d-flex justify-content-between align-items-center border border-3 p-4 px-5 mt-2 rounded-3">
                                            <div>
                                                <h5 class="m-0">Sons</h5>
                                                <p class="m-0">Reproduzir sons ao receber publicações</p>
                                            </div>
                                            <input class="form-check-input p-2" type="checkbox" name="" id="">
                                        </div>
                                        <div class="d-flex justify-content-end mt-3">
                                            <button class="btn btn-primary px-4">Salvar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="tab-pane fade" id="privacidade-content" role="tabpanel"
                            aria-labelledby="privacidade-content-tab" tabindex="0">
                            <div>
                                <div class="container max-width-container">
                                    <div class="mx-auto mt-5 align-items-end" style="max-width: 700px;">
                                        <div
                                            class="d-flex justify-content-between align-items-center border border-3 p-4 px-5 rounded-3 ">
                                            <div>
                                                <h5 class="m-0">Foto de perfil</h5>
                                                <p class="m-0">Exibir foto de perfil para todos</p>
                                            </div>
                                            <input class="form-check-input p-2" type="checkbox" name="" id="">
                                        </div>
                                        <div
                                            class="d-flex justify-content-between align-items-center border border-3 p-4 px-5 mt-2 rounded-3">
                                            <div>
                                                <h5 class="m-0">Recado</h5>
                                                <p class="m-0">Exibir o seu recado para todos</p>
                                            </div>
                                            <input class="form-check-input p-2" type="checkbox" name="" id="">
                                        </div>
                                        <div class="d-flex justify-content-end mt-3">
                                            <button class="btn btn-primary px-4">Salvar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="seguranca-content" role="tabpanel"
                            aria-labelledby="seguranca-content-tab" tabindex="0">
                            <div>
                                <div class="container max-width-container">
                                    <div class="mx-auto mt-5 align-items-end" style="max-width: 700px;">
                                        <div
                                            class="d-flex justify-content-between align-items-center border border-3 p-4 px-5 rounded-3 ">
                                            <div>
                                                <h5 class="m-0">Falta implementar</h5>
                                                <p class="m-0">Falta implementar</p>
                                            </div>
                                            <input class="form-check-input p-2" type="checkbox" name="" id="">
                                        </div>
                                        <div
                                            class="d-flex justify-content-between align-items-center border border-3 p-4 px-5 mt-2 rounded-3">
                                            <div>
                                                <h5 class="m-0">Falta implementar</h5>
                                                <p class="m-0">Falta implementar</p>
                                            </div>
                                            <input class="form-check-input p-2" type="checkbox" name="" id="">
                                        </div>
                                        <div class="d-flex justify-content-end mt-3">
                                            <button class="btn btn-primary px-4">Salvar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="tab-pane fade" id="tema-content" role="tabpanel" aria-labelledby="tema-content-tab"
                            tabindex="0">
                            <div>
                                <div class="container max-width-container">
                                    <div class="mx-auto mt-5 align-items-end" style="max-width: 700px;">
                                        <div
                                            class="d-flex justify-content-between align-items-center border border-3 p-4 px-5 rounded-3 ">
                                            <div class="d-flex flex-column">
                                                <h5 class="mb-3">Escolha um tema</h5>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="flexRadioDefault"
                                                        id="flexRadioDefault1">
                                                    <label class="form-check-label" for="flexRadioDefault1">
                                                        Claro
                                                    </label>
                                                </div>

                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="flexRadioDefault"
                                                        id="flexRadioDefault2" checked>
                                                    <label class="form-check-label" for="flexRadioDefault2">
                                                        Escuro
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-end mt-3">
                                            <button class="btn btn-primary px-4">Salvar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>





                        <div class="tab-pane fade" id="ajuda-content" role="tabpanel"
                            aria-labelledby="ajuda-content-tab" tabindex="0">
                            <div>
                                <div class="container max-width-container">
                                    <div class="mx-auto mt-5 align-items-end border" style="max-width: 600px;">
                                        <div class="accordion accordion-flush" id="accordionFlushExample">
                                            <div class="accordion-item ">
                                                <h2 class="accordion-header" id="flush-headingOne">
                                                    <button class="accordion-button  " type="button"
                                                        data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
                                                        aria-expanded="false" aria-controls="flush-collapseOne">
                                                        <span class="material-symbols-outlined me-2">help</span>
                                                        <p class="m-0">Central de ajuda</p>
                                                    </button>
                                                </h2>
                                                <div id="flush-collapseOne"
                                                    class="accordion-collapse collapse show active"
                                                    aria-labelledby="flush-headingOne"
                                                    data-bs-parent="#accordionFlushExample">
                                                    <div class="accordion-body">
                                                        <h5>Lorem ipsum dolor sit</h5>
                                                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                                                            Dolor
                                                            quia itaque fugit, quis porro saepe rem ducimus
                                                            voluptate doloribus doloremque esse magni. Impedit, nam
                                                            omnis et
                                                            voluptas vero ipsam sint.
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="accordion-item">
                                                <h2 class="accordion-header" id="flush-headingTwo">
                                                    <button class="accordion-button collapsed" type="button"
                                                        data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
                                                        aria-expanded="false" aria-controls="flush-collapseTwo">
                                                        <span
                                                            class="material-symbols-outlined me-2">phone_in_talk</span>
                                                        <p class="m-0">Fale conosco</p>
                                                    </button>
                                                </h2>
                                                <div id="flush-collapseTwo" class="accordion-collapse collapse"
                                                    aria-labelledby="flush-headingTwo"
                                                    data-bs-parent="#accordionFlushExample">
                                                    <div class="accordion-body">
                                                        <h5>Lorem ipsum dolor sit</h5>
                                                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                                                            Dolor
                                                            quia itaque fugit, quis porro saepe rem ducimus voluptate
                                                            doloribus doloremque esse magni. Impedit, nam omnis et
                                                            voluptas
                                                            vero ipsam sint.
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="accordion-item">
                                                <h2 class="accordion-header" id="flush-headingThree">
                                                    <button class="accordion-button collapsed" type="button"
                                                        data-bs-toggle="collapse" data-bs-target="#flush-collapseThree"
                                                        aria-expanded="false" aria-controls="flush-collapseThree">
                                                        <span class="material-symbols-outlined me-2">description</span>
                                                        <p class="m-0">Termos e Política de Privacidade</p>
                                                    </button>
                                                </h2>
                                                <div id="flush-collapseThree" class="accordion-collapse collapse"
                                                    aria-labelledby="flush-headingThree"
                                                    data-bs-parent="#accordionFlushExample">
                                                    <div class="accordion-body">
                                                        <h5>Lorem ipsum dolor sit</h5>
                                                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                                                            Dolor
                                                            quia itaque fugit, quis porro saepe rem ducimus
                                                            voluptate doloribus doloremque esse magni. Impedit, nam
                                                            omnis et
                                                            voluptas vero ipsam sint.
                                                        </p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>




    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
    <script src="../assets/js/shared.js"></script>
</body>

</html>