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
		<title>菜单资源管理  |  修改删除</title>
        <!-- Bootstrap -->
        <link href="resource/admin/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    </head>


    <body>

            <div class="col-xs-10">
                <form class="form-horizontal" id="menuForm" method="post">
                    <c:if test="${requestScope.type eq 'child' }">
                    <div class="form-group">
                        <label for="parent_id" class="col-xs-2 control-label">节点列表</label>
                        <div class="col-xs-8">
                            <select class="form-control" id="parent_id" name="parent_id">
                                <option value="">请选择父节点菜单</option>
                                <c:forEach items="${requestScope.parentNodeList }" var="parent">
                                    <option value="${parent.menu_id }"
                                    <c:if test="${menu.parent_id==parent.menu_id }">selected='selected'</c:if>
                                    >${parent.menu_name }</option>
                                    
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    </c:if>
                    <div class="form-group">
                        <label for="menu_name" class="col-xs-2 control-label">菜单名称</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="menu_name" name="menu_name" placeholder="请输入菜单名称"
                            value="${menu.menu_name }"
                            >
                        </div>
                    </div>
                    <c:if test="${requestScope.type eq 'child' }">
                    <div class="form-group">
                        <label for="url" class="col-xs-2 control-label">访问URL</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="url" name="url" placeholder="请设置访问路径"
                            value="${menu.url }"
                            >
                        </div>
                    </div>
                    </c:if>
                    <div class="form-group">
                        <label for="sort" class="col-xs-2 control-label">设置排序</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="sort" name="sort" placeholder="设置排序"
                            value="${menu.sort }"
                            >
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10">
                            <button type="button" id="menu-update" class="btn btn-primary">确认更新</button>
                            <button type="button" id="menu-delete" class="btn btn-danger">彻底删除</button>
                        </div>
                    </div>
                    <!-- 隐藏域 -->
                    <input type="hidden" id="menu_id" name="menu_id" value="${menu.menu_id }">
                    <input type="hidden" id="old_menu_name" value="${menu.menu_name }">
                    <input type="hidden" id="old_parent_id" value="${menu.parent_id }">
                    <input type="hidden" name="_method" value="put">
                </form>
            </div>

        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <!-- 需要支持 -->
        <script src="resource/admin/plugin/layer/layer.js" type="text/javascript"></script>
        <script type="text/javascript" src="resource/admin/plugin/bootstrap/js/bootstrap.js"></script>
        <script type="text/javascript">
            $(function () {
            	//EL表达式可以在JavaScript当中直接使用
                var type='${requestScope.type}';
                $("#menu-update").click(function(){
                	//如果是子节点需要验证
                	var parent_id;//undefined
                    if(type==="child"){
                        parent_id = $("#parent_id").val();
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
                    $("#menuForm").attr("action","sys/menu/update");//给表单设置action的值
                    $("#menuForm").submit();
                });
                
                $("#menu-delete").click(function(){
                	var menu_id = $("#menu_id").val();
                	
                	 top.layer.confirm('你确定要删除该节点吗?', {icon: 2, title:'菜单资源管理 | 提示信息'}, function(index){
                		 $.post("sys/menu/delete",{type:type,menu_id:menu_id,_method:"delete"},function(data){
                             if(data.flag=="success"){
                                 alert(data.message);
                                 window.parent.location.reload();
                                 return false;
                             }else{
                                 alert(data.message);
                                 return false;
                             }
                         },"json")
                         top.layer.close(index);
                     });
                	
                	
                	
                })
            });
        </script>
    </body>

</html>