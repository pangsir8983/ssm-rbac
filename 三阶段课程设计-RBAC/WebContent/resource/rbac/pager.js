$(function(){
	var pageNow = parseInt($("#pageNow").val());
	var totalPages = parseInt($("#totalPages").val());
	
    $("#start").click(function(){
        $("#pageNow").val(1);
        $("#searchForm").submit();
    });
     $("#pre").click(function(){
        if(pageNow==1){
            alert("没有上一页了!");
            return false;
        }
        $("#pageNow").val(pageNow-1);
        $("#searchForm").submit();
    });
    
     $("#next").click(function(){
        if(pageNow==totalPages){
            alert("没有下一页了!");
            return false;
        }
        $("#pageNow").val(pageNow+1);
        $("#searchForm").submit();
    });
    
    
     $("#end").click(function(){
        $("#pageNow").val(totalPages);
        $("#searchForm").submit();
     });
     
     $("#searchBtn").click(function(){
       $("#pageNow").val(1);
       $("#searchForm").submit();
     })
});