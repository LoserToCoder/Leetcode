<%@page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>发表博文</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" href="/post/css/article.css" type="text/css" media="screen">
    <style type="text/css">
    #header_taller{padding-top: 15px;height: 140px;}
    #fnavi_taller{margin-bottom: 10px;}
    #fntext1_taller{padding-top: 10px;}
    .cus_in3,.cus_in2{font-size: 14px;}
    .cus_in2{margin-left: 8px;}
    </style>
    <link rel="stylesheet" href="/post/css/article-pub.css" type="text/css">
    <link rel="stylesheet" href="${APP_PATH}/commons/layui/css/layui.css"/>
   <style>    
    #header { visibility: hidden; margin-top: -66px; margin-bottom: 0;}
    #footer { visibility: hidden; display: none; }
    #main_all { width: 100%; }
    .form-list label { float: none; margin-bottom: 10px; }
    .form-list-right { float: none; }

    #edit,.w-e-text-container,.w-e-text{
           height: 500px !important;
    }
   </style>
  </head>
  <body>
    <div class="mb30" id="header">
	</div>
    <div id="main_all" style=" min-height: 418px;">
	   <div id="main_below_pw" style="margin-top:40px;">
       <div class="w1000 clearfix mb20">
       <div>
            
            <form id="blog-form" method="post"> <div style="display:none"><input type="hidden" name="csrfmiddlewaretoken" value="2e636794dfcd22be9559eb835f541008"></div>
                <div class="w1000 headerBox clearfix" style="background:white; z-index:100; top:40px;">
                    <h2>发布博文</h2>
                    <a href="/index.jsp" class="fl"><i style="margin:16px 6px 0 0;" class="icon icon-greenpointleft"></i>返回主页</a>
                    <button class="fr" type="button" id="pub">发 布</button>
                </div>
                <ul class="form-list" style="width:800px; margin:0 auto;">
                    <li class="clearfix titleform">
                        <label style="font-size:16px;">标题：</label>
                        <div class="form-list-right">
                            <input class="txt" id="blog-title" placeholder="最多48个字符" value="${recruit.theme}">
                            <p class="blog-title-form field-missing-notice">您还可以输入<span>48</span>个字符。</p>
                        </div>
                    </li>
                    <li class="tutorial-select clearfix">
                        <label style="width:70px; padding-right:0;">分类：</label>
                        <select name="classification" id="id_classification">
							<option value="" selected="selected">---------</option>
							<option value="1">效率笔记</option>
							<option value="19">生活小妙招</option>
							<option value="28">慧生活</option>
							<option value="46">情感</option>
                            <option value="1">撩汉</option>
                            <option value="19">美人说</option>
                            <option value="28">美妆·护肤·穿搭</option>
                            <option value="46">旅行·在路上</option>
                            <option value="1">好书推荐</option>
                            <option value="19">美食菜谱</option>
                            <option value="28">海外党</option>
                            <option value="46">大学那些事</option>
                            <option value="28">音乐</option>
                            <option value="46">影视</option>
                            <option value="34">信息技术</option>
						</select>
                    </li>
                    <li class="clearfix">
                        <label>封面：</label>
                        <div class="form-list-right">
                            <div class="upload-face" id="upload-pics-cover">

                                <a id="upload-pics-btn-cover" style="z-index: 99;"><i class="icon icon-upload-img"></i><span>上传封面</span></a>
                                <div class="uploading"></div>
                            
                            <div id="html5_1d6smd4hdh7j10f71pfb1fvslq33_container" class="moxie-shim moxie-shim-html5" style="position: absolute; top: 0px; left: 0px; width: 308px; height: 160px; overflow: hidden; z-index: 98;"><input id="html5_1d6smd4hdh7j10f71pfb1fvslq33" type="file" style="font-size: 999px; opacity: 0; position: absolute; top: 0px; left: 0px; width: 100%; height: 100%;" multiple="" accept="image/jpeg,.jpg,image/png,.png,.jpeg,image/gif,.gif,image/bmp,.bmp,.JPG,.PNG,.JPEG,.GIF,.BMP,application/pdf,.pdf,image/tiff,.tiff"></div></div>

                            <div class="upload-face-info">
                                <span>支持JPG、PNG格式，单张最大5M，宽度不少于1000PX</span>
                            </div>
                            <p class="blog-cover field-missing-notice">请上传一张封面</p>
                            <input type="hidden" value="" id="cover"/>
                            <input type="hidden" value="${recruitId}" id="recruit_id"/>
                        </div>
                    </li>
                    <li class="uEditorLi clearfix" style="margin-bottom:10px;">
                        <label>正文：</label>
                        <div class="form-list-right">
                            <div id="edit"></div>
                            <p class="blog-story field-missing-notice" style="">请输入正文</p>
                        </div>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    </div>
    </div>
    <div id="footer" class="clearfix">

    </div>
    <style type="text/css">
        .w-e-menu {
            position: relative !important;
            text-align: center !important;
            padding: 20px 10px !important;
            cursor: pointer !important;
            height: 50px;
            width: 50px;
        }
        .w-e-menu>i{
            width: 20px !important;
            height: 20px !important;
        }
    </style>
    <script src="${APP_PATH}/commons/jquery/jquery.js" type="text/javascript"></script>
    <script type="text/javascript" src="${APP_PATH}/commons/layui/layui.js"></script>
    <script src="${APP_PATH}/commons/wangEditor/wangEditor.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            var Editor=window.wangEditor;
            var editor=new Editor("#edit");
            var global_url='emotions/';
            editor.customConfig.menus =[
                'head',  // 标题
                'bold',  // 粗体
                'fontSize',  // 字号
                'fontName',  // 字体
                'italic',  // 斜体
                'underline',  // 下划线
                'strikeThrough',  // 删除线
                'foreColor',  // 文字颜色
                'backColor',  // 背景颜色
                'link',  // 插入链接
                'list',  // 列表
                'justify',  // 对齐方式
                'quote',  // 引用
                'emoticon',  // 表情
                'image',  // 插入图片
                'table',  // 表格
                'video',  // 插入视频
                'code',  // 插入代码
                'undo',  // 撤销
                'redo'  // 重复
            ];
            editor.customConfig.emotions=[
                {
                    // tab 的标题
                    title: 'default',
                    // type -> 'emoji' / 'image'
                    type: 'image',
                    // content -> 数组
                    content: [
                        {
                            alt: '[疑问]',
                            src: global_url+'2018new_ningwen_org.png'
                        },
                        {
                            alt: '[右哼哼]',
                            src: global_url+'2018new_youhengheng_org.png'
                        },
                        {
                            alt: '[顶]',
                            src: global_url+'2018new_ding_org.png'
                        },
                        {
                            alt: '[互粉]',
                            src: global_url+'2018new_hufen02_org.png'
                        },
                        {
                            alt: '[污]',
                            src: global_url+'2018new_wu_org.png'
                        },
                        {
                            alt: '[害羞]',
                            src: global_url+'2018new_haixiu_org.png'
                        },
                        {
                            alt: '[吃瓜]',
                            src: global_url+'2018new_chigua_org.png'
                        },
                        {
                            alt: '[打脸]',
                            src: global_url+'2018new_dalian_org.png'
                        },
                        {
                            alt: '[可爱]',
                            src: global_url+'2018new_keai_org.png'
                        },
                        {
                            alt: '[汗]',
                            src: global_url+'2018new_han_org.png'
                        },
                        {
                            alt: '[笑而不语]',
                            src: global_url+'2018new_xiaoerbuyu_org.png'
                        },
                        {
                            alt: '[馋嘴]',
                            src: global_url+'2018new_chanzui_org.png'
                        },
                        {
                            alt: '[抓狂]',
                            src: global_url+'2018new_zhuakuang_org.png'
                        }
                    ]
                },
                {
                    //tab标题
                    title:'emoji',

                    type:'image',

                    content:[
                        {
                            alt: '[爱你]',
                            src: global_url+'2018new_aini_org.png'
                        },
                        {
                            alt: '[允悲]',
                            src: global_url+'2018new_kuxiao_org.png'
                        },
                        {
                            alt: '[悲伤]',
                            src: global_url+'2018new_beishang_org.png'
                        },
                        {
                            alt: '[吃惊]',
                            src: global_url+'2018new_chijing_org.png'
                        },
                        {
                            alt: '[偷笑]',
                            src: global_url+'2018new_touxiao_org.png'
                        },
                        {
                            alt: '[可怜]',
                            src: global_url+'2018new_kelian_org.png'
                        },
                        {
                            alt: '[失望]',
                            src: global_url+'2018new_shiwang_org.png'
                        },
                        {
                            alt: '[生病]',
                            src: global_url+'2018new_shengbing_org.png'
                        },
                        {
                            alt: '[憧憬]',
                            src: global_url+'2018new_chongjing_org.png'
                        },
                        {
                            alt: '[感冒]',
                            src: global_url+'2018new_kouzhao_org.png'
                        },
                        {
                            alt: '[亲亲]',
                            src: global_url+'2018new_qinqin_org.png'
                        },
                        {
                            alt: '[可怜]',
                            src: global_url+'2018new_yun_org.png'
                        },
                        {
                            alt: '[太开心]',
                            src: global_url+'2018new_taikaixin_org.png'
                        },
                        {
                            alt: '[坏笑]',
                            src: global_url+'2018new_huaixiao_org.png'
                        },
                        {
                            alt: '[鄙视]',
                            src: global_url+'2018new_bishi_org.png'
                        },
                        {
                            alt: '[哈哈]',
                            src: global_url+'2018new_haha_org.png'
                        },
                        {
                            alt: '[傻眼]',
                            src: global_url+'2018new_shayan_org.png'
                        },
                        {
                            alt: '[NO]',
                            src: global_url+'2018new_no_org.png'
                        },
                        {
                            alt: '[赞]',
                            src: global_url+'2018new_nu_org.png'
                        },
                        {
                            alt: '[good]',
                            src: global_url+'2018new_good_org.png'
                        },
                        {
                            alt: '[中国赞]',
                            src: global_url+'2018new_zhongguozan_org.png'
                        }
                    ]
                },
                {
                    title:'sina',

                    type:'image',

                    content:[
                        {
                            alt: '[吐]',
                            src: global_url+'2018new_tu_org.png'
                        },
                        {
                            alt: '[色]',
                            src: global_url+'2018new_huaxin_org.png'
                        },
                        {
                            alt: '[微笑]',
                            src: global_url+'2018new_weixioa02_org.png'
                        },
                        {
                            alt: '[笑cry]',
                            src: global_url+'2018new_xiaoku_thumb.png'
                        },
                        {
                            alt: '[酷]',
                            src: global_url+'2018new_ku_org.png'
                        },
                        {
                            alt: '[衰]',
                            src: global_url+'2018new_shuai_org.png'
                        },
                        {
                            alt: '[哼]',
                            src: global_url+'2018new_heng_org.png'
                        },
                        {
                            alt: '[思考]',
                            src: global_url+'2018new_sikao_org.png'
                        },
                        {
                            alt: '[怒]',
                            src: global_url+'2018new_nu_org.png'
                        },
                        {
                            alt: '[鼓掌]',
                            src: global_url+'2018new_guzhang_org.png'
                        },
                        {
                            alt: '[钱]',
                            src: global_url+'2018new_qian_thumb.png'
                        },
                        {
                            alt: '[困]',
                            src: global_url+'2018new_kun_org.png'
                        },
                        {
                            alt: '[舔屏]',
                            src: global_url+'2018new_tianping_thumb.png'
                        },
                        {
                            alt: '[作揖]',
                            src: global_url+'2018new_zuoyi_org.png'
                        },
                        {
                            alt: '[握手]',
                            src: global_url+'2018new_woshou_org.png'
                        },
                        {
                            alt: '[圣诞老人]',
                            src: global_url+'xmax_oldman01_org.png'
                        }

                    ]
                },
                {
                    title:'小黄人',
                    type:'image',
                    content:[
                        {
                            alt: '[小黄人不屑]',
                            src: global_url+'xhrnew_buxie_org.png'
                        },
                        {
                            alt: '[小黄人高兴]',
                            src: global_url+'xhrnew_gaoxing_org.png'
                        },
                        {
                            alt: '[小黄人委屈]',
                            src: global_url+'xhrnew_weiqu_org.png'
                        },
                        {
                            alt: '[小黄人坏笑]',
                            src: global_url+'xhrnew_huaixiao_thumb.png'
                        },
                        {
                            alt: '[小黄人白眼]',
                            src: global_url+'xhrnew_baiyan_org.png'
                        },
                        {
                            alt: '[小黄人无奈]',
                            src: global_url+'xhrnew_wunai_org.png'
                        },
                        {
                            alt: '[小黄人得意]',
                            src: global_url+'xhrnew_deyi_org.png'
                        },
                        {
                            alt: '[小黄人微笑]',
                            src: global_url+'xhrnew_weixiao_org.png'
                        },
                        {
                            alt: '[小黄人剪刀手]',
                            src: global_url+'xhrnew_jiandaoshou_org.png'
                        }
                    ]

                },
                {
                    title:'其他',

                    type:'image',

                    content:[
                        {
                            alt: '[星星]',
                            src: global_url+'hot_star171109_org.png'
                        },
                        {
                            alt: '[半星]',
                            src: global_url+'hot_halfstar_org.png'
                        },
                        {
                            alt: '[空星]',
                            src: global_url+'hot_blankstar_org.png'
                        },
                        {
                            alt: '[鲜花]',
                            src: global_url+'2018new_xianhua_org.png'
                        },
                        {
                            alt: '[音乐]',
                            src: global_url+'2018new_yinyue_org.png'
                        },
                        {
                            alt: '[给力]',
                            src: global_url+'2018new_geili_org.png'
                        },
                        {
                            alt: '[下雨]',
                            src: global_url+'2018new_yu_org.png'
                        },
                        {
                            alt: '[蜡烛]',
                            src: global_url+'2018new_lazhu_org.png'
                        },
                        {
                            alt: '[生日快乐]',
                            src: global_url+'2018new_dangao_org.png'
                        },
                        {
                            alt: '[飞机]',
                            src: global_url+'2018new_feiji_org.png'
                        },
                        {
                            alt: '[心碎]',
                            src: global_url+'2018new_xinsui_org.png'
                        },
                        {
                            alt: '[心]',
                            src: global_url+'2018new_xin_org.png'
                        },
                        {
                            alt: '[礼物]',
                            src: global_url+'2018new_liwu_org.png'
                        },
                        {
                            alt: '[骷髅]',
                            src: global_url+'2018new_kulou_org.png'
                        },
                        {
                            alt: '[看涨]',
                            src: global_url+'kanzhangv2_org.gif'
                        },
                        {
                            alt: '[看跌]',
                            src: global_url+'kandiev2_org.gif'
                        },
                        {
                            alt: '[神马]',
                            src: global_url+'horse2_org.gif'
                        },
                        {
                            alt: '[带着微博去旅行]',
                            src: global_url+'eventtravel_org.gif'
                        }
                    ]
                }
            ];
            /**
             * 配置字体颜色、背景色
             editor.customConfig.colors = [
             '#000000',
             '#eeece0',
             '#1c487f',
             '#4d80bf',
             '#c24f4a',
             '#8baa4a',
             '#7b5ba1',
             '#46acc8',
             '#f9963b',
             '#ffffff'
             ]
             editor.customConfig.uploadImgParams={
    uuid:12312312
}
             隐藏“网络图片”tab
             editor.customConfig.showLinkImg = false
             如果想完全自己控制图片上传的过程，可以使用如下代码
             editor.customConfig.customUploadImg = function (files, insert) {
    // files 是 input 中选中的文件列表
    // insert 是获取图片 url 后，插入到编辑器的方法

    // 上传代码返回结果之后，将图片插入到编辑器中
    insert(imgUrl)
}
             */

