<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		right:50px;
	}
	
	.news-list .film-delete {
		position: absolute;
		top: 0;
		right: 0;
		color: #a8aeb2;
	}
</style>
<style type="text/css">
	p {
		margin-left:100px
	}
	p input {
	color: #fff;
	background: #60BEFC;
	padding: 0 32px;
	height: 30px;
	cursor: pointer;
	display: inline;
	font-family: inherit;
	font-size: inherit;
	font-style: inherit;
	font-weight: inherit;
	margin-top: 20px;
	margin-right: 2px;
}
</style>
</head>
<body>


<%--使用公共的头部 start --%>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<%--使用公共的头部 end --%>

<!-- content -->
<div class="content" >
  <div class="breadcrumb">
    <a href="${ctx }/showAllFilms.do">戍边影院</a><span class="sep">&gt;</span><a href="${ctx }/manageCategory.action">增加类别</a><span class="sep">&gt;</span>详情
  </div>
  <div class="sidebar">
    <ul class="side-menu">
    
    <c:if test="${_user.superAdmin }">
    
      <li class="${type == 1 ? 'active':'' }"><a href="${ctx }/upload.action">上传电影</a></li>
     <li class="${type == 2 ? 'active':'' }"><a href="${ctx }/delete.action">电影管理</a></li>
      <li class='active' ><a href="${ctx }/manageCategory.action">类别管理</a></li>
    
    </c:if>
    
    <c:if test="${_user.superAdmin eq false }">
    
    <c:if test="${_user.uploadFilm == 1 }">  <li class="${type == 1 ? 'active':'' }"><a href="${ctx }/upload.action">上传电影</a></li></c:if>
     <c:if test="${_user.deleteFilm == 1 }"> <li class="${type == 2 ? 'active':'' }"><a href="${ctx }/delete.action">电影管理</a></li></c:if>
      <c:if test="${_user.manageFilmCategory == 1 }"> <li class='active' ><a href="${ctx }/manageCategory.action">类别管理</a></li></c:if>
    
    </c:if>
    
    
    </ul>
  </div>
  <div class="main">
  		<b>添加类别</b>
  		<form action="${ctx }/manageCategory.action" method="post" style="margin-top:20px" onsubmit="return check()">
  			名称：
  			<input type="text" id="categoryName" name="categoryName" />
  			<p><input type="submit" value="提交" /></p>
  		</form>
  </div>
 </div>
<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

<script>

function check() {
	if ($("#categoryName").val() == "") {
		alert("请输入名称");
		return false;
	}
	return true;
}

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