//加减号
var setAmount={
    min:1,
    max:99,
    reg:function(x){
        return new RegExp("^[1-9]\\d*$").test(x);
    },
    amount:function(obj,mode){
        var x=$(obj).val();
        if (this.reg(x)){
            if (mode){
                x++;
            }else{
                x--;
            }
        }else{
        	x = 1;
            //alert("请输入正确的数量！");
            $(obj).val(1);
            $(obj).focus();
        }
        return x;
    },
    reduce:function(obj){
        var x=this.amount(obj,false);
        if (x>=this.min){
            $(obj).val(x);
        }else{
            //alert("商品数量最少为"+this.min);
            $(obj).val(1);
            $(obj).focus();
        }

    },
    add:function(obj){
        var x=this.amount(obj,true);
        if (x<=this.max){
            $(obj).val(x);
        }else{
            //alert("商品数量最多为"+this.max);
            $(obj).val(this.max);
            $(obj).focus();
        }
        },
    modify:function(obj){
        var x=$(obj).val();
        if (x<this.min||x>this.max||!this.reg(x)){
            //alert("请输入正确的数量！");
            //$(obj).val(1);
            $(obj).focus();
        }

    }
}

$(document).ready(function(){
	// 更新商品页的部分视图
	syncProductBlock();
	
	var unlogin = isunlogin();
	// 登陆用户购物车判断
	if(unlogin!=1)
	{
		minicart();//导航购物车
	}
	// 系列向下扩展
	if($('.kuanshi a').length>12){
		$('.kuanshi-tog-switch').show();
	}
	$('.kuanshi-tog-switch').click(function(){
		if($(this).hasClass('on')){
			$(this).removeClass('on')
		}else{
			$(this).addClass('on');
		};
		$('.kuanshi-tog').slideToggle();
	});

	$('.kuanshi a').each(function(){
		if($(this).hasClass('on'))
		{
			kuanshi = $('.kuanshi a').index(this);
			if(!$('.kuanshi-tog-switch').hasClass('on')){
				if(kuanshi>=12){
					$('.kuanshi-tog-switch').trigger('click');
				}
			}

		}
	});
	// 商品４个大图点击轮回
	$('.gpic_index').find('li').click(function(){
		$(this).addClass('gpic_on').siblings().removeClass('gpic_on');
		$('.gpic_box').find('div.jqzoom').eq($('.gpic_index').find('li').index(this)).show().siblings().hide();
	}); 
	
	
	$('#seecomments').click(function(){
		window.location.href="#toseecomments";
		$('#toseecomments').trigger('click');
	});

	// 实现商品页选项卡交互    
    $('.label-header').delegate('a', 'click', function() {
        var $self = $(this);
        var $parent = $self.parent();
        // 如果是已经选中的选项卡，从此处结束
        if($parent.hasClass('checked')) return;
        $parent.addClass('checked').siblings().removeClass('checked');

        // 显示对应的选项卡内容
        $('.' + $self.data('label')).show().siblings().hide();
    });


	//留言与评价
	$('.comment-sort-tag span').click(function(){
		if($('.comment-sort-tag span').index(this)==1){
			$(this).parent().next('div.fr').hide();
		}else{
			$(this).parent().next('div.fr').show();
		};
		$(this).addClass('on').siblings().removeClass('on');
		$('.comment-wrapper dl.pin-plun').eq($('.comment-sort-tag span').index(this)).show().siblings().hide();
	});
	
	//点击“默认/最新”排序
	$('#tab_userfultotal').click(function(){
		$(this).addClass("on").siblings().removeClass();
		$("#cnt_userfultotal").show();
		$("#cnt_time").hide();
	});
	$('#tab_time').click(function(){
		$(this).addClass("on").siblings().removeClass();
		$("#cnt_time").show();
		$("#cnt_userfultotal").hide();
	});
	
	//加入购物车-上
	$("#add-cart,#add-cart-now").live("click",function(){

		if($(this).attr('disable') == 1){
			return false;
		}
		var pamount_error = $('#pamount-error');
		pamount_error.html('');
		
		var num = $('#pamount').val();
		//var pid = $('#this-product').val();
		var pid = thisproductid();
		var subid = $('#select-size').val();
		var re = setAmount.reg(num);
		if(!re){
			pamount_error.html('请输入正确的数量');
			//pamount_error.css('visibility','visible');
			//$(this).attr('disable','0');
			return;
		}
		$(this).attr('disable','1');
		//按钮上转动的加载效果
		//$(this).parent().find('.btns').css('visibility','hidden');
		//$(this).parent().find('.login-loading').css('visibility','visible');
		//点击加loading效果；removeloading($(this));
		addloading($(this));
		
        if($(this).attr("id")=="add-cart-now"){
            lazyAddCart(num,pid,subid,showCartMsgA,1);   //立即购买
        }else{        	
            lazyAddCart(num,pid,subid,showCartMsgA);    //加入购物车
        }   
	});
	
	//cookie跟踪反馈	
	trackclick(1,0);
	
	//点击选择尺码
	$('.kuanshi a').live("click",function(){
	//$('.kuanshi span').click(function(){
		var disable = $(this).attr('disable');
		var select_size_error = $('#select-size-error');
		if(disable == 1){
			select_size_error.html('很抱歉,此款暂时无货');
			$('#add-cart').attr('disable','1');
			$('#add-cart-now').attr('disable','1');
			//return;
		}else{
			select_size_error.html('');
			$('#add-cart').attr('disable','0');
			$('#add-cart-now').attr('disable','0');
		}
		
		$('.kuanshi a').removeClass('clicked');
		$(this).addClass('clicked');
		var subid = $(this).attr('subid');
		$('#select-size').val(subid);
		
		var select_num_obj = $('#pamount');
		select_num_obj.val('1');
		select_num_obj.removeClass('gnum-on');
		var pamount_error = $('#pamount-error');
		pamount_error.html('');

	});
	
	//页面加载时，输入框为空
	$('#orderCommCont').val('');
	//商品id
	var pid = thisproductid();
	
	//加载评价与留言
	showCommentCnt(pid, 1, 0, 'createat', 'cnt_message');
	showCommentCnt(pid, 1, 1, 'usefultotal', 'cnt_comment');
	
	//当鼠标覆盖到某评价或留言，显示“删除”	
	$('.comment-detail').live('mouseenter', function() { 
		$(this).find('.mycomment-detail-delete').show();
	}).live('mouseleave', function () {
		$(this).find('.mycomment-detail-delete').hide();
	});

	//加入购物车显示弹出层控制
	$('.addcart-btn').click(function(){
		if(!$('.kuanshi span').hasClass('on')){
		$('.size-select').addClass('active');	
		};
	});
	$('.size-select-alert .delete').click(function(){
		$('.size-select').removeClass('active');
	});

});

