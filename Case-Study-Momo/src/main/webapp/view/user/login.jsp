<%--
  Created by IntelliJ IDEA.
  User: piiyk
  Date: 7/10/2023
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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

    .container{
      margin-top: 80px;
      width: 35%;
      border: 2px #c1a0e0 solid;
      box-shadow: 20px 20px 40px 10px rgb(240, 201, 208) ;
      padding: 30px;
      background-color: #e4dfe4;
    }
  </style>

  <title>Login</title>
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

    <form class="d-flex">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-danger btn-rounded" type="submit">Search</button>
    </form>

</nav>

<div class="container">
  <!-- Pills navs -->
  <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
    <li class="nav-item" role="presentation">
      <a
              class="nav-link active"
              id="tab-login"
              data-mdb-toggle="pill"
              href="#pills-login"
              role="tab"
              aria-controls="pills-login"
              aria-selected="true"
      >Login</a
      >
    </li>
    <li class="nav-item" role="presentation">
      <a
              class="nav-link"
              id="tab-register"
              data-mdb-toggle="pill"
              href="#pills-register"
              role="tab"
              aria-controls="pills-register"
              aria-selected="false"
      >Register</a
      >
    </li>
  </ul>
  <!-- Pills navs -->

  <!-- Pills content -->
  <div class="tab-content">
    <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
      <c:if test="${messenger1==false}">
        <script>
          alert("Bạn nhập sai mật khẩu");
        </script>
      </c:if>
      <c:if test="${messenger2==false}">
        <script>
          alert("Đăng ký tài khoản thất bại");
        </script>
      </c:if>
      <c:if test="${messenger2==true}">
        <script>
          alert("Đăng ký tài khoản thành công");
        </script>
      </c:if>
      <form action="/login?action=login" method="post">
        <div class="text-center mb-3">
          <p>Sign in with:</p>
          <button type="button" class="btn btn-secondary btn-floating mx-1">
            <i class="fab fa-facebook-f"></i>
          </button>

          <button type="button" class="btn btn-secondary btn-floating mx-1">
            <i class="fab fa-google"></i>
          </button>

          <button type="button" class="btn btn-secondary btn-floating mx-1">
            <i class="fab fa-twitter"></i>
          </button>

          <button type="button" class="btn btn-secondary btn-floating mx-1">
            <i class="fab fa-github"></i>
          </button>
        </div>

        <p class="text-center">or:</p>

        <!-- Email input -->
        <div class="form-outline mb-4">
          <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" />
          <label class="form-label" for="phoneNumber">Phone Number</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
          <input type="password" id="password" name="password" class="form-control" />
          <label class="form-label" for="password">Password</label>
        </div>

        <!-- 2 column grid layout -->
        <div class="row mb-4">
          <div class="col-md-6 d-flex justify-content-center">
            <!-- Checkbox -->
            <div class="form-check mb-3 mb-md-0">
              <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked />
              <label class="form-check-label" for="loginCheck"> Remember me </label>
            </div>
          </div>

          <div class="col-md-6 d-flex justify-content-center">
            <!-- Simple link -->
            <a href="#!">Forgot password?</a>
          </div>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

        <!-- Register buttons -->
        <div class="text-center">
          <p>Not a member? <a href="#!">Register</a></p>
        </div>
      </form>
    </div>
    <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
      <form action="/login?action=register" method="post">
        <div class="text-center mb-3">
          <p>Sign up with:</p>
          <button type="button" class="btn btn-secondary btn-floating mx-1">
            <i class="fab fa-facebook-f"></i>
          </button>

          <button type="button" class="btn btn-secondary btn-floating mx-1">
            <i class="fab fa-google"></i>
          </button>

          <button type="button" class="btn btn-secondary btn-floating mx-1">
            <i class="fab fa-twitter"></i>
          </button>

          <button type="button" class="btn btn-secondary btn-floating mx-1">
            <i class="fab fa-github"></i>
          </button>
        </div>

        <p class="text-center">or:</p>

        <!-- Name input -->
        <div class="form-outline mb-4">
          <input type="text" id="rsUsername" name="rsUsername" class="form-control" />
          <label class="form-label" for="rsUsername" >Name</label>
        </div>

        <!-- Username input -->
        <div class="form-outline mb-4">
          <input type="text" id="rsPhoneNumber" name="rsPhoneNumber" class="form-control" />
          <label class="form-label" for="rsPhoneNumber" >Phone Number</label>
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
          <input type="password" id="rsPassword" name="rsPassword" class="form-control" />
          <label class="form-label" for="rsPassword">Password</label>
        </div>

        <!-- Email input -->
        <div class="form-outline mb-4">
          <input type="text" id="rsBankAccountNumber" name="rsBankAccountNumber" class="form-control" />
          <label class="form-label" for="rsBankAccountNumber" >Bank Account Number</label>
        </div>

        <!-- Checkbox -->
        <div class="form-check d-flex justify-content-center mb-4">
          <input
                  class="form-check-input me-2"
                  type="checkbox"
                  value=""
                  id="registerCheck"
                  checked
                  aria-describedby="registerCheckHelpText"
          />
          <label class="form-check-label" for="registerCheck">
            I have read and agree to the terms
          </label>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-3">Resister</button>
      </form>
    </div>
  </div>
  <!-- Pills content -->
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"
></script>
</body>
</html>
</body>
</html>
