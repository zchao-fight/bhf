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
td {
	padding: 5px;
}

#submitAll {
	padding: 0 32px;
	height: 30px;
	cursor: pointer;
	font-family: inherit;
	font-size: inherit;
	font-style: inherit;
	font-weight: inherit;
	margin-top: 30px;
	margin-right: 2px;
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
				href="${ctx }/upload.action">上传电影</a><span class="sep">&gt;</span>详情
		</div>
		<div class="sidebar">
			<ul class="side-menu">

				<c:if test="${_user.superAdmin }">
						<li><a href="${ctx }/upload.action">上传电影</a></li>
						<li class='active'><a href="${ctx }/delete.action">电影管理</a></li>
						<li class="${type == 3 ? 'active':'' }"><a
							href="${ctx }/manageCategory.action">类别管理</a></li>
				</c:if>

				<c:if test="${_user.superAdmin eq false}">

					<c:if test="${_user.uploadFilm == 1 }">
						<li><a href="${ctx }/upload.action">上传电影</a></li>
					</c:if>
					<c:if test="${_user.deleteFilm == 1 }">
						<li class='active'><a href="${ctx }/delete.action">电影管理</a></li>
					</c:if>
					<c:if test="${_user.manageFilmCategory == 1 }">
						<li class="${type == 3 ? 'active':'' }"><a
							href="${ctx }/manageCategory.action">类别管理</a></li>
					</c:if>
				</c:if>


			</ul>
		</div>
		<div class="main">

			<form action="modifyFilmUpload.action" method="post"
				enctype="multipart/form-data">
				<table>
					<tr>
						<td>片名：</td>
						<td><input type="text" name="title" value="${film.title }"></td>
						<td><input type="hidden" value="${film.id }" name="id"></td>
					</tr>
					<tr>
						<td>国家：</td>
						<td><input type="text" name="country"
							value="${film.country }"></td>
						<td><input type="hidden" value="${film.filmurl }"
							name="filmurl"></td>
					</tr>
					<tr>
						<td>时长：</td>
						<td><input type="text" name="during" value="${film.during }"></td>
						<td><input type="hidden" value="${film.imgurl }"
							name="imgurl"></td>
					</tr>
					<tr>
						<td>主演：</td>
						<td><input type="text" name="leadingrole"
							value="${film.leadingrole }"></td>
						<td></td>
					</tr>
					<tr>
						<td>类型：</td>
						<td><select name="type">
								<c:forEach var="item" items="${filmCategory }">
									<c:if test="${film.type == item.title }">
										<option value="${item.title }" selected="selected">${item.title }</option>
									</c:if>
									<c:if test="${film.type != item.title }">
										<option value="${item.title }">${item.title }</option>
									</c:if>

								</c:forEach>
						</select>
						<td></td>
					</tr>
					<tr>
						<td>选择封皮:</td>
						<td><input type="file" name="files"></td>
						<td></td>
					</tr>
					<tr>
						<td>当前封皮：</td>
						<td><img src="${film.imgurl }"
							style="width: 160px; height: 120px" /></td>
						<td></td>
					</tr>



					<tr>
						<td colspan="3" style="text-align: left"><input
							id="submitAll" type="submit" value="提交"></td>
					</tr>
				</table>
			</form>
		</div>


	</div>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

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