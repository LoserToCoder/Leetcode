/**
 * Create a cookie with the given name and value and other optional parameters.
 *
 * @example $.cookie('the_cookie', 'the_value');
 * @desc Set the value of a cookie.
 * @example $.cookie('the_cookie', 'the_value', { expires: 7, path: '/', domain: 'jquery.com', secure: true });
 * @desc Create a cookie with all available options.
 * @example $.cookie('the_cookie', 'the_value');
 * @desc Create a session cookie.
 * @example $.cookie('the_cookie', null);
 * @desc Delete a cookie by passing null as value. Keep in mind that you have to use the same path and domain
 *       used when the cookie was set.
 */
jQuery.cookie = function(e, i, o) {
	if("undefined" == typeof i) {
		var n = null;
		if(document.cookie && "" != document.cookie)
			for(var r = document.cookie.split(";"), t = 0; t < r.length; t++) {
				var p = jQuery.trim(r[t]);
				if(p.substring(0, e.length + 1) == e + "=") {
					n = decodeURIComponent(p.substring(e.length + 1));
					break
				}
			}
		return n
	}
	o = o || {}, null === i && (i = "", o.expires = -1);
	var u = "";
	if(o.expires && ("number" == typeof o.expires || o.expires.toUTCString)) {
		var s;
		"number" == typeof o.expires ? (s = new Date, s.setTime(s.getTime() + 24 * o.expires * 60 * 60 * 1e3)) : s = o.expires, u = "; expires=" + s.toUTCString()
	}
	var a = o.path ? "; path=" + o.path : "",
		c = o.domain ? "; domain=" + o.domain : "",
		m = o.secure ? "; secure" : "";
	document.cookie = [e, "=", encodeURIComponent(i), u, a, c, m].join("")
};
/*
 * Special scroll events for jQuery
 * 用于图片延迟加载。当滚动条停止滚动时, 加载视口里的商品图片
 * http://james.padolsey.com/javascript/special-scroll-events-for-jquery/
 */
! function() {
	var a = jQuery.event.special,
		b = "D" + +new Date,
		c = "D" + (+new Date + 1);
	a.scrollstart = {
		setup: function() {
			var c, d = function(b) {
				var d = this,
					e = arguments;
				c ? clearTimeout(c) : (b.type = "scrollstart", jQuery.event.dispatch.apply(d, e)), c = setTimeout(function() {
					c = null
				}, a.scrollstop.latency)
			};
			jQuery(this).bind("scroll", d).data(b, d)
		},
		teardown: function() {
			jQuery(this).unbind("scroll", jQuery(this).data(b))
		}
	}, a.scrollstop = {
		latency: 300,
		setup: function() {
			var b, d = function(c) {
				var d = this,
					e = arguments;
				b && clearTimeout(b), b = setTimeout(function() {
					b = null, c.type = "scrollstop", jQuery.event.dispatch.apply(d, e)
				}, a.scrollstop.latency)
			};
			jQuery(this).bind("scroll", d).data(c, d)
		},
		teardown: function() {
			jQuery(this).unbind("scroll", jQuery(this).data(c))
		}
	}
}();

/**
 * 延迟加载图片。由事件触发指定区域图片的加载请求
 * 
 * 例如$('#J_header-nav').lazyloadBlock({ block: '.header-nav', events: { load: window }});
 * 当load事件触发后,自动加载.header-nav区域内的图片
 */
! function(e) {
	var n = {
		image: "img",
		block: "",
		events: null,
		autoTriggle: !1
	};
	e.fn.lazyloadBlock = function(o) {
		var a = e.extend({}, n, o),
			t = e.extend({}, o, {
				event: "lazyloadAppear"
			}),
			i = a.block ? a.block + " " + a.image : a.image,
			l = a.events,
			r = function() {
				this.find(i).trigger("lazyloadAppear")
			};
		return this.each(function() {
			var n = e(this),
				o = e.proxy(r, n);
			e(a.image, n).lazyload(t);
			for(var i in l)
				if(l.hasOwnProperty(i)) {
					var c = l[i];
					"string" == typeof c && (selectors = /(.+)\s(\S+)/.exec(c)) ? e(selectors[1]).on(i, selectors[2], o) : e(c).bind(i, function() {
						"load" === i ? setTimeout(o, 0) : r.call(n)
					})
				}
			e(document).ready(function() {
				a.autoTriggle && r.call(n)
			})
		})
	}
}(jQuery, window);