$(document).ready(function() {
    'use strict';
    // 实现一个js动画
    var $aldSlider = $('#J_ald-slider')
        , $aldContent = $aldSlider.find('ul')
        , $aldItems = $aldContent.find('li')
        , $aldTrigger = $('#J_ald-trigger')
        , aldContentH = $aldContent.height()
        , aldContentTop = 0
        , aldSliderOffset = $aldSlider.height() + 8
        , number = 3
        , evType = document.ontouchstart ? 'touchstart' : 'click'
        , $startItems = $aldItems.slice(0, 3)
        , $endItems = $aldItems.slice(-3)
        ;    
    $aldTrigger.on(evType, 'a', function(e) {
        var resetTop = false
            , resetBottom = false
            ;

        if( +this.id === 2 ) {               // 向下滑动
            if(aldContentTop === aldSliderOffset - aldContentH) {
                $startItems.css({ position: 'relative', top: aldContentH });
                resetTop = true;
            }
            aldContentTop -= aldSliderOffset;
        }else {
            if(aldContentTop === 0) {
                $endItems.css({ position: 'relative', top: -aldContentH });
                resetBottom = true;
            }
            aldContentTop += aldSliderOffset;
        }
        $aldContent
            .animate({ top: aldContentTop }, 200, function() {
                var item = null;
                if(resetTop) {
                    $startItems.removeAttr('style');
                    $aldContent.css({ top: 0 });
                    aldContentTop = 0;
                }
                if(resetBottom) {
                    $endItems.removeAttr('style');
                    $aldContent.css({ top: aldSliderOffset - aldContentH });
                    aldContentTop = aldSliderOffset - aldContentH
                }
            });
    });
    // 用户下拉获取更多商品
    var $productContainer = $('#J_moredata')
        , $win = $(window)
        , $doc = $(document)
        , p = 1
        , pid = $('#this-product').val()
        , loading = true                // 标识ajax是否正在进行
        , winH = $win.height()
        , loadmoreOffset = $productContainer.offset()
        , loadmoreOffsetTop = loadmoreOffset ? loadmoreOffset.top : 0
        , $loading = $('<div style="text-align:center; line-height: 32px; margin-top: 40px;"><img src="http://img1.nuandaocdn.com/Public/images/web/loading.gif">&nbsp;&nbsp;加载中...</div>')
        ;
    $productContainer.on('moreDateEvt', function(e, pid, p) {
        var $self = $(this);
        // 如果加载区域是隐藏的或者获取不到pid, 不请求新数据
        if($self.filter(':hidden').length || pid === undefined) {return false; } 
        $.ajax({
            url: 'getRecommendList'
            , type: 'POST'
            , data: { id: pid, p: p }
            , dataType: 'json'
            , beforeSend: function() {
                loading = false;
                $self.after($loading);             // 添加正在加载标识
            }
        }).done(function(re) {
            if(re.status === 1) {
                var $docFragment = $(document.createDocumentFragment())
                    , rows = re.data
                    , rowsHtml = ''
                    ;
                if (!rows.length) return;      // 如果没有获取到数据, 结束请求
                for (var i = 0, len = rows.length; i < len; i++) {
                    var row = rows[i];
                    // 指定图片路径
                    row['imgPathname'] = getImgUrl(row.img.replace(/\.jpg$/i, function(match) {
                        return '-218' + match;
                    }))
                    rowsHtml += guestLikeView(row);
                }
                var $rowsHtml = $(rowsHtml);        // 存储对象,便于下面的延迟加载              
                $self.append($rowsHtml);            // 渲染到页面, 并为该片段添加图片延迟加载
                $rowsHtml.find('.lazyload-img').lazyload({ effect: 'fadeIn', event: 'scrollstop', threshold : 600 });
                loading = true;            
            }
        }).fail(function(re) {
            console.log(re);
            
        }).always(function() {
            $loading.remove();
        });
    }).trigger('moreDateEvt', [pid, p++]);
    $win.on('scroll.moreProduct', function() {
        // 360 计算了底部的高度
        loading && ($doc.scrollTop() + winH + 360 > $doc.height()) && $productContainer.trigger('moreDateEvt', [pid, p++]);
    });
});


