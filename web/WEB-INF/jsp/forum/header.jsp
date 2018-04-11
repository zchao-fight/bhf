﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%
	Enumeration enumeration = request.getAttributeNames();

	while (enumeration.hasMoreElements()) {
		String name = (String) enumeration.nextElement();
		Object obj = request.getAttribute(name);
		System.out.println("request[\"" + name + "\"]: " + obj);
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${ title }</title>
<link href="${ctx}/css/style.css" rel="stylesheet" />
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/jquery.SuperSlide.js"></script>
<script src="${ctx}/js/dropdown.js"></script>
<style type="text/css">
	body {
		font-family: Tahoma;
		font-size: 12px;
		/* background: #e1d5aa url(/Forum/images/bg1.jpg) top center repeat-y; */
		background:  url(${pageContext.request.contextPath}/images/forum/images/bg.jpg) top fixed ;
		margin: auto;
		
	}
	
	h1, h2, h3, h4, h5, h6, form, body {
		padding: 0;
		margin: 0
	}
	
	td, th, div {
		word-break: break-all;		/* 允许单词内换行 */
		word-wrap: break-word		/* 如果该行末端宽度不够显示整个单词，它会自动把整个单词放到下一行 */
	}
	
	table {
		empty-cells: show;			/* 在空单元格周围绘制边框 */
	}
	
	
	
	
	.nav {
  height: 46px;
  line-height: 46px;
  background: #fff;
  margin-bottom: 20px;
}
.nav li {
  float: left;
  margin-right: 20px;
}

ol, ul, li {
  list-style: none;
}
.nav li a {
  display: block;
  width: 140px;
  text-align: center;
  font-size: 16px;
}
.nav .active {
  background: #5dcfff;
}
.nav .active a {
  color: #fff;
}

.nav .active a:hover {
  color: #fff;
}

.nav ul li a:hover {
	color:#5dcfff;
}


@charset "UTF-8";
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td, hr, button, article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section {
  margin: 0;
  padding: 0;
}

h1, h2, h3, h4, h5, h6 {
  font-size: 100%;
  font-weight: 400;
}

address, caption, cite, code, dfn, em, th, var {
  font-style: normal;
  font-weight: 400;
}

ol, ul, li {
  list-style: none;
}

a {
  text-decoration: none;
  color: #37393b;
  background-color: transparent;
  -webkit-text-decoration-skip: objects;
}

a:hover {
  text-decoration: none;
  
}

a:active {
  outline-width: 0;
}


fieldset, img {
  border: 0;
}

html {
  color: #37393b;
  background: #fff;
  -webkit-text-size-adjust: 100%;
  -ms-text-size-adjust: 100%;
}

article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section {
  display: block;
}

audio, canvas, video {
  display: inline-block;
  *display: inline;
  *zoom: 1;
}

body, button, input, select, textarea {
  font: 14px tahoma, "Hiragino Sans GB", "microsoft yahei", sans-serif;
  line-height: 1.5;
}

button, input, select, textarea {
  font-size: 100%;
}

button, input[type=button], input[type=reset], input[type=submit] {
  cursor: pointer;
  -webkit-appearance: button;
}

button::-moz-focus-inner,
[type="button"]::-moz-focus-inner,
[type="reset"]::-moz-focus-inner,
[type="submit"]::-moz-focus-inner {
  border-style: none;
  padding: 0;
}

button:-moz-focusring,
[type="button"]:-moz-focusring,
[type="reset"]:-moz-focusring,
[type="submit"]:-moz-focusring {
  outline: 1px dotted ButtonText;
}

abbr[title] {
  border-bottom: none;
  text-decoration: underline;
  text-decoration: underline dotted;
}

b,
strong {
  font-weight: bolder;
}

del {
  text-decoration: line-through;
}

mark {
  background: #ff0;
  color: #000;
}

small {
  font-size: 80%;
}

audio,
video {
  display: inline-block;
}

img {
  border-style: none;
}

svg:not(:root) {
  overflow: hidden;
}

table {
  
  border-spacing: 0;
}

th {
  text-align: inherit;
}

td {
  word-break: break-all;
  word-wrap: break-word;
}

textarea {
  resize: none;
}

iframe {
  display: block;
}

/*float*/
.clearfix {
  *zoom: 1;
}
.clearfix:before, .clearfix:after {
  content: "";
  display: table;
}
.clearfix:after {
  clear: both;
  overflow: hidden;
}

.clear {
  clear: both;
}

* {
  box-sizing: border-box;
}



.hide {
  display: none !important;
}



/*搜索*/
.search {
  width: 420px;
  border: 2px solid rgba(33, 40, 46, 0.2);
  *zoom: 1;
}
.search:before, .search:after {
  content: "";
  display: table;
}
.search:after {
  clear: both;
  overflow: hidden;
}
.search .s-inp {
  float: left;
  width: 316px;
  background: #fff;
  border-color: #fff;
  border-radius: 0;
  padding: 5px;
  height: 38px;
}
.search .s-inp:focus {
  box-shadow: none;
  border-color: #fff;
}
.search .btn {
  float: left;
  width: 100px;
  padding: 5px;
  height: 38px;
  border-radius: 0;
}



















.wrap {
  width: 1200px;
  margin-left: auto;
  margin-right: auto;
}

/*搜索*/
.search {
  width: 420px;
  border: 2px solid rgba(33, 40, 46, 0.2);
  *zoom: 1;
}
.search:before, .search:after {
  content: "";
  display: table;
}
.search:after {
  clear: both;
  overflow: hidden;
}
.search .s-inp {
  float: left;
  width: 316px;
  background: #fff;
  border-color: #fff;
  border-radius: 0;
  padding: 5px;
  height: 38px;
}
.search .s-inp:focus {
  box-shadow: none;
  border-color: #fff;
}
.search .btn {
  float: left;
  width: 100px;
  padding: 5px;
  height: 38px;
  border-radius: 0;
}

.header-main {
  height: 20px;
  padding-top: 30px;
}
.header-main .search {
  float: right;
  margin-top: 19px;
}

.logo {
  float: left;
  margin : 0px;
}
.logo a {
  display: block;
  height: 10px;
  line-height: 80px;
  font-size: 34px;
  color: #fff;
}
.logo img {
  float: left;
  width: 80px;
  height: 80px;
  margin-right: 10px;
}
	
	
	
	
	
	img {
		border: 0
	}
	
	h1 {
		font-size: 16px;
		margin: .5em 1em 1em 0
	}
	
	h3, h2 {
		display: inline;			/* 元素前后没有换行符 */
		/* font-size: 1.0em; */
		font: 14px tahoma, "Hiragino Sans GB", "microsoft yahei", sans-serif;
	}
	
	h3 {
		font-weight: normal
	}
	
	h2 a, h3 a {
		color: #000
	}
	
	h4 {
		margin: 20px 0 10px;
		font-size: 1.1em
	}
	
	textarea, input, select {
		font: 14px Arial;
		padding: 1px 3px 0 3px;
		vertical-align: middle;
		margin-bottom: 1px
	}
	
	.c {
		clear: both;
		height: 0;
		font: 0/0 Arial;
	}
	
	.b {
		font-weight: bold
	}
	
	.tal {
		text-align: left
	}
	
	.tac {
		text-align: center
	}
	
	.tar {
		text-align: right
	}
	
	.fr {
		float: right
	}
	
	.fl {
		float: left
	}
	td a {
		font-size: 14px;
	}
	
	.abtn {
		cursor: pointer;
		border: 1px solid #c7b985;
		color: #96465d;
		padding: 2px 8px;
		margin-left: 2px;
		height: 30px
	}
	/*字体大小*/
	.f9 {
		font-size: 11px;
	}
	
	.f10 {
		font-size: 11px;
	}
	
	.f12 {
		font-size: 12px
	}
	
	.f14 {
		font-size: 14px
	}
	
	.fn, .fn a {
		font-weight: normal
	}
	/*span color 数值自定义*/
	.s1 {
		color: #008000;
	}
	
	.s2 {
		color: #984B98;
	}
	
	.s3 {
		color: #FA891B;
	}
	
	.s4 {
		color: #0033FF;
	}
	
	.s5 {
		color: #659B28
	}
	
	.gray {
		color: #818a89
	} /*次要文字颜色-可定义*/
	/*main color 数值自定义*/
	.f_one, .t_one, .r_one {
		background: #ffffff;
	}
	
	.f_two, .t_two, .r_two {
		background: #fbf8e9;
	}
	/*form*/
	textarea, input, select {
		font: 14px Arial;
		padding: 1px 3px 0 3px;
		vertical-align: middle;
		margin-bottom: 1px
	}
	
	select {
		border: solid 1px #e1d5aa;
	}
	
	.btn {
		/* background: #c7b985 url(${pageContext.request.contextPath}/images/forum/images/bg.png) 0 -200px repeat-x; */
		background-color: #5DCFFF;
		color:white;
		/* color: #000000; */
		border-width: 1px;
		padding-left: 15px;
		padding-right: 15px;
		vertical-align: middle
	}
	
	.input {
		border: solid 1px #c7b985;
		padding: 2px 0px 2px 1px;
		font-size: 1.0em;
		vertical-align: middle
	}
	
	form {
		display: inline;
	}
	
	textarea {
		border: solid 1px #c7b985;
	}
	/*header*/
	#header {
		width: 940px;
		margin: auto;
		/* background: url(${pageContext.request.contextPath}/images/forum/images/headerbg.png) 0 0 repeat-x;  */
	}
	/*toolbar*/
	.toptool {
		background: url(${pageContext.request.contextPath}/images/forum/images/bg.png) 0 0 repeat-x;
		color: #ffffff;
		padding-top: 5px;
	}
	
	.toptool span {
		padding: 1px 5px;
		line-height: 150%;
	}
	
	.toptool span a {
		color: #ffffff;
	}
	/*index info*/
	#infobox {
		border: #c7b985 1px solid;
		margin-top: -.8em;
		background: #c7b985 url(${pageContext.request.contextPath}/images/forum/images/bg.png) 0 bottom repeat-x;
	}
	
	#notice {
		margin: 0 -.3em;
		height: 20px
	}
	
	#notice a {
		color: #fff;
		padding-left: 1em;
		background: url(${pageContext.request.contextPath}/images/forum/images/dotB.png) no-repeat 0 .1em;
		margin-left: 1.5em
	}
	/*banner*/
	.banner img {
		vertical-align: middle;
	}
	/*guide*/
	.guide {
		background: #F3F8EF url(${pageContext.request.contextPath}/images/forum/images/bg.png) 0 -100px repeat-x;
		padding: .5em;
		color: #ccc
	}
	
	.guide a {
		color: #ccc;
	}
	/*table*/
	.t {
		/* border: 1px solid #c7b985; */
		margin: 0px auto 8px;
	}
	
	.t table {
		/* border: 1px solid #fff; */
		margin: 0 auto;
		width: 99.98%;
	}
	
	.t2 {
		/* border-top: #c7b985 1px solid; */
		margin: 0px auto 5px;
	}
	
	.t3 {
		margin: auto
	}
	
	.t4 {
		padding: 1px 0 1px 1px
	}
	/*table head*/
	.h {
		/* border-bottom: 1px solid #f9c100; */
		background: ##FAFAFA url(${pageContext.request.contextPath}/images/forum/images/bg.png) 0 -200px repeat-x;
/* 		background: #E0F0F9 url(${pageContext.request.contextPath}/images/forum/images/bg.png) 0 -200px repeat-x; */
		text-align: left;
		color: #000000;
		padding: .3em .4em
	}
	
	.h span {
		font-weight: normal;
	}
	
	.h h2 {
		/* font-weight: bold; */
		font-size: 16px;
	}
	
	.h a {
		font-family: Arial;
		color: #000000
	}
	
	.h span a, .h span {
		color: #5495A0;
	}
	
	.h a.a2 {
		margin-left: 12px;
	}
	/*table tr1*/
	.tr1 th {
		padding-bottom:5px ;
		text-align: left;
		vertical-align: top;
		font-weight: normal;
	}
	
	.tr1 td.td1 {
		/* border: 1px solid #e1d5aa; */
	}
	/*table tr2*/
	.tr2 {
		background: #FAFAFA;
		color: black;
/* 		color: #dc565e; */
	}
	
	.tr2 td, .tr2 th {
		line-height: 18px;
		/* border-bottom: 1px solid #c7b985; */
		padding: 2px 6px 0px; /*border-top:1px solid #c7b985;*/
	}
	
	.tr2 a {
		color:black;
/* 		color: #dc565e; */
		margin: 2px 2px 0
	}
	/*table tr3*/
	.tr3 td, .tr3 th {
		 border-bottom: 0.1px solid #F0F0EE; 
		padding: .3em .6em
	}
	
	.tr3 th {
		text-align: left;
		font-weight: normal;
	}
	
	.tr4 {
		background: #E0F0F9 url(${pageContext.request.contextPath}/images/forum/images/bg.png) 0 -200px repeat-x;
		color: #000000;
	}
	
	.tr4 td {
		padding: 4px 10px;
	}
	
	.tr td, .tr th {
		padding: 2px
	}
	/*topic content tips*/
	.tpc_content {
		font-size: 14px;
		font-family: Arial;
		padding: 0 2% 0 0.5%;
		margin: 0 0 2%
	}
	
	.tips {
		background: #fbf8e9;
		border: #e1d5aa 1px solid;
		padding: 5px;
		margin: 0 1% 1% 0;
		float: left;
		text-align: center;
	}
	
	.tiptop {
		border-bottom: 1px solid #e1d5aa;
		padding: 0 0 5px 0;
		vertical-align: middle;
	}
	
	.tipad {
		border-top: 1px solid #e1d5aa;
		margin: 10px 0 0;
		padding: 5px 0 0;
	}
	
	.quote {
		width: 80%;
		font-size: 70%;
		color: #000000;
		margin: 8px 2px 2px;
		padding: 0
	}
	
	blockquote {
		width: 80%;
		font-size: 85%;
		color: #81888c;
		border: 1px solid #e1d5aa;
		border-left-width: 3px;
		padding: 5px;
		margin: 0 0 1%
	}
	/*menu*/
	.menu {
		position: absolute;
		background: #fff;
		border: 1px solid #c7b985;
	}
	
	.menu td, .menu li, .menu ul {
		background: #fff;
		padding: 0;
		margin: 0
	}
	
	.menu li {
		list-style: none;
	}
	
	.menu a {
		display: block;
		padding: 3px 15px 3px 15px;
		background: #fff;
	}
	
	.menu a:hover {
		background: #96465d;
		text-decoration: none;
		color: #fff;
	}
	
	.menu ul.ul1 li a {
		display: inline;
		padding: 0
	}
	/*pages*/
	.pages {
		margin: 3px 0;
		font: 12px tahoma, "Hiragino Sans GB", "microsoft yahei", sans-serif;
/* 		font: 11px/12px Tahoma */
	}
	
	.pages * {
		vertical-align: middle;
	}
	
	.pages a {
		padding: 1px 4px 1px;
		border: 1px solid #c7b985;
		margin: 0 1px 0 0;
		text-align: center;
		text-decoration: none;
		font: normal 12px/14px verdana;
	}
	
	.pages a:hover {
		border: #dc565e 1px solid;
		background: #F3F8EF;
		text-decoration: none;
		color: #000000
	}
	
	.pages input {
		/* margin-bottom: 0px;
		border: 1px solid #dc565e;
		height: 15px;
		font: bold 12px/15px Verdana;
		padding-bottom: 1px;
		padding-left: 1px;
		margin-right: 1px;
		color: #dc565e;  */
		
		margin-bottom: 0px;
		border: 1px solid #37393b;
		height: 19px;
		/*! font: bold 12px/15px Verdana; */
		padding-bottom: 1px;
		/*! padding-left: 1px; */
		margin-right: 1px;
		color: #37393b; 
		
		margin-left: 2px;
		/*! width: 30px; */
		
	}
	/*footer*/
	#footer {
		width: 1200px;
		text-align: right;
		border-top: 2px solid #f9c100;
		margin: auto;
		padding: 5px 0;
		background: #ffffff
	}
	
	#main {
		width: 1100px;
		margin: auto;
		padding: .8em 0 0;
		background: #ffffff
	}
	
	.button {
		font-size: 12px;
	}
	/*自定义css*/
