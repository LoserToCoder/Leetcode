<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>动态</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=1000, initial-scale=1, user-scalable=yes" />
		<link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
		<link rel="stylesheet" href="css/article.css" type="text/css" media="screen">
		<link rel="stylesheet" href="css/hot.css" type="text/css">
		<link rel="stylesheet" href="${APP_PATH}/commons/layui/css/layui.css" />
		<link rel="stylesheet" href="css/bootstrap-grid.min.css" />
		<link rel="stylesheet" href="${APP_PATH}/commons/zoomify/zoomify.min.css" />
		<style type="text/css">
			 *{
				 font-weight: 400;
			 }
		     .x-navi {
				 margin-left: 15px;
				 margin-right: 15px;
			 }
			.x-navi a,.x-navi a:visited,.x-navi a:active{
				font-size: 16px !important;
				text-decoration: none;
				color: #000 !important;
			}
            .right-bar .ta-addnew .ta-addnew-a,.right-bar .ta-addnew .ta-addnew-a:visited,.right-bar .ta-addnew .ta-addnew-a:active{
				height: 30px;
				width: 80px;
                text-decoration: none;
				border-radius:20px;
				border-color:#ea6f5a ;
				text-align: center;
				font-size: 16px;
				color: #ffffff !important;
				background-color: #ea6f5a;
			}
			 #search-hd-keywords{
				 width: 200px;
				 border-bottom-left-radius: 20px;
				 border-top-left-radius: 20px;
				 border-color: #ea6f5a;
			 }
			 .search-hd{
				height: 30px;
				width: 200px;
				 text-align: center;

			}
			 .menu_avatar{
				margin-top:-5px
			}
			 #dt-search-list {
				 display: none;
				 position: absolute;
				 background-color: #fff;
				 top: 30px;
				 left: -1px;
				 border: 1px solid #d4d5d5;
				 height: 80px;
			 }
			 #header .dt-vline,
			 .dt-search-line.hover {
				 background-color: #ebebeb
			 }

			 #dt-search-list.show {
				 display: block
			 }

			 .dt-search-line,.dt-search-line span {
				 width: 344px;
				 height: 20px;
				 padding: 5px 10px;
				 cursor: pointer;
				 color: #888;
				 font-size: 13px
			 }
		</style>
		<style type="text/css">
			#dt-search {
				float: left;
				margin-left: 10px;
				margin-top: 24px;
				border: 1px solid #ff7e7e;
				border-radius: 20px;
				position: relative;
				z-index: 900;
			}
			#dt-search form {
				position: relative;
				background-color: #fff;
				width: 262px;
				height: 30px;
				border-radius: 20px;
			}
			#dt-search form input {
				padding: 0 4px 0 10px;
				width: 220px;
				height: 30px;
				line-height: 30px;
				border: 0 none;
				border-radius: 20px;
			}
			#dt-search form button {
				position: absolute;
				top: -1px;
				right: -1px;
				width: 42px;
				height: 31px;
				outline: 0;
				border: 0 none;
				background-color: #ff7e7e;
				background-image: url(data:image/png;base64,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);
				background-position: -143px -3px;
				border-radius: 0 20px 20px 0;
				cursor: pointer;
			}

		</style>
	</head>
	<body>
	<div class="mb30" id="header">
		<div class="w1000">
			<a href="#" class="fs0 fl"><img src="../images/logo/logo.png" style="margin-top: 20px" alt=""/></a>

			<div class="nav-hd fl">

				<div class="x-navi fl">
					<a href="../index.jsp">首页</a>
				</div>
				<div class="x-navi fl">
					<a href="shop/shopping.jsp">商店</a>
				</div>
				<div class="x-navi fl">
					 <a href="../recruit/recruit.jsp">征文活动</a>
				</div>
				<div class="x-navi fl">
					<a class="x-navi fl" href="javascript:void(null)">沸点</a>
				</div>
			</div>

			<div id="dt-search" class="x-navi fl">
				<form action="../search/">
					<input class="ipt" id="kw" autocomplete="off" name="kw" placeholder="搜索感兴趣的内容" type="text" />
					<input id="type" name="type" value="feed" type="hidden" />
					<button type="submit"></button>
				</form>
				<div id="dt-search-list">
					<div class="dt-search-line hover">
						搜索含
						<span class="red"></span> 的内容
					</div>
					<div class="dt-search-line">
						搜索含
						<span class="red"></span> 的商品
					</div>
					<div class="dt-search-line">
						搜索在
						<span class="red"></span> 场景下相关的商品
					</div>

				</div>
			</div>


			<div class="right-bar fr">
				<div href="javascript:;" class="ta-addnew fl" style="margin-left: 20px">
					<a href="publish.jsp" class="ta-addnew-a">写文章</a>
				</div>

				<div href="/r/10445556" class="menu_avatar menu_item">
					<a href="#" class="round-avatar" id="info" target="_blank">

						<img src="../images/default_avatar.png" alt="AtwoodCode">

					</a>
					<div class="x-menu menu_profile">
						<span class="arrow_up"><i></i></span>
						<div class="pro_avtar clearfix">

							<div>
								<a href="http://www.sogoke.com/r/10445556/" target="_blank">AtwoodCode</a>
								<a href="http://www.sogoke.com/r/10445556/" target="_blank">我的个人主页</a>
							</div>
						</div>
						<dl>
							<dd>
								<a href="http://www.sogoke.com/home/" class="fwidth"><span>我的动态</span><b>›</b></a>
							</dd>
							<dd>
								<a href="http://www.sogoke.com/home/collections/" class="fwidth"><span>我的喜欢</span><b>›</b></a>
							</dd>
							<dd>
								<a href="http://www.sogoke.com/shopping/carts/" class="fwidth"><span>我的购物车</span><b>›</b></a>
							</dd>
							<dt class="clearfix"><a href="http://www.sogoke.com/accounts/logout/">退出</a></dt>
						</dl>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="main_all" style="min-height: 418px;" class="row">
			<div class="col-xs-3"></div>
			<div class="w1000 clearfix home mb50 col-xs-9">
				<div class="fl left-main" style="width: 690px;">
					<h1 class="mb30">广播你此时的状态</h1>
					<div class="home-postbox mb30" style="font-size: 14px;">
						<div class="home-postbox-btn clearfix mb10" >
							<a href="javascript:;" class="current createBuzz"><i class="icon icon-mybuzz"></i>发布广播</a>
							<a href="http://www.sogoke.com/create/topic/"><i class="icon icon-mytopic"></i>发布问题</a>
							<a href="http://www.sogoke.com/create/blog/"><i class="icon icon-myblog"></i>发布博文</a>
						</div>
						<div class="home-post-trigger active" style="cursor: pointer;">用简短的文字和图片   广播你此时的状态<i class="icon icon-mybuzz-pic fr mt10"></i></div>

						<form id="home-post-form" name="" action="#">
							<div class="home-post-form" style=" display:none;">

								<div style="position:relative;font-size:0;">
									<textarea class="t-autosize needs-reset-button" placeholder="分享你此时的状态..."></textarea>
									<div class="msg hpf-counter"><span>512字以内/最多上传<b style="color: red;">6</b>张图片</span></div>
								</div>
								<ul class="clearfix hpf-uploaded-pics kaikou-box ui-sortable" id="uploader-list"></ul>

								<div id="hpf-submit" class="clearfix hpf-submit" style="position: relative;">
									<a style="position: relative;" id="uploader" class="hpf-uploader fl">
									   <i class="icon icon-mybuzz-pic" style="display: inline-block;"></i>
									</a>
									<div class="hpf-uploaded-pics-counter fl active">还可以上传<span>5</span>张图片</div>
									<button id="pub" type="button" style="background:#00b7ee;" class="btn btn-lightgreen buzz-post-btn fr">发布</button>
									<div id="html5_1d6t1b0b4bi5cmksgpj1p1b9o3_container" class="moxie-shim moxie-shim-html5" style="position: absolute; top: 0px; left: 0px; width: 0px; height: 0px; overflow: hidden; z-index: 0;"><input id="html5_1d6t1b0b4bi5cmksgpj1p1b9o3" type="file" style="font-size: 999px; opacity: 0; position: absolute; top: 0px; left: 0px; width: 100%; height: 100%;" multiple="" accept="image/jpeg,.jpg,image/png,.png,.jpeg,image/gif,.gif,image/bmp,.bmp,.JPG,.PNG,.JPEG,.GIF,.BMP,application/pdf,.pdf,image/tiff,.tiff"></div>
								</div>
							</div>
						</form>
					</div>

					<div class="clearfix mb20 sf-switcher">
						<div class="fl txt-a" style="">
							<a id="tab_activities" href="javascript:;" class="current">广播</a>
							<a id="tab_published" href="javascript:;">沸点</a>
							<a id="tab_commented" href="javascript:;">我的动态</a>
						</div>
					</div>
					<ul id="activities" class="mine-list-type">
						<li  class="clearfix dynamic-list">
							<div class="fl fs0 mt5 mlt-reprinted-avatar">
								<a href="#" class="fl fs0 avatar">
									<img src="img/kouhong.png" />
								</a>
							</div>

							<div class="fr mlt-main">
								<div class="mb10">
									<a href="#" target="_blank" class="colorGreen">AtwoodCode</a> 发布的
									<a href="#" class="colorBlue" target="_blank">广播</a>
								</div>
								<div class="mlt-content mb10">
				                       xxxx
								</div>
								<div class="mlt-blog-pics fs0 clearfix mb15 row element" style="display: none;">
											<p class="col-xs-4"><img src="img/7.jpg"></p>
											<p class="col-xs-4"><img src="img/3.jpg" ></p>
											<p class="col-xs-4"><img src="img/1.jpg"></p>
								</div>
								<div class="mlt-blog-pics fs0 clearfix mb15 row element" style="display: none;">
											<p class="col-xs-4"><img src="img/4.jpg"></p>
											<p class="col-xs-4"><img src="img/5.jpg" ></p>
											<p class="col-xs-4"><img src="img/2.jpg"></p>
								</div>
								<div class="mlt-pics mb10 zoom">
										<img src="img/kouhong.png" alt="">
										<div class="picnum"><i class="icon icon-picnum"></i>6张</div>
								</div>
								<div class="mb20">
									<a  class="sgkred" >展开</a>
								</div>
								<div class="mlt-meta clearfix">
									<div class="fl mlt-date">
										<span>刚刚</span>
									</div>
									<div class="fr mlt-opt">
										<a data-url="/actions/delete/buzz/RtDS4HyQxvEePnsMMnsNMC/-/buzzs/" class="delete">删除</a>
										<a href="javascript:;" class="like liked" data-id="RtDS4HyQxvEePnsMMnsNMC"><i class="icon icon-like2"></i><span>0</span></a>
										<a href="javascript:;" data-type="buzz" data-raw_id="RtDS4HyQxvEePnsMMnsNMC" data-fetchurl="/comments/fetch/buzz/RtDS4HyQxvEePnsMMnsNMC/" class="embedreply" onclick="embedReply(this);"><i class="icon icon-comments"></i><span>0</span></a>

									</div>
								</div>
							</div>
						</li>

						<li  class="clearfix dynamic-list">
							<div class="fl fs0 mt5 mlt-reprinted-avatar">
								<a href="http://www.sogoke.com/r/10445556/" class="fl fs0 avatar" target="_blank">
									<img src="img/3.jpg" />
								</a>
							</div>

							<div class="fr mlt-main">
								<div class="mb10">
									<a href="#" target="_blank" class="colorGreen">AtwoodCode</a> 发布的
									<a href="#" class="colorBlue" target="_blank">广播</a>
								</div>
								<div class="mlt-content mb10">说的挺有道理的</div>
								<div class="mlt-blog-pics fs0 clearfix mb15 row element" style="display: none;">
											<p class="col-xs-4"><img src="img/7.jpg"></p>
											<p class="col-xs-4"><img src="img/8.jpg" ></p>
											<p class="col-xs-4"><img src="img/1.jpg"></p>
								</div>
								<div class="mlt-blog-pics fs0 clearfix mb15 row element" style="display: none;">
											<p class="col-xs-4"><img src="img/5.jpg"></p>
											<p class="col-xs-4"><img src="img/6.jpg" ></p>
											<p class="col-xs-4"><img src="img/2.jpg"></p>
								</div>
								<div class="mlt-pics mb10 zoom">
										<img src="img/8.jpg" alt="">
										<div class="picnum"><i class="icon icon-picnum"></i>3张</div>
								</div>
								<div class="mb20">
									<a  class="sgkred" >展开</a>
								</div>
								<div class="mlt-meta clearfix">
									<div class="fl mlt-date">
										<span>刚刚</span>
									</div>
									<div class="fr mlt-opt">
										<a data-url="/actions/delete/buzz/RtDS4HyQxvEePnsMMnsNMC/-/buzzs/" class="delete">删除</a>
										<a href="javascript:;" class="like liked" data-id="RtDS4HyQxvEePnsMMnsNMC"><i class="icon icon-like2"></i><span>0</span></a>
										<a href="javascript:;" data-type="buzz" data-raw_id="RtDS4HyQxvEePnsMMnsNMC" data-fetchurl="/comments/fetch/buzz/RtDS4HyQxvEePnsMMnsNMC/" class="embedreply" onclick="embedReply(this);"><i class="icon icon-comments"></i><span>0</span></a>

									</div>
								</div>
							</div>
						</li>
                     </ul>
					<ul id="published" class="mine-list-type" style="display:none"></ul>
					<ul id="commented" class="mine-list-type" style="display:none"></ul>
					<img id="flying" style="float:left;margin-left:320px;margin-top:20px;" src="css/flying.gif" width="80" height="80" alt="flying" />
				</div>
			</div>
		</div>

		<script src="${APP_PATH}/commons/jquery/jquery.js"></script>
 		<script type="text/javascript" src="${APP_PATH}/commons/zoomify/zoomify.min.js" ></script>
		<script src="${APP_PATH}/commons/layui/layui.js"></script>
		<script type="text/javascript">
			$(function() {

				$("#info").mouseover(function () {
					$(this).parent().find(".x-menu").css("display","block")
                })
				$(".x-menu").mouseleave(function () {
					$(this).css("display","none")
                })

                //放大镜效果
                $("p.col-xs-4 img,.zoom img").zoomify()
                //展开和收起
                $(".sgkred").click(function(){
                	if($(this).html()=='展开'){
                		$(this).html('收起');
                	}else{
                		$(this).html('展开');
                	}
                	$(this).parent().parent().find('.zoom').slideToggle()
                	$(this).parent().parent().find('.element').slideToggle();
                	
                })
				$(".home-post-trigger, .home-postbox-btn .current").click(function() {
					$(".home-post-trigger").slideToggle();

					$(".home-post-form").slideToggle(function() {
						$(".home-post-form .t-autosize").focus()
					});
						$('#uploader div:eq(1)').attr('style',
				'position: absolute; top: 0px; left: 0px; width: 82px; height: 39px; overflow: hidden; bottom: auto; right: auto;');
				});
				$("#tab_activities").click(function() {
					$(this).addClass("current");
					$("#tab_published").removeClass("current");
					$("#tab_commented").removeClass("current");
					$("#tab_discoveries").removeClass("current");
					if(!$("#activities").html()) {
						$("#flying").show();
					}
					$("#activities").fadeIn();
					$("#published").fadeOut().html("");
					$("#discoveries").fadeOut().html("");
					$("#commented").fadeOut().html("")
				})
			});

			$(function () {
                layui.use('upload', function(){
                    var upload = layui.upload;
                    upload.render({
                        elem: '#uploader'
                        ,url: '/uploader'
                        ,multiple: true,
                        field:'uploadFiles'
                        ,before: function(obj){
                            //预读本地文件示例，不支持ie8
                            obj.preview(function(index, file, result){
                               $('#uploader-list').append('<li><img src="'+result+'"/><i class="icon icon-cross-round"></i></li>')
                            });
                        }
                        ,done: function(res){
                           if($('#uploader-list li').length>0){
                               $('#uploader-list').css('display','block')
						   }
                        }
                    });
                })
            })
		</script>
	</body>

</html>