function guestLikeView(obj) {
    var tmpl = '<a href="/product/{{productid}}?fm=guess" target="_blank"><img class="lazyload-img" data-original="{{imgPathname}}" alt="{{productname}}" title="{{productname}}" width="148" height="148"></a>';
    return tmpl.replace(/\{\{([\S\s]*?)\}\}/ig, function(match, $1) {return obj[$1]; });
}
// 异步加载部分视图
function syncProductBlock()
{
    var pagesign = getpagesign();
    var behaviorid = getbehaviorid();
    var data = "default=1&pagesign="+pagesign+"&id="+behaviorid;
    if(pagesign == 'product')
    {
        $.ajax({
            type: "POST",
            url: "/Ajax/syncProductBlock",
            dataType:"json",
            cache: false,
            data: data+"&m=" + Math.random(),
            beforeSend:function(){},
            success:function(re){
              $('#pblock').append(re.data.html.pblock);
              $('#pprice').html(re.data.html.pprice);
              $('#feedlist').html(re.data.html.feedlist);
            },error:function(){
                //alert('未知错误');
                return;
            }
        });
    }   
}

/**
 * 获取商品评价数量
 */
function getcommentcount(pid,type){
	var data = 'pid='+pid+'&type='+type;
	$.ajax({
		type: "POST",
		url: "/product/commentCount",
		dataType:"json",
		cache : false,
		async: false,
		data: data+"&m=" + Math.random(),
		success:function(o){
			if(o.status==1){
				if(o.data.type==1){
					$('.commentSum').html(o.data.sum);	
				}else if(o.data.type==0){
					$('.messageSum').html(o.data.sum);
					
				}
				
			}else{
				//alert('失败');	
			}
		},
		error:function(){
			//alert('error');
		}
	})
	
}

//当前商品id（仅限商品页）
function thisproductid(){
	var pid = $('#this-product').val();
	return pid;
}

