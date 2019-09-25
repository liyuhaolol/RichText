package spa.lyh.cn.richtext;

public class StaticWeb {
    public static String webString = "\n" +
            "<!doctype html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<meta charset=\"UTF-8\">\n" +
            "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1\">\n" +
            "\t\n" +
            "\t<meta name=\"keywords\" content=\"巴西总统联合国演讲“各种怼”：“亚马孙是全人类遗产”是殖民主义论调 \" />\n" +
            "    <meta name=\"description\" content=\"巴西总统联合国演讲“各种怼”：“亚马孙是全人类遗产”是殖民主义论调 \" />\n" +
            "\t\n" +
            "\t<title>巴西总统联合国演讲“各种怼”：“亚马孙是全人类遗产”是殖民主义论调 </title>\n" +
            "     <!-- Link Swiper's CSS -->\n" +
            "    <link rel=\"stylesheet\" href=\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/css/swiper.min.css\">\n" +
            "    <!-- <link rel=\"stylesheet\" href=\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/css/wap.css\"> -->\n" +
            "    <script src=\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/js/jquery-1.8.0.min.js\"></script>\n" +
            "    <script src=\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/js/myjquery.js\"></script>\n" +
            "    <script src=\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/js/swiper.min.js\"></script>\n" +
            "\n" +
            "    <!-- Demo styles -->\n" +
            "    <style>\n" +
            "    html, body {\n" +
            "        position: relative;\n" +
            "        height: 100%;\n" +
            "    }\n" +
            "    .swiper-slide p span{\n" +
            "    \t/*margin-right: 0.1rem;*/\n" +
            "    \tpadding:0;\n" +
            "    }\n" +
            "    .swiper-slide p .text{\n" +
            "    \t/*padding-right:0.02rem;*/\n" +
            "    \tmargin-right: 0.02rem;\n" +
            "    }\n" +
            "    \n" +
            "    .mainContent img{\n" +
            "    \twidth: 100%;\n" +
            "    \tmax-width: 550px;\n" +
            "    \theight: auto;\n" +
            "    \tmargin: 0 auto;\n" +
            "    }\n" +
            "    .mainContent{\n" +
            "    \tfont-size:0.18rem;\n" +
            "    \tline-height: .27rem;\n" +
            "    }\n" +
            "\n" +
            "    /*add*/\n" +
            "    .downapp{\n" +
            "    \tbackground: rgba(0,0,0,0.4); \n" +
            "    \tpadding:0.1rem; \n" +
            "    \tposition:fixed; \n" +
            "    \twidth:100%; \n" +
            "    \tbottom:0; \n" +
            "    \toverflow:hidden;\n" +
            "    \t/*text-align: center;*/\n" +
            "    \tz-index:111;\n" +
            "    }\n" +
            "    .pr{\n" +
            "    \tposition:relative;\n" +
            "    }\n" +
            "    .pr a{\n" +
            "    \tcolor:white;\n" +
            "    \toutline: none;\n" +
            "    \tblr:expression(this.onFocus=this.blur());\n" +
            "    \ttext-decoration: none;\n" +
            "    \tfont-size: 0.2rem;\n" +
            "    \t/*display: inline-block;*/\n" +
            "    \tdisplay: block;\n" +
            "    \t/*width: 0.6rem;*/\n" +
            "    \t/*width:3.2rem;*/\n" +
            "    \twidth:95%;\n" +
            "    \theight:0.6rem;\n" +
            "    \t/*line-height: 0.35rem;\n" +
            "    \tbackground:#38f;*/\n" +
            "    \tborder-radius:0.06rem;\n" +
            "    }\n" +
            "    .pr a img{\n" +
            "    \tfloat:left;\n" +
            "    \twidth:0.8rem;\n" +
            "    \theight:0.8rem;\n" +
            "    }\n" +
            "    .pr span{\n" +
            "\t\tfloat:left;\n" +
            "\t\tmargin-top:0.2rem;\n" +
            "\t\tmargin-left:0.2rem;\n" +
            "    }\n" +
            "    .app_close{\n" +
            "    \twidth: 0.6rem;\n" +
            "\t\theight: 0.6rem;\n" +
            "\t\tright: 10px;\n" +
            "\t\ttop: -10px;\n" +
            "\t\tposition: absolute;\n" +
            "\t\tbackground: #000 url(\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/img/x.png\") no-repeat 23px 14px;\n" +
            "\t\tbackground-size: auto 30%;\n" +
            "\t\ttext-indent: -9999px;\n" +
            "\t\tborder-radius: 0 0 0 100%;\n" +
            "\t\tcursor: pointer;\n" +
            "\t\tz-index: 999;\n" +
            "    }\n" +
            "\n" +
            "\n" +
            "    \n" +
            "    </style>\n" +
            "    <script>\n" +
            "    $(document).ready(function(){\n" +
            "    \t$(\".mainContent p:has(img)\").css(\"text-align\",\"center\");\n" +
            "    \t$(\".mainContent p:has(img)\").css(\"text-indent\",\"0px\");\n" +
            "       // $(\".mainContent\").find(\"p\").not(':has(img)').css(\"border\",\"solid yellow\");\n" +
            "    //alert($.browser.chrome);\n" +
            "        //转换本地时间\n" +
            "        var timestamp = $(\"#span_localDate\").text();\n" +
            "\tvar localDate = new Date(parseInt(timestamp)).Format(\"yyyy-MM-dd hh:mm\");\n" +
            "        $(\"#span_localDate\").text(localDate);\n" +
            "        $(\"#span_localDate\").show();\n" +
            "        //转换本地时间结束\n" +
            "\n" +
            "\t    //夜间模式 add 20180409\n" +
            "\t    function getQueryVariable(variable){\n" +
            "\t       var query = window.location.search.substring(1);\n" +
            "\t       var vars = query.split(\"&\");\n" +
            "\t       for (var i=0;i<vars.length;i++) {\n" +
            "\t               var pair = vars[i].split(\"=\");\n" +
            "\t               if(pair[0] == variable){return pair[1];}\n" +
            "\t       }\n" +
            "\t       return(false);\n" +
            "\t    }\n" +
            "\t    function include_css(path){       \n" +
            "\t        var fileref=document.createElement(\"link\");   \n" +
            "\t        fileref.rel = \"stylesheet\";  \n" +
            "\t        fileref.type = \"text/css\";  \n" +
            "\t        fileref.href = path;   \n" +
            "\t        var head = document.getElementsByTagName('head')[0];\n" +
            "\t        head.appendChild(fileref);\n" +
            "\t    }\n" +
            "\n" +
            "\t    var res = getQueryVariable(\"night\");\n" +
            "\t    if(res==\"true\"){\n" +
            "\t        include_css(\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/css/wapn.css\");\n" +
            "\t    }else{\n" +
            "\t        include_css(\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/css/wap.css\");\n" +
            "\t    } \n" +
            "\n" +
            "\t    //图片点击放大效果\n" +
            "\t    var imgSrcs=[];\n" +
            "\t    $(\".mainContent img\").each(function(){\n" +
            "\t    \timgSrcs.push($(this).attr('src'));\t\n" +
            "\t    });\n" +
            "\n" +
            "\t    //判断客户端\n" +
            "\t    var u = navigator.userAgent; \n" +
            "\t    var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端 \n" +
            "\t    var isiOS = !!u.match(/\\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端\n" +
            "\t   \n" +
            "\t    //判断是否是app打开\n" +
            "\t    var isapp = getQueryVariable(\"closeAD\");\n" +
            "\n" +
            "\n" +
            "\t    if(isapp==\"true\"){\n" +
            "\t    \t//添加视频音频播放暂停\n" +
            "\t\t    var videos = document.getElementsByTagName('video');\n" +
            "\t\t    for (var i = 0; i < videos.length; i++) {\n" +
            "\t\t        videos[i].addEventListener('play', onPlay, false);\n" +
            "\t\t    }\n" +
            "\n" +
            "\t\t    var audios = document.getElementsByTagName('audio');\n" +
            "\t\t    for (var i = 0; i < audios.length; i++) {\n" +
            "\t\t        audios[i].addEventListener('play', onPlay, false);\n" +
            "\t\t    }\n" +
            "\n" +
            "\t    \tfunction onPlay() {\n" +
            "\t    \t\tif(isiOS){\n" +
            "\t    \t\t\twindow.webkit.messageHandlers.stopTTS.postMessage(\"\");\n" +
            "\t    \t\t}else if(isAndroid){\n" +
            "\t\t       \t\twindow.android.stopAudio();\n" +
            "\t\t    \t}\t\t        \n" +
            "\t\t    }\n" +
            "\n" +
            "\n" +
            "\t    \t$(\".downapp\").hide();\n" +
            "\t    \tif(isAndroid){\n" +
            "\t\t  \t\tpics = imgSrcs.join(\",\");\n" +
            "\t\t  \t\twindow.android.getPicUrl(pics);\n" +
            "\t\t  \t\t$(\".mainContent img\").on(\"click\",function(){\n" +
            "\t\t    \t\tvar clicksrc = $(this).attr(\"src\");\n" +
            "\t\t    \t\tfor(var i = 0; i < imgSrcs.length; i++) {\n" +
            "\t\t\t            if (imgSrcs[i] == clicksrc){\n" +
            "\t\t\t            \twindow.android.getPicIndex(i);\n" +
            "\t\t\t            \treturn i;\n" +
            "\t\t\t\t        }\t       \n" +
            "\t\t\t\t    }\t\t    \t\t    \t\n" +
            "\t\t\t    });\n" +
            "\t\t    }else if(isiOS){\n" +
            "\t\t    \twindow.webkit.messageHandlers.AddPicture.postMessage(imgSrcs);\n" +
            "\t\t    \t$(\".mainContent img\").on(\"click\",function(){\n" +
            "\t\t    \t\tvar clicksrc = $(this).attr(\"src\");\n" +
            "\t\t    \t\tfor(var i = 0; i < imgSrcs.length; i++) {\n" +
            "\t\t\t            if (imgSrcs[i] == clicksrc){\n" +
            "\t\t\t            \twindow.webkit.messageHandlers.testWS.postMessage(i);\n" +
            "\t\t\t            \treturn i;\n" +
            "\t\t\t\t        }\t       \n" +
            "\t\t\t\t    }\t\t    \t\t    \t\n" +
            "\t\t\t    });\n" +
            "\t\t    }\n" +
            "\t    }   \n" +
            "    });\n" +
            "  \n" +
            "    function phide(obj){\n" +
            "       $(obj).parent().children().children(\"div\").fadeToggle();\n" +
            "    }\n" +
            "    function stopaudio(){\n" +
            "    \tvar audio = document.getElementById(\"audio1\");\n" +
            "    \taudio.pause();\n" +
            "    }\n" +
            "    function stopvideo(){\n" +
            "    \tvar video = document.getElementById(\"video1\");\n" +
            "    \tvideo.pause();\n" +
            "    }\n" +
            "\n" +
            "    function closed(obj){\n" +
            "    \t$(obj).parent().parent().hide();\n" +
            "    }\n" +
            "\n" +
            "    function onPause() {\n" +
            "\t\tvar videos = document.getElementsByTagName('video');   \n" +
            "        for (var i = 0; i < videos.length; i++) {\n" +
            "     \t\tvar video = videos[i];\n" +
            "         \tvideo.pause();\n" +
            "        }   \n" +
            "        var audios = document.getElementsByTagName('audio');\n" +
            "        for (var i = 0; i < audios.length; i++) {\n" +
            "        \tvar audio = audios[i];\n" +
            "            audio.pause();\n" +
            "        }\n" +
            "\t}\t\n" +
            "\n" +
            "\n" +
            "Date.prototype.Format = function(fmt) {//author: liyuhao\n" +
            "\t\t\tvar o = {\n" +
            "\t\t\t\t\"M+\" : this.getMonth() + 1, \n" +
            "\t\t\t\t\"d+\" : this.getDate(), \n" +
            "\t\t\t\t\"h+\" : this.getHours(), \n" +
            "\t\t\t\t\"m+\" : this.getMinutes(), \n" +
            "\t\t\t\t\"s+\" : this.getSeconds(), \n" +
            "\t\t\t\t\"q+\" : Math.floor((this.getMonth() + 3) / 3),\n" +
            "\t\t\t\t\"S\" : this.getMilliseconds() };\n" +
            "\t\t\tif (/(y+)/.test(fmt))\n" +
            "\t\t\t\tfmt = fmt.replace(RegExp.$1, (this.getFullYear() + \"\").substr(4 - RegExp.$1.length));\n" +
            "\t\t\tfor (var k in o)\n" +
            "\t\t\tif (new RegExp(\"(\" + k + \")\").test(fmt))\n" +
            "\t\t\t\tfmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : ((\"00\" + o[k]).substr((\"\" + o[k]).length)));\n" +
            "\t\t\treturn fmt;\n" +
            "\t\t}\n" +
            "    </script>\n" +
            "</head>\n" +
            "<body>\n" +
            " <!--    <div class=\"wrap\"> -->\n" +
            "\t     <!-- 图文类型稿件-->\n" +
            "\t\t\t<div class=\"mod\">\n" +
            "\t\t\t\t<header class=\"landingHead\">\n" +
            "\t\t\t\t\t<h1 class=\"titleFont\">巴西总统联合国演讲“各种怼”：“亚马孙是全人类遗产”是殖民主义论调 </h1>\n" +
            "\t\t\t\t\t<div class=\"infoSet\">\n" +
            "\t\t\t\t\t\t<span class=\"afrSplit\">来源：南美侨报</span>\n" +
            "\t\t\t\t\t\t <span   id=\"span_localDate\" style=\"display:none;\"> \n" +
            "\t\t\t\t\t\t\t1569405540000 &nbsp\n" +
            "\t\t\t\t\t\t</span>\n" +
            "\t\t\t\t\t</div>                            \n" +
            "\t\t\t\t</header>\n" +
            "\t\t\t\t<div class=\"mainContent\">\n" +
            "\t\t\t\t\t\n" +
            "\t\t                <p>\n" +
            "\t\t\t              <p align=\"center\">\n" +
            "\t<img src=\"http://cms.jrlamei.com/jrlmCMS/nmqb_consult/u/cms/www/image/20190925/20190925065812_836.jpg\" alt=\"\" /> \n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t【南美侨报网编译王晗9月25日报道】第74届联合国大会一般性辩论24日在纽约联合国总部举办，巴西总统贾伊尔•波尔索纳罗（Jair \n" +
            "Bolsonaro）在联合国秘书长古特雷斯发表开幕讲话后首个发言。在约30分钟的演讲中，他谈到了环境问题，批判了部分国家，还谈到了现任政府为巴西重建所做的努力。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t<strong>谈环境——“‘亚马孙是全人类遗产’说法是谬论”</strong>\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t综合巴西国家通讯社、《圣保罗页报》报道，在演讲中，波尔索纳罗将大部分精力都用在谈环境问题上。但他的演讲被一些专家批判，称他失去了让国际消除对亚马孙担忧的机会。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t据悉，抵达纽约前，总统府的顾问曾讨论用更为温和的环境立场，以避免和国际领导人和联合国产生冲突。不过，波尔索纳罗采取的是另一种方式。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t“说亚马孙是全人类遗产是谬论，说它是森林之肺也是误解。正是这些谬论，让一些国家非但没有帮助我们，还利用媒体的谎言，表现出了卑劣的殖民主义。他们质疑的是我们最神圣的主权。”波尔索纳罗说。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t波尔索纳罗批判法国总统马克龙“在七国集团会上竟然提议对巴西进行制裁，甚至没有听取我们的意见”。“我感谢那些不同意实施这项荒谬提议的人”，并提到了美国总统特朗普。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t波尔索纳罗还多次批判本国和国际媒体，称他们破坏了巴西的国际形象。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t尽管他本人已经派出军队帮助灭火，但波尔索纳罗否认了最近亚马孙地区的大火。“我们希望每个人都能了解巴西，尤其是了解我们的亚马孙，它拥有广阔而自然的美景。它没有被烧毁，那是媒体的谎言。”他说。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t在巴西政府看来，其灭火行动已经取得了显著成效。根据巴西国家空间研究院（Inpe）的数据，8月份时监测亚马孙森林地区有30901个起火点，远高于去年同期（10421个）。但到9月份，这一数字降至17095个，低于去年9月的24803个。此外，根据巴西国防部23日公布的数据，在巴西政府开启“巴西绿色行动”（旨在减少亚马孙地区的火灾并打击环境犯罪）的一个月中，在亚马孙地区查处了112项违法行为，罚金总额3637万黑奥。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t<strong>谈政绩——凶杀案减少、毒品缉获量创纪录</strong>\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t在其接下来的演讲中，社会主义成为了波尔索纳罗的攻击对象。“在劳工党（PT）执政时期，巴西已经无限接近社会主义体制”，并称这导致巴西出现大量腐败、陷入严重经济衰退、犯罪率极高。随后，他又批判了古巴和委内瑞拉的“独裁政权”，并称赞了巴西1964年发生的军事政变。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t古巴外交部长布鲁诺•罗德里格斯在几分钟后就对讲话进行了回应，他在推特上称波尔索纳罗“精神错乱，渴望军事独裁”。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t波尔索纳罗重申他以最高标准捍卫人权和民主，并尊重言论、宗教和新闻自由。他还提到了巴西政府对犯罪和腐败的打击措施，称在现任巴西政府执政的前6个月，凶杀案数量就减少了20%，缉获的可卡因和其他毒品数量破纪录。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t<strong>谈经济——“正研究对中国和印度游客免签”</strong>\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t在经济方面，波尔索纳罗提到了巴西的外贸开放、特许权转让和私有化项目，“没有经济自由就不可能有政治自由”。他还将欧盟和南方共同市场（Mercosur）签署的自贸协定、巴西积极加入经济合作与发展组织（OECD）等作为经济方面的例子。“我们已经很先进，从金融监管到环境保护，都采用了全球最高标准。”他说。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\">\n" +
            "\t此外，波尔索纳罗还提到了巴西对美国、日本、澳大利亚和加拿大游客的免签措施，并提到正在研究对中国和印度游客免签。他邀请在场所有人去巴西和亚马孙地区旅游，“和报纸和电视上所说的有很大不同”。\n" +
            "</p>\n" +
            "<p style=\"text-indent:2em;\" align=\"right\">\n" +
            "\t（编辑：宣萱）\n" +
            "</p>  \n" +
            "\t\t                </p>\n" +
            "\t\t\t\t\n" +
            "\t\t\t\t\t<div class=\"contentImg\" > \t\t\n" +
            "\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t<p></p>\n" +
            "\t\t\t\t\t<p></p>\n" +
            "\t\t\t\t</div>\n" +
            "\t\t\t</div>\n" +
            "\t\t\n" +
            "\t\t <!-- 视频类型稿件-->\n" +
            "\t\t\n" +
            "                <script>\n" +
            "                       var vi = document.getElementById(\"video1\")\n" +
            "                       vi.addEventListener('webkitendfullscreen',function () {\n" +
            "                            window.webkit.messageHandlers.webVideoEndFullScreen.postMessage(\"\");\n" +
            "                       },false);\n" +
            "               </script>\n" +
            "\n" +
            "\t\t <!-- 音频类型稿件-->\n" +
            "\t\t\n" +
            "\t\t <!-- 图集类型稿件-->\n" +
            "\t\t<!-- add下载app -->\n" +
            "        <div class=\"downapp\" style=\"display:none;\">\n" +
            "        \t<div class=\"pr\">\n" +
            "        \t\t<a><img src=\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/img/waplogo.png\"><span>下载今日拉美客户端</span></a>\n" +
            "        \t\t<div class=\"app_close\" onclick=\"closed(this);\">关闭</div>\n" +
            "        \t</div>\n" +
            "        </div>\n" +
            "\t\t<!-- Swiper JS -->\n" +
            "\t\t<script src=\"http://cms.jrlamei.com/jrlmCMS/r/cms/www/tpl_basecms/js/swiper.min.js\"></script>\n" +
            "\n" +
            "\t\t<!-- Initialize Swiper -->\n" +
            "\t\t<script>\n" +
            "\t\tvar swiper = new Swiper('.swiper-container', {        \n" +
            "\t\t\tpaginationClickable: true\n" +
            "\t\t});\n" +
            "\t\t</script>\n" +
            "\n" +
            "\t\t\n" +
            "\t\t\n" +
            "\t\t\n" +
            "   <!--  </div> -->\n" +
            "</body>\n" +
            "</html>";
}
