<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    HttpSession sessao = request.getSession();
    if (sessao.getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }
%>



<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Insert title here</title>
<%@include file="head.jsp"%>
</head>
<body style="background: black;">
    <%@include file="../shared/header.jsp" %>
</body>
</html>
