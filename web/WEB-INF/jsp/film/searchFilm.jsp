<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<title>德宏州党政军警民联防平台</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="My Play Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 







</script>
<!-- bootstrap -->
<link href="${ ctx }/film/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' media="all" />
<!-- //bootstrap -->
<link href="${ ctx }/film/css/dashboard.css" rel="stylesheet">
<!-- Custom Theme files -->
<link href="${ ctx }/film/css/style.css" rel='stylesheet'
	type='text/css' media="all" />
<script src="${ ctx }/film/js/jquery-1.11.1.min.js"></script>
<!--start-smoth-scrolling-->

<style type="text/css">
.content {
	width: 1200px;
	margin-left: auto;
	margin-right: auto;
}

h5 {
	margin: 0;
	margin-bottom: 16px;
	padding-top: 10px;
}

.btn:active {
	border: 1px solid transparent;
}

.sidebar {
	top: 31px;
}

.main {
	padding: 0px;
	background: #fff;
}

.col-sm-offset-3 {
	margin: 0;
}

.main-grids {
	padding: 0em 0 1em 1em;
}

.FilmManagement {
	color: #fff;
	background: #60BEFC;
	padding: 0 32px;
	height: 30px;
	cursor: pointer;
	float: right;
	display: inline;
	font-family: inherit;
	font-size: inherit;
	font-style: inherit;
	font-weight: inherit;
	margin-top: 0px;
	margin-right: 18px;
}

.nav-sidebar li a {
	display: block;
	width: 200px;
	text-align: left;
	font-size: 16px;
	float: left;
}

.nav-sidebar li {
	width: 200px;
}
.nav li {
	margin-right: 5px;
}
</style>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">

		<%-- <div class="clearfix">
		<div class="header-main wrap">
		<h1 class="logo">
			<a href="#"><img src="${ ctx }/film/images/log.png">德宏州党政军警民联防平台</a>
		</h1>
		<div class="search" >
			<input type="text" class="s-inp" value="搜索"> <a href="javascript:void(0)" onclick="doSearch(this)" class="btn btn-primary">搜索</a>
		</div>
	  </div> --%>
		<div style="margin-top:8px">&nbsp;</div>
		<div class="nav">
			<ul class="wrap">
				<li><a href="${ctx}/index.action">首页</a></li>
				<li><a href="${ctx }/notice/more.action">通知公告</a></li>
				<li><a href="${ctx }/news/more.action">联防要闻</a></li>
				<li><a href="${ctx }/work/more.action">工作动态</a></li>
				<li><a href="${ctx }/law/more.action">政策法规</a></li>
				<li><a href="${ctx }/law/more.action">基层风采</a></li>
				<li><a href="${ctx }/category_list.do">论坛互动</a></li>
				<li class="active"><a href="${ctx }/showAllFilms.do">戍边影院</a></li>
			</ul>
		</div>
	</nav>

	<div class="content">
		<div class="col-sm-3 col-md-2 sidebar" style="height: 892px">
			<div class="top-navigation">
				<div class="t-menu">MENU</div>
				<div class="t-img"></div>
				<div class="clearfix"></div>
			</div>


			<form action="${ctx }/searchFilm.action" method="post">
				<div class="form-group" style="margin-top: 30px;">
					<div class="input-group input-group-md">
						<div class="addon-md">
							<input type="text" placeholder="请输入电影名"
								style="background-color: #374850; color: white; border: 1px solid transparent; border-radius: 2px;"
								class="form-control" name="keyword">
						</div>
						<span class="input-group-btn">
							<button
								style="background-color: #374850; border-color: #374850; outline: none;border:none"
								class="btn btn-default" type="submit">
								<span class="glyphicon glyphicon-search" style="color: #99998D"></span>
							</button>
						</span>
					</div>
				</div>
			</form>



			<div class="drop-navigation drop-navigation" style="margin-top: 20px">
				<ul class="nav nav-sidebar" style="background: #272c2e">
					<li class="active"><a href="${ ctx }/showAllFilms.do"
						class="home-icon"><span class="glyphicon glyphicon-home"
							aria-hidden="true">&nbsp;全部</span></a></li>

					<c:forEach var="item" items="${filmCategory }">
						<li><a href="${ctx }/showCategoryFilm.action?id=${item.id }"
							class="user-icon"><span
								class="glyphicon glyphicon-home glyphicon-blackboard"
								aria-hidden="true">&nbsp;${item.title }</span></a></li>
					</c:forEach>
				</ul>
				<!-- script-for-menu -->

			</div>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
			id="mainContent">
			<div class="main-grids">
				<div class="recommended">
					<div class="recommended-grids">
						<div class="recommended-info" style="margin-top: 60px;">
							<h3 class="page-header">搜索结果</h3>
						</div>

						<c:if test="${flag }">
							<div>
								很抱歉，没有找到与“<font color="red">${keyword }</font>”相关的结果
							</div>

						</c:if>
						<c:if test="${!flag }">

							<c:forEach var="item" items="${data.list }">
								<div class="col-md-3 resent-grid recommended-grid">
									<div class="resent-grid-img recommended-grid-img">
										<a href="${ctx }/playFilm.do?id=${item.id}"><img
											style="height: 153px; width: 230px;" src="${item.imgurl }"
											alt="" /></a>
										<div class="time small-time">
											<p>
												<span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp;&nbsp;${item.during }
											</p>
										</div>
										<div class="clck small-clck"></div>
									</div>
									<div style="box-shadow: 0px 0 2px #C1C1C1 !important;">
										<h5>
											<a style="margin-left: 8px"
												href="${ctx }/playFilm.do?id=${item.id}" class="title">${item.title }</a>
										</h5>
										<div style="margin-left: 8px">
											主演：${item.leadingrole }<span
												style="float: right; margin-right: 5px">${item.country }</span>
										</div>
										<div></div>

										<%-- <ul  >
										<li style="float:left;margin-left: -40px">主演：${item.leadingrole }</li>
										<li class="right-list" style="float:right"><p>${item.country }</p></li>
									</ul> --%>
									</div>
								</div>
							</c:forEach>

						</c:if>


						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<div>
				<span style="float: right"> <a
					href="${ctx }/showAllFilms.do?page=${data.prePage}" class="btn">上一页</a>
					<select id="pageSelect">
						<c:forEach var="inx" begin="1" end="${data.pages }">
							<c:if test="${inx == data.pageNum }">
								<option value="${inx }" selected="selected">第${inx }页</option>
							</c:if>
							<c:if test="${inx != data.pageNum}">
								<option value="${inx }">第${inx }页</option>
							</c:if>
						</c:forEach>
				</select> <a href="${ctx }/showAllFilms.do?page=${data.nextPage}" class="btn">下一页</a>
					<font style="font-size: 12px">共${data.total}部&nbsp;&nbsp;&nbsp;&nbsp;</font>
				</span>
				<p>&nbsp;</p>
			</div>
			<br />
		</div>

		<script type="text/javascript">
			$("#pageSelect").change(function() {

				var page = $(this).val();
				location.href = "${ctx}/showAllFilms.do?page=" + page;
			});
		</script>

		<script type="text/javascript">
			var screenHeight = window.screen.availHeight / 2;
			$("#mainContent").css("height", screenHeight);
		</script>

	</div>
</body>
</html>