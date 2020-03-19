$(function(){
  var token=$.cookie('uuid');
  if(!token){
  	//让用户登陆,跳转到用户的登录界面
  	 window.location.href='index';
  }
})
 <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
  <script src="js/wangEditor.min.js" type="text/javascript"></script>
  <script src="commons/layer/2.4/layer.js" type="text/javascript"></script>
  <script src="js/ext.js" type="text/javascript"></script>
  <script type="text/javascript">
      $(function () {
          var content={};
          function pubMessage(){
              content.title=$("#article_title").val();
              content.content=editor.txt.html();
             // content.status=$("#status").val();
              content.authorId = $("#uuid").val();
              content.category='经典段子';
              content.cover='/uploads/aa.jpg';
             if(!content.title||content.title=="")
             {
                 layer.tips("标题不能为空",'#article_title');
                 return;
             }

             if(!content.content||content.content.length<100){
                  layer.tips('内容不能少于100','#edit');
                  return;
              }
              $.post({
                  url:'/compose/pub',
                  dataType:'json',
                  data:content,
                  success:function (result) {
                       alert(result);
                       console.log(result)
                  },
                  error:function (xhr,status,error) {

                  }

              })
          }
          $("#save").click(function () {
              pubMessage();
          })
          $("#pub").click(function () {
              pubMessage();
          })
      })
  </script>
