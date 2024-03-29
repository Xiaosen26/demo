<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 2024/3/25
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="0kb" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" rel="stylesheet" href="${ctx}/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${ctx}/css/style.css">
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/simpleCart.min.js"></script>
    <script>
        function validateForm() {
            var phoneNumber = document.getElementById("phone").value;
            var email = document.getElementById("email").value;
            var phonePattern = /^\d{11}$/;
            var emailPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

            if (!phonePattern.test(phoneNumber)) {
                alert("请输入有效的11位手机号！");
                return false;
            }
            if (!emailPattern.test(email)) {
                alert("请输入有效的邮箱格式！");
                return false;
            }
            return true;
        }
    </script>
    <style>
        body {
            background-color: rgba(248, 215, 218, 1);
            color: rgba(114, 28, 36, 1);
            /*filter: blur(1px);*/
            /*opacity: 50%;*/
            background-size: contain;
            background-repeat: no-repeat;
            margin: 0;
            height: 0vh;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="register">
        <form action="register" method="post" onsubmit="return validateForm();">
            <div class="register-top-grid">
                <h3 style="text-align: center">用户注册</h3>
                <div>
                    <span>用户名 <label for="name" style="color:red;">*</label></span>
                    <input type="text" id="name" name="name" required>
                </div>
                <div>
                    <span>密码 <label for="password" style="color:red;">*</label></span>
                    <input type="password" id="password" name="password" required>
                </div>
                <div>
                    <span>学校 <label for="school" style="color:red;">*</label></span>
                    <input type="text" id="school" name="school" required>
                </div>
                <div>
                    <span>学号 <label for="number" style="color:red;">*</label></span>
                    <input type="text" id="number" name="number" required>
                </div>
                <div>
                    <span>手机号 <label for="phone" style="color:red;">*</label></span>
                    <input type="text" id="phone" name="phone" required>
                </div>
                <div>
                    <span>邮箱 <label for="email" style="color:red;">*</label></span>
                    <input type="text" id="email" name="email" required>
                </div>
                <div class="register-but text-center">
                    <input type="submit" value="注册">
                    <div class="clearfix"></div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
