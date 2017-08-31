<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
		<title>无标题文档</title>
<link href="resource/admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="resource/admin/js/jquery.js"></script>
<script type="text/javascript" src="resource/fusioncharts/fusioncharts.js"></script><!--引入主类库-->
<script type="text/javascript">
$(function(){
	var chartObj = {
		chart:{
			yaxisname:"次数",
			caption:"栏目文章点击次数统计",
			numbersuffix:"次",
			useroundedges:"1",
			bgcolor:"FFFFFF,FFFFFF",
			showborder:0
		}
	};
	
	$.get("sys/content/chart",function(data){
		var chart = new FusionCharts("Column2D.swf", "ChartId", "550", "240", "0", "0");
	    //创建一个FusionCharts对象，第一个参数为swf文件的路径，第二个为id用来标识这个对象，第三个为宽度，第四个为高度
	    //赋值
	    chartObj["data"]=data;
	    
	    chart.setJSONData(JSON.stringify(chartObj));
	    //dataMain为div的ID
	    chart.render("dataMain");//将FusionCharts对象填充到指定的div标签处：render（div）
	},"json");

});
</script>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="javascript:;">首页</a></li>
			<li><a href="javascript:;">工作台</a></li>
		</ul>
	</div>


	<div class="mainbox">
    
    <div class="mainleft">
			<div class="leftinfo">
				<div class="listtitle">数据统计</div>

				<div id="dataMain" class="maintj">在这加载图形</div>

			</div>
			<!--leftinfo end-->
    
    <div class="leftinfos">
    
   
    <div class="infoleft">
    
    <div class="listtitle">开班计划</div>    
    <ul class="newlist">
    <c:forEach items="${classContentList }" var="c" >
        <li>
            <a href="sys/content/${c.cms_id }">${c.title }</a>
            <b><fmt:formatDate value="${c.create_date }" pattern="yyyy-MM-dd"/></b>
        </li>
    </c:forEach>
    </ul>   
    
    </div>
    
    
    <div class="inforight">
    <div class="listtitle">培训课程</div>
    <ul class="newlist">
    <c:forEach items="${peixunContentList }" var="px" >
        <li>
            <a href="sys/content/${px.cms_id }">${px.title }</a>
            <b><fmt:formatDate value="${px.create_date }" pattern="yyyy-MM-dd"/></b>
        </li>
    </c:forEach>
    </ul>   
    
    </div>
    
    
    </div>
    
    
    </div>
    <!--mainleft end-->
    
    
    <div class="mainright">
    
    
    <div class="dflist">
    <div class="listtitle">学员风采</div>    
    <ul class="newlist">
    <c:forEach items="${studentContentList }" var="student" >
        <li>
            <a href="sys/content/${student.cms_id }">${student.title }</a>
            <b><fmt:formatDate value="${student.create_date }" pattern="yyyy-MM-dd"/></b>
        </li>
    </c:forEach>
    </ul>   
    </div>
    
    
    <div class="dflist1">
    <div class="listtitle">教室团队</div>    
    <ul class="newlist">
    <c:forEach items="${teacherContentList }" var="teacher" >
        <li>
            <a href="sys/content/${teacher.cms_id }">${teacher.title }</a>
            <b><fmt:formatDate value="${teacher.create_date }" pattern="yyyy-MM-dd"/></b>
        </li>
    </c:forEach>
    </ul>     
    </div>
    
    

    
    
    </div>
    <!--mainright end-->
    
    
    </div>



</body>
<script type="text/javascript">
    setWidth();
    $(window).resize(function(){
        setWidth(); 
    });
    function setWidth(){
        var width = ($('.leftinfos').width()-12)/2;
        $('.infoleft,.inforight').width(width);
    }
</script>
</html>