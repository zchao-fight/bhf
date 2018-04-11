<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<jsp:include flush="true" page="../header.jsp"></jsp:include>
<style>
.sep {
	margin: 0 5px;
	color: #a8aeb2;
	font-family: "5B8B\4F53";
}
</style>

<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom: 20px; border-bottom: 0;margin-left: 5px">
		<%-- <input type="hidden" id="id" value="${ id }">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h"><strong class="fl w"
					style="font-weight: normal; font-size: 16px">添加版面</strong> &nbsp; <span
					style="color: red; font-weight: bold;">${message }</span></th>
					
				
			</tr>
		</table> --%>
		<a href="${ctx }/category_list.do">论坛互动</a><span class="sep">&gt;</span><a
			href="${ctx }/admin/forum/catagory.do">分类管理</a><span class="sep">&gt;</span><a
			href="${ctx }/admin/forum/catagory.do">板块: ${ category.name}</a>
	</div>


<%-- 	<form:form action="board_add.do" commandName="board" method="post"
		onsubmit="return check()">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout: fixed; border-top: 0">
				<tr class="tr3">
					<td style="width: 120px;">类别:<form:input id="categoryId"
							path="categoryId" value="${ category.id}"
							style="visibility:hidden;width:5px" />
					</td>
					<td>
						<form:select path="categoryId" id="categoryId" >
							<c:forEach items="${ categoryList }" var="category">
								<form:option value="${ category.id }" label="${ category.name} "></form:option>
							</c:forEach>
						</form:select> <label>${ category.name}</label>

					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px;">名称:</td>
					<td><form:input id="name" path="name" style="width:500px" /></td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px;">描述:</td>
					<td><form:textarea id="description" path="description"
							style="width:500px;height:100px" /></td>
				</tr>

				<tr>
					<!-- class="tr3"  -->
					<td colspan="2" style="padding-top: 20px; padding-left: 535px">
						<input id="submit" type="submit" value="添加"
						style="color: #fff; background: #60BEFC; padding: 0 32px; height: 30px; cursor: pointer; display: inline; font-family: inherit; font-size: inherit; font-style: inherit; font-weight: inherit; margin-top: 0px;">
					</td>
				</tr>

			</table>
		</div>
	</form:form> --%>
	
	
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout: fixed; border-top: 0">
				<tr class="tr3">
					<td style="width: 120px;">
						类别:<input id="categoryId" path="categoryId" value="${ category.id}" style="visibility:hidden;width:5px" />
					</td>
					<td>
						<label>${ category.name}</label>

					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px;">名称:</td>
					<td><input id="name" style="width:500px" /></td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px;">描述:</td>
					<td><textarea id="description"  style="width:500px;height:100px" ></textarea></td>
				</tr>

				<tr>
					<!-- class="tr3"  -->
					<td colspan="2" style="padding-top: 20px; padding-left: 535px">
						<input id="submit" type="button" value="添加" onclick="addBoard()"
						style="color: #fff; background: #60BEFC; padding: 0 32px; height: 30px; cursor: pointer; display: inline; font-family: inherit; font-size: inherit; font-style: inherit; font-weight: inherit; margin-top: 0px;">
					</td>
				</tr>

			</table>
		</div>
</div>
<script>
function addBoard() {
	
	var temp1 = $("#categoryId").val();
	var temp2 = $("#name").val();
	var temp3 = $("#description").val();
	
	var jsonStr = {"categoryId":temp1, "name":temp2, "description":temp3};
	$.post("board_add.do",jsonStr,function(data) {
		if (data.res == 0) {
			alert("请输入名称");
		}
		if (data.res == 1) {
			alert("添加成功");
		}
		
	}, "json" );
	location.href = location.href;
}
	
</script>

<script>
	var adaptHeight = $(document).height() + "px";
	document.getElementById("main").style.height = adaptHeight;
</script>

<script>
	function check() {
		var name = document.getElementById("name").value;
		if (name == "") {
			alert("名称不能为空");
			return false;
		}
		return true;
	}
</script>

<jsp:include flush="true" page="../footer.jsp" />
