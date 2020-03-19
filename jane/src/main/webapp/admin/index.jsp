<%@page language="java"  contentType="text/html;charset=UTF-8" %>
<jsp:include page="meta.jsp"></jsp:include>
<title>后台管理系统</title>
<meta name="keywords" content="后台管理系统">
<meta name="description" content="后台管理系统">
</head>
<body>
<jsp:include page="/admin/header.jsp"></jsp:include>
<jsp:include page="/admin/menu.jsp"></jsp:include>
<section class="Hui-article-box">
	<nav class="breadcrumb"><i class="Hui-iconfont"></i> <a href="/" class="maincolor">首页</a>
		<span class="c-999 en">&gt;</span>
		<span class="c-666">我的桌面</span>
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="Hui-article">
	</div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>