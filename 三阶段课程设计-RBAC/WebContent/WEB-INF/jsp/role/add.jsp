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
		<title>系统角色管理 | 新增角色</title>
        <link href="resource/admin/css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body style="min-width: 700px;">
        <form action="sys/role/add" method="post" id="role-form">
            <div class="formbody">
                <ul class="forminfo">
                    <li>
                        <label>角色名称</label>
                        <input name="role_name" id="role_name" type="text" class="dfinput" placeholder="请输入角色名称"/>
                    </li>
                    <li>
                        <label>角色标识</label>
                        <input name="role_key" id="role_key" type="text" class="dfinput" placeholder="请输入唯一的角色标识值"/>
                    </li>
                    <li>
                        <label>角色状态</label>
                        <select id="status" name="status" class="select_show">
                            <option value="1">激活</option>
                            <option value="2">禁用</option>
                        </select>
                    </li>
                    <li>
                        <label>&nbsp;</label><input id="role-add-btn" type="button" class="btn" value="确认保存"/>
                    </li>
                </ul>
            </div>
        </form>
        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script type="text/javascript">
            $(function () {
                /**用户添加按钮绑定事件*/
                $("#role-add-btn").on("click",function () {
                	var role_name = $.trim($("#role_name").val());
                	var role_key = $.trim($("#role_key").val());
                	if(role_name===""){
                		alert("角色名称不能为空");
                		return false;
                	}
                	if(role_key===""){
                        alert("角色标识不能为空");
                        return false;
                    }
                    //通过Ajax完成验证
                    $.get("sys/role/validKey",{key:role_key},function(data){
                        //JSON格式的字符串转换为JavaScript对象
                        //data = JSON.parse(data);
                        if(data.flag == "success"){
                        	$("#role-form").submit();
                        	return false;
                        }else{
                        	alert(data.message);
                        	return false;
                        }
                        
                    },"json");
                	
                   // $("#role-form").submit();
                })
            })
        </script>
    </body>

</html>