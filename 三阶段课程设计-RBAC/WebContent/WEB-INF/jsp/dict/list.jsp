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
		<title>字典维护</title>
        <link href="resource/admin/css/style.css" rel="stylesheet" type="text/css" />
    </head>


    <body>

        <div class="place">
            <span>位置：</span>
            <ul class="placeul">
                <li><a href="javascript:;">首页</a></li>
                <li><a href="javascript:;">字典维护</a></li>
            </ul>
        </div>

        <div class="rightinfo">
            <div class="tools">

                <ul class="toolbar">
                    <li class="click dict-add" permission-data="CREATE"><span><img src="resource/admin/images/t01.png" /></span>新建角色</li>
                    <li class="click dict-update" permission-data="UPDATE"><span><img src="resource/admin/images/t02.png" /></span>维护角色</li>
                    <li class="click dict-delete" permission-data="DELETE"><span><img src="resource/admin/images/t03.png" /></span>注销角色</li>
                </ul>

            </div>



            <table class="tablelist">
                <thead>
                    <tr>
                        <th width="50px;">序号</th>
                        <th width="100px;">字典类型</th>
                        <th width="100px;">实际值</th>
                        <th width="100px;">显示值</th>
                        <th width="100px;">排序</th>
                        <th width="100px;">状态</th>
                        <th width="100px;">描述</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${requestScope.dictList }" var="dict" varStatus="vs">
	                    <tr>
	                        <td>
	                            <input type="radio" name="id" value="${dict.id }">
	                        </td>
	                        <td>${dict.type }</td>
	                        <td>${dict.value }</td>
	                        <td>${dict.label }</td>
	                        <td>${dict.sort }</td>
	                        <td>
	                           <c:if test="${dict.del_flag==1 }" var="flag">
	                               <span style="color: green;font-weight: bold;">可用</span>
	                           </c:if>
	                           <c:if test="${!flag }">
	                               <span style="color: red;font-weight: bold;">禁用</span>
	                           </c:if>
	                            
	                        </td>
	                        <td>${dict.remark }</td>
	                    </tr>
                    </c:forEach>
                    
                    
                </tbody>

            </table>


        </div>

        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script src="resource/admin/plugin/layer/layer.js" type="text/javascript"></script>
        <script type="text/javascript" src="resource/rbac/permissions.js"></script>
        <script type="text/javascript">
        permission_js.init('${sessionScope.role_menu_functions}');
        </script>
    </body>

</html>