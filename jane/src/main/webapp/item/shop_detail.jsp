<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <title>${item.title}</title>
    <meta content="在人群里非常醒目，搭配牛仔蓝/白色下装，好看又有活力，搭配高腰单品或是露出小蛮腰，就算是小个子的女生也能穿着大长腿 " name="Description">
    <meta content="“安妮陈”纯色个性下摆针织T恤" name="Keywords">
    <meta name="theme-color" content="#3ec0a3">
    <link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.bak.css"/>
    <link href="${APP_PATH}/commons-css/nav-menus.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${APP_PATH}/item/css/nuandao.css">
    <link rel="stylesheet" href="${APP_PATH}/item/css/article-pc.eb1068c5.css">
    <link rel="stylesheet" href="${APP_PATH}/item/css/starability-all.min.css"/>
    <style type="text/css">
        .container{
            margin-top: 30px;
        }
    </style>
    <script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js"></script>
</head>
<c:if test="${not empty item.prefix}">
    <c:set var="path" value="${item.pid}/thumbox_list"/>
</c:if>
<c:if test="${empty item.prefix}">
    <c:set var="path" value="${item.pid}"/>
</c:if>
<body class=" hPC">
<jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>
<!-- 商品主图以及主要信息展示区域 -->
<div class="container prop">
    <div class="crumbs">
        <a href="javascript:void(null)">${item.category}</a>
        <a href="javascript:void(null)">${item.subCategory}</a>
        <input type="hidden" id="pid" value="${item.id}">
    </div>
    <div class="prop-img">
        <div class="pr gpic">
            <div class="gpic_box clear img-show">
                <c:forEach varStatus="status" var="thumb" items="${item.thumbs}">
                      <c:if test="${status.index==0}">
                          <div class="jqzoom" id="wrap">
                              <div style="top:0px;z-index:9;position:relative;">
                                  <a rel="position: &#39;inside&#39; , showTitle: false, adjustX:0, adjustY:0" class="cloud-zoom"
                                     style="position: relative; display: block;">

                                      <img  title="${item.title}" alt="${item.title}"
                                            src="//localhost:80/images/goods_details/${path}/${thumb}" style="display: block;">

                                  </a>
                                  <div class="mousetrap"
                                       style="background-image:url(&quot;.&quot;);z-index:8;position:absolute;width:465px;height:465px;left:0px;top:0px;"></div>
                              </div>
                          </div>
                      </c:if>
                    <c:if test="${status.index!=0}">
                        <div class="jqzoom" style="display: none;" id="wrap">
                            <div style="top:0px;z-index:9;position:relative;">
                                <a rel="position: &#39;inside&#39; , showTitle: false, adjustX:0, adjustY:0" class="cloud-zoom"
                                   style="position: relative; display: block;">
                                    <c:if test="${not empty item.prefix}">
                                        <img  title="${item.title}" alt="${item.title}"
                                              src="//localhost:80/images/goods_details/${item.pid}/thumbox_list/${thumb}" style="display: block;">
                                    </c:if>
                                    <c:if test="${empty item.prefix}">
                                        <img  title="${item.title}" alt="${item.title}"
                                              src="//localhost:80/images/goods_details/${item.pid}/${thumb}" style="display: block;">
                                    </c:if>
                                </a>
                                <div class="mousetrap"
                                     style="background-image:url(&quot;.&quot;);z-index:8;position:absolute;width:465px;height:465px;left:0px;top:0px;"></div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <ul class="gpic_index clear" id="thumblist">

                <c:forEach var="thumb" items="${item.thumbs}" varStatus="status">
                    <c:if test="${status.index==0}">
                        <li class="gpic_li gpic_on"><img width="80" height="80" src="//localhost:80/images/goods_details/${path}/${thumb}" alt=""></li>
                    </c:if>
                    <c:if test="${status.index!=0}">
                        <li class="gpic_li"><img width="80" height="80" src="//localhost:80/images/goods_details/${path}/${thumb}" alt=""></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
    <!-- 商品主要信息展示区域 -->
    <div class="container-product">
        <dl class="prop-fields" id="pblock">
            <dd class="brand">
                <a href="javascript:void(null)">
                    <span class="inlineblock brands-title" style="margin-left: -15px">${item.title}</span></a>
            </dd>
            <dd class="price">
                <span id="pprice">优惠价:<span class="new pprice175127">¥${item.price}</span></span>
            </dd>
            <dd class="story">
                 ${item.desc}
            </dd>
            <hr style="margin-right: 36%;margin-top: 0px">
            <dd class="size"><label>规格</label>
                <div class="kuanshi">
                    <a href="javascript:void(0)" disable="0" subid="154411" id="sub154411">大 </a>
                    <a href="javascript:void(0)" disable="0" subid="154412" id="sub154412">中</a>
                    <a href="javascript:void(0)" disable="0" subid="154413" id="sub154413">小</a>
                    <span class="text-error" id="select-size-error"></span>
                </div>
            </dd>
            <hr style="margin-right: 36%;margin-top: 0px">
            <dd>
                <div style="float:left;height: 30px;padding-top: 5px;text-align: center">好评指数&nbsp&nbsp&nbsp</div>
                <div style="float:left;">
                    <fieldset class="starability-slot">
                        <input type="radio" id="rate5-2" name="rating" value="5" class="score" />
                        <label for="rate5-2" title="超好">5 stars</label>
                        <input type="radio" id="rate4-2" name="rating" value="4"  class="score" />
                        <label for="rate4-2" title="非常好">4 stars</label>
                        <input type="radio" id="rate3-2" name="rating" value="3"  class="score" />
                        <label for="rate3-2" title="中等">3 stars</label>
                        <input type="radio" id="rate2-2" name="rating" value="2"  class="score" />
                        <label for="rate2-2" title="不好">2 stars</label>
                        <input type="radio" id="rate1-2" name="rating" value="1"  class="score" />
                        <label for="rate1-2" title="糟糕">1 star</label>
                    </fieldset>
                    <input type="hidden" value="" id="score_id">
                    <input type="hidden" value="${item.title}" id="title">
                    <input type="hidden" value="${item.imgUrl}" id="imgurl">
                    <input type="hidden" value="${item.subCategory}" id="sub_category">
                    <input type="hidden" value="${item.category}" id="category">
                    <input type="hidden" value="" id="collected">
                    <input type="hidden" value="" id="liked">
                </div>
                <div style="height: 30px;padding-top: 5px" id="score_content">&nbsp&nbsp&nbsp8.3分&nbsp(41人参与评价)</div>
            </dd>
            <hr style="margin-right: 36%;margin-top: 0px">
            <div class="clearfix">
                <div class="btn-group btn-withloading">
                    <button class="goto" id="add-cart-now" disable="0">去购买</button>
                </div>
            </div>
        </dl>
    </div>
