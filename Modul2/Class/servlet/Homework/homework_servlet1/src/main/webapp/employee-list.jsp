<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: DELL--%>
<%--  Date: 11/01/2025--%>
<%--  Time: 9:56 CH--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Danh sách Nhân viên</title>--%>

<%--    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <style>--%>
<%--        body {--%>
<%--            background-color: #f8f9fa;--%>
<%--        }--%>
<%--        h1 {--%>
<%--            margin-bottom: 30px;--%>
<%--            color: #343a40;--%>
<%--        }--%>
<%--        .table th {--%>
<%--            background-color: #007bff;--%>
<%--            color: white;--%>
<%--        }--%>
<%--        .table td {--%>
<%--            vertical-align: middle;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container mt-5">--%>
<%--    <h1 class="text-center">Danh sách Nhân viên</h1>--%>
<%--    <table class="table table-striped table-bordered">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>Mã Nhân viên</th>--%>
<%--            <th>Tên</th>--%>
<%--            <th>Chức vụ</th>--%>
<%--            <th>Mức lương</th>--%>
<%--            <th>Phòng ban</th>--%>
<%--            <th>Ngày tuyển dụng</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        &lt;%&ndash;        item ở đây chính là employee data bên controller chỗ Attribute&ndash;%&gt;--%>
<%--        <c:forEach var="employee" items="${employeeData}">--%>
<%--            <tr>--%>
<%--                <td>${employee.id}</td>--%>
<%--                <td>${employee.name}</td>--%>
<%--                <td>${employee.position}</td>--%>
<%--                <td>${employee.salary}</td>--%>
<%--                <td>${employee.department}</td>--%>
<%--                <td>${employee.hireDate}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>


<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>

<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>--%>
<%--</body>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee List</title>

    <!-- CSS Styles -->
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .search-form {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            margin-bottom: 20px;
        }
        .search-form label {
            font-weight: bold;
        }
        .search-form input[type="text"],
        .search-form input[type="date"] {
            padding: 5px;
            width: 200px;
        }
        .search-form input[type="submit"] {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .search-form input[type="submit"]:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>

<h1>Employee List</h1>

<!-- Form tìm kiếm với các trường hiển thị ngang -->
<form class="search-form" action="employeeList" method="get">
    <div>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${param.name}" placeholder="Search by Name"/>
    </div>

    <div>
        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary" value="${param.salary}" placeholder="Search by Salary"/>
    </div>

    <div>
        <label for="fromDate">From Hire Date:</label>
        <input type="date" id="fromDate" name="fromDate" value="${param.fromDate}"/>
    </div>

    <div>
        <label for="toDate">To Hire Date:</label>
        <input type="date" id="toDate" name="toDate" value="${param.toDate}"/>
    </div>

    <div>
        <label for="position">Position:</label>
        <input type="text" id="position" name="position" value="${param.position}" placeholder="Search by Position"/>
    </div>

    <div>
        <input type="submit" value="Search"/>
    </div>
</form>

<!-- Bảng danh sách nhân viên -->
<table>
    <thead>
    <tr>
        <th>Employee ID</th>
        <th>Name</th>
        <th>Position</th>
        <th>Salary</th>
        <th>Department</th>
        <th>Hire Date</th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="employee" items="${employeeData}">
              <tr>
                   <td>${employee.id}</td>
                   <td>${employee.name}</td>
                 <td>${employee.position}</td>
                  <td>${employee.salary}</td>
                  <td>${employee.department}</td>
                <td>${employee.hireDate}</td>
               </tr>
            </c:forEach>
    </tbody>
</table>

</body>
</html>

<%--Controller là tầng nhận request và xử lý request và trả về response
    Tầng Service được sử dụng để xử lý nghiệp vụ của hệ thống
    Tầng DAO (Data Access Object) là tầng được sử dụng để kết nốt đến database
    Tầng Model là tầng chứa thông tin của class--%>
<%--Bước 1: Tạo ra các đối tượng trong model
    Bước 2: kết nối đến database , tạo ra 1 interface trong DAO
    Bước 3: Tạo 1 Packet impl (implement)
    Bước 4: Chúng ta lấy danh sách Employee trong db thì ở trong class
    interface này chúng ta cần 1 hàm để lấy đó là List<Employee> getAllEmployee;
    Bước 5: sang class trong impl  thì chúng ta phải implement lại class interface kia
    và ở đây cx là class để kết nối đến database , ở trong này sẽ tạo các
    connection đến database
    - Tạo sẽ theo trình tự sau:
    Lưu ý ở ây thì nên tạo riêng ra 1 hàm
        + Tạo connection đến db
        + Tạo câu query
        + Thực thi câu query
        + Lấy ra dữ liệu từ câu query đưa vào object java
        + Trả về kết quả là danh sách employee
    Bước 6: Sau khi xong tầng dao thì vào tầng service và cũng tạo 1 interface
            Tạo 1 EmployeeService và cũng có List<Employee>getAllEmployee();
    Bước 7: Cũng tạo ra 1 class EmployeeServiceImpl rồi implement lại lớp interface kia
    Bước 8: Tiếp theo đến phần controller thì chúng ta lúc này đã gọi hết dữ liệu từ
    backend lên rồi và bây giờ chúng ta gắn dữ liệu lên request thôi
    EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employees = employeeService.getAllEmployees();
          req.setAttribute("employeeData", employees);
     Bước 9: Gán dữ liệu lên fontend , chúng ta sẽ tạo 1 vòng lặp foreach
     trên fontenđ
    --%>

<%-- Theo trình tự sẽ là tầng controller sẽ gọi đến tầng service
    và tầng service sẽ gọi đên tầng DAO
    --%>

</html>

