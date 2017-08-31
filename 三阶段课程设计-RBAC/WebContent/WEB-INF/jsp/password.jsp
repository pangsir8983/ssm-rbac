<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<title>设置密码口令</title>
        <link href="resource/admin/css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body style="min-width: 700px;">
        <form action="sys/user/password" method="post" id="passwordForm">
            <div class="formbody">
                <ul class="forminfo">
                    <li>
                        <label>原密码</label>
                        <input id="old_password" type="password" class="dfinput" placeholder="请输入员密码"/>
                    </li>
                    <li>
                        <label>新密码</label>
                        <input id="password" name="password" type="password" class="dfinput" placeholder="请输新密码"/>
                    </li>
                    <li>
                        <label>确认密码</label>
                        <input id="confirm_password" type="password" class="dfinput" placeholder="再次输入确认密码"/>
                    </li>
            
                    <li>
                        <label>&nbsp;</label><input id="password-update" type="button" class="btn" value="设置密码"/>
                    </li>
                </ul>
            </div>
        </form>
        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#password-update").on("click",function () {
                	var old_password=$.trim($("#old_password").val());
                	var password=$.trim($("#password").val());
                	var confirm_password=$.trim($("#confirm_password").val());
                	
                    $.post("sys/user/password/valid",{old_password:old_password},function(data){

                        if(data.flag == "success"){
                        	
                        	if(password!=confirm_password){
                        		alert("您输入的两次密码不一致,请重新输入");
                        		return false;
                        	}else{
                        		$("#passwordForm").submit();
                        	}
                        	return false;
                        }else{
                        	alert(data.message);
                        	return false;
                        }
                        
                    },"json");
                	
                });
            })
        </script>
    </body>

</html>