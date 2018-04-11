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
<style>
.article a {
	font-size: 18px;
}

div a:hover {
	color: #5DCFFF;
}

pre {
	white-space: pre-wrap; /* css-3 */
	white-space: -moz-pre-wrap; /* Mozilla, since 1999 */
	white-space: -pre-wrap; /* Opera 4-6 */
	white-space: -o-pre-wrap; /* Opera 7 */
	word-wrap: break-word; /* Internet Explorer 5.5+ */
	line-height: 26px;
	font-size: 14px;
	margin-left: 80px;
	margin-right: 80px;
	margin-top: 20px;
}
</style>

<script type="text/javascript">
	 function tab(obj){
	  var $this = $(obj);
	  var $tabmenu = $this.find(".tab-hd li");
	  $tabmenu.on("mousemove",function(){
	    if ($(this).hasClass('active')) return
	    $(this).addClass("active").siblings().removeClass("active");
	    $this.find(".tab-item").eq($(this).index()).fadeIn().siblings().hide();
	  })
} 
 </script>
<script type="text/javascript">
	function doZoom(fontSize,type) {
		if (type == "小") {
			$(".article .article-bd p").css("line-height","26px");
			
		} else if (type == "中") {
			$(".article .article-bd p").css("line-height","32px");
		} else {
			$(".article .article-bd p").css("line-height","48px");
		}
		$(".article-bd").css("font-size",fontSize);
	}
</script>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>

	<!-- content -->
	<div class="content" id="mainContent">
		<div class="breadcrumb">
			<a href="${ctx }/index.action">首页</a><span class="sep">&gt;</span><a
				href="${ctx }/law/more.action">政策法规</a><span class="sep">&gt;</span>详情
		</div>
		<div class="article">
			<div class="article-hd">
				<h1>${data.name }</h1>
				<div class="article-info" style="text-align: center;">
					<!-- <span class="info-size">
					<a href="javascript:doZoom('14px','小');" class="active">小</a>
					<a href="javascript:doZoom('16px', '中');">中</a>
					<a href="javascript:doZoom('18px', '大');">大</a></span> -->
					<span class="mr">类型：${data.type }</span>
					<span class="mr">生效时间：${data.abledtime }</span> 
					<span class="mr">发布号：${data.pulishnumber }</span>
				</div>
			</div>
			<div class="article-bd">
				<!-- <p class="article-pic">
					<img src="images/pic/p01.jpg" width="800" alt="">
				</p> -->

				<pre>${data.digest }</pre>
				<br />
				<div style="float: left; margin-left: 100px">关键字：${data.keywords }</div>
			</div>

			<br />
			<div style="text-align: center;">
				<a href="${data.filepath }/${data.filename}">附件:${data.filename }</a>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

	<script>
	var mainHeight = $("#mainContent").height();
	var screenHeight = window.screen.availHeight;
	if (mainHeight < screenHeight) {
		$("#mainContent").css("height", screenHeight);
		
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
</script>
</body>
</html>

