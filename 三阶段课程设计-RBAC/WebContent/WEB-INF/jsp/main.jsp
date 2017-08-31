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
		<title>后台主界面</title>
    <!-- 后台框架页面样式 -->
    <link rel="stylesheet" href="resource/admin/css/home.css" type="text/css"/>
    <!-- 引入字体图表 -->
    <link href="resource/admin/Font-Awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>



</head>
<div class="backAdmin">
    <div class="top">
        <!-- LOGO 内容应该可以改变  -->
        <div class="topleft">
            <a href="sys/content" target="rightFrame">
                <h1 style="height: 71px;width: 271px;font-size: 30px;color: honeydew;margin-top: 15px;margin-left: 40px;">
                    胖先森后台管理系统
                </h1>
            </a>
        </div>

        <div class="topright">
            <ul>
                <li>
                    <span>
                        <img src="resource/admin/images/help.png" title="设置口令" class="helpimg"/>
                    </span>

                    <a href="javascript:void(0)" id="password-update">设置口令</a>
                </li>
                <li><a href="javascript:void(0)">关于</a></li>
                <li><a href="javascript:void(0)" id="logout">安全退出</a></li>
            </ul>

            <div class="user">
                <!-- 设置头像 -->
                <img
                    src="attr/user/${sessionScope.session_user.photo }"
                  onerror="resource/admin/images/hanpang.png" alt="用户头像"/>
                <span>${sessionScope.session_user.account }</span>
                <!-- <b>5</b> -->
            </div>

        </div>
    </div>

    <div class="left">
        <div class="lefttop">
            <i class="icon-cloud icon-large pull-left icon-border"></i>
            <span>信息导航</span>
        </div>

        <dl class="leftmenu">
            <c:forEach items="${requestScope.parentMenus }" var="parent">
            <dd>
                <div class="title">
                    <i class="icon-gears icon-large pull-left icon-border"></i>
                    <span>${parent.menu_name }</span>
                </div>
                <ul class="menuson">
                    <c:forEach items="${requestScope.childMenus }" var="child">
                        <c:if test="${child.parent_id eq parent.menu_id }">
                            <li>
		                        <i class="icon-user"></i>
		                        <a href="${child.url }?pid=${child.menu_id }&rid=${sessionScope.session_user.fk_role_id}" data-id="${child.menu_id }" target="rightFrame">${child.menu_name}</a>
		                    </li>
                        </c:if>
                    
                     </c:forEach>
                </ul>
            </dd>
            </c:forEach>
        </dl>


    </div>
    <div class="right">
        <div class="inner">
            <!-- 设置iframe -->
            <iframe id="rightFrame" name="rightFrame" class="mainIframe" scrolling="no" frameborder="0" src="sys/content"
                    onload="initIframe()"></iframe>
        </div>
    </div>
    <div class="bottom">
        <span>码迷码迷吽, 仅供学习交流，请勿用于任何商业用途</span>
        <i> 版权所有 @ 2017 <a href="http://www.jianshu.com/u/f89cad0c1a52">胖先森简书</a> </i>
    </div>
</div>
<!-- Jquery支持 -->
<script type="text/javascript" src="resource/admin/js/jquery.js"></script>
<script src="resource/admin/plugin/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript" src="resource/admin/js/home.js"></script>
<script type="text/javascript" src="resource/rbac/main.js"></script>
<script type="text/javascript">
$(function(){
	$("#password-update").click(function(){
		 layer.open({
             title:"重新设置密码口令",
             type: 2,
             area: ['750px', '350px'],
             fixed: false,
             content: 'sys/user/password'
         });
	});
});

</script>

</body>
</html>
</html>