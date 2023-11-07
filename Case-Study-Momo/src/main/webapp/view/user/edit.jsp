<%--
  Created by IntelliJ IDEA.
  User: piiyk
  Date: 7/10/2023
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css"
            rel="stylesheet"
    />
    <!-- Font Awesome -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <style>
        .navbar {
            background-color: #fad9f3;
        }
        body{
            background-color: #f5e9f2;
        }
        .content{
            margin-top: 60px;
        }
        #carouselDarkVariant{
            margin-top: 60px;
        }
        footer{
            margin-top: 100px;
        }
        #profile{
            margin-top: 150px;
            width: 50%;
            padding: 30px;
            background-color: rgb(247, 218, 223);
        }
        input{
            background-color: rgb(253, 196, 255);
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="view/image/momoIcon.png" alt="" width="30" height="30" class="d-inline-block align-text-top">
            Momo
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Vé xem phim</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Nạp tiền điện thoại</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Nạp Data
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Data 3G</a></li>
                        <li><a class="dropdown-item" href="#">Data 4G</a></li>
                        <li><a class="dropdown-item" href="#">Data 5G</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Thanh Toán Hóa Đơn
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Thanh toán hóa đơn điện</a></li>
                        <li><a class="dropdown-item" href="#">Thanh toán hóa đơn nước</a></li>
                        <li><a class="dropdown-item" href="#">Thanh toán hóa đơn Internet</a></li>
                        <li><a class="dropdown-item" href="#">Thanh toán Ví trả sau</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-danger btn-rounded" type="submit">Search</button>
            </form>

            <ul class="navbar-nav">
                <!-- Avatar -->
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle d-flex align-items-center"
                            href="#"
                            id="navbarDropdownMenuLink"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false"
                    >
                        <img
                                src="https://haycafe.vn/wp-content/uploads/2022/02/Avatar-trang-den-599x600.png"
                                class="rounded-circle"
                                height="30"
                                alt="Portrait of a Woman"
                                loading="lazy"
                        />
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <li>
                            <a class="dropdown-item" href="/profile?action=showProfile&phoneNumber=${userMomo.getPhoneNumber()}">Xem thông tin</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="/profile?action=edit&phoneNumber=${userMomo.getPhoneNumber()}">Chỉnh sửa</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="/profile?action=delete&phoneNumber=${userMomo.getPhoneNumber()}">Xóa tài khoản</a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="/login">Đăng xuất</a>
                        </li>
                    </ul>
                </li>
            </ul>

        </div>
</nav>
<c:if test="${messenger==true}">
    <script>
        alert("Chỉnh sửa thông tin thành công");
    </script>
</c:if>

<c:if test="${messenger==false}">
    <script>
        alert("Chỉnh sửa thông tin thất bại");
    </script>
</c:if>

<div class="container" id ="profile">
    <form action="/profile?action=edit&phoneNumber=${userMomo.getPhoneNumber()}" method="post">
        <div class="row mb-3"><h1 class="text-center">Chỉnh sửa thông tin</h1>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <p class="mb-0">Số điện thoại</p>
            </div>
            <div class="col-sm-9">
                <p class="text-muted mb-0" id="phoneNumber" name="phoneNumber" for="phoneNumber">
                    <c:out value=" ${userMomo.getPhoneNumber()}"/>
                </p>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-sm-3">
                <p class="mb-0">Tên</p>
            </div>
            <div class="col-sm-9">
                <input type="text" id="username" name="username" for="username" class="form-control" value="${userMomo.getUsername()}"/>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-sm-3">
                <p class="mb-0">Mật khẩu</p>
            </div>
            <div class="col-sm-9">
                <input type="password" id="password" name="password" for="password" class="form-control" value=""/>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-sm-3">
                <p class="mb-0">Tài khoản ngân hàng</p>
            </div>
            <div class="col-sm-9">
                <input type="text" id="bankAccountNumber" name="bankAccountNumber" for="bankAccountNumber" class="form-control" value="${userMomo.getBankAccountNumber()}"/>
            </div>
        </div>
        <hr>
        <div class="button-submit text-center mt-3">
            <button type="submit" style="background-color: #eba7da;" class="btn btn-rounded mt-3 ">Chỉnh sửa</button>
        </div>
    </form>
</div>


<!-- Footer -->
<footer class="text-center text-lg-start bg-pink text-muted">
    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <div class="me-5 d-none d-lg-block">
            <span>Kết nối với chúng tôi trên các mạng xã hội:</span>
        </div>
        <div>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-facebook-f"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-twitter"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-google"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-instagram"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-linkedin"></i>
            </a>
            <a href="" class="me-4 link-secondary">
                <i class="fab fa-github"></i>
            </a>
        </div>

    </section>

    <section class="">
        <div class="container text-center text-md-start mt-5">
            <div class="row mt-3">
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">
                        <i class="fas fa-gem me-3 text-secondary"></i>Momo
                    </h6>
                    <p>
                        Với hàng trăm tính năng, bạn có thể thực hiện mọi nhu cầu cuộc sống với siêu ứng dụng MoMo: Chuyển tiền, Gửi tiết kiệm, Vay nhanh, Đặt vé du lịch, Mua vé xem phim, Quyên góp, Mua sắm thanh toán…
                        Nhanh chóng, tiện lợi, an toàn. Cả thế giới trong bàn tay, một chạm là có ngay!
                    </p>
                </div>


                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        VỀ CHÚNG TÔI
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Giới Thiệu</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">An toàn - Bảo mật</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Chính sách quyền riêng tư</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Liên hệ</a>
                    </p>
                </div>


                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                    <!-- Links -->
                    <h6 class="text-uppercase fw-bold mb-4">
                        Dịch vụ nổi bật
                    </h6>
                    <p>
                        <a href="#!" class="text-reset">Vé xem phim</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Nạp tiền điện thoại</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Nạp Data</a>
                    </p>
                    <p>
                        <a href="#!" class="text-reset">Thanh toán hóa đơn</a>
                    </p>
                </div>

                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                    <h6 class="text-uppercase fw-bold mb-4">Liên Hệ</h6>
                    <p><i class="fas fa-home me-3 text-secondary"></i> Ho Chi Minh City, VietNam</p>
                    <p>
                        <i class="fas fa-envelope me-3 text-secondary"></i>
                        piiyk172@gmail.com
                    </p>
                    <p><i class="fas fa-phone me-3 text-secondary"></i> + 0772 416 448</p>
                    <p><i class="fas fa-print me-3 text-secondary"></i> + 0772 416 448</p>
                </div>
            </div>
        </div>
    </section>
    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
        © 2023 Momo:
        <a class="text-reset fw-bold">Momo.com</a>
    </div>
</footer>
<!-- Footer -->


</body>
</html>
