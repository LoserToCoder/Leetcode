<%@page language="java"  contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="meta.jsp"></jsp:include>
<link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
<title>征文列表</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 征文管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a class="btn btn-primary radius" onclick="picture_add('新增征文','/admin/recruit-add.jsp')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i>新增征文</a></span> <span class="r">共有数据：<strong>${beans.resultTotal}</strong> 条</span> </div>
			<div class="mt-20">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="40"><input name="" type="checkbox" value=""></th>
							<th width="80">ID</th>
							<th width="100">主题</th>
							<th width="100">封面</th>
							<th>征文描述</th>
							<th width="150">开始时间</th>
							<th width="60">结束时间</th>
							<th width="60">状态</th>
							<th width="100">操作</th>
						</tr>
					</thead>
					<tbody>
					    <c:forEach var="recruit" items="${beans.results}" varStatus="seq">
							<tr class="text-c">
								<td><input name="" type="checkbox" value=""></td>
								<td>${seq.index+1}</td>
								<td>${recruit.theme}</td>
								<td><img width="50" class="picture-thumb" src="//localhost${recruit.cover}"></td>
								<td class="text-l">${recruit.desc}</td>
								<td class="text-c">${recruit.startTime}</td>
								<td>${recruit.endTime}</td>
								<c:if test="${recruit.status==1}">
								<td class="td-status"><span class="label label-success radius">进行中</span></td>
								</c:if>
								<c:if test="${recruit.status==2}">
									<td class="td-status"><span class="label  label-defaunt radius">已结束</span></td>
								</c:if>
								<td class="td-manage"><a style="text-decoration:none" onClick="picture_stop(this,${recruit.id})" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/commons/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
	]
});
/*图片-添加*/
function picture_add(title,url){
	/*var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);*/
    layer.open({
        type:2,
        title:title,
        content:url,
        area:['800px', '650px'],
        success:function(layero, index){
            console.log(layero,index)
        }
    })
}
/*图片-审核*/
function picture_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过'], 
		shade: false
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}
/*图片-下架*/
function picture_stop(obj,id){
	layer.confirm('确认要结束吗？',function(index){
        $.ajax({
            url:'/recruit/deadline',
			type:'GET',
			dataType:'json',
			data:{
                id:id
			},success:function (data) {
				if(data.status==200){
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已结束</span>');
                    $(obj).remove();
                    layer.msg('已结束!',{icon: 5,time:1000});
				}
            }
        })

	});
}

/*图片-发布*/
function picture_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
/*图片-申请上线*/
function picture_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}
/*图片-删除*/
function picture_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){

		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>