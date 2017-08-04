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
		<title>菜单资源管理  |  新增</title>
        <!-- Bootstrap -->
        <link href="resource/admin/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    </head>


    <body>

            <div class="col-xs-10">
                <form class="form-horizontal" action="sys/menu/add" method="post" id="menuForm">
                    <c:if test="${type eq 'child' }">
                    <div class="form-group">
                        <label for="parent_id" class="col-xs-2 control-label">节点列表</label>
                        <div class="col-xs-8">
                            <select class="form-control" id="parent_id" name="parent_id">
                                <option value="">请选择父节点菜单</option>
                                <c:forEach items="${requestScope.parentNodeList }" var="parent">
                                    <option value="${parent.menu_id }">${parent.menu_name }</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    </c:if>
                   
                    <div class="form-group">
                        <label for="menu_name" class="col-xs-2 control-label">菜单名称</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="menu_name" name="menu_name" placeholder="请输入菜单名称">
                        </div>
                    </div>
                    <c:if test="${type eq 'child' }">
                    <div class="form-group">
                        <label for="url" class="col-xs-2 control-label">访问URL</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="url" name="url" placeholder="请设置访问路径">
                        </div>
                    </div>
                    </c:if>
                    <div class="form-group">
                        <label for="sort" class="col-xs-2 control-label">设置排序</label>
                        <div class="col-xs-8">
                            <input type="number" min="10" start="10" step="10" class="form-control" id="sort" name="sort" placeholder="设置排序">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <button type="button" id="menu-add" class="btn btn-primary">确认保存</button>
                        </div>
                    </div>
                </form>
            </div>

        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script type="text/javascript" src="resource/admin/plugin/bootstrap/js/bootstrap.js"></script>
        <script type="text/javascript">
            $(function () {
            	//EL表达式可以在JavaScript当中直接使用
            	var type='${requestScope.type}';
            	$("#menu-add").click(function(){
            		//如果是子节点需要验证
            		if(type==="child"){
            			var parent_id = $("#parent_id").val();
            			if(parent_id===""){
            				alert("请选择父节点信息");
            				return false;
            			}
            			var url = $.trim($("#url").val());
            			if(url===""){
            				alert("请设置访问的路径");
                            return false;
            			}
            		}
            		var menu_name = $.trim($("#menu_name").val());
            		if(menu_name===""){
                        alert("菜单名称不能为空");
                        return false;
                    }
            		var sort =$("#sort").val();
            		if(sort===""){
                        alert("请设置排序");
                        return false;
                    }
            		
            		$("#menuForm").submit();
            	});

            });
        </script>
    </body>

</html>