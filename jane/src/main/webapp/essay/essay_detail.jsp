<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
    <title>${post.info.title}</title>
    <link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" media="all" href="${APP_PATH}/essay/css/web-d8f364aa94534f48835a.css">
    <link rel="stylesheet" media="all" href="${APP_PATH}/essay/css/entry-aa75deb505b1b600256a.css">
    <link rel="stylesheet" media="all" href="${APP_PATH}/essay/css/custom.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.css"/>
    <link href="${APP_PATH}/commons-css/nav-menus.css" rel="stylesheet"/>
    <style type="text/css">
        .sub-comment div.v-tooltip-container div a, .sub-comment div.v-tooltip-container div a:active,
        .sub-comment div.v-tooltip-container div a:visited {
            color: #2f2f2f !important;
            text-decoration: none !important;
            text-underline: none !important;
        }
        .image-package p img{
            width: 100%;
        }
        .comment-wrap .tool-group a:hover{
        text-decoration: none  !important;
        }
    </style>

    <script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js"></script>
</head>
<body lang="zh-CN" class="reader-black-font">
<jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>
<div class="note">
    <div class="post">
        <div class="article">
            <h1 class="title">${post.info.title}</h1>
            <!-- 作者区域 -->
            <div class="author">
                <a class="avatar" href="javascript:void(null)">
                    <img  src="//localhost:80/images/user/${post.info.id}/uuid${post.info.id}.jpg" alt="96">
                </a>
                <div class="info">
                    <!-- 关注用户按钮 -->
                    <input type="hidden" id="title" value="${post.info.title}">
                    <input type="hidden" id="userid" value="${post.info.id}">
                    <input type="hidden" id="articleId" value="${post.info.articleId}"/>
                    <input type="hidden" id="isFocus"/>
                    <input type="hidden" id="isLikes">
                    <a class="btn btn-success follow" id="focus" style="height: 20px;float: none;background-color: #42c02e !important;"><i
                            class="iconfont ic-follow"></i><span>关注</span></a>
                    <!-- 文章数据信息 -->
                    <div class="meta" style="font-size: 16px;color: #2f2f2f">
                        <!-- 如果文章更新时间大于发布时间，那么使用 tooltip 显示更新时间 -->
                        <span class="publish-time">${post.info.pubDate}</span>
                        <span class="views-count">阅读 ${post.info.viewCounts+1}</span>
                       <%-- <span class="comments-count">评论 ${post.info.commentCounts}</span>--%>
                        <span class="likes-count">喜欢  ${post.info.likes}</span></div>
                </div>
                <!-- 如果是当前作者，加入编辑按钮 -->
            </div>

            <!-- 文章内容 -->
            <div data-note-content="" class="show-content">
                <div class="show-content-free">
                    ${post.info.html}
                </div>
            </div>
        </div>

        <!-- 如果是付费文章，未购买，则显示购买按钮 -->

        <!-- 连载目录项 -->

        <!-- 如果是付费文章 -->
        <!-- 如果是付费连载，已购买，且作者允许赞赏，则显示付费信息和赞赏 -->
        <div id="free-reward-panel" class="support-author"><p>喜欢我，请点赞；很喜欢，就赏我，感恩有你！</p>
            <div class="btn btn-pay" style="float: none">赞赏支持</div>
            <div class="supporter">
                <ul class="support-list"></ul> <!----></div>
            <section class="v-modal-wrap reward-note-modal" style="display: none">
                <div class="v-modal-mask"></div>
                <div class="v-modal">
                    <!--
                       v-modal 的图层在页面上,且页面是透明的,
                      通过设置z-index使得v-modal 和页面不在一个图层上,就不会再出现穿插的问题
                     -->
                    <a class="close">×</a>
                    <main>
                        <form target="_blank" class="new_reward">
                            <div class="reward-intro"><a class="avatar"><img
                                    src="https://upload.jianshu.io/users/upload_avatars/15883738/9026595f-478d-4371-a5b3-e785f7dc85e3.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/261/h/261/format/webp"></a>
                                <span class="intro">给作者点奖励,就当是送糖果给作者了</span> <i class="iconfont ic-candy"></i></div>
                            <div class="main-inputs">
                                <div class="amount-group"><input id="option1" type="radio" value="2"> <label
                                        for="option1" class="option"><i class="iconfont ic-candy"></i> <span
                                        class="amount">2</span> <span class="piece">¥</span></label> <input id="option2"
                                                                                                            type="radio"
                                                                                                            value="5">
                                    <label for="option2" class="option"><i class="iconfont ic-candy"></i> <span
                                            class="amount">5</span> <span class="piece">¥</span></label> <input
                                            id="option3" type="radio" value="10"> <label for="option3" class="option"><i
                                            class="iconfont ic-candy"></i> <span class="amount">10</span> <span
                                            class="piece">¥</span></label> <input id="option4" type="radio" value="20">
                                    <label for="option4" class="option"><i class="iconfont ic-candy"></i> <span
                                            class="amount">20</span> <span class="piece">¥</span></label> <input
                                            id="option5" type="radio" value="50"> <label for="option5" class="option"><i
                                            class="iconfont ic-candy"></i> <span class="amount">50</span> <span
                                            class="piece">¥</span></label> <input id="custom-option" type="radio"
                                                                                  class="custom-amount"> <label
                                            for="custom-option" class="option"><span class="custom-text">自定义</span>
                                        <div class="custom-amount-input"><i class="iconfont ic-candy"></i> <input
                                                type="number"
                                                oninput="value = parseInt(Math.min(Math.max(value, 0), 10000), 10)">
                                            <span class="piece">¥</span></div>
                                    </label></div>
                                <!--此处注释掉给作者留言的功能
                                 <div class="message"><textarea placeholder="给Ta留言…"></textarea></div>
                                -->
                            </div>
                            <div class="reward-info"><span class="amount">￥2</span> <!----></div>
                            <div class="choose-pay" style="">
                                <input id="method1" type="radio" name="pay-method"
                                       value="wx_pub_qr">
                                <label for="method1" class="option">
                                    <img src="/essay/payway/wechat-b876a8446e11c13deb9f7c04093d5369.png" class="day wechat">
                                    <img src="/essay/payway/wechat_night-c47e4c033673b27a6a94db7535dd69e6.png"
                                         class="night wechat">
                                </label> <input id="method2" type="radio" name="pay-method" value="alipay">
                                <label for="method2" class="option">
                                    <img src="/essay/payway/alipay-819dd0110c4f574b52bf4d193de5b0f5.png" class="day alipay">
                                    <img src="/essay/payway/alipay_night-d4b239a001224e8620390df2deed1c75.png"
                                         class="night alipay">
                                </label>
                            </div>
                        </form>

                        <!--在确认支付之前  <div class="wx-qr-code" style="display:none"></div>-->
                        <div class="wx-qr-code" style="display:none"><h3>微信扫码支付</h3>
                            <div class="qr-code" title="weixin://wxpay/bizpayurl?pr=P5IBm1k">
                                <canvas width="200" height="200" style="display: none;"></canvas>
                                <img alt="Scan me!"
                                     src=""
                                     style="display: block;"></div>
                            <div class="pay-amount">赞赏金额:<span>￥2</span></div>
                        </div>
                        <div class="btn btn-pay">立即支付</div>
                        <!--当二维码出现时,下面的立即支付 <div class="btn btn-pay" style="display:none"></div>-->
                    </main>
                </div>
            </section>
        </div>
        <div style="color: #2f2f2f">
            <div id="comment-list" class="comment-list">
                <div>
                    <form class="new-comment">
                        <a class="avatar"><img src="/images/default_avatar.png"></a>
                        <textarea placeholder="写下你的评论..." id="post-content"></textarea>
                        <div class="write-function-block">
                            <a class="btn btn-send" id="post-comment">发送</a>
                           <%-- <a class="cancel">取消</a>--%>
                        </div>
                    </form>
                    <!---->
                </div>
                <div id="featured-comment-list">
                    <div class="top-title"><span id="comment-total"></span></div>
                </div>
                <div class="comments-placeholder" style="display: none;">
                    <div class="author">
                        <div class="avatar"></div>
                        <div class="info">
                            <div class="name"></div>
                            <div class="meta"></div>
                        </div>
                    </div>
                    <div class="text"></div>
                    <div class="text animation-delay"></div>
                    <div class="tool-group"><i class="iconfont ic-zan-active"></i>
                        <div class="zan"></div>
                        <i class="iconfont ic-list-comments"></i>
                        <div class="zan"></div>
                    </div>
                </div>


               <%--
               分页
               <div>
                    <ul class="pagination">
                        <li>
                            <a>上一页</a>
                        </li>
                        <li>
                            <a>1</a>
                        </li>
                        <li>
                            <a href="javascript:void(null)" class="active">2</a>
                        </li>
                        <li>
                            <a>3</a>
                        </li>
                        <li>
                            <a>4</a>
                        </li>
                        <li>
                            <a>5</a>
                        </li>
                        <li>
                            <a>下一页</a>
                        </li>
                    </ul>
                </div>
                --%>
            </div>
        </div>
    </div>

    <div class="side-tool">
        <ul>
            <li data-placement="left" data-toggle="tooltip" data-container="body" data-original-title="回到顶部" style="">
                <a class="function-button" title="回到顶部"><i class="iconfont ic-backtop" title="回到顶部"></i></a>
            </li>
            <li data-placement="left" data-toggle="tooltip" style="display: block"  id="collection" data-container="body" data-original-title="收藏文章">
                <a class="function-button"><i class="iconfont ic-mark"></i></a>
            </li>
            <li data-placement="left" data-toggle="tooltip" data-container="body" data-original-title="收藏文章">
                <a class="function-button" id="cancel" style="display: none" title="收藏"><i class="iconfont ic-mark-active" title="收藏"></i></a>
            </li>
            <li data-placement="left" data-toggle="tooltip" data-container="body" data-original-title="喜欢文章"
                aria-describedby="tooltip830886">
                <a class="function-button" id="likes"><i class="iconfont ic-like-active"></i></a>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript">
    /*function addReply(id) {
        if($("#comment-"+id).find(".sub-comment-list .sub-comment").length==0){
            $("#comment-"+id).find(".sub-comment-list").toggle();
        }
        $("#comment-"+id).find(".sub-comment-list div:last-child").toggle()
    }*/
    function Popreply(commentId) {
        var html=' <div><form class="new-comment"><textarea id="reply-'+commentId+'" placeholder="写下你的评论..."></textarea><div class="write-function-block">'
        html+='<a class="btn btn-send" onclick="sub_reply('+commentId+')">发送</a></div></form></div>'
        $("#comment-"+commentId+" .sub-comment-list").append(html)
    }
    function addComment(comment){
        var html="";
        html+='<div id="comment-'+comment.id+'" class="comment">';
        html+='<div><div class="author"><div  class="v-tooltip-container" style="z-index: 0;">';
        html+='<div class="v-tooltip-content"><a href="javascript:void(null)" class="avatar">';
        html+='<img src="//localhost:80/images/user/'+comment.uid+'/uuid'+comment.uid+'.jpg"></a></div></div>';
        html+='<div class="info"><a href="javascript:"';
        html+='class="name">'+$("#jane_name").val()+'</a><div class="meta"><span>'+comment.commentTime+'</span></div>';
        html+='</div></div><div class="comment-wrap"><p>'+comment.content+'</p><div class="tool-group">';
        html+='<a onclick="Popreply('+comment.id+')"><i class="iconfont ic-comment"></i><span>回复</span></a>';
        html+='<a onclick="spread('+comment.id+')" id="spread-'+comment.id+'"><i class="iconfont"></i> <span>展开</span></a></div></div></div>';
        html+='<div class="sub-comment-list"></div>'
        $("#featured-comment-list").append(html);
    }
    function fillReply(commentId,content) {
        $("#comment-"+commentId+" .sub-comment-list").append(content)
    }
    function nest_reply(subcommentId,nickname) {
        var html=' <div><form class="new-comment"><textarea id="reply-'+subcommentId+'" placeholder="写下你的评论..."></textarea><div class="write-function-block">'
        html+='<a class="btn btn-send" onclick="sub_reply('+subcommentId+')">发送</a></div></form></div>'
        $("#comment-"+commentId+" .sub-comment-list").append(html)
        $("#reply-" + subcommentId).val("@" + nickname);
    }
    function spread(commentId){
        $.ajax({
            url:'/reply/list',
            type:'GET',
            dataType:'json',
            data:{
                commentId:commentId
            },success:function (data) {
                if(data.status==200){
                    $("#comment-" + commentId + " .sub-comment-list").html();
                    for(var i=0;i<data.info.length;i++){
                        var html='<div id="subcomment-'+data.info[i].commentId+'" class="sub-comment">';
                        html+=' <p><div data-v-f3bf5228="" class="v-tooltip-container" style="z-index: 0;">';
                        html+='<div class="v-tooltip-content">';
                        html+='<a href="javascript:" target="_blank">'+data.info[i].username+'</a>：</div>';
                        html+='</div><span>'+data.info[i].replyContent+'</span>';
                        html+='</p><div class="sub-tool-group"><span>'+data.info[i].replyTime+'</span>';
                        html+='<a onclick="Popreply('+data.info[i].commentId+')"><i class="iconfont ic-comment"></i> <span>回复</span></a></div></div>';
                        fillReply(commentId, html);
                    }
                    $("#spread-"+commentId).remove();
                }
            }
        })
    }
    function sub_reply(commentId){
        var content=$("#reply-"+commentId).val();
        var uid=$("#jane_id").val();
        if(!uid){
            alert("请先登录")
            return;
        }
        if(content&&content.length>0){
            $.ajax({
                url:'/reply/add',
                type:'GET',
                dataType:'json',
                data:{
                    uid:uid,
                    replyContent:content,
                    commentId:commentId
                },success:function (data) {
                    if(data.status==200){
                        var html='<div id="subcomment-'+data.info.id+'" class="sub-comment">';
                        html+=' <p><div data-v-f3bf5228="" class="v-tooltip-container" style="z-index: 0;">';
                        html+='<div class="v-tooltip-content">';
                        html+='<a href="javascript:" target="_blank">'+$("#jane_name").val()+'</a>：</div>';
                        html+='</div><span>'+data.info.replyContent+'</span>';
                        html+='</p><div class="sub-tool-group"><span>'+data.info.replyTime+'</span>';
                        html+='<a class="" onclick="Popreply('+commentId+')"><i class="iconfont ic-comment"></i> <span>回复</span></a></div></div>';
                        fillReply(commentId, html);
                        $("#reply-"+commentId).parent().parent().remove();
                    }
                }
            })
        }

    }
    $(function () {
        //更新浏览量
        var id=$("#articleId").val();
        $.ajax({
            url:'/post/update/views',
            type:'GET',
            dataType:'json',
            data:{
                articleId:id
            },
            success:function (data) {
               console.log(data)
            }
        })
    })
    $(function () {
       /* setTimeout(function () {
            var avatar=$("#avatar").attr('src');
            if(avatar){
                $("#user-avatar").attr("src",avatar);
            }
        },500)*/
        //处理图片问题
        function loading() {
            $("div.image-package p  img").each(function () {
                var prefix='//localhost'
                var idx=$(this).attr('src').indexOf(prefix)
                if(idx!=-1)
                    return;
                var src='//localhost:80'+$(this).attr('src')
                $(this).attr('src',src)
            })
        }
        loading()
        $("#post-comment").click(function () {
             var uid=$("#jane_id").val();
             if(!uid){
                 alert("请先登录")
                 return;
             }
             var content=$("#post-content").val();
             if(!content||content.length==0)
             {
                 alert("评论内容不能为空");
                 return
             }
             var comment={
                 entityId:$("#articleId").val(),
                 uid:uid,
                 content:content
             }
             $.ajax({
                 url:'/comment/add',
                 type:'POST',
                 dataType:'json',
                 data:{
                      uid:comment.uid,
                      entityId:comment.entityId,
                      content:comment.content
                 },
                 success:function(data){
                     if(data.status==200){
                         addComment(data.info)
                         $("#post-content").val("");
                     }
                 }
             })
        })
        var pid=$("#articleId").val();
        $.ajax({
            url:'/post/comments',
            type:'GET',
            dataType:'json',
            data:{
                id:pid
            },
            success:function (data) {
                if(data.status==200){
                    $("#comment-total").html("精彩评论(" + data.info.length + ")");
                     for(var i=0;i<data.info.length;i++){
                           addComment(data.info[i])
                     }
                }else{
                    $("#featured-comment-list").html("");
                }
            }
        })

    })
    $(function () {
        setTimeout(function () {
            var focusId=$("#userid").val();
            var uid=$("#jane_id").val();
            if(uid){
                $.ajax({
                    url:'/user/focus/validate',
                    type:'GET',
                    dataType:'json',
                    data:{
                        uid:uid,
                        focusId:focusId
                    },success:function (data) {
                        if(data.status==200){
                            $("#isFocus").val(1)
                        }
                    }
                })
            }
        },500)
        setTimeout(function () {
            var pid=$("#articleId").val();
            var uid=$("#jane_id").val();
            if(uid){
                $.ajax({
                    url:'/user/collection',
                    type:'GET',
                    dataType:'json',
                    data:{
                        uid:uid,
                        pid:pid
                    },success:function (data) {
                        if(data.status==200){
                            $("#cancel").css("display", "block");
                            $("#collection").css("display", "none");
                        }
                    }
                })
            }
        },500)
        $("#focus").click(function () {
            var uid=$("#jane_id").val();
            var focusId=$("#userid").val();
            if(!uid){
                alert("请先登录");
                return;
            }
            if($("#isFocus").val()){
                alert("已关注过了");
                return;
            }
            $.ajax({
                url:'/user/focus',
                type:'GET',
                dataType:'json',
                data:{
                    uid:uid,
                    focusId:focusId
                },success:function (data) {
                    if(data.status==200){
                        $("#isFocus").val(1)
                        alert(data.msg);
                    }else{
                        alert("用户关注失败");
                    }
                }
            })
        })
        $("#likes").click(function () {
            if($("#isLikes").val()){
                alert("已点过赞");
                return;
            }
            var id = $("#articleId").val();
            $.ajax({
                url:'/post/update/likes',
                type:'GET',
                dataType:'json',
                data:{
                    articleId:id
                },success:function (data) {
                    if(data.status==200){
                        $("#isLikes").val(1)
                        alert("谢谢你的点赞");
                    }
                }
            })
        })
        $("#collection").click(function () {
            var entityId=$("#articleId").val();
            var uid=$("#jane_id").val();
            if(!uid){
                alert("请先登录")
                return;
            }
            $.ajax({
                url:'/user/post/collection',
                type:'GET',
                dataType:'json',
                data:{
                    entityId:entityId,
                    title:$("#title").val(),
                    type:2,
                    uid:uid
                },success:function (data) {
                    if(data.status==200){
                        $("#collection").css("display", 'none');
                        $("#cancel").css("display", 'block');
                        alert("收藏成功")
                    }
                }
            })
        })
        $("#cancel").click(function () {
            var entityId=$("#articleId").val();
            var uid=$("#jane_id").val();
            if(!uid){
                alert("请先登录")
                return;
            }
            $.ajax({
                url:'/user/cancel/collection',
                type:'GET',
                dataType:'json',
                data:{
                    entityId:entityId,
                    uid:uid
                },success:function (data) {
                    if(data.status==200){
                        $("#collection").css("display", 'block');
                        $("#cancel").css("display", 'none');
                        alert("取消收藏")
                    }
                }
            })
        })
    })
</script>

</body>

</html>