<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/12/29
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理登录</title>
    <style type="text/css">
        body, div, table, tr, td {
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-size: cover;
            background-attachment: fixed;
        }

        .login {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
            padding: 20px;
            width: 300px;
            max-width: 90%;
        }

        .denglu {
            font-size: 24px;
            text-align: center;
            margin-bottom: 20px;
        }

        .login input[type="text"],
        .login input[type="password"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .login input[type="text"]:focus,
        .login input[type="password"]:focus {
            outline: none;
            border-color: #007BFF;
        }

        .login input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .login input[type="submit"]:hover {
            background-color: #0056b3;
        }

        #msg {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-bottom: 10px;
        }

        #verifyCodeImage {
            cursor: pointer;
        }

        @media (max-width: 768px) {
            .login {
                width: 100%;
                padding: 15px;
            }
        }

    </style>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login1.css"/>--%>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        function fun1() {
            $("#msg").hide();
        }
        function fun2() {
            $("#verifyCodeImage").attr("src", "${pageContext.request.contextPath}/getVerifyCode?timestamp=" + (new Date()).valueOf());
        }

    </script>
</head>
<body>
<form class="login" action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr>
            <td colspan="2" ><div class="denglu">登录</div></td>
        </tr>
        <tr>
            <td colspan="2" >
                <lable id="msg">${msg}</lable>
            </td>
        </tr>
        <tr>
            <td colspan="2" >
                <input type="text" placeholder="用户名" name="userName" onkeypress="fun1()" >
            </td>
        </tr>
        <tr>
            <td colspan="2" >
                <input type="password" placeholder="密码" name="password" onkeypress="fun1()" >
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" placeholder="验证码" id="verifyCode" name="verifyCode" />
            </td>
            <td>
                <img id="verifyCodeImage" src="${pageContext.request.contextPath}/getVerifyCode" onclick="fun2()" height="40" width="130" />
            </td>
        </tr>
        <tr>
            <td colspan="2" >
                <input type="submit" class="btn" value="登录" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
