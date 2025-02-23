<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin: Quản lý sản phẩm</title>
    <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link href="../css/bootstrap.css" rel="stylesheet">
    <script src="../js/bootstrap.bundle.js" defer></script>
    <link href="../css/bootstrap-icons.css" rel="stylesheet">
    <link href="../css/styles.css" rel="stylesheet">
</head>

<body>

<header class="section-header">
    <section class="header-main border-bottom">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-11 py-3">
                    <a class="text-body" href="./home.html">
                        <h3>Shop Bán Sách : Admin</h3>
                    </a>
                </div>
                <div class="col-1">
                    <ul class="nav justify-content-end text-small">
                        <li>
                            <a href="#" class="nav-link text-body">
                                <i class="bi bi-window d-block text-center fs-3"></i>
                                Client
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
</header>

<nav class="navbar navbar-expand-lg navbar-light border-bottom">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-people"></i> Quản lý người dùng</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-tags"></i> Quản lý thể loại</a></li>
                <li class="nav-item"><a class="nav-link active" href="#"><i class="bi bi-book"></i> Quản lý sản phẩm</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-cart"></i> Quản lý giỏ hàng</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-inboxes"></i> Quản lý đơn hàng</a></li>
            </ul>
            <a class="btn btn-primary" href="#" role="button">Đăng nhập</a>
        </div>
    </div>
</nav>

<div class="container text-end my-2">
    <div class="d-inline-flex align-items-center">
        <span class="me-3">Xin chào <strong>${username}</strong></span>
        <a href="${applicationScope.baseUrl}/logout" class="btn btn-outline-danger btn-sm">Đăng xuất</a>
    </div>
</div>


<section class="section-content">
    <div class="container">
        <header class="section-heading py-4 d-flex justify-content-between">
            <h3 class="section-title">Quản lý sản phẩm</h3>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/form-insert-book?action=add" role="button">Thêm sản phẩm</a>
        </header>

        <main class="table-responsive-xl mb-5">
            <table class="table table-bordered table-striped table-hover align-middle">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">Tên sách</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Giảm giá</th>
                    <th scope="col">Tác giả</th>
                    <th scope="col">Nhà xuất bản</th>
                    <th scope="col">Năm xuất bản</th>
                    <th scope="col">Số trang</th>
                    <th scope="col">Số lượng tồn kho</th>
                    <th scope="col">Số lượt mua</th>
                    <th scope="col">Hình ảnh</th>
                    <th scope="col">Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bookModel" items="${books}">
                    <tr>
                        <th scope="row">${bookModel.idSach}</th>
                        <td>${bookModel.idSach}</td>
                        <td>${bookModel.tenSach}</td>
                        <td>${bookModel.gia}</td>
                        <td>${bookModel.giamGia}</td>
                        <td>${bookModel.tacGia}</td>
                        <td>${bookModel.nhaXuatBan}</td>
                        <td>${bookModel.namXuatBan}</td>
                        <td>${bookModel.soTrang}</td>
                        <td>${bookModel.soLuongTonKho}</td>
                        <td>${bookModel.tongSoLuotMua}</td>
                        <td><img src="${bookModel.hinhAnh}" alt="${bookModel.tenSach}" style="width: 50px; height: auto;"></td>
                        <td class="text-center text-nowrap">
                            <a class="btn btn-primary me-2" href="#" role="button">Xem</a>
                            <a class="btn btn-success me-2" href="${pageContext.request.contextPath}/form-update-book?id=${bookModel.idSach}" role="button">Sửa</a>
                            <a class="btn btn-danger" href="delete-book?id=${bookModel.idSach}" role="button">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </main>

        <nav class="mt-3 mb-5">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled"><a class="page-link" href="#">Trang trước</a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Trang sau</a></li>
            </ul>
        </nav>
    </div>
</section>

<footer class="section-footer">
    <section class="footer-bottom text-center bg-light border-top py-3">
        <div class="container-fluid">© 2021 — Shop Bán Sách</div>
    </section>
</footer>

</body>

</html>
