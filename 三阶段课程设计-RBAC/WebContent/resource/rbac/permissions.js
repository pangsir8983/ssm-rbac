var permission_js={
    init:function(functions){
         $("*[permission-data]").hide();
        if(functions!=""){
             var premissions = functions.split(",");
             $.each(premissions,function(index,value){
                 $("*[permission-data='"+value+"']").show();
             });
        }
    }
}