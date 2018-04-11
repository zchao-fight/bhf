<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/jquery.SuperSlide.js"></script>
<script src="${ctx}/js/dropdown.js"></script>

<!-- 每个页面的头都一样 header -->
<%-- <div class="header">
	<div class="header-bar">
		<div class="wrap">
			<div class="bar-left">
				长峰提供技术支持<a href="javascript:;">收藏本站</a>
				<a href="${ctx }/admin/forum/catagory.do">管理员页面</a>
			</div>
			<c:if test="${empty _user }">
				<ul class="bar-menu">
					<li><a href="${ctx }/login.action">登录</a></li>
				</ul>
			</c:if>
			<c:if test="${not empty _user }">
				<ul class="bar-menu">
					<li class="set-menu dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="iconfont icon-msg"></i><span class="badge" id="notifyCountSpan"></span></a>
						<ul class="dropdown-menu dropdown-menu-right" data-toggle="dropdown" id="notifyUl">
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
							<li><a href="javascript:;">通知1</a></li>
						</ul></li>
					<!-- <li><a href="#"><i class="iconfont icon-down"></i></a></li> -->
					<li class="set-menu dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="iconfont icon-set"></i></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="javascript:;">文电系统</a></li>
							<li><a href="javascript:;">总指挥系统</a></li>
							<li><a href="javascript:;">执勤系统</a></li>
							<li><a href="javascript:;">资源管理系统</a></li>
							<li><a href="javascript:;">指挥调度系统</a></li>
							<li><a href="javascript:;">运维系统</a></li>
							<li><a href="javascript:;">视频监控系统</a></li>
						</ul></li>
					<li class="user-menu dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="images/pic/p05.jpg" alt="">${_user.name}<i class="iconfont icon-arw-down"></i></a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li><a href="javascript:;">修改密码</a></li>
							<li><a href="${ctx }/logout.action">注销</a></li>
						</ul></li>
				</ul>
			</c:if>
		</div>
	</div> --%>
	<div class="header-main wrap" style="height:20px">
		<%-- <h1 class="logo">
			<a href="${ctx }/"><img src="${ctx}/images/logo.png">德宏州党政军警民联防平台</a>
		</h1>
		<div class="search" >
		<form action="${ctx}/search.action" method="post">
			<input type="text" class="s-inp" value="${keyword }"> <a href="javascript:void(0)" onclick="doSearch(this)" class="btn btn-primary">
			<input type="text" class="s-inp" name="keyword" value="${keyword }"> <a class="btn btn-primary">
			<input type="submit">搜索</a>
		</form>
		</div> --%>
</div>
<!-- 导航 -->
<style>

.nav li {
margin-right: 10px;
}
</style>
<div class="nav">
	<ul class="wrap">
		<li  class=${type == 0 ? 'active':''} ><a href="${ctx}/index.action">首页</a></li>
		<li class=${type == 1 ? 'active':'' }><a href="${ctx }/notice/more.action">通知公告</a></li>
		<li class="${type == 2 ? 'active':'' }"><a href="${ctx }/news/more.action">联防要闻</a></li>
		<li class="${type == 3 ? 'active':''}" ><a href="${ctx }/work/more.action">工作动态</a></li>
		<li  class="${type == 4 ? 'active':'' }"><a href="${ctx }/law/more.action">政策法规</a></li>
		<li class="${type == 6 ? 'active':'' }"><a href="${ctx }/style/more.action">基层风采</a></li>
		<li class="${type == 5 ? 'active':'' }"><a href="${ctx }/category_list.do">论坛互动</a></li>
		<li class="${type == 7 ? 'active':'' }"><a href="${ctx }/showAllFilms.do">戍边影院</a></li>
		
	</ul>
</div>

<script type="text/javascript">
	function doSearch(obj) {
		var keyword = $(obj).prev().val();
		//var keyword = $(unique).val();
		location.href = "${ctx}/search.action?keyword=" + encodeURI(keyword);
	}

	
	setInterval(function(){
		pullMsgSecondsEverySeconds();
	}, 10000);
	
	function pullMsgSecondsEverySeconds() {
		$.post("${ctx}/notify/getMsg.action", {}, function(data) {
			var msg = [];
			var events = data.events;
			if (events) {
				for (var i = 0; i < events.length; i++) {
					msg.push(events[i].name);
				}
			}

			if (data.emails) {
				for (var i = 0; i < data.emails.length; i++) {
					msg.push(data.emails[i].name);
				}
			}

			if(msg.length == 0){
				$("#notifyCountSpan").hide();
				//$("#notifyUl").hidden();
				return;
			}else{
				$("#notifyCountSpan").show();
			}
			
			$("#notifyCountSpan").html(msg.length);
			$("#notifyUl").empty();
			for (var i = 0; i < msg.length; i++) {
				$("#notifyUl").append('<li><a href="javascript:;">' + msg[i] + '</a></li>')
			}

		}, "json");
	}
</script>