<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="Refresh" content="10; url=/essay/"/>
    <title>404页面</title>
    <meta name="keywords" content="创作共享"/>
    <meta name="description" content="创作共享"/>
    <link href="${APP_PATH}/images/favicon.ico" rel="SHORTCUT ICON">
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/lib.6f910717.bak.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/commons-css/nav-menus.css"/>
    <style>
        #header {
            margin-bottom: 0;
        }
        .pg-center {
            margin: 0 auto;
            height: 465px;
            background-image: url(/images/404.jpg);
            background-position: center;
            background-repeat: no-repeat;
        }
        .pg-content {
            margin-left: 148px;
            margin-top: 20px;
            padding-bottom: 80px;
        }
        .pg-content span {
            display: block;
            color: #3b3b3b;
            padding-bottom: 13px;
            font-family: "\9ED1\4F53";
            font-size: 20px;
        }
    </style>
    <script src="${APP_PATH}/commons/custom/lib.bundle.a6ecd17d.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="${APP_PATH}/template/common-nav.jsp"></jsp:include>
<div id="content">
    <div class="pg-center"></div>
    <div class="pg-content">
        <span>此页面已无法找到,可能已经被删除或者地址错误</span>
        <span>友情建议:您可以选择去逛一逛其他地方</span>
        <div class="pg-backhome">跳转至首页</div>
    </div>
</div>
<div id="win-house" class="h0">
</div>
<div id="foot-forms" class="dn">
</div>
</body>
</html>