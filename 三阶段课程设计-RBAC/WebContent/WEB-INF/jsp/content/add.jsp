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
		<title>内容后台管理</title>
		<script type="text/javascript" src="resource/admin/js/jquery.js"></script>
		<script type="text/javascript" charset="utf-8" src="resource/ueditor/ueditor.config.js"></script>
        <script type="text/javascript" charset="utf-8" src="resource/ueditor/ueditor.all.js"></script>
        <script type="text/javascript" charset="utf-8" src="resource/ueditor/lang/zh-cn/zh-cn.js"></script>
	</head>
	<body>
		<h2>发布内容</h2>
		<form action="sys/content/add" method="post" id="contentForm" enctype="multipart/form-data">
		  标题:<input type="text" id="title" name="title" placeholder="请输入标题" maxlength="30"><br/>
		  作者:<input type="text" id="author" name="author" placeholder="请输入作者" maxlength="10"><br/>
		  图片:<input type="file" name="myfile" id="myfile"><br/>
		  <textarea rows="" cols="" name="remark" id="remark" maxlength="128" style="width: 800px;height: 100px;" placeholder="请输入摘要"></textarea><br/>
		  <script id="content" name="content" type="text/plain" style="width:900px;height:400px;"></script><br/>
		  
		  
		  <!-- 隐藏域 -->
		  <input type="hidden" name="type_id" value="${requestScope.type }">
		  <button type="button" id="content-add" style="width: 150px;height: 40px;">发布内容</button>
		</form>
		
		<script type="text/javascript">
		
		    //实例化编辑器
		    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		    var ue = UE.getEditor('content',{
		        toolbars: [
		            [
		                 'bold', //加粗
		                 'italic', //斜体
		                 'underline', //下划线
		                 'strikethrough', //删除线
		                 'pasteplain', //纯文本粘贴模式
		                 'horizontal', //分隔线
		                 'removeformat', //清除格式
		                 'inserttitle', //插入标题
		                 'cleardoc', //清空文档
		                 'insertcode', //代码语言
		                 'fontfamily', //字体
		                 'fontsize', //字号
		                 'paragraph', //段落格式
		                 'spechars', //特殊字符
		                 'forecolor', //字体颜色
		                 'backcolor', //背景色
		                 'insertorderedlist', //有序列表
		                 'insertunorderedlist', //无序列表
		                 'imagenone', //默认
		                 'imageleft', //左浮动
		                 'imageright', //右浮动
		                 'imagecenter', //居中
		                 'link', //超链接
		                 'emotion', //表情
		                 'simpleupload', //单图上传
		            ]
		        ]
		    });
		    
		    $("#content-add").click(function(){
		    	var title = $.trim($("#title").val());
		    	var author = $.trim($("#author").val());
		    	var remark = $.trim($("#remark").val());
		    	if(title===""){
		    		alert("请输入内容");
		    		$("#title").focus();
		    		return false;
		    	}
		    	if(author===""){
                    alert("请输入作者");
                    $("#author").focus();
                    return false;
                }
		    	if(remark===""){
		    		alert("请输入摘要");
                    $("#remark").focus();
                    return false;
                } 
		    	//获取文件内容,HTML5
		    	var myfile = $("#myfile").prop("files")[0]
		    	if(myfile){
		    		var allowType = ["jpg","gif","png","bmp"];
		    		var fileName = myfile.name;
		    		var ext = fileName.substring(fileName.lastIndexOf(".")+1);
		    		var flag = false;
		    		for(var i=0;i<allowType.length;i++){
		    			if(ext==allowType[i]){
		    				flag = true;
		    				break;
		    			}
		    		}
		    		if(!flag){
		    			alert("请输入要求的图片格式, 后缀名为:"+allowType.join(" | "));
		    			return false;
		    		}
		    	}else{
		    		alert("请选择图片");
		    		return false;
		    	}
		    	
		    	if(!ue.hasContents()){
		    		alert("输入文章的内容");
		    		return false;
		    	}
		    	
		    	
		        $("#contentForm").submit();	    	
		    	
		    	
		    });
		
		
		</script>
	</body>
</html>