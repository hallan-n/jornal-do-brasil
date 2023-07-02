



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
            <hr class="my-4" />
    </div>
    <div>
        <form action="publication" method="POST" enctype="multipart/form-data">
            <input type="hidden" value="form" name="action">
            <input type="file" name="file">
            <input type="submit" value="Enviar">
        </form>
    </div>
    
</body>

</html>

