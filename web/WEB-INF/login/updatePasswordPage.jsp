<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/4
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>修改密码</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->

    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<%--   <style>--%>
<%--       body{--%>
<%--           background:url("${pageContext.request.contextPath}/static/images/up.jpg");--%>
<%--           background-size: 100%;--%>
<%--       }--%>
<%--   </style>--%>
</head>


<div class="layui-container" >
    <div class="layui-row" >
        <form class="layui-form" style="position: absolute;left: 370px;top: 0px">
        <div class="layui-form-item">
            <label for="L_pass" class="layui-form-label">
                <span class="x-red">*</span>旧密码
            </label>
            <div class="layui-input-inline">
                <input type="password" onblur="updatePassword()" id="Old_pass"  required="" lay-verify="required"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                请输入旧密码
            </div>
        </div>
            <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">
                    <span class="x-red">*</span>新密码
                </label>
                <div class="layui-input-inline">
                    <input type="password" id="L_pass" name="pass" required="" lay-verify="pass"
                            class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    6到16个字符
                </div>
            </div>
            <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                    <span class="x-red">*</span>确认密码
                </label>
                <div class="layui-input-inline">
                    <input type="password" id="L_repass" name="repass" required="required" lay-verify="repass"
                            class="layui-input">
                </div>
            </div>
            <div class="layui-form-item" >
                <label for="L_repass" class="layui-form-label">
                </label>
                <button type="submit" class="layui-btn" lay-filter="add" lay-submit="">
                    修改
                </button>
                <button type="reset" class="layui-btn" >
                    重置
                </button>
            </div>
        </form>
    </div>
</div>
<script>


    function updatePassword(){
        var old_pass = $("#Old_pass").val();
        console.log(old_pass)
        $.ajax({
            url:"${pageContext.request.contextPath}/loginController/confimPassword.ajax",
            data:{"oldPass":old_pass},
            success:function (data) {
               if(data=="true"){
                   layer.msg('密码正确',{icon:1,time:500})
               }else {
                   layer.msg("密码错误,请重新输入！",{icon:2,time:500})
               }
            }
        })
    }




    layui.use(['form', 'layer'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function(value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            },
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            repass: function(value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });


        //监听提交
        form.on('submit(add)',
            function() {
                $.post(
                    "${pageContext.request.contextPath}/loginController/updatePassword.ajax",
                    {"newPass":$("#L_pass").val()},
                    function (data) {
                        layer.msg('修改成功',{icon:1,time:300})
                        setTimeout(function () {
                            parent.location.href="${pageContext.request.contextPath}/loginController/logout.do"
                        },300)
                    }
                )
                return false;
            });


    });
</script>
</body>

</html>
