
$(function(){
    
    var thisEditor
    var needNotice = false;
    var showCheckingNotice = $('.headerBox').hasClass('editing') ? true : false;
    var originTop;
    var posting = false;
    var picUploaded = 0;  

    if ($('.blog-type a.current').length == 0) {
        $('.blog-type a').first().addClass('current');
        $('.blog-license').show();
    };

    $(document).ready(function(){
        $(window).bind('beforeunload', function(){
            if(needNotice){
                return '请确认保存或提交数据成功, 未发布内容将会全部清空!';
            }
        });
        $('input, select, textarea').bind('input', function(){
            needNotice = true;
        });
    });

    $('input.txt').placeholder();
    $('textarea.t-autosize').autoTextarea();
    textCounter('#blog-title',48);

    // $('.blog-sort li').on({
    //     mouseenter: function(){
    //         $('.blog-sort-intro').hide();
    //         $(this).children('.blog-sort-intro').show();
    //     },
    //     mouseleave: function(){
    //         $(this).children('.blog-sort-intro').hide();
    //         $('.blog-sort li a.current').next('.blog-sort-intro').show();
    //     }
    // });

    $('.blog-sort-a').click(function(){
        if ( $(this).hasClass('hi') ){
            $('.blog-sort-intro').show();
            $('.blog-sort-intro').find('p').show();
            $('.tutorial-select').hide();
            $('.uEditorToolbar').follow({top:$('.uEditorLi').offset().top,targetTop:44});
            $('.blog-category-select').hide();
        } else if ( $(this).hasClass('tutorial') ) {
            $('.blog-sort-intro').hide();
            $('.tutorial-select').show();
            $('.uEditorToolbar').follow({top:$('.uEditorLi').offset().top,targetTop:44});
        } else {
            $('.blog-sort-intro').hide();
            $('.tutorial-select').hide();
            $('.uEditorToolbar').follow({top:$('.uEditorLi').offset().top,targetTop:44});
            $('.blog-category-select').hide();
        }
        $('.blog-sort a.current').removeClass('current');
        $(this).addClass('current');
        $('#blog-sort-id').val($(this).parent().attr('data-id'));
        CRcheck();
    });

    $('.blog-type a').click(function(){
        $('.blog-type a.current').removeClass('current');
        if ( $(this).attr('data-ID') == "1" ){
            $('#blog-type-id').val('1');
            $('#blog-type-id').next('.msg').hide();
            $('.blog-license').show();
        } else {
            $('.blog-license').hide();
            $('#blog-type-id').next('.msg').show();
            $('#blog-type-id').val($(this).attr('data-ID'));
        }

        $(this).addClass('current');
    });

    $('.modify-license').click(function(){
        if( $(this).hasClass('fold') ){
            $(this).removeClass('fold');
            $(this).text('展开');
            $('.blog-license-content').slideUp();
        } else {
            $(this).addClass('fold').text('收起');
            $('.blog-license-content').slideDown();
        }
    });

    $('.blog-license-content .confirm').click(function(){
        if( $('.modify-license').hasClass('fold') ){
            $('.modify-license').removeClass('fold');
            $('.modify-license').text('展开');
            $('.blog-license-content').slideUp();
        } else {
            $('.modify-license').addClass('fold').text('收起');
            $('.blog-license-content').slideDown();
        }
    })

    $('.blog-license-content input[type=radio]').click(function(){
        $('.blog-license-default span').html($(this).next('span').html());
    });


    $(function(){
        var queueMaxima = 1;
            var init = {
                Error: function(up, error) {
                    $('#upload-pics-btn-cover').loadingDots2('stop');
                    switch(error.code) {
                    case plupload.INIT_ERROR:
                    $('#uploader_notice').css({'color':'#FFB2B0'}).html(sogoke.PLUPLOAD_ERROR_MESSAGES['INIT_ERROR']);
                    break;
                    case plupload.HTTP_ERROR:
                    $('#uploader_notice').css({'color':'#FFB2B0'}).html(sogoke.PLUPLOAD_ERROR_MESSAGES['HTTP_ERROR']);
                    break;
                    case plupload.FILE_SIZE_ERROR:
                        $('#uploader_notice').css({'color':'#FFB2B0'}).html('图片大于5M,请压缩后再上传');
                        break;
                    case plupload.FILE_EXTENSION_ERROR:
                        $('#uploader_notice').css({'color':'#FFB2B0'}).html(ERROR_FMT);
                        break;
                    default:
                    $('#uploader_notice').css({'color':'#FFB2B0'}).html(sogoke.PLUPLOAD_ERROR_MESSAGES['DEFAULT']);
                    }   
                },           
                FilesAdded: function(up, files) {
                    var i = 0;
                    if (files.length  > queueMaxima) {
                        for (; i < files.length; ++i ) {
                            up.removeFile(files[i]);
                        }
                        $('#uploader_notice').css({'color':'#FFB2B0'}).html('每次只能上传一张封面');
                    } else {
                        up.start();
                        $('#upload-pics-btn').loadingDots2({'word':'上传中'});      
                    }
                },          
                FileUploaded: function(up, file, info) {
                    var response = JSON.parse(info.response);
                                                                
                    $('#uploader_notice').css({'color':'#FFB2B0'}).html('');   
                    $('#upload-pics-cover .uploading').html('').hide();
                    if($('#upload-pics-cover img').length > 0){
                        $('#upload-pics-cover img').replaceWith('<img data-suid="'+ response.suid +'" src="'+ response.url+'">');
                        setTimeout(function(){
                            console.log($('#upload-pics-cover img').height());
                            var fixedTop = $('#upload-pics-cover img').height()>160? '-' + ($('#upload-pics-cover img').height() - 160)/2 + 'px':0;
                            $('#upload-pics-cover img').animate({'top':fixedTop});
                        },200)
                    }else{
                        console.log($('#upload-pics-btn-cover'))
                        $('#upload-pics-btn-cover').html('');
                        $('#upload-pics-cover .uploading').after('<img data-suid="'+ response.suid +'" src="'+ response.url+'"><div class="uploadtxtbtn" >更换图片</div>')
                        setTimeout(function(){
                            console.log($('#upload-pics-cover img').height());
                            var fixedTop = $('#upload-pics-cover img').height()>160? '-' + ($('#upload-pics-cover img').height() - 160)/2 + 'px':0;
                            $('#upload-pics-cover img').animate({'top':fixedTop});
                        },200)
                    }
                    CR.CoverExisted.run(showCheckingNotice);
                    CRcheck();
                },
                UploadComplete: function(up, files) {
                    $('#upload-pics-btn-cover').loadingDots2('stop');
                    //$('#upload-pics-btn-cover').text("");
                }
            };

        var uploaderCover = sogoke.uploader({
                multiple_queues:true,
                location:'create_blog',
                container:"upload-pics-cover",
                browse_button:"upload-pics-btn-cover",
                init:init
            }); 
        uploaderCover.init();
    });


    $.extend($.uEditorToolbarItems, {
        uploadImageButton : {
          id:'uploads',
          label : '上传图片',
          className : 'uploadImageButtonClass'
        }
    });

    ///////////////////////////////
    // start simditor initiation //
    ///////////////////////////////
    //初始化编辑器
    var simditor = new Simditor({
        textarea: $('#simditor'),
        toolbarFloat: true,
        toolbarFloatOffset: 50,
        cleanPaste: true,
        allowedTags: ['br', 'span', 'a', 'img', 'b', 'strong', 'i', 'strike', 'u', 'font', 'p', 'ul', 'ol', 'li', 'blockquote', 'pre', 'code', 'h1', 'h2', 'h3', 'h4', 'hr','div','span'],
        allowedAttributes : {
            div: ['class'],
            img: ['src','class','data-suid'],
            i: ['class'],
            video: ['src','video_cover','class','data-vid','data-addr','alt','title']
        },
        toolbar: [
            'image',
            'link',
            '|',
            'title',
            'bold',
            'italic',
            //'underline',
            //'strikethrough',
            'fontScale',
            'color',
            '|',
            'ol',
            'ul',
            'blockquote',
            'code',
            'table',
            //'|',
            'hr',
            //'|',
            'indent',
            'outdent',
            'alignment'
        ]
    })

    sogoke.simditor = simditor

    var tpl = "<div class=\"simditor-popover image-resize\">\
                    <div class=\"link-settings\">\
                        <div class=\"settings-field\">\
                            <label>宽度 </label>\
                            <input class=\"image-size\" id=\"edit-width\" type=\"text\" value=\"默认\" tabindex=\"2\" />\
                            <a class=\"btn-restore\" href=\"javascript:;\"\
                                  title=\"\" tabindex=\"-1\">\
                                <span class=\"simditor-icon simditor-icon-undo\"></span>\
                            </a>\
                        </div>\
                    </div>\
                </div>";
        $('body').append(tpl);

    simditor.insertHtmlToEditor = function( html, setSize ){
        if (!simditor.inputManager.focused) {
            simditor.focus();
        }; 
        range = simditor.selection.range();
        range.deleteContents();
        simditor.selection.range(range);
        console.log(html);
        range.insertNode(html[0]);
        simditor.selection.setRangeAfter(html, range);
        simditor.trigger('valuechanged');
        console.log(html);
    }

    $(document).on({
        'click': function(e){
            $('#edit-width').val($(this).attr('data-width')).focus(function(){ this.select();});
            $('.simditor-popover.image-resize').css({'top':$(this).offset().top + 5 , 'left':$(this).offset().left + 5}).show();

            $(document).one('click',function(e){

                $('.simditor-popover.image-resize').hide();
            })
            imageSize($(this));
            return false;
        }
    },'.simditor-body img:not(.sogoke-video-preview), .content_photo');

    function imageSize( $el ){
        $('.simditor-popover.image-resize,.simditor-popover.image-resize *').click(function(e){
            e.stopPropagation();
        })

        $('#edit-width').one('blur',function(e){
            if ($('#edit-width').val() !== '默认') {
                console.log($el);
                $el.removeClass('onEdit').css('width',$('#edit-width').val()).addClass('edited');
                $el.attr('data-width',$('#edit-width').val());
            };
        })

        $('.simditor-icon-undo').one('click',function(e){
            console.log($el);
            $el.removeClass('edited').addClass('onEdit').css('width','auto');
            $el.attr('data-width','默认');
            $('#edit-width').val('默认');
            return false;
        });

    }

    $(document).on({
        'click':function(){
            // var urlPrompt = prompt("输入视频地址:", "http://");
            // if (urlPrompt && urlPrompt.split('http://')[1] !== '') {
            //     var html = sogoke.createVideo(urlPrompt,640,387);
            //     insertHtmlToEditor($(html));
            // }else{
            //     alert('未插入视频')
            // }

            $('#upload-video').show()
        }
    },'.toolbar-item-video');

    simditor.createLinkVideo = function(url, width, height) {
        var html = sogoke.createVideoOld(url,540,360);
        simditor.insertHtmlToEditor($(html));
    }

    ///////////////////////////////
    //  end simditor initiation  //
    ///////////////////////////////


    setTimeout(function(){
        if (simditor) {
            $('.toolbar-item-image').attr('id','uploadsNew');
            $('.toolbar-item-image').parent('li').attr('id','uploads_wrapper');
            $('.simditor-toolbar>ul')
                .prepend($('<li id="uploads_wrapper">\
                    <a tabindex="-1" unselectable="on" class="toolbar-item toolbar-item-video" href="javascript:;" title="插入视频" style="z-index: 1;">\
                        <span class="simditor-icon simditor-icon-video"></span>\
                    </a>\
                </li>'));

            $(function() {
                $('video.sogokeVideo').each(function(i,x) {

                    var url = $(this).data('src');
                    var html = sogoke.createVideoOld(url)

                    $(this).replaceWith($(html));
                })
            })

            $(function() {
                $('.simditor-body').find('img').each(function(i,x) {
                    var src = $(x).attr('src')
                    var matched = $(x).attr('src').match(/media\/photos\/([a-z0-9]+)/i)

                    var suid = matched && matched.length > 1 ? matched[1] : null
                    
                    if ( suid) {    
                        var html = '<img class="uploaded_photo" src="'+src+'" data-suid="'+suid+'">'
                        $(x).replaceWith($(html))
                    }
                })
            })

            thisEditor = simditor;
            
            var init = {
                PostInit: function() {
                    document.getElementById('uploadsNew').onclick = function() {
                        //uploader.start();
                        //return false;
                    };
                },
                Error: function(up, error) {
                    //
                    switch(error.code) {
                    case plupload.INIT_ERROR:
                    alert('没有找到上传插件，你可能需要安装Adobe Flash');
                    break;
                    case plupload.HTTP_ERROR:
                    alert('网络错误');
                    break;
                    default:
                    alert(error);
                    alert(error.code);
                    }      
                },             
                FilesAdded: function(up, files) {
                    up.start();
                    //$('#uploadsNew').css({'background':'url(/static/img/loading.gif)'});
                    $('.simditor-icon-picture-o').addClass('loading');
                },
                UploadProgress: function(up, file) {
                },
                FileUploaded: function(up, file, info) {
                    $('.simditor-icon-picture-o').removeClass('loading');
                    var response = JSON.parse(info.response);
                    file.id = response.suid;
                    var $img, range;
                    //$img = $('<img class="uploaded_photo" src="http://sogoke-photo.b0.upaiyun.com/media/photos/' + response.suid + '" />');
                    $img = $('<img data-width="默认" class="content_photo tmp_photo onEdit" src="' + response.url + '" data-suid="' + response.suid + '" />');
                    $line = $('<br/>');
                    simditor.insertHtmlToEditor( $img, 1 );
                    simditor.insertHtmlToEditor( $line, 0 );
                    picUploaded = $('.simditor-body').find('.tmp_photo').length;
                },
                UploadComplete: function(up, files) {
                }
            };

            var uploader = sogoke.uploader({'location':"create_blog",
                'container':'uploads_wrapper','browse_button':'uploadsNew', 'init':init});

            uploader.init();

            $('.sogoke-video-wrap').each(function(i,x) {
                var vid = $(x).find('video').data('vid')
                var cover = $(x).find('video').attr('video_cover') || $(x).find('img').attr('src')
                var src = $(x).find('video').attr('src')
                console.log(cover, 'cover')

                var videoCover = cover.match(/media\/photos/) ? (cover + '!video') : cover

                var $html = $('<img\
                        data-vid="' + vid + '"\
                        data-addr="'+ src +'" \
                        data-cover="'+ cover +'"\
                        class="sogoke-video-preview" \
                        src="' + videoCover + '" \
                    />')

                $(x).replaceWith($html)
            })

            $('.sogoke-link-video').each(function(i,x) {
                var url = $(x).find('video').attr('src')

                var html = sogoke.createVideoOld(url,540,360);

                $(x).replaceWith($(html))
            })
    
            //////////////////////////////////////////////////////////////////////
            // Event Handlers
            //////////////////////////////////////////////////////////////////////  

            $('#blog-title').on('keyup',function(){
                CR.TitleLengthCheck.run(true);
            });

            $(document).on('click',function(){
                CRcheck();
                //thisEditor.cleanSource();
            });

            inputTags('.input-tags', function(el) {
                CR.TagsFilled.run(showCheckingNotice);
                CRcheck();
            }, function(el) {
                CR.TagsFilled.run(showCheckingNotice);
                CRcheck();
            });

            $.ajax({
                type:'GET',
                url: '/accounts/user/binds/',
                datatype: 'json',
                data: {},
                cache: false,
                success: function(response){
                    var html = Handlebars.templates.share(response)
                    $('button[type="submit"].btn').after(html);
                }
            });

            $('#blog-form').submit(function(e){
                console.log(posting)
                if (posting) {
                    sogoke.showFntext2_notice('正在发布中...请稍后')
                    return false
                }

                //thisEditor.cleanSource();
                showCheckingNotice = true;

                e.preventDefault();

                var for_user_id       =  undefined;
                var for_user_username =  undefined;
                var for_user_occupation= undefined;
                var for_user_url = undefined;
                var new_category = undefined;
                var new_sub_category = undefined;

                var all_fields_filled = CRcheck(true);
        
                if (all_fields_filled) {

                    posting = true
        
                    var photos_suid       = [],
                        videos_vid        = [],
                        cover             = $('#upload-pics-cover img').data('suid'), 
                        //body              = $(editor.iframe).contents().find('body'),
                        body              =$('.simditor-body'),
                        raw_html          = body.html(),
                        text              = sogoke.stripNewLineHTML(raw_html),
                        title             = $('#blog-title').val(),
                        title_placeholder = $('#blog-title').attr('placeholder'),
                        tag_names         =  parseTag('.input-tags-list'),
                        blog_type         = $('#blog-type-id').val(),
                        blog_license      = $('input[name="license-choose"]:checked').val(),
                        blog_origin_url   = $('input[name="origin_url"]').val(),
                        category_name     = $('input[name="blog-sort-id"]').val();

                    var authorSiteUrl = $('input.authorSiteUrl');
                    var authorName = $('input.authorName');
                    var authorOccupation = $('input.authorOccupation');
                    if( category_name === 'interview'){
                        var match = $('input.authorSiteUrl').val().match(/http:\/\/www\.sogoke\.com\/r\/([0-9]+)\//);
                        if (match) {
                            for_user_id = parseInt(match[1]);
                        }else{
                            for_user_url = authorSiteUrl.val();
                        }
                        for_user_username = authorName.val();
                        for_user_occupation = authorOccupation.val();
                    }else if (category_name === 'tutorial'){
                        new_category = $('#id_classification').val();
                        new_sub_category = $('#id_sub_classification').val();
                    }

                    // var photoCount = body.find('img.tmp_photo').length;
                    // if(picUploaded !== photoCount){
                    //     sogoke.showFntext2_notice('正在处理图片中');
                    //     return false;
                    // }
                    // Replace tmporaory photo with real photo url
                    // body.find('img.tmp_photo').each(function(index, element) {
                    //     var suid = $(this).data('suid'), src;
            
                    //     src = sogoke.MEDIA_PHOTO_URL + 'photos/' + suid + '!B';
                    //     $(this).attr({'src':src, 'class':'uploaded_photo'});
                    // });

                    body.find('img').each(function(i,x) {
                        if ($(x).hasClass('tmp_photo') && $(x).data('suid')) {
                            var suid = $(x).data('suid'), src;
                            src = sogoke.MEDIA_PHOTO_URL + 'photos/' + suid + '!B';
                            $(x).removeClass('tmp_photo');
                            $(x).attr({'src':src, 'class':'uploaded_photo'});
                        }else if($(x).attr('src').match(/^(\/media\/tmp\/)(.*)(\.jpeg)$/)){
                            var matched = $(x).attr('src').match(/^(\/media\/tmp\/)(.*)(\.jpeg)$/);
                            var suid = matched[2];
                            var src = sogoke.MEDIA_PHOTO_URL + 'photos/' + suid + '!B';
                            $(x).attr({'src':src, 'class':'uploaded_photo'});
                            $(x).data('suid',suid);
                        }
                    })

                    //
                    body.find('img.uploaded_photo').each(function(index, element) {
                        var suid = $(this).data('suid');
                        photos_suid.push(suid);
                    });

                    body.find('iframe.sogokeVideo').each(function(i,x) {
                        var url = $(this).data('src');
                        var $html = $('<video class="sogokeVideo" data-src="'+ url +'"></video>');
                        $(this).replaceWith($html);
                    })

                    body.find('.link-video-vessel').each(function(i,x) {
                        var url = $(this).data('url')
                        var $html = $('<div class="sogoke-link-video" data-url="'+url+'"><img src="https://sogoke-photo.b0.upaiyun.com/media/photos/bwNmDJ6JrjjfCsJdCgHP7U!/both/632x360/quality/100" alt="" /><video class="link-video-tag" data-vid="" video_cover="https://sogoke-photo.b0.upaiyun.com/media/photos/bwNmDJ6JrjjfCsJdCgHP7U" data-src="'+url+'" src="'+url+'" /></div>')

                        $(this).replaceWith($html)
                    })

                    body.find('img.sogoke-video-preview').each(function(i,x) {
                        var cover = $(x).data('cover')
                        var vid = $(x).data('vid')
                        var src = $(x).data('addr')

                        videos_vid.push(vid)

                        var $videoHtml = sogoke.createSogokeVideo(vid, cover, src)
                        $(x).replaceWith($videoHtml)
                    })

                    var share_to = [];
                    $.each(['sina','qq','douban'], function(i, v){
                        if($('input[name="share_to_'+v+'"]:checked').length >0){
                            share_to.push(v);
                        }
                    });

                    var data = {
                        title:title,category_name:category_name,
                        type:blog_type, license:blog_license,
                        origin_url:blog_origin_url,
                        tag_names:tag_names.toString(),
                        cover:cover,
                        photos_suid: photos_suid.toString(),
                        html:body.html(), 
                        text:text,
                        for_user_id: for_user_id||"",
                        for_user_username : for_user_username||"",
                        for_user_occupation: for_user_occupation||"",
                        for_user_url: for_user_url||"",
                        share_to:share_to.join(','),
                        classification: new_category||"",
                        sub_classification: new_sub_category||"",
                        videos_vid: videos_vid.join(',')
                    };

                    var options = {
                            data:data,
                            error:function(data) {
                                posting = false
                                sogoke.showFntext2_error('博文发布失败！');
                            },
                            success:function(data) {
                                var redirect, message;

                    
                                if (window.location.pathname === '/create/blog/') {
                                    redirect = '/home/';
                                    message = '博文发布成功，请等待回到首页';
                                }  else {  // Edit
                                    var path = window.location.pathname;
                                    redirect = path.substr(0, path.length - 5); // Fileter trailing 'edit/';
                                    message = '完成博文编辑，请等待回到原始页面';        
                                }
                                
                            sogoke.showFntext2_bingo(message, 3000, function() {
                                needNotice=false;
                                posting = false;
                                window.location.href = redirect;
                            });
                        }
                    };

                    $(this).ajaxSubmit(options);
                };

            });
        };   
    },100);

    //global.js CR function

    new CR({
        id: 'TitleNotEmpty',
        criteria: function() {
            return !/^\s*$/.test($('#blog-title').val());
        },
        succeed: function() {
            $('.blog-title-form.field-missing-notice').hide();
        },
        failure: function() {
            $('.blog-title-form.field-missing-notice').css('color','#FF9997').text('标题不能为空').show();
        }
    });

    new CR({
        id: 'TitleLengthCheck',
        criteria: function() {
            return $('#blog-title').val().length <= 48;
        },
        succeed: function() {
            $('.blog-title-form.field-missing-notice').css('color','#b5b5b5').text('还可以输入' + (48-$('#blog-title').val().length) + '个字').show();
        },
        failure: function() {
            $('.blog-title-form.field-missing-notice').css('color','#FF9997').text('最多可输入48个字符,您多输入了' + ($('#blog-title').val().length - 48) + '个字').show();
        }
    });

    new CR({
        id: 'TitleRightLength',
        criteria: function() {
            return $('#blog-title').val().length <= 48;
        },
        succeed: function() {
            $('.blog-title-form.field-missing-notice').css('color','#b5b5b5').hide();
        },
        failure: function() {
            $('.blog-title-form.field-missing-notice').css('color','#FF9997').text('最多可输入48个字符,您多输入了' + ($('#blog-title').val().length - 48) + '个字').show();
        }
    });

    new CR({
        id: 'MainCategoryFilled',
        criteria: function() {
            return $('#blog-sort-id').val() != 0;
        },
        succeed: function() {
            $('.blog-category.field-missing-notice').hide();
            $('.blog-category-interview.field-missing-notice').hide();
            $('.blog-category-name.field-missing-notice').hide();
            $('.blog-category-occupation.field-missing-notice').hide();
        },
        failure: function() {
            $('.blog-category.field-missing-notice').text('请选择分类').show();
        }
    });

    new CR({
        id: 'MainCategoryInterviewFilled',
        criteria: function(){
            //console.log(/http:\/\/www\.sogoke\.com\/r\/([0-9]+)\//.test($('.authorSiteUrl').val()))
            //return /http:\/\/www\.sogoke\.com\/r\/([0-9]+)\//.test($('.authorSiteUrl').val());
            return !/^\s*$/.test($.trim($('.authorSiteUrl').val()));
        },
        succeed: function(){
            $('.blog-category-interview.field-missing-notice').hide();
        },
        failure: function(){
            $('.blog-category-interview.field-missing-notice').show();
        }
    })

    new CR({
        id: 'MainCategoryNameFilled',
        criteria: function(){
            return !/^\s*$/.test($.trim($('.authorName').val()));
        },
        succeed: function(){
            $('.blog-category-name.field-missing-notice').hide();
        },
        failure: function(){
            $('.blog-category-name.field-missing-notice').show();
        }
    })

    new CR({
        id: 'MainCategoryOccupationFilled',
        criteria: function(){
            return !/^\s*$/.test($.trim($('.authorOccupation').val()));
        },
        succeed: function(){
            $('.blog-category-occupation.field-missing-notice').hide();
        },
        failure: function(){
            $('.blog-category-occupation.field-missing-notice').show();
        }
    })

    new CR({
        id: 'SubClassificationSelected',
        criteria: function(){
            return $('#id_sub_classification').val() != 0;
        },
        succeed: function(){
            $('.blog-sub-classification.field-missing-notice').hide();
        },
        failure: function(){
            $('.blog-sub-classification.field-missing-notice').show();
        }
    })

    new CR({
        id: 'MainTutorialCategoryFilled',
        criteria: function() {
            return $('#id_classification').val() != 0;
        },
        succeed: function() {
            $('.blog-category-select.field-missing-notice').hide();
        },
        failure: function() {
            $('.blog-category-select.field-missing-notice').text('请选择分类').show();
        }
    });

    new CR({
        id: 'CoverExisted',
        criteria: function() {
            return $('#upload-pics-cover img').length != 0;
        },
        succeed: function() {
            $('.blog-cover.field-missing-notice').hide();
        },
        failure: function() {
            $('.blog-cover.field-missing-notice').show();
        }
    });

    new CR({
        id: 'SubTutorialCategoryFilled',
        criteria: function(){
            return $('#id_sub_classification').val() != 0;
        },
        succeed: function(){
            $('.blog-category-select.field-missing-notice').hide();
        },
        failure: function(){
            $('.blog-category-select.field-missing-notice').text('请选择子类型').show();
        }
    })

    new CR({
        id: 'SubCategoryInputRight',
        criteria: function(){
            if ($('#blog-type-id').val() !== '1') {
                return !/^\s*$/.test($.trim($('.origin_url').val()));
            }else{
                return true;
            }
        },
        succeed: function(){
            $('.blog-license-selection.field-missing-notice').hide();
        },
        failure: function(){
            $('.blog-license-selection.field-missing-notice').show();
        }
    })

    new CR({
        id: 'TagsFilled',
        criteria: function() {
            return $('.input-tags-list li').length != 0
        },
        succeed: function() {
            $('.blog-tags.field-missing-notice').hide();
        },
        failure: function() {
            $('.blog-tags.field-missing-notice').text('请输入标签').show();
        }
    });

    new CR({
        id: 'StoryFilled',
        criteria: function() {
            var content = $($(thisEditor).html());  // #TODO# use official API instead
            //return !/^\s*$/.test(content.replace(/\<br\>/g,''));
            return true;
        },
        succeed: function() {
            $('.blog-story.field-missing-notice').hide();
        },
        failure: function() {
            $('.blog-story.field-missing-notice').show();
        }
    });

    function CRcheck(interviewNotice){
        var all_fields_filled = true;
        if (!CR.TitleNotEmpty.run(showCheckingNotice)) {
            all_fields_filled = false;
            $('.headerBox').find('button').removeClass('all_filled');
        }else if (!CR.TitleRightLength.run(true)) {
            all_fields_filled = false;
            $('.headerBox').find('button').removeClass('all_filled');
        }

        if (!CR.MainCategoryFilled.run(showCheckingNotice)){
            all_fields_filled = false;
            $('.headerBox').find('button').removeClass('all_filled');
        }else if($('#blog-sort-id').val() == 'interview'){
            var ifShow = interviewNotice ? interviewNotice : showCheckingNotice;
            if (!CR.MainCategoryInterviewFilled.run(ifShow)) {
                all_fields_filled = false;
                $('.headerBox').find('button').removeClass('all_filled');
            }else
            if (!CR.MainCategoryNameFilled.run(ifShow)) {
                all_fields_filled = false;
                $('.headerBox').find('button').removeClass('all_filled');
            }else
            if (!CR.MainCategoryOccupationFilled.run(ifShow)) {
                all_fields_filled = false;
                $('.headerBox').find('button').removeClass('all_filled');
            };
        }else if($('#blog-sort-id').val() == 'tutorial'){
            if (!CR.MainTutorialCategoryFilled.run(showCheckingNotice)){
                all_fields_filled = false;
                $('.headerBox').find('button').removeClass('all_filled');
                $field_to_focus = $('#id_new_category');
            }else if(!CR.SubTutorialCategoryFilled.run(showCheckingNotice)){
                all_fields_filled = false;
                $('.headerBox').find('button').removeClass('all_filled');
                $field_to_focus = $('#id_new_sub_category');
            }
        }

        if (!CR.SubCategoryInputRight.run(showCheckingNotice)){
            all_fields_filled = false;
            $('.headerBox').find('button').removeClass('all_filled');
        }

        if (!CR.CoverExisted.run(showCheckingNotice)){
            all_fields_filled = false;
            $('.headerBox').find('button').removeClass('all_filled');
        }

        if (!CR.TagsFilled.run(showCheckingNotice)){
            all_fields_filled = false;
            $('.headerBox').find('button').removeClass('all_filled');
        }

        if (!CR.StoryFilled.run(showCheckingNotice)){
            all_fields_filled = false;
            $('.headerBox').find('button').removeClass('all_filled');
        }

        if (all_fields_filled === true){
            $('.headerBox').find('button').addClass('all_filled');
            return all_fields_filled;
        }
    }

    $('.uEditorToolbar').follow({top:$('.uEditorLi').offset().top,targetTop:44});
    $('.headerBox').follow({top:$('.headerBox').offset().top});

});
