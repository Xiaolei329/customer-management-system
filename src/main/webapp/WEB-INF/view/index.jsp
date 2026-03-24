<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2024/12/29
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息首页</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://www.layuicdn.com/layui-v2.5.6/css/layui.css" rel="stylesheet" />
    <script src="https://www.layuicdn.com/layui-v2.5.6/layui.js"></script>
    <script>
        layui.use('element', function(){
            var element = layui.element;
            var $ = layui.jquery;
            $(".layui-nav-item a").on('click', function(){
                var address = $(this).attr("data-url");
                if(undefined===address||""===address){
                }else{
                    $("#iframInfo").attr("src", address);
                }
            })
        });
    </script>

</head>

<body class="layui-layout-body" style="overflow: hidden">
<div class="layui-layout  layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">客户管理系统</div>

        <ul class="layui-nav  layui-layout-right">
            <li class="layui-nav-item"><a href="">个人中心</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/logout">退出</a></li>
        </ul>
    </div>

<%--    侧边界面--%>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;"  data-url="${pageContext.request.contextPath}/html/customList.html" ><i class="layui-icon">&#xe604;</i>用户管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="${pageContext.request.contextPath}/html/todo1.html"><i class="layui-icon">&#xe60c;</i>官方网站</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-url="${pageContext.request.contextPath}/html/todo1.html"><i class="layui-icon">&#xe60c;</i>联系我们</a>
                </li>
            </ul>
        </div>
    </div>
<%--    body--%>
    <div class="layui-body">
        <iframe src="${pageContext.request.contextPath}/html/customList.html" id="iframInfo" width="100%" height="100%"   name="iframe" scrolling="auto" class="iframe" framborder="0">
        </iframe>
    </div>
<%--    foot--%>
    <div class="layui-footer">
    </div>
</div>
</body>
</html>
