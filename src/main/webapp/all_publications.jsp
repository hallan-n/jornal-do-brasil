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
        <title>JDB - Todas publicações</title>
</head>

<body>

    <div class="bg-dark p-4 pb-3">
        <header id="header">
            <%@include file="header.jsp" %>
        </header>
    </div>
    <div class="container">
        <div class="mx-auto mt-5 p-5" style="max-width: 1000px;">
            <input class="form-control" type="text" id="input" placeholder="Pesquisar...">
        <table id="table" class="table">
            <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Título</th>
                    <th scope="col">Descrição</th>
                    <th scope="col">Categoria</th>
                    <th scope="col">Operações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${publications}" var="pub">
                    <tr>
                        <td class="p-3" scope="row">${pub.idPubli}</th>
                        <td class="p-3">${pub.title}</td>
                        <td class="p-3">${pub.description}</td>
                        <td class="p-3">${pub.category}</td>        
                        <td class="d-flex p-0 gap-1 p-1">
                            <a href="publication?action=open&id=${pub.fileName}" class="btn btn-primary">
                                <span class="material-symbols-outlined pt-1">open_in_new</span>
                            </a>
                            <a href="publication?action=edit&id=${pub.fileName}" class="btn btn-warning">
                                <span class="material-symbols-outlined pt-1">edit</span>
                            </a>
                            <a href="publication?action=delete&filename=${pub.fileName}" class="btn btn-danger">
                                <span class="material-symbols-outlined pt-1">delete</span>
                            </a>
                        </td>                                
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </div>




    <script>
    $(document).ready(function () {
    $("#input").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#table tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});
</script>
    <script src="assets/js/search.js"></script>
    <script src="assets/js/verify.js"></script>
</body>

</html>