</div>
<!-- 产品故事，顾客评价，商品问答区域 -->
<%--<div class="label-header">
</div>--%>
<div id="content">
    <div class="pg-article-content">
        <section class="wrap-container">
            <section class="pg-article-detail">
                <section class="author">
                    <div class="author-wrap">
                        <a class="link" href="javascript:void(null)" target="_blank">
                            <img src="//localhost/images/user/172/uuid172.jpg">
                        </a>
                        <div class="author-info">
                            <a class="name"  target="_blank">
                                ~swenty~
                            </a>
                            <span class="create-at">${item.pubDate}</span>
                        </div>
                    </div>
                </section>
                <article class="article-detail"
                         data-author="~swenty~" data-original="1">
                    <c:if test="${empty item.scene}">
                        <h2>旅行清单，海岛必备好物推荐</h2>
                    </c:if>
                    <c:if test="${not empty item.scene}">
                        <h2>${item.scene}</h2>
                    </c:if>
                    <span class="visit-count">阅读量${item.viewCounts+1}次</span>
                    <c:if test="${empty item.content}">
                        <div class="blog-content">
                            <p>&nbsp;</p>
                            <p>最近几年海岛当仁不让地成为了度假首选。很多小仙女看到特价机票，朋友圈美图，都会心动不已，恨不得立马订机票说走就走。</p>
                            <figure  class="img-box">
                                <div class="img-padding"
                                     style="width: 100%; background-color: #f0f0f0;">
                                    <img src="//localhost:80/images/goods_details/175111/thumbox_list/5b331efe0fc83-450.jpg">
                                </div>
                            </figure>
                            <p>三四月份江浙沪的低温与阴雨天气持续如今未曾间断，周末的我终于还是按捺不住内心的躁动，抽上一个周末远离城市的时间，去塞班度过一个浪漫假期~</p>
                            <figure class="img-box">
                                <div class="img-padding"
                                     style="width: 500px;">
                                    <img src="//localhost:80/images/goods_details/175111/thumbox_list/5b331efe0fc83-450.jpg">
                                </div>
                            </figure>
                            <p>&nbsp;去海边度假，行头一定要备好；而去往海岛，作为一枚爱好旅游的海岛狂热爱好者，给大家推荐一些海岛必备好物吧：</p>
                            <p>（1）各种漂亮的裙纸和配饰：海岛度假衣服要带够，助攻海岛LOOK的配饰也要提前准备好；&nbsp;纯色系和大印花系的长裙，甜美碎花，一字肩领或是清新花边的度假短裙，搭配大檐帽，墨镜，夸张的耳环，风车花束，发带花环，网红防晒罩衫，各种显色口红，罗马风或者民族风的绑带鞋或拖鞋，藤编包，都非常适合度假的哇；</p>

                            <p>（2）防晒霜：去海岛，一定要严格防晒，推荐要防晒指数90以上的防晒，下水以后搭配面膜和芦荟胶涂抹，防晒效果会更好哦；</p>
                            <p>（3）游玩的时候搭配各种网红ins风十足的浮排，游泳圈，整个度假风就凸显的更加淋漓尽致啦；</p>

                            <p>（4）浮潜：虽说一般地方都有租用浮潜三宝（呼吸管，潜水面镜，脚蹼）的地方，但是有洁癖的宝宝建议还是自备为好；</p>
                            <p>&nbsp;</p>
                            <p>（5）海岛度假其实很容易出状况，有不少间接被炎热的天气制造出来的尴尬，驱蚊水，阻门器，常用药品都可以准备一些啦；</p>

                            <p>而有时候精心挑好的海岛行程和泳衣，却半路被大姨妈拦住了道，这时候带上棉条就超级实用了；推荐你们高洁丝的这款卫生棉条，堪称是我用过最好用也最容易上手的卫生棉条了；</p>
                            <p>&nbsp;</p>
                            <p>高洁丝这款棉条首先吸引我的点是澳洲进口棉芯，材质非常柔软，一点也不会刺激皮肤，就算是敏感肌的妹纸也同样适用~</p>
                            <p>很多小伙伴们会担心不知道怎么使用，其实使用起来非常简单。首先使用前先洗净手，沿着小包装的箭头撕开，将导管尾部向后拉到底，听到“咔哒”一声，选择一个舒服的姿势，像推注射器一样，轻轻一推就可以啦。而且吸收后也不会变形，无感拉出这一点简直了。</p>
                            <p>&nbsp;</p>
                            <p>小小一只口红大小的棉条不仅卫生而且携带也特别方便，放在包里也不占位置。我已经囤了好多，无论是游泳，潜水还是温泉，生理期也不会打乱我的节奏，都可以自由进行水下活动啦！</p>
                            <p>小tip：</p>
                            <p>棉条一定要注意选好尺寸，一般分为普通流量和大流量型这些尺寸决定了吸收量，普通流量的相当于1~2片卫生巾(日用240)的吸收量，大流量的相当于1~2片（日/夜用280）的吸收量。建议新手宝宝们可以先选择普通流量，更好上手一些哦~</p>
                            <p>&nbsp;</p>
                        </div>
                    </c:if>
                    <c:if test="${not empty item.content}">
                    <div class="blog-content">
                        ${item.content}
                    </div>
                    </c:if>
                </article>
                <section class="operate-wrap">
                    <a class="operate-item like" href="javascript:;" id="likes">
                        <i class="icon-praise"></i>
                        <span id="item-likes">${item.likes}</span>
                    </a>
                    <%--<a class="operate-item comment" id="comment">
                        <i class="icon-comment"></i>评论
                    </a>--%>
                    <a class="operate-item collection" href="javascript:;" id="collection">
                        <i class="icon-collection"></i>
                        <span id="item-collection">${item.collections}</span>
                    </a>
                    <div class="comment-wrap">
                    </div>
                </section>
            </section>
           <%-- <div id="pg-bottom-comment"  class="comment-wrap" style="height: 152px;display: none">

                <div class="bottom-comment-content">
                    <span>回复</span>
                    <textarea name="comment" id="operate-comment" cols="80" rows="2" placeholder="说些什么吧..."></textarea>
                </div>
                <div class="bottom-comment-button">
                    <div class="bottom-comment-photo">
                        <input id="choose-photo" type="file" accept="image/*" style="display:none">
                    </div>
                    <div class="bottom-comment-submit">
                        <a href="javascript:;" class="comment-cancel">取消</a>
                        <a href="javascript:;" class="comment-submit">发送</a>
                    </div>
                </div>
            </div>
            <div id="pg-comment-all" class="md-pc-comment">
                <div class="cmt-normal-comment">
                    <div class="cmt-title">
                        <span>所有评论</span>
                    </div>
                    <div class="cmt-list">
                        <ul>

                            <li class="cmt clr" data-cid="20825107" data-sid="19155582" data-type="10"
                                data-subjectid="724123" data-sname="瑞塔莎" data-rcount="0">
                                <div class="line-split-h"></div>
                                <a href="https://www.duitang.com/people/?user_id=19155582" class="sender-avatar"
                                   target="_blank">
                                    <img class="circle-icon" src="./旅行清单，海岛必备好物推荐 - 堆糖_files/20190227195407_zTmZ3.jpeg">
                                </a>
                                <div class="cmt-r">
                                    <div class="cmt-r-info clr">
                                        <a class="cmt-r-name" href="https://www.duitang.com/people/?user_id=19155582"
                                           target="_blank">瑞塔莎</a>
                                        <span class="cmt-r-time">3月22日 10:37</span>
                                    </div>
                                    <div class="commont-data">
                                        <div class="cmt-box">
                                            <p class="cmt-maincont">
                                                刚好发愁游泳时姨妈来怎么办呢，这篇文章太有用了。已购买
                                            </p>
                                            <div class="cmt-r-item-ft clr">
                                                <div class="cmt-r-item-pos">
                                                    <span class="cmt-like" data-likeid="20824883">
                                                        <i class="l icon"></i>
                                                        <em>0</em>
                                                    </span>
                                                    <span class="cmt-reply-btn">
                                                        <em>回复</em>
                                                    </span>
                                                    <span class="cmt-delete-btn cmt-dn">
                                                      <em>删除</em>
                                                    </span>
                                                    <span class="r c-more"></span>
                                                </div>
                                            </div>
                                            <div class="reply-box">
                                                <div class="comment-input-in cmt-dn">
                                                    <textarea placeholder="说些什么吧"></textarea>
                                                    <div class="comment-send-btn-wrap">
                                                        <a class="comment-send-btn" href="javascript:;">发送</a>
                                                        <a class="comment-send-cancel" href="javascript:;">取消</a>
                                                    </div>
                                                </div>
                                                <div class="reply-box-in">
                                                    <div class="cmt-r-item-answer clr" data-rid="10286127" data-sid="14221670" data-sname="堆糖Class小助手">
                                                        <a class="cmt-r-item-name" href="/people/?user_id=14221670" target="_blank">
                                                            堆糖Class小助手
                                                            <em><i class="cmt-author">作者</i></em>
                                                        </a>
                                                        <i>：</i><span class="cmt-replycont">超可爱～</span>
                                                        <div class="cmt-r-operate-wrap">
                                                            <div class="cmt-reply-time">25天前</div>
                                                            <div class="cmt-in-reply cmt-dn"><a href="javascript:;">回复</a></div>
                                                        </div>
                                                        <div class="comment-input-in reply-input-in cmt-dn">
                                                            <textarea placeholder="说些什么吧"></textarea>
                                                            <div class="comment-send-btn-wrap">
                                                                <a class="comment-send-btn" href="javascript:;">发送</a>
                                                                <a class="comment-send-cancel" href="javascript:;">取消</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <p class="cmt-r-item-find cmt-dn">
                                                    <a href="javascript:;">查看全部回复</a>
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                        <div class="cmt-zero cmt-dn">
                            <a href="javascript:;">你也来说些什么吧</a>
                        </div>
                    </div>
                </div>
            </div>--%>
        </section>
        <aside class="wrap-siderbar">
            <section class="related-article">
                <span class="title">你可能感兴趣的商品</span>

                <ul class="article-list" id="recommend-list">
                    <li class="article-item" data-href="/article/?id=696035">
                        <a href="https://www.duitang.com/article/?id=696035" target="_blank">
                            <img src="//localhost/images/goods_details/170249/thumbox_list/579c283702eba-450.jpg">
                            <div class="related-info">
                                <p class="article-title">年终大盘点｜旅途私藏，那些不可缺少的神器好物</p>
                                <p class="article-data">
                                    <span class="read">阅读 36864 </span>
                                    <span> 收藏 6</span>
                                </p>
                            </div>
                        </a>
                    </li>
                    <li class="article-item">
                        <a href="https://www.duitang.com/article/?id=521494" target="_blank">
                            <img src="//localhost/images/goods_details/170253/thumbox_list/579c61766d6b1-450.jpg">
                            <div class="related-info">
                                <p class="article-title">推荐一款旅行必备好物</p>
                                <p class="article-data">
                                    <span class="read">阅读 5 </span>
                                    <span> 收藏 3</span>
                                </p>
                            </div>
                        </a>
                    </li>
                    <li class="article-item" data-href="/article/?id=395048">
                        <a href="https://www.duitang.com/article/?id=395048" target="_blank">
                            <img src="//localhost/images/goods_details/172027/thumbox_list/58115ea0a2b74-450.jpg">
                            <div class="related-info">
                                <p class="article-title">好物｜冬季出游，好鞋比好天气更重要</p>
                                <p class="article-data">
                                    <span class="read">阅读 82427 </span>
                                    <span> 收藏 477</span>
                                </p>
                            </div>
                        </a>
                    </li>
                    <li class="article-item" data-href="/article/?id=423696">
                        <a href="https://www.duitang.com/article/?id=423696" target="_blank">
                            <img src="//localhost/images/goods_details/174099/thumbox_list/594e2394a1f2b-450.jpg">
                            <div class="related-info">
                                <p class="article-title">好物 | 海岛游好伙伴—防水背包陪你跳下水</p>
                                <p class="article-data">
                                    <span class="read">阅读 10853 </span>
                                    <span> 收藏 138</span>
                                </p>
                            </div>
                        </a>
                    </li>
                </ul>
            </section>
            <section class="wangmai-ad-wrap" style="margin-bottom: 20px;">
                <div id="_so_pcBy_0"></div>
            </section>
        </aside>
    </div>
