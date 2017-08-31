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
        <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
        <title>手机微站</title>
        <!-- 用户显示选项卡中的小图标 -->
        <link href="resource/web/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
        <!-- 引入的CSS -->
        <link type="text/css" rel="stylesheet" href="resource/web/css/flexslider.css" />
        <link type="text/css" rel="stylesheet" href="resource/web/css/jquery.mmenu.all.css" />
        <link type="text/css" rel="stylesheet" href="resource/web/css/style.css" />
        <!-- 引入JS库的支持 -->
        <script type="text/javascript" src="resource/web/js/jquery.min.js"></script>
        <script type="text/javascript" src="resource/web/js/jquery.mmenu.min.all.js"></script>
        <script type="text/javascript" src="resource/web/js/jquery.flexslider.js"></script>
        <script type="text/javascript" src="resource/web/js/o-script.js"></script>
        
    </head>
    <body class="o-page">
        <div id="page">
            <!-- 头部信息 -->
            <div id="header">
                <a href="javascript:void(0)" onclick="javascript:alert('敬请期待,后续功能')"></a>
                <span id="Logo" class="svg">
                    <!-- 这里使用svg,但是我们如果在图片大小合适的情况也修改为图片 -->
                    <img src="img/logo.svg" />
                </span>
                <!-- 回退按钮  -->
                <a class="backBtn" href="javascript:history.back();"></a>
            </div>
            <!-- 提示信息 也可以是欢迎语言 根据情况可以自行改变  -->
            <div class="subHeader"><i class="i-home i-small"></i>欢迎大家 访问胖先生网站!</div>
            
            <!-- Banner  -->
            <!-- 导航图片,该位置可以根据后台读取数据,可以绑定事件后,跳转到对应的页面上 -->
            <div class="bannerPane">
              <section class="slider">
                <div class="flexslider">
                  <ul class="slides">
                    <c:forEach items="${bannerList }" var="banner">
	                    <li>
	                       <a href="front/${banner.cms_id }"> <img src="attr/content/${banner.photo }" /></a>
	                    </li>
                    </c:forEach>
                    
                   
                  </ul>
                </div>
              </section>
            </div>
            <!-- End Banner -->

            <!-- 分割线 -->
            <div class="block">
                做培训,我们是认真的
            </div>
            <!-- 功能区 -->
            <div class="exploreSiteFullPane">
                
                <a href="front/index" class="explorePane active">
                    <span class="i-pane i-blue">
                        <i class="i-home"></i>
                    </span>
                    <h4>首页</h4>
                </a>
                <a href="front/type/1" class="explorePane middle">
                    <span class="i-pane i-blue">
                        <i class="i-about"></i>
                    </span>
                    <h4>名师团队</h4>
                </a>
                <a href="front/type/2" class="explorePane">
                    <span class="i-pane i-blue">
                        <i class="i-blog"></i>
                    </span>
                    <h4>培训课程</h4>
                </a>
                <a href="front/type/3" class="explorePane">
                    <span class="i-pane i-blue">
                        <i class="i-gallery"></i>
                    </span>
                    <h4>学员风采</h4>
                </a>
                <a href="front/type/4" class="explorePane middle">
                    <span class="i-pane i-blue">
                        <i class="i-shortcodes"></i>
                    </span>
                    <h4>开班计划</h4>
                </a>
                <a href="front/type/5" class="explorePane">
                    <span class="i-pane i-blue">
                        <i class="i-contact"></i>
                    </span>
                    <h4>报名流程</h4>
                </a>

            </div>
            
            <!-- Social Icons -->
            <!-- 主要用于分享使用,可以必应一下,使用插件进行完完成 -->
            <div class="socialMedia scl-grey">
                <a href="#" class="ico-facebook" title="facebook">facebook</a>
                <a href="#" class="ico-twitter" title="twittertwitter">twitter</a>
                <a href="#" class="ico-linkedin" title="linkedin">linkedin</a>
                <a href="#" class="ico-gplus" title="gplus">gplus</a>
                <a href="#" class="ico-youtube" title="youtube">youtube</a>
                <a href="#" class="ico-tumblr" title="tumblr">tumblr</a>
                <a href="#" class="ico-pinterest" title="pinterest">pinterest</a>
            </div>
            <div class="subFooter">Copyright 2016. All rights reserved &reg;胖先生.</div>

        </div>

    </body>
</html>