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
    <title>设置时间</title>
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
        <form class="layui-form" >
        <div class="layui-form-item">
            <label for="semester" class="layui-form-label">
                <span class="x-red">*</span>学期
            </label>
            <div class="layui-input-inline">
                <input type="text"  id="semester" name="semester"  required="" lay-verify="required"
                          class="layui-input">
            </div>
        </div>
            <div class="layui-form-item">
                <label for="sonsult_start"  class="layui-form-label">
                    <span class="x-red">*</span>评教开始时间
                </label>
                <div class="layui-input-inline">
                    <input   id="sonsult_start" name="sonsultDateStart"
                             class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="sonsult_end" class="layui-form-label">
                    <span class="x-red">*</span>评教结束时间
                </label>
                <div class="layui-input-inline">
                    <input   id="sonsult_end" name="sonsultDateEnd"
                                   class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="course_start" class="layui-form-label">
                    <span class="x-red">*</span>选课开始时间
                </label>
                <div class="layui-input-inline">
                    <input   id="course_start"  name="courseDateStart"
                                  class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="course_end" class="layui-form-label">
                    <span class="x-red">*</span>选课结束时间
                </label>
                <div class="layui-input-inline">
                    <input   id="course_end"  name="courseDateEnd"
                                class="layui-input">
                </div>
            </div>

            <div class="layui-form-item" >
                <label  class="layui-form-label">
                </label>
                <button type="submit" class="layui-btn" lay-filter="add" lay-submit="">
                    设置
                </button>
                <button type="reset" class="layui-btn" >
                    重置
                </button>
            </div>
        </form>
    </div>
</div>
<script>

    layui.use(['form','laydate', 'layer'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            laydate = layui.laydate,
            layer = layui.layer;


        //执行一个laydate实例
        laydate.render({
            elem: '#sonsult_start'
            ,trigger: 'click'//指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#sonsult_end'
            ,trigger: 'click'//指定元素
        });
        //执行一个laydate实例
        laydate.render({
            elem: '#course_start'
            ,trigger: 'click'//指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#course_end'
            ,trigger: 'click'//指定元素
        });

        //监听提交
        form.on('submit(add)',
            function() {
                $.post(
                    "${pageContext.request.contextPath}/adminEnter/setDime.ajax",
                     $("form").serialize(),
                    function (data) {
                        layer.msg('设置成功',{icon:1,time:300})
                        setTimeout(function (){
                           xadmin.close();
                           xadmin.father_reload();
                        },300)
                    }
                )
                return false;
            });


    });
</script>
</body>

</html>
