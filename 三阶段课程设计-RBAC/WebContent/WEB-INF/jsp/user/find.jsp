<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%
	//项目的发布路径，例如:  /rabc
	String path = request.getContextPath();
	/*
	全路径，形式如下: http://127.0.0.1:8001/rbac/
	request.getScheme()      ——> http 获取协议
	request.getServerName()  --> 127.0.0.1 获取服务名
	request.getServerPort()  --> 8001 获取端口号
	path                     --> /rbac 获取访问的路径 路
	*/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- 
	<base/>标签解决路径问题
	参考文章:http://www.cnblogs.com/muqianying/archive/2012/03/16/2400280.html
--%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<link href="resource/admin/css/style.css" rel="stylesheet" type="text/css" />
    </head>


    <body>

        <div class="place">
            <span>位置：</span>
            <ul class="placeul">
                <li><a href="javascript:;">首页</a></li>
                <li><a href="javascript:;">系统用户管理</a></li>
            </ul>
        </div>

        <div class="rightinfo">
            <form action="sys/user/find" method="get" id="searchForm">
            <ul class="seachform1" style="width: 1000px;">
                <!-- map传递数据 -->
                <li><label>姓名</label><input name="query['user_name']" type="text" class="scinput1" value="${pager.query.user_name }"/></li>
                <li>
                    <label>状态</label>
                    <div class="vocation">
                        <select name="query['status']" class="select_show" style="height: 34px;">
                            <option value="">请选择用户状态</option>
                            <option value="1"
                                <c:if test="${pager.query.status==1 }">selected='selected'</c:if>
                            >可用</option>
                            <option value="2"
                                <c:if test="${pager.query.status==2 }">selected='selected'</c:if>
                            >禁用</option>
                        </select>
                    </div>
                </li>
                <li>
                    <input id="searchBtn" type="button" class="scbtn"  style="height: 34px;" value="查询"/>
                    <input id="user-add" type="button" class="scbtn1" style="height: 34px;"  value="新增系统用户"/>
                </li>
                
            </ul>
                <!-- 隐藏域传递数据 -->
                <input type="hidden" name="pageNow" id="pageNow" value="${pager.pageNow }">
                <input type="hidden" id="totalPages" value="${pager.totalPages }">
            </form>



            <table class="tablelist">
                <thead>
                <tr>
                    <th width="50px;">序号</th>
                    <th width="100px;">账号</th>
                    <th width="100px;">姓名</th>
                    <th width="200px;">登录IP</th>
                    <th width="200px;">登录日期</th>
                    <th width="80px;">状态</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                    <c:forEach items="${requestScope.pager.datas }" var="user" varStatus="st">
                    <tr>
                        <td>${(pager.pageNow-1)*pageSize+st.count }</td>
                        <td>${user.account }</td>
                        <td>${user.user_name }</td>
                        <td>${user.ip }</td>
                        <td><fmt:formatDate value="${user.login_time }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <span style="color: green;font-weight: bold;">可用</span>
                        </td>
                        <td>
                            <a href="javascript:;" data-id="1" class="tablelink user-update">更新</a>
                            &nbsp;|&nbsp;
                            <a href="javascript:;" data-id="1" class="tablelink user-delete">删除</a>
                            &nbsp;|&nbsp;
                            <a href="javascript:;" data-id="1" class="tablelink user-upload">上传</a>
                            &nbsp;|&nbsp;
                            <a href="javascript:;" data-id="1" class="tablelink user-update-role">分配角色</a>
                        </td>

                    </tr>
                    </c:forEach>
                </tbody>

            </table>



            <!-- 分页 开始 -->
            <div class="pagin">
                <div class="message">共<i class="blue">${pager.totalCount }</i>条记录，当前显示第&nbsp;<i class="blue">${pager.pageNow }&nbsp;/&nbsp;${pager.totalPages }</i>页</div>
                <ul class="paginList">
                    <li class="paginItem"><a href="javascript:;" id="start">首页</a></li>
                    <li class="paginItem"><a href="javascript:;" id="pre">上一页</a></li>
                    <li class="paginItem"><a href="javascript:;" id="next">下一页</a></li>
                    <li class="paginItem"><a href="javascript:;" id="end">尾页</a></li>
                </ul>
            </div>
            <!-- 分页 结束 -->
        </div>

        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script src="resource/admin/plugin/layer/layer.js" type="text/javascript"></script>
        <!-- 引入分页 -->
        <script type="text/javascript" src="resource/rbac/pager.js"></script>
        
        <script type="text/javascript">
            $(function () {
                /**通过ID选择器绑定事件*/
                $("#user-add").on("click",function () {
                    parent.layer.open({
                        title:"系统用户管理 | 新建用户",
                        type: 2,
                        area: ['750px', '500px'],
                        fixed: false,
                        content: 'system-user-add.html'
                    });
                });
                /**通过class选择器绑定事件*/
                $(".user-update").click(function () {
                    //获取自定属性值
                    var user_id = $(this).attr("data-id");//this是JS对象,知识点JS对象转Jquery对象
                    parent.layer.open({
                        title:"系统用户管理 | 更新用户",
                        type: 2,
                        area: ['750px', '500px'],
                        fixed: false,
                        content: 'system-user-update.html?user_id='+user_id
                    });
                });

                /**通过class选择器绑定事件*/
                $(".user-delete").click(function () {
                    //获取自定属性值
                    var user_id = $(this).attr("data-id");//this是JS对象,知识点JS对象转Jquery对象
                    var _self = this;
                    parent.layer.confirm('你确定要执行改操作吗?', {icon: 2, title:'用户管理 | 提示信息'}, function(index){
                        //可以使用Ajax完成上传操作

                        //jquery操作DOM节点异常元素
                        $(_self).parent().parent().fadeOut(function () {
                           $(this).remove();
                        })

                        parent.layer.close(index);
                    });
                });

                $(".user-update-role").click(function () {
                    //获取自定属性值
                    var user_id = $(this).attr("data-id");
                    parent.layer.open({
                        title:"系统用户管理 | 设置角色",
                        type: 2,
                        area: ['700px', '450px'],
                        fixed: false,
                        content: 'system-user-role.html?user_id='+user_id
                    });
                });
                $(".user-upload").click(function () {
                    //获取自定属性值
                    var user_id = $(this).attr("data-id");
                    parent.layer.open({
                        title:"系统用户管理 | 设置头像",
                        type: 2,
                        area: ['400px', '250px'],
                        fixed: false,
                        content: 'system-user-upload.html?user_id='+user_id
                    });
                });
            })

        </script>
    </body>

</html>