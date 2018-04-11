<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include flush="true" page="../header.jsp"></jsp:include>


<div id="main" style="margin-bottom:350px">

	<!-- Thread Start -->
	<div class="t t2">
		<table cellspacing="0" cellpadding="0" width="100%"
			style="table-layout:fixed;border-top:0">


			<%-- <tr class="tr3">
				<td style="width: 120px; ">帐号:</td>
				<td>${ person.account }</td>
			</tr> 
			<tr class="tr3">
				<td>姓名:</td>
				<td>${ person.name } &nbsp;</td>
			</tr>
			--%>
			<tr class="tr3">
				<td>昵称:</td>
				<td>${ person.name } &nbsp;</td>
			</tr>
			<tr class="tr3">
				<td>性别:</td>
				<td>${ person.sex } &nbsp;</td>
			</tr>
			<tr class="tr3">
				<td>电子邮件:</td>
				<td>${ person.email } &nbsp;</td>
			</tr>
			<tr class="tr3">
				<td>生日:</td>
				<td>${ person.birthday } &nbsp;</td>
			</tr>
			<tr class="tr3">
				<td>注册时间:</td>
				<td><fmt:formatDate value="${ person.datecreated }" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp;</td>
			</tr>
			<tr class="tr3">
				<td>上次登录时间:</td>
				<td><fmt:formatDate value="${ person.datelastactived }" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp;</td>
			</tr>
			<%-- <tr class="tr3">
				<td>负责的版面:</td>
				<td><c:forEach items="${ boardList }"
						var="board">
						<a href="<c:url value="board_list" />?id=${ board.id }">${board.name }</a>
					</c:forEach> &nbsp;</td>
			</tr> --%>
		</table>
	</div>
</div>

<jsp:include flush="true" page="../footer.jsp" />