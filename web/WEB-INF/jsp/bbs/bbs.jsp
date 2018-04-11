<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>德宏州党政军警民联防平台</title>
<link href="${ctx}/css/style.css" rel="stylesheet">
</head>
<body>


<%--使用公共的头部 start --%>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<%--使用公共的头部 end --%>

<!-- content -->
<div class="content">
  <div class="breadcrumb">
    <a href="#nogo">首页</a><span class="sep">&gt;</span><a href="#nogo">论坛互动</a>
    <a href="${ctx }/bbs/addTopic.action" style="float:right;border-radius: 0;color:#FFF;" onclick="doSearch(this)" class="btn btn-primary">我要发帖</a>
  </div>
  <%-- <div class="sidebar">
    <ul class="side-menu">
      <li class="${type == 1 ? 'active':'' }"><a href="${ctx }/notice/more.action">通知公告</a></li>
      <li class="${type == 2 ? 'active':'' }"><a href="${ctx }/news/more.action">边防要闻</a></li>
      <li class="${type == 3 ? 'active':'' }"><a href="${ctx }/work/more.action">工作动态</a></li>
      <li class="${type == 4 ? 'active':'' }"><a href="${ctx }/law/more.action">政策法规</a></li>
      <li class="${type == 5 ? 'active':'' }"><a href="${ctx }/preplan/more.action">联防预案</a></li>
    </ul>
  </div> 
  <div class="main">
  --%>
  <div>
    <ul class="news-list news-list-line">
     <c:forEach items="${data.list }" var="item">
	      <li>
	        <a href="${ctx}/">${item.title }</a>
	        <span class="news-date">
	        	<font color="#37393b" style="font-size: 14px !important;margin-right: 20px">${item.userName}</font>
	        	<font style="font-size: 12px !important">发布于 <fmt:formatDate value="${item.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/></font></span>
	      </li>
      </c:forEach>
     
    </ul>
    <div class="page">
     	 共${data.total }条 
     	 <a href="${ctx }/news/more.action?page=${data.prePage}" class="btn"><i class="iconfont icon-arw-left"></i></a>
      	<select id="pageSelect">
      		<c:forEach begin="1" end="${data.pages }" var="inx">
      			<c:if test="${inx == data.pageNum }">
      				<option value="${inx }" selected="selected">第${inx }页</option>
      			</c:if>
      			<c:if test="${inx != data.pageNum }">
      				<option value="${inx }" >第${inx }页</option>
      			</c:if>
      			
      		</c:forEach>
      	</select>
      	<a href="${ctx }/${pageurl}${data.nextPage}" class="btn"><i class="iconfont icon-arw-right"></i></a>
    </div>
  </div>
</div>
<!-- footer -->
<div class="footer">
  <div class="ft-menu wrap">
    <dl class="menu-item menu-item-01">
      <dt>用户指引</dt>
      <dd><a href="#"><i class="iconfont icon-dot"></i>产品购买指南</a></dd>
      <dd><a href="#"><i class="iconfont icon-dot"></i>系统安全保障规则</a></dd>
      <dd><a href="#"><i class="iconfont icon-dot"></i>防范和制止违规信息规则</a></dd>
    </dl>
    <dl class="menu-item menu-item-02">
      <dt>友情链接</dt>
      <dd><a href="#"><i class="iconfont icon-arw-right"></i>航天云网</a></dd>
      <dd><a href="#"><i class="iconfont icon-arw-right"></i>安科院</a></dd>
      <dd><a href="#"><i class="iconfont icon-arw-right"></i>航天科工集团</a></dd>
    </dl>
    <dl class="menu-item menu-item-03">
      <dt>联系我们</dt>
      <dd><i class="iconfont icon-place"></i>北京市海淀区五棵树2号院</dd>
      <dd><i class="iconfont icon-mail"></i>contact@domain.com</dd>
      <dd><i class="iconfont icon-phone"></i>000-369-7777</dd>
    </dl>
    <dl class="menu-item menu-item-04">
      <dt>微信关注</dt>
      <dd class="menu-code"><img src="images/code.png"></dd>
    </dl>
    <div class="return-top" id="return"><i class="iconfont icon-arw-top"></i></div>
  </div>
  <div class="ft-txt wrap">
    Weishengyun.com © 2016, All Rights Reserved
  </div>
</div>
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/jquery.SuperSlide.js"></script>
<script src="${ctx}/js/dropdown.js"></script>
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