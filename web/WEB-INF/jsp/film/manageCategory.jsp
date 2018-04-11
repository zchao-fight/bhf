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

<style type="text/css">
.news-list .news-date {
	right: 50px;
}

.news-list .film-delete {
	position: absolute;
	top: 0;
	right: 0;
	color: #a8aeb2;
}
</style>

</head>
<body>


	<%--使用公共的头部 start --%>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
	<%--使用公共的头部 end --%>

	<!-- content -->
	<div class="content">
		<div class="breadcrumb">
			<a href="${ctx }/showAllFilms.do">戍边影院</a><span class="sep">&gt;</span><a
				href="${ctx }/manageCategory.action">类别管理</a><span class="sep">&gt;</span>详情
		</div>
		<div class="sidebar">
			<ul class="side-menu">

				<c:if test="${_user.superAdmin }">
				
						<li class="${type == 1 ? 'active':'' }"><a
							href="${ctx }/upload.action">上传电影</a></li>
						<li class="${type == 2 ? 'active':'' }"><a
							href="${ctx }/delete.action">电影管理</a></li>
						<li class='active'><a href="${ctx }/manageCategory.action">类别管理</a></li>
				</c:if>

				<c:if test="${_user.superAdmin  eq false}">
					<c:if test="${_user.uploadFilm == 1 }">
						<li class="${type == 1 ? 'active':'' }"><a
							href="${ctx }/upload.action">上传电影</a></li>
					</c:if>
					<c:if test="${_user.deleteFilm == 1 }">
						<li class="${type == 2 ? 'active':'' }"><a
							href="${ctx }/delete.action">电影管理</a></li>
					</c:if>
					<c:if test="${_user.manageFilmCategory == 1 }">
						<li class='active'><a href="${ctx }/manageCategory.action">类别管理</a></li>
					</c:if>

				</c:if>


			</ul>
		</div>
		<div class="main">
			<div style="margin-left: 850px">
				<a href="${ctx }/addFilmCategory.action"><img alt="添加类别"
					src="${ctx }/images/addFilmCategory.png"></a>
			</div>
			<ul class="news-list news-list-line">
				<c:forEach items="${data.list }" var="item">
					<li><a href="#">${item.title }</a> <span class="news-date">${item.datecreated }</span>
						<span class="film-delete"><a href="javascript:void(0)"
							onclick="deleteCategory(${item.id})"><img alt="删除"
								src="${ctx }/images/delete.png" width="20px" height="20px"
								onmousemove=""></a></span></li>
				</c:forEach>
			</ul>

			<div class="page">
				共${data.total }条 <a
					href="${ctx }/news/more.action?page=${data.prePage}" class="btn"><i
					class="iconfont icon-arw-left"></i></a> <select id="pageSelect">
					<c:forEach begin="1" end="${data.pages }" var="inx">
						<c:if test="${inx == data.pageNum }">
							<option value="${inx }" selected="selected">第${inx }页</option>
						</c:if>
						<c:if test="${inx != data.pageNum }">
							<option value="${inx }">第${inx }页</option>
						</c:if>

					</c:forEach>
				</select> <a href="${ctx }/${pageurl}${data.nextPage}" class="btn"><i
					class="iconfont icon-arw-right"></i></a>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

	<script>

	function deleteCategory(id) {
		if (confirm("确定要删除吗？")) {
			$.get("${ctx}/deleteCategory.action?id="+id, function(result) {
				alert("删除成功");
				location.href = location.href;
			});
		}
	}
</script>

	<script type="text/javascript">

var mainHeight = $(".main").height();
var screenHeight = window.screen.availHeight;
if (mainHeight < screenHeight) {
	$(".main").css("height", screenHeight);
}

</script>


	<script>
jQuery(".slide").slide({
  titCell:".hd ul",
  mainCell:".bd ul",
  effect:"left",
  autoPlay:true,
  autoPage:"<li><a></a></li>",
  interTime: 6000
});
jQuery(".slide-sm").slide({
  titCell:".hd ul",
  mainCell:".bd ul",
  effect:"left",
  autoPlay:true,
  autoPage:"<li><a></a></li>",
  interTime: 5000
});

//选项卡
function tab(obj){
  var $this = $(obj);
  var $tabmenu = $this.find(".tab-hd li");
  $tabmenu.on("click",function(){
    if ($(this).hasClass('active')) return
    $(this).addClass("active").siblings().removeClass("active");
    $this.find(".tab-item").eq($(this).index()).fadeIn().siblings().hide();
  })
}
//选项卡调用
tab(".panel-tab");
// 返回顶部

$("#return").click(function(){ 
  $('body,html').animate({scrollTop:0},500); 
})

$("#pageSelect").change(function(){
	var page = $(this).val();
	location.href = '${ctx}/${pageurl}'+page;
});
</script>
</body>
</html>