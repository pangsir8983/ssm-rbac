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
		<title>H5模版:</title>
	</head>
	<body>
		<h2>角色授权</h2>
		<c:forEach items="${requestScope.menuList }" var="menu">
		  <h3>${menu.menu_name }</h3>
		  <p>
		   <c:forEach items="${menu.functionList }" var="function">
		      <input type="checkbox" name="func" menu-id="${function.menu_id }" role-id="${role_id }"
		          value="${function.function_key }"
			         <c:forEach items="${menus_and_functions }" var="maf">
	                    <c:if test="${maf.menu_id==function.menu_id and maf.permission==function.function_key }">
	                        checked="checked"
	                    </c:if>
	                  </c:forEach>
		          >
		      ${function.function_name }
		   </c:forEach>
		  </p>
		</c:forEach>
		<button type="button">更新授权</button>
		 <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script src="resource/admin/plugin/layer/layer.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(function(){
			
			$("button").click(function(){
				var p = [];
				$("input[name='func']:checked").each(function(o,index){
					var obj = $(this);
					var data = {
						role_id:obj.attr("role-id"),
						menu_id:obj.attr("menu-id"),
						permission:obj.val()
					};
					p.push(data);
				});
				if(p.length>0){
					var jsonStr = JSON.stringify(p);
					$.ajax({
					  url:"sys/role/permission",
					  type:"POST",
					  data:jsonStr,
					  contentType:"application/json;charset=UTF-8",
					  dataType:"json",
					  processData:false,
					  success:function(data){
						 if(data.flag=="success"){
							 alert("授权成功");
							 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
							 parent.layer.close(index);
						 }else{
							 alert(data.message);
							 return false;
						 }
					  }
					  
					});
				}else{//代表一个功能也没有选择
					//EL表达式获取角色ID
					var role_id='${requestScope.role_id}';
					$.post("sys/role/permission",{role_id:role_id,_method:"delete"},function(data){
						 if(data.flag=="success"){
							 alert("该角色取消了所有的功能");
                             var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                             parent.layer.close(index);
                         }else{
                             alert(data.message);
                             return false;
                         }
					},"json");
					
				}
				
			});
		});
		
		</script>
	</body>
</html>