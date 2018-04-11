<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>德宏州党政军警民联防平台</title>
<link href="${ctx}/css/style.css" rel="stylesheet">
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/jquery.SuperSlide.js"></script>
<script src="${ctx}/js/dropdown.js"></script>
</head>
<body>

	<%--使用公共的头部 start --%>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
	<%--使用公共的头部 end --%>


	<!-- content -->
	<div class="content" style="height:1380px;">
		<div class="breadcrumb">
			<a href="#nogo">首页</a><span class="sep">&gt;</span><a
				href="javascript:void(0)">搜索结果</a>
			<div style="float: right">
				<form action="${ctx}/search.action" method="post">
					<input type="text" style="width: 200px" name="keyword"
						placeholder="请输入搜索内容"> <input type="submit" value="搜索"
						class="btn btn-primary">
				</form>
			</div>
		</div>
		<div class="sidebar">
			<ul class="side-menu">
				<li><a href="${ctx }/notice/more.action">通知公告</a></li>
				<li><a href="${ctx }/news/more.action">边防要闻</a></li>
				<li><a href="${ctx }/work/more.action">工作动态</a></li>
				<li><a href="${ctx }/law/more.action">政策法规</a></li>
				<li><a href="${ctx }/style/more.action">基层风采</a></li>
			</ul>
		</div>
		<div class="main">
			<c:if test="${haveNoSearchResult }">
				<center>
					很抱歉，没有找到与“<font color="red">${keyword }</font>”相关的结果
				</center>
			</c:if>
			<c:if test="${!haveNoSearchResult }">
				<ul class="news-list news-list-line">
					<%---通知公告搜索结果 --%>
					<c:forEach items="${notice }" var="item">
						<li><a href="${ctx}/notice/detail.action?id=${item.id}">${item.name }</a>
							<%--  <span class="news-date">${item.createdate }</span> --%></li>
					</c:forEach>
					<%---联防要闻搜索结果 --%>
					<c:forEach items="${news }" var="item">
						<li><a href="${ctx}/news/detail.action?id=${item.id}">${item.name }</a>
							<%-- <span class="news-date">${item.createtime }</span> --%></li>
					</c:forEach>
					<%---工作动态搜索结果 --%>
					<c:forEach items="${work }" var="item">
						<li><a href="${ctx}/work/detail.action?id=${item.id}">${item.name }</a>
							<%--  <span class="news-date">${item.createdate }</span> --%></li>
					</c:forEach>
					<%---政策法规搜索结果 --%>
					<c:forEach items="${law }" var="item">
						<li><a href="${ctx}/law/detail.action?id=${item.id}">${item.name }</a>
							<%--  <span class="news-date">${item.createdate }</span> --%></li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
	</div>
	<!-- footer -->
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

	<script>
		jQuery(".slide").slide({
			titCell : ".hd ul",
			mainCell : ".bd ul",
			effect : "left",
			autoPlay : true,
			autoPage : "<li><a></a></li>",
			interTime : 6000
		});
		jQuery(".slide-sm").slide({
			titCell : ".hd ul",
			mainCell : ".bd ul",
			effect : "left",
			autoPlay : true,
			autoPage : "<li><a></a></li>",
			interTime : 5000
		});

		//选项卡
		function tab(obj) {
			var $this = $(obj);
			var $tabmenu = $this.find(".tab-hd li");
			$tabmenu.on("click", function() {
				if ($(this).hasClass('active'))
					return

				

				$(this).addClass("active").siblings().removeClass("active");
				$this.find(".tab-item").eq($(this).index()).fadeIn().siblings()
						.hide();
			})
		}
		//选项卡调用
		tab(".panel-tab");
		// 返回顶部

		$("#return").click(function() {
			$('body,html').animate({
				scrollTop : 0
			}, 500);
		})

		$("#pageSelect").change(function() {
			var page = $(this).val();
			location.href = '${ctx}/${pageurl}' + page;
		});
	</script>
</body>
</html>