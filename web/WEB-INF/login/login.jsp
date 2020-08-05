<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/2
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title><spring:message code="title"></spring:message> </title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message"><spring:message code="title"></spring:message> </div>
    <div id="darkbannerwrap"></div>

    <form  class="layui-form" >

        <input name="userSno" placeholder=" <spring:message code="username"/>"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="userPassword" lay-verify="required" placeholder="<spring:message code="password"/>"  type="password" class="layui-input">
        <hr class="hr15">
        <div class="layui-inline" style="width: 100%;">
            <div class="layui-input-inline" style="margin:0px 10px 0px 0px;float: left;">
                <input type="text" name='verify' lay-verify="title" autocomplete="off" placeholder="<spring:message code="authCode"/>" class="layui-input" style="border-top:0;border-left:0;border-right:0;background: none;">
            </div>
            <div class="layui-input-inline" style="float: left;">
                <img onclick="yanzheng()" id="img" src="${pageContext.request.contextPath}/loginController/imgCode.do">
            </div>
        </div>
        <hr class="hr15">

        <input lay-submit lay-filter="login" value=" <spring:message code="login"/>" style="width: 100%;"
               type="button"  onclick="login()" />
        <hr class="hr20" >
        <center>
            <a class="layui-btn layui-btn-sm layui-bg-green" href="${pageContext.request.contextPath}/loginController/login.do?locale=zh">中文</a>
            <a class="layui-btn layui-btn-sm layui-bg-green" href="${pageContext.request.contextPath}/loginController/login.do?locale=en">English</a>
        </center>
    </form>
</div>

<script>
    //图片验证
    function yanzheng(){
        var timestamp = (new Date()).valueOf();
        $("#img").attr("src","${pageContext.request.contextPath}/loginController/imgCode.do?timestamp=" + timestamp);
    }

    function login() {
          $.ajax({
              type:"post",
              url:"${pageContext.request.contextPath}/loginController/checkLogin.ajax",
              data:$("form").serialize(),
              success:function (data) {
                if(data == 'success'){
                    layer.msg('登录成功!',{icon:1,time:300});
                  setTimeout(function(){
                      window.location.href="${pageContext.request.contextPath}/loginController/index.do";
                  },100);
              }else if(data == 'false'){
                    layer.msg('验证码错误!',{icon:2,time:300})
                    yanzheng()
                }else if(data == 'error'){
                    layer.msg('用户名或密码错误!',{icon:2,time:300})
                }
              }
          })
    }

</script>

</body>
</html>