<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/25/2023
  Time: 2:48 PM
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
<a href="/BookServlet?action=showFormCreate">ADD BOOK</a>
<div class="container" style="width: 70%;padding-top: 30px">
    <table class="table table-bordered table-hover bordered-primary">
        <thead>
        <tr>
            <td hidden>Id</td>
            <td>Title</td>
            <td>PageSize</td>
            <td>Category</td>
            <td>Author</td>
            <td colspan="2" style="text-align: center">Action</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${booksList}">
            <tr>
                <td hidden>${book.idBook}</td>
                <td>${book.titleBook}</td>
                <td>${book.pageSize}</td>
                <td>${book.category}</td>
                <td>${book.author}</td>
                <td><a href="/BookServlet?action=showFormEdit&id=${book.idBook}">
                    <button class="btn btn-primary">EDIT</button>
                </a></td>
                <td><a href="#">
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal"
                            onclick="sendInfoToDelete('${book.idBook}','${book.titleBook}')">
                        DELETE
                    </button>
                </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form id="formDelete" method="get">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Warning</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="action" value="deleteBook"/>
                <input type="hidden" id="id" name="id"/>
                <span>Do You Want Delete Book <span id="nameDelete"></span>?</span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Delete</button>
            </div>
        </div>
        </form>
    </div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function sendInfoToDelete(id,name) {
        alert(id+""+name);
        document.getElementById("nameDelete").innerText = name;
        document.getElementById("id").value = id;

    }

</script>

</html>
