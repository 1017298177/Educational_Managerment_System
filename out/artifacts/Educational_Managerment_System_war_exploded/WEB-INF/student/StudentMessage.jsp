<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面</title>
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

                    <!--                       文件下载 -->
                    <div class="layui-card-body">
                        <table class="layui-table" >
                            <thead>
                            <tr>
                                <c:if test="${role=='student'}">
                                    <th>学号</th>
                                </c:if>
                               <c:if test="${role!='student'}">
                                    <th>职工号</th>
                               </c:if>
                                <th>姓名</th>
                                <th>年龄</th>
                                <th>性别</th>
                                <th>电话号码</th>
                                <th>身份证号码</th>
                                <c:if test="${role=='student'}">
                                    <th>班级</th>
                                </c:if>
                                <th>系别</th>
                                <th>照片</th>
                            </thead>
                            <tbody >
                                <tr>
                                    <td>${user.userSno} </td>
                                    <td>${user.userName} </td>
                                    <td>${user.userAge}</td>
                                    <td>${user.userSex}</td>
                                    <td>${user.userTel}</td>
                                    <td>${user.userCard}</td>
                                    <c:if test="${role=='student'}">
                                        <td>${user.userClass}</td>
                                    </c:if>
                                    <td>${user.userDep}</td>
                                    <td>
                                        <img src="${pageContext.request.contextPath}/static/images/${user.userImage}">
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<script>



</script>

</html>
