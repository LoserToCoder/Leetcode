<%@page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${APP_PATH}/commons/layui/css/layui.css"/>
<jsp:include page="meta.jsp"></jsp:include>
<title>新增征文</title>
</head>
<body>
<div class="page-container">
	<div class="form form-horizontal">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品的名称</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="item-title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>积分</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="score">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>数量</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  class="input-text"  placeholder="数量" id="nums" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品上传</label>
			<div class="formControls col-xs-8 col-sm-9">
				<a id="upload_cover" class="btn btn-default btn-uploadstar radius ml-10">上传图片</a>
				<div>
					<img src="" id="recruit_cover"  style="display: none;width: 100px"/>
					<input type="hidden" id="cover">
				</div>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="submit" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</div>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script type="text/javascript" src="${APP_PATH}/commons/layui/layui.js"></script>
<script type="text/javascript">

    $(function () {
            layui.use('upload', function () {
                var upload = layui.upload;
                upload.render({
                    elem: '#upload_cover'
                    , url: '/product/cover'
                    , multiple: false,
                    field: 'uploadFiles',
                    number: 1
                    , before: function (obj) {

                    }
                    , done: function (res, index, upload) {
                       if(res.status==200){
                           $("#recruit_cover").css('display', 'block');
                           $("#recruit_cover").attr("src","//localhost"+res.url)
                           $("#cover").val(res.url)
					   }else{
                           alert("上传失败");
					   }
                    },
                    error: function (index, upload) {

                    }
                });
            })
		    $("#submit").click(function () {
                  var item={
                      title:$("#item-title").val(),
					  score:$("#score").val(),
                      num:$("#nums").val(),
                      picture:$("#cover").val()
				  }
				  if(!item.title){
                      layer.msg('名称不能为空', {icon:5,time:1000});
                      return;
				  }
				  if(!item.score){
                      layer.msg('积分不能为空', {icon:5,time:1000});
                      return;
				  }
                 if(!item.num){
                    layer.msg('数量不能为空', {icon:5,time:1000});
                    return;
                 }
                 if(!item.picture){
                     layer.msg('商品图片不能为空', {icon:5,time:1000});
                     return;
				 }
                 $.ajax({
					 url:'/product/add',
					 type:'POST',
					 dataType:'json',
					 data:{
					    title:item.title,
						 score:item.score,
						 num:item.num,
						 picture:item.picture
					 },success:function (data) {
					     if(data.status==200)
						 {
                             layer.msg(data.msg, {icon:1,time:1000});
                             layer_close()
						 }else {
                             layer.msg(data.msg, {icon:2,time:1000});
						 }
                     }

				 })
            })
    })
</script>
<!--请在下方写此页面业务相关的脚本-->
</body>
</html>