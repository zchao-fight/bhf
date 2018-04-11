<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html class="page-full">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>德宏州党政军警民联防平台</title>
<link href="${ctx}/css/style.css" rel="stylesheet">
</head>
<body>
<!-- header -->
<div class="header-mini">
  <h1 class="logo"><a href="#"><img src="images/logo.png">德宏州党政军警民联防平台</a></h1>
  <ul class="bar-menu">
    <li><a href="#"><i class="iconfont icon-msg"></i><span class="badge">3</span></a></li>
    <li class="set-menu dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="iconfont icon-set"></i></a>
      <ul class="dropdown-menu dropdown-menu-right">
        <li><a href="javascript:;">文电系统</a></li>
        <li><a href="javascript:;">总指挥系统</a></li>
        <li><a href="javascript:;">执勤系统</a></li>
        <li><a href="javascript:;">资源管理系统</a></li>
        <li><a href="javascript:;">指挥调度系统</a></li>
        <li><a href="javascript:;">运维系统</a></li>
        <li><a href="javascript:;">视频监控系统</a></li>
      </ul>
    </li>
    <li class="user-menu dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="images/pic/p05.jpg" alt="">胡海峰<i class="iconfont icon-arw-down"></i></a>
      <ul class="dropdown-menu dropdown-menu-right">
        <li><a href="javascript:;">修改密码</a></li>
        <li><a href="javascript:;">注销</a></li>
      </ul>
    </li>
  </ul>
</div>
<ul class="menu-groups">
  <li class="item-lg"><a href="${ctx}/index.action" class="menu01"><i class="iconfont icon-menhu"></i>门户系统</a></li>
  <li><a href="#" class="menu02"><i class="iconfont icon-zhiqin"></i>执勤系统</a></li>
  <li><a href="#" class="menu03"><i class="iconfont icon-diaodu"></i>调度系统</a></li>
  <li><a href="#" class="menu04"><i class="iconfont icon-wendian"></i>文电系统</a></li>
  <li><a href="#" class="menu05"><i class="iconfont icon-shipin"></i>视频系统</a></li>
  <li><a href="#" class="menu06"><i class="iconfont icon-ziyuan"></i>资源系统</a></li>
  <li><a href="#" class="menu07"><i class="iconfont icon-yunwei"></i>运维系统</a></li>
  <li><a href="#" class="menu08"><i class="iconfont icon-zhiban"></i>值班系统</a></li>
  <li><a href="#" class="menu09"><i class="iconfont icon-yizhangtu"></i>一张图</a></li>
</ul>
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/dropdown.js"></script>
<script>
// 计算位置
function set(){
  var hWin = $(window).height()
  var hHead = $(".header-mini").outerHeight();
  var hMenu = $(".menu-groups").outerHeight();
  if(hWin - hHead - hMenu<40){
    $(document.body).height(hHead+hMenu+40)
  }else{
    $(document.body).height("100%")
    var mTop = (hWin - hHead - hMenu)/2
    $(".menu-groups").css("margin-top",mTop);
  }
}
$(function(){
  set()
})
$(window).resize(function(){
  set()
})
</script>
</body>
</html>