var ND = ND || {};
ND.TEST = '7.0';
ND.isPhone = /(iphone|ipod|android)/i.test(navigator.userAgent);
ND.EMAIL = /^\s*([A-Za-z0-9_-]+(\.\w+)*@(\w+\.)+\w{2,3})\s*$/;
ND.isFn = function(sFunc) {
	return(typeof $.fn[sFunc] === 'function') ? true : false;
};
ND.checkEmail = function(email, el) {
	if(email === '') {
		el.text('请填写邮箱地址').show();
		return false;
	}
	if(!ND.EMAIL.test(email)) {
		el.text('您填写的邮箱地址不正确').show();
		return false;
	}
	return true;
};
ND.isIos = function() {
	return /(iphone|ipad|ipod)/i.test(navigator.userAgent);
};
ND.setBackgroundImage = function(url) {
	return 'url(' + url + ')';
};

// 解决调不支持console的浏览器报错
if(typeof window.console === 'undefined') {
	window.console = {
		log: function() {
			return;
		}
	};
}
var pagesign;

var imgDNS = ['http://img1.nuandaoimg.com', 'http://img2.nuandaoimg.com', 'http://img1.nuandaocdn.com', 'http://img2.nuandaocdn.com'];
var getImgUrl = function(imgPathname) {
	return imgDNS[Math.random() * 4 | 0] + '/Public/images/uploads/' + imgPathname;
};

// 显示用户的登陆状态
function personal() {

}
// ------------------------
// footjs内容是mixpanel统计代码
// ------------------------
//用户信息
function syncUserbehavior() {
	var pagesign = getpagesign();
	var behaviorid = getbehaviorid();
	var data = "default=1&pagesign=" + pagesign + "&id=" + behaviorid;
	$.ajax({
		type: "POST",
		url: "/Ajax/syncbehavior",
		dataType: "json",
		cache: false,
		data: data + "&m=" + Math.random(),
		beforeSend: function() {},
		success: function(re) {
			$('#personalfootjs').html(re.data.footjs);
		},
		error: function() {
			//alert('未知错误');
			return;
		}
	});
}

function syncShareButton() {
	var pagesign = getpagesign();
	var behaviorid = getbehaviorid();
	var data = "default=1&pagesign=" + pagesign + "&id=" + behaviorid;
	if(pagesign == 'sale' || pagesign == 'product' || pagesign == 'only') {
		$.ajax({
			type: "POST",
			url: "/Ajax/syncShareButton",
			dataType: "json",
			cache: false,
			data: data + "&m=" + Math.random(),
			beforeSend: function() {},
			success: function(re) {
				$('#topbox-share').html(re.data.share);
				$('#topbox-time').html(re.data.topboxtime);
			},
			error: function() {
				//alert('未知错误');
				return;
			}
		});
	}
}

// 在新窗口打开页面, 如果失败，用新标签打开
function openNewWindow(url) {
	null === window.open(url) && (window.location = url);
}

function overlay(options) {
	var ok = options.ok;
	var cancel = options.cancel;
	var target = options.target;
	var $overlay = $(options.container);
	// 如果不存在该遮罩
	if(!$overlay.length) return;
	$('.overlay').hide();
	// 重写弹层内容
	if(options.content) {
		$overlay.find('.overlay-content').html(options.content);
	}

	// 显示并定位弹层
	$overlay.show();
	if(target) {
		var targetOffset = options.target.offset();
		var targetW = options.target.width();
		var overlayH = $overlay.height();
		var overlayW = $overlay.width();
		$overlay.offset(function() {
			return {
				left: targetOffset.left - overlayW + targetW,
				top: targetOffset.top - overlayH - 12
			}
		});
	}

	$overlay.show().unbind('click').bind('click', function(e) {
		var $target = $(e.target);
		if($target.hasClass('cancel')) {
			// 如果存在取消操作
			cancel && cancel.call(this, options.args);
			this.style.display = 'none';
		} else if($target.hasClass('ok')) {
			// 存在ok函数，并且返回true时 才能关闭弹层
			if(ok && ok.call(this, options.args)) {
				this.style.display = 'none';
			} else {
				// console.log('不存在ok或ok没有返回true');
			}
		}
	});
	return $overlay;
}

//按钮加loading效果函数，传入jQuery选择器比(this)
function addloading(btn) {
	btn.attr('originhtml', btn.html());
	//$(this).height($(this).height());
	btn.addClass('btn-loading').append("<div class='onloading'><div class='sloading'><div></div><div></div><div></div><div></div></div></div>");
	btn.find('.onloading').width(btn.width());
}
//按钮消除loading效果函数，传入jQuery选择器比(this)
function removeloading(btn) {
	btn.find('.onloading').remove();
}

