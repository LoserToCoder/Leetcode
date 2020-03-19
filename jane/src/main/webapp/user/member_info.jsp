<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<html>
 <head> 
  <meta charset="utf-8" /> 
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
  <meta property="wb:webmaster" content="3bd1e36da79af84a" /> 
  <title>账号设置 - 个人中心</title> 
  <meta name="keywords" content="创作共享" />
  <meta name="description" content="创作共享" />
  <link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
  <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.css" />
  <link href="css/set.76496992.css" rel="stylesheet" type="text/css" /> 
  <link href="${APP_PATH}/commons-css/nav-menus.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="${APP_PATH}/commons/layui/css/layui.css"/>
  <script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js"></script>
 </head> 
 <body> 
 <jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>
 <div id="content">
   <div class="block"> 
    <div class="box"> 
     <h2><a href="javascript:">我的信息</a>&nbsp;&gt;&nbsp;<a href="javascript:;">账号设置</a>&nbsp;&gt;&nbsp;<a href="javascript:;" class="changename">基本信息</a></h2>
    </div> 
    <div class="pb8 set-mt15"> 
     <ul class="ctr-sw"> 
      <li data-info="set-info" class="cur"><a href="#info">基本信息</a><i></i></li> 
      <li data-info="set-email"><a href="#email">邮箱</a><i></i></li> 
      <li data-info="set-pwd"><a href="#password">密码</a><i></i></li>
     </ul> 
    </div> 
   </div> 
   <div class="info-main-area"> 
    <div class="hset set-info" style="display: block;"> 
     <div class="block"> 
      <div class="ps-info-img"> 
       <div class="ps-img-d">
        <a id="myphotoa" href="javascript:;"><img id="avatar" src="/images/default_avatar.png" width="120" height="120" /></a>
       </div> 
      </div> 
      <div id="set-uploadhead-holder" class="set-selectpic gray"> 
       <div id="default-dec" class="l20">
        <br /> 选择喜欢的图片作为您的头像：
       </div> 
       <div id="view-dec" class="l20 dn">
        这是您新头像的预览，满意地话就点击保存吧：
        <br />&nbsp;
       </div> 
       <div class="pgareaup"> 
        <a class="abtn abtn-up dib" href="javascript:;" id="set-uploadhead-btn"><u><i></i>上传头像</u>
        </a>
        <div id="set-uploading" class="dib loading3 dn">
         正在上传
        </div> 
        <div id="set-uperror" class="dib mt8 ml8 l20 red"></div> 
       </div>
       <div class="clr mt8"> 
        <div class="l mt8 gray">
          可以上传jpg,gif,png格式的图片，且文件小于2M 
        </div> 
       </div> 
      </div> 
     </div> 
     <div class="block brdsep"> 
      <form id="form-setprofile" >
       <div class="set-baseinfo"> 
        <table class="tableform" cellspacing="0" cellpadding="0"> 
         <colgroup width="142"></colgroup> 
         <colgroup width="600"></colgroup> 
         <tbody>
          <tr>
           <th>性别</th> 
           <td> <input id="gender-0" class="pg-gender ml8 chk" name="gender" value="1" type="radio" /><label for="gender-0">男</label> <input id="gender-1" class="pg-gender ml8 chk" name="gender" value="2" type="radio" /><label for="gender-1">女</label> <input id="gender-2" class="pg-gender ml8 chk" name="gender" value="3" type="radio" checked="checked" /><label for="gender-2">保密</label> </td>
          </tr>
          <tr>
           <th>详细地址</th>
           <td id="chinacity-1">
            <input id="citycode" name="citycode" value="" type="text" />
           </td>
          </tr>
          <tr>
           <th>手机号</th>
           <td id="phone-1">
            <input id="phone"  value="" type="text" />
           </td>
          </tr>
          <tr> 
           <td>&nbsp;</td> 
           <td> 
            <div class="clr mt8"> 
             <a id="set-upsavebtn" class="abtn abtn-w4" target="_self" href="javascript:;"><u>保存设置</u></a>
            </div> </td> 
          </tr> 
         </tbody>
        </table> 
       </div> 
      </form> 
     </div> 
    </div> 
    <div class="hset set-email" style="display: none;"> 
     <form id="form-upemail" action="">
      <div class="set-baseinfo"> 
       <table class="tableform" cellspacing="0" cellpadding="0"> 
        <tbody>
         <tr> 
          <td>邮箱地址</td> 
          <td><input class="ipt" name="email" value="416148489@qq.com" id="jane_email" type="text" />
           <div class="error" id="error"></div></td>
          <td>(更改邮箱地址)</td> 
         </tr>
         <tr> 
          <td>&nbsp;</td> 
          <td> 
           <div class="clr mt8"> 
            <a id="emailUp" class="abtn abtn-w4" target="_self" href="javascript:;"><u>保存设置</u></a> 
           </div> </td> 
          <td></td> 
         </tr> 
        </tbody>
       </table> 
      </div> 
     </form> 
    </div> 
    <!-- edit_passwd --> 
    <div class="hset set-pwd set-password" style="display: none;"> 
     <div id="form-editpasswd">
      <div class="set-baseinfo"> 
       <table class="tableform" cellspacing="0" cellpadding="0"> 
        <tbody>
         <tr> 
          <th>当前密码</th> 
          <td><input class="ipt" name="passwd2" value="" type="password" id="currentPwd" /></td>
          <td >&nbsp;</td>
         </tr> 
         <tr> 
          <th>新密码</th> 
          <td><input class="ipt" name="newpasswd" value="" type="password"  id="newPwd"/></td>
          <td>&nbsp;</td> 
         </tr> 
         <tr> 
          <th>确认新密码</th> 
          <td><input class="ipt" name="newpasswd2" value="" type="password" id="ensurePwd" /></td>
          <td class="pswerror" style="color:red">&nbsp;</td> 
         </tr>
         <tr> 
          <td>&nbsp;</td> 
          <td> 
           <div class="clr mt8"> 
            <a id="pwdUp" class="abtn abtn-no abtn-w4" target="_self" href="javascript:;"><u>保存设置</u></a>
           </div> </td>
         </tr> 
        </tbody>
       </table> 
      </div> 
     </div>
    </div> 
   </div> 
  </div> 
  <div id="footer" class="footer">
  </div> 
  <div id="win-house" class="h0"> 
   <div class="set-name">
   </div> 
  </div> 
  <div id="foot-forms" class="dn"> 
  </div>
  <script src="js/profileEdit.99650e2d.js"></script>
 <script type="text/javascript" src="${APP_PATH}/commons/layui/layui.js"></script>
 <script type="text/javascript">
     $(function () {
         layui.use('upload', function () {
             var upload = layui.upload;
             upload.render({
                 elem: '#set-uploadhead-btn'
                 , url: '/uploader/cover'
                 , multiple: false,
                 field: 'uploadFiles',
                 number: 1,
                 data: {
                     type: 'user',
                     id: $("#jane_id").val()
                 }
                 , before: function (obj) {

                 }
                 , done: function (res, index, upload) {
                     if (res.errno == 0) {
                         $("#avatar").attr("src", "//localhost" + res.data[0]);
                     }

                 },
                 error: function (index, upload) {

                 }
             });
         })
         $("#set-upsavebtn").click(function () {
             var gender=$("input.pg-gender:checked").val();
             var phone=$("#phone").val();
             var address=$("#citycode").val();
             var avatar=$("#avatar").attr('src');
             if(!phone||phone.length==0){
                 alert("手机号不能为空");
                 return;
             }
             if (!address || address.length == 0) {
                 alert("收货地址不能为空");
                 return;
             }
             $.ajax({
                 url:'/user/update',
                 type:'GET',
                 dataType:'json',
                 data:{
                     gender:gender,
                     phone:phone,
                     address:address,
                     avatar:avatar,
                     id:$("#jane_id").val(),
                     token:$.cookie('T_TOKEN'),
                     type:3
                 },success:function (data) {
                     if(data.status==200){
                         alert("更新成功");
                     }
                 }
             })
         })
         
         $("#emailUp").click(function () {
             var error=$("#error").html();
             if(error&&error.length>0){
                 return;
             }
             var email=$("#jane_email").val();
             $.ajax({
                 url:'/user/update',
                 type:'GET',
                 dataType:'json',
                 data:{
                     email:email,
                     id:$("#jane_id").val(),
                     type:1
                 },success:function (data) {
                     if(data.status==200){
                         alert("更新成功");
                     }
                 }
             })
         })
         $("#currentPwd").blur(function () {
             var current=$("#currentPwd").val();
             if(current&&current.length>0){
                 $.ajax({
                     url:'/user/validate/password',
                     type:'GET',
                     dataType: 'json',
                     data:{
                         password:current,
                         id:$("#jane_id").val()
                     },success:function (data) {
                         if(data.status==200){
                             $("#currentPwd").val(data.info);
                         }else{
                             alert("用户密码不正确")
                         }
                     }
                 })
             }
         })
         $("#pwdUp").click(function () {
             var current=$("#currentPwd").val();
             if(current&&current==1){
                 var newPwd=$("#newPwd").val();
                 var ensurePwd=$("#ensurePwd").val();
                 if(newPwd&&ensurePwd){
                     if(newPwd==ensurePwd){
                         $.ajax({
                             url:'/user/update',
                             type:'GET',
                             dataType:'json',
                             data:{
                                 password:newPwd,
                                 id:$("#jane_id").val(),
                                 type:2
                             },success:function (data) {
                                 if(data.status==200){
                                     alert("密码修改成功");
                                 }else{
                                     alert("密码修改失败");
                                 }
                             }
                         })
                     }
                     else{
                         alert("两次密码输入不一致,请重新输入");
                     }
                 }

             }
         })
     })
 </script>
 </body>
</html>