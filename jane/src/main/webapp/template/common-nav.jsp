<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<style type="text/css">
    #header {
        font-family: tahoma, arial, sans-serif !important;
        font-weight: 400;
        margin-bottom: 0px;
    }
    <!--
    写作按钮的字体位置调整
    -- >
    .btn-decoration, .btn-decoration:visited, .btn-decoration:active {
        padding-top: 4px !important;
    }
    #dt-search {
        float: left;
        margin-left: 36px;
        margin-top: 16px;
        border: 1px solid #ff7e7e;
        border-radius: 20px;
        position: relative;
        z-index: 900;
    }
    #dt-search form {
        position: relative;
        background-color: #fff;
        width: 262px;
        height: 30px;
        border-radius: 20px;
    }
    #dt-search form input {
        padding: 0 4px 0 10px;
        width: 220px;
        height: 30px;
        line-height: 30px;
        border: 0 none;
        border-radius: 20px;
    }
    #dt-search form button {
        position: absolute;
        top: 0;
        right: -1px;
        width: 42px;
        height: 30px;
        outline: 0;
        border: 0 none;
        background-color: #ff7e7e;
        background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAAB4CAYAAAC3kr3rAAAAAXNSR0IArs4c6QAAFV5JREFUeAHtXQmUFNW5vr0MM4MsGZRtBjAIAyKLJm4xigtEeSiIqAxCDohAQiAvhOeLgiHIzCAiIe+ZQ84zgaOIoibgGjN6InFBJPFgIokjizookVXwxQ0ZRma6K99X1cXU9PRS3VW9zv+f83fduut/v77/3erWX0oJCQKCgCAgCAgCgoAgIAgIAoKAICAICAKCgCAgCAgCgoAgIAgIAoKAICAICAKCQJtDwNPmatyGK6xpmgekZQMEkKUn5LgcXBaS5wCumyDfodB9Vly8WSFFnguBxuAFXwQeDx6Qieqi3EEo979xHZaJ8s0yUX4BeBnud4CvB1NRyHTvYBi4HdxZQf6skCL/hRiJKl4cquYwNIB16Ck/SHO1T0F5HcDXo/zOKP+1NJevUG43lHkY/EdwH8jwpVUGhFO+h8B/h/sKhB+xhmfCLSNIilHHH80Rw1QOlsZpLRtpR96kklBGIdj8j63ljYT/BSwb1xKwOc1JmTgog6PCK+Afo+GPDlcOFkw/8A1wrgIfRpoC+meSTPAcyYCKjCA7yiQPEwOTwahWRYSqsaecjvDTIoS54oW82VvPBl8RyrBPWMajEWcI/MaBvwt3l7Bwt2+rkOE7UICV8TIOxeEoUx0vbqrD2Zs5JoD7BTNBxTo5zizHMwAWxLQ3+NvgMy3VOQvu4eCXwLtD/gFcXwdvA3afhPwcXyADp1P/CS4Gc1G+D0wFuQa8CxxpevcR/FdBDtcX8ZCHawyuOVpNq+AXkZCGnche8GDIlLGFuysjCCrB4ds6hOO27RH+1NNR6x+Bp4OtytED99eBeeUU4lQwyQe+BDwXaaeC29PTBRqFPKgcJCrsGbpLqYG4TgZz2sey2QhNomwc8VJBlyHTl9HQW6w5YhUUisvO5PJY8VId5paCpFRO7a67TtcqK4ucFrJgwYKvb9iwgQ2jFc2fP7/PqlWrnM55xyNj61SFjZQjyTSwmTfrMQPMNUAh2CQ2YsZ1RKGed6glE7p/DL4QzE6M9ee0bxL4FrAVV8ZJBXGNszeJjJkm5eujWHJlvYJo1dXDVWNjLVaTz7mgJIu2bdv2aLiSQDkuQY/1tz179vSOBZaNMLPXZtSu4P8CXwm2KgJu9d59NK7zwGy0JkVUXjPQ5pUjlzl1/hrcY8EcKf4DbBLL6QemMg83PXHtBQWz1sES1DadCSsIAOSCvNLKJnRWv5B7hBmWzFWrqhqpmpqexOLmBvAhFQw+BSVJeo+8tLR0DuTqZFUSKgdke9Lr9U665557Is3NExF9qyUy1wHmqGHxbuFkXcyt9ga4relbREzghvN9k86GI54MjGMSFcua3vR3ej2ADMI3CezkyTRMmzEyexrbAqCBUeBSmwkOomdOaoiEIlyNUeNBKoensnKLxqnRjh2/Q7l++E2AX5NNGVpEW7lyZeGBAweehlzcWPgN6rPe5/NNvvvuuznfdUTIi419DticZnG+Xx4j080IeyUUTpneihHXVhBkYJlcY5BuAnPdEY/uRQTiQXoKctQaTnd+IVObWqRPAWxVYWwiGe7PuAkTlGMARos1UISxVA5m4KmoCKjS0slQGk4PfplwpqEEc+fO/aqsrIxPtLnj9pxbysHs0bCotJvoDtGfTUeEK+P+JeR/yA3lCOVlnabZ3ZEKWuRLeFZhSRvRibodQsAq8OMRI0T2fIhpQmkjx0iDb8IjSCSZ0Nj0PwKVcSc/jhY7d5ZAOf4/vDwNI4D67LP+njvv5LZh0lSJqVpDQ0MvF6ZVLWQAFBxFbgNz3cHG9jNwJFzYaFaDSc8DujcMp7NflD8OOXwjlMsluI6Mk+PnCLd2OA9DFqdTzVZFQq4CeJ4A80HhylYRLB6IOxe3s8DfQFymyRhF+uMSFgYVclVBEhYgyxIAjqkQ6YyQWPNxte4UmdLug2NN6Ma1nhJlD0Oe14fy5bbxbLB1OzcUdPJSA9ebobtGXH+ORsmr6wTZ+PCSU8p3wDejnBbbvginnBxluKHALeddiGN3FER098lcILqfc9vO8VNL9dkguA75EMwGwaldb/DfwSaZ83/z3sn1XSQ+BuYmQT2YDW4COFxJ2PC4KWAqB5zq7VQpBzNH3kegBBzdqsB74X6ZVzCpD3gEmFOxa8G/AXNXbSzSZWwUcWsE0f9gVIR/fpsn/KnsAb+VABC/AHYtetME0raKivK/CU82MpM43eNzl1JwMfgw+G3wfrBJDXDcBzncVFYz71ZXyMiF+2VgcxPnANyvonxOPbHU1NeaG+AMgG+Cf5D+6Sa3FISazx6CPUKbJ/y57CW5FrBDbJgrgB0bgmsEGa5GZlQKO8QNg0chwx47kdMVB3XgNvgfwe9Bth+kq1xrOa4oiDVDceu9nxc4fAfcD/wxeDeYGw5fgbkuYK/ZH8yF6yb8+e/j6jqhgX0bmbLzijWV5nTwCcjAHjzrCHXg1JDT1I2QcWG6BRQFSTfiaS4PDYzTXo4kA8FdwNwGpqJSIbgT+A80PFdHL+TpKqEO3OSYBH4Lsm5zNXPJTBCwIoDGxlFLSBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQSAaAnLUJBoyUfy1JUt4CHAtDEl01aMUFPCs1TTPokXPR0mS0954u3MZTqHOw/HaX+IFtjtyujIifOoRgIIc0WprNe3YMYPphl/qS85MCVCQRm3/fpjpqEzJS1SZqZX9UhMeQVr1oPbLMmIm2eNmTbl+HIy97jqc0+VBXdD7OIj7zDMK1leM+yTrZyTOnl9t6dKeKhCohkQzlReHk4N4HUPTVqiioiWe+fOPZo+kqZUk1jHoaCWvVePGdT3ZQKLFiub//vtd1e9/vxbB3aJFieKfHeV+8AHeUMArCkdDbaQjzFqNH48XbM8wxE6+fkqj4bpDhx5GgxwFhSuJgkNLb7//UzTeF1TPnlM9s2a50svrnVEg8Ft14YXFaiAOAXfurNS//qVUbe2P1PbtN8NW2bWwCcC3EfOeElcQzr3N3jMZeJjWnL8nkj5byqUizJkTXfJk68ccP/poKeb7E9Wll3rU+edHL8Ma8te/lqhXX52ItPvgfbs1KBk3rFiWYaR4VE2e3AlK15wF3T17FuG/L0IH94y2fPmAtjCSYOx0QJs3K3XvvUrxKuQcAY9nppo40aPexGvir70WPz/GYVymYVo3qKnppxg5OrRQDmu+/fvDnMLgr6njxxdYvfPVnfgIYkWCf84JvE/P66WXWkPS6169Gqaiz1Tqoovwjl4KX3dgOZ/yBbwIVIIZ0fe/HyEgAS9Oq3r3VmrqVNh6fNIo65pr8IqTr2UmAbzf9Dw2zT77zIjbHi8p2p2Stcyp9Z3ff5UqL4/dLoYMKVK7dl2FxGl/w6+1wKn1iQ1EvLLPPddQDl4zSWy0r7+O9+PwgtzIkbArOCA10jhVALtSscFPnqzUs8/CchaUcsYMpdrx9WwQO6QHHlCqe3cjTrjyGLGS+g1ZrzxDdTV2sKNm0g3Lx0BgaNTwPApwpiAcNTI5coT/EV/AIMfTTxsKwoVzLhN3jlif007DR8kewpc9MJKQOHLQj5sEjOMm1dV1gyI2YLoGDY1BVNZAoDBGjLwJcqYgsWA4dgyGNf9ibIPSXYTXinv0wNcxboiVKrvDUj3Fstae2BXDQs+ECcbI+MILRiinkYMHK7V+vYHvxRdbUzlzBwI9VIcO9nbCvN4mWrn0wJSrs0KzO7UzBTmA9/657UkF4FDPoblXL6U++UQp/qH19c21/xJmn3bTuEcKqRPsE+TDFOswzFZtg22CW24xwKJCkK3EEeXBB43nMex43CCPp7fq2FGzlVVBwQmMcBjKMmt93ZasDiIlryA1NUbP5qBw15JygZyORbprAsfIiA8cufa48krYQgw3hmhJxzDG+cMfmhXJEpyUMxD4JjYJYhRqybWsrEl9+OHl8HnU4pt3zuQVhAvibKF0LZ7Dp1hu7FxZMeRDvz/9qUSfilLh4xHj1NUppIHlK6R1Sj7fcGzv2msT5eWd1N69Y1CkKIhT3PMmfaoVUdM2Yidugpo2zf7qm2uStWuDwHijY5w17TxdOe1k1LcvY11lJ2oux7HXW1hryLNGPE4xn0bLkyCeXTLOKyWW2Cw32af4yZabmJTOYvfoMQVPxPdi12qm7ecaxshxPxr2QmeF66kbUH4nxYeB8YhHT/D0JV60XA9PXEFwtFs/S5XMcRGiFTrMlwRwmSo3CVGTSxI6S3U7UpPTT5pmYNzU1C1u4X7/EWwHh3YR4saWCPmKAI+ytzjebh5zj3bN8+Pv+fo/R6tXMiNItLzy1T+xkSv5ETLr8NPuvPM9CFVuEazOU109wHIvTkFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQMBDwuAEELO0NxvFsWHAA+f2bYXVvB2y53oS7s8A7YfT4dwzKN4pU73TVkeekMnEuKlPlpgvX8HIcKwgs8X0XpmgeUUOGGC+g79xZBGsbdVCYgbBTdUK99VYQlhT/Buvnw8MLz+X7KPWegs7hsVTWC6eLB8HU6ABYFXkAdgBmAOv3gO2uVJWpl9e5861q5swXcbzdr5Yte0TdccdMyOBX9903HvYIFqAD/Eeqys90vo4URO9Bg8FaGDrz6naaWBsaHFi7Vqnp0w0jDjR6vGIFTdRMcjqS6LZrDfOcib1QpGn6C0Wu2a7liBmt3n7/EI6gbv6x2uLFL6FxLsW7NFNwvRHGMQIwjlGs9u8/rj7+2AdToU+gE/otrvM9VVUj3Spbq6oaC0V8VlVUaKpvX6OtLF+uTr4s9847Gt4N8kBRr/IsXoz3fvOPnB13DwaHq0GDGqAczXaUaNBs6FANf55Ht3JC200cSbZu5XTLGVE5ysp+qMaMaQ/rG/byOnq0RNXU/FDRAotbLyJFqzdH0e3bOdV0VUGgFMuhkC+pwsKAmjXLZ7GH1Q7+CvWbCEuH0+DvnnJUV1+M/NbrVh67dYvckZ55pkd16ULrKhsxpb4MHeBme39K7sSy/+5zInUKBDz6H8c0/AM5zcJaJJEsIsal/dlElIOZUJGYxi3btREFS7FnQcEkdETH1ezZVuUwCmUHdO21xapTp4A+wrglit+/Uo0eXaxoRTEWMXzsWL4pem+saLka5kxBvN7XYGSgvT6tMhHgFItD7+bNjerxx5v06RXXIG4s1Gl/1u7IYcrDK9O4ZbuW+UWrN9df2KRgFLdIXwNwWjVmTPHJPPk++CuvKHXw4EkvfWRBPD1+s29SLkydz0eD76ebUgrPgZZcwuksTA4KC/thFLkgPCjX7x0piD7XLiy8WT38cBB8QmeuP2hUrLw8CGuKQdh2qscc9UPd7muuoxWSX693QcEPWtXb653t9voDa4Byfc1hmhmlUtx/v4J1daXWrTO+20G5GM61CRfwTikYHAjzP5HbRjTLLt27e1G29e1Dp1JkRfrIINgUDTs5vbEwrMYHVo7pc9EuXXzq1FM1DPeF6oILCjH0tsO0oD3+uBsxqrxoM1t70Z54QimySfHuzXguXNFTzkE2/6NKSo6hvirERzGN+99QmAul4INOfOU1GFyjL8jNHN99l2s8pa6+2rjW1pohtGpZzN2t0Kuyzf6Ju/pjatU8YtlJ3717MZRUFMTECg1hGLZ396oRI/rA7H9HTAHagX3YDvSo884zzGKaBpYrKgqhSMP1odvMIEevqMMuNNr/Q51PQV07wqh0O53ppl9JyQrs/sCam3PSn3N4vdP13Sozu2HDlHr7bcOINa/8ApRJ3NXC1q/j5yPB4GGYFU3M5u7Ro4x/xBQlX65JjSD6dqvf/xQaRlCdfXbrHQ7+iaNGGQaWuUjnd/369atHwxrkGnA33qgU2aR492Y8B1cox08xUvZRt98e2SwozYHOmNEevXh/Pa6Dsk4m9fnq9K1c4kjiiDVlimHYeuZMpUpLDX+Gc8sXz0UMDwe/fv8W2D6zZ6PXLGb3bk1fm5n3eXJNSkHwHb1zsbY4FQ8Ho6c/5xyuRfhZMQOqkpIiOL6eq7hh8dsXU6iF+G4Hd8SiV4Nh8+YpxtXTRI9pK0R/CMjnHKtWBU4moFJccYWhLKZnTc1xPg9x5aHhokXboeR1+DBSc5lmOZGujMf4TJdnFL2Bx67oOVjEtYsdBaFdu2pqy5YgvqHH5yAF6GFeiJsmVgRaETQ/nhkrXngY0zi1XdvYOAKjYBN2a8Jzb33POIzLNG5QY+M6THl8MGp9HKNwyxx5/+tfB/AcpFh/WNgyNKk7j8ejYfpcoV580YdRKXYeDN+0qZHx9XSxY+dcaLIK0gs7VL64tfV6A+qf/9yo3nhjKZSjN3Z4tsZNEysCn4jX1NQnpCRUDqZhWmfUC9Ob9razMOL2sh0/VkRNWwj8RuFTE+vVr371pXrssc+xjX5Cv/L+q6/WIXwk6pikPdjWhWNbfjdmAGOxU9cQdSThyLFmDUfLCXr81tnkvE+yT9LXALSF+MDLCfSoxkjCT4ORzE+F1dc34gFhAUCeh2EfWy8uEO3P8on46tWRj5oUFATUrbf60JvxuEs9vifYXh85QkdNHEpQj6klF6L2MNuzpwlx8RFB52Q5PrIR07afA4NytW/fGijFdCzK6yzTqpedl9acA/KtwWbMUMwCNuATd+UYFT14plSEDqpBX6NwWuX1ViDe7uZU+eWKMZmOXVFs8Z6Oh28/gQJwJOGBRHwvTHlwj6dyyot7zl8Xo2f5BNe0EBbGX2Jb+RT13HP1MM3/GEas77lVcOgb5l/gTFIjdqoKUU/WMQhlpCJ40DH4TvodPNiEh3g8DtPBc9ttx9ySwZpPOk/VaprmUUuWDMH/fQkUojumeYfR8WzhmiMfp1VWnJNWEGsm2eJG7/om9u+HYmNgK6ydj3DrcKJZP23ZshJMZ25AA+mMhoIdCHUCbjyxA3m9fG7As1GNcH8O9yPoHBoYJJS7COSXglRW3orGOQbTvnFt4SP3udvsRHJBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBAQBQUAQEAQEAUFAEBAEBAFBQBAQBNKLwL8Bnvo3OYXyzIYAAAAASUVORK5CYII=);
        background-position: -143px -3px;
        border-radius: 0 20px 20px 0;
        cursor: pointer;
    }
    #compose {
        margin-left: 60px;
    }
    #login {
        font-size: 16px;
    }
