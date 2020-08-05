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
                    <div class="layui-card-header">
                        <button class="layui-btn" onclick="xadmin.open('设置时间','${pageContext.request.contextPath}/adminEnter/setDimePage.do',600,400)"><i class="layui-icon">&#xe637;</i>设置时间</button>
                    </div>
                    <div class="layui-card-body">
                        <table class="layui-table" >
                            <thead>
                            <tr>
                                <th>学期</th>
                                <th>评教开始时间</th>
                                <th>评教结束时间</th>
                                <th>选课开始时间</th>
                                <th>选课截止时间</th>
                            </thead>
                            <tbody >
                            <c:forEach items="${mapList.list}" var="list">
                                <tr>
                                    <td>${list.semester} </td>
                                    <td>${list.sonsultDateStart} </td>
                                    <td>${list.sonsultDateEnd}</td>
                                    <td>${list.courseDateStart}</td>
                                    <td>${list.courseDateEnd}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="layui-card-body ">
                        <div class="page">
                            <div>
                                <a class="prev" href="${pageContext.request.contextPath}/adminEnter/datePage.do?page=${mapList.firstPage}">首页</a>
                                <a class="num" href="${pageContext.request.contextPath}/adminEnter/datePage.do?page=${mapList.prePage}">&lt;&lt;</a>
                                <span class="current"  href="${pageContext.request.contextPath}/adminEnter/datePage.do?page=${mapList.currentPage}">${mapList.currentPage}</span>
                                <a class="num" href="${pageContext.request.contextPath}/adminEnter/datePage.do?page=${mapList.nextPage}">&gt;&gt;</a>
                                <a class="next" href="${pageContext.request.contextPath}/adminEnter/datePage.do?page=${mapList.lastPage}">尾页</a>
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
    layui.use(['laydate','form','upload'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        var upload = layui.upload;
        //文件上传
        var uploadInst = upload.render(
            {
                //绑定元素
                elem: '#uploadTest',
                // 上传接口
                url: "${pageContext.request.contextPath}/fileResourcesController/fileTrans.do",
                accept:'file',
                type:"post",
                multiple:true,
                done: function(result){
                    layer.msg('上传成功!',{icon:1,time:500});
                    setTimeout(function(){
                        location.reload();
                    },600);
                }
            });

    });

</script>

</html>
