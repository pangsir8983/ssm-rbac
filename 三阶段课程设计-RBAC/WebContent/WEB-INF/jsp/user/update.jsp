<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
		<title>系统用户管理 | 更新用户</title>
        <link href="resource/admin/css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body style="min-width: 700px;">
        <form action="sys/user/update" method="post" id="user-form">
            <div class="formbody">
                <ul class="forminfo">
                    <li>
                        <label>账号</label>
                        <input id="account" type="text" class="dfinput" value="${user.account }" readonly="readonly"/>
                    </li>
                    <li>
                        <label>姓名</label>
                        <input name="user_name" id="user_name" type="text" class="dfinput" placeholder="请输入姓名"
                            value="${user.user_name }"
                        />
                    </li>
                    <li>
                        <label>账号状态</label>
                        <select id="status" name="status" class="select_show">
                            <option value="1"
                            <c:if test="${user.status==1 }">selected='selected'</c:if>
                            >激活</option>
                            <option value="2"
                            <c:if test="${user.status==2 }">selected='selected'</c:if>
                            >禁用</option>
                        </select>
                    </li>
                    <li>
                        <label>&nbsp;</label><input id="user-update-btn" type="button" class="btn" value="确认更新"/>
                    </li>
                </ul>
            </div>
            
            <!-- 隐藏域 -->
            <input type="hidden" name="user_id" value="${user.user_id }">
            <input type="hidden" name="_method" value="put">
            
        </form>
        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script type="text/javascript">
            $(function () {
                /**用户添加按钮绑定事件*/
                $("#user-update-btn").on("click",function () {
                	//前端的验证插件 jquery-validation.js
                	var user_name = $.trim($("#user_name").val());
                	if(user_name===""){
                        alert("请输入姓名信息");
                        $("#user_name").focus();
                        return false;
                    }
                	$("#user-form").submit();
                	
                	
                    
                })
            })
        </script>
    </body>

</html>