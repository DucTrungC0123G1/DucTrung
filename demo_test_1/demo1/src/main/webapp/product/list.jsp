<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/20/2023
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div>
    <button type="button" class="btn btn-primary"><a href="#" style="text-decoration: none;color: aliceblue">AddNew</a></button>
</div>

<div class="container-fluid" style="margin-top: 20px">
    <table class="table table-dark table-hover" style="border-radius: 20px">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Date</td>
            <td>Type</td>
            <td>Description</td>
            <td colspan="2" style="text-align: center">Action</td>
        </tr>
        <c:forEach var="productList" items="${productList}">
            <tr>
                <td>${productList.id}</td>
                <td>${productList.name}</td>
                <td>${productList.nsx}</td>
                <c:if test="${productList.typeProduct==true}">
                    <td>Drink</td>
                </c:if>
                <c:if test="${productList.typeProduct==false}">
                    <td>Food</td>
                </c:if>
                <td>${productList.description}</td>
                <td><button type="button" class="btn btn-primary"><a href="#"style="text-decoration: none;color: aliceblue">EDIT</a></button></td>
                <td><button type="button" class="btn btn-danger"><a href="#"style="text-decoration: none;color: aliceblue">DELETE</a></button></td>
            </tr>
        </c:forEach>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
