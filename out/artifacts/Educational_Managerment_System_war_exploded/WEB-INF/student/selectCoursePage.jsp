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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
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
                    <div class="layui-card-body">
                        <table class="layui-table" >
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>课程名称</th>
                                <th>课程性质</th>
                                <th>考核方式</th>
                                <th>学分</th>
                                <th>任课教师</th>
                                <th>课程人数</th>
                                <th>是否已选</th>
                                <th>是否撤销</th>
                            </thead>
                            <tbody >
                            <c:forEach items="${mapList.list}" var="list">
                            <tr>
                                <td>${list.courseId} </td>
                                <td>${list.courseName} </td>
                                <td>${list.courseType} </td>
                                <td>${list.courseCheckMethod}</td>
                                <td>${list.courseCredit}</td>
                                <td>${list.courseTeacher}</td>
                                <td>${list.coursePersonTotal}</td>
                                <td>
                                    <c:if test="${list.courseState==1}">
                                <span style="color: red">已选</span>
                                    </c:if>
                                <c:if test="${list.courseState==0}">
                                    <a href="${pageContext.request.contextPath}/selectCourseController/selectCourse.do?courseId=${list.courseId}" style="color: blue">选课</a>
                                </c:if>
                                </td>
                                <td>
                                    <c:if test="${list.courseState==0}">
                                        <span style="color: blue">未选课</span>
                                    </c:if>
                                    <c:if test="${list.courseState==1}">
                                        <a href="${pageContext.request.contextPath}/selectCourseController/updateCourseChecked.do?courseId=${list.courseId}" style="color: red">撤销</a>
                                    </c:if>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="layui-card-body ">
                        <div class="page">
                            <div>
                                <a class="prev" href="${pageContext.request.contextPath}/selectCourseController/selectCoursePage.do?page=${mapList.firstPage}">首页</a>
                                <a class="num" href="${pageContext.request.contextPath}/selectCourseController/selectCoursePage.do?page=${mapList.prePage}">&lt;&lt;</a>
                                <span class="current"  href="${pageContext.request.contextPath}/selectCourseController/selectCoursePage.do?page=${mapList.currentPage}">${mapList.currentPage}</span>
                                <a class="num" href="${pageContext.request.contextPath}/selectCourseController/selectCoursePage.do?page=${mapList.nextPage}">&gt;&gt;</a>
                                <a class="next" href="${pageContext.request.contextPath}/selectCourseController/selectCoursePage.do?page=${mapList.lastPage}">尾页</a>
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
