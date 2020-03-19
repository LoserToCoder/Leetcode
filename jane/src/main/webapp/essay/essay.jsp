<%@page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=Edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
		<meta name="description" content="在这里，你可以任性地创作，一篇短文、一张照片、一首诗、一幅画……我们相信，每个人都是生活中的艺术家，有着无穷的创造力。">
		<title>创作</title>
		<link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
		<link rel="stylesheet" media="all" href="${APP_PATH}/essay/css/web-e7e403d2843dd1edd8db.css" />
		<link rel="stylesheet" media="all" href="${APP_PATH}/essay/css/entry-7642b94e17df29096c13.css" />
		<link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.css"/>
		<link href="${APP_PATH}/commons-css/nav-menus.css" rel="stylesheet"/>
		<style type="text/css">
			html,body{
				background-color: #ffffff !important;
			}
			.col-xs-16 {
					width: 61.66667% !important;
			}
			.have-img .wrap-img img {width:150px;height: 150px; background: url(/essay/css/loading.gif) 50% no-repeat;}
			a.load-more:link,a.load-more:visited{
                 color: #ffffff;
			}
			.category_hidden{
				display: none !important;
			}
		</style>
		<script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js"></script>
	</head>
	<body lang="zh-CN" class="reader-black-font" style="">
	    <jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>
		<div class="container index">
			<div class="row">
				<!-- Banner -->
				<!-- Banner -->
				<div class="col-xs-16 main">
					   <div class="recommend-collection">

						<a class="collection"  href="/category/post?category=效率笔记">
							<div class="name">效率笔记</div>
						</a>
						<a class="collection"  href="/category/post?category=生活小妙招">
							<div class="name">生活小妙招</div>
						</a>
						<a class="collection"  href="/category/post?category=情感">
							<div class="name">情感</div>
						</a>
						<a class="collection"  href="/category/post?category=慧生活">
							<div class="name">慧生活</div>
						</a>
						<a class="collection"  href="/category/post?category=美妆·护肤·穿搭">
							<div class="name">美妆·护肤·穿搭</div>
						</a>
						<a class="collection"  href="/category/post?category=好书推荐">
							<div class="name">好书推荐</div>
						</a>

						<a class="collection"  href="/category/post?category=美食菜谱">
							<div class="name">美食菜谱</div>
						</a>
						<a class="collection"  href="/category/post?category=旅行·在路上">
							<div class="name">旅行·在路上</div>
						</a>
						<a class="collection category_hidden"  href="/category/post?category=撩汉">
							<div class="name">撩汉</div>
						</a>

						<a class="collection category_hidden"  href="/category/post?category=美人说">
							<div class="name">美人说</div>
						</a>
						<a class="collection category_hidden"  href="/category/post?category=海外党">
							<div class="name">海外党</div>
						</a>
						<a class="collection  category_hidden"   href="/category/post?category=音乐">
							<div class="name">音乐</div>
						</a>
						<a class="collection category_hidden"  href="/category/post?category=影视">
							<div class="name">影视</div>
						</a>
						<a class="collection category_hidden"  href="/category/post?category=信息技术">
							<div class="name">信息技术</div>
						</a>
						<a class="collection category_hidden"  href="/category/post?category=大学那些事">
							<div class="name">大学那些事</div>
						</a>

						<a class="more-hot-collection" id="category_more" style="text-decoration: none;cursor: pointer"  href="javascript:;">
							更多热门专题 <i class="iconfont ic-link"></i></a>
					</div>
					<div class="split-line"></div>
					<div></div>
					<div id="list-container">


						<!-- 文章列表模块 -->
						<ul class="note-list" infinite-scroll-url="javascript:;">

						<c:forEach var="item" items="${beans.results}" >
							<li id="note-17215651" data-note-id="17215651" class="have-img">
								<a class="wrap-img" href="/post/${item.id}" target="_blank">
									<img  class="img-blur-done lazy" style="width: 150px;height: 120px" src="/essay/css/blank.gif" data-echo="//localhost:80${item.cover}"  />
								</a>
								<div class="content">
									<a class="title" target="_blank" href="/post/${item.id}">${item.title}</a>
									<p class="abstract">
										${item.previews}
									</p>
									<div class="meta">
										<a class="collection-tag" target="_blank" href="javascript:;">${item.category}</a>
										<a target="_blank" href="javascript:;">
											<i class="iconfont ic-list-read"></i> ${item.viewCounts}
										</a>
										<a target="_blank" href="javascript:;">
											<i class="iconfont ic-list-comments"></i> ${item.commentCounts}
										</a>
										 <span><i class="iconfont ic-list-like"></i> ${item.likes}</span>
									</div>
								</div>
							</li>
						</c:forEach>
						</ul>
						<!-- 文章列表模块 -->
					</div>
				</div>
				<div class="col-xs-7 col-xs-offset-1 aside">
					<!-- 每周热吻 -->
					<div class="jianshu-daily" id="recommend">

                            <div class="title">
								<input type="hidden" value="" id="totalPage">
                                <span>你可能感兴趣的热<em style="color: red;font-size: 15px">‘吻’</em>(文)</span>
                                <a class="page-change" id="switch" ><i class="iconfont ic-search-change" style="transform: rotate(0deg);"></i>
                                换一批</a>
                            </div>

					</div>

				</div>
		  </div>
		</div>
	<div class="side-tool">
		<ul>
			<li data-placement="left" data-toggle="tooltip" data-container="body" data-original-title="回到顶部" style="">
				<a class="function-button" id="winTop" title="回到顶部"><i class="iconfont ic-backtop" title="回到顶部"></i></a>
			</li>
		</ul>
	</div>
		<%--<footer class="container">
			<div class="row">
				<div class="col-xs-17 main">
					&lt;%&ndash;<a target="_blank" href="javascript:;">帮助中心</a></em>&ndash;%&gt;
				</div>
			</div>
		</footer>--%>
	</body>
<script src="/commons/echo/echo.min.js"></script>
<script type="text/javascript">
    currentPage=2;
	$(function () {
        Echo.init({
            offset: 0,
            throttle: 0
        });
        $("#category_more").click(function () {
			$(this).css('display','none');
			$(".recommend-collection a").removeClass("category_hidden")
        })
    })
	$(function () {
		$.ajax({
			url:'/recommend/list/1',
			type:'GET',
			dataType:'json',
			success:function (data) {
				if(data.code==200){
				    $("#totalPage").val(data.pageTotal)
				    var results=data.results;
				    for(var i=0;i<results.length;i++){
                       var html='<a class="note" href="/post/'+results[i].id+'">';
                       html+='<img src="//localhost'+results[i].cover+'" >'
                       html+='<div class="note-title">'+results[i].title+'</div></a>';
                       $("#recommend").append(html);
					}
				}
            }
		})
		$("#switch").click(function () {
		    var totalPage= $("#totalPage").val();
		    if(totalPage<currentPage)
		        currentPage=1
            $.ajax({
                url:'/recommend/list/'+currentPage,
                type:'GET',
                dataType:'json',
                success:function (data) {
                    if(data.code==200){
                        $("#recommend a.note").remove();
                        var results=data.results;
                        for(var i=0;i<results.length;i++){
                            var html='<a class="note" href="/post/'+results[i].id+'">';
                            html+='<img src="//localhost'+results[i].cover+'" >'
                            html+='<div class="note-title">'+results[i].title+'</div></a>';
                            $("#recommend").append(html);
                        }
                        currentPage=currentPage+1;
                    }
                }
            })
        })
		$("#winTop").click(function () {
			$(window).scrollTop(0)
        })
    })
</script>
</html>