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
		<title>角色管理</title>
        <link href="resource/admin/css/style.css" rel="stylesheet" type="text/css" />
    </head>


    <body>

        <div class="place">
            <span>位置：</span>
            <ul class="placeul">
                <li><a href="javascript:;">首页</a></li>
                <li><a href="javascript:;">角色管理</a></li>
            </ul>
        </div>

        <div class="rightinfo">
            <form action="sys/role/list" method="post" id="searchForm">
                <ul class="seachform1" style="width: 1000px;">
                    <li><label>角色名称</label><input name="role_name" id="role_name" type="text" class="scinput1" /></li>
                    <li>
                        <label>角色状态</label>
                        <div class="vocation">
                            <select name="status" id="status" class="select_show" style="height: 34px;">
                                <option value="">全部</option>
                                <option value="1">可用</option>
                                <option value="-1">禁用</option>
                            </select>
                        </div>
                    </li>
                    <li>
                        <input type="button" class="scbtn"  style="height: 34px;" value="查询"/>
                    </li>
                </ul>
            </form>
            <div class="tools">

                <ul class="toolbar">
                    <li class="click role-add"><span><img src="resource/admin/images/t01.png" /></span>添加</li>
                    <li class="click role-update"><span><img src="resource/admin/images/t02.png" /></span>修改</li>
                    <li class="click role-delete"><span><img src="resource/admin/images/t03.png" /></span>删除</li>
                    <li class="click role-menu"><span><img src="resource/admin/images/t05.png" /></span>授权</li>
                </ul>

            </div>



            <table class="tablelist">
                <thead>
                    <tr>
                        <th width="50px;">序号</th>
                        <th width="100px;">角色名称</th>
                        <th width="100px;">角色标识</th>
                        <th width="100px;">角色状态</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${requestScope.roleList }" var="role" varStatus="vs">
	                    <tr>
	                        <td>
	                            <input type="radio" name="role_id" value="${role.role_id }">
	                        </td>
	                        <td>${role.role_name }</td>
	                        <td>${role.role_key }</td>
	                        <td>
	                           <c:if test="${role.status==1 }" var="flag">
	                               <span style="color: green;font-weight: bold;">可用</span>
	                           </c:if>
	                           <c:if test="${!flag }">
	                               <span style="color: red;font-weight: bold;">禁用</span>
	                           </c:if>
	                            
	                        </td>
	                    </tr>
                    </c:forEach>
                    
                    
                </tbody>

            </table>


        </div>

        <script type="text/javascript" src="resource/admin/js/jquery.js"></script>
        <script src="resource/admin/plugin/layer/layer.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function () {
                /**绑定tr的单击事件,雪中单选框按钮*/
                $("tbody tr").click(function () {
                   $(this).find("input[type='radio']").prop("checked",true);
                });



                /**通过ID选择器绑定事件*/
                $(".role-add").on("click",function () {
                    parent.layer.open({
                        title:"角色管理 | 新增角色",
                        type: 2,
                        area: ['550px', '350px'],
                        fixed: false,
                        content: 'sys/role/add'
                    });
                });
                /**通过class选择器绑定事件*/
                $(".role-update").click(function () {
                    //获取role_id
                    var role_id = $("tbody input[type='radio']:checked").val();
                    if(!role_id){
                        parent.layer.alert('请选择要更新的角色信息!', {icon: 3});
                        return false;
                    }

                    parent.layer.open({
                        title:"角色管理 | 更新角色",
                        type: 2,
                        area: ['750px', '500px'],
                        fixed: false,
                        content: 'system-role-update.html?role_id='+role_id
                    });
                });

                /**通过class选择器绑定事件*/
                $(".role-delete").click(function () {
                    //获取role_id
                    var role_id = $("tbody input[type='radio']:checked").val();
                    if(!role_id){
                        parent.layer.alert('请选择要删除的角色信息!', {icon: 3});
                        return false;
                    }
                    parent.layer.confirm('你确定要执行改操作吗?', {icon: 2, title:'角色管理 | 提示信息'}, function(index){
                        window.location.href="sys/role/delete?role_id="+role_id;
                        parent.layer.close(index);
                    });
                });

                $(".role-menu").click(function () {
                    //获取自定属性值
                    var user_id = $(this).attr("data-id");
                    parent.layer.open({
                        title:"角色管理 | 授权菜单",
                        type: 2,
                        area: ['600px', '350px'],
                        fixed: false,
                        content: 'system-role-menu.html?user_id='+user_id
                    });
                });

            })

        </script>
    </body>

</html>