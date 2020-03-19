<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta property="wb:webmaster" content="3bd1e36da79af84a"/>
    <title>创作共享良品导购</title>
    <meta name="keywords" content="良品购，购物分享，淘宝购物，网购推荐"/>
    <meta name="description" content="良品购频道，推荐最具人气的优质实惠单品"/>
    <link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.bak.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/nav-menus.css"/>
    <link href="${APP_PATH}/commons-css/shopping.002da7c8.css" rel="stylesheet"/>
    <style>
        .j .mbpho a img {
            width: 224px;
            background: url(/item/css/loading.gif) 50% no-repeat;
        }
        .put {
            border-radius: 2px;
            background: #F7F7F7;
            border: 1px solid #DDD;
            color: #666;
            background-color: #f7f7f7;
            background-repeat: repeat-x;
        }
    </style>
    <script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js"></script>
</head>
<body style="height:100% !important;">
<jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>
<div id="content">
    <div class="sh-catnav clr">
        <img class="sh-catnav-bg" src="${APP_PATH}/images/logo/bg.jpeg" height="400"/>
        <div class="sh-catnav-mask"></div>
        <div class="sh-catnav-inner">
            <div class="hsh-items">
                <ul>
                    <li class="hsh-item hsh-item0 acur" data-item="hsh-item1"><a href="javascript:switchCategory(0)"><i
                            class="item-icon item0-icon"></i><span>良品购</span><i class="icon-r"></i></a></li>
                    <li class="hsh-item hsh-item1" data-item="hsh-item1"><a href="javascript:switchCategory(1)" ><i
                            class="item-icon item1-icon"></i><span>上衣</span><i class="icon-r"></i></a></li>
                    <li class="hsh-item hsh-item2" data-item="hsh-item2"><a href="javascript:switchCategory(13)"><i
                            class="item-icon item2-icon"></i><span>裙裤</span><i class="icon-r"></i></a></li>
                    <li class="hsh-item hsh-item3" data-item="hsh-item3"><a href="javascript:switchCategory(24)"><i
                            class="item-icon item3-icon"></i><span>配饰</span><i class="icon-r"></i></a></li>
                    <li class="hsh-item hsh-item5" data-item="hsh-item5"><a href="javascript:switchCategory(41)"><i
                            class="item-icon item5-icon"></i><span>包袋</span><i class="icon-r"></i></a></li>
                    <li class="hsh-item hsh-item6" data-item="hsh-item6"><a href="javascript:switchCategory(51)"><i
                            class="item-icon item6-icon"></i><span>日杂</span><i class="icon-r"></i></a></li>
                    <li class="hsh-item hsh-item4" data-item="hsh-item4"><a href="/score/shop"><i
                            class="item-icon"></i><span>积分兑换</span><i class="icon-r"></i></a></li>
                </ul>
            </div>
            <div class="sh-detail">
                <ul class="clr">
                    <li class="de-lpg clr" style="display: block">
                        <p class="fst-p">阿良推荐</p>
                        <p><a class="red" href="/search/category?category=安妮陈">安妮陈</a></p>
                        <p><a href="/search/category?category=T恤">T恤</a></p>
                        <p><a href="/search/category?category=情侣装">情侣装</a></p>
                        <p><a href="/search/category?category=阔腿裤">阔腿裤</a></p>
                        <p><a href="/search/category?category=杯子">杯子</a></p>
                        <p><a class="red" href="/search/category?category=手机壳">手机壳</a></p>
                        <p class="fst-p">流行</p>
                        <p><a class="red" href="/search/category?category=卫衣">卫衣</a></p>
                        <p><a href="/search/category?category=锁骨链">锁骨链</a></p>
                        <p><a href="/search/category?category=长裙">长裙</a></p>
                        <p><a href="/search/category?category=针织衫">针织衫</a></p>
                        <p><a href="/search/category?category=风衣">风衣</a></p>
                        <p><a class="red" href="/search/category?category=复古包">复古包</a></p>
                    </li>
                </ul>
            </div>
            <div class="sh-r">
                <div id="dt-carousel">
                    <div class="dt-carousel-content clr" style="width: 400%;">
                        <div class="dt-carousel-item cur">
                            <a  href="#" class="dt-carousel-img"
                               data-src="//localhost:80/images/goods_details/174165/thumbox_list/596851d468f66-450.jpg"
                               style="background-image:url(//localhost:80/images/goods_details/174165/thumbox_list/596851d468f66-450.jpg)"></a>
                            <span class="dt-carousel-title"> <span
                                    class="dt-carousel-lstitle"> 显瘦技巧轻松get，身上肉肉的也不怕 </span> </span>
                        </div>
                        <div class="dt-carousel-item">
                            <a  href="#" class="dt-carousel-img"
                               data-src="/images/carousel/20161020165355_esrPS.thumb.512_320_c.jpeg"></a>
                            <span class="dt-carousel-title"> <span
                                    class="dt-carousel-lstitle"> 复古摆件，带你回到旧时光 </span> </span>
                        </div>
                        <div class="dt-carousel-item">
                            <a href="#" class="dt-carousel-img"
                               data-src="//localhost:80/images/goods_details/174082/thumbox_list/594e0243a2c02-450.jpg"></a>
                            <span class="dt-carousel-title"> <span
                                    class="dt-carousel-lstitle">沙滩上,一件连衣裙足矣</span> </span>
                        </div>
                        <div class="dt-carousel-item">
                            <a  href="#" class="dt-carousel-img"
                               data-src="/images/carousel/20161018115859_BzTKR.thumb.512_320_c.jpeg"></a>
                            <span class="dt-carousel-title"> <span
                                    class="dt-carousel-lstitle"> 少女的秘密—All about bra </span> </span>
                        </div>
                    </div>
                    <div class="dt-carousel-action-wrap">
                        <div class="dt-carousel-action-mask"></div>
                        <div class="dt-carousel-action clr">
                            <div class="dt-carousel-action-title">
                                <span class="dt-carousel-lstitle"> 显瘦技巧轻松get，身上肉肉的也不怕 </span>
                            </div>
                            <div class="dt-carousel-points">
                                <div class="dt-carousel-point cur"></div>
                                <div class="dt-carousel-point"></div>
                                <div class="dt-carousel-point"></div>
                                <div class="dt-carousel-point"></div>
                            </div>
                        </div>
                    </div>
                    <div class="dt-carousel-action-left">
                        <i></i>
                    </div>
                    <div class="dt-carousel-action-right">
                        <i></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="layer layer-full">
        <div class="tube">
            <div class="block mb0">
                <div class="sh-rec clr" id="sh-rc">
                    <a name="woo-anchor"></a>
                    <h3> 良品购 </h3>
                    <div class="ctg-menu-newhot l dymswitch-0">
                        <a class="woo-swa woo-cur" href="javascript:;">热门</a>
                    </div>
                    <div class="pic_sect">
                        <ul>
                            <li><a href="/search/filter?minPrice=0&maxPrice=100">0-100</a></li>
                            <li><a href="/search/filter?minPrice=100&maxPrice=200">100-200</a></li>
                            <li><a href="/search/filter?minPrice=200&maxPrice=500">200-500</a></li>
                            <li style="width: 260px;font-weight: 400">
                                价格:<input class="put" type="text" id="min_price" placeholder="  最低价格"
                                          style="width: 70px"/>
                                <span style="color: #ddd">~</span>
                                <input class="put" type="text" id="max_price" placeholder="  最高价格" style="width: 70px"/>
                                <span style="color: #ddd">￥</span>
                                <input class="put" type="button" id="filter" value="确定"
                                       style="width: 40px">
                                <input type="hidden" id="adjust" value="${beans.type}">

                            </li>
                            <c:if test="${beans.resultTotal<=30}">
                            <li>共${beans.resultTotal}个商品</li>
                            </c:if>
                            <c:if test="${beans.resultTotal>30}">
                                <li>共30个商品</li>
                            </c:if>
                            <li style="width: 1px"></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="woo-holder">
                <div class="woo-swb woo-cur" style="display: block;">
                    <div class="woo-tmpmasn woo-pcont stpics clr woo-masned"
                         style="position:relative;height:0;overflow:hidden;margin:0;padding:0;"></div>
                    <div class="woo-pcont stpics clr woo-masned" id="item_boxs" data-wootemp="4" data-totalunits="6655"
                         style="height: 1000px; position: relative; width: 1200px; visibility: visible;">
                        <c:forEach var="item" items="${beans.results}" varStatus="status">
                            <fmt:parseNumber var="i" integerOnly="true" value="${status.index/5}"/>
                            <div class="woo co${status.index%5}"
                                 style="top: ${i*392}px; left: ${status.index%5*244}px;">
                                <div class="j">
                                    <div class="mbpho" style="height:224px;">
                                        <a target="_blank" class="a" href="/item/${item.id}.html">
                                            <c:if test="${empty item.prefix}">
                                                <img class="lazy" alt="X"
                                                     data-echo="//localhost:80/images/goods_details/${item.pid}/${item.imgUrl}"
                                                     src="/item/css/blank.gif" height="224"/>
                                            </c:if>
                                            <c:if test="${not empty item.prefix}">
                                                <img class="lazy" alt="X"
                                                     data-echo="//localhost:80/images/goods/${item.prefix}/${item.pid}/${item.imgUrl}"
                                                     src="/item/css/blank.gif" height="224"/>
                                            </c:if>

                                            <u style="margin-top:-224px;height:222px;"></u>
                                        </a>

                                    </div>
                                    <div class="wooscr">
                                        <div class="g" style="font-size: 14px;font-family: Microsoft Yahei, Sans GB,Helvetica Neue, Helvetica, tahoma, arial, Verdana, sans-serif, WenQuanYi Micro Hei, \5B8B\4F53">
                                                ${item.title}
                                        </div>
                                        <div class="d">
                                            <span class="d1 ">${item.collections}</span>
                                            <span class="d2 ">${item.likes}</span>
                                            <a class="bl"
                                               href="javascript:void(null)"
                                               target="_blank"> <u class="_tb" title="去购买"> <b>￥${item.price}</b> </u>
                                            </a>
                                        </div>
                                        <ul>
                                            <li class="f">
                                                <a target="_blank" href="javascript:void(null)">
                                                    <img src="//localhost:80/images/user/${item.uid}/uuid${item.uid}.jpg"
                                                         width="24" height="24"/>
                                                </a>
                                                <p>
                                                    <span> 发布到&nbsp; <a target="_blank" href="javascript:void(null)">创作共享平台</a> </span>
                                                </p>
                                            </li>
                                            <!-- 三条评论 开始 -->
                                            <!-- 三条评论 结束 -->
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                        <div class="woo-pager" style="display: block; height: auto;">
                            <div class="woo-pbr woo-mpbr">
                                <ul class="woo-dib">
                                    <li class="woo-cur">1</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="win-house" class="h0"></div>
