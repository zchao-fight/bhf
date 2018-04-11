<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html class="page-full">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>德宏州党政军警民联防平台</title>
<link href="${ctx}/css/style.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<div class="header-mini">
		<h1 class="logo">
			<a href="${ctx }"><img src="images/logo.png">德宏州党政军警民联防平台</a>
		</h1>
	</div>
	<form id="loginForm" action="${ctx}/handleLogin.action" method="post">
	<div class="box-login">
		<div class="login-pic">
			<img src="${ctx }/images/login.jpg" alt="">
		</div>
		<div class="login-main">
			<div class="login-tit">账户登录</div>
			<div class="login-con">
				<div class="login-item">
					<input type="text" name="username" placeholder="用户名账户" class="inp inp-login">
				</div>
				<div class="login-item">
					<input type="password" name="password" placeholder="密码" class="inp inp-login">
				</div>
				<c:if test="${not empty loginMsg }">
					<div class="login-item-tips" style="display:block">${loginMsg }</div>
				</c:if>
				<div class="login-item-btn">
					<a href="javascript:void(0)" onclick="submit()" class="btn btn-primary btn-block">登录</a>
				</div>
				<div class="login-item-txt">
					<a href="#" class="pull-right">忘记密码</a>
					<!-- <a href="#">注册</a> -->
				</div>
			</div>
		</div>
	</div>
	</form>
	<script src="${ctx}/js/jquery.min.js"></script>
	<script src="${ctx}/js/dropdown.js"></script>
	<script>
		function submit(){
			$("#loginForm").submit();
		}
		// 计算位置
		function set() {
			var hWin = $(window).height()
			var hHead = $(".header-mini").outerHeight();
			var hMenu = $(".box-login").outerHeight();
			if (hWin - hHead - hMenu < 40) {
				$(document.body).height(hHead + hMenu + 40)
			} else {
				$(document.body).height("100%")
				var mTop = (hWin - hHead - hMenu) / 2
				$(".box-login").css("margin-top", mTop);
			}
		}
		$(function() {
			set()
		})
		$(window).resize(function() {
			set()
		})
	</script>
</body>
</html>