<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<style>
td a {
	font-size: 14px;
}

th a {
	font-size: 14px;
}
</style>

<jsp:include flush="true" page="../header.jsp"></jsp:include>

<div class="contentwrap z" id="main" style="margin-top: 0px">


	<%-- <c:if test="${_user.admin || _user.superAdmin }">
		<div class="h" class="h" style="background: #FAFAFA">
			<a href="<c:url value="category_initAdd.do" />?action=initAdd"
				class="cfont">-- 添加类别 --</a>
		</div>
	</c:if> --%>
	<br />

<div style="float: left;margin-left:10px;margin-top:-10px; display: none;" id="search">
			<form action="${ctx}/searchThread.do" method="post"
				onsubmit="return check()">
				<input id="searchContent" type="text" style="width: 200px;"
					name="keyword" placeholder="请输入搜索内容"> <input type="submit"
					value="搜索" class="btn btn-default" style="background-color: #red">
			</form>
		</div>

	<div style="float: right; margin-right: 20px">
		<div style="float: left; margin-right: 20px; margin-top: 3px"
			id="showSearch">
			<a href="javascript:void(0)"><img alt="搜索" title="搜索"
				src="${ctx }/images/search_icon.png" onclick="showSearch()"></a>
		</div>

		

		
		
		<div  style="float: left; margin-right: 20px; margin-left:20px; margin-top: 3px;display: none" id="hideSearch">
			<a href="javascript:void(0)"><img alt="收起搜索框" title="收起搜索框"
				src="${ctx }/images/cancel_icon.png" onclick="hideSearch()"></a>
		</div>

		<script type="text/javascript">
			function showSearch() {
				$("#search").fadeIn(3000);
				$("#showSearch").hide();
				$("#hideSearch").fadeIn(3000);
			}
			function check() {
				var content = $("#searchContent").val().trim();
				console.log(content);
				if (content == "") {
					alert("请输入搜索内容");
					return false;
				}
				return true;
			}

			function hideSearch() {
				$("#search").hide();
				$("#showSearch").show();
				$("#hideSearch").hide();
			} 
		</script>


		<c:choose>
			<c:when test="${_user.superAdmin }">

			</c:when>

			<c:otherwise>
				<a
					href="<c:url value="viewPersonalCenter.do" />?id=${ personInfo.id }"><img
					title="个人中心" alt="个人中心" style="width: 22px; height: 21px"
					src="${ctx }/images/forum/images/personal_center.png"></a>
			</c:otherwise>
		</c:choose>



		&nbsp;&nbsp;&nbsp;

		<c:if
			test="${_user.deleteThread == 1 || _user.onAndCancel == 1 || _user.addBoard == 1 || _user.addCategory == 1 || _user.superAdmin}">
			<a style="float: right; font-size: 16px; color: blue"
				href="${ctx }/admin/forum/catagory.do"> <img
				style="width: 21px; height: 21px" alt="论坛管理" title="论坛管理"
				src="${ctx }/images/forum/images/forum_center.png">
				&nbsp;&nbsp;&nbsp; <!-- <input type="button"
				class="forumManagement" value="论坛管理" /> --></a>

		</c:if>



	</div>



	<c:forEach var="category" items="${ categoryList }">
		<div class="t">
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<th class="h" colspan="6" class="h">
						<%-- <a class="closeicon fr" style="cursor:pointer;" onclick="return IndexDeploy('85',0)">
							<img id="img_85" src="${pageContext.request.contextPath}/images/forum/images/index/cate_fold.gif" /> 
						</a> --%>
						<h2>&raquo; ${ category.name }</h2> <%-- &nbsp;&nbsp; <a
						href="<c:url value="board_initAdd.do" />?action=initAdd&id=${ category.id }">
							<img id="img_85"
							src="${pageContext.request.contextPath}/images/forum/images/index/home.gif" /> --%>
						</a>
					</th>
				</tr>
				<tr class="tr2">
					<td width="*" colspan="2" class="tac">板块</td>
					<td class="tal y-style e" style="width: 5%">帖子</td>
					<td class="tal y-style e" style="width: 5%">回复</td>
					<td class="tal y-style f" style="width: 30%">最后发表</td>
					<!-- <td class="y-style" style="width: 10%">版主</td> -->
					<td class="y-style" style="width: 20%">最后活跃</td>
				</tr>
				<tbody id="cate_85" style="display:;">
					<c:forEach var="board" items="${ category.boardList }">
						<tr class="tr3 f_one">
							<td class="icon tac" width="45"><a
								href="<c:url value="board_list.do" />?id=${ board.id }"><img
									src="${pageContext.request.contextPath}/images/forum/images/soldier.jpg"
									style="width: 40px; height: 40px" /> </a></td>
							<th><a
								href="<c:url value="board_list.do" />?id=${ board.id }">${board.name }</a>

								<br /> <span class="smalltxt gray">${ board.description }</span>
							</th>
							<td class="tal y-style e"><span class="f10">${ board.threadcount }</span>
								<br /></td>
							<td class="tal y-style e"><span class="f10">${ board.replycount }</span>
								<br /></td>

							<th><c:if test="${ board.lastThread != null }">
									<a
										href="<c:url value="thread_list.do" />?id=${ board.lastThread.id }"
										class="a2">${ board.lastThread.title }</a>
									<%-- <span class="f12"> <a href="<c:url value="person_view.do" />?id=${ board.lastThread.author.id }">${board.lastThread.author.account }</a></span>
									<span class="f9 gray"> <fmt:formatDate value="${ board.lastThread.datecreated }" pattern="yyyy-MM-dd hh:mm:ss" />
									</span> --%>
								</c:if> <c:if test="${ board.lastReply != null }">
									<a
										href="<c:url value="thread_list.do" />?id=${ board.lastReply.thread.id }&reply.id=${ board.lastReply.id }"
										class="a2">${ board.lastReply.title }</a>
									<br />
									<span class="f12"> <a
										href="<c:url value="person_view.do" />?id=${ board.lastReply.author.id }">${board.lastReply.author.name }</a></span>
									<span class="f9 gray">${ board.lastReply.datecreated }</span>
								</c:if> &nbsp;</th>
							<%-- 	<td class="y-style"
								style="word-break: keep-all; word-wrap: no-wrap"><c:forEach
									var="person" items="${ board.administrators }">
									<a href="<c:url value="person_view.do" />?id=${ person.id }">${person.account }</a>
								</c:forEach> &nbsp;
							</td> --%>

							<td class="y-style"
								style="word-break: keep-all; word-wrap: no-wrap"><c:if
									test="${ board.lastThread != null }">
									<span class="f12"> <a
										href="<c:url value="person_view.do" />?id=${ board.lastThread.author.id }">${board.lastThread.author.name }</a></span>
									<br />
									<span class="f9 gray"> <fmt:formatDate
											value="${ board.lastThread.datecreated }"
											pattern="yyyy-MM-dd hh:mm:ss" />
									</span>
								</c:if></td>
						</tr>
					</c:forEach>
					<tr>
						<td class="f_one" colspan="6" style="height: 8px"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:forEach>
</div>

<script>
	var mainHeight = $("#main").height();
	var bodyHeight = document.body.clientHeight;
	if (mainHeight < bodyHeight) {
		$("#main").css("height", bodyHeight);
	}
</script>



<jsp:include flush="true" page="../footer.jsp"></jsp:include>

