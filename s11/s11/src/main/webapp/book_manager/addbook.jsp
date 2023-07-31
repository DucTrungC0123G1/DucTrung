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
</head>
<body>
<div>
    <form action="/BookServlet?action=addBook" method="post">
            <input type="number" name="idBook" placeholder="id">
            <input type="title" name="titleBook" placeholder="title">
            <input type="pageSize" name="pageSize" placeholder="pagesize">
            <select name="category" id="category">
                <option value="1">Tự Nhiên</option>
                <option value="2">Xã Hội</option>
                <option value="3">Truyện</option>
                <option value="4">Tiểu Thuyết</option>
            </select>
        <select name="author" id="author">
            <option value="1">Nguyễn Đức Trung</option>
            <option value="2">Nguyễn Thái Học</option>
            <option value="3">Dương Trung Quốc</option>
            <option value="4">Hà Văn Minh</option>
        </select>
        <button type="submit">Save</button>
    </form>
</div>


</body>
</html>
