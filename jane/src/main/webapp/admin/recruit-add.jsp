<%@page language="java" pageEncoding="UTF-8"  contentType="text/html;charset=UTF-8" %>
<link rel="stylesheet" href="${APP_PATH}/commons/layui/css/layui.css"/>
<jsp:include page="meta.jsp"></jsp:include>
<title>新增征文</title>
</head>
<body>
<div class="page-container">
	<div class="form form-horizontal">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>征文的主题</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="theme">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>征文描述</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea id="desc" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="textarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="remark">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>开始时间</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  class="input-text"  placeholder="开始时间" id="startTime" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>结束时间</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text"  class="input-text"  placeholder="结束时间" id="endTime" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>征文封面上传</label>
			<div class="formControls col-xs-8 col-sm-9">
				<a id="upload_cover" class="btn btn-default btn-uploadstar radius ml-10">上传封面</a>
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
                    , url: '/recruit/cover'
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
            layui.use('laydate', function(){
            var laydate = layui.laydate;
             laydate.render({
                elem: '#startTime', //指定元素
                type: 'datetime'
             });
             laydate.render({
                    elem: '#endTime', //指定元素
                    type: 'datetime'
             });
        });
		    $("#submit").click(function () {
                  var recruit={
                      theme:$("#theme").val(),
					  desc:$("#desc").val(),
					  remark:$("#remark").val(),
					  startTime:$("#startTime").val(),
					  endTime:$("#endTime").val(),
                      cover:$("#cover").val()
				  }
				  if(!recruit.theme){
                      layer.msg('主题不能为空', {icon:5,time:1000});
                      return;
				  }
				  if(!recruit.desc){
                      layer.msg('描述不能为空', {icon:5,time:1000});
                      return;
				  }
                 if(!recruit.startTime){
                    layer.msg('起始时间不能为空', {icon:5,time:1000});
                    return;
                 }
                 if(!recruit.endTime){
                     layer.msg('结束时间不能为空', {icon:5,time:1000});
                     return;
				 }
				 if(!recruit.cover){
                     layer.msg('封面不能为空', {icon:5,time:1000});
                     return;
                 }
                 $.ajax({
					 url:'/recruit/add',
					 type:'POST',
					 dataType:'json',
					 data:{
					     theme:recruit.theme,
						 desc:recruit.desc,
						 startTime:recruit.startTime,
						 endTime:recruit.endTime,
						 cover:recruit.cover,
						 remark:recruit.remark
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