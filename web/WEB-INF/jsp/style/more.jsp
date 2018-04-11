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
	<div class="content">
		<div class="breadcrumb">
			<a href="${ctx }/index.action">首页</a><span class="sep">&gt;</span><a
				href="${ctx }/style/more.action">基层风采</a><span class="sep">&gt;</span>更多
			<div style="float: right" id="showSearch">
				<a href="javascript:void(0)"><img alt="搜索" title="搜索"
					src="${ctx }/images/search_icon.png" onclick="showSearch()"></a>
			</div>


			<div style="float: right; display: none" id="search">
				<form action="${ctx}/search.action" method="post"
					onsubmit="return check()">
					<input id="searchContent" type="text" style="width: 200px"
						name="keyword" placeholder="请输入搜索内容"> <input type="submit"
						value="搜索" class="btn btn-primary">
				</form>
			</div>

			<script type="text/javascript">
				function showSearch() {
					$("#search").fadeIn(3000);
					$("#showSearch").hide();
					$("#hideSearch").fadeIn(3000);
				}
				function check() {
					var content = $("#searchContent").val().trim();
					console.log(content);
					if (content == "") {
						alert("请输入搜索内容");
						return false;
					}
					return true;
				}

				/* function hideSearch() {
					$("#search").hide();
					$("#showSearch").fadeIn(3000);
					$("#hideSearch").hide();
				} */
			</script>

		</div>
		<div class="sidebar">
			<ul class="side-menu">
				<li class="${type == 1 ? 'active':'' }"><a
					href="${ctx }/notice/more.action">通知公告</a></li>
				<li class="${type == 2 ? 'active':'' }"><a
					href="${ctx }/news/more.action">联防要闻</a></li>
				<li class="${type == 3 ? 'active':'' }"><a
					href="${ctx }/work/more.action">工作动态</a></li>
				<li class="${type == 4 ? 'active':'' }"><a
					href="${ctx }/law/more.action">政策法规</a></li>
				<li class="${type == 6 ? 'active':'' }"><a
					href="${ctx }/style/more.action">基层风采</a></li>
			</ul>
		</div>
		<div class="main">
			<ul class="news-list news-list-line">
				<c:forEach items="${data.list }" var="item">
					<li><c:choose>
							<c:when test="${item.highlight eq 1 && item.stick eq 1 }">
								<a style="color: red"
									href="${ctx}/${url}${item.id}&tmp=<%=Math.random()%>">【置顶】${item.name }</a>
								<span class="news-date">${item.createdate }</span>
							</c:when>
							<c:when test="${item.highlight eq 1 }">
								<a style="color: red"
									href="${ctx}/${url}${item.id}&tmp=<%=Math.random()%>">${item.name }</a>
								<span class="news-date">${item.createdate }</span>
							</c:when>
							<c:when test="${item.stick eq 1 }">
								<a href="${ctx}/${url}${item.id}&tmp=<%=Math.random()%>">【置顶】${item.name }</a>
								<span class="news-date">${item.createdate }</span>
							</c:when>
							<c:otherwise>
								<a href="${ctx}/${url}${item.id}&tmp=<%=Math.random()%>">${item.name }</a>
								<span class="news-date">${item.createdate }</span>
							</c:otherwise>
						</c:choose></li>
				</c:forEach>

			</ul>
			<div class="page">
				共${data.total }条 <a href="${ctx }/${pageurl}${data.prePage}"
					class="btn"><i class="iconfont icon-arw-left"></i></a> <select
					id="pageSelect">
					<c:forEach begin="1" end="${data.pages }" var="inx">
						<c:if test="${inx == data.pageNum }">
							<option value="${inx }" selected="selected">第${inx }页</option>
						</c:if>
						<c:if test="${inx!=data.pageNum }">
							<option value="${inx }">第${inx }页</option>
						</c:if>
					</c:forEach>
				</select> <a href="${ctx }/${pageurl}${data.nextPage}" class="btn"><i
					class="iconfont icon-arw-right"></i></a>
			</div>
		</div>


		<!-- 与底部留出空隙 -->
		<c:if test="${data.list.size() lt 10}">
			<script>
				//$(".main").height("565");
			</script>
		</c:if>
	</div>
	<!-- footer -->

	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

	<script>
		var mainHeight = $(".main").height();
		var screenHeight = window.screen.availHeight;
		if (mainHeight < screenHeight) {
			$(".main").css("height", screenHeight);
		}
	</script>

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