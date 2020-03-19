<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>创作共享良品购</title>
    <meta name="keywords" content="良品购，购物分享，淘宝购物，网购推荐"/>
    <meta name="description" content="推荐最具人气的优质实惠单品"/>
    <link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.bak.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/nav-menus.css"/>
    <link href="${APP_PATH}/commons-css/shopping.002da7c8.css" rel="stylesheet"/>
    <script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js"></script>
</head>
<body style="height:100% !important;">
<jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>
<div id="content">
    <div class="layer layer-full">
        <div class="tube">
            <div class="block mb0">
                <div class="sh-rec clr" id="sh-rc">
                    <a name="woo-anchor"></a>
                    <h3> 积分兑换</h3>
                    <div class="ctg-menu-newhot l dymswitch-0">
                        <a class="woo-swa woo-cur" href="javascript:;" style="text-decoration: none;text-underline: non">日常</a>
                    </div>
                    <div class="pic_sect">
                        <ul>
                            <li>共${beans.resultTotal}个商品</li>
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
                                        <a target="_blank" class="a" href="javascript:void(null)">
                                                <img class="lazy" alt="X"
                                                     src="//localhost${item.picture}" height="224"/>

                                            <u style="margin-top:-224px;height:222px;"></u>
                                        </a>

                                    </div>
                                    <div class="wooscr">
                                        <div class="g" style="font-size: 14px;font-family: Microsoft Yahei, Sans GB,Helvetica Neue, Helvetica, tahoma, arial, Verdana, sans-serif, WenQuanYi Micro Hei, \5B8B\4F53">
                                                ${item.title}
                                        </div>
                                        <div class="d">
                                            <span style="float: left;display:inline;line-height: 19px; padding: 0 0 0 16px;margin: 0 8px 0 0;font-size: 13px;background-image: none !important;"><a onclick="score(${item.score},${item.id})" href="javascript:;" style="text-underline: none;text-decoration:none;cursor: pointer;color:#FF6664;">兑换</a></span>
                                            <a class="bl"
                                               href="javascript:void(null)"
                                               target="_blank"> <u class="_tb" title="去购买"> <b>${item.score}</b>积分 </u>
                                            </a>
                                        </div>
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
<script type="text/javascript">

    function score(score,id){
        var uid=$("#jane_id").val();
        if(!uid){
            alert("请先登录");
            return;
        }
        $.ajax({
            url:'/user/scores',
            type:'GET',
            dataType:"json",
            data:{
                uid:uid
            },success:function (data) {
                if(data.status==200){
                    var uscore=data.info;
                    if(score>uscore){
                        alert("用户积分不足");
                        return;
                    }
                    if(confirm("去定要兑换吗?")){
                        $.ajax({
                            url:'/score/consume',
                            type:'GET',
                            dataType:'json',
                            data:{
                                pid:id,
                                score:score,
                                uid:uid,
                            },success:function (data) {
                                if(data.status==200){
                                    alert("积分兑换成功,请用户赶快填写收货地址,等待收货");
                                }
                            }
                        })



                    }
                }
            }
        })
    }
    $(function () {
        function adjustProductStyleHight(results) {
            var height = 0;
            if (results <= 5) {
                height = 392;
            } else if (results <= 10) {
                height = 780;
            } else if (results <= 15) {
                height = 1136;
            } else {
                height = 1568;
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

        function init() {
            var pagetotal =${beans.pageTotal}
            var results =${beans.resultTotal}
            if (pagetotal == 1) {
                adjustProductStyleHight(results)
            }
        }
        init();

    })
</script>
</html>