//用户点击富文本区域会触发onfocus函数执行
            editor.customConfig.onfocus = function () {
                //console.log("onfocus")
            }
            editor.customConfig.onblur = function (html) {
                // html 即编辑器中的内容
                // console.log('onblur', html)
            }
//插入网络地址后的回调函数
            editor.customConfig.linkImgCallback = function (url) {
                // console.log(url) // url 即插入图片的地址
            }
            editor.customConfig.linkCheck = function (text, link) {
                console.log(text) // 插入的文字
                console.log(link) // 插入的链接
                return true // 返回 true 表示校验成功
                // return '验证失败' // 返回字符串，即校验失败的提示信息
            }
            editor.customConfig.linkImgCheck = function (src) {
                console.log(src) // 图片的链接
                return true // 返回 true 表示校验成功
                // return '验证失败' // 返回字符串，即校验失败的提示信息
            }
            editor.customConfig.uploadImgParams={
                id:${id}
            }
            editor.customConfig.uploadImgServer  ='/uploader/cover';
            editor.customConfig.uploadImgMaxLength = 5;
            editor.customConfig.uploadImgMaxSize = 5 * 1024 * 1024;
            editor.customConfig.uploadFileName = 'uploadFiles';
            editor.customConfig.uploadImgHooks = {
                before: function (xhr, editor, files) {
                    // 图片上传之前触发
                    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，files 是选择的图片文件
                    // 如果返回的结果是 {prevent: true, msg: 'default_avatar.png'} 则表示用户放弃上传
                    // return {
                    //     prevent: true,
                    //     msg: '放弃上传'
                    // }
                },
                success: function (xhr, editor, result) {
                    // 图片上传并返回结果，图片插入成功之后触发
                    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
                    if(result.errno==0){
                        for(var i=0;i<result.data.length;i++)
                            editor.txt.append('<div class="image-package"><p><img src="//localhost'+result.data[i]+'" style="max-width: 700px"></p></div>');
                    }
                    /***
                     * editor  文本操作:
                     *  editor.txt.append();追加内容
                     *  editor.txt.text();获取文本内容
                     *   editor.txt.html();设置内容||读取html
                     *   editor.txt.clear()清空编辑器内容
                     */


                },
                fail: function (xhr, editor, result) {
                    // 图片上传并返回结果，但图片插入错误时触发
                    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
                },
                error: function (xhr, editor) {
                    // 图片上传出错时触发
                    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
                },
                timeout: function (xhr, editor) {
                    // 图片上传超时时触发
                    // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
                },
                // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
                // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
                customInsert: function (insertImg, result, editor) {
                    // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
                    // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
                    // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
                    var url = result.url;
                    insertImg(url);
                    // result 必须是一个 JSON 格式字符串！！！否则报错
                }
            }
            editor.create()
            layui.use('upload', function(){
                var upload = layui.upload;
                isFirst=true
                upload.render({
                    elem: '#upload-pics-btn-cover'
                    ,url: '/uploader/cover'
                    ,multiple: true,
                    field:'uploadFiles',
                    number:1,
                    data:{id:${id}}
                    ,before: function(obj){
                        //预读本地文件示例，不支持ie8
                        obj.preview(function(index, file, result){
                            if(isFirst){
                                $("#upload-pics-btn-cover").html('')
                                $('#upload-pics-cover .uploading').after('<img id="cover" src="'+result+'" style="top: -74px;"><div class="uploadtxtbtn">点击可以更换封面图片</div>')
                                isFirst=false;
                            }else{

                                $('#cover').attr('src',result)
                            }

                        });
                    }
                    ,done: function(res,index, upload){
                        if(res.errno==0){
                            $("#cover").val(res.data[0])
                        }
                    },
                    error: function(index, upload){

                    }
                });

            })
            $("#pub").click(function () {
                 var article={
                     id:${id},
                     type:1,
                     title:$("#blog-title").val(),
                     cover:$("#cover").val(),
                     category:$("#id_classification option:selected").text(),
                     content:editor.txt.text(),
                     html:editor.txt.html()
                 }
                 if(!article.id)
                     return;
                 $.ajax({
                    url:'/post/recruit/compose',
                    type:'POST',
                    dataType:'json',
                    data:{id:article.id,
                          title:article.title,
                          cover:article.cover,
                          category:article.category,
                          content:article.content,
                          type:article.type,
                          html:article.html,
                          recruitId:$("#recruit_id").val()
                    },
                    success:function (data) {
                       if(data.status==200){
                           alert("保存成功")
                       }
                    }
                })

            })
        })
    </script>
</body>
</html>