//topbox滑动  
function movebox() {
	// var topscroll = $(document).scrollTop(); 
	// if(topscroll<118){
	//     $('.fl-topbox-flow').css("position","relative").removeClass('shadow');          
	// }
	// else{
	//     $('.fl-topbox-flow').css("position","fixed").addClass('shadow');
	// };  
};
window.onscroll = movebox;
window.onload = $(window).scrollTop(0);

function likehover() {
	$(".pins,.pin-pins-img").hover(function() {
		$(this).find('.pins-share').slideDown(300);
		//$(this).find('.sales-add-cart').show();
		//$(this).find('.paddc-tip').show();
	}, function() {
		$(this).find('.pins-share').slideUp(300);
		//$(this).find('.sales-add-cart').hide();
		//$(this).find('.paddc-tip').hide();
	});

	$(".pins dt").hover(function() {
		$(this).find('.pins-discount').fadeIn(300);
	}, function() {
		$(this).find('.pins-discount').fadeOut(300);
	});

	$('.sales-pins, .pin-pins').hover(function() {
		$(this).find('.pins-likeshare-share').stop(true, true).animate({
			width: "110px"
		});
	}, function() {
		$(this).find('.pins-likeshare-share').stop(true, true).animate({
			width: "0px"
		});
	});
}

function getnowtime() {
	var timestamp = (new Date()).valueOf().toString().substr(0, 10);
	return parseInt(timestamp);
}

//导航购物
function minicart(nocount) {
	if(nocount) {
		var data = "countdown=0";
	} else {
		var data = "countdown=1";
	}

	$.ajax({
		type: "POST",
		url: "/shopping/cart",
		dataType: "json",
		cache: false,
		data: data + "&m=" + Math.random(),
		beforeSend: function() {},
		success: function(re) {
			if(re.data != null) {
				if(re.data.num) {
					$('#cart_total_quantity_value').html(re.data.num);
				} else {}
				$('#navcart-pop').html(re.data.html);
				$('#navcart-popbar').show();
			}

		},
		error: function() {
			//alert('未知错误');
			return;
		}
	});
}
//倒计时
function DownCount() {
	if(actnum <= 0) {
		return;
	}
	for(var i = 0; i < actnum; i++) {
		if(endtimes[i] <= 0) {
			$("#ongoing_" + i).html("0秒");
		} else {
			timechange(endtimes[i], i);
			endtimes[i] = endtimes[i] - 1;
		}
	}
}

function timechange(expires, i) {
	if(expires > 0) {
		var second = expires;
	} else {
		var second = "分";
		return second;
	}
	var day = hour = minutes = "";
	if(second > 86400) {
		day = Math.floor(second / 86400) + " 天";
		second = second % 86400;
	}
	if(second > 3600) {
		hour = Math.floor(second / 3600);
		hour = hour.toString();
		if(hour.length == 1) {
			hour = hour + " 小时";
		} else {
			hour = hour + " 小时";
		}
		second = second % 3600;
	}
	if(second > 60) {
		minutes = Math.floor(second / 60);
		minutes = minutes.toString();
		if(minutes.length == 1) {
			minutes = minutes + "分";
		} else {
			minutes = minutes + "分";
		}
		second = second % 60;
	}
	second = second.toString();
	if(second.length == 1) {
		second = second + "秒";
	} else {
		second = second + "秒";
	}
	$(".ongoing,#ongoing_" + i).html(day + hour + minutes + second);
}

function popdiv(popdiv, width, height, alpha) {

	var A = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
	var D = 0;
	D = Math.min(document.body.clientHeight, document.documentElement.clientHeight);
	if(D == 0) {
		D = Math.max(document.body.clientHeight, document.documentElement.clientHeight)
	}
	var topheight = (A + (D - 300) / 2) - 50 + "px";
	$("#popbg").css({
		height: $(document).height(),
		filter: "alpha(opacity=" + alpha + ")",
		opacity: alpha
	})
	$("#popbg").fadeIn();
	$(popdiv).removeClass();
	$(popdiv).attr("class", "pop_out ");
	$(popdiv).css({
		left: (($(document).width()) / 2 - (parseInt(width) / 2)) + "px",
		top: topheight
	});
	$(popdiv).fadeIn();
}

//track分享
//参数：分享网分享url 分享内容类型 分享内容分享来源页面
function shareto(stype, url, ptype, pname, page) {
	// if(isunlogin() == 1){
	//  showlogindiv();
	// }else{
	// mixpanel.track('Share', {'mp_note':'user shared '+pname+' using '+stype,'Share Content':ptype,'Share Name':pname ,'Share Page':page,'Share SNS':stype});
	window.open(url);
	// }
}

//track喜欢
//参数：喜欢内容类喜欢内容喜欢来源页面
function tracklike(ptype, pname, page) {
	// mixpanel.track('Like ', {'mp_note':'user liked '+pname,'Like Content':ptype,'Like Name':pname ,'Like Page':page});
}

