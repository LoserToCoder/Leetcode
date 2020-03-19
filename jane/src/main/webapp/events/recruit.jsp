<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="征文活动">
		<meta name="keywords" content="征文活动">
		<title>活动|为更理想的生活</title>
		<link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
		<link rel="stylesheet" href="${APP_PATH}/events/css/recruit.css">
		<link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.css" />
		<link href="${APP_PATH}/commons-css/nav-menus.css" rel="stylesheet"/>

		<style>
			#dt-search form{
				width: 207px !important;
			}
			.ipt{
				line-height: 21px;
				padding: 0px 0px 0px 3px;
				font-size: 14px;
				width: 204px !important;
				height: 30px;
				line-height: 14px;
			}
		</style>
		<script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js"></script>
	</head>
	<body style="">
	    <jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>

		<div class="main-wrapper" >
			<!-- slide end -->
			<div class="main-list post-list clearfix">
				<!-- main left list start -->
				<div class="left-list">
					<c:if test="${beans.code!=200}">
						<div class="single-event clearfix">
							<div class="event-pic">
								<a href="#" target="_blank">
									<img src="images/phone_20180727201022_01.61_55752.jpg">
								</a>
							</div>
							<div class="event-infos">
								<p class="title">
									参与有福利/
									<a href="#" target="_blank">
										眼花缭乱的话费套餐，分享你正在用的那一个
									</a>
								</p>
								<p class="event-row">
									<strong>时间：</strong>2019-05-01~ 2019-06-29
								</p>
								<p class="event-excerpt">流量当道的时代，话费套餐越来越丰富，这次我们也邀请大家来分享自己正在用的、或是看重准备更换的话费套餐，说说具体内容和每月费用，说不定你的分享也将为其他人带来新思路。这次我们准备的奖品是麦当劳“大薯日”周边透明手袋一份。</p>

								<p class="join-count">
									<a href="javascript:void(null)" target="_blank">
										<i class="icon-comment"></i>
										去参与
									</a>
								</p>
								<p class="event-tag" style="background-color:  #E83237;">正在开始...</p>
							</div>
						</div>
						<div class="single-event clearfix">
							<div class="event-pic">
								<a href="#" target="_blank">
									<img src="images/valen_20180803200145_00.88_48040.jpg">
								</a>
							</div>
							<div class="event-infos">
								<p class="title">
									参与有福利/
									<a href="https://www.toodaylab.com/event/218" target="_blank">
										前辈们的忠告，这些礼物情人节的时候真的送不得
									</a>
								</p>
								<p class="event-row">
									<strong>时间：</strong>2019-01-01~ 2019-03-29
								</p>

								<p class="event-excerpt">七夕就要到来，相信很多同学们又要患上一年几度的“礼物选择困难症”了。虽然送礼的攻略一大把，但对症下药的功力还得靠时间积累。这次我们邀请大家来分享经验之谈，什么礼物送不得、什么礼物微笑接下内心却满是尴尬……以此让新手们在错误的道路上及时刹车。我们也将在评论中选出一位同学送出（可以直接转送的）礼物，大家加油……</p>
								<p class="join-count">

									<a href="javascript:void(null)" target="_blank">
										<i class="icon-comment"></i>
										去参与
									</a>
								</p>
								<p class="event-tag">已结束</p>
							</div>
						</div>
						<div class="single-event clearfix">
							<div class="event-pic">
								<a href="#" target="_blank">
									<img src="images/airline_20180720194931_00.jpeg">
								</a>
							</div>
							<div class="event-infos">
								<p class="title">
									评论有奖 /
									<a href="#" target="_blank">
										分享让你印象深刻的一次航旅经历，两份实验室礼包等你拿
									</a>
								</p>
								<p class="event-row">
									<strong>时间：</strong>2019-01-01~ 2019-02-29
								</p>
								<p class="event-excerpt">这一次以“航空”为主题，邀请大家分享让你印象深刻的航旅经历，同时也可以就此谈谈你对各大航司的看法。当然不只是常旅客，大家都可以参与进来，我们也将为两名同学送出实验室礼包一份。</p>
								<p class="join-count">
									<a href="javascript:void(null)" target="_blank">
										<i class="icon-comment"></i>
										去参与
									</a>
								</p>
								<p class="event-tag">已结束</p>
							</div>
						</div>
						<div class="load-more clearfix">
							<a class="next more" href="https://www.toodaylab.com/events/page/2"><span>下一页</span></a>
						</div>
					</c:if>
					<c:if test="${beans.code==200}">
						<c:forEach var="recruit" items="${beans.results}">
							<div class="single-event clearfix">
								<div class="event-pic">
									<a href="#" target="_blank">
										<img src="//localhost${recruit.cover}">
									</a>
								</div>
								<div class="event-infos">
									<p class="title">
										参与有福利/
										<a href="#" target="_blank">
											${recruit.theme}
										</a>
									</p>
									<p class="event-row">
										<strong>时间：</strong>${recruit.startTime}~${recruit.endTime}
									</p>
									<p class="event-excerpt">${recruit.desc}</p>


									<c:if test="${recruit.status==1}">
										<p class="join-count">
											<a id="${recruit.id}" class="recruit" style="text-decoration: none;cursor: pointer">
												<i class="icon-comment"></i>
												去参与
											</a>
										</p>
										<p class="event-tag" style="background-color:  #E83237;">正在开始...</p>
									</c:if>
									<c:if test="${recruit.status==2}">
										<p class="join-count">
											<a href="#">
												<i class="icon-comment"></i>
												已结束
											</a>
										</p>
										<p class="event-tag">已结束</p>
									</c:if>
								</div>
							</div>
						</c:forEach>
						<c:if test="${beans.resultTotal>10}">
							<div class="load-more clearfix">
								<a class="next more" href="https://www.toodaylab.com/events/page/2"><span>下一页</span></a>
							</div>
						</c:if>

					</c:if>

				</div>
				<div class="right-sidebar">
					<!-- most hot block start -->
					<div class="hot-block">
						<div class="hot-header">
							<h2><i class="icon-fire"></i> 最热</h2>
						</div>
						<div class="hot-list clearfix">

							<a href="/post/GjB_jWgBJ7edbEKlgxPA" target="_blank">
								<div class="hot-item odd">
									<span class="ranking hot">1</span>
									<p>《都挺好》苏明玉卷入原生家庭斗争是她活该！</p>
								</div>
							</a>

						
							<a href="/post/HDB_jWgBJ7edbEKlgxPZ">
								<div class="hot-item even">
									<span class="ranking ">2</span>
									<p>《都挺好》：一地鸡毛的生活里，亲情该何去何从</p>
								</div>
							</a>

							<a href="/post/hTB_jWgBJ7edbEKlThAF">
								<div class="hot-item odd">
									<span class="ranking ">3</span>
									<p>崔永元继续爆料，最可怕的事出现了！</p>
								</div>
							</a>

						</div>
					</div>
					<!-- most hot block end -->
				</div>
			</div>
		</div>
		<!-- start cnzz -->
		<div id="cnzz">
			<script src="aa.js" language="JavaScript"></script>
			<script src="bb.js" charset="utf-8" type="text/javascript"></script>
			<a href="#" target="_blank" title="站长统计">站长统计</a>
		</div>
	</body>
	<script type="text/javascript">
		$(function () {
			$(".recruit").click(function () {
                var recruitId = $(this).attr('id');
                var uid=$("#jane_id").val();
                if(!uid){
                    alert("请先登录");
                    return;
				}
				if(recruitId){
                    window.location.href='/recruit/join?id='+uid+"&recruitId="+recruitId;
				}
            })
        })
	</script>

</html>