//加入购物车回调函数-上
function showCartMsgA(re,pid,subid,num){
	var select_num_obj = $('#pamount');
	var pamount_error = $('#pamount-error');
	if(re.status == 'unlogin'){
		if($('#add-cart-now').attr('disable') == 1){
			showlogindiv('#add-cart-now', true);
		}else{
			showlogindiv('#add-cart', true);
		}
	}else if(re.status == 2){
		//alert('无货');
		select_num_obj.addClass('gnum-on');
		select_num_obj.val('0');
		pamount_error.html('该货品已卖完，浏览更多<a class="qing" href="/">精彩货品</a>');
		if(subid > 0){
			$('#sub'+subid).attr('disable', 1);
		}
	}else if(re.status == 0){
		//alert('库存不足');
		pamount_error.html(re.info);
	//货品不可买
	}else if(re.status == -2){
		alert('很抱歉,商品已下架，暂时无法购买');
		window.location.reload();
		//window.location.href="/";
	}else if(re.status == 1){
		//alert('成功');
		if($('#add-cart-now').attr('disable') == 1){
		  window.location.href="/shopping/checkout/buynow";
		  return;
		}
		trackcart('product');
		
		//$('#add-success-a').show();
		minicart();//导航购物车

		//$("#navcart-pop").show();
		//$('#navcart-popbar').addClass('bgwhite');
		//window.location.href="#top";
		//$("html, body").animate({scrollTop : 0}, 500);//慢慢回到顶部

		//pprice = $('.pprice'+pid).html();
		//pname = $('.ginfo h1').html();
		//ppic = $('.gpic_index').find('li').eq(0).find('img').attr('src');
		/*if(pname!='' && pprice!='' && num>0 && ppic !='')
		{
			$('.pop-pname').html(pname);
			$('.pop-pnum').html(num);
			$('.pop-pprice').html(pprice);
			$('.pop-ppic').find('img').attr('src', ppic);

			$('.add-cart-popupwrap').show();
			$('.add-cart-popup').show();
		}*/
		$('#add-cart').html('已加入购物车');
		$('#navcart-pop').show();
		var pid = thisproductid();
		$('.item'+pid).addClass('checked').fadeOut().fadeIn().fadeOut().fadeIn().fadeOut().fadeIn().fadeOut().fadeIn().fadeOut().fadeIn();
		navhideclear=setTimeout(function(){
			$('#navcart-pop').fadeOut(1000,function(){
				$('.item'+pid).removeClass('checked');
			});			
		},4000);
		
	}else if(re.status == 3){
		//alert('没选款式');
		var select_size_error = $('#select-size-error');
		select_size_error.html('请选择规格');
		//select_size_error.css('visibility','visible');
	}

	$('#add-cart').attr('disable','0');
	$('#add-cart-now').attr('disable','0');
	//按钮上转动的加载效果
	//去掉loading效果；removeloading($(this));
	removeloading($('#add-cart'));
	removeloading($('#add-cart-now'));
}

//发布留言
function submitMessage(){
	if($(this).attr('disable') == 1){		
		return false;
	}
	
	var orderCommCnt = $("textarea[name='orderCommCont']").val();
	orderCommCnt = $.trim(orderCommCnt);
	if(orderCommCnt.length<1){
		$('.alert-msg').html('<font color="red">写点什么</font>');
		return;
	}
	
	/*
	if(orderCommCnt.length>130){
		$('.alert-msg').html('<font color="red">超130字喽~</font>');
		return;
	}
	*/
	
	var pid = thisproductid();
	var isSyncWeibo = document.getElementById('syncWeibo').checked;
	//var isCheckWeibo = $('#syncWeibo').attr('checked');
	//alert(isSyncWeibo);
	$(this).attr('disable','1');
    var pname = '{$p.productname}';
	
	//提交发布数据
	var data = 'pid='+pid+'&ordercommcnt='+orderCommCnt+'&issyncweibo='+isSyncWeibo+'&commenttype=0';
	$.ajax({
		type: "POST",
		url: "/user/orderComment",
		dataType:"json",
		cache : false,
		//async: false, 
		context: $(this),
		data: data+"&m=" + Math.random(),
		success:function(o){
			if(o.status == 'unlogin'){				
				showlogindiv();
			}else if(o.status == 0){
				alert(o.info);
			}else if(o.status==1){
                //ALERT('OK');
                //清空留言输入框
                $("textarea[name='orderCommCont']").val("");
                
                //发布成功后，刷新留言区
                showCommentCnt(pid, 1, 0, 'createat', 'cnt_message');					
                
                //发布成功后，同时更新留言总数
                var curSum = $('#tab_message').html();		
                var messageSum = 0;
                if(curSum.length == 3){
                    messageSum = 1;
                }else{
                    var pregCurSum = curSum.match(/.(\d+)./);
                    //alert(pregCurSum[1]);
                    if(pregCurSum[1]){
                        messageSum = ++(pregCurSum[1]);
                    }
                }
                //alert('messageSum='+messageSum);
                $('#tab_message').html('留言(<a id="messageSum">'+messageSum+'</a>)');
                $('#counter_message').html(130);
                
                //ajax只触发一次
                $(this).attr('disable','0');

                //统计
                trackcomment('user message', pname, 'product');
                
                //记住是否同步微博的状态
                var posttype = (isSyncWeibo == true) ? 3 : -3;
                weiboSet(posttype,'posttype');
                                    
                //同步微博
                if(isSyncWeibo){
                    syncWeiboComment(pid, o.data);
                }
                //alert(o.info);
			}
		},
		error:function(){
		}
	});
}

