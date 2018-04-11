<%--
  Created by IntelliJ IDEA.
  User: zc
  Date: 2017/12/27
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>您所访问的资源不存在！</title>
    <meta name="author" content="zc">
    <meta name="copyright" content="Copyright   zc 版权所有">
    <style>
        #errorpage{width:600px;text-align: center;padding: 80px 0;margin:0 auto;height:360px;}
        #errorpage .pinknum{color: #fe3a3b;}
        #errorpage p{font-size: 18px;font-weight: bold;padding-top: 30px;}
        #errorpage .greyspan{color: #999;}
        #errorpage i{font-size: 72px;color: #ccc;}
        #errorpage .errorsug{margin: 12px auto 62px;text-align: left;display: inline-block;*display: inline;}
        #errorpage .errorsug p{font-size: 14px;padding-top: 6px;text-indent: 15px;}
        #errorpage .bt a{background: #fe3a3b;padding: 9px 46px 11px;*padding: 7px 24px 9px;color: #fff;border: 0;font-size: 14px;}

        #errorpage .tfans_error .tfans{float: left;}
        #errorpage .tfans_error .errortans{margin: 0;text-align: left;float: left;z-index: 5;height: 300px;position: relative;padding: 80px 0 0 24px;}
        #errorpage .tfans_error .errortans .ter{position: absolute; left: 155px; top: 10px; z-index: 3; }
        #errorpage .tfans_error .errortans p{font-weight: normal;z-index: 10;position: relative;}
        #errorpage .tfans_error .errortans p b{font-size: 38px; }
        #errorpage .tfans_error .errortans div{margin-top: 30px; }
        #errorpage .tfans_error .errortans div button{font-size: 17px; padding: 3px 42px 5px; border-radius: 3px; }

        #errorpage .logo{display: inline-block;float: left;height:303px; width:256px;background: url(${ctx}/images/tfans.jpg);}
        #errorpage .info{display: inline-block;float: left;position: relative;}
        #errorpage .e404{display: inline-block;position:absolute;top: -60px;left: 145px;;height:164px; width:150px;background: url(${ctx}/images/404.jpg);}
        #errorpage .lh{height:90px;}
        #errorpage .err{font-size: 36px;}
        #errorpage a {text-decoration: none;}


    </style>

</head>

<body>
<div id="errorpage">
    <div class="tfans_error">
        <div class="logo"></div>
        <div class="errortans clearfix">
            <div class="e404"></div>
            <p><b>出错啦！</b></p>
            <p>您访问的页面不存在</p>
            <%--<div class="bt" ><a href="#">返回首页</a></div>--%>
            <div class="bt" ><a href="javascript:history.go(-1);">&#9666;返回上一页</a></div>
        </div>
    </div>
</div>
<!-- xmoban.cn 提示文本 实际使用请删除 -->
<div style="padding:20px 0;margin-top:30px;">

    <!--
    <div style="margin-bottom:30px;text-align:center;"><a href="http://www.xmoban.cn/">X模版</a> | <a href="http://www.xmoban.cn/404-Template">404页面模版</a> | <a href="http://www.xmoban.cn/management-Template">管理后台模版</a> | <a href="http://www.xmoban.cn/Package">打包下载</a> | <a href="http://www.xmoban.cn/Custom-design">定制设计</a></div>
    </div>
    -->

    <!-- /xmoban.cn -->
</body>
</html>
