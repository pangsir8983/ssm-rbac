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
		<title>菜单资源管理</title>
        <!-- Bootstrap -->
        <link href="resource/admin/plugin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="resource/admin/plugin/jstree/themes/proton/style.css" />
    </head>


    <body>

        <ol class="breadcrumb">
            <span>位置：</span>
            <li><a href="javascript:void(0);">首页</a></li>
            <li class="active">菜单管理</li>

        </ol>
        <div class="row">
            <div class="col-md-11">
                <a href="sys/menu/add?type=parent" target="menusIframe" permission-data="CREATE_PARENT" class="btn btn-primary">新增父节点</a>
                <a href="sys/menu/add?type=child" target="menusIframe" permission-data="CREATE_CHILD" class="btn btn-warning">新建子节点</a>
                <a href="javascript:void(0)" id="refresh" class="btn btn-default">刷新</a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3" >
                <div id="jstree-proton-1" style="margin-top:20px;" class="proton-demo">
                    <ul>
                        <li id="-1" node-type="root" class="jstree-open">菜单资源管理
                            <ul>
                                <c:forEach items="${requestScope.treeNodeList }" var="parent">
                                <li id="${parent.menu_id }" node-type="parent" class="jstree-open">${parent.menu_name }
                                    <ul>
                                        <c:forEach items="${parent.childMenuList }" var="child">
                                            <li id="${child.menu_id }" node-type="child">${child.menu_name }</li>
                                        </c:forEach>
                                    </ul>
                                </li>
                                </c:forEach>
                            </ul>
                        </li>
                     
                    </ul>
                </div>
            </div>
            <div class="col-md-8">
                <iframe name="menusIframe" id="menusIframe" frameborder="0" style="height: 500px;width: 750px;"></iframe>
            </div>
        </div>
        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script type="text/javascript" src="resource/admin/plugin/bootstrap/js/bootstrap.js"></script>
        <script type="text/javascript" src="resource/admin/plugin/jstree/jstree.js"></script>
        <script type="text/javascript">
            $(function () {
                $('#jstree-proton-1').jstree({
                    'core': {
                        'themes': {
                            'name': 'proton',
                            'responsive': true
                        },
                        "multiple" : false,
                        "animation" : 0
                    }
                });
                $('#jstree-proton-1').bind("activate_node.jstree", function (obj, e) {
                    // 处理代码
                    // 获取当前节点
                    var currentNode = e.node;
                    if(currentNode.li_attr.id!=-1){
                        var url = "sys/menu/show?id="+currentNode.li_attr.id+"&type="+currentNode.li_attr["node-type"];
                        $("#menusIframe").attr("src",url);
                    }

                    //console.log(currentNode)
                    //console.log(currentNode.li_attr.id)
                    //console.log(currentNode.li_attr["node-type"])
                });

                $("#refresh").click(function () {
                    window.location.href=window.location.href;
                })
            });
        </script>
        
         <!-- 权限控制 -->
        <script type="text/javascript" src="resource/rbac/permissions.js"></script>
        <script type="text/javascript">
        permission_js.init('${sessionScope.role_menu_functions}');
        </script>
    </body>

</html>