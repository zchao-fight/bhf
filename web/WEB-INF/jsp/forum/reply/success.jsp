<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include flush="true" page="../header.jsp"></jsp:include>


<div id="main" style="height:1050px">
	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">发表成功</strong>
				</th>
			</tr>
		</table>
	</div>

	<div class="t t2">
		<table cellspacing="0" cellpadding="0" width="100%"
			style="table-layout:fixed;border-top:0">
			<tr class="tr1">
				<th>
					<a href="<c:url value="thread_view.do" />?id=${ thread.id }">回到刚刚回复的帖子</a>
				</th></tr>
		</table>
	</div>
</div>

<jsp:include flush="true" page="../footer.jsp" />