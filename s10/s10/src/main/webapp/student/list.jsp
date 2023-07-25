<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/25/2023
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid" style="padding-top: 50px">

    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <td>ID_Student</td>
            <td>Name_Student</td>
            <td>Gender_Student</td>
            <td>Score_Student</td>
            <td>Grade_Student</td>
        </tr>
        </thead>
        <tbody>
        <div class="alert alert-primary" role="alert" style="text-align: center">
            <p>${mess}</p>
        </div>
        <c:forEach var="studentList" items="${studentList}">
            <tr>
                <td>${studentList.idStudent}</td>
                <td>${studentList.nameStudent}</td>
                <c:if test="${studentList.genderStudent==true}">
                    <td>Nam</td>
                </c:if>
                <c:if test="${studentList.genderStudent == false}">
                    <td>Nữ</td>
                </c:if>
                <td>${studentList.scoreStudent}</td>
                <c:choose>
                    <c:when test="${studentList.scoreStudent>=90}">
                        <td>Giỏi</td>
                    </c:when>
                    <c:when test="${studentList.scoreStudent>=80}">
                        <td>Khá</td>
                    </c:when>
                    <c:when test="${studentList.scoreStudent>=60}">
                        <td>Trung Bình</td>
                    </c:when>
                    <c:otherwise>
                        <td>Yếu</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
