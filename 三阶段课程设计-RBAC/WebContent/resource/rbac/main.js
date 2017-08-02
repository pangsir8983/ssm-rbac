$(function(){
    $("#logout").on("click",function(){
        layer.confirm('您确定要安全退出该系统吗', {icon: 2, title:'提示信息'}, function(index){
            window.top.location.href="sys/logout";
            parent.layer.close(index);
        });
    
    });
});