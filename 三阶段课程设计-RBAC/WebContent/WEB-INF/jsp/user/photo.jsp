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
		<title>系统用户管理 | 角色分配</title>
        <link href="resource/admin/css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body style="min-width: 700px;">
        <form action="sys/user/photo" method="post" id="user-form" enctype="multipart/form-data">
            <div class="formbody">
                <ul class="forminfo">
                    <li>
                        <label>头像</label>
                        <input type="file" name="myfile" id="myfile">
                    </li>
                    <li>
                        <label>&nbsp;</label><input id="user-photo-btn" type="button" class="btn" value="上传头像"/>
                    </li>
                     <li>
                        <label>&nbsp;</label>
                        <img alt="" src="attr/user/${user.photo }">
                    </li>
                </ul>
            </div>
                <!-- 隐藏域 -->
                <input type="hidden" name="user_id" value="${user.user_id }">
        </form>
        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#user-photo-btn").on("click",function () {
                	var myfile = $("#myfile").prop("files")[0];
                	if(myfile){
                		//需要验证
                		
                		$("#user-form").submit();
                	}else{
                		alert("请选择头像图片");
                		return false;
                	}
                    
                });
            })
        </script>
    </body>

</html>