<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" language="java" %>
<html>
 <head> 
  <meta charset="utf-8" /> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>主页 - 个人中心</title> 
  <meta name="keywords" content="兴趣爱好" />
  <link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
  <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.css" />
  <link rel="stylesheet" href="${APP_PATH}/commons-css/nav-menus.css">
  <link href="css/detail.2e1eb0ea.css" rel="stylesheet" />
  <link rel="stylesheet" href="${APP_PATH}/user/css/style.css">
  <script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js"></script>
  <script src="${APP_PATH}/commons/jquery/jquery.min.js"></script>
 </head> 
 <body>
  <jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>
  <div id="content" style="margin-top: 50px">
   <div class="layer layer-full oh"> 
    <div class="tube"> 
     <div class="block blockmb"> 
      <div class="people-header"> 
       <div class="people-header-left"> 
        <img class="header-bg" src="/images/20140120184114_TjEfA.thumb.712_356_g.jpeg" />
        <div class="header-bg-mask"></div> 
        <table> 
         <tbody> 
          <tr> 
           <td class="people-info"> <a class="people-avatar" href="javascript:"> <img id="avatar" src="/images/default_avatar.png" /> </a>
            <div class="people-name">
            </div> 
            <div class="people-meta"> 
             <span id="jane_score">0</span>
            </div> 
            <div class="people-desc"> 
            </div> 
            <div class="people-social"> 
            </div> 
        </td>
          </tr> 
         </tbody> 
        </table> 
       </div> 
       <div class="people-header-right"> 
        <img class="header-bg" src="/images/default_background.jpg" />
        <div class="header-bg-mask"></div> 
       </div> 
      <%-- <div class="reply-addpic header-bg-change">
        <div class="header-bg-change-bg"></div> 
        <a class="abtn-up dib header-bg-change-btn" href="javascript:;" id="reply-addpic-btn">修改封面</a>
       </div> --%>
      </div> 
     </div>
     <div class="width100 hidden_yh" style="background:#f0f0f0;padding-top:34px;padding-bottom:34px;">
      <div class="width1200 hidden_yh center_yh">
       <div id="vipNav">
        <a href="javascript:" style="text-decoration: none">我的主页</a>
        <a href="javascript:" id="collections" style="text-decoration: none">我的收藏</a>
        <a href="javascript:" id="articles" style="text-decoration: none">我的文章</a>
        <a href="javascript:" id="items" style="text-decoration: none">我的商品</a>
        <a href="javascript:" id="score_records" style="text-decoration: none">兑换记录</a>
       </div>
       <div id="vipRight">
        <div class="hidden_yh bj_fff" style="width:938px;border:1px solid #ddd;">
         <div class="width100 font24" style="height:60px;line-height:60px;text-indent:50px;background:#f5f8fa;border-bottom:1px solid #ddd;" id="item-title">我的主页</div>
         <div class="hidden_yh" style="padding:20px;width:898px;" id="item-content">
         </div>
        </div>
       </div>
      </div>
     </div>
    </div> 
   </div> 
  </div>
 </body>
 <script type="text/javascript">
  $(function () {
      $("#collections").click(function () {
          var uid=$("#jane_id").val();
          if(uid){
              $.ajax({
                  url:'/user/collections',
                  type:'GET',
                  dataType:'json',
                  data:{
                      id:uid
                  },
                  success:function (data) {
                      if(data.status==200){
                          $("#item-content").html("");
                          for(var i=0;i<data.info.length;i++){
                              var type=data.info[i].type;
                              var html = "";
                              html+='<div class="width100 hidden_yh" style="border-bottom:1px dashed #ddd;padding-top:10px;padding-bottom:10px;">' ;
                              html+='<div class="left_yh" style="width:580px; padding-top: 50px;padding-left: 50px">';
                              if(type==1){
                                  html+='<h3 class="font18 c_33 font100" ><a href="/item/'+data.info[i].entityId+'.html">'+data.info[i].title+'</a></h3></div>'
                              }else{
                                  html+='<h3 class="font18 c_33 font100" ><a href="/post/'+data.info[i].entityId+'">'+data.info[i].title+'</a></h3></div>'
                              }
                              $("#item-content").append(html);
                          }
                          $("#item-title").html("我的收藏")
                      }else if(data.status==201){
                          $("#item-content").html("");
                           $("#item-title").html("我的收藏")
                           $("#item-content").html(data.msg);
                      }
                  }
              })
          }
      })
      $("#articles").click(function () {
          var uid=$("#jane_id").val();
          if(uid){
              $.ajax({
                  url:'/post/user',
                  type:'GET',
                  dataType:'json',
                  data:{
                      id:uid
                  },
                  success:function (data) {
                      if(data.status==200){
                          $("#item-content").html("");
                          for(var i=0;i<data.info.length;i++){
                              var html = "";
                              html+='<div class="width100 hidden_yh" style="border-bottom:1px dashed #ddd;padding-top:10px;padding-bottom:10px;">' ;
                              html+='<img src="//localhost'+data.info[i].cover+'" width="100" height="100" class="left_yh">'
                              html+='<div class="left_yh" style="width:580px; padding-top: 50px;padding-left: 50px">';
                              html+='<h3 class="font18 c_33 font100" ><a href="/post/'+data.info[i].id+'">'+data.info[i].title+'</a></h3></div>'
                              $("#item-content").append(html);
                          }
                          $("#item-title").html("我的文章")
                      }else if(data.status==201){
                          $("#item-content").html("");
                          $("#item-title").html("我的文章")
                          $("#item-content").html(data.msg);
                      }
                  }
              })
          }
      })
      $("#items").click(function () {
          var uid=$("#jane_id").val();
          if(uid){
              $.ajax({
                  url:'/user/item',
                  type:'GET',
                  dataType:'json',
                  data:{
                      id:uid
                  },
                  success:function (data) {
                      if(data.status==200){
                          $("#item-content").html("");
                          for(var i=0;i<data.info.length;i++){
                              var html = "";
                              html+='<div class="width100 hidden_yh" style="border-bottom:1px dashed #ddd;padding-top:10px;padding-bottom:10px;">' ;
                             if(data.info[i].prefix){
                                 html+='<img src="//localhost:80/images/goods/'+data.info[i].prefix+'/'+data.info[i].pid+'/'+data.info[i].imgUrl+'" width="100" height="100" class="left_yh">'
                             }else {
                                 html+='<img src="//localhost:80/images/goods_details/'+data.info[i].pid+'/'+data.info[i].imgUrl+'" width="100" height="100" class="left_yh">'
                             }
                              html+='<div class="left_yh" style="width:580px; padding-top: 50px;padding-left: 50px">';
                              html+='<h3 class="font18 c_33 font100" ><a href="/item/'+data.info[i].id+'.html">'+data.info[i].title+'</a></h3></div>'
                              $("#item-content").append(html);
                          }
                          $("#item-title").html("我的商品")
                      }else if(data.status==201){
                          $("#item-title").html("我的商品")
                          $("#item-content").html(data.msg);
                      }
                  }
              })
          }
      })
      $("#score_records").click(function () {
          var uid=$("#jane_id").val();
          if(uid){
              $.ajax({
                  url:'/soft/score',
                  type:'GET',
                  dataType:'json',
                  data:{
                      uid:uid
                  },
                  success:function (data) {
                      if(data.status==200){
                          $("#item-content").html("");
                          for(var i=0;i<data.info.length;i++){
                              var html = "";
                              html+='<div class="width100 hidden_yh" style="border-bottom:1px dashed #ddd;padding-top:10px;padding-bottom:10px;">' ;
                              html+='<img src="//localhost'+data.info[i].picture+'" width="100" height="100" class="left_yh">'
                              html+='<div class="left_yh" style="width:580px; padding-top: 50px;padding-left: 50px">';
                              html+='<h3 class="font18 c_33 font100" ><a href="/item/'+data.info[i].id+'.html">'+data.info[i].title+'</a></h3></div>'
                              $("#item-content").append(html);
                          }
                          $("#item-title").html("我的兑换记录")
                      }else if(data.status==201){
                          $("#item-title").html("我的兑换记录")
                          $("#item-content").html(data.msg);
                      }
                  }
              })
          }
      })
  })
 </script>
</html>