</div>
<div class="dt-side-combo"
     style="position: fixed; bottom: 80px; z-index: 10000; width: 44px; height: 44px; left: 50%; right: 10px; top: auto; margin-left: 612px; opacity: 1; display: block;">
    <div class="SG-sidecont">
        <div id="dt-side-combo">
            <a id="dt-backtotop" class="dt-backtotop" href="javascript:;"></a>
        </div>
    </div>
</div>
<script type="text/javascript">

    $(function () {
        setTimeout(function () {
            var uid=$("#jane_id").val();
            if(!uid){
                $("input.score").attr("disabled","disabled");
                return;
            }
            $.ajax({
                url:'/item/user/star',
                type:'GET',
                dataType:'json',
                data:{
                    uid:$("#jane_id").val(),
                    pid:$("#pid").val()
                },
                success:function (data) {
                    if(data.status==200){
                        $("#score_id").val(data.info)
                        $("input.score").attr("disabled","disabled")
                    }
                }
            })
        },500)
        function loadStarScore(){
                $.ajax({
                    url:'/item/score/star',
                    type:'GET',
                    dataType:'json',
                    data:{
                        pid:$("#pid").val()
                    },
                    success:function (data) {
                        if(data.status==200){
                            var html="";
                            var counts=data.info.counts;
                            var average=data.info.average;
                            if(counts==0){
                                html="&nbsp&nbsp&nbsp0分&nbsp(0人参与评价)";
                            }else{
                                html="&nbsp&nbsp&nbsp"+average+"分&nbsp("+counts+"人参与评价)";
                                var stars=Math.floor(average/2);
                                $("#rate"+stars+"-2").prop("checked",true);
                            }
                            $("#score_content").html(html)
                        }
                    }
                })
            }
        loadStarScore();
        $(".score").click(function () {
            var score_id = $("#score_id").val();
            var uid=$("#jane_id").val();
            if(!score_id&&uid){
               var score=$(this).val()*2;
               $.ajax({
                   url:'/item/score/add',
                   type:'GET',
                   dataType:'json',
                   data:{
                       pid:$("#pid").val(),
                       uid:uid,
                       score:score
                   },
                   success:function (data) {
                       if(data.status==200){
                           $("input.score").prop("checked",false);
                           loadStarScore();
                           $("#score_id").val(data.info);
                           $("input.score").attr("disabled","disabled");
                       }else{
                           alert(data.msg)
                       }
                   }
               })
            }
        })
        $("#likes").click(function () {
            var pid=$("#pid").val();
            var liked=$("#liked").val();
            if(liked){
                alert("已经点赞过");
                return;
            }
           /* var uid=$("#jane_id").val();*/
            $.ajax({
                url:'/item/update',
                type:'GET',
                dataType:'json',
                data:{
                    pid:pid,
                    type:'likes'
                },
                success:function (data) {
                    if(data.status==200){
                        var likes=parseInt($("#item-likes").html());
                        $("#item-likes").html(likes+1);
                        $("#liked").val(1);
                    }
                }
            })

        })
        $("#collection").click(function () {
            var pid=$("#pid").val();
            var uid=$("#jane_id").val();
            var collected=$("#collected").val();
            if(collected){
                alert("已经收藏");
                return;
            }
            if(!uid){
                alert("请先登录");
                return;
            }
            $.ajax({
                url:'/item/collection',
                type:'GET',
                dataType:'json',
                data:{
                    entityId:pid,
                    title:$("#title").val(),
                    uid:uid
                },
                success:function (data) {
                    if(data.status==200){
                        var collection=parseInt($("#item-collection").html());
                        $("#item-collection").html(collection+1);
                        $("#collected").val(1);
                        if(data.info!=1){
                            console.log("收藏失败");
                        }
                    }
                }
            })

        })

        var random = Math.random() * 100 + "";
        var nums=parseInt(random);
        var category = "";
        if(nums%2==1){
            category=$("#category").val();
        }else{
            category=$("#sub_category").val();
        }
        $.ajax({
            url:'/item/recommends',
            type:'GET',
            dataType:'json',
            data:{
                category:category
            },
            success:function (data) {
                if(data.status==200){
                    html = "";
                    results=data.info;
                    for(var i=0;i<data.info.length;i++){
                        if(results[i].prefix){
                            html+='<li class="article-item"><a href="/item/'+results[i].id+'.html">';
                            html+=' <img src="//localhost/images/goods/'+results[i].prefix+'/'+results[i].pid+'/'+results[i].imgUrl+'">';
                            html+='<div class="related-info"><p class="article-title">好物|'+results[i].title+'</p>';
                            html+=' <p class="article-data"><span class="read">阅读'+results[i].views+'</span><span> 收藏'+results[i].collections+'</span></p></div></a></li>'
                        }else{
                            html+='<li class="article-item"><a href="/item/'+results[i].id+'.html">';
                            html+=' <img src="//localhost/images/goods_details/'+results[i].pid+'/'+results[i].imgUrl+'">';
                            html+='<div class="related-info"><p class="article-title">好物|'+results[i].title+'</p>';
                            html+=' <p class="article-data"><span class="read">阅读'+results[i].views+'</span><span> 收藏'+results[i].collections+'</span></p></div></a></li>'
                        }
                    }
                    $("#recommend-list").html(html);

                }
            }
        })
        var uid=$("#jane_id").val();
        if(uid){
            $.ajax({
                url:"/user/collection",
                type:'GET',
                dataType:'json',
                data:{
                    pid:$("#pid").val(),
                    uid:uid
                },
                success:function (data) {
                    if(data.status==200){
                        $("#collected").val(1);
                    }
                }
            })
        }
    })
    $(function () {
        $('.kuanshi-tog-switch').click(function () {
            if ($(this).hasClass('on')) {
                $(this).removeClass('on')
            } else {
                $(this).addClass('on');
            }
            ;
            $('.kuanshi-tog').slideToggle();
        });
        $('.kuanshi a').each(function () {
            if ($(this).hasClass('on')) {
                kuanshi = $('.kuanshi a').index(this);
                if (!$('.kuanshi-tog-switch').hasClass('on')) {
                    if (kuanshi >= 12) {
                        $('.kuanshi-tog-switch').trigger('click');
                    }
                }

            }
        });
        // 商品４个大图点击轮回
        $("#thumblist li.gpic_li").click(function () {
            if($(this).hasClass('gpic_on'))
                return
            $(this).addClass('gpic_on').siblings().removeClass("gpic_on")
            $(".gpic_box .jqzoom").eq($(this).index()).show().siblings().hide()
        })

       /* $('.gpic_index').find('li').click(function () {
            $(this).addClass('gpic_on').siblings().removeClass('gpic_on');
            $('.gpic_box').find('div.jqzoom').eq($('.gpic_index').find('li').index(this)).show().siblings().hide();
        });*/

        $("#comment").click(function () {
            $("#pg-bottom-comment").slideToggle();
        })
        $(".cmt-reply-btn").click(function () {
              $(this).parent().parent().next(".reply-box").find(".comment-input-in").removeClass("cmt-dn");
        })
        $(".cmt-like .icon").click(function () {
            var praise=parseInt($(this).next("em").html());
            $(this).next("em").html(praise+1);
            $(this).parent(".cmt-like").addClass("active");
        })
        $(".comment-cancel").click(function () {
            $("#pg-bottom-comment").slideToggle();
        })
        $(".comment-send-cancel").click(function () {
            $(this).parent().parent().addClass("cmt-dn");
        })
        $(".reply-box-in").mouseover(function () {
            $(this).find(".cmt-in-reply").removeClass("cmt-dn")
        })
        $(".cmt-in-reply").click(function () {
            $(this).parent().next(".reply-input-in").removeClass("cmt-dn")
        })
    })
    $(function () {
        var pid=$("#pid").val();
        if(!pid)
            return
        $.ajax({
            url:'/item/update',
            type:'GET',
            dataType:'json',
            data:{
                pid:pid,
                type:'view_counts'
            },
            success:function (data) {
                console.log(data)
            }
        })
    })
</script>
</body>

</html>