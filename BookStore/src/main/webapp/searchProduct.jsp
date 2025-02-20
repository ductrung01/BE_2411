<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Trang chủ</title>
    <link href="img/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link href="css/bootstrap.css" rel="stylesheet">
    <script src="js/bootstrap.bundle.js"></script>
    <link href="css/bootstrap-icons.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <style>
        .section-header {
            background-color: #f8f9fa;
            padding: 20px 0;
        }
        .section-title {
            font-weight: bold;
            color: #343a40;
        }
        .footer-top {
            background-color: #f8f9fa;
        }
        .footer-bottom {
            background-color: #e9ecef;
        }
    </style>
</head>

<body>

<header class="section-header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-3 py-3">
                <a class="text-body" href="./home.jsp">
                    <h3>Shop Bán Sách</h3>
                </a>
            </div>
            <div class="col-lg-4 col-xl-5">
                <form action="searchProduct" class="search">
                    <div class="input-group w-100">
                        <input type="text" name="keyword" class="form-control" placeholder="Nhập từ khóa cần tìm ...">
                        <button class="btn btn-primary" type="submit">
                            <i class="bi bi-search"></i>
                        </button>
                    </div>
                </form>
            </div>
            <div class="col-lg-5 col-xl-4">
                <ul class="nav col-12 col-lg-auto my-2 my-lg-0 justify-content-center justify-content-lg-end text-small">
                    <li>
                        <a href="#" class="nav-link text-body">
                            <i class="bi bi-person d-block text-center fs-3"></i>
                            Tài khoản
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link text-body">
                            <i class="bi bi-list-check d-block text-center fs-3"></i>
                            Đơn hàng
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link text-body">
                            <i class="bi bi-cart d-block text-center fs-3"></i>
                            Giỏ hàng
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>

<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <strong><i class="bi bi-list"></i> Danh mục sản phẩm</strong>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Sách giáo khoa</a></li>
                        <li><a class="dropdown-item" href="#">Sách khoa học</a></li>
                        <li><a class="dropdown-item" href="#">Truyện tranh</a></li>
                        <li><a class="dropdown-item" href="#">Tiểu thuyết</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Tất cả danh mục</a></li>
                    </ul>
                </li>
                <li class="nav-item"><a class="nav-link" href="#">Sản phẩm mới</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Sản phẩm bán chạy</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Khuyến mãi</a></li>
            </ul>
            <a class="btn btn-light me-2" href="#" role="button">Đăng ký</a>
            <a class="btn btn-primary" href="#" role="button">Đăng nhập</a>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <header class="section-heading py-4">
        <h3 class="section-title">Kết quả tìm kiếm cho: ${param.keyword}</h3>
    </header>

    <c:if test="${not empty searchResults}">
        <div class="row item-grid">
            <c:forEach var="bookModel" items="${searchResults}">
                <div class="col-lg-3 col-md-6 mb-4">
                    <div class="card h-100">
                        <a href="chi-tiet-sach?id=${bookModel.idSach}" class="img-wrap text-center">
                            <img class="img-fluid" src="${bookModel.hinhAnh}" alt="${bookModel.tenSach}">
                        </a>
                        <figcaption class="info-wrap mt-2 text-center">
                            <a href="chi-tiet-sach?id=${bookModel.idSach}" class="title">${bookModel.tenSach}</a>
                            <div class="price mt-1 fw-bold">${bookModel.gia}₫</div>
                        </figcaption>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>

    <c:if test="${empty searchResults}">
        <p class="text-center">Không tìm thấy kết quả nào cho từ khóa: ${param.keyword}</p>
    </c:if>
</div>

<footer class="section-footer">
    <section class="footer-top py-5">
        <div class="container">
            <div class="row">
                <aside class="col-sm-6 col-lg-3">
                    <h6 class="pb-2">Giới thiệu</h6>
                    <ul class="list-unstyled">
                        <li><a href="#">Về Shop</a></li>
                        <li><a href="#">Tuyển dụng</a></li>
                        <li><a href="#">Chính sách thanh toán</a></li>
                        <li><a href="#">Chính sách bảo mật</a></li>
                        <li><a href="#">Giải quyết khiếu nại</a></li>
                        <li><a href="#">Hợp tác</a></li>
                    </ul>
                </aside>
                <aside class="col-sm-6 col-lg-3">
                    <h6 class="pb-2">Hỗ trợ khách hàng</h6>
                    <ul class="list-unstyled">
                        <li>Hotline: 1900-80xx</li>
                        <li><a href="#">Câu hỏi thường gặp</a></li>
                        <li><a href="#">Hướng dẫn đặt hàng</a></li>
                        <li><a href="#">Phương thức vận chuyển</a></li>
                        <li><a href="#">Chính sách đổi trả</a></li>
                    </ul>
                </aside>
                <aside class="col-lg-5">
                    <h6 class="pb-2">Đăng ký nhận tin</h6>
                    <form action="#">
                        <div class="input-group w-100">
                            <input type="text" class="form-control" placeholder="Email của bạn ...">
                            <button class="btn btn-primary" type="button">Đăng ký</button>
                        </div>
                    </form>
                </aside>
            </div>
        </div>
    </section>

    <section class="footer-bottom text-center border-top py-3">
        <div class="container">© 2021 — Shop Bán Sách</div>
    </section>
</footer>

</body>

</html>
