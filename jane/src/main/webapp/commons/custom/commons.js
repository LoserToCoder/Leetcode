$(function () {

    function fillUser(user) {
                $("#login").toggle()
                $("#login-done").toggle()
                $("#login-done img").attr('src',user.avatar)
                $("#jane_id").val(user.id)
                $("#jane_name").val(user.username)
                $("#jane_background_cover").val(user.backgroundCover)
                $("#jane_score").html("★"+user.score+"积分")
                $("#avatar").attr("src",user.avatar)
                $("#jane_qrcode").val(user.qrcode)
                $("#jane_gender").val(user.gender)
                $("#jane_email").val(user.email)
                $("#jane_gender").val(user.gender)
    }
    $("#mynavtools-logout").click(function () {
        var  token=$.cookie('T_TOKEN')
        if(token)
           window.location.href="/user/logout?token="+token;
    })
    function loader() {
        var token=$.cookie('T_TOKEN')
        if(!token){
           // $("#popSelect").css("display","none")
            $("#popSelect").remove()
            return
        }
        $.ajax({
            url:'/user/validate',
            type:'GET',
            data:{token:token},
            dateType:'json',
            beforeSend:function(){

            },
            success:function (data) {
                if(data.status==200){
                    fillUser(data.info)
                }else {
                    $("#popSelect").remove()
                }
            },
            error:function (XMLHttpRequest) {

            },
            complete:function (XMLHttpRequest, textStatus) {

            }
        })
    }
    function initializeWindows(){
        var currentWindowWidth=$(this).width();
        if(currentWindowWidth>1255)
            $('#dt-header-right').css('display','block');
        else{
            $('#dt-header-right').css('display','none');
        }
    }
    //当点击更多时,加载数据,并隐藏更多
   //当浏览器窗口大小发生变化时,控制导航栏的菜单
    $(window).resize(initializeWindows);
    initializeWindows();

    loader();

})