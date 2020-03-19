$(function () {
    var token=$.cookie('T_TOKEN')
    if(!token)
        return;
    $.ajax({
        url:'/user/validate',
        type:'GET',
        data:{token:token},
        dateType:'json',
        beforeSend:function(){

        },
        success:function (data) {
            if(data.status==200){
                window.location.href="//localhost:8080/essay/"
            }
        },
        error:function (XMLHttpRequest) {

        },
        complete:function (XMLHttpRequest, textStatus) {

        }
    })
})