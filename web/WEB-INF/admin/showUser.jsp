<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/xadmin.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
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
                    <form class="layui-form layui-col-space5" action="${pageContext.request.contextPath}/adminEnter/dataToShowUser.do">
                        <div class="layui-inline layui-show-xs-block">
                            <select id="userDep" name="userDep">
                                <option value="">选择系别</option>
                                <option value="计科系">计科系</option>
                                <option value="数学系">数学系</option>
                                <option value="英语系">英语系</option>
                                <option value="美术系">美术系</option>
                                <option value="体育系">体育系</option>
                            </select>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input class="layui-input"  autocomplete="off" placeholder="年级" name="userCollege" >
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="userClass"  placeholder="班级"  class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  type="submit" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">

                    <button class="layui-btn" onclick="xadmin.open('添加用户','${pageContext.request.contextPath}/adminEnter/toPageAddUser.do',600,400)"><i class="layui-icon"></i>添加</button>
                </div>
                <div class="layui-card-body ">
                    <table class="layui-table layui-form">
                        <thead>
                        <tr>
                            <th>
                                <input type="checkbox" name=""  lay-skin="primary">
                            </th>
                            <th>ID</th>
                            <th>学号</th>
                            <th>系别</th>
                            <th>年级</th>
                            <th>班级</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>电话</th>
                            <th>操作</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${mapList.list}" var="x">
                        <tr>
                            <td>
                                <input type="checkbox" name=""  lay-skin="primary">
                            </td>
                            <td>${x.userId}</td>
                            <td>${x.userSno}</td>
                            <td>${x.userDep}</td>
                            <td>${x.userCollege}</td>
                            <td>${x.userClass}</td>
                            <td>${x.userName}</td>
                            <td>${x.userSex}</td>
                            <td>${x.userTel}</td>
                            <td class="td-manage">
                                <a title="编辑"  onclick="xadmin.open('编辑','${pageContext.request.contextPath}/adminEnter/updataToPage.do?userId=${x.userId}')" href="javascript:;">
                                    <i class="layui-icon">&#xe642;</i>
                                </a>
                                <a title="删除" onclick="member_del(this,'${x.userId}')" href="javascript:;">
                                    <i class="layui-icon">&#xe640;</i>
                                </a>
                                <a onclick="xadmin.open('分配角色','${pageContext.request.contextPath}/adminEnter/distributionRole.do?userId=${x.userId}',300,350)" href="javascript:;">分配角色
                                </a>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="layui-card-body ">
                    <div class="page">
                        <div>
                            <div>
                                <a class="prev" href="${pageContext.request.contextPath}/adminEnter/dataToShowUser.do?page=${mapList.firstPage}&userDep=${user.userDep}&userClass=${user.userClass}&userCollege=${user.userCollege}">首页</a>
                                <a class="num" href="${pageContext.request.contextPath}/adminEnter/dataToShowUser.do?page=${mapList.prePage}&userDep=${user.userDep}&userClass=${user.userClass}&userCollege=${user.userCollege}">&lt;&lt;</a>
                                <span class="current"  href="${pageContext.request.contextPath}/adminEnter/dataToShowUser.do?page=${mapList.currentPage}&userDep=${user.userDep}&userClass=${user.userClass}&userCollege=${user.userCollege}">${mapList.currentPage}</span>
                                <a class="num" href="${pageContext.request.contextPath}/adminEnter/dataToShowUser.do?page=${mapList.nextPage}&userDep=${user.userDep}&userClass=${user.userClass}&userCollege=${user.userCollege}">&gt;&gt;</a>
                                <a class="next" href="${pageContext.request.contextPath}/adminEnter/dataToShowUser.do?page=${mapList.lastPage}&userDep=${user.userDep}&userClass=${user.userClass}&userCollege=${user.userCollege}">尾页</a>
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

    /*用户-删除*/
    function member_del(obj,id){

        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $.ajax({
                url:"${pageContext.request.contextPath}/adminEnter/del.do",
                type:"post",
                data:{"id":id},
                success:function (data) {
                }

            })
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }

</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</html>
