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


<script type="text/javascript">
    $(function () {
        // 全选
        $("#parentInput").click(function(){
            $("input:checkbox:gt(0)").prop("checked",$("#parentInput").prop("checked"));
        })
        //判断全选框是否还选中
        var a=$("input:checkbox:gt(0)");
        $.each(a,function(i,m){
            a.click(function(){
                var count = 0;
                $.each(a,function(i,m){
                    if(m.checked==false){
                        count++;
                    }
                })
                if(count==1){
                    $("#parentInput")[0].checked = false;
                }
                if(count==0){
                    $("#parentInput")[0].checked = true;
                }
            })
        })

    })



</script>-->



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
                                <th >
                                    <input type="checkbox"  id="parentInput"  lay-skin="primary">
                                </th>
                                <th>序号</th>
                                <th>课程名称</th>
                                <th>课程性质</th>
                                <th>考核方式</th>
                                <th>学分</th>
                                <th>任课单位</th>
                            </thead>
                            <tbody >
                            <c:forEach items="${mapList.list}" var="list">
                            <tr>
                                <td>
                                    <input value="${list.courseId}" type="checkbox" id="ck"  lay-skin="primary">
                                </td>
                                <td>${list.courseId} </td>
                                <td>${list.courseName} </td>
                                <td>${list.courseType} </td>
                                <td>${list.courseCheckMethod}</td>
                                <td>${list.courseCredit}</td>
                                <td>${list.courseDepartment}</td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="layui-card-body ">
                        <div class="page">
                            <div>
                                <a class="prev" href="${pageContext.request.contextPath}/trainController/trainPage.do?page=${mapList.firstPage}">首页</a>
                                <a class="num" href="${pageContext.request.contextPath}/trainController/trainPage.do?page=${mapList.prePage}">&lt;&lt;</a>
                                <span class="current"  href="${pageContext.request.contextPath}/trainController/trainPage.do?page=${mapList.currentPage}">${mapList.currentPage}</span>
                                <a class="num" href="${pageContext.request.contextPath}/trainController/trainPage.do?page=${mapList.nextPage}">&gt;&gt;</a>
                                <a class="next" href="${pageContext.request.contextPath}/trainController/trainPage.do?page=${mapList.lastPage}">尾页</a>
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
