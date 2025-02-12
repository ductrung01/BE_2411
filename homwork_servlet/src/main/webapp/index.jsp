<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSP - Hello World</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .hero {
      background-color: #007bff;
      color: white;
      padding: 50px 0;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Trang Chủ</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="hello-servlet">Hello Servlet</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="employee">Danh sách nhân viên</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="department">Danh sách phòng ban</a>
      </li>
    </ul>
  </div>
</nav>

<div class="hero text-center">
  <h1 class="display-4"><%= "Hello World!" %></h1>
  <p class="lead">Chào các giang hồ và các con vợ nhé!</p>
</div>

<div class="container mt-5">
  <div class="row">
    <div class="col-md-4">
      <div class="card mb-4 shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Hello Servlet</h5>
          <p class="card-text">Truy cập servlet để xem thông tin chi tiết.</p>
          <a href="hello-servlet" class="btn btn-primary">Xem ngay</a>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card mb-4 shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Danh sách nhân viên</h5>
          <p class="card-text">Xem danh sách tất cả nhân viên.</p>
          <a href="employee" class="btn btn-success">Xem ngay</a>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card mb-4 shadow-sm">
        <div class="card-body">
          <h5 class="card-title">Danh sách phòng ban</h5>
          <p class="card-text">Khám phá các phòng ban trong công ty.</p>
          <a href="department" class="btn btn-info">Xem ngay</a>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