</style>
<!--css-->

<style type="text/css">/*竖线风格输出*/
	.tr3 td, .tr3 th {
	 	border-right: 1px solid #F0F0EE; 
	}
	
	.y-style {
		text-align: center;
	}
	
	.t table {
		border: 0;
		width: 100%;
	}
	
	.tr1 th {
		border-right: 1px solid #e1d5aa;
	}
	
	.tr1 td.td1 {
		border-left: 0
	}
	
	.t {
		padding: 1px
	}
	.nav li {
		margin-right: 5px;
	}
</style>
</head>
<body>
	<div id="wrapA" >
		<%-- <div id="header">
			<div class="toptool tar">
				<span>
					<a href="<c:url value="category_list.do" />">Home首页</a> | 
					<a href="<c:url value="category_list.do" />">论坛首页</a>
				</span>
			</div>
			<table cellspacing="0" cellpadding="0" align="center" width="100%">
				<tr>
					<td class="banner">
						<a href="<c:url value="category_list.do" />">
							 <img src="${pageContext.request.contextPath}/images/forum/images/logo.png" ></img>
						</a>
					</td>
					<td class="banner" id="banner" align="right">
						<!-- <img src="${pageContext.request.contextPath}/images/forum/images/banner.gif"></img> -->
					</td>
				</tr>
				<tr>
					<td align="center" height="1" colspan="2"></td>
				</tr>
			</table>
			
			
				<div class="header-main wrap">
		<h1 class="logo">
			<a href="#"><img src="images/logo.png" />德宏州党政军警民联防平台</a>
		</h1>
		<div class="search" >
			<input type="text" class="s-inp" value="${keyword }" /> <a href="javascript:void(0)" onclick="doSearch(this)" class="btn btn-primary" style="background: #5DCFFF;text-align: center">搜索</a>
		</div>
	</div>