/* track评论
 * 参数：ctype(comment类型) page(页面) pname(留言的商
 * feed页发表留言 user message    feed   商品
 * product页发表留言 user message   product   商品
 * 我的订单页发表评buyer comment   myorder   商品
 */
function trackcomment(ctype, pname, page) {
	// mixpanel.track('Comment ', {'mp_note':'user commented on '+pname,'Comment Type':ctype,'Comment Name':pname ,'Comment Page': page});
}

//track邀
//参数：分享网分享url 邀请来源页
function trackinvite(stype, url, page, num) {
	// mixpanel.track('Invite', {'mp_note':'user invited using '+stype,'Invite Page':page,'Invite SNS':stype,'Amount Invited':num});
	if(url != '') {
		window.open(url);
	}
}

//track加入购物
//参数：分享网分享url 邀请来源页
function trackcart(page) {
	// mixpanel.track("Add to Cart", {'Add to Cart Page':page});//Mixpanel 统计 购物
}
//统计去结进行统计
function trackgotocart(page) {
	// mixpanel.track("Go to Cart", {'Go to Cart Page':page});//Mixpanel 统计 结算
}
//点击继续购物" 和点击右上角进行统计
function trackgoShopping(page) {
	// mixpanel.track("Go on Shopping", {'Go on Shopping Page':page});//Mixpanel 统计 继续购物
}
//track邀
//参数：分享网分享url 邀请来源页
function trackweibo(stype, url, page) {
	$('.boxtop-wbbox').hide();
	setTimeout('window.location.href= \'' + url + '\'', 1000);
}
//验证用户邮箱
function checkuseremail(email) {
	var filter = /^\s*([A-Za-z0-9_-]+(\.\w+)*@(\w+\.)+\w{2,3})\s*$/;
	return filter.test(email);
}

//获取页面标识
function getpagesign() {
	return $("input[name='pagesign']").val();
}

//获取用户行为
function getbehaviorid() {
	var behaviorid = $("input[name='behaviorid']").val();
	return behaviorid;
}

//获取当前是否登录
function isunlogin() {
	var unlogin = $("input[name='unlogin']").val();
	return unlogin;
}

//用户未登录点击跟踪cookie
//type 0 cookie记录
//type 1 cookie读取删除
function trackclick(type, clickbtn) {
	if(type == 0) {
		if(clickbtn) {
			$.cookie("clickbtn", clickbtn);
		}
	} else {
		var unlogin = isunlogin();
		//click事件跟踪
		if(unlogin != 1) {
			clickbtn = $.cookie('clickbtn');
			if(clickbtn != '' && clickbtn != 0) {
				var pagesign = getpagesign();
				if(pagesign != 'index') {
					$(clickbtn).click();
				}
				$.cookie('clickbtn', null);
				$("input[name='clickbtn']").val('');
			}
		}
	}

}

// 提交设计师信
// function partner(url, partner_submit) {
//     if(partner.submit) return;                      // 防止再次提交表单
//     var required = false;                           // 标记表单必填项是否都填写
//     var $msg = $('#J_message');                     // 显示提示信息
//     var message = '';
//     var $partnerInfo = $('#J_partnerInfo');
//     var $inputs = $partnerInfo.find('input');       // 所有的文本
//     $.each($inputs.toArray(), function() {
//         if(this.getAttribute('require') && !$.trim(this.value)){
//             $(this).addClass('error');
//             required = true;
//         }
//     });
//     if(required) { message += '红色框为必填'; }
//     // 验证邮箱的合法
//     var $email = $inputs.filter('[name="email"]');
//     var email_re = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
//     var email_valid = email_re.test($email.val());
//     if(!email_valid) { $email.addClass('error'); message += '填写有效的邮箱地址.'; }
//     $inputs.bind('focus', function(){
//         $(this).removeClass('error');
//         $msg.hide();
//     });

//     if(!required && email_valid) {
//         $.ajax({
//             type: 'POST',
//             url: url,
//             dataType:"json",
//             data: $partnerInfo.serialize()+"&m=" + Math.random(),
//             beforeSend: function(){
//                     partner.submit = true; 
//                 },
//             success: function(o){ 
//                 if(o.status == 1){
//                     partner.submit = true; 
//                     $msg.text('您的信息已提交成').show(); 
//                 }else{  
//                     partner.submit = false;             
//                     $msg.html(o.info);  
//                 }
//             },error:function(){
//                 //alert('未知错误');
//                 return;
//             }
//         }); 
//     }else {
//         $msg.text(message).show();
//     }

// }