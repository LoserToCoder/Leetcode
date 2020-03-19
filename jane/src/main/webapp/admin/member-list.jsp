<%@page language="java"  contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="meta.jsp"></jsp:include>
<title>用户列表</title>
<link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
<meta name="keywords" content="后台管理系统">
<meta name="description" content="后台管理系统">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 会员列表<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
		<article class="cl pd-20">
			<div class="mt-20">
				<table class="table table-border table-bordered table-hover table-bg table-sort">
					<thead>
						<tr class="text-c">
							<th width="25"><input type="checkbox" name="" value=""></th>
							<th width="80">ID</th>
							<th width="100">用户名</th>
							<th width="40">性别</th>
							<th width="150">邮箱</th>
							<th width="130">加入时间</th>
							<th width="70">状态</th>
							<th width="100">操作</th>
						</tr>
					</thead>
					<tbody>
					    <c:if test="${beans.status==200}">
						    <c:forEach var="user" items="${beans.info}" varStatus="seq">
								<tr class="text-c">
									<td><input type="checkbox" value="1" name=""></td>
									<td>${seq.index}</td>
									<td>${user.username}</td>
									<c:if test="${user.gender==1}">
										<td>男</td>
									</c:if>
									<c:if test="${user.gender==2}">
										<td>女</td>
									</c:if>
									<c:if test="${user.gender==3}">
										<td>保密</td>
									</c:if>
									<td>${user.email}</td>
									<td>${user.reisterTime}</td>
									<c:if test="${user.status==1}">
										<td class="td-status"><span class="label label-success radius">已启用</span></td>
									</c:if>
									<c:if test="${user.status==0}">
										<td class="td-status"><span class="label label-defaunt radius">已启用</span></td>
									</c:if>
									<td class="td-manage"><a style="text-decoration:none" onClick="member_stop(this,${user.id})" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${beans.status!=200}">
							用户信息加载失败
						</c:if>

					</tbody>
				</table>
			</div>
		</article>
	</div>
</section>
<jsp:include page="footer.jsp"></jsp:include>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH}/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/commons/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	});
	$('.table-sort tbody').on( 'click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
			$(this).removeClass('selected');
		}
		else {
			$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
	    $.ajax({
			url:'/user/status',
			type:'GET',
            dataType: 'json',
			data:{
			    id:id,
				type:1
			},success:function (data) {
				if(data.status==200){
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_start(this,'+id+')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
                    $(obj).remove();
                    layer.msg('已停用!',{icon: 5,time:1000});
				}
            }
		})

	});
}

/*用户-启用*/
function member_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
        $.ajax({
            url:'/user/status',
            type:'GET',
            dataType: 'json',
            data:{
                id:id,
                type:2
            },success:function(data){
               if(data.status==200){
                   $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,'+id+')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
                   $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
                   $(obj).remove();
                   layer.msg('已启用!',{icon: 6,time:1000});
			   }
            }
        })

	});
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,id,w,h);
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>