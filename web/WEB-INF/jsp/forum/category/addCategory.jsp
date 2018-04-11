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
	<div class="t" style="margin-bottom: 20px; border-bottom: 0">
		<a href="${ctx }/category_list.do" style="margin-left: 10px">论坛互动</a><span class="sep">&gt;</span><a
			href="${ctx }/admin/forum/catagory.do">分类管理</a><span class="sep">&gt;</span>添加类别

		<!-- <table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h"><strong class="fl w"><b>添加类别</b></strong></th>
			</tr>
		</table> -->
	</div>

	<%-- <form:form action="category_add.do" commandName="category"
		method="post" onsubmit="return check()">
		<input type="hidden" name="action" value="add">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout: fixed; border-top: 0">
				<tr class="tr1 r_one">
					<th
						style="width: 10%; background: #fff; border-bottom: 0.1px solid #F0F0EE; border-right: 0px solid #F0F0EE;padding-left: 10px"
						class="r_two">名称:</th>
					<th
						style="vertical-align: bottom; padding-left: 15px; border: 0; border-bottom: 0.1px solid #F0F0EE;">
						<form:input id="name" path="name" style="width:200px" />

					</th>
				</tr>
				<tr>
					<td colspan="2"><input id="submit" type="submit" value="提交"
						style="margin-left: 230px; color: #fff; background: #60BEFC; padding: 0 32px; height: 30px; cursor: pointer; display: inline; font-family: inherit; font-size: inherit; font-style: inherit; font-weight: inherit; margin-top: 20px;">
					</td>
				</tr>

			</table>
		</div>
	</form:form> --%>
	
	<!-- category_add.do -->
	
		
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout: fixed; border-top: 0">
				<tr class="tr1 r_one">
					<th
						style="width: 10%; background: #fff; border-bottom: 0.1px solid #F0F0EE; border-right: 0px solid #F0F0EE;padding-left: 10px"
						class="r_two">名称:</th>
					<th
						style="vertical-align: bottom; padding-left: 15px; border: 0; border-bottom: 0.1px solid #F0F0EE;">
						<input id="name" path="name" style="width:200px" />

					</th>
				</tr>
				<tr>
					<td colspan="2"><input id="submit" type="button" value="提交" onclick="addCategory()"
						style="margin-left: 230px; color: #fff; background: #60BEFC; padding: 0 32px; height: 30px; cursor: pointer; display: inline; font-family: inherit; font-size: inherit; font-style: inherit; font-weight: inherit; margin-top: 20px;">
					</td>
				</tr>

			</table>
		
	
	
	
</div>

<script>

function addCategory() {
	var name = $("#name").val();
	var jsonStr = {"name": name};
	$.post(
		"category_add.do", jsonStr,	function(data) {
			if (data.res == 0) {
				alert("请添加类别");
			}
			if (data.res == 2) {
				alert("类别已存在！");
			}
			if (data.res == 1) {
				alert("添加成功");
			}
		}, "json"
	);
	location.href = location.href;
	
}

</script>



<script>
	var adaptHeight = $(document).height() + "px";
	document.getElementById("main").style.height = adaptHeight;
</script>

<script>
	function check() {

		var value = document.getElementById("name").value;
		if (value == "") {
			alert("请输入类别");
			return false;
		}
		return true;
	}
</script>


<jsp:include flush="true" page="../footer.jsp" />
