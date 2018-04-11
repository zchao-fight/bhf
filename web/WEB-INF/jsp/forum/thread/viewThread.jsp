<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include flush="true" page="../header.jsp"></jsp:include>
<style>
b {
	font-weight: normal;
}
</style>

<div id="main" style="width: 1100px">
	<div class="t3">
		<table cellspacing="0" cellpadding="0" width="100%" align="center">
			<tr>
				<td style="text-align: left;padding-bottom:10px" id="myFirstTD" ><img
					src="${pageContext.request.contextPath}/images/forum/images/index/home_menu.jpg"
					align="absbottom" /> <b> <a
						style="font-size: 16px; font-weight: normal"
						href="<c:url value="category_list.do" />?id=${ thread.board.category.id }">${ thread.board.category.name }</a>
						&raquo; <a style="font-size: 16px; font-weight: normal"
						href="<c:url value="board_list.do" />?id=${ thread.board.id }">${ thread.board.name }</a>
				</b></td>
				<td align="right" style="padding-bottom: .2em"><c:choose>
						<c:when test="${_user.superAdmin }">

							<script type="text/javascript">
								$("#myFirstTD").css("padding-bottom", "10px");
							</script>
						</c:when>
						<c:otherwise>
							<a
								href="<c:url value="reply_initAdd.do" />?action=initAdd&id=${ thread.id }">
								<img src="images/reply.png" />
							</a>
							<a
								href="<c:url value="thread_initAdd.do" />?action=initAdd&id=${ thread.board.id }"
								style="margin-left: .5em"> <img src="images/post.png"
								id="td_post" />
							</a>&nbsp;&nbsp;&nbsp;
					</c:otherwise>

					</c:choose></td>
			</tr>
		</table>
	</div>


	<!-- Thread Start -->


	<c:if test="${ pagination.pageNum == 1 }">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout: fixed; border-top: 0">
				<tr class="tr1">
					<th style="width: 10%" rowspan="2" class="r_two"><b>作者：${ thread.author.name }</b>
						<div class="user-pic">
							<table style="border: 0">
								<tr>
									<td width="1"><a
										href="<c:url value="person_view.do" />?id=${ thread.author.id }"
										target="_blank" style="cursor: pointer;"> <img class="pic"
											src="${ctx }/images/forum/images/soldier.jpg" width="100"
											height="100" border="0" />
									</a></td>
								</tr>
							</table>
						</div></th>
					<th height="100%" class="r_one" valign="top" id="td_4900235"
						style="padding: 5px 15px 0 15px; border: 0; width: 80%; overflow: hidden">
						<div class="tiptop">
							<span class="fr" style="margin: 0 0 0 1em"><a
								style="cursor: pointer" onclick="fontsize('small','4900235')">小</a>
								<a style="cursor: pointer"
								onclick="fontsize('middle','4900235')">中</a> <a
								style="cursor: pointer" onclick="fontsize('big','4900235')">大</a>
							</span><!--  <span class="fl" style="white-space: nowrap;"> 引用 推荐 编辑
								只看 </span> -->
							<div class="c"></div>
						</div>
						<h1 id="subject_4900235" class="fl">&nbsp;</h1>

						<div id="p_4900235" class="c"></div>

						<div class="tpc_content" id="read_4900235">${ thread.content }
						</div>
					</th>
				</tr>
				<tr class="tr1 r_one">
					<th style="vertical-align: bottom; padding-left: 15px; border: 0">

						<div id="w_4900235" class="c"></div>

						<div class="tipad">
							<span style="float: right"> <a
								href="javascript:scroll(0,0)" title="顶端">顶端</a>
							</span> <span class="gray">发布于:<fmt:formatDate
									value="${ thread.datecreated }" pattern="yyyy-MM-dd HH:mm:ss" />
								|
							</span> <span><a class="s3">原帖</a> </span>
						</div>
					</th>
				</tr>
			</table>
		</div>
	</c:if>

	<!-- Thread End -->

	<!-- Reply Start -->


	<c:forEach var="reply" items="${ replyList }">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout: fixed; border-top: 0">
				<tr class="tr1">
					<th style="width: 10%" rowspan="2" class="r_two"><b>作者：${ reply.author.name }</b>
						<div class="user-pic">
							<table style="border: 0">
								<tr>
									<td width="1"><a
										href="<c:url value="person_view.do" />?id=${ reply.author.id }"
										target="_blank" style="cursor: pointer;"> <img class="pic"
											src="${ctx }/images/forum/images/soldier.jpg" width="100"
											height="100" border="0" />
									</a></td>
								</tr>
							</table>
						</div></th>
					<th height="100%" class="r_one" valign="top" id="td_4900235"
						style="padding: 5px 15px 0 15px; border: 0; width: 80%; overflow: hidden">
						<div class="tiptop">
							<span class="fr" style="margin: 0 0 0 1em"><a
								style="cursor: pointer" onclick="fontsize('small','4900235')">小</a>
								<a style="cursor: pointer"
								onclick="fontsize('middle','4900235')">中</a> <a
								style="cursor: pointer" onclick="fontsize('big','4900235')">大</a>
							</span>
							 <!-- <span class="fl" style="white-space: nowrap;"> 引用 推荐 编辑
								只看 </span> -->
							<div class="c"></div>
						</div>
						<h1 id="subject_4900235" class="fl">&nbsp;</h1>

						<div id="p_4900235" class="c"></div>

						<div class="tpc_content" id="read_4900235">${ reply.content }
						</div>
					</th>
				</tr>
				<tr class="tr1 r_one">
					<th style="vertical-align: bottom; padding-left: 15px; border: 0">

						<div id="w_4900235" class="c"></div>

						<div class="tipad">
							<span style="float: right"> <a
								href="javascript:scroll(0,0)" title="顶端">顶端</a>
							</span> <span class="gray">发布于: <fmt:formatDate
									value="${ reply.datecreated }" pattern="yyyy-MM-dd HH:mm:ss" />|
							</span> <span><a class="s3">${ reply.floor } 楼</a> </span>
						</div>
					</th>
				</tr>
			</table>
		</div>
	</c:forEach>


	<c:if test="${ replyList.size() <= 5}">
		<div class="t3" style="margin-bottom: 200px">
			<table width="100%" align="center" cellspacing="0" cellpadding="0">
				<tr>
					<td align="left"
						style="margin-top: 5px; float: right; margin-right: 10px">
						<div class="fl">
							<div class="pages">${ pagination }</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<script>
			var adaptHeight = $(document).height() + "px";
			document.getElementById("main").style.height = adaptHeight;
		</script>
	</c:if>
	<c:if test="${ replyList.size() > 6}">
		<div class="t3">
			<table width="100%" align="center" cellspacing="0" cellpadding="0">
				<tr>
					<td align="left"
						style="margin-top: 5px; float: right; margin-right: 10px">
						<div class="fl">
							<div class="pages">${ pagination }</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</c:if>

</div>
<!-- Reply End -->


<script>
	function fontsize(size, obj) {

		if (size == "small") {
			$(".tpc_content").css("font-size", "14px");
		} else if (size == "middle") {
			$(".tpc_content").css("font-size", "18px");
		} else {
			$(".tpc_content").css("font-size", "22px");
		}
	}
</script>


<jsp:include flush="true" page="../footer.jsp" />
