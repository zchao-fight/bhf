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
<style type="text/css">
.content .main {
	margin-left: 1px !important;
}
</style>
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/jquery.SuperSlide.js"></script>
<script src="${ctx}/js/dropdown.js"></script>
</head>
<body>

	<%--使用公共的头部 start --%>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
	<%--使用公共的头部 end --%>

	<!-- content -->
	<div class="content" style="width: 1100px;">
		<div class="breadcrumb">
			<a href="${ctx }/category_list.do">论坛互动</a><span class="sep">&gt;</span><a href="#">分类管理</a>
			
			<c:if test="${_user.addCategory == 1 || _user.superAdmin}">
			<div style="float:right">
				<span class="news-date"><%-- <a href="${ctx }/category_initAdd.do?action=initAdd"
				class="btn ">添加分类</a> --%>
				<a href="${ctx }/category_initAdd.do?action=initAdd"
				><img style="width:22px;height: 22px;" title="添加分类" alt="添加分类" src="${ctx }/images/forum/images/forum_add.png"  /></a>
				</span></li>
			
			</div>
			</c:if>
		</div>

		

			<div class="main">
				<ul class="news-list news-list-line">
					<c:forEach items="${categoryList }" var="item">
						<li><a
							href="${ctx}/admin/forum/board.do?catagoryId=${item.id}">${item.name }</a>
							<span class=""
							style="font-size: 12px; margin-left: 20px; color: #cecece;">
								(板块数量：${fn:length(item.boardList) })</span> <span class="news-date">
								<%-- <a href="javascript:void(0)" onclick="deleteCatalog(${item.id})"
								class="btn ">删除分类</a> --%>
								<c:if test="${_user.addCategory == 1 || _user.superAdmin }">
								<a href="javascript:void(0)" onclick="deleteCatalog(${item.id})">
								<img style="width:22px;height:22px" alt="删除分类" title="删除分类" src="${ctx }/images/forum/images/forum_delete.png" />
								</a>
								</c:if>
								</span></li>
					</c:forEach>
				</ul>
			</div>



	</div>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

<script>
	var adaptHeight = $(document).height();
	$(".content").css("height", adaptHeight);
</script>


	<script>
$("#pageSelect").change(function(){
	var page = $(this).val();
	location.href = '${ctx}/${pageurl}'+page;
});

function deleteCatalog(id){
	if(confirm("确定要删除吗?")){
		 $.get("${ctx}/admin/forum/deleteCatagory.do?id="+id, function(result){
			    alert("删除成功");
			    location.href =location.href ; 
		 });
	}
}
</script>
</body>
</html>