<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Nhân Viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- CSS Styles -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #343a40;
        }
        .container {
            margin-top: 30px;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        .header {
            background-color: #0d6efd;
            color: white;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            margin-bottom: 30px;
            font-size: 28px;
            font-weight: bold;
        }
        .search-form {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            margin-bottom: 30px;
        }
        .search-form label {
            font-weight: bold;
            margin-right: 10px;
        }
        .search-form input[type="text"],
        .search-form input[type="date"] {
            padding: 10px;
            width: 220px;
            border-radius: 5px;
            border: 1px solid #ced4da;
        }
        .search-form input[type="submit"] {
            padding: 10px 20px;
            background-color: #dc3545;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .search-form input[type="submit"]:hover {
            background-color: #c82333;
        }
        th {

            color: black; /* Màu chữ là trắng */
            text-align: center;
        }
        td {
            text-align: center;
        }
        .btn-group .btn {
            margin: 0 5px;
        }
        .table {
            margin-top: 20px;
            border-radius: 8px;
            overflow: hidden;
        }
        .table th, .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
<%
    // Nhận thông báo từ servlet
    String message = (String) request.getAttribute("message");
    if (message != null) {
%>
<p><strong><%= message %></strong></p>
<%
    }
%>
<div class="container">
    <div class="header">
        Danh Sách Nhân Viên
    </div>

    <!-- Form tìm kiếm -->
    <form class="search-form" action="employee" method="get">
        <div>
            <label for="name">Tên:</label>
            <input type="text" id="name" name="name" value="${param.name}" placeholder="Tìm theo tên"/>
        </div>
        <div>
            <label for="salary">Mức lương:</label>
            <input type="text" id="salary" name="salary" value="${param.salary}" placeholder="Tìm theo mức lương"/>
        </div>
        <div>
            <label for="fromDate">Từ ngày tuyển:</label>
            <input type="date" id="fromDate" name="fromDate" value="${param.fromDate}"/>
        </div>
        <div>
            <label for="toDate">Đến ngày tuyển:</label>
            <input type="date" id="toDate" name="toDate" value="${param.toDate}"/>
        </div>
        <div>
            <label for="position">Chức vụ:</label>
            <input type="text" id="position" name="position" value="${param.position}" placeholder="Tìm theo chức vụ"/>
        </div>
        <div>
            <input type="submit" value="Tìm kiếm"/>
        </div>
    </form>

    <form action="action-employee" method="get">
<%--        action dùng để điều hướng trang , điều hướng url sang /action-employee--%>
        <button type="submit" class="btn btn-outline-primary mb-3">Thêm nhân viên</button>
    </form>

    <!-- Bảng danh sách nhân viên -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Chức vụ</th>
            <th>Mức lương</th>
            <th>Phòng ban</th>
            <th>Ngày tuyển</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employeeModel" items="${employeeData}">
            <tr>
                <td>${employeeModel.id}</td>
                <td>${employeeModel.name}</td>
                <td>${employeeModel.position}</td>
                <td>${employeeModel.salary}</td>
                <td>${employeeModel.departmentName}</td>
                <td>${employeeModel.hireDate}</td>
                <td>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-outline-danger">Xóa</button>
                        <button type="button" class="btn btn-outline-warning">Chỉnh sửa</button>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