</style>
<div id="header">
    <div style="width: 100%; height: 65px;">
        <div class="pnav-header SG-posfollow"
             style="position: fixed; bottom: auto; z-index: 998; width: 100%; height: 65px; left: 0px; right: auto; top: 0px;">
            <div class="SG-sidecont">
                <div id="header-wrap">
                    <div id="dt-header">
                        <div class="dt-wrap">
                            <a id="dt-logo" href="/essay/">创作共享</a>
                            <div class="menu">
                                <div class="cover">
                                    <a href="/essay/" class="nounderline">首页</a>
                                </div>
                            </div>
                            <div class="menu">
                                <div class="cover">
                                    <a href="${APP_PATH}/search/category?category=安妮陈" class="nounderline">商店</a>
                                </div>
                            </div>
                            <div class="menu">
                                <div class="cover">
                                    <a href="/recruit/events" class="nounderline">征文</a>
                                </div>
                            </div>
                            <%--
                                <div class="menu">
                                <div class="cover">
                                    <a href="/post/pub_shop" class="nounderline">发布商品</a>
                                </div>
                            </div>--%>
                            <div id="dt-nav" class="menu">
                                <div id="dt-nav-btn-cover"></div>
                                <div id="dt-nav-btn">
                                    分类
                                    <i></i>
                                </div>
                                <div id="dt-nav-content-cover"></div>
                                <div id="dt-nav-content" class="clr">
                                    <div id="dt-nav-right">
                                        <div id="dt-nav-right-inner">
                                            <div class="dt-nav-group">
                                                <a href="/category/post?category=效率笔记">效率笔记</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=美食菜谱">美食菜谱</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=信息技术">信息技术</a>
                                            </div>
                                            <div class="dt-nav-group">
                                                <a href="/category/post?category=美人说">美人说</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=美妆·护肤·穿搭">美妆·护肤·穿搭</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=情感">情感</a>
                                            </div>
                                            <div class="dt-nav-group">
                                                <a href="/category/post?category=慧生活">慧生活</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=海外党">海外党</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=好书推荐">好书推荐</a>
                                            </div>
                                            <div class="dt-nav-group">
                                                <a href="/category/post?category=撩汉">撩汉</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=旅行·在路上">旅行·在路上</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=音乐">音乐</a>
                                            </div>
                                            <div class="dt-nav-group">
                                                <a href="/category/post?category=影视">影视</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=大学那些事">大学那些事</a>
                                                <div class="dt-nav-vline"></div>
                                                <a href="/category/post?category=生活小妙招">生活小妙招</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="dt-nav-neck"></div>
                            </div>
                            <div id="dt-search" class="menu">
                                <form action="/search/">
                                    <input class="ipt" id="kw" autocomplete="off" name="keyword" placeholder="搜索感兴趣的内容"
                                           type="text"/>
                                    <input id="type" name="type" value="feed" type="hidden"/>
                                    <button type="submit">搜索</button>
                                </form>
                                <div id="dt-search-list">
                                    <div class="dt-search-line hover">
                                        搜索含
                                        <span class="red"></span> 的文章
                                    </div>
                                    <div class="dt-search-line">
                                        搜索含
                                        <span class="red"></span> 的商品
                                    </div>
                                    <div class="dt-search-line">
                                        搜索在
                                        <span class="red"></span> 场景下相关的商品
                                    </div>

                                </div>
                            </div>

                            <div class="menu" id="compose">
                                <div class="cover">
                                    <a href="javascript:void(null)" class="nounderline  btn-decoration" id="pub">写文章</a>
                                </div>
                            </div>
                            <div id="dt-header-right">

                                <div id="dt-account" class="dt-has-menu dt-head-cat">
                                    <a class="dt-account-btn" id="login" href="/users/login"><span>登录/注册</span></a>
                                    <a class="dt-account-btn" id="login-done"
                                       style="display: none"><img class="dt-avatar"/><span>我的创作</span><i></i></a>
                                        <div class="dt-menu" id="popSelect">
                                            <div class="dt-menu-inner dt-menu-mini">
                                                <a id="mynavtools-home" href="/user/member"> <i></i> 个人主页 </a>
                                                <a id="mynavtools-setting" href="/user/memberinfo"> <i></i> 账号设置
                                                </a>

                                                <div class="dt-menu-bottom">
                                                    <a id="mynavtools-logout" href="javascript:void(null)"> <i></i> 退出 </a>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                                <div class="dt-vline"></div>
                                <div id="dt-add" class="dt-has-menu dt-head-cat">
                                    <a class="dt-add-btn" href="javascript:;">发布</a>
                                    <div class="dt-menu">
                                        <div class="dt-menu-inner">
                                           <%-- <a id="mynavtools-local" href="javascript:;"> <i></i> 上传图片 </a>
                                            <a id="mynavtools-src" href="zhuaqu.html"> <i></i> 抓取网页图片 </a>--%>
                                            <a id="mynavtools-create"> <i></i> 发布商品</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="dt-header-btm">
                        <input type="hidden" value="" id="jane_id">
                        <input type="hidden" value="" id="jane_name">
                        <input type="hidden" value="" id="jane_background_cover">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${APP_PATH}/commons/jquery/jquery.min.js"></script>
<script src="${APP_PATH}/commons/cookie/jquery.cookie.js"></script>
<script src="${APP_PATH}/commons/custom/commons.js"></script>
<script type="text/javascript">
    $(function () {
        $("#dt-search form button[type=submit]").click(function () {
            $("#dt-search form").attr('action', $("#dt-search form").attr('action')+$("input#type").val())
            $(this).submit()
        })
        $("#pub").click(function () {
            var id=$("#jane_id").val()
            if(id){
                window.location.href="/post/pub/"+id;
            }else{
                alert("请先登录!!!")
            }
        })
        $("#mynavtools-create").click(function () {
            var id=$("#jane_id").val()
            if(id){
                window.location.href="/pub/item/"+id;
            }else{
                alert("请先登录!!!")
            }
        })
    })
</script>