//显示所有留言或评价
function showCommentCnt(pid,p,type,sort,divid){
	var data = "pid="+pid+"&type="+type+"&p="+p+"&sort="+sort+"&divid="+divid;
	//alert(data);
	$.ajax({
		type: "POST",
		url: "/product/getCommentAjax",
		dataType:"json",
		cache : false,
		async: false,
		data: data+"&m=" + Math.random(),
		success:function(o){
			if(o.status==1){
				$('#'+divid).html(o.data.html);
				//document.getElementById(divid).innerHTML = o.data.html;
			}else{
				//alert('留言失败');					
			}
		},
		error:function(){
			//alert('error');
		}
	})
}

//点击“有用”
function submitUseful(commentid, usefultotal)
{
	var pid = thisproductid();
	var data = "commentid="+commentid+'&productid='+pid;
	$.ajax({
		type: "POST",
		url: "/product/addUsefultotal",
		dataType:"json",
		cache : false,
		data: data+"&m=" + Math.random(),
		success:function(o){
			if(o.status == 'unlogin'){
				showlogindiv();
			}else{
				if(o.status==1){
					//alert('ok');	
					var total = parseInt(usefultotal)+1;
					var msg = "<font color='grey'>有用("+total+")</font>";
					$('#'+commentid).html(msg);
					$('#'+commentid).attr("onclick", '');
				}else{
					//alert('已经点评过了');					
				}
			}
		},
		error:function(){
			//alert('error');
		}
	})
}
//即时提示字数限制
function countChar(textareaName,spanName){
	document.getElementById(spanName).innerHTML = 130 - document.getElementById(textareaName).value.length;
	if(document.getElementById(spanName).innerHTML < 0){
		$('.alert-msg').html('<font color="red">超130字喽~</font>');
	}else{
		$('.alert-msg').html('');
	}
}

//删除评价或留言
function delComment(productid, commentid, commenttype){
	if(confirm('确定删除该评价么？')){
		if(commenttype==1){
			//var commentcount = $('#commentSum').html();
			var commentcount = document.getElementById('commentSum').innerHTML;
		}else{
			//var commentcount = $('#messageSum').html();
			var commentcount = document.getElementById('messageSum').innerHTML;
		}
		commentcount = (commentcount<1) ? 0 : commentcount;
		var total = commentcount;
		
		var data = 'productid='+productid+'&commentid='+commentid+'&commenttype='+commenttype+'&total='+total;
		//alert(data);
		$.ajax({
			type: "POST",
			url: "/user/deletecomment",
			dataType:"json",
			cache : false,
			async: false, 
			data: data+"&m=" + Math.random(),
			success:function(o){
				if(commentcount > 0){
					commentcount = commentcount-1;
					if(commenttype==1){
						$('#commentSum').html(commentcount);
					}else{
						$('#messageSum').html(commentcount);
					}					
				}
				//$('#comment_'+commentid).slideUp();
				
				if(commenttype==1){
					showCommentCnt(productid, 1, 1, 'usefultotal', 'cnt_comment');
				}else{
					showCommentCnt(productid, 1, 0, 'createat', 'cnt_message');
				}
				
			},
			error:function(){
				//alert('del comment failed!');
			}
		});
	}
}
