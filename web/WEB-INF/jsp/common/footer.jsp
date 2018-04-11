<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- footer -->
	<div class="footer">
		<div class="ft-menu wrap">
			<dl class="menu-item menu-item-01">
				<dt>用户指引</dt>
				<dd>
					<a href="/upload/document/联防平台部署手册.docx"><i class="iconfont icon-dot"></i>联防平台部署手册</a>
				</dd>
				<dd>
					<a href="/upload/document/联防平台用户使用手册.docx"><i class="iconfont icon-dot"></i>联防平台用户使用手册</a>
				</dd>
				<dd>
					<a href="/upload/document/各联防单位视频会议场地规范.docx"><i class="iconfont icon-dot"></i>各联防单位视频会议场地规范</a>
				</dd>
			</dl>
			<dl class="menu-item menu-item-02">
				<dt>常用下载</dt>
				<dd>
					<a href="/upload/software/格式化工厂.exe"><i class="iconfont icon-arw-right"></i>格式化工厂</a>
				</dd>
				<dd>
					<a href="/upload/software/VLC视频播放器.exe"><i class="iconfont icon-arw-right"></i>VLC视频播放器</a>
				</dd>
				<dd>
					<a href="/upload/software/ScreenCapture截图软件.exe"><i class="iconfont icon-arw-right"></i>ScreenCapture截图软件</a>
				</dd>
			</dl>
			<dl class="menu-item menu-item-03">
				<dt>技术支持</dt>
				<dd>
					<i class="iconfont icon-place"></i>北京航天长峰科技工业集团有限公司
				</dd>
				<dd>
					<i class="iconfont icon-mail"></i>ccf_jgsyb@sina.com
				</dd>
				<dd>
					<i class="iconfont icon-phone"></i>010-68385288
				</dd>
			</dl>
			<dl class="menu-item menu-item-04">
				<dt>微信关注</dt>
				<dd class="menu-code">
					<img src="${ctx }/images/code.png">
				</dd>
			</dl>
			<div class="return-top" id="return">
				<i class="iconfont icon-arw-top"></i>
			</div>
		</div>
	</div>
		
</body>
</html>