webpackJsonp([6], [function(t, e, a) {
	(function(t) {
		var e = a(35);
		a(55), a(67);
		var n = a(33);
		a(43), t(function() {
			function a() {
				var e = t("#daren-tmpl").html(),
					a = n.compile(e);
				
			}
			var i, o = !1,
				r = t(document);
			t(window).scroll(function() {
				if(!o) {
					var a = t(this),
						n = a.scrollTop();
					n > 500 && (o = !0, e.wooInit(null, null, 244, 20, null, !0))
				}
			}), t(".dt-carousel-item").carousel({
				action: ".dt-carousel-point",
				eventType: "click",
				time: 1000,
				fadeElement: ".dt-carousel-img",
				left: ".dt-carousel-action-left",
				right: ".dt-carousel-action-right",
				animateType: "move",
				carouselWrap: ".dt-carousel-content",
				callback: function(e, a, n, i, o) {
					var r = n.find(".dt-carousel-title").html(),
						s = t(".dt-carousel-action-title");
					s.html(r), t(".dt-carousel-item").mouseover(function() {
						o()
					}).mouseout(function() {
						i()
					})
				}
			}), t("#dt-carousel").on("a", "mousedown", function() {
				var e = t(this),
					a = e.closest("#dt-carousel").find("a"),
					n = a.index(e);
				t.G.gaq("/_trc/NIdex/_/focus_" + n + "__" + t(this).attr("href"))
			}), t("#dt-slider").on("a", "mousedown", function(e) {
				t.G.gaq("/_trc/NIdex/_/story_entry__" + t(this).attr("href"))
			}), r.on(".dt-woo-list a", "mousedown", function(e) {
				t.G.gaq("/_trc/NIdex/_/category_entry__" + t(this).attr("href"))
			}), t("#dt-enter").on("a", "mousedown", function() {
				var e = t(this),
					a = e.closest("#dt-enter").find("a"),
					n = a.index(e);
				t.G.gaq("/_trc/NIdex/_/guide_entry_" + n)
			}), t("#dt-hot").on("a", "mousedown", function() {
				t.G.gaq("/_trc/NIdex/_/hot_activ_entry__" + t(this).attr("href"))
			}), t(".dt-album").on("a", "mousedown", function() {
				t.G.gaq("/_trc/NIdex/_/albums_entry__" + t(this).attr("href"))
			}), t(".wxlink").on("mouseover", function(e) {
				clearTimeout(i);
				var a = t(this).position().left + 20,
					n = t(this).position().top + 20,
					o = t('<div class="weixinpopout" style="width: 86px; height: 86px; background: url(http://img5.duitang.com/uploads/people/201401/14/20140114164336_WswB8.jpeg) no-repeat 0 0;"></div>');
				o.appendTo("body").fadeIn(), t(".weixinpopout").css({
					position: "absolute",
					top: n,
					left: a
				})
			}), t(".wxlink").on("mouseout", function(e) {
				i = setTimeout(function() {
					t(".weixinpopout").animate({
						opacity: 0
					}, function() {
						t(this).remove()
					})
				}, 400)
			}), r.find("a").each(function(e, a) {
				var n = t(a);
				n.data("href", n.attr("href"))
			}), r.on("body > a", "click", function() {
				var e = t(this).attr("href");
				t.G.gaq("/_trc/Error/_/adclick_to_" + e)
			}), r.on("mousedown", "a", function(e) {
				var a = t(this),
					n = a.attr("href"),
					i = a.data("href");
				i && n != i && t.G.gaq("/_trc/Error/_/adclick_change_" + n)
			}), window.setTimeout(function() {
				for(var e = t("body").children(), a = t(window).width(), n = 0; 5 > n; n++) {
					var i = e.eq(-n - 1);
					if(i.hasClass("dn") || "script" == i.get(0).tagName.toLowerCase()) break;
					if(!i.hasClass("dt-side-combo") && !i.hasClass("blockUI") && i.outerWidth() > 0 && i.offset().left < a) {
						var o = i.find("a"),
							r = (i.attr("id") || "") + "_" + (i.attr("class") || "");
						o.each(function(e, a) {
							var n = t(a).attr("href");
							t.G.isLink(n) && t.G.gaq("/_trc/Error/_/adclick_lnk_" + n)
						});
						var s = i.find("iframe");
						s.each(function(e, a) {
							var n = t(a).attr("src");
							t.G.gaq("/_trc/Error/_/adclick_ifr_" + n)
						}), s.remove(), t.G.gaq("/_trc/Error/_/adclick_pop_" + r)
					}
				}
			}, 300), a()
		})
	}).call(e, a(1))
}, , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , function(t, e, a) {
	var n;
	(function(i) {
		! function(i, o) {
			n = function() {
				return i.DtTools = o()
			}.call(e, a, e, t), !(void 0 !== n && (t.exports = n))
		}(this || i, function() {
			var t = {};
			return t.VERSION = "0.0.1", t.dtImageTrans = function(t, e, a, n, i) {
				var o = t.trim().replace(/^http(s)?:\/\//gi, ""),
					r = o.split("/");
				r[0], r[1];
				return e ? (a = a || 0, n = n || 0, i = i ? "_" + i : "", this.dtImageTrans(t).replace(/(\.[a-z_]+)$/gi, ".thumb." + a + "_" + n + i + "$1")) : t.replace(/(?:\.thumb\.\w+|\.[a-z]+!\w+)(\.[a-z_]+)$/gi, "$1")
			}, t.dtUriTrans = function(t, e) {
				if(void 0 == e) return t;
				var a = [];
				for(var n in e) {
					var i = n + "=" + e[n];
					a.push(i)
				}
				var o = a.join("&"),
					r = t + "?" + o || "";
				return r
			}, t.getParams = function(t) {
				t || (t = window.location.href);
				var e, a, n, i = {};
				t = t.split("#")[0];
				for(var o = t.indexOf("?"), r = o > -1 ? t.substr(o + 1) : "", s = r.split("&"), n = 0; n < s.length; n++) {
					var l = s[n].indexOf("=");
					if(l > 0) {
						e = s[n].substring(0, l), a = s[n].substr(l + 1);
						try {
							a.indexOf("+") > -1 && (a = a.replace(/\+/g, " ")), i[e] = decodeURIComponent(a)
						} catch(c) {}
					}
				}
				return i
			}, t.addParam = function(t, e, a) {
				var n = new RegExp("([&\\?])" + e + "=[^& ]*", "g");
				t = t.replace(n, function(t, e) {
					return "?" == e ? "?" : ""
				});
				var i = t.indexOf("?");
				return t += (i > -1 ? i + 1 != t.length ? "&" : "" : "?") + e + "=" + a
			}, t
		})
	}).call(e, function() {
		return this
	}())
}, function(t, e, a) {
	(function(e) {
		a(36), a(37), a(1), a(15), a(44), a(45), a(46);
		var n = a(48),
			i = function() {
				function t(t, i, o, r, s, l, c) {
					var d = function(t) {
							if(t && 0 !== t.length) {
								var e, a = t.parents(".nav-wrap");
								if(a.length && (e = a.find(".nav-bottom-span"), e.length)) {
									var n = t.width(),
										i = t.position().left,
										o = e.width();
									e.position().left;
									0 === o ? e.hide().css({
										left: i,
										width: n
									}).fadeIn(300) : (e.stop(), e.animate({
										left: i,
										width: n,
										opacity: 1
									}, 300))
								}
							}
						},
						u = (e("#woo-holder"), e.browser.msie);
					u && "6.0" === e.browser.version;
					!l && e('<a id="gotonext" href="javascript:;" style="visibility:hidden"></a><a href="#" id="retotop"></a><a id="gotopre" href="javascript:;"></a>').sidepop({
						id: "side-retotop",
						dockSide: "right",
						width: 82,
						scroll: 2,
						departure: 0,
						baseline: "bottom",
						bias: 16,
						isFixed: !0,
						zIndex: 100,
						btnset: 0
					});
					var f = e("#onlyproduct-a");
					f.length && e.G.bindChecks("#onlyproduct-a", "#woo-form-hot,#woo-form-new", void 0, function() {
						var t = e(".woo-swa"),
							a = e.Woo.pagine,
							n = t.index(t.filter(".woo-cur"));
						return a[n] && !a[n].loading && !a[n].lazyAdding
					}, function() {
						var t = e(".woo-swa"),
							a = e.Woo.pagine,
							n = t.index(t.filter(".woo-cur")),
							i = f.hasClass("onlyproduct-0");
						!a[n] || a[n].loading || a[n].lazyAdding || (a[n].refreshPage(1), i ? f.removeClass("onlyproduct-0 onlyproduct-0-no").addClass("onlyproduct-1 onlyproduct-1-no") : f.removeClass("onlyproduct-1 onlyproduct-1-no").addClass("onlyproduct-0 onlyproduct-0-no"))
					});
					var p = {
						unitsnum: 24,
						subpagenum: 5,
						appendnum: 12,
						anchordiff: 80,
						arrform: t || ["hot", "new"],
						arrsplit: i || "",
						arrmasnw: o || 245,
						arrmargin: r || 21,
						arrfmasnw: s || 0,
						arrgap: 0,
						gopre: "#gotopre",
						gonext: "#gotonext",
						gotop: "#retotop",
						footer: "#footer,#dt-woomore",
						anchordiff: 70,
						onScroll: function(t) {
							var a = window.sessionStorage.getItem("hasPop");
							"false" === a && !e.G.getUSERID() && ("undefined" == typeof ALREADYNOTICED || !ALREADYNOTICED) && t >= 1e3 && window.location.pathname.match(/^\/(category|topics|album|shopping|blogs)/gi) && (ALREADYNOTICED = !0, SUGAR.PopOut.login())
						},
						onLazyAddOver: function(t, a) {
							if(!t.loading) {
								var n = e("#onlyproduct-a,#onlyproduct-set a");
								n.removeClass("onlyproduct-0-no onlyproduct-1-no")
							}
						},
						onTabSwitch: function(t, a, n, i, o) {
							t.parent().removeClass("dymswitch-" + i + " dymswitch-" + i + "to" + n).addClass("dymswitch-" + n), d(e(".woo-swa").eq(n))
						},
						requestAlways: function(t, a) {
							if(!t.lazyAdding) {
								var n = e("#onlyproduct-a,#onlyproduct-set a");
								n.removeClass("onlyproduct-0-no onlyproduct-1-no")
							}
						},
						resize: !0
					};
					p = e.extend(p, c), e.Woo(p);
					var h = e(".woo-swa");
					h.hover(function(t) {
						var a = e(this);
						if(!a.hasClass("woo-cur")) {
							var n = h.index(a),
								i = a.parent(),
								o = i.attr("class").replace(/dymswitch-\d+\b/gi, function(t) {
									return t + "to" + n
								});
							i.attr("class", o)
						}
					}, function(t) {
						var a = e(this);
						if(!a.hasClass("woo-cur")) {
							var n = (h.index(a), a.parent()),
								i = n.attr("class").replace(/(dymswitch-\d+)to\d+\b/gi, function(t, e) {
									return e
								});
							n.attr("class", i)
						}
					}), e.isFunction(n) && n(), a()
				}

				function a() {
					if(e.G.isSTAFF() && e.fn.confirm) {
						var t = e("#woo-holder");
						t.confirm(function(t) {
							var a = e(this),
								n = a.data("confirm");
							e.post(n, function() {
								a.closest("div.woo").fadeOut(150, function() {
									e(this).remove()
								})
							})
						}, "a.mblogdelete", {
							tipword: "确定要删除？"
						}), t.confirm(function(t) {
							var a = e(this),
								n = a.data("confirm");
							e.post(n, function() {
								a.closest("div.woo").fadeOut(150, function() {
									e(this).remove()
								})
							})
						}, "a.mblogdeleteall", {
							tipword: "确定要删除all？"
						}), t.on("click", ".mblogpass", function(t) {
							var a = e(this),
								n = a.data("confirm");
							e.post(n, function() {
								a.closest("div.woo").fadeOut(150, function() {
									e(this).remove()
								})
							})
						}), t.on("click", "a.mblogblackall", function(t) {
							t.preventDefault(), t.stopPropagation();
							var a = e(this),
								n = a.data("confirm");
							a.hasClass("normal-no") || (a.addClass("normal-no").css("opacity", "0.5"), e.post(n, function() {
								var t = a.data("confirm");
								a.removeClass("mblogblackall normal-no").addClass("mblogunblackall").css("opacity", "1").html("解屏").data("confirm", t.replace("/block_photo/", "/unblock_photo/")).closest("div.woo").css("opacity", "0.1")
							}))
						}), t.on("click", "a.mblogunblackall", function(t) {
							t.preventDefault(), t.stopPropagation();
							var a = e(this),
								n = a.data("confirm");
							if(!a.hasClass("normal-no")) {
								var i = e.G.getParams(n).id;
								e.ajax({
									url: n,
									data: {
										id: i,
										safe: 0
									},
									timeout: 2e4,
									success: function(t) {
										var e = a.data("confirm");
										a.removeClass("mblogunblackall normal-no").addClass("mblogblackall").css("opacity", "1").html("屏蔽").data("confirm", e.replace("/unblock_photo/", "/block_photo/")).closest("div.woo").css("opacity", "1")
									}
								}), a.addClass("normal-no").css("opacity", "0.5")
							}
						}), t.on("click", "a.mbloggood", function(t) {
							t.preventDefault(), t.stopPropagation();
							var a = e(this),
								n = (a.html(), a.data("confirm"));
							a.hasClass("normal-no") || (a.addClass("normal-no").css("opacity", "0.5"), e.post(n, function() {
								var t = a.data("confirm");
								a.removeClass("mbloggood normal-no").addClass("mblogungood").css("opacity", "1").html("去精").data("confirm", t.replace("?opt=on", "?opt=off")).closest("div.woo").css("opacity", "0.1")
							}))
						}), t.on("click", "a.mblogungood", function(t) {
							t.preventDefault(), t.stopPropagation();
							var a = e(this),
								n = (a.html(), a.data("confirm"));
							a.hasClass("normal-no") || (a.addClass("normal-no").css("opacity", "0.5"), e.post(n, function() {
								var t = a.data("confirm");
								a.removeClass("mblogungood normal-no").addClass("mbloggood").css("opacity", "1").html("精").data("confirm", t.replace("?opt=off", "?opt=on")).closest("div.woo").css("opacity", "1")
							}))
						})
					}
				}
				return {
					wooInit: t,
					wooStaff: a
				}
			}();
		t.exports = i
	}).call(e, a(1))
}, function(t, e, a) {
	var n = a(1);
	n(function() {
		var t = document.referrer,
			e = window.location.search,
			a = !0,
			i = "";
		e.replace(/[\?\&]spm=([^& ]+)/g, function(t, e) {
			return i = e, ""
		}), !i && a && n.G.isFromDomain(t, "duitang.com") && t.indexOf(".duitang.com/album/") > -1 && t.replace(/[\?\&]spm=([^& ]+)/g, function(t, e) {
			return i = e, ""
		}), n(document).delegate("a", "mousedown", function() {
			var t = n(this).attr("href"),
				e = "",
				a = n.G.isRedirect(t);
			if(a) {
				i || (e = n(this).closest(".woo-pcont").data("spm"), e || (e = n(this).closest("#woo-holder").data("spm")), e || (e = n(this).closest(".spm-holder").data("spm")), e && (e = e.replace("spm=", ""), i = e));
				var o = "";
				t.replace(/[\?\&]to=([^& ]+)/g, function(t, e) {
					o = decodeURIComponent(e)
				}), (n.G.isFromDomain(o, "yihaodian.com") || n.G.isFromDomain(o, "1mall.com")) && (o = n.G.addParam(o, "tracker_u", "107031367"), n(this).attr("href", n.G.addParam(t, "to", encodeURIComponent(o)))), i && n.G.isFromDomain(o, "taobao.com", "tmall.com") && n(this).attr("href", n.G.addParam(t, "spm", i))
			}
		})
	})
}, function(t, e, a) {
	var n = a(38),
		i = a(39),
		o = a(34);
	a(40), a(43);
	var r = a(33),
		s = a(1),
		l = function(t) {
			function e(t) {
				return s("<div>").text(t).html()
			}

			function a(t) {
				var e = s.trim(t),
					a = e.substr(0, 1);
				if("{" != a && "[" != a) {
					if("<!doctype" === e.substr(0, 9)) return [
						[], !0
					];
					u && (e = e.replace(/(<img[^>]* class=[\'\"]?i[\'\"]?[^>\"\']*)src/gi, function(t, e) {
						return e + "srcd"
					}));
					var n = s(e).filter(".woo"),
						i = "False" === n.attr("hasnext") ? !1 : !0;
					return [n.toArray(), i]
				}
				return null
			}
			if(t) {
				var l = navigator.userAgent.toString().toLowerCase(),
					c = !!l.match(/ipad/gi),
					d = s.G.getParams(window.location.search).from_blog,
					u = !c,
					f = [],
					p = [],
					h = [],
					m = [];
				h = ['<% for (var i = 0; i < list.length; i ++) { %><% var u = list[i],aidx = $unit(u.id,u),plnk = $pricelnk(u,pgsource),imgsize=[224,0],newiht=$trans(224,u.iwd,u.iht); %><% if(!aidx) continue; %><div class="woo" data-id="<%=u.id%>"><div class="j"> 	  <div class="mbpho" <% if( !imgsize[1] ){ %>style="height:<%=newiht > 800 ? 800 : newiht%>px;"<% }else{ %>style="height:<%=imgsize[1]%>px"<% } %> ><a target="_blank" <% if( u.ourl ){ %>class="a"  href="<%=u.ourl%>"<% }else if( coupon && plnk ){ %>class="a" <% if(u.tid){ %> biz-itemid="<%=u.tid%>" data-type="0" data-rd="1" <% } %> href="<%=plnk%>"<% }else{ %>class="a"  href="/blog/?id=<%=u.id%>"<% } %>><img <%=srcd ? "srcd" : "src"%>="<%=$imgsrc(u.isrc,imgsize)%>" data-rootid="<%=u.rid%>" data-iid="<%=u.photo_id%>" height="<%=newiht%>"/><u <%= newiht > 800 ? "class=\'bottomfade\'" : ""%> style=\'margin-top:-<%=newiht%>px;height:<%= newiht > 800 ? 798 : (newiht-2)%>px;\'></u></a> 	    <div class="collbtn" data-favorite=\'{"id":"<%=u.id%>","owner":"<%=u.uid%>","type":"1"}\'><a <% if( ruid == u.uid ){ %>class="y re-done" title="去看我的收集" href="/blog/?id=<%=u.id%>" target="_blank"><i class="y-done"></i><em>已收集 <% }else if( ruid == u.ruid ){ %>class="y re-done" title="去看我的收集" href="/blog/?id=<%=u.rid%>" target="_blank" ><i class="y-done"></i><em>已收集 <% }else{ %>class="y" href="#" ><i></i><em>收集 <% } %><% if(u.favc > 0) {%><%=u.favc%><% } %></em></a><a class="x btn-white" href="#"><i><%=u.repc%></i></a><a <% if( ruid == u.ruid || ruid == u.uid ){ %>class="z re-zan btn-white" href="/blog/?id=<%=u.id%>"><i class="z-done"><% }else{ %>class="z btn-white" href="#" ><i><% } %><%=u.zanc%></i></a></div> 	  </div> 	  <div class="wooscr"> 	  <div class="g"<% if (u.wait_audit) {%> style="background-color:#f14382"<% } %>><%=$content(u.msg)%></div> 	  <div class="d"><span <% if( u.favc > 0 ){ %>class="d1"><% }else{ %>class="d1 dn"><% } %><%=u.favc%></span><span <% if( u.zanc > 0 ){ %>class="d2"><% }else{ %>class="d2 dn"><% } %><%=u.zanc%></span><span <% if( u.repc > 0 ){ %>class="d3"><% }else{ %>class="d3 dn"><% } %><%=u.repc%></span><% if(!coupon && plnk){ %>&nbsp;<%=$price(u,plnk)%><% } %></div> 	<% if( coupon && plnk ){ %> 	  <%=$coupon(u,plnk)%> 	<% } %> 	  <ul> 	<% if( nopth ){ %> 	  <li class="f"></li> 	<% }else{ %> 	  <li class="f"><a target="_blank" href="/people/?user_id=<%=u.uid%>"><img width="24" height="24" src="<%=u.ava%>"></a><p><a class="p" target="_blank" href="/people/?user_id=<%=u.uid%>"<% if (u.sender_wait_audit) {%> style="color:#f14382"<% } %>><%=$cut(u.unm,16)%></a>&nbsp;<br/><span><%= u.uid == u.ruid ? "发布" : "收集" %>到&nbsp;<% if(u.albid){ %><a target="_blank" href="/album/?id=<%=u.albid%>"<% if (u.album_wait_audit) {%> style="color:#f14382"<% } %>><%=$cut(u.albnm,12)%></span></a><% }else{ %><a target="_blank" href="/album/people/<%=u.uid%>/">默认专辑</a><% } %></p></li> 	<% } %> 	<% for(var j=0,l=hasrp?u.cmts.length:0; j<l; j++){ %> 	  <li><a target="_blank" href="/people/?user_id=<%=u.cmts[j].id%>"><img width="24" height="24" src="<%=u.cmts[j].ava%>"></a><p><a target="_blank" href="/people/?user_id=<%=u.cmts[j].id%>"><% if( ruid == u.cmts[j].id ){ %>我<% }else{ %><%=$cut(u.cmts[j].name,16)%><% } %></a><br/><span><%=$content(u.cmts[j].cont)%></span></p></li> 	<% } %></ul></div>' + (s.G.isSTAFF() ? '<div class="clr staf"><% if(u.is_robot){ %><span class="red mr8">机器人</span><% } %><% if(u.srclnk){ %><span class="red mr8">来源</span><% } %><% if(u.sta == 7){ %><a href="javascript:;" data-confirm="/operate/audit/unblock_blog/?id=<%=u.id%>" class="mblogpass">PASS</a><a href="javascript:;" data-confirm="/operate/audit/block_photo/?id=<%=u.id%>" class="mblogblackall">屏蔽all</a><% }else if( u.sta == 6 ){ %><a href="javascript:;" data-confirm="/operate/audit/unblock_photo/?id=<%=u.id%>" class="mblogunblackall">解屏all</a><% }else{ %><a href="javascript:;" data-confirm="/operate/audit/block_photo/?id=<%=u.id%>" class="mblogblackall">屏蔽all</a><% } %><% if( u.good ){ %><a href="javascript:;" data-confirm="/blog/switchshopping/<%=u.rid%>/?opt=off" class="mblogungood">去精</a><% }else{ %><a href="javascript:;" data-confirm="/blog/switchshopping/<%=u.rid%>/?opt=on" class="mbloggood">精</a><% } %></div>' : "") + "</div></div><% } %>", null, null, null, s(n).closest("#mod1").html(), s(n).closest("#mod2").html(), s(n).closest("#mod3").html(), s(n).closest("#mod4").html()], p = [function(t) {
					if(t && t.length && s.isPlainObject(t[0])) {
						var e = s.G.getUSERID(),
							a = m[0],
							n = {
								list: t,
								srcd: u,
								ruid: e,
								picsize: "224",
								coupon: a.coupon,
								hasrp: a.hasrp,
								nopth: a.nopth,
								pgsource: a.pgsource
							},
							o = i.compile(h[0], {
								escape: !0
							}),
							r = s.trim(o(n));
						return r
					}
					return t
				}, null, null, null, function(t) {
					if(t && t.length && s.isPlainObject(t[0])) {
						var e = s.G.getUSERID(),
							a = m[0],
							n = {
								isSTAFF: s.G.isSTAFF(),
								list: t,
								srcd: u,
								ruid: e,
								picsize: "224",
								coupon: a.coupon,
								hasrp: a.hasrp,
								pgsource: a.pgsource
							},
							i = r.compile(h[4]),
							o = s.trim(i(n));
						return o
					}
					return t
				}, function(t) {
					if(t && t.length && s.isPlainObject(t[0])) {
						var e = {
								list: t
							},
							a = r.compile(h[5]),
							n = s.trim(a(e));
						return n
					}
					return t
				}, function(t) {
					if(t && t.length && s.isPlainObject(t[0])) {
						var e = {
								list: t
							},
							a = r.compile(h[6]),
							n = s.trim(a(e));
						return n
					}
					return t
				}, function(t) {
					if(t && t.length && s.isPlainObject(t[0])) {
						var e = {
								list: t
							},
							a = r.compile(h[7]),
							n = s.trim(a(e));
						return n
					}
					return t
				}], f = [function(t) {
					var e = a(t);
					if(e) return e;
					var n = [
							[], !0
						],
						i = s.isPlainObject(t) ? t : s.parseJSON(t);
					if(!i) return n;
					if(i.success) {
						var o = (s.G.getUSERID(), i.data);
						m[0] = {
							picsize: "224",
							coupon: !!o.coupon,
							hasrp: !!o.hasrp,
							nopth: !!o.nopth,
							pgsource: o.pgsource
						}, n = [o.blogs, o.has_next, o.count]
					}
					return n
				}, function(t) {
					var n = a(t);
					if(n) return n;
					var i = [
							[], !0
						],
						r = s.isPlainObject(t) ? t : s.parseJSON(t);
					if(!r) return i;
					if(r.success) {
						for(var l = s(null), c = r.data, d = 0, f = c.albums, p = f.length; p > d; d++) {
							var h = f[d].username || "",
								m = f[d].wait_audit ? "ohblocked" : "ohnoblocked",
								g = f[d].wait_audit ? "解屏" : "屏蔽",
								v = ['<div class="woo" data-id="', f[d].id, '" data-ht="328" ' + (0 == d ? 'hasnext="' + (c.has_next ? "True" : "False") + '"' : "") + ">", '<div class="albbigimg">', '<p class="lev2"></p>', '<p class="lev1"></p>', '<a href="/album/?id=', f[d].id, '" class="lev0" target="_blank">', function() {
									var t = "";
									if(f[d].pics)
										for(var a = 0; 1 > a && a < f[d].pics.length; a++) 0 == a && (t += "<img " + (u ? "srcd" : "src") + '="' + o.dtImageTrans(f[d].pics[a], !0, 200, 200, "c") + '" alt="' + f[d].name + '"/>');
									else t += '<img src="http://img5.duitang.com/uploads/people/201307/10/20130710134638_QtMin.jpeg" alt="' + e(f[d].name) + '" />';
									return t
								}(), "</a>", '<p class="lev3"' + (f[d].wait_audit ? ' style="background-color:#f00"' : "") + "></p>", "<div>", e(f[d].name.cut(24, "…")), "</div>", "</div>", "<ul>", "<li>", s.G.isSTAFF() ? '<a class="r blockthisalbum ' + m + '" title="' + f[d].id + '" href="javascript:;" style="margin-left: 40px;">' + g + "</a>" : "", f[d].user_id == s.G.getUSERID() ? '<a class="r delthisalbum" title="' + f[d].id + '" href="javascript:;">删除</a>' : "", "<span>", f[d].count, "个收集 | ", f[d].like_count, "人喜欢</span></li>", '<li class="clr"><a href="/people/?user_id=', f[d].user_id, '" target="_blank">', '<img src="', f[d].avatar, '" />', h.cut(14, "…"), "</a></li>", "<li>" + e(f[d].desc) + "</li>", "</ul>", "</div>"].join("");
							l = l.add(s(v))
						}
						i = [l.toArray(), c.has_next]
					}
					return i
				}, function(t) {
					var e = a(t);
					if(e) return e;
					var n = [
							[], !0
						],
						i = s.isPlainObject(t) ? t : s.parseJSON(t);
					if(!i) return n;
					if(i.success) {
						for(var r = s(null), l = i.data, c = 0, d = l.albums, f = d.length; f > c; c++) {
							var p = d[c],
								h = (p.username || "", p.wait_audit ? "ohblocked" : "ohnoblocked"),
								m = p.wait_audit ? "解屏" : "屏蔽",
								g = ['<div class="woo" data-id="', p.id, '" data-ht="358" ' + (0 == c ? 'hasnext="' + (l.has_next ? "True" : "False") + '"' : "") + ">", '<div class="dt-xitem-img">', function() {
									var t = "";
									if(p.pics)
										for(var e = 0; 1 > e && e < p.pics.length; e++) 0 == e && (t += "<img " + (u ? "srcd" : "src") + '="' + o.dtImageTrans(p.pics[e], !0, 224, 224, "c") + '" alt="' + p.name + '"/>');
									else t += '<img src="http://img5.duitang.com/uploads/people/201401/24/20140124115823_HJydi.png" alt="' + p.name + '" />';
									return t
								}(), '<a href="/album/?id=', p.id, '" class="dt-xitem-icv" target="_blank">', "</a>", "</div>", '<div class="dt-xitem-desc">', '<div class="dt-xitem-title"><a target="_blank" href="/album/?id=', p.id, '">', p.name.cut(24, "…"), "</a></div>", '<div class="dt-xitem-attr">', "<p>", function() {
									var t = "";
									return t += 7 == p.status ? s.G.isSTAFF() ? '<a class="r blockthisalbum ohblocked " title="' + d[c].id + '" href="javascript:;">PASS</a>' : "" : s.G.isSTAFF() ? '<a class="r blockthisalbum ' + h + '" title="' + d[c].id + '" href="javascript:;">' + m + "</a>" : ""
								}(), p.count, "个收集", " <b>·</b> ", p.like_count, "人喜欢", "</p>", '<p class="dt-xitem-user">', "by ", '<a target="_blank" href="/people/?user_id=', p.user_id, '">', p.username, "</a>", "</p>", "</div>", "</div>", '<div class="dt-xitem-bt1"></div>', '<div class="dt-xitem-bt2"></div>', "</div>"].join("");
							r = r.add(s(g))
						}
						n = [r.toArray(), l.has_next]
					}
					return n
				}, function(t) {
					var n = a(t);
					if(n) return n;
					var i = [
							[], !0
						],
						r = s.isPlainObject(t) ? t : s.parseJSON(t);
					if(!r) return i;
					if(r.success) {
						for(var l = s(null), c = r.data, d = 0, u = c.albums, f = u.length; f > d; d++) {
							var p = u[d].username || "",
								h = u[d].is_like ? '<a data-albumlike=\'{"id":' + u[d].id + '}\' class="albumlikebtn albumliked" href="javascript:;">取消喜欢</a>' : '<a data-albumlike=\'{"id":' + u[d].id + '}\' class="albumlikebtn" href="javascript:;">喜欢</a>',
								m = u[d].desc.replace(/<br\s*\/?>/gi, " ").cut(92, "…"),
								g = u[d].pics,
								v = g ? g.length : 0,
								b = ['<div data-id="', u[d].id, '" data-ht="260" class="woo" ' + (0 == d ? 'hasnext="' + (c.has_next ? "True" : "False") + '"' : "") + ">", '<p class="lev1"></p><div class="albbigimg clr"><div class="dec clr"><h2><a target="_blank" href="/album/?id=', u[d].id, '" title="', u[d].name, '">', e(u[d].name.cut(20, "…")), "</a></h2><span>", u[d].count, "个收集&nbsp;|&nbsp;", u[d].like_count, '人喜欢</span></div><a target="_blank" href="/album/?id=', u[d].id, '" class="lev0">', function() {
									for(var t = "", e = 0; 5 > e && v > e; e++) {
										var a = u[d].pics[e];
										t += e ? '<img width="80" height="80" src="' + a + '" />' : '<img width="164" height="164" src="' + o.dtImageTrans(a, !0, 164, 164, "c") + '" />'
									}
									return t
								}(), '</a><ul><li><a href="/people/?user_id=', u[d].user_id, '" class="nc"><img width="24" height="24" src="', u[d].avatar, '" />', p.cut(14, "…"), '</a></li><li class="decpro"><u>&nbsp;</u>', m, '<i>&nbsp;</i></li><li class="decfav">', h, "</li></ul></div>", "</div>"].join("");
							l = l.add(s(b))
						}
						i = [l.toArray(), c.has_next]
					}
					return i
				}, function(t) {
					var e = a(t);
					if(e) return e;
					var n = [
							[], !0
						],
						i = s.isPlainObject(t) ? t : s.parseJSON(t);
					if(!i) return n;
					if(i.success || 1 === i.status) {
						var r = s.G.getUSERID(),
							l = i.data;
						m[0] = {
							picsize: "224",
							coupon: !0,
							hasrp: !0,
							pgsource: "tp_"
						}, s(l.object_list).each(function(t, e) {
							var a = 0 === e.photo.width ? 0 : Math.floor(224 * e.photo.height / e.photo.width);
							e.newHeight = a > 800 ? 800 : a, e.photo.path.indexOf(".gif_jpeg") > -1 && (e.photo.path = e.photo.path.replace(".gif_jpeg", ".gif")), e.photo.path = o.dtImageTrans(e.photo.path, !0, 224, 0), 0 !== e.buyable && "" !== e.source_link && (e.buyAbled = !0), e.isStaff = s.G.isSTAFF() ? !0 : !1, r === e.sender_id && (e.isUersSelf = !0), r && 1 === e.is_root && (e.sRoot = !0)
						}), n = [l.object_list, !!l.more, l.total || ""]
					}
					return n
				}, function(t) {
					var n = a(t);
					if(n) return n;
					var i = [
							[], !0
						],
						r = s.isPlainObject(t) ? t : s.parseJSON(t);
					if(!r) return i;
					if(r.success || 1 === r.status) {
						var l = r.data;
						s(l.object_list).each(function(t, a) {
							a.covers && a.covers.length > 0 && (a.coverBg = o.dtImageTrans(a.covers[0], !0, 200, 200, "c")), a.desc && (a.desc = e(a.desc)), a.user && (a.user.avatar = o.dtImageTrans(a.user.avatar, !0, 48, 48, "c"))
						}), i = [l.object_list, !!l.more]
					}
					return i
				}, function(t) {
					var e = a(t);
					if(e) return e;
					var n = [
							[], !0
						],
						i = s.isPlainObject(t) ? t : s.parseJSON(t);
					if(!i) return n;
					if(i.success || 1 === i.status) {
						var o = s.G.getUSERID(),
							r = i.data;
						s(r.object_list).each(function(t, e) {
							o === e.user.id && (e.isUersSelf = !0), e.name = e.name.cut(10, "…"), e.desc = e.desc.cut(46, "…"), e.user.username = e.user.username.cut(7, "…")
						}), n = [r.object_list, !!r.more]
					}
					return n
				}, function(t) {
					var e = a(t);
					if(e) return e;
					var n = [
							[], !0
						],
						i = s.isPlainObject(t) ? t : s.parseJSON(t);
					if(!i) return n;
					if(i.success || 1 === i.status) {
						var r = (s.G.getUSERID(), i.data);
						s(r.object_list).each(function(t, e) {
							e.isStaff = s.G.isSTAFF() ? !0 : !1, e.oClass = 6 == e.status ? "ohblocked" : "ohnoblocked", e.oText = 6 == e.status ? "解屏" : "屏蔽", e.covers = o.dtImageTrans(e.covers[0], !0, 224, 224, "c")
						}), n = [r.object_list, !!r.more]
					}
					return n
				}], i.helper("$coupon", function(t, e) {
					var a = "",
						n = parseFloat(t.price),
						i = parseFloat(t.coupon_price);
					return n && i && (a = '<div class="v"><a href="' + e + '" target="_blank">￥' + i + "</a><s>￥" + n + '</s><a class="q" href="' + e + '" target="_blank">查看详情</a><p>' + Math.round(i / n * 100) / 10 + "折</p></div>"), a
				}), i.helper("$price", function(t, e) {
					return t.coupon_price && (t.price = t.coupon_price), t.buylnk ? '<a class="bl ' + (t.price ? "" : "by") + '" href="' + e + '" target="_blank"' + (t.tid ? 'biz-itemid="' + t.tid + '" data-type="0" data-rd="1"' : "") + '><u class="_tb" title="去购买">' + (t.price ? "￥" + t.price : "&nbsp;") + "</u></a>" : ""
				}), i.helper("$pricelnk", function(t, e) {
					var a = t.prelnk || "",
						n = s.G.isRedirect(a);
					return n || (a = "/dj/go2/?to="), t.buylnk && (a = s.G.addParam(a, "to", encodeURIComponent(t.buylnk)), a = s.G.addParam(a, "mk", (e ? e : "_") + "p_" + t.id)), a
				}), i.helper("$imgsrc", function(t, e) {
					return t.indexOf(".gif_jpeg") > -1 && (t = t.replace(".gif_jpeg", ".gif")), s.isArray(e) ? o.dtImageTrans(t, !0, e[0], e[1], "") : t
				}), i.helper("$content", function(t) {
					var a = e(t),
						n = s.G.trimLink(a, s.G.isSTAFF());
					return n
				}), i.helper("$cut", function(t, e) {
					return t.cut(e, "…")
				}), i.helper("$trans", function(t, e, a) {
					return 0 === e ? 0 : Math.floor(a * t / e)
				}), i.helper("$unit", function(t, e) {
					return t += "", g.addUnit(t, e, !0)
				});
				var g = function() {
					var t = {
						ulen: 0,
						latestUnits: {},
						init: function(e, a) {
							t.analyzeResponse = e, t.render = a, t.masnUnits = {}
						},
						reset: function() {
							t.ulen = 0, t.masnUnits = {}
						},
						getLatestUnits: function() {
							return t.latestUnits
						},
						resetLatestUnits: function() {
							t.latestUnits = {}
						},
						setUnitsFromLatest: function() {
							var e = t.latestUnits;
							s.isPlainObject(e) && (t.masnUnits = e)
						},
						addUnit: function(e, a, n) {
							var i = t.masnUnits;
							return n && i[e] || d == e ? 0 : (t.latestUnits[e] = a, i[e] = a, t.ulen++, i[e].indx = t.ulen - 1, t.ulen)
						}
					};
					return t
				}();
				g.init(f, p), s.Woo.WooTemp = g
			}
		}(s.Woo);
	t.exports = l
}, function(t, e) {
	t.exports = '<!-- 默认模板 该模板适用于 首页热门，最新、个人中心 发布、收集 关注动态-->\n<!-- 依赖 handerbar help的组件注入-->\n<script id="mod1" type="text/x-handlebars-template">\n  {{#each list}}\n  <div class="woo">\n    <div class="j">\n      <div class="mbpho" style="height:{{#ifCond newHeight \'>\' 800}}800{{else}}{{newHeight}}{{/ifCond}}px">\n        <a target="_blank"  class="a"  href="/blog/?id={{id}}">\n          <img src="{{photo.path}}" data-rootid="{{../ruid}}" data-iid="" height="{{newHeight}}"/>\n          <u {{#ifCond newHeight \'>\' 800}}class="bottomfade"{{/ifCond}} style="margin-top:-{{newHeight}}px;height:{{#ifCond  newHeight \'>\' 800}}800px{{else}}{{newHeight-2}}{{/ifCond}}">\n          </u>\n        </a>\n        <div class="collbtn" data-favorite=\'{"id":"{{id}}","owner":"{{sender_id}}","type":"1","likeid":"{{like_id}}"}\'>\n           <a {{#ifCond favorite_blog_id \'>\' 0}} class="y re-done" title="去看我的收集" href="/blog/?id={{favorite_blog_id}}" target="_blank" >\n            <i class="y-done"></i>\n            <em>已收集 {{else}} class="y" href="#" >\n            <i></i>\n            <em>收集{{/ifCond}}  {{#ifCond favorite_count \'>\' 0 }}{{favorite_count}}{{/ifCond}}</em>\n          </a>\n          <a class="x btn-white" href="#"><i>{{reply_count}}</i></a>\n          <a  {{#ifCond isUersSelf \'||\' like_id}}class="z re-zan btn-white" href="/blog/?id={{id}}">\n            <i class="z-done">\n            {{else}}\n              class="z btn-white" href="#" >\n            <i>{{/ifCond}}{{like_count}}</i>\n          </a>\n        </div>\n      </div>\n      <div class="wooscr">\n        <div class="g" {{#ifCond status \'===\' 6}}style="background-color:#f14382"{{/ifCond}}{{#if isStaff}} {{#ifCond status \'===\' 10}}style="background-color:#ff9143"{{/ifCond}}{{/if}} >{{msg}}</div>\n        <div class="d">\n          <span {{#ifCond favorite_count \'>\' 0}} class="d1">{{else}}class="d1 dn">{{/ifCond}}{{favorite_count}}</span>\n          <span {{#ifCond like_count \'>\' 0 }}class="d2">{{else}}class="d2 dn">{{/ifCond}}{{like_count}} </span>\n          <span {{#ifCond reply_count \'>\' 0 }}class="d3">{{else}}class="d3 dn">{{/ifCond}}{{reply_count}}</span>\n           {{#if buyAbled}}\n           <a class="bl {{#if item.price}}{{else}}by{{/if}}" href="{{source_link}}" target="_blank" {{#if id}} biz-itemid="{{id}}" data-type="0" data-rd="1"{{/if}}>\n            <u class="_tb" title="去购买">\n              {{#if item.price}}\n              ￥{{item.price}}\n              {{else}}\n              &nbsp;\n              {{/if}}\n            </u></a>\n           {{/if}}\n        </div>\n        <ul>\n          <li class="f">\n              <a target="_blank" href="/people/?user_id={{sender_id}}">\n              <img src="{{dtImageTrans sender.avatar true 24 24 \'c\'}}"  width="24" height="24">\n              </a>\n              <p>\n                <a class="p" target="_blank" href="/people/?user_id={{sender_id}}">\n                {{more sender.username 16}}\n                </a>&nbsp;<br/>\n                <span>\n                  {{#if isRoot}}发布{{else}}收集{{/if}}到&nbsp;\n                  {{#if album}}\n                  <a target="_blank" href="/album/?id={{album.id}}">{{album.name}}</span></a>\n                  {{else}}\n                  <a target="_blank" href="/album/people/{{sender_id}}/">默认专辑</span></a>\n                  {{/if}}\n              </p>\n            </li>\n          {{#if ../hasrp}}\n            <!--评论部分-->\n            {{#each top_comments.object_list}}\n            <li>\n                <a target="_blank" href="/people/?user_id={{sender.id}}">\n                    <img src="{{dtImageTrans sender.avatar true 24 24 \'c\'}}"  width="24" height="24">\n                </a>\n                <p>\n                    <a target="_blank" href="/people/?user_id={{sender.id}}">\n                    {{#ifCond ruid \'==\' sender.id}}\n                        我\n                    {{else}}\n                        {{more sender.username 16}}\n                    {{/ifCond}}\n                    </a><br/>\n                    <span>\n                    {{content content}}\n                    </span>\n                </p>\n            </li>\n            {{/each}}\n          {{/if}}\n        </ul>\n      </div>\n    </div>\n   </div>\n  {{/each}}\n</script>\n<!--搜索专辑模板-->\n<script id="mod2" type="text/x-handlebars-template">\n  {{#each list}}\n  <div class="woo" data-id="{{id}}" data-ht="328" \' + (i == 0 ? \'hasnext="\' + (dat.has_next ? \'True\' : \'False\') + \'"\' : \'\') + \'>\n    <div class="albbigimg">\n      <p class="lev2"></p>\n      <p class="lev1"></p>\n      <a href="/album/?id={{id}}" class="lev0" target="_blank">\n      {{#if covers}}\n        <img src="{{coverBg}}" alt="{{desc}}">\n      {{else}}\n        <img src="http://img5.duitang.com/uploads/people/201307/10/20130710134638_QtMin.jpeg" alt="{{desc}}" />\n      {{/if}}\n      </a>\n      <div>{{more desc 24}}</div>\n    </div>\n    <ul>\n      <li><span>{{count}}张图片 | {{favorite_count}}人收藏</span></li>\n      <li class="clr"><a href="/people/?user_id={{user.id}}" target="_blank"><img src="{{user.avatar}}">{{more user.username 16}}</a></li>\n      <li>{{desc}}</li>\n    </ul>\n    <ul>\n    </div>\n  {{/each}}\n</script>\n<!--专辑标签瀑布流模板-->\n<script id="mod3" type="text/x-handlebars-template">\n{{#each list}}\n<div class="woo" data-id="{{id}}" hasnext="" data-ht="260">\n  <p class="lev1"></p>\n  <div class="albbigimg clr">\n    <div class="dec clr">\n      <h2><a href="/album/?id={{id}}" title="{{name}}">{{name}}</a></h2>\n      <span>{{count}}张图片&nbsp;|&nbsp;{{favorite_count}}人收藏</span>\n    </div>\n    <a class="lev0" href="/album/?id={{id}}" target="_blank" >\n\n    {{#each top_blogs}}\n      {{#ifCond @index \'===\' 0}}\n      <img width="164" height="164" src="{{dtImageTrans photo_url true 164 164 \'c\'}}" alt="{{name}}">\n      {{else}}\n      <img width="80" height="80" src="{{dtImageTrans photo_url true 80 80 \'c\'}}" alt="{{../name}}">\n      {{/ifCond}}\n    {{/each}}\n    </a>\n    <ul>\n      <li><a class="nc" href="/people/?user_id={{user.id}}"><img src="{{user.avatar}}" width="24" height="24"/>{{user.username}}</a></li>\n      {{#if desc}}\n      <li class="decpro"><u>&nbsp;</u>{{desc}}<i>&nbsp;</i></li>\n      {{/if}}\n      {{#ifCond isUersSelf \'!=\' true}}\n      <li class="decfav">\n        <a href="javascript:;" class="albumlikebtn{{#ifCond like_id \'!=\' 0}} albumliked{{/ifCond}}"  data-albumlike=\'{"id":"{{id}}"}\'>喜欢</a>\n      </li>\n      {{/ifCond}}\n    </ul>\n  </div>\n</div>\n{{/each}}\n</script>\n<!--peopleDetail页面瀑布流模版-->\n<script id="mod4" type="text/x-handlebars-template">\n{{#each list}}\n<div class="woo" data-id="{{id}}" data-ht="358">\n  <div class="dt-xitem-img">\n    <img alt="{{name}}" src="{{covers}}" />\n    <a href="/album/?id={{id}}" class="dt-xitem-icv" target="_blank"></a>\n  </div>\n  <div class="dt-xitem-desc">\n    <div class="dt-xitem-title">\n     <a target="_blank" href="/album/?id={{id}}">{{more name 24}}</a>\n    </div>\n    <div class="dt-xitem-attr">\n     <p>\n      {{#if isStaff}}\n        {{#ifCond status \'===\' 7}}\n          <a class="r blockthisalbum ohblocked " title="{{id}}" href="javascript:;">PASS</a>\n        {{else}}\n          <a class="r blockthisalbum {{oClass}}" title="{{id}}" href="javascript:;">{{oText}}</a>\n        {{/ifCond}}\n      {{/if}}\n      {{count}}张图片 <b>&middot;</b> {{favorite_count}}人收藏\n     </p>\n     <p class="dt-xitem-user">by <a target="_blank" href="/people/?user_id={{user.id}}">{{user.username}}</a></p>\n    </div>\n  </div>\n  <div class="dt-xitem-bt1"></div>\n  <div class="dt-xitem-bt2"></div>\n</div>\n{{/each}}\n</script>';
}, function(t, e) {
	var a = function(t, e) {
		return a["object" == typeof e ? "render" : "compile"].apply(a, arguments)
	};
	! function(t, e) {
		"use strict";
		t.version = "1.4.0", t.openTag = "<%", t.closeTag = "%>", t.parser = null, t.render = function(t, e) {
			var a = d(t);
			return void 0 === a ? u({
				id: t,
				name: "Render Error",
				message: "Not Cache"
			}) : a(e)
		}, t.compile = function(e, n) {
			function i(a) {
				try {
					return new r(a).template
				} catch(i) {
					return o ? (i.id = e || n, i.name = "Render Error", i.source = n, u(i)) : t.compile(e, n, !0)(a)
				}
			}
			var o = arguments[2];
			"string" != typeof n && (o = n, n = e, e = null);
			try {
				var r = c(n, o)
			} catch(s) {
				return s.id = e || n, s.name = "Syntax Error", u(s)
			}
			return i.prototype = r.prototype, i.toString = function() {
				return r.toString()
			}, e && (a[e] = i), i
		}, t.helper = function(t, e) {
			l[t] = e
		};
		var a = {},
			n = "".trim,
			i = n && !e.document,
			o = {},
			r = function() {
				var t = Array.prototype.forEach || function(t, e) {
					for(var a = this.length >>> 0, n = 0; a > n; n++) n in this && t.call(e, this[n], n, this)
				};
				return function(e, a) {
					t.call(e, a)
				}
			}(),
			s = Object.create || function(t) {
				function e() {}
				return e.prototype = t, new e
			},
			l = t.prototype = {
				$forEach: r,
				$render: t.render,
				$getValue: function(t) {
					return void 0 === t ? "" : t
				}
			};
		r("break,case,catch,continue,debugger,default,delete,do,else,false,finally,for,function,if,in,instanceof,new,null,return,switch,this,throw,true,try,typeof,var,void,while,with,abstract,boolean,byte,char,class,const,double,enum,export,extends,final,float,goto,implements,import,int,interface,long,native,package,private,protected,public,short,static,super,synchronized,throws,transient,volatile,arguments,let,yield".split(","), function(t) {
			o[t] = !0
		});
		var c = function(e, a) {
				function i(t) {
					return v += t.split(/\n/).length - 1, t = t.replace(/('|"|\\)/g, "\\$1").replace(/\r/g, "\\r").replace(/\n/g, "\\n"), t = y[1] + "'" + t + "'" + y[2], t + "\n"
				}

				function c(t) {
					var e = v;
					return h ? t = h(t) : a && (t = t.replace(/\n/g, function() {
						return v++, "$line=" + v + ";"
					})), 0 === t.indexOf("=") && (t = t.substring(1).replace(/[\s;]*$/, ""), n && (t = "$getValue(" + t + ")"), t = y[1] + t + y[2]), a && (t = "$line=" + e + ";" + t), d(t), t + "\n"
				}

				function d(t) {
					t = t.replace(/\/\*.*?\*\/|'[^']*'|"[^"]*"|\.[\$\w]+/g, ""), r(t.split(/[^\$\w\d]+/), function(t) {
						if(/^this$/.test(t)) throw {
							message: 'Prohibit the use of the "' + t + '"'
						};
						!t || o.hasOwnProperty(t) || /^\d/.test(t) || b.hasOwnProperty(t) || (u(t), b[t] = !0)
					})
				}

				function u(t) {
					var e;
					e = "print" === t ? _ : "include" === t ? x : l.hasOwnProperty(t) ? "$helpers." + t : "$data." + t, w += t + "=" + e + ","
				}
				var f = t.openTag,
					p = t.closeTag,
					h = t.parser,
					m = e,
					g = "",
					v = 1,
					b = {
						$out: !0,
						$line: !0
					},
					w = "var $helpers=this," + (a ? "$line=0," : ""),
					y = n ? ["$out='';", "$out+=", ";", "$out"] : ["$out=[];", "$out.push(", ");", "$out.join('')"],
					k = n ? "if(content!==undefined){$out+=content;return content}" : "$out.push(content);",
					_ = "function(content){" + k + "}",
					x = "function(id,data){if(data===undefined){data=$data}var content=$helpers.$render(id,data);" + k + "}";
				r(m.split(f), function(t, e) {
					t = t.split(p);
					var a = t[0],
						n = t[1];
					1 === t.length ? g += i(a) : (g += c(a), n && (g += i(n)))
				}), m = g, a && (m = "try{" + m + "}catch(e){e.line=$line;throw e}"), m = w + y[0] + m + "this.template=" + y[3];
				try {
					var C = new Function("$data", m),
						P = C.prototype = s(l);
					return P.toString = function() {
						return this.template
					}, C
				} catch(T) {
					throw T.temp = "function anonymous($data) {" + m + "}", T
				}
			},
			d = function(e) {
				var n = a[e];
				if(void 0 === n && !i) {
					var o = document.getElementById(e);
					return o && t.compile(e, o.value || o.innerHTML), a[e]
				}
				return a.hasOwnProperty(e) ? n : void 0
			},
			u = function(t) {
				function a() {
					return a + ""
				}
				var n = "[template]:\n" + t.id + "\n\n[name]:\n" + t.name;
				return t.message && (n += "\n\n[message]:\n" + t.message), t.line && (n += "\n\n[line]:\n" + t.line, n += "\n\n[source]:\n" + t.source.split(/\n/)[t.line - 1].replace(/^[\s\t]+/, "")), t.temp && (n += "\n\n[temp]:\n" + t.temp), e.console && console.error(n), a.toString = function() {
					return "{Template Error}"
				}, a
			}
	}(a, this), "undefined" != typeof t && t.exports && (t.exports = a)
}, function(t, e, a) {
	(function(t) {
		var e = a(1);
		a(41),
			function(a, n) {
				var i, o, r, s, l, c, d, u = (a.location, e(a)),
					f = e.History,
					p = 0,
					h = !1,
					m = !1,
					g = !1,
					v = !1,
					b = !1,
					w = [],
					y = [],
					k = function(t) {
						k.init(t)
					};
				e.extend(k, {
					dfConf: {
						formprefix: "#woo-form-",
						frame: ["#woo-holder", ".woo-swa", ".woo-swb", ".woo-pcont", ".woo-pager", ".woo-masned"],
						gopre: null,
						gonext: null,
						gotop: null,
						footer: null,
						unit: ".woo",
						anchor: "woo-anchor",
						anchordiff: 70,
						sink: e(null),
						sinkheight: 0,
						sinkright: !1,
						unitsnum: 24,
						subpagenum: 4,
						scrollwait: 100,
						lbias: 400,
						appendnum: 12,
						batchopen: !1,
						batchdelay: 6,
						batchnum: 2,
						nearbypagenum: 3,
						ajaxdatatype: "text",
						ajaxcache: !1,
						resize: !1,
						refreshwhenswitch: !1,
						exrecycle: !1,
						exrecycletop: .5,
						exrecyclebot: 1,
						onScroll: function(t) {},
						onFirstArrange: function(t) {},
						onOnePageOver: function(t, e) {},
						onLazyAddOver: function(t, e) {},
						onTabSwitch: function(t, e, a, n, i) {},
						beforeImageLoad: function(t) {
							return t
						},
						requestAlways: function(t, e) {}
					},
					init: function(t) {
						if("string" == typeof t.arrsplit) {
							var a = t.arrsplit;
							t.arrsplit = []
						}
						if("number" == typeof t.arrmasnw) {
							var n = t.arrmasnw;
							t.arrmasnw = []
						}
						if("number" == typeof t.arrmessw) {
							var o = t.arrmessw;
							t.arrmessw = []
						}
						if("number" == typeof t.arrmargin) {
							var r = t.arrmargin;
							t.arrmargin = []
						}
						if("number" == typeof t.arrfmasnw) {
							var s = t.arrfmasnw;
							t.arrfmasnw = []
						}
						if("number" == typeof t.arrgap) {
							var l = t.arrgap;
							t.arrgap = []
						}
						for(var p = 0; p < t.arrform.length; p++) a !== h && t.arrsplit.push(a), n !== h && t.arrmasnw.push(n), o !== h && t.arrmessw.push(o), r !== h && t.arrmargin.push(r), s !== h && t.arrfmasnw.push(s), l !== h && t.arrgap.push(l);
						k._varClean(), this.conf = e.extend({}, this.dfConf, t);
						var h, t = this.conf,
							g = t.frame,
							v = e(g[1]),
							b = e(g[2]);
						this.$holder = c = e(g[0]), c.length && v.length && b.length && (this.$conts = b, this.$gonext = e(t.gonext), this.$gopre = e(t.gopre), this.$gotop = e(t.gotop), this.$footer = e(t.footer), d = k.WooTemp, i = u.height(), (f && !f.getHash() || !f) && k._switch(v, b), f && f.bind(function(t) {
							m ? m = !1 : k._switch(v, b);
							var e = t.split("-p"),
								a = parseInt(e[1]) || 1;
							a > 1 ? k.$gopre.css("display", "block") : k.$gopre.css("display", "none")
						}), this.setClickGoPre(), this.setClickGoNext(), this.setClickGoTop(), u.unbind("scroll.woo").bind("scroll.woo", k._winScroll), u.unbind("resize.woo").bind("resize", k._winResize))
					},
					_varClean: function() {
						h = !1, m = !1, g = !1, v = !1, w = [], y = [], k.masn = [], k.pagine = []
					},
					_winScroll: function() {
						g = !0, a.clearTimeout(l), l = a.setTimeout(function() {
							g = !1
						}, k.conf.scrollwait);
						var t = u.scrollTop();
						k.$gotop.css("visibility", t > 100 ? "visible" : "hidden")
					},
					_winResize: function() {
						k.throttle(function() {
							i = u.height();
							var t = k.conf;
							t.resize && !t.exrecycle && o != (o = u.width()) && k.resize()
						}, 100)
					},
					$holder: e(null),
					masn: [],
					pagine: [],
					resetCol: function(t, e, a) {
						var n = c.find(this.conf.frame[5] + ":visible").not(".woo-tmpmasn"),
							i = k._getDataColY(n);
						if(i && i[e]) {
							i[e] += t;
							var o = Math.max.apply(Math, i);
							n.data("colY", i).css({
								height: o
							}), c.find("div.co" + e).each(function(e, n) {
								var i = parseInt(n.style.top);
								i > a && (n.style.top = i + t + "px")
							})
						}
					},
					throttle: function(t, e) {
						a.clearTimeout(k.throttle.timer), k.throttle.timer = setTimeout(function() {
							t.call(this)
						}, e)
					},
					resize: function() {
						for(var t = 0; t < y.length; t++) {
							var e = y[t];
							t === p && e ? (e.setCols(), e.figure(), e.arrangeContents(!0)) : e && e.resetDomWidth()
						}
					},
					recurseDo: function(t, n, i, o, r) {
						return 0 == i ? void(e.isFunction(r) && r()) : (n = t.apply(null, n), void(n[0].length ? a.setTimeout(function() {
							k.recurseDo(t, n, --i, o, r)
						}, o) : e.isFunction(r) && r()))
					},
					getFormAction: function(t) {
						return encodeURI(t.attr("action"))
					},
					paramForm: function(t, a) {
						var i = {};
						return e("input,select,textarea", t).not("[type=submit]").filter("[name]").each(function(t, a) {
							(("checkbox" === e(a).attr("type") || "radio" === e(a).attr("type")) && e(a).prop("checked") === !0 || "checkbox" !== e(a).attr("type") && "radio" !== e(a).attr("type")) && (i[a.name] !== n ? i[a.name] += "," + a.value : i[a.name] = a.value)
						}), e.isPlainObject(a) && e.extend(i, a), e.param(i)
					},
					scrollTo: function(a, n, i) {
						if("undefined" != typeof t) return void e("body,html").animate({
							scrollTop: a
						}, n, i);
						var o = parseInt(document.body.scrollTop),
							r = 0,
							s = 10;
						a = parseInt(a), n /= s;
						var l = setInterval(function() {
							r++, document.body.scrollTop = (a - o) / n * r + o, document.documentElement.scrollTop = (a - o) / n * r + o, r >= n && (e.isFunction(i) && i(), clearInterval(l))
						}, s)
					},
					scrollToAnchor: function() {
						var t = (e("body,html"), k.conf);
						if($tohsh = e("a[name=" + t.anchor + "]"), t.anchor && $tohsh.length) {
							var n = $tohsh.offset().top - t.anchordiff || 0;
							k.scrollTo(n, 200)
						} else a.ActiveXObject && !a.XMLHttpRequest && k.scrollTo(n, 200)
					},
					_clickGoTop: function(t) {
						t.preventDefault(), t.stopPropagation(), v = !0;
						var a = this;
						e("body,html");
						k.scrollTo(0, 200, function() {
							a.style.visibility = "hidden", v = !1
						})
					},
					setClickGoTop: function() {
						k.$gotop.unbind("click.woo").bind("click.woo", k._clickGoTop)
					},
					_clickGoPre: function(t) {
						t.preventDefault(), k._clickGo.call(this, -1)
					},
					setClickGoPre: function() {
						k.$gopre.unbind("click.woo").bind("click.woo", k._clickGoPre)
					},
					_clickGoNext: function(t) {
						t.preventDefault(), k._clickGo.call(this, 1)
					},
					setClickGoNext: function() {
						k.$gonext.unbind("click.woo").bind("click.woo", k._clickGoNext)
					},
					_clickGo: function(t) {
						var a = k.conf;
						if(e(this).css("display", "none"), w && w[p] && y && y[p]) {
							var n = c.find(a.frame[4] + ":visible"),
								i = n.find(".woo-pbr").length,
								o = w[p] && w[p].hasNextUpperPage,
								r = i && o ? !1 : !0;
							if(i && !o) return;
							w[p].isPagerClick = !0, r && (w[p].loading = !1, w[p].lazyAdding = !0, w[p].halting = !0), w[p].slidePage(t, !0)
						}
					},
					_switch: function(t, a) {
						var n = k.conf,
							o = n.frame,
							r = n.arrform;
						t.unbind("click.woo").tabswitch(function(t, n, o, s, l) {
							var c = (t.eq(o), k._getPageNumFromHash());
							if(e.Woo.conf.onTabSwitch(t, n, o, s, l), l) {
								if(c = w[o] && o != s && !k.conf.refreshwhenswitch ? w[o].getPageNum() : 1, h = !0, m = !0, f) {
									var d = "!" + r[o];
									f.setHash(d + (c > 1 ? "-p" + c : ""))
								}
								n.eq(o).find(k.conf.frame[3]).last().css("height", i)
							} else;
							w[s] && (w[s].idata = [], w[s].$data = e(null)), k._pageInit(a, o, c)
						}, {
							event: "click.woo",
							focus: "woo-cur",
							cont: o[2],
							index: k._getFocusIdx(t)
						})
					},
					_pageInit: function(t, n, i) {
						k.idx = p = n, b = !1, a.clearTimeout(r);
						var o = this.conf,
							l = o.frame,
							c = o.arrform,
							u = o.arrsplit,
							f = o.arrmasnw,
							m = o.arrmessw,
							g = o.arrmargin,
							v = o.arrfmasnw,
							_ = o.arrgap,
							x = e.isArray(u) ? u[n] : "",
							C = t.eq(n),
							P = C.find(l[3]).not(".woo-tmpmasn"),
							T = C.find(l[4]),
							$ = parseInt(P.data("totalunits")),
							I = isNaN($),
							S = P.data("wootemp") || 0,
							j = P.data("subpagenum") || o.subpagenum,
							A = P.data("unitsnum") || o.unitsnum,
							G = e(P.data("sink") ? P.data("sink") : o.sink),
							H = P.data("sinkheight") || o.sinkheight,
							F = !!P.data("sinkright") || o.sinkright,
							D = I ? 2 : Math.ceil($ / A),
							U = !!v[n],
							O = f[n],
							z = e.isArray(m) ? m[n] : null,
							O = z ? O - z : O,
							L = g[n],
							N = _[n],
							R = U ? O + v[n] : O,
							q = R != O,
							E = D > 2 ? !1 : !0;
						if(this.$footer.css("display", 1 == D ? "block" : "none"), w[n])(w[n].lazyAdding || w[n].loading) && h || (w[n].lazyAdding = !0, w[n].scrollLoading = !0, y[n].standardUnitCount = 0, y[n].setCols(), w[n].refreshPage(i));
						else {
							var M, W = e(null);
							this.masn[n] = y[n] = new k.Masn(P, {
								unit: o.unit,
								gap: N || 0,
								onAppend: k._doLoadImage,
								onFirstArrange: o.onFirstArrange,
								onArrange: function(t) {
									t.length && (M = 2, W = t), w[n] && (w[n].caching = 1, w[n].$data = t), s && a.clearTimeout(s), k._onscroll()
								},
								initAppendCounts: A,
								sinkWhat: G,
								firstHeight: H,
								rightAlignFirstBlock: F,
								specialColumnOpen: q,
								firstColumnWidth: R,
								columnMessWidth: z,
								columnWidth: O,
								columnMargin: L,
								batchOpen: o.batchopen,
								batchDelay: o.batchdelay,
								batchNum: o.batchnum
							}), this.pagine[n] = w[n] = new k.Pagine([P, T], {
								identity: "!" + c[n],
								arrRequestUrl: [e(o.formprefix + c[n])[0], x],
								requestAlways: o.requestAlways,
								onOnePageOver: o.onOnePageOver,
								ajaxDataType: o.ajaxdatatype,
								ajaxCache: o.ajaxcache,
								scrollBias: o.lbias,
								nearbyPageNum: o.nearbypagenum,
								subPageNum: j,
								unitsPerSub: A,
								currentUpperPage: i,
								totalPageNum: D,
								caching: M,
								$data: W,
								nextMode: E,
								analyzeResponse: d ? d.analyzeResponse[S] : e.noop,
								lazyAdd: function(t) {
									var i = this,
										o = i.config;
									if(0 === i.$data.length && 0 === i.idata.length) return i.caching = 0, void(i.isLastSub() && i.showFooter());
									i.lazyAdding = !0, i.caching = 1;
									var r = i.$data,
										s = i.idata,
										l = r && r.length || 0,
										c = s && s.length || 0,
										u = l + c,
										f = t ? Math.max(u + 1, o.unitsPerSub) : k.conf.appendnum,
										h = l + c - f,
										m = !1;
									t && y[n] && (y[n].clearColY(), m = !0);
									var g, v;
									l >= f ? (g = r.slice(0, f), i.$data = r.slice(f)) : (g = r, i.$data = e(null), v = s.slice(0, f - l), i.idata = s.slice(f - l));
									var b = d && d.render[S] ? d.render[S](v) : v;
									y[n].appendContents(g, b, !1, !1, m, k.conf.batchnum, function() {
										if(0 >= h) {
											i.caching = 0;
											var t = i.currentPage,
												e = o.subPageNum;
											t % e === 0 && i.currentPage != i.totalPageNum && a.setTimeout(function() {
												i.prepareNext()
											}, 400), i.isLastSub() && i.showFooter()
										} else i.caching = h <= o.unitsPerSub ? 1 : 2, i.$pager.css({
											height: 0,
											overflow: "hidden"
										});
										a.setTimeout(function() {
											i.lazyAdding = !1, k.conf.onLazyAddOver(i, p)
										}, 200)
									})
								}
							})
						}
						h = !1, k.$gonext.css("visibility", "hidden")
					},
					_getIdentityFromHash: function() {
						var t = "";
						return f && (t = f.getHash(), t = t.split("-")[0]), t
					},
					_getPageNumFromHash: function() {
						var t = 1;
						if(f) {
							var e = f.getHash();
							e = e.split("-p")[1], e && (t = parseInt(e) || t)
						}
						return t
					},
					_getFocusIdx: function(t) {
						for(var a = k.conf.arrform, n = k._getIdentityFromHash().substr(1), i = -1, o = 0; o < a.length; o++)
							if(a[o] === n) {
								i = o;
								break
							}
						return -1 === i && t.each(function(t, a) {
							e(a).hasClass("woo-cur") && (i = t)
						}), i = -1 === i ? 0 : i
					},
					_onscroll: function() {
						var t = u.scrollTop();
						if(!v && !b && (w[p] && w[p].hasTouchedBottom() && (w[p].doLazyAdd(), w[p].doLoadNext()), !g && (k.conf.onScroll(t), c.length))) {
							var e = k.conf,
								n = k.$gopre,
								i = k.$gonext,
								o = c.find(e.frame[4] + ":visible"),
								r = o.find(".woo-pbr").length,
								l = w[p] && w[p].hasNextUpperPage;
							n.add(i).css("visibility", t > c.position().top && (!r || r && l) ? "visible" : "hidden")
						}
						if(k.conf.exrecycle && y[p]) {
							var d = y[p],
								f = y[p].$dom,
								h = f.position().top;
							d.exRecycleInvisibleUnits(t, h, 1, 4, -1), d.exRecycleInvisibleUnits(t, h, 0, 3, 1)
						}
						a.clearTimeout(s), s = a.setTimeout(k._onscroll, 100)
					},
					_doLoadImage: function(t) {
						t.find("img[srcd]").each(function(t, n) {
							var i = e(n),
								o = i.attr("srcd");
							e.isFunction(e.Woo.conf.beforeImageLoad) && (o = e.Woo.conf.beforeImageLoad(o)), o && i.css("display", "none").one("load", function(t) {
								e(this).css({
									visibility: "visible"
								}).fadeIn(400)
							}).one("error", function() {
								var t = e(this);
								a.setTimeout(function() {
									t.one("error", function() {
										t.attr("src", o)
									}).attr("src", o)
								}, 1e3)
							}).attr("src", o).removeAttr("srcd")
						})
					},
					_getDataColY: function(t) {
						var e = t.data("colY");
						return e
					}
				}), k.Pagine = function(t, e) {
					this.init(t, e)
				}, k.Pagine.prototype = {
					init: function(t, a) {
						this.config = e.extend({}, a);
						var n = this,
							i = n.config,
							o = i.currentUpperPage,
							r = i.subPageNum;
						n.hasNextUpperPage = !0, n.caching = i.caching, n.$data = i.$data || e(null), n.idata = [], n.$dom = t[0], n.$pager = t[1], n.unitsPerSub = i.unitsPerSub, n.totalPageNum = i.totalPageNum, n.currentUpperPage = o, n.currentPage = (o - 1) * r + 1, n.$loadingsm = e('<div id="woo-loading" class="woo-loading"></div>');
						var s = i.arrRequestUrl;
						"object" === e.type(s[0]) && "form" === s[0].tagName.toLowerCase() && (n.arrurl = s), n.$dom.find(":first-child").length ? o > 1 ? (n.clearCont = !0, n.loadPage(n.currentPage, 1)) : n.setPager() : (n.clearCont = !1, n.loadPage(n.currentPage, 1))
					},
					loadPage: function(t, e, a) {
						if(this.loading) return void(this.scrollLoading = !1);
						var n = this,
							i = n.config,
							o = i.subPageNum,
							r = e && (t % o === 1 || 1 == o),
							s = !1;
						!e && k.scrollToAnchor(), n.$pager.css("display", "none"), n.pagerVisible = !1, n.loading = !0, n.currentUpperPage = t, o > 1 && !e ? t = (t - 1) * o + 1 : o > 1 && e && (n.currentUpperPage = Math.floor((t - .1) / o) + 1), e && !r || !n.clearCont || (n.changeHashOnFirstLoad(i.identity, n.currentUpperPage), h = !0, s = !0, n.$dom.empty()), n.isPagerClick = !1, n._requestData(t, e, a, !1, s)
					},
					getPageNum: function() {
						return this.currentUpperPage
					},
					gotoPage: function(t) {
						var e = this;
						e.clearCont = !0, e.loadPage(t, !1, !0)
					},
					refreshPage: function(t) {
						var a = this,
							n = t || a.currentUpperPage;
						a.$data = e(null), a.idata = [], a.caching = 0, a.halting = !0, a.loading = !1, a.gotoPage(n)
					},
					slidePage: function(t, e) {
						var a = this,
							n = a.currentUpperPage;
						a.clearCont = !0, a.loadPage(n + t, !1, e)
					},
					slideSubPage: function(t) {
						var e = this,
							a = e.currentPage;
						e.clearCont = !0, e.loadPage(a + t, 1)
					},
					jumpPage: function() {
						var t = this,
							e = t.$pager.find("[type=text]").val() || 0;
						e && (t.clearCont = !0, t.loadPage(e))
					},
					prepareNext: function() {
						var t = this,
							e = t.currentPage;
						t.prepare && t.prepare[0] === e + 1 || t._requestData(e + 1, !0, !1, !0)
					},
					requestOver: function(t, e, a, n, i) {
						var o = this,
							r = o.config,
							s = !o.$dom.find(":first-child").length,
							l = r.subPageNum,
							c = t % l === 1;
						o.hasNoMore = !n, o.currentPage = t, o.caching = 2, i && (o.totalPageNum = Math.ceil(i / r.unitsPerSub)), s && (o.loading = !0);
						var d = r.nextMode,
							u = o.currentPage,
							f = (o.currentUpperPage || u, o.totalPageNum),
							p = o.$loadingsm;
						o.$dom.removeClass("woo-loading"), o.isLastSub() || p.css("visibility", "hidden"), d || u === f ? n ? o.totalPageNum = u + 1 : o.totalPageNum = u : d || (n ? u > f && (o.totalPageNum = u + 1) : o.totalPageNum = u), o.loadFromJson(a, s), (!e || c || o.isLastSub()) && o.setPager(), o.caching ? o.$pager.css({
							display: "block",
							height: 0,
							overflow: "hidden"
						}) : o.isLastSub() && o.$pager.css({
							display: "block",
							height: "auto"
						}), o.pagerVisible = !0
					},
					loadFromJson: function(t, e) {
						var a = this,
							n = a.config;
						a.idata = a.idata.concat(t), n.lazyAdd.call(a, e)
					},
					_requestAlways: function() {
						var t = this,
							a = t.config;
						t.loading = !1, t.$dom.removeClass("woo-loading"), t.$loadingsm.css("visibility", "hidden"), e.isFunction(a.requestAlways) && a.requestAlways(t, p)
					},
					_beforeRequest: function(t) {
						var n = this,
							i = n.$loadingsm;
						n.$pager.after(i), k.$footer.css("display", "none"), t ? (n.$dom.addClass("woo-loading"), i.css("visibility", "hidden"), d && d.reset && d.reset(), n.idata = [], n.$data = e(null), s && a.clearTimeout(s), k._onscroll()) : i.css("visibility", "visible")
					},
					_requestData: function(t, n, i, o, r) {
						var s = this,
							l = s.config,
							c = (l.subPageNum, s.arrurl);
						if(c)
							if(!o && s._beforeRequest(r), s.prepare && s.prepare[0] == t) d && d.setUnitsFromLatest && d.setUnitsFromLatest(), s.requestOver(t, n, s.prepare[1], s.prepare[2], s.prepare[3]), s.prepare = null, a.setTimeout(function() {
								s._requestAlways()
							}, 50), s.scrollLoading = !1;
							else {
								var u = e(c[0]),
									f = {};
								f = u.serializeObject();
								var p = k.getFormAction(u);
								p.match("^/napi/") ? f.start = (t - 1) * (c[1] || 24) : p += t + c[1], e.ajax({
									type: "GET",
									dataType: l.ajaxDataType,
									cache: !!l.ajaxCache,
									url: p,
									data: f,
									timeout: 2e4,
									success: function(a) {
										if(!s.halting || i) {
											i && (s.halting = !1, s.$dom.empty()), d && d.resetLatestUnits && d.resetLatestUnits();
											var r = l.analyzeResponse(a);
											if(o) {
												s.prepare = [t, r[0], r[1], r[2]];
												var c = [];
												e(r[0]).find("img[srcd]").each(function(t, a) {
													var n = e(a);
													c.push(n.attr("srcd"))
												}), k.recurseDo(function(t) {
													return(new Image).src = t.splice(0, 1), [t]
												}, [c], c.length, 200)
											} else s.requestOver(t, n, r[0], r[1], r[2]);
											s.scrollLoading = !1, s._requestAlways()
										}
									},
									error: function(a, i) {
										o || (e('<div id="woo-retry" style="text-align:center;padding:12px 0 0;height:28px">网络繁忙，<a href="javascript:;">点此重试~</a></div>').click(function(a) {
											a.stopPropagation(), a.preventDefault(), s._requestData(t, n), e(this).remove(), s.$loadingsm.css("display", "block")
										}).insertAfter(s.$dom), s.$loadingsm.css("display", "none")), s._requestAlways()
									}
								})
							}
					},
					hasNextUpperPage: function() {
						var t = this;
						return t.hasNextUpperPage
					},
					isLastSub: function() {
						var t = this;
						return t.currentPage % t.config.subPageNum === 0 || t.currentPage === t.totalPageNum
					},
					showFooter: function() {
						var t = this;
						t.$pager.css({
							height: "auto"
						}), k.$footer.css("display", "block"), t.$loadingsm.remove(), a.clearTimeout(r), r = a.setTimeout(function() {
							t.isLastSub() && 0 === t.$data.length && 0 === t.idata.length && (b = !0, k.conf.exrecycle || a.clearTimeout(s))
						}, 200), t.config.onOnePageOver(t, p)
					},
					setPager: function() {
						var t = this,
							e = t.config,
							a = t.currentUpperPage,
							n = e.nearbyPageNum,
							i = t.totalPageNum,
							o = e.subPageNum,
							r = "";
						i = Math.floor((i - .1) / o) + 1, (e.nextMode && a >= i || !e.nextMode && a >= i) && t.hasNoMore && (t.hasNextUpperPage = !1), t.isLastSub() ? (r = ['<div class="woo-pbr woo-mpbr"><ul class="woo-dib">', 1 == a ? "" : '<li><a class="woo-pre" href="javascript:;" pdir="-1" >上一页</a></li>', 1 == a ? '<li class="woo-cur">1</li>' : '<li><a href="javascript:;">1</a></li>', a - n > 2 ? '<li class="woo-ell" >…</li>' : "", function() {
							for(var t = "", e = a - n; a + n >= e; e++) e == a && 1 != e ? t += '<li class="woo-cur">' + e + "</li>" : e > 1 && i >= e && (t += '<li><a href="javascript:;">' + e + "</a></li>");
							return t
						}(), i - 1 > a + n && !e.nextMode ? '<li class="woo-ell" >…</li>' : "", i > a + n && !e.nextMode ? '<li><a href="javascript:;">' + i + "</a></li>" : "", a == i ? "" : (e.nextMode ? '<li class="woo-ell" >…</li>' : "") + '<li><a class="woo-nxt" href="javascript:;"  pdir="1">下一页</a></li>', "</ul></div>"].join(""), t.$pager.find(".woo-mpbr").remove(), t.$pager.append(r)) : (t.$pager.find(".woo-mpbr").remove(), t.$pager.append(r)), t.addEventOnPagerClick();
						var s = k.$gonext;
						s.css("display", "block"), t.$pager.find(".woo-pbr").length && s.css("visibility", t.hasNextUpperPage ? "visible" : "hidden"), t.pagerVisible = !0, t.doLazyAdd()
					},
					changeHashOnFirstLoad: function(t, e) {
						var a = this,
							n = t + (e > 1 ? "-p" + e : ""),
							i = f.getHash();
						(i || a.isPagerClick) && i !== n && f.setHash(n)
					},
					_pagerClick: function(t) {
						var a = t.data.pager,
							n = t.target;
						if(n && n.tagName && "a" != n.tagName.toLowerCase() && (n = e(n).closest("a")[0]), a.$pager && n && n.tagName && "a" === n.tagName.toLowerCase() && !e(n).closest(".woo-nopagine", a.$pager.get(0)).length) {
							t.preventDefault(), t.stopPropagation();
							var i = parseInt(n.innerHTML),
								o = n.getAttribute("pdir");
							a.isPagerClick = !0, i ? a.gotoPage(i) : "jump" === o ? a.jumpPage() : "sub" === o ? a.slideSubPage(1) : (o = parseInt(o)) && a.slidePage(o)
						}
					},
					addEventOnPagerClick: function() {
						var t = this;
						t.$pager.unbind("click.woo").bind("click.woo", {
							pager: t
						}, t._pagerClick)
					},
					hasTouchedBottom: function(t) {
						var e = this,
							a = e.config,
							t = t === n ? u.scrollTop() : t,
							o = k._getDataColY(e.$dom),
							r = e.$dom.offset().top + (parseInt(e.$dom.get(0).style.height) || 0) - t - i,
							s = Math.max.apply(Math, o),
							l = Math.min.apply(Math, o);
						return r < a.scrollBias || s - l > r
					},
					doLazyAdd: function() {
						var t = this,
							e = t.config;
						!t.lazyAdding && t.pagerVisible && t.caching && e.lazyAdd.call(t)
					},
					doLoadNext: function() {
						var t = this;
						t.config;
						t.lazyAdding || t.halting || t.scrollLoading || !t.pagerVisible || !(t.caching < 2) && t.caching || t.isLastSub() || (t.scrollLoading = !0, t.slideSubPage(1))
					}
				}, k.Masn = function(t, e) {
					this.init(t, e)
				}, k.Masn.prototype = {
					init: function(t, a) {
						this.opts = e.extend({}, a);
						var n = this;
						n.$dom = e(t), n.domInitWidth = n.$dom.data("domwidth") || "auto", n.figure(), n.arrangeContents(), n.opts.onFirstArrange(p)
					},
					figure: function() {
						var t = this,
							a = t.$dom,
							n = t.opts,
							i = e("<div>");
						a.css({
							position: "relative"
						}), t.colwf = t.colw = n.columnWidth, n.firstColumnWidth && (t.colwf = n.firstColumnWidth), t.setCols(), t.clearColY(), a.prepend(i), t.offset0 = i.offset(), t.domtop0 = a.offset().top, t.left0 = Math.round(i.position().left), i.remove(), n.firstHeight && (t.firstWidth = t.colwf, t.firstHeight = n.firstHeight)
					},
					clearColY: function() {
						var t = this,
							e = [];
						if(t.unitCount = 0, t.standardUnitCount = 0, k.conf.exrecycle) {
							t.arrColumnTail = [], t.posCoordination = {}, t.columnVisibleRange = [
								[],
								[]
							], t.unitCache = {};
							for(var a = 0; a < t.colCount; a++) t.columnVisibleRange[0][a] = t.columnVisibleRange[1][a] = a, e[a] = 0
						} else
							for(var a = 0; a < t.colCount; a++) e[a] = 0;
						t.$dom.data("colY", e)
					},
					exIsUnitVisible: function(t, e, a, n) {
						var o = k.conf.exrecycletop,
							r = k.conf.exrecyclebot,
							s = o > -10 && 10 > o ? o * i : o,
							l = r > -10 && 10 > r ? r * i : r,
							c = -1,
							d = e + a + n,
							u = e + a,
							f = t - s,
							p = t + i + l;
						return d >= f && p >= u ? c = 0 : f > d && (c = 1), c
					},
					exRecycleInvisibleUnits: function(t, e, a, i, o) {
						for(var r, s = this, l = 0, c = 0, d = 0; d < s.colCount; d++) {
							for(r = s.columnVisibleRange[1 & a][d], c = s.columnVisibleRange[1 ^ a][d]; l >= 0 && l < s.unitCount;) {
								l = r;
								var u = s.posCoordination["" + l];
								if(u === n) break;
								var f = s.exIsUnitVisible(t, e, u[0], u[1]);
								if(f == o) break;
								if(0 !== f || u[5] || (s.unitCache["" + l] && s.unitCache["" + l].appendTo(s.$dom), u[5] = 1), s.columnVisibleRange[1 & a][d] = l, -1 == u[i] || u[i] == l) break;
								r = u[i]
							}
							for(; c >= 0 && c < s.unitCount;) {
								var u = s.posCoordination["" + c];
								if(u === n) break;
								var f = s.exIsUnitVisible(t, e, u[0], u[1]);
								if(0 == f || f == o) break;
								if(u[5] && (s.unitCache["" + c] && s.unitCache["" + c].remove(), u[5] = 0), -1 == u[i]) {
									s.columnVisibleRange[1 & a][d] = s.columnVisibleRange[1 ^ a][d];
									break
								}
								if(u[i] == c) break;
								c = s.columnVisibleRange[1 ^ a][d] = u[i]
							}
						}
					},
					setContHeight: function() {
						var t = this,
							e = k._getDataColY(t.$dom);
						t.$dom.css({
							height: Math.max.apply(Math, e.concat(i - t.domtop0))
						}).data("colY", e)
					},
					setCols: function() {
						var t, e = this,
							a = e.opts,
							n = e.$dom,
							i = a.columnMessWidth || 0,
							o = i ? a.columnMargin : 0;
						e.resetDomWidth(), t = e.domWidth, e.colCount = Math.max(Math.floor((t + a.columnMargin - e.colwf + e.colw - i) / e.colw), 1), e.domWidth = e.colCount * e.colw + e.colwf - e.colw - a.columnMargin + i - o, n.css("width", e.domWidth)
					},
					resetDomWidth: function() {
						var t = this,
							e = t.$dom;
						e.css("width", t.domInitWidth), t.domWidth = "auto" === t.domInitWidth ? e.parent().width() : t.domInitWidth
					},
					arrangeContents: function(t) {
						var a, n, i = this,
							o = i.$dom,
							r = i.opts,
							s = r.initAppendCounts;
						if(a = o.children().filter(r.unit), n = a.length) {
							t && (s = n);
							var l = a.slice(0, s);
							a = a.slice(s).addClass("woo-wait"), i.appendContents(l, null, !0, t, !!r.firstHeight, s, e.noop), r.onAppend(l)
						}
						o.css("visibility", "visible"), e.isFunction(r.onArrange) && r.onArrange(a)
					},
					appendContents: function(t, a, n, i, o, r, s) {
						var l = this,
							c = l.opts,
							d = l.$dom,
							r = (k._getDataColY(d), r || c.batchNum),
							u = l._placeEachUnit(l, c, d, t, a, n, i, o && l.firstHeight),
							f = u[0],
							p = u[1];
						n ? (k.conf.exrecycle && p.each(function(t, e) {
							var a = p.eq(t);
							l.unitCache["" + a.data("idx")] = a
						}), c.onAppend(p), l.setContHeight()) : (f.appendTo(d), c.batchOpen ? k.recurseDo(function(t, a) {
							var n = 0;
							return k.conf.exrecycle ? t.each(function(i, o) {
								var r = t.eq(i);
								l.unitCache["" + r.data("idx")] = r, n++, e(o).append(a.eq(i).children())
							}) : t.each(function(t, i) {
								n++, e(i).append(a.eq(t).children())
							}), c.onAppend(t), t = t.slice(r), a = a.slice(n), l.setContHeight(), [t, a]
						}, [f, p], Math.ceil(f.length / r), c.batchDelay, function() {
							s()
						}) : (k.conf.exrecycle ? f.each(function(t, a) {
							var n = f.eq(t);
							l.unitCache["" + n.data("idx")] = n, e(a).append(p.eq(t).children())
						}) : f.each(function(t, a) {
							e(a).append(p.eq(t).children())
						}), l.setContHeight(), c.onAppend(f), s()))
					},
					prePlaceUnit: function(t, e, a, n, i) {
						var o, r, s, l, c, d = this,
							u = d.opts,
							f = a;
						for(o = Math.min.apply(Math, e); f--;) e[f] == o && (r = f);
						return d.colwf != d.colw && (0 === r && !u.rightAlignFirstBlock || r === a - 1 && u.rightAlignFirstBlock) && (c = d.colwf, !i && t.addClass("woo-spcol")), n && u.specialColumnOpen && t.removeData("ht").removeAttr("data-ht"), s = d.colw * r + d.left0 + (!u.rightAlignFirstBlock && r && d.colwf != d.colw ? d.colwf - d.colw : 0), l = i ? d.firstHeight : t.data("ht") || (t.outerHeight ? t.outerHeight(!0) : t.height() + (parseInt(t.css("margin-top")) || 0) + (parseInt(t.css("margin-bottom")) || 0)), e[r] += l + u.gap, [o, r, s, l, c]
					},
					_placeEachUnit: function(t, a, n, i, o, r, s, l) {
						var c, d, u, f, p, h, m, g, v = n.prev(),
							b = !!v.length,
							w = "",
							y = e(null),
							_ = k._getDataColY(n),
							x = t.colCount,
							C = 0,
							P = s && l;
						if(!b || b && !v.hasClass("woo-tmpmasn")) {
							var T = k.conf.frame,
								$ = ("." == T[3].indexOf(0) ? T[3].substr(1) : "") + " " + ("." == T[5].indexOf(0) ? T[5].substr(1) : "") + " woo-loading";
							v = e('<div class="woo-tmpmasn ' + n.attr("class") + '" style="position:relative;height:0;overflow:hidden;margin:0;padding:0;"></div>').removeClass($), n.before(v)
						}
						var I = i.add(o).removeClass("woo-wait"),
							S = r ? I.parent() : v.append(I);
						if(y = S.find(a.unit).not(".woo-f,.woo-wait").each(function(n, i) {
								var o = e(i),
									r = o.data("id");
								(0 === n && l && !a.rightAlignFirstBlock || n === x - 1 && l && a.rightAlignFirstBlock) && (c = t.prePlaceUnit(o, _, x, s, l), d = c[0], u = c[1], f = c[2], p = c[3], h = c[4], m = '<div class="woo woo-f co' + u + " " + (h ? "woo-spcol" : "") + '" data-ht="' + p + '" data-idx="' + t.unitCount + '" style="position:absolute;overflow:hidden;top:' + d + "px;left:" + f + "px;width:" + (t.firstWidth - a.columnMargin) + 'px;"></div>', w += m, g = P ? S.find(".woo-f:first").css({
									left: f,
									top: d
								}) : e(m).append(a.sinkWhat), g.data("idx", t.unitCount), C = n, k.conf.exrecycle && t.exCoordMap(d, p, u), t.unitCount++), c = t.prePlaceUnit(o, _, x, s), d = c[0], u = c[1], f = c[2], p = c[3], h = c[4], w += '<div class="' + a.unit.substr(1) + " co" + u + (h ? " woo-spcol" : "") + '" ' + (r ? 'data-id="' + r + '"' : "") + ' data-ht="' + p + '" data-idx="' + t.unitCount + '" style="top:' + d + "px;left:" + f + 'px;"></div>', o.css({
									top: d,
									left: f
								}).data("ht", p).data("idx", t.unitCount), o.removeClass(function(t, e) {
									return "woo-spcol " + (e.match(/co\d+/gi) || []).join(" ")
								}).addClass((h ? "woo-spcol " : "") + "co" + u), k.conf.exrecycle && t.exCoordMap(d, p, u), t.unitCount++, t.standardUnitCount++
							}), n.data("colY", _), !P && l) {
							var j = y.toArray();
							y = e(j.slice(0, C).concat(g ? g.toArray() : [], j.slice(C)))
						}
						return v.empty(), [e(w), y]
					},
					exCoordMap: function(t, e, n) {
						var i = this,
							o = i.arrColumnTail[n] || n;
						i.posCoordination["" + i.unitCount] = [t, e, n, o, -1, 0], i.posCoordination["" + o] && (i.posCoordination["" + o][4] = i.unitCount), i.arrColumnTail[n] = i.unitCount;
						var r = i.unitCount;
						a.setTimeout(function() {
							i.posCoordination["" + r][5] = 1
						}, 800)
					}
				}, e.Woo = k
			}(window)
	}).call(e, a(1))
}, function(t, e, a) {
	var n = a(1);
	a(42), n.extend(n.History, {
		getNoPageHash: function(t) {
			var e = t || window.location.hash.substr(1);
			return e.replace(/\-p\d+/gi, "")
		},
		getHashByIndex: function(t) {
			var e = window.location.hash.substr(1);
			return e = e.split("-")[t]
		},
		hashAnalize: function(t) {
			var e = t.indexOf(n.History.getHashByIndex(0));
			return e = 0 > e ? -1 : e
		}
	})
}, function(t, e, a) {
	(function(t) {
		! function(t) {
			t.History ? window.console.warn("$.History has already been defined...") : (t.History = {
				options: {
					debug: !1
				},
				timer: null,
				state: "",
				$window: null,
				$iframe: null,
				handlers: {
					generic: [],
					specific: {}
				},
				extractHash: function(t) {
					var e = t.replace(/^[^#]*#/, "").replace(/^#+|#+$/, "");
					return e
				},
				getState: function() {
					var e = t.History;
					return e.state
				},
				setState: function(e) {
					var a = t.History;
					return e = a.extractHash(e), a.state = e, a.state
				},
				getHash: function() {
					var e = t.History,
						a = e.extractHash(window.location.hash || location.hash);
					return a
				},
				setHash: function(e) {
					var a = t.History;
					return e = a.extractHash(e), "undefined" != typeof window.location.hash ? window.location.hash !== e && (window.location.hash = e) : location.hash !== e && (location.hash = e), e
				},
				go: function(e) {
					var a = t.History;
					e = a.extractHash(e);
					var n = a.getHash(),
						i = a.getState();
					return e !== n ? a.setHash(e) : (e !== i && a.setState(e), a.trigger()), !0
				},
				hashchange: function(e, a, n) {
					var i = t.History;
					if(i.nativeSupport || i.notSupportTrigger) i.firedFirstTime = !0, i.notSupportTrigger = !1;
					else if(i.nativeSupport = !0, i.timer && clearInterval(i.timer), i.firedFirstTime) return !1;
					var o = i.getHash();
					return i.go(o), !0
				},
				bind: function(e, a) {
					var n = t.History;
					return a ? ("undefined" == typeof n.handlers.specific[e] && (n.handlers.specific[e] = []), n.handlers.specific[e].push(a)) : (a = e, n.handlers.generic.push(a)), !0
				},
				trigger: function(e) {
					var a = t.History;
					"undefined" == typeof e && (e = a.getState());
					var n, i, o, r;
					if("undefined" != typeof a.handlers.specific[e])
						for(r = a.handlers.specific[e], n = 0, i = r.length; i > n; ++n)(o = r[n])(e);
					for(r = a.handlers.generic, n = 0, i = r.length; i > n; ++n)(o = r[n])(e);
					return !0
				},
				construct: function() {
					var e = t.History;
					return t(document).ready(function() {
						e.domReady()
					}), !0
				},
				configure: function(e) {
					var a = t.History;
					return a.options = t.extend(a.options, e), !0
				},
				domReadied: !1,
				domReady: function() {
					var e = t.History;
					if(!e.domRedied) return e.domRedied = !0, e.$window = t(window), e.$window.bind("hashchange", this.hashchange), e.nativeSupport = e.nativeSupport(), setTimeout(e.hashchangeLoader, 200), !0
				},
				nativeSupport: function(e) {
					e = e || t.browser;
					var a = e.version,
						n = parseInt(a, 10),
						i = a.split(/[^0-9]/g),
						o = parseInt(i[0], 10),
						r = parseInt(i[1], 10),
						s = parseInt(i[2], 10),
						l = !1;
					return e.msie && n >= 8 ? l = !0 : e.webkit && n >= 528 ? l = !0 : e.mozilla ? o > 1 ? l = !0 : 1 === o && (r > 9 ? l = !0 : 9 === r && s >= 2 && (l = !0)) : e.opera && (o > 10 ? l = !0 : 10 === o && r >= 60 && (l = !0)), l
				},
				hashchangeLoader: function() {
					var e = t.History;
					if(e.nativeSupport) {
						var a = e.getHash();
						a && e.$window.trigger("hashchange")
					} else {
						var n;
						if(t.browser.msie) {
							e.$iframe = t('<iframe id="jquery-history-iframe" style="display: none;"></iframe>').prependTo(document.body)[0], e.$iframe.contentWindow.document.open(), e.$iframe.contentWindow.document.close();
							var i = !1;
							n = function() {
								var t = e.getHash(),
									a = e.getState(),
									n = e.extractHash(e.$iframe.contentWindow.document.location.hash);
								a !== t ? (i || (e.$iframe.contentWindow.document.open(), e.$iframe.contentWindow.document.close(), e.$iframe.contentWindow.document.location.hash = t), i = !1, e.notSupportTrigger = !0, e.$window.trigger("hashchange")) : a !== n && (i = !0, e.setHash(n))
							}
						} else n = function() {
							var t = e.getHash(),
								a = e.getState();
							a !== t && (e.notSupportTrigger = !0, e.$window.trigger("hashchange"))
						};
						e.timer = setInterval(n, 2e3)
					}
					return !0
				}
			}, t.History.construct())
		}(t)
	}).call(e, a(1))
}, function(t, e, a) {
	(function(t) {
		var e = a(33);
		e.registerHelper("ifCond", function(t, e, a, n) {
			switch(e) {
				case "==":
					return t == a ? n.fn(this) : n.inverse(this);
				case "===":
					return t === a ? n.fn(this) : n.inverse(this);
				case "<":
					return a > t ? n.fn(this) : n.inverse(this);
				case "<=":
					return a >= t ? n.fn(this) : n.inverse(this);
				case ">":
					return t > a ? n.fn(this) : n.inverse(this);
				case ">=":
					return t >= a ? n.fn(this) : n.inverse(this);
				case "!=":
					return t != a ? n.fn(this) : n.inverse(this);
				case "&&":
					return t && a ? n.fn(this) : n.inverse(this);
				case "||":
					return t || a ? n.fn(this) : n.inverse(this);
				default:
					return n.inverse(this)
			}
		}), e.registerHelper("if", function(t, e) {
			return t ? e.fn(this) : e.inverse(this)
		}), e.registerHelper("duitang", function(t) {
			return "http://www.duitang.com/" + t
		}), e.registerHelper("timePattern", function(t) {
			var e = (new Date).getTime(),
				a = 1e3 * t - e;
			if(a > 0) {
				var n = Math.floor(a / 1e3 / 3600 / 24),
					i = Math.floor(a / 1e3 / 3600 - 24 * n),
					o = Math.floor((a - 1e3 * (60 * i * 60 - 24 * n * 3600)) / 1e6 / 60);
				return n + "天" + i + "时" + o + "分"
			}
		}), e.registerHelper("promotionDone", function(t, e) {
			var a = (new Date).getTime(),
				n = 1e3 * t - a;
			return 0 > n || e ? "done" : ""
		}), e.registerHelper("promotionUrl", function(t, e, a) {
			var n = (new Date).getTime(),
				i = 1e3 * e - n;
			return 0 > i || a ? "javascript:;" : "/shopping/temaihui/detail/" + t + "/?__urlopentype=pageweb"
		}), e.registerHelper("taobaoUrl", function(t, e, a) {
			var n = (new Date).getTime(),
				i = 1e3 * e - n;
			return 0 > i || a ? "javascript:;" : t
		}), e.registerHelper("truncate", function(e, a) {
			var n = t.trim(e).substring(0, a);
			return n
		}), e.registerHelper("pcjump", function(t, e) {
			var a = (new Date).getTime(),
				n = 1e3 * t - a,
				i = navigator.userAgent.toString().toLowerCase(),
				o = (!!i.match(/ipad/gi), !!i.match(/iphone/gi)),
				r = !!i.match(/android/gi);
			return 0 > n || e ? "target=_self" : o || r ? "" : "target=_blank"
		}), e.registerHelper("dtImageTrans", function(e, a, n, i, o) {
			var r = t.trim(e).replace(/^http(s)?:\/\//gi, ""),
				r = r.split("/"),
				s = r[0],
				r = r[1];
			return -1 == s.indexOf("duitang.com") || !r || "uploads" != r && "misc" != r ? e : a ? (n = n || 0, i = i || 0, o = o ? "_" + o : "", t.G.dtImageTrans(e).replace(/(\.[a-z_]+)$/gi, ".thumb." + n + "_" + i + o + "$1")) : e.replace(/(?:\.thumb\.\w+|\.[a-z]+!\w+)(\.[a-z_]+)$/gi, "$1")
		}), e.registerHelper("plus", function(t, e) {
			return t + e
		}), e.registerHelper("sale", function(t, e) {
			return(t / e * 10).toFixed(1)
		}), e.registerHelper("exist", function(t, e) {
			return t ? e.fn(this) : e.inverse(this)
		}), e.registerHelper("more", function(e, a) {
			return e.length >= a ? t.trim(e).substring(0, a).trim(this) + "..." : e
		}), e.registerHelper("round", function(t, e) {
			return -1 != t.toString().indexOf(".") ? t.toFixed(e) : t
		}), e.registerHelper("goto", function(t, e) {
			return "/redirect/?to=" + encodeURIComponent(t) + "&mk=b11_p_" + e + "&spm=2014.12553688.1.0"
		}), e.registerHelper("content", function(e, a) {
			var n = t.G.trimLink(e, t.G.isSTAFF()),
				i = n;
			return i
		}), e.registerHelper("htmlescape", function(t) {
			t = e.Utils.escapeExpression(t);
			var a = /(\n)/gi;
			return a.test(t) && (t = t.replace(a, "<br>").replace(/\r/, "").replace(/\s/gi, "&nbsp;")), new e.SafeString(t)
		})
	}).call(e, a(1))
}, function(t, e, a) {
	(function(t) {
		! function() {
			t.fn.tabswitch = function(e, a, n) {
				function i(t) {
					t.preventDefault(), c(g.index(this), !0)
				}

				function o(t, e) {
					for(var a = f.sub[0], n = f.sub[1], i = 0; i < a.length && i < n.length; i++) {
						var o = g.eq(t),
							r = g.eq(e),
							s = a[i].replace(/\./, ""),
							l = n[i].replace(/\./, "");
						if(o.hasClass(s) && r.hasClass(l)) return 1;
						if(o.hasClass(l) && r.hasClass(s)) return -1
					}
					return 0
				}

				function r(e) {
					for(var a = g.eq(e), n = f.sub[0], i = f.sub[1], o = 0; o < n.length; o++) {
						var r = n[o].replace(/\./, "");
						if(a.hasClass(r)) return g.index(t(i[o])[0])
					}
					return -1
				}

				function s(t) {
					for(var e = g.eq(t), a = f.sub[0], n = f.sub[1], i = 0; i < a.length && i < n.length; i++) {
						var o = a[i].replace(/\./, ""),
							r = n[i].replace(/\./, "");
						if(e.hasClass(o) || e.hasClass(r)) return g.filter(a[i])
					}
					return null
				}

				function l(e, a) {
					for(var n = g.eq(e), i = f.sub[0], o = f.sub[1], r = 0; r < o.length; r++) {
						var s = o[r].replace(/\./, "");
						if(n.hasClass(s)) {
							var l = t(i[r]).filter(".cur")[0];
							return a && l ? g.index(l) : g.index(t(i[r])[0])
						}
					}
					return -1
				}

				function c(t, e) {
					var a, n = g,
						i = g.index(a),
						c = f.sub && f.sub[0] ? f.sub[0].length : null,
						u = -1,
						p = -1,
						h = t;
					c && (n = n.not(f.sub[0].join(",")), p = l(t, !0), u = r(t)), a = n.filter("." + v), i = g.index(a), n.add(m).removeClass(v), c && 1 === o(t, i) ? (s(t).removeClass(v), a.addClass(v)) : c && -1 !== u ? (s(t).removeClass(v), g.eq(u).addClass(v)) : c && -1 !== p && (g.eq(p).addClass(v), h = p), m.css("display", "none").eq(h).css("display", "block").add(g.eq(t)).addClass(v), f.auto && d(), "function" == typeof f.fn && f.fn(g, m, h, i, e)
				}

				function d() {
					window.clearTimeout(p), p = window.setTimeout(function() {
						var t = g.index(g.filter("." + v));
						c((t + 1) % m.length, !0)
					}, f.autodelay)
				}
				var u = this;
				"function" != typeof e && (n = a, a = e, e = t.noop), "string" != typeof a && (n = a, a = "");
				var f = t.extend({}, t.fn.tabswitch.defaults, n);
				f.fn = e;
				var p, h = !!a,
					m = t(f.cont),
					g = h ? t(a, u) : u,
					v = f.focus;
				return c(f.index), h ? this.delegate(a, f.event, i) : this.bind(f.event, i), t.fn.tabswitch.stop = function() {
					window.clearTimeout(p)
				}, t.fn.tabswitch.resume = function() {
					f.auto && d()
				}, u
			}, t.fn.tabswitch.defaults = {
				cont: ".tabswitch-cont",
				sub: [
					[".tabswitch-sub0"],
					[".tabswitch-main0"]
				],
				focus: "cur",
				index: 0,
				event: "click",
				auto: !1,
				autodelay: 3e3
			}
		}()
	}).call(e, a(1))
}, function(t, e, a) {
	(function(t) {
		a(1);
		! function(t) {
			t.fn.confirm = function(e, a, n) {
				"function" != typeof e && (n = a, a = e, e = t.noop), "string" != typeof a && (n = a, a = ""), n = t.extend({}, n);
				var i = n.dir ? 1 : -1,
					o = n.tipword || "",
					r = function(e, a) {
						l.css({
							display: "block",
							overflow: "hidden"
						}), t(".PL-cfm-cont", l).stop().clearQueue().css({
							marginTop: i * e
						}).animate({
							marginTop: i * a
						}, 300, "linear", function() {
							l.css("overflow", "visible").css("display", a > e ? "none" : "block")
						})
					},
					s = function(a) {
						a.preventDefault();
						var n, s, c = t(this),
							d = c.offset(),
							u = c.outerWidth(),
							f = c.outerHeight(),
							p = t(document).width(),
							h = t(document).height(),
							m = t(window).scrollTop(),
							g = t(window).scrollLeft(),
							v = t(window).width(),
							b = t(window).height(),
							w = l.outerWidth(),
							y = l.outerHeight(),
							k = 12,
							_ = -1 === i ? d.top + f + k : d.top - y - k,
							x = d.left - w / 2 + u / 2;
						n = h - y - k, _ = k > _ ? k : _ > n ? n : _, n = p - w - k, x = k > x ? k : x > n ? n : x, n = _ - k, s = x - k, t("html").animate({
							scrollTop: m > n ? n : (n = _ + k + y - b) > m ? n : "+=0",
							scrollLeft: g > s ? s : (s = x + k + w - v) > g ? s : "+=0"
						}, 300), l.css({
							top: _,
							left: x
						}).data({
							"this": this,
							event: a,
							fn: e
						}), t(".PL-cfm-wds", l).html(o), r(y, 0)
					},
					l = t("#PL-confirm");
				if(!l.length) {
					l = t('<div id="PL-confirm" class="PL-confirm"><div class="PL-cfm-cont"><div class="PL-cfm-wds tc">' + o + '</div><div class="PL-cfm-btns tc"><a class="abtn abtn-s PL-cfm-yes dib" href="javascript:;""><u>确定</u></a><a class="abtn abtn-s PL-cfm-no dib" target="_self" href="javascript:;"><u>取消</u></a></div></div></div>').appendTo("body");
					var c = function() {
						var t = l.outerHeight();
						r(0, t)
					};
					t(".PL-cfm-yes", l).click(function(t) {
						t.preventDefault(), l.data("fn").call(l.data("this"), l.data("event"))
					}).click(c), t(".PL-cfm-no", l).click(c)
				}
				return a ? this.delegate(a, "click", s) : this.click(s), this
			}
		}(t)
	}).call(e, a(1))
}, function(t, e, a) {
	(function(t) {
		var e = a(1);
		e.G = a(9), a(47);
		var n = a(29),
			i = a(5);
		! function(t) {
			function e(t) {
				i.PopOut.alert([null, m, ""], 2)
			}

			function a() {
				w.find("a.abtn").addClass("abtn-no"), w.find(".s-sina").css({
					opacity: .5,
					color: "#aaa"
				})
			}

			function o() {
				w.find("a.abtn").removeClass("abtn-no"), w.find(".s-sina").css({
					opacity: 1,
					color: "#333"
				})
			}

			function r(t, e) {
				b.find("input[name=album_id]").val(t).end().find("a,span").html(e)
			}

			function s(t, e) {
				y.html(e).attr("class", t)
			}

			function l() {
				g.val(""), s("", "")
			}

			function c(e, a) {
				t.G.blinkIt(function() {
					s("re-postsuc", _[0] + "成功！")
				}, null, function() {
					i.PopOut.closeMask(), t.isFunction(a) && a(e), l()
				}, 1, 800);
				var n = t(".collection").find("em");
				1 === n.length && e.blog && n.each(function() {
					n.html(parseInt(n.html()) + 1)
				})
			}

			function d(e, a) {
				if(e) {
					var n = t(h);
					if(n.addClass("re-done").attr("href", "/blog/?id=" + e).attr("target", "_blank").attr("title", "去看我的收集"), a) {
						var i = n.closest(".woo").find(".d1"),
							o = t(".otheralbums h4").find("span").text(),
							r = parseInt(i.text()) || parseInt(o) || 0;
						i.html(r + 1).removeClass("dn"), n.find("em").length && n.find("i").addClass("y-done").end().find("em").html("已收集 " + (r + 1))
					}
				}
			}

			function u(a, n, i, r, s) {
				k = !1, _ = ["收集", "收集到", "收集"], p("/napi/blog/forward/", s, i), m.css("display", "block"), l(), o();
				var c, d = a.closest(".center"),
					u = "";
				d.length ? (c = d.find(".js-favorite-blogtit"), u = c.html().replace(/\<br\>/gi, "\n").replace(/&nbsp;/gi, " ")) : (c = a.closest(".woo").find("div.g"), u = t("<div>" + c.html() + "</div>").find("a").remove().end().text()), g.val(t.trim(u)), t("#re-inp-parent").attr("name", "parent").val(n), v.empty().scrollTop(0);
				var f, h, b = d.find(".js-favorite-blogimg");
				b.length ? (f = b.data("width"), h = b.data("height")) : (b = a.closest("div.woo").find("div.mbpho img"), f = b.outerWidth(), h = parseInt(b.attr("height"))), f > 200 && (h = 200 * h / f, f = 200), $i = t("<img />").attr("src", b.attr("src")).appendTo(v), $i.css({
					width: f,
					height: h,
					marginTop: 200 >= h ? (200 - h) / 2 : 0,
					cursor: 200 >= h ? "default" : "move"
				}), t.data(v[0], "imgProp", {
					height: h
				}), e(a)
			}

			function f(a, n, i, r, s, c, d, u) {
				k = u, _ = ["编辑", "转移到", "提交"], p("/napi/blog/edit/", s, i, c, d, u), m.css("display", "block"), l(), o();
				var f, h = a.closest(".center"),
					b = "";
				h.length ? (f = h.find(".js-favorite-blogtit"), b = f.html().replace(/\<br\>/gi, "\n").replace(/&nbsp;/gi, " ")) : (f = a.closest(".woo").find("div.g"), b = t("<div>" + f.html() + "</div>").find("a").remove().end().text()), g.val(t.trim(b)), t("#re-inp-parent").attr("name", "blog_id").val(n), v.empty().scrollTop(0);
				var w = h.find("img.js-favorite-blogimg");
				if(w.length) var y = w.data("height"),
					x = w.data("width"),
					y = 200 * y / x,
					C = t("<img />").attr("src", w.attr("src")).appendTo(v);
				else {
					w = a.closest("div.woo").find("div.mbpho img");
					var y = parseInt(w.attr("height")),
						C = t("<img />").attr("src", w.attr("src")).appendTo(v)
				}
				C.css({
					width: 200,
					marginTop: 200 > y ? (200 - y) / 2 : 0,
					cursor: 200 >= y ? "default" : "move"
				}), t.data(v[0], "imgProp", {
					height: y
				}), e(a)
			}

			function p(e, i, l, u, f, p) {
				function h(t) {
					n.keyupLenLimitForU(t.currentTarget, 300, !0, !0)
				}
				if(m && m.length) t.G.store(m);
				else {
					m = t('<div id="re-favorite"><form action="' + e + '" target="_self"><div id="re-head"><a id="re-close" target="_self" href="javascript:;" onclick="SUGAR.PopOut.closeMask();">关闭</a><h1>' + _[0] + '</h1></div><div id="re-cont" class="clr"><div id="re-left" class="l"></div> <div id="re-right" class="r"> <p>' + _[1] + '</p> <div id="re-albumsel"><input class="dn" type="text" data-optional="1" name="album_id"><a id="re-albumtrig" href="javascript:;">默认专辑</a><span id="re-onlyeditwds"></span></div><textarea name="msg"' + ("编辑" == _[0] && (parseInt(l) || t.G.isSTAFF()) ? ' class="txa" ' : ' class="txa txa-no"  readonly="true"') + ' data-optional="1" ></textarea> <div id="re-subpan" class="u-chk clr"> <a href="javascript:;" class="abtn l "><button type="submit"><u>' + _[2] + "</u></button></a>" + (void 0 != typeof BIND_SITES && BIND_SITES.sina ? '<input id="re-sycn-sina" type="checkbox" value="1" class="chk s-sina" name="syncpost" /><label class="s-sina" title="同步到新浪微博" for="re-sycn-sina">同步</label><div class="re-mbsite s-sina">新浪</div>' : "") + '<div id="re-poststat"></div></div></div></div><input id="re-inp-parent" type="hidden" name="parent" value="" data-optional="1" /></form></div>'), t.G.store(m);
					var x = t.G.getYearCookie("sync");
					t("#re-sycn-sina").prop("checked", -1 === x.indexOf("sina") ? !1 : !0).change(function() {
						var e = t(this),
							a = e.attr("value");
						x = x.replace(new RegExp("," + a, "ig"), ""), e.prop("checked") || -1 !== x.indexOf(a) ? e.prop("checked") && t.G.setYearCookie("sync", x + "," + a) : t.G.setYearCookie("sync", x)
					}), y = t("#re-poststat"), b = m.find("#re-albumsel"), b.removeClass("re-onlyedit").find("a").myalbums({
						sel_valueipt: b.find("input[name=album_id]"),
						sel_holder: m
					}), v = t("#re-left").mousemove(function(e) {
						if(e.stopPropagation(), !t.data(this, "movelock")) {
							var a = t(this),
								n = t.data(this, "imgProp") || {},
								i = n.height;
							if(i > 200) {
								var o = e.pageY,
									r = v.offset().top,
									s = o - r - 50,
									s = 0 > s ? 0 : s;
								t.data(this, "movelock", !0), a.stop().animate({
									scrollTop: s * (i - 200) * 2 / 200
								}, 50, "linear", function() {
									t.data(a[0], "movelock", !1)
								})
							}
						}
					}), g = m.find("textarea.txa"), g.keyup(h).blur(h).focus(h), n.keyupLenLimitForU(g[0], 300, !0, !0), t.fn.at && g.at({
						isFixed: !0
					}), w = m.find("form").safeSubmit(function(e) {
						var n = t(this),
							r = g.val(),
							l = b.find("input").val(),
							u = t("#re-albumtrig").text(),
							f = n.find("a.abtn");
						f.find("[type=submit]");
						if(!f.hasClass("abtn-no")) {
							a(), s("re-inpost", "正在提交，请稍候");
							var p = n.getFormAction(),
								h = n.serializeObject();
							"/napi/blog/forward/" === p && (h.album = h.album_id, delete h.album_id), t.ajax({
								url: p,
								data: h,
								success: function(e) {
									var a = t.isPlainObject(e) ? e : t.parseJSON(e);
									if(!a || "object" != typeof a) return void s("re-posterr", "出现异常，可能是网络原因");
									if(a.data || (a.data = {}), a.data.content = r, a.data.albumid = l, a.data.albumname = u, a.success || 1 === a.status) {
										var n = b.find("[name=album_id]").val(),
											f = b.find("a").html();
										!k && n && "0" != n && (t.Bom.removeCookie("sgt"), t.Bom.setSubCookie("sgt", "ai" + t.G.getUSERID(), n, {
											expires: 30
										}), t.Bom.setSubCookie("sgt", "an" + t.G.getUSERID(), f, {
											expires: 30
										})), c(a.data, i), d(a.data && a.data.blog && a.data.blog.id, 1)
									} else if(a.data && a.data.robot_check);
									else {
										var p = t.trim(t.G.mergeServerMessage(a.message));
										s("re-posterr", p), o(), "你已经收集了该分享" == p ? d() : o(), t.G.gaq("/_trc/Error/ajax/response_" + p + "_forward")
									}
								},
								myerror: function() {
									s("re-posterr", "网络原因导致失败，请稍候再试"), o()
								}
							}).always(function() {})
						}
					}, function(e) {
						t.G.blinkIt(function() {
							g.css({
								backgroundColor: "#d7ebf7"
							})
						}, function() {
							g.css({
								backgroundColor: "#fff"
							})
						}, function() {
							g.focus()
						}, 4, 200)
					})
				}
				if(p ? (b.addClass("re-onlyedit"), t("#re-subpan").find("input,label,div.re-mbsite").css("visibility", "hidden")) : (b.removeClass("re-onlyedit"), t("#re-subpan").find("input,label,div.re-mbsite").css("visibility", "visible")), "undefined" != typeof u) u = u || "", f = f || "默认专辑", r(u, f);
				else {
					var C = t.Bom.getSubCookie("sgt", "ai" + t.G.getUSERID()) || "",
						P = t.Bom.getSubCookie("sgt", "an" + t.G.getUSERID()) || "默认专辑";
					r(C, P)
				}
				w.attr("action", e), m.find("h1").html(_[0]).end().find("#re-right p").eq(0).html(_[1]).end().find(".abtn u").html(_[2])
			}
			var h, m, g, v, b, w, y, k = !1,
				_ = ["收集", "收集到", "收集"];
			t.fn.SGfavorite = function(e) {
				function a(e) {
					if(t(this).hasClass("re-done")) return !0;
					e.stopPropagation(), e.preventDefault();
					var a = t(this),
						n = a.data("favorite"),
						n = n ? n : a.closest(".collbtn").data("favorite"),
						i = n ? n.id : 0,
						r = t.G.getUSERID(),
						s = n.owner,
						l = n.rooter;
					if(h = this, 1 != n.edit || s != r && !t.G.isSTAFF()) {
						if(s == r) return void alert("你收集过的，不能再收集哦~");
						if(l == r) return void alert("你第一次发布的，不能再收集哦~");
						var c = a.parent();
						c.hasClass("collbtn") && t.G.gaq("/_trc/Repost/waterfall/popstart"), u(a, i, l, s, o)
					} else f(a, i, l, s, o, n.belongalbumid, n.belongalbumname, n.onlyedit)
				}
				e = e || {};
				var n = e.etype || "click",
					o = e.callback;
				return t.G.getUSERID() <= 0 ? (this.attr("title") || this.attr("title", "登录才能进行操作哦，点击就可以登录啦"), t(document).on(n, this.selector, function(t) {
					t.stopPropagation(), t.preventDefault(), i.PopOut.login()
				})) : t(document).on(n, this.selector, a), this
			}, t.fn.SGcomment = function(e) {
				function a(e, a, n, i, o, r, s) {
					var l = o.find(".re-comt");
					o.find(".re-comt").stop().clearQueue().animate({
						height: 0
					}, 200).queue(function() {
						t.Woo.resetCol(-118, r, s), t.data(i[0], "comment", -1), l.find("textarea").blur()
					}), t.data(i[0], "comment", 0)
				}

				function n(e, a, n, i, o, r, s, l) {
					if("undefined" == typeof t.data(i[0], "comment")) {
						var c = t('<li class="re-comt"><img width="24" height="24" src=' + USER.smallAvatar + '><form action="/napi/comment/create/"><div class="pb8"><textarea class="txa" name="content" placeholder="发布评论..."></textarea><a class="abtn l" href="#"><u>评论</u></a></div><input type="hidden" name="_type" value=""/><input type="hidden" value="' + a + '" name="comment_message_id"></form></li>');
						o.after(c), t.fn.at && c.find("textarea").at({
							pageMembers: r.find("li p a:first-child")
						}), c.find("a.abtn").click(function(e) {
							e.stopPropagation(), e.preventDefault();
							var a = t(this),
								n = a.closest("form"),
								i = n.find("textarea"),
								o = t.trim(i.val());
							return o ? void(a.hasClass("abtn-no") || (a.addClass("abtn-no"), t.ajax({
								url: "/napi/comment/create/",
								data: n.paramForm(),
								mysuccess: function(e, n) {
									var o = t(".dt-avatar").attr("src"),
										r = t(['<li><a href="dynamic.jsp" target="_blank"><img src="', o, '" width="24" height="24"></a><p><a href="dynamic.jsp" target="_blank">我</a><br/><span>', e.data.content.replace(/<br\s*\/?>/i, " ").replace(/@[\u2E80-\u9FFF\d\w]{1,20}/gi, ""), "</span></p></li>"].join(""));
									c.before(r.css("display", "none")), i.val(""), r.slideDown(200, function() {
										t.Woo.resetCol(r.outerHeight(!0), s, l)
									});
									var d = a.closest(".woo").find(".d3"),
										u = parseInt(d.text()) || 0;
									d.html(++u).removeClass("dn")
								},
								myerror: function() {
									this.errormsg()
								}
							}).always(function() {
								a.removeClass("abtn-no")
							}))) : void alert("请输入内容！")
						})
					}
					var d = t(window),
						u = d.height(),
						f = d.scrollTop(),
						p = r.find(".re-comt"),
						h = p.offset(),
						m = h.top,
						g = m + 118 - (u + f);
					if(g > 0) {
						var v = t.browser,
							b = v.webkit,
							w = t(b ? "body" : "html");
						w.animate({
							scrollTop: "+=" + g
						}, 400, function() {})
					}
					p.stop().clearQueue().animate({
						height: 118
					}, 200).queue(function() {
						t.Woo.resetCol(118, s, l), t.data(i[0], "comment", 1), p.find("textarea").focus()
					}), t.data(i[0], "comment", 0)
				}

				function o(e) {
					e.stopPropagation(), e.preventDefault();
					var i, o = t(e.target).closest("a"),
						r = o.closest(".woo"),
						s = r.find(".f").last(),
						l = r.find("li").not(".re-comt").last(),
						c = o.closest(".collbtn").data("favorite"),
						c = c ? c : s.data("favorite");
					if(!s.length && c && c.id) return void(window.location.href = "/blog/?id=" + c.id + "#reply");
					if(i = t.data(s[0], "comment"), 0 !== i) {
						var d = c.id,
							u = c.owner,
							f = t.data(t("#woo-holder")[0], "zindex") || 10,
							i = void 0 == i || 0 > i ? !1 : !0,
							p = r[0].className,
							h = t.G.getNum(p.match(/\bco\d+\b/gi).toString()),
							m = parseInt(r.css("top")) || 0;
						r.css("zIndex", ++f), t.data(t("#woo-holder")[0], "zindex", f), i ? a(o, d, u, s, r, h, m) : n(o, d, u, s, l, r, h, m)
					}
				}
				e = e || {};
				var r = "click";
				return t.G.getUSERID() ? t(document).on(r, this.selector, o) : (this.attr("title", "登录才能评论，点击下就可以登录啦"), t(document).on(r, this.selector, function(t) {
					t.stopPropagation(), t.preventDefault(), i.PopOut.login()
				})), this
			}, t.fn.SGlike = function(e) {
				function a(e, a, n) {
					e.hasClass("no-sub") || (e.addClass("no-sub"), n = n || 1, t.ajax({
						url: "/napi/like/",
						data: "object_id=" + a + "&category=" + n,
						mysuccess: function(a, n) {
							e.addClass("re-zan");
							var i = e.closest(".woo").find(".d2"),
								o = e.closest(".action").find("em"),
								r = i.html(),
								s = 0;
							e.data("like") ? e.data("like").likeid = a.data.liked_id : e.data("like", {
								likeid: a.data.liked_id + ""
							}), s = r ? parseInt(r) + 1 : 1, i.length && i.html(s).removeClass("dn") && (e.find("i").length ? e.find("i").html(s).addClass("z-done") : e.html(s).addClass("z-done")), o.length && o.each(function() {
								t(this).html(parseInt(o.html()) + 1)
							})
						},
						myerror: function() {
							this.errormsg()
						}
					}).always(function() {
						e.removeClass("no-sub")
					}))
				}

				function n(e, a) {
					e.hasClass("no-sub") || (e.data("like") && (a = e.data("like").likeid), a && (e.addClass("no-sub"), t.ajax({
						url: "/napi/unlike/",
						data: "like_id=" + a,
						mysuccess: function(a, n) {
							e.removeClass("re-zan");
							var i = e.closest(".woo").find(".d2"),
								o = e.closest(".action").find("em"),
								r = i.html(),
								s = 0;
							s = parseInt(r) > 1 ? parseInt(r) - 1 : 0, i.length && (s ? i.html(s) : i.html(s).addClass("dn")) && (e.find("i").length ? e.find("i").html(s).removeClass("z-done") : e.html(s).removeClass("z-done")), o.length && o.each(function() {
								t(this).html(parseInt(o.html()) - 1 < 0 ? 0 : parseInt(o.html()) - 1)
							})
						},
						myerror: function() {
							this.errormsg()
						}
					}).always(function() {
						e.removeClass("no-sub")
					})))
				}

				function o(e) {
					e.stopPropagation(), e.preventDefault();
					var i = t(this),
						o = i.data("favorite"),
						o = o ? o : i.closest(".collbtn").data("favorite"),
						r = o.id,
						s = (o.owner, o.likeid),
						l = o.type;
					i.hasClass("re-zan") ? n(i, s) : a(i, r, l)
				}
				e = e || {};
				var r = "click";
				t.G.getUSERID() ? t(document).on(r, this.selector, o) : (this.attr("title") || this.attr("title", "登录之后才能赞哦！"), t(document).on(r, this.selector, function(t) {
					t.stopPropagation(), t.preventDefault(), i.PopOut.login()
				}))
			}
		}(t), e(function() {
			var t = e("#woo-holder");
			if(t.length) {
				var a = e(window),
					n = e.browser.msie,
					i = n && "6.0" === e.browser.version;
				a.scroll(function() {
					var n = a.scrollTop(),
						o = e("#collbtn");
					if(o.length && !i) {
						var r = t.data("offset"),
							s = 0;
						if(r) {
							var l = o.closest("div.woo"),
								c = parseInt(l.css("top")) || 0,
								d = r.top,
								u = -20,
								f = 65;
							if(n - (d + c) + u + s + f > 0) {
								var p = l.offset().left;
								l.find(".collbtn").css({
									left: p,
									position: "fixed",
									top: s + f,
									display: "block"
								})
							} else l.find(".collbtn").css({
								position: "absolute",
								left: 0,
								top: s,
								display: "block"
							})
						}
					}
				})
			}
		})
	}).call(e, a(1))
}, function(t, e, a) {
	(function(t) {
		a(1);
		! function(t) {
			t.fn.myalbums = function(e, a, n) {
				function i(e) {
					t.G.getUSERID() && (t(u.sel_holder) != t("body") ? l.appendTo(u.sel_holder) : l.css({
						position: "absolute",
						zIndex: 30001,
						left: e.left + u.biasleft,
						top: e.top + u.biasleft
					}), l.css("display", "block" == l.css("display") ? "none" : "block"), !s.data("loaded") && t("a", d).length <= 1 ? (d.addClass("loading"), t.ajax({
						cache: !1,
						type: "GET",
						url: "/napi/album/list/by_user/?limit=50",
						mysuccess: function(e, a) {
							d.removeClass("loading");
							var n = e.data.object_list,
								i = c.val();
							if(n && n.length) {
								for(var o = 0, r = n.length; r > o; o++) t("<a " + (i == n[o].id ? 'class="cur"' : "") + ' href="#" data-albumid="' + n[o].id + '">' + n[o].name.cut(40, "…") + "</a>").appendTo(d);
								0 == i && d.find("a").eq(0).addClass("cur")
							}
							s.data("loaded", 1)
						},
						myfailure: function(t, e) {
							d.removeClass("loading")
						}
					})) : l.find(".cur").removeClass("cur").end().find("a[data-albumid=" + c.val() + "]").addClass("cur"))
				}

				function o(t, e) {
					c.val(t), s.html(e), d.find(".cur").removeClass("cur").end().find("a[data-albumid=" + t + "]").addClass("cur").prependTo(d), d.scrollTop(0), l.css("display", "none")
				}

				function r() {
					c = t(u.sel_valueipt), c.length || (c = t('<input class="dn" type="text" value="">').appendTo(s)), l = t("#myalbums-wrap"), l.length || (l = t('<div id="myalbums-wrap" style="display:none"><div id="myalbums-albs"></div><div class="clr"><form action="/napi/album/create/" method="post"><input type="text" value="" name="name" class="ipt l" maxlength="40"><a target="_self" href="javascript:;" class="abtn l"><button type="submit"><u>创建</u></button></a></form></div></div>').click(function(t) {
						t.stopPropagation()
					}).appendTo("body"), l.find("input").lengthLimit()), t(document).click(function(t) {
						l.css("display", "none")
					}), d = t("#myalbums-albs"), d.delegate("a", "click", function(e) {
						e.preventDefault();
						var a = this.innerHTML,
							n = t(this).data("albumid") || "";
						o(n, a)
					});
					var e = t.browser.mozilla ? "DOMMouseScroll" : "mousewheel";
					navigator.userAgent.toString().match(/ipad/gi) && (t('<a id="ipadalbumselectordown" class="ipadalbumsel" href="javascript:;"></a>').appendTo(l).click(function(t) {
						d.get(0).scrollTop += 26
					}).bind("dblclick", function(t) {
						t.preventDefault(), t.stopPropagation()
					}), t('<a id="ipadalbumselectorup" class="ipadalbumsel" href="javascript:;"></a>').appendTo(l).click(function(t) {
						d.get(0).scrollTop -= 26
					}).bind("dblclick", function(t) {
						t.preventDefault(), t.stopPropagation()
					})), d.bind(e, function(t) {
						t.originalEvent.wheelDelta ? this.scrollTop += -1 * t.originalEvent.wheelDelta : this.scrollTop += t.originalEvent.detail > 0 ? 60 : -60, t.preventDefault()
					}), l.find("input").click(function() {
						t(this).focus()
					}), l.find("form").safeSubmit(function(e) {
						var a = this,
							n = t(a),
							i = n.find(".abtn"),
							r = i.find("[type=submit]");
						i.hasClass("abtn-no") || (i.addClass("abtn-no"), t.ajax({
							url: n.getFormAction(),
							data: n.paramForm(),
							mysuccess: function(e, a) {
								var i = n.find("input"),
									r = t.trim(i.val());
								i.val(""), d.prepend(t('<a href="#" data-albumid="' + e.data.album.id + '">' + r.cut(40, "…") + "</a>")).scrollTop(0), o(e.data.album.id, r)
							},
							myfailure: function(t, e) {
								t.data && t.data.robot_check ? r.verif({
									w: 1
								}) : this.wrongmsg(t)
							}
						}).always(function() {
							i.removeClass("abtn-no")
						}))
					}), p.bind(u.event, function(e) {
						e.stopPropagation(), e.preventDefault();
						var a = t(this).offset();
						i(a)
					})
				}
				var s = this;
				if(!(s.length <= 0)) {
					"function" != typeof e && (n = a, a = e, e = t.noop), "string" != typeof a && (n = a, a = "");
					var l, c, d, u = t.extend({}, t.fn.myalbums.defaults, n),
						f = !!a,
						p = f ? t(a, s) : s;
					return u.fn = e, r(), l
				}
			}, t.fn.myalbums.defaults = {
				sel_holder: "body",
				sel_valueipt: "",
				event: "click",
				biastop: 0,
				biasleft: 0
			}
		}(t)
	}).call(e, a(1))
}, function(t, e, a) {
	(function(e) {
		function n(t) {
			if(t.length) {
				var e = t.find("div.woo-pcont:visible").offset(),
					a = e.top,
					n = e.left,
					i = parseInt(t.css("marginLeft")) || 0;
				t.data("offset", {
					left: n - i,
					top: a
				})
			}
		}
		a(1), a(46);
		var i = function() {
			function t(t, e) {
				e ? t.addClass("woocov") : t.removeClass("woocov")
			}
			e("div.woo .collbtn .y").SGfavorite(), e("div.woo .collbtn .x").SGcomment(), e("div.woo .collbtn .z").SGlike();
			var a = e("#woo-holder"),
				i = e(window);
			if(a.length) {
				var o = e.browser.msie,
					r = o && "6.0" === e.browser.version,
					s = -20,
					l = 0,
					c = 65;
				r ? a.on("mousemove", "div.woo", function(o) {
					n(a);
					var r = e(this),
						s = parseInt(r.css("top")) || 0,
						d = i.scrollTop(),
						u = a.data("offset"),
						f = u.top;
					t(r.find(".a u"), !0), r.find(".collbtn").css({
						display: "block",
						top: Math.max(d - (f + s) - l + c, l)
					})
				}) : (a.on("mouseenter", "div.woo", function(o) {
					n(a);
					var r = e(this),
						d = r.find(".collbtn"),
						u = parseInt(r.css("top")) || 0,
						f = i.scrollTop(),
						p = a.data("offset"),
						h = p.top;
					if(t(r.find(".a u"), !0), e("#collbtn").css("display", "none").removeAttr("id").addClass("collbtn"), d.attr("id", "collbtn").addClass("collbtn"), f - (h + u) + s + l + c > 0) {
						var m = r.offset().left;
						d.css({
							left: m,
							position: "fixed",
							top: l + c,
							display: "block"
						})
					} else d.css({
						position: "absolute",
						left: 0,
						top: l,
						display: "block"
					})
				}), a.on("mousemove", "div.woo", function(t) {
					var a = e(this),
						n = a.find(".collbtn");
					e("#collbtn")[0] != n[0] && e("#collbtn").css("display", "none").removeAttr("id").addClass("collbtn"), n.attr("id", "collbtn").addClass("collbtn")
				})), a.on("mouseleave", "div.woo", function(a) {
					var n = e(this);
					t(n.find(".a u"), !1), n.find(".collbtn").css("display", "none").removeAttr("id").addClass("collbtn")
				})
			}
		};
		t.exports = i
	}).call(e, a(1))
}, , , , , , , function(t, e, a) {
	(function(t) {
		! function() {
			t.G && !t.G.reTop && (t.G.reTop = function() {
				var e, a = t(window),
					n = a.width(),
					i = a.height(),
					o = t.browser,
					r = (o.msie && "6.0" === o.version, o.webkit, !1),
					s = t("#dt-side-combo"),
					l = t("#dt-backtotop");
				if(!l.length) {
					s = t('<div id="dt-side-combo" ><a id="dt-backtotop" class="dt-backtotop" href="javascript:;">回到顶部</a><a class="dt-report" href="/leave/message/">反馈意见</a></div>').sidepop({
						id: "dt-side-combo",
						dockSide: "right",
						width: 48,
						height: 142,
						scroll: 1,
						departure: 10,
						baseline: "bottom",
						bias: 30,
						isFixed: !0,
						zIndex: 1e4,
						btnset: 0
					}), s = s.parent().parent(), s.addClass("vh"), $comboin = t("#dt-side-combo"), l = t("#dt-backtotop"), l.click(function(e) {
						e.preventDefault();
						r = !0, t("body,html").animate({
							scrollTop: 0
						}, 200, function() {
							r = !1
						}), s.css("display", "none")
					});
					var c = function(n) {
						clearTimeout(e), r || (e = window.setTimeout(function() {
							var e = a.scrollTop();
							e > 100 ? s.stop().css({
								display: "block"
							}).animate({
								opacity: 1
							}, 300) : s.stop().animate({
								opacity: 0
							}, 300, function() {
								s.css("display", "none")
							}), n && t({}).delay(300).queue(function() {
								s.removeClass("vh")
							})
						}, 100))
					};
					a.scroll(c), c(!0);
					var d = function() {
						var t = 17,
							e = n + t;
						if(1120 >= e || e > 1262 && 1336 >= e) s.css({
							left: "auto",
							right: 10,
							marginLeft: 0
						});
						else {
							var a = 1262 >= e ? 490 : 612;
							s.css({
								left: "50%",
								marginLeft: a
							})
						}
					};
					d(), a.resize(function() {
						n = a.width(), i = a.height(), d()
					})
				}
			}, t(function() {
				t.G.reTop()
			}))
		}()
	}).call(e, a(1))
}, , , , , , , , , , , , function(t, e, a) {
	(function(t) {
		t(function() {
			t.fn.extend({
				carousel: function(e) {
					if(!(e && e.action && e.eventType)) return !1;
					e = t.extend({
						time: 0,
						lazyLoadImg: ".dt-carousel-img"
					}, e);
					var a, n, i = t(document),
						o = t(this),
						r = t(e.action),
						s = 0 | e.time,
						l = function(a) {
							var n, i, l, u, f;
							if(r.removeClass("cur"), r.eq(a).addClass("cur"), o.each(function(e, a) {
									l = t(a), l.hasClass("cur") && (u = l)
								}), !u) throw new Error("no cur!");
							if(f = o.eq(a), n = f.find(e.lazyLoadImg), n.length && (i = n.attr("data-src"), i && n.css({
									"background-image": "url(" + i + ")"
								})), o.index(u) !== a) {
								switch(e.animateType) {
									case "move":
										u.removeClass("cur"), f.addClass("cur");
										var p, h = t(e.carouselWrap);
										p = 0 !== a ? "-" + a + "00%" : "0%", h.stop(!0, !0), h.animate({
											left: p
										});
										break;
									default:
										if(e.fadeElement) {
											var m = u.find(e.fadeElement),
												g = f.find(e.fadeElement);
											m.stop(!0, !0), g.stop(!0, !0), u.removeClass("cur"), f.addClass("cur"), m.css({
												display: "block"
											}).fadeOut(1e3), g.css({
												display: "none"
											}).fadeIn(1e3)
										} else u.stop(!0, !0), f.stop(!0, !0), u.removeClass("cur").css({
											display: "block"
										}), f.addClass("cur").css({
											display: "none"
										}), u.fadeOut(1e3), f.fadeIn(1e3)
								}
								e.callback && e.callback(a, u, f, d, c)
							}
							0 !== s && d()
						},
						c = function() {
							clearTimeout(a)
						},
						d = function() {
							clearTimeout(a), a = setTimeout(function() {
								var a = t(e.action + ".cur"),
									i = r.index(a[0]);
								n = i === o.length - 1 ? 0 : i + 1, l(n), d()
							}, s)
						};
					e.left && e.right && i.delegate(e.left, "click", function(a) {
						var i = t(e.action + ".cur"),
							c = r.index(i[0]);
						n = 0 === c ? o.length - 1 : c - 1, l(n), 0 !== s && d()
					}).delegate(e.right, "click", function(a) {
						var i = t(e.action + ".cur"),
							c = r.index(i[0]);
						n = c === o.length - 1 ? 0 : c + 1, l(n), 0 !== s && d()
					}), i.delegate(e.action, e.eventType, function(e) {
						var a = (t(this), r.index(this));
						l(a)
					}), 0 !== s && d()
				}
			})
		})
	}).call(e, a(1))
}]);