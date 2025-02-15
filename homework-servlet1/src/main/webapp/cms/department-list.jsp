<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/01/2025
  Time: 8:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách Phòng ban</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        h1 {
            margin-bottom: 30px;
            color: #343a40;
        }
        .table th {
            background-color: #007bff;
            color: white;
        }
        .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Danh sách Phòng ban</h1>

    <!-- Form tìm kiếm -->
    <form action="department" method="GET" class="mb-4">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="departmentName">Tên Phòng Ban</label>
                <input type="text" class="form-control" id="departmentName" name="departmentName" placeholder="Nhập tên phòng ban">
            </div>
            <div class="form-group col-md-6">
                <label for="location">Vị Trí</label>
                <input type="text" class="form-control" id="location" name="location" placeholder="Nhập vị trí">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
    </form>

    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Mã phòng ban</th>
            <th>Tên Phòng ban</th>
            <th>Địa chỉ</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="department" items="${departmentData}">
            <tr>
                <td>${department.id}</td>
                <td>${department.departmentName}</td>
                <td>${department.departmentLocation}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
