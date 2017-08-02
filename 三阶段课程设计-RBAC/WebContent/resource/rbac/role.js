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
});
