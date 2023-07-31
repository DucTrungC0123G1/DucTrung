<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/25/2023
  Time: 2:49 PM
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
<div class="container" style="text-align: center">
    <form action="/BookServlet?action=editBook&id=${idBook}" method="post" style="width: 70%; padding-top: 50px">
        <table>
            <input hidden type="text" name="idBook" value="${books.idBook}">
            <div class="input-group mb-3">
                <span class="input-group-text" id="title">Title</span>
                <input type="text" class="form-control" name="title" value="${books.titleBook}"
                       aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="page-size">PageSize</span>
                <input type="text" class="form-control" name="pageSize" value="${books.pageSize}"
                       aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <label class="input-group-text" for="category">Category</label>
                <select class="form-select" id="category" name="category">
                    <c:if test="${books.category==1}">
                        <option value="1" selected>Tự Nhiên</option>
                        <option value="2">Xã Hội</option>
                        <option value="3">Truyện</option>
                        <option value="4">Tiểu Thuyết</option>
                    </c:if>
                    <c:if test="${books.category==2}">
                        <option value="1">Tự Nhiên</option>
                        <option value="2" selected>Xã Hội</option>
                        <option value="3">Truyện</option>
                        <option value="4">Tiểu Thuyết</option>
                    </c:if>
                    <c:if test="${books.category==3}">
                        <option value="1">Tự Nhiên</option>
                        <option value="2">Xã Hội</option>
                        <option value="3" selected>Truyện</option>
                        <option value="4">Tiểu Thuyết</option>
                    </c:if>
                    <c:if test="${books.category==4}">
                        <option value="1">Tự Nhiên</option>
                        <option value="2">Xã Hội</option>
                        <option value="3">Truyện</option>
                        <option value="4" selected>Tiểu Thuyết</option>
                    </c:if>

                </select>
            </div>
            <div class="input-group mb-3">
                <label class="input-group-text" for="author">Author</label>
                <select class="form-select" id="author" name="author">
                    <c:if test="${books.author==1}">
                        <option value="1" selected>Nguyễn Đức Trung</option>
                        <option value="2">Nguyễn Thái Học</option>
                        <option value="3">Dương Trung Quốc</option>
                        <option value="4">Hà Văn Minhn</option>
                    </c:if>
                    <c:if test="${books.author==2}">
                        <option value="1">Nguyễn Đức Trung</option>
                        <option value="2" selected>Nguyễn Thái Học</option>
                        <option value="3">Dương Trung Quốc</option>
                        <option value="4">Hà Văn Minh</option>
                    </c:if>
                    <c:if test="${books.author==3}">
                        <option value="1">Nguyễn Đức Trung</option>
                        <option value="2">Nguyễn Thái Học</option>
                        <option value="3" selected>Dương Trung Quốc</option>
                        <option value="4">Hà Văn Minhn</option>
                    </c:if>
                    <c:if test="${books.author==4}">
                        <option value="1">Nguyễn Đức Trung</option>
                        <option value="2">Nguyễn Thái Học</option>
                        <option value="3">Dương Trung Quốc</option>
                        <option value="4" selected>Hà Văn Minh</option>
                    </c:if>
                </select>
            </div>
        </table>
        <input type="submit" value="save">
    </form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
