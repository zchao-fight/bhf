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
</head>
<body>

<%--使用公共的头部 start --%>
<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
<%--使用公共的头部 end --%>

<!-- content -->
<div class="content">
  <div class="breadcrumb">
    <a href="#nogo">首页</a><span class="sep">&gt;</span><a href="${ctx }/news/more.action">边防要闻</a><span class="sep">&gt;</span>更多
  </div>
  <div class="sidebar">
    <ul class="side-menu">
      <li class="${type == 1 ? 'active':'' }"><a href="${ctx }/notice/more.action">通知公告</a></li>
      <li class="${type == 2 ? 'active':'' }"><a href="${ctx }/news/more.action">边防要闻</a></li>
      <li class="${type == 3 ? 'active':'' }"><a href="${ctx }/work/more.action">工作动态</a></li>
      <li class="${type == 4 ? 'active':'' }"><a href="${ctx }/law/more.action">政策法规</a></li>
      <li class="${type == 5 ? 'active':'' }"><a href="${ctx }/preplan/more.action">联防预案</a></li>
    </ul>
  </div>
  <div class="main">
   	<div style="text-align:center; font-size:20px;font-weight:bold;font-family:微软雅黑">${data.name }</div>
   	<div style="text-align:center;line-height:30px;">发布时间：${data.createtime }</div>
   	<br>
   	<div>
   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${data.content }
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
</script>
</body>
</html>