<script src="/item/js/shopping.ffc5895f.js"></script>
<div class="dt-side-combo"
     style="position: fixed; bottom: 2px; z-index: 10000; width: 48px; height: 142px; left: 55%; right: 10px; top: auto; margin-left: 612px; opacity: 1; display: none;">
    <div class="SG-sidecont">
        <div id="dt-side-combo">
            <a id="dt-backtotop" class="dt-backtotop" href="javascript:;">回到顶部</a>
            <a class="dt-report" href="javascript:void(null)"></a>
        </div>
    </div>
</div>
</div>
</body>
<script type="text/javascript" src="${APP_PATH}/commons/echo/echo.min.js"></script>
<script type="text/javascript">
    function switchCategory (cid) {
        if(cid==0){
            $("ul.clr li:visible").css('display','none');
            $("ul.clr li:first").css('display','block');
            return;
        }
        $.ajax({
                url: '/post/category',
                type: 'GET',
                dataType: 'json',
                data: {
                    cid: cid
                },
                success: function (data) {
                    if (data.status == 200) {
                        $("ul.clr li:visible").css('display','none');
                        fill(data.info)
                    }
                }
            })
    }
    function fill(data){
        var html='<li class="clr" style="display:block">';
        for(var i=0;i<data.length;i++){
            if(i%3==0){
                html+='<p><a class="red" href="/search/category?category='+data[i].name+'">'+data[i].name+'</a></p>'
            }else {
                html+='<p><a href="/search/category?category='+data[i].name+'">'+data[i].name+'</a></p>'
            }
        }
        html+='</li>';
        $("ul.clr").append(html)
    }
    $(function () {
        function adjustProductStyleHight(results) {
            var height = 0;
            if (results <= 5) {
                height = 392;
            } else if (results <= 10) {
                height = 784;
            } else if (results <= 15) {
                height = 1136;
            } else {
                var type=$("#adjust").val();
                if(type==5){
                    height=1799;
                }else{
                    height = 1568;
                }

            }
            $("#item_boxs").height(height)
        }
        $(window).scroll(function () {
            if ($(window).scrollTop() > 500)
                $(".dt-side-combo").css("display", "block")
            if ($(window).scrollTop() < 100)
                $(".dt-side-combo").css("display", "none")
        })
        $("#dt-backtotop").click(function () {
            $(window).scrollTop(0)
        })
        $("#filter").click(function () {
            var minPrice=$("#min_price").val();
            var maxPrice=$("#max_price").val();
            if(!minPrice||!maxPrice){
                alert("请至少输入一个价格范围")
                return;
            }
            var keyword=$("#kw").val();
            if(keyword){
                window.location.href='/search/filter?keyword='+keyword+'&minPrice='+minPrice+"&maxPrice="+maxPrice;
            }else{
                window.location.href='/search/filter?minPrice='+minPrice+"&maxPrice="+maxPrice;
            }
        })
        function init() {
            var pagetotal =
            ${beans.pageTotal}
            var results =
            ${beans.resultTotal}
            if (pagetotal == 1) {
                adjustProductStyleHight(results)
            }
            var keyword = "${beans.keyword}";
            $("#kw").val(keyword)
            Echo.init({
                offset: 0,
                throttle: 0
            });
        }
        init();
    })
</script>
</html>