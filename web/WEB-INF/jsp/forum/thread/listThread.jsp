<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<body>
	<jsp:include flush="true" page="../header.jsp"></jsp:include>

	<div id="main" style="width: 1100px">
		<div class="t3" style="margin: 8px auto">
			<table width="100%" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td><strong class="fl w"> <img
							src="${pageContext.request.contextPath}/images/forum/images/index/home_menu.jpg"
							align="absmiddle" id="td_cate"
							style="cursor: pointer;" /> <a
							href="<c:url value="category_list.do" />?id=${ board.category.id }"
							style="font-size: 16px; font-weight: normal">${board.category.name }</a>
							&raquo; <a
							href="<c:url value="board_list.do" />?id=${ board.id }"
							style="font-size: 16px; font-weight: normal">${ board.name }</a>
					</strong>
						<div class="fr w">
							<%-- <a href="<c:url value="board_initSetAdmin.do" />?id=${ board.id }&action=initAdd">版主</a>:
						&nbsp;
						<c:forEach items="${ board.administrators }" var="person">
							<a href="<c:url value="person_view.do" />?id=${ person.id }">${person.account }</a>
						</c:forEach> --%>

							<c:choose>
								<c:when test="${_user.superAdmin }">

								</c:when>
								<c:otherwise>
									<a
										href="<c:url value="/thread_initAdd.do" />?action=initAdd&id=${ board.id }">
										<img
										src="${pageContext.request.contextPath}/images/forum/images/post.png"
										id="td_post" />
									</a> &nbsp;&nbsp;&nbsp;
							</c:otherwise>
							</c:choose>

						</div></td>
				</tr>
			</table>
		</div>

		<div class="c"></div>

		<div class="t z" style="margin: 3px auto">
			<table cellspacing="0" cellpadding="0" width="100%" id="ajaxtable">
				<%-- <tr>
				<th class="h" colspan="6">
					<a href="<c:url value="board_list.do" />?id=${ board.id }">${board.name }</a>
				</th>
			</tr> --%>
				<tbody style="table-layout: fixed;">
					<tr></tr>
					<tr class="tr2">
						<!-- <td  class="tac y-style">状态</td> -->
						<td style="width: 30%" class="tac">文章</td>
						<td style="width: 27%" class="y-style">作者</td>
						<td style="width: 6%" class="y-style">回复</td>
						<td style="width: 6%" class="y-style">人气</td>
						<td style="width: 20%" class="y-style">最后回复</td>
						<%-- <!-- 管理员操作 -->
						<c:if test="${_user.admin || _user.superAdmin}">
							<td class="y-style">操作</td>
						</c:if> --%>
						<c:if test="${_user.onAndCancel == 1 || _user.deleteThread == 1 ||  _user.superAdmin}">
							<td class="y-style">操作</td>
						</c:if> 
					</tr>

					<c:forEach var="thread" items="${ threadList }">
						<tr align="center" class="tr3 t_one">
							<%-- <td><a title="打开新窗口"
								href="<c:url value="thread_list.do" />?id=${ thread.id }"
								target="_blank"> <img
									src="${pageContext.request.contextPath}/images/forum/images/thread/topichot.gif"
									border=0>
							</a></td> --%>
							<td style="text-align: left; padding-left: 18px" id="td_579742">
								<h3>
									<a href="<c:url value="thread_list.do" />?id=${ thread.id }">
										<c:if test="${thread.topped eq true }">
											<span style="margin-left: -10px">【置顶】${thread.title }</span>
										</c:if> <c:if test="${thread.topped eq false }">${thread.title }</c:if>


									</a>
								</h3>
							</td>
							<td class="tal y-style"><a
								href="<c:url value="person_view.do" />?id=${ thread.author.id }"
								class="bl">${ thread.author.name }</a>
								<div class="f10">
									<fmt:formatDate value="${thread.datecreated }"
										pattern="yyyy-MM-dd HH:mm:ss" />
								</div></td>
							<td class="tal f10 y-style">${ thread.replycount }</td>
							<td class="tal f10 y-style">${ thread.hit }</td>
							<td class="tal y-style">&nbsp; <c:if
									test="${ thread.authorLastReplied != null }">
									<a
										href="<c:url value="person_view.do" />?id=${ thread.authorLastReplied.id }"
										class="bl">${ thread.authorLastReplied.name }</a>
									<div class="f10">
										<fmt:formatDate value="${thread.datelastreplied }"
											pattern="yyyy-MM-dd HH:mm:ss" />
									</div>
								</c:if>
							</td>

<c:if test="${_user.onAndCancel == 1 || _user.deleteThread == 1 ||  _user.superAdmin}">					
								<td width="10%" class="y-style" colspan="2">
								<c:if test="${_user.onAndCancel == 1 ||  _user.superAdmin}">
									<c:if test="${!thread.topped}">
										
										<a href="javascript:void(0)" onclick="setTop(${thread.id})"><img
											style="height: 20px; width: 20px" title="置顶"
											src="${ctx }/images/forum/images/thread/onTopThread.png"></img></a>
									</c:if> 
									<c:if test="${thread.topped}">
										<a href="javascript:void(0)"
											onclick="cancelSetTop(${thread.id})"><img
											style="height: 20px; width: 20px" title="取消置顶"
											src="${ctx }/images/forum/images/thread/cancelTopThread.png"></img></a>
									</c:if> 
									</c:if>
								<c:if test="${_user.deleteThread == 1 ||  _user.superAdmin}">
									<a style="padding: 5px" href="javascript:void(0)"
									onclick="deleteThread(${thread.id})"> <img
										style="height: 20px; width: 20px" title="删除"
										src="${ctx }/images/forum/images/thread/delete.png"></img>
								</a>
								
								</c:if>
								</td>
</c:if>

						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" class="f_one" style="height: 8px"></td>
					</tr>
				</tbody>
			</table>
		</div>


		<c:if test="${ threadList.size() < 20 }">

			<div class="t3">
				<table width="100%" align="center" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left" valign="middle"
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

		<c:if test="${ threadList.size() >= 20 }">

			<div class="t3">
				<table width="100%" align="center" cellspacing="0" cellpadding="0">
					<tr>
						<td align="left" valign="middle"
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



	<jsp:include flush="true" page="../footer.jsp" />



	<script type="text/javascript">
		function setTop(id){
			if(confirm("确定要置顶吗?")){
				 $.get("${ctx}/admin/forum/threadSetTop.do?id="+id, function(result){
					    alert("成功");
					    location.href =location.href ; 
				 });
			}
		}
		
		function cancelSetTop(id){
			if(confirm("确定要取消置顶吗?")){
				 $.get("${ctx}/admin/forum/threadCancelSetTop.do?id="+id, function(result){
					    alert("成功");
					    location.href =location.href ; 
				 });
			}
		}
		
		function deleteThread(id){
			if(confirm("确定要删除吗?")){
				 $.get("${ctx}/admin/forum/deleteThread.do?id="+id, function(result){
					    alert("成功");
					    location.href =location.href ; 
				 });
			}
		}
		

	</script>


</body>
