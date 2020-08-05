<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>网上选课</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="Content-Type"  content="multipart/form-data; charset=utf-8" />
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
</head>
<body>
<div >
    <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
    </div>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">

                    <div class="layui-card-body ">
                        <form class="layui-form layui-col-space5" action="${pageContext.request.contextPath}/selectAchievementController/achievementPage.do">
                            <div class="layui-inline layui-show-xs-block">
                                <input class="layui-input" value="${achievement.achievementCourse}"  type="text" placeholder="课程名称" name="achievementCourse" >
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <input class="layui-input" value="${achievement.achievementCourseType}"  type="text" placeholder="课程类型" name="achievementCourseType" >
                            </div>
                            <div class="layui-inline layui-show-xs-block">
                                <button class="layui-btn" type="submit" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                <!--                                    <input class="layui-btn" type="submit" th:value=""><i class="layui-icon">&#xe615;</i></input>-->
                            </div>
                        </form>
                    </div>

                    <div class="layui-card-body">
                        <table class="layui-table" >
                            <thead>
                            <tr>
                                <th>课程名称</th>
                                <th>课程类型</th>
                                <th>学分</th>
                                <th>分数</th>
                                <th>备注</th>
                            </thead>
                            <tbody >
                            <c:forEach items="${mapList.list}" var="list">
                            <tr>
                                <td>${list.achievementCourse} </td>
                                <td>${list.achievementCourseType} </td>
                                <td>${list.achievementCourseCredit} </td>
                                <td>${list.achievementCore}</td>
                                <td>正考</td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="layui-card-body ">
                        <div class="page">
                            <div>
                                <a class="prev" href="${pageContext.request.contextPath}/selectAchievementController/achievementPage.do?page=${mapList.firstPage}">首页</a>
                                <a class="num" href="${pageContext.request.contextPath}/selectAchievementController/achievementPage.do?page=${mapList.prePage}">&lt;&lt;</a>
                                <span class="current"  href="${pageContext.request.contextPath}/selectAchievementController/achievementPage.do?page=${mapList.currentPage}">${mapList.currentPage}</span>
                                <a class="num" href="${pageContext.request.contextPath}/selectAchievementController/achievementPage.do?page=${mapList.nextPage}">&gt;&gt;</a>
                                <a class="next" href="${pageContext.request.contextPath}/selectAchievementController/achievementPage.do?page=${mapList.lastPage}">尾页</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

</script>

</html>
