 $(function () {
        /**绑定tr的单击事件,雪中单选框按钮*/
        $("tbody tr").click(function () {
           $(this).find("input[type='radio']").prop("checked",true);
        });

        /**通过类选择器绑定事件*/
        $(".role-add").on("click",function () {
            parent.layer.open({
                title:"角色管理 | 新建角色",
                type: 2,
                area: ['750px', '350px'],
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
                title:"角色管理 | 维护角色",
                type: 2,
                area: ['750px', '350px'],
                fixed: false,
                content: 'sys/role/update/'+role_id //使用占位符传递数据-练习一下
            });
        });

         /**通过class选择器绑定事件*/
        $(".role-delete").click(function () {
            //获取role_id
            var role_id = $("tbody input[type='radio']:checked").val();
            if(!role_id){
                parent.layer.alert('请选择要注销的角色信息!', {icon: 3});
                return false;
            }
            if(role_id<0){
                parent.layer.alert('您选择的角色无法进行注销操作!', {icon: 5});
                return false;
            }
            
            parent.layer.confirm('你确定要执行改操作吗?', {icon: 2, title:'角色管理 | 提示信息'}, function(index){
                $.post("sys/role/remove",{role_id:role_id,_method:"delete"},function(data){
                    if(data.flag=="success"){
                        window.location.href = window.location.href;//刷新页面
                    }else{
                        alert(data.message);
                        return false;
                    }
                },"json");
            	
                parent.layer.close(index);
            });
        });

        $(".role-menu").click(function () {
            var role_id = $("tbody input[type='radio']:checked").val();
            if(!role_id){
                parent.layer.alert('请选择要授权的角色信息!', {icon: 3});
                return false;
            }
            parent.layer.open({
                title:"角色管理 | 授权菜单",
                type: 2,
                area: ['600px', '450px'],
                fixed: false,
                content: 'sys/role/permission?role_id='+role_id
            });
        });
});
