<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/lib/layui/layui.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" action="">
            <input name="courseId" value="${course.courseId}" type="hidden">
            <div class="layui-form-item">
                <label for="courseDepartment" class="layui-form-label">
                    <span class="x-red">*</span>系别
                </label>
                <div class="layui-input-inline">
                    <select id="courseDepartment" name="courseDepartment">
                        <option value="计科系"     <c:if test="${course.courseDepartment=='计科系'}">
                            selected="selected"
                        </c:if>>计科系</option>
                        <option value="数学系"
                                <c:if test="${course.courseDepartment=='数学系'}">
                                    selected="selected"
                                </c:if>
                        >数学系</option>
                        <option value="英语系"
                                <c:if test="${course.courseDepartment=='英语系'}">
                                    selected="selected"
                                </c:if>
                        >英语系</option>
                        <option value="美术系"
                                <c:if test="${course.courseDepartment=='美术系'}">
                                    selected="selected"
                                </c:if>
                        >美术系</option>
                        <option value="体育系"
                                <c:if test="${course.courseDepartment=='体育系'}">
                                    selected="selected"
                                </c:if>
                        >体育系</option>
                    </select>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="courseGrade" class="layui-form-label">
                    <span class="x-red">*</span>年级
                </label>
                <div class="layui-input-inline">
                    <select id="courseGrade" name="courseGrade">
                        <option value="大一"
                                <c:if test="${course.courseGrade=='大一'}">
                                    selected="selected"
                                </c:if>
                        >大一</option>
                        <option value="大二"
                                <c:if test="${course.courseGrade=='大二'}">
                                    selected="selected"
                                </c:if>
                        >大二</option>
                        <option value="大三"
                                <c:if test="${course.courseGrade=='大三'}">
                                    selected="selected"
                                </c:if>
                        >大三</option>
                        <option value="大四"
                                <c:if test="${course.courseGrade=='大四'}">
                                    selected="selected"
                                </c:if>
                        >大四</option>
                    </select>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>



            <div class="layui-form-item">
                <label for="courseSemester" class="layui-form-label">
                    <span class="x-red">*</span>学期
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="courseSemester" value="${course.courseSemester}" name="courseSemester" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">考试类型</label>
                <div class="layui-input-block">
                    <input type="radio" name="courseCheckMethod" value="考试"
                    <c:if test="${course.courseCheckMethod=='考试'}">
                           checked="checked"
                    </c:if>
                           title="考试">
                    <input type="radio" name="courseCheckMethod"
                    <c:if test="${course.courseCheckMethod=='考察'}">
                           checked="checked"
                    </c:if>
                           value="考察" title="考察">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="courseType" class="layui-form-label">
                    <span class="x-red">*</span>年级
                </label>
                <div class="layui-input-inline">
                    <select id="courseType" name="courseType">
                        <option value="专必选"
                                <c:if test="${course.courseType=='专必选'}">
                                    selected="selected"
                                </c:if>
                        >专必选</option>
                        <option value="专任选"
                                <c:if test="${course.courseType=='专任选'}">
                                    selected="selected"
                                </c:if>
                        >专任选</option>
                        <option value="公必选"
                                <c:if test="${course.courseType=='公必选'}">
                                    selected="selected"
                                </c:if>
                        >公必选</option>
                        <option value="公任选"
                                <c:if test="${course.courseType=='公任选'}">
                                    selected="selected"
                                </c:if>
                        >公任选</option>
                    </select>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>



            <div class="layui-form-item">
                <label for="courseCredit" class="layui-form-label">
                    <span class="x-red">*</span>学分
                </label>
                <div class="layui-input-inline">
                    <input type="text" value="${course.courseCredit}" id="courseCredit" name="courseCredit" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>



            <div class="layui-form-item">
                <label for="courseName" class="layui-form-label">
                    <span class="x-red">*</span>课程名字
                </label>
                <div class="layui-input-inline">
                    <input type="text" value="${course.courseName}" id="courseName" name="courseName" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>
            <div class="layui-form-item">
                <label for="coursePersonTotal" class="layui-form-label">
                    <span class="x-red">*</span>课程人数
                </label>
                <div class="layui-input-inline">
                    <input type="text" value="${course.coursePersonTotal}" id="coursePersonTotal" name="coursePersonTotal" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>
                </div>
            </div>



            <div class="layui-form-item">

                </label>
                <button  class="layui-btn" lay-filter="add" lay-submit="">
                    保存
                </button>
            </div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer'],
    function () {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function (value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            },
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            repass: function (value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)',
            function (data) {
                $.ajax({
                    url:"${pageContext.request.contextPath}/classOpenController/saveUpdateCourse.ajax",
                    type:"post",
                    data:$("form").serialize(),
                    success:function (data) {

                    }

                })
                console.log(data);
                //发异步，把数据提交给php
                layer.alert("增加成功", {
                        icon: 6
                    },
                    function () {
                        //关闭当前frame
                        xadmin.close();

                        // 可以对父窗口进行刷新
                        xadmin.father_reload();
                    });
                return false;
            });

    });</script>
<script>var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>