</div> --%>


 <div id="header">
	<div class="header-main wrap">
	</div>
</div> 

<!-- 导航 -->
<div class="nav" >
	<ul class="wrap">
		<li ><a href="${ctx}/index.action">首页</a></li>
		<li><a href="${ctx }/notice/more.action">通知公告</a></li>
		<li style="margin-left: 5px"><a href="${ctx }/news/more.action">联防要闻</a></li>
		<li style="margin-left: 5px"><a href="${ctx }/work/more.action">工作动态</a></li>
		<li style="margin-left: 5px"><a href="${ctx }/law/more.action">政策法规</a></li>
		<%-- <li><a href="${ctx }/preplan/more.action">联防预案</a></li> --%>
		<li><a href="${ctx }/style/more.action">基层风采</a></li>
		<li style="margin-left: 5px" class="active"><a href="${ctx }/category_list.do">论坛互动</a></li>
		<li style="margin-left: 5px"><a href="${ctx }/showAllFilms.do">戍边影院</a></li>
	</ul>
</div>
			
			
 			<%-- 
			<div id="h_guide" class="guide" >
				<span class="s3">&raquo;</span>

				<c:choose>
					<c:when test="${ personInfo == null }">
							您尚未&nbsp;
							<a href="<c:url value="person_initLogin.do" />">登录</a> |
							<a href="<c:url value="person_initAdd.do" />">注册</a>
					</c:when>
					<c:otherwise>
							欢迎您, <a href="<c:url value="person_view.do" />?id=${ personInfo.id }">${personInfo.account }</a> | 
								<a href="<c:url value="person_logout.do" />">注销</a>
					</c:otherwise>
				</c:choose>
			</div>   --%>
			
			
		</div>
	</body>

</html>			
			