<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/2
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" rel="stylesheet" href="${ctx}/css/bootstrap.css">
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <!--图片滚动和样式-->
    <link type="text/css" rel="stylesheet" href="${ctx}/css/login.css">
</head>
<style>

    .register-link a {
        text-decoration: none;
        color: #007bff;
        margin-left: 5px;
    }
</style>
<body style="position: relative; min-height: 80vh;">
<div class="container" style="position: absolute; bottom: 20%;" >
    <div class="row justify-content-center mt-5" >
        <div class="col-md-4" style="margin-left: 38%">
            <h1 class="text-center mb-4">登录页面</h1>
            <form action="##" method="post">
                <div class="form-group mt-4">
                    <label for="username">用户名：</label>
                    <input type="text" class="form-control form-control-sm" id="username" name="username">
                </div>
                <div class="form-group mt-4">
                    <label for="password">密码：</label>
                    <input type="password" class="form-control form-control-sm" id="password" name="password">
                </div>
                <button type="submit" class="btn btn-primary btn-block btn-sm">登录</button>
                <div class="text-right mt-4" style="padding-top: 3%">
                    <span>还没有账号？<a href="${ctx}/register.jsp">立即注册</a></span>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
