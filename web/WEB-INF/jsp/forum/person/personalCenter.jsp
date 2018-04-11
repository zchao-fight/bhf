<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include flush="true" page="../header.jsp"></jsp:include>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript"
	src="${ctx }/js/My97DatePicker/WdatePicker.js">

</script>
<script type="text/javascript" src="${ctx }/js/jquery.min.js">

</script>


<style>
.tabContent {
	margin: 10px 0 0 10px;
	color: #474747;
	display: none
}

.side-menu li.active {
	background: #5dcfff;
	border: 1px solid #5dcfff;
}

div.selectTab {
	display: block
}

.content {
	width: 1200px;
	margin-left: auto;
	margin-right: auto;
}

a {
	text-decoration: none;
	color: #37393b;
	background-color: transparent;
	-webkit-text-decoration-skip: objects;
}

}
ol, ul, li {
	list-style: none;
}

.content .sidebar {
	float: left;
	width: 200px;
	background-color: #F5F5F5;
}

.content .sidebar li {
	width: 240px
}

#tabContent {
	margin-left: 260px;
}

input.noBorder {
	border: none;
}

.barcon {
	width: 1100px;
	margin: 0 auto;
	text-align: center;
}

.barcon1 {
	font-size: 14px;
	float: left;
	margin-top: 20px;
}

.barcon2 {
	float: right;
	margin-right: 200px;
}

.barcon2 ul {
	margin: 20px 0;
	padding-left: 0;
	list-style: none;
	text-align: center;
}

.barcon2 li {
	display: inline;
}

.barcon2 a {
	font-size: 14px;
	font-weight: normal;
	display: inline-block;
	padding: 5px;
	padding-top: 0;
	color: black;
	border: 1px solid #ddd;
	background-color: #fff;
}

.barcon2 a:hover {
	background-color: #eee;
}

.ban {
	opacity: .4;
}

.content .sidebar {
	float: left;
	width: 240px;
	background-color: #F5F5F5;
}

.side-menu li {
	border: 1px solid #dee1e7;
	background: #fafafa;
	margin-bottom: 8px;
}

.side-menu li a {
	display: block;
	line-height: 44px;
	height: 44px;
	padding: 0 20px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

li {
	display: list-item;
	text-align: match-parent;
}

.breadcrumb {
	height: 36px;
	line-height: 36px;
	color: #37393b;
	margin-bottom: 8px;
}

table {
	width: 100%;
}

.table-striped td {
	padding-top: 10px;
	padding-bottom: 10px;
}

#modifyPersonalInfo {
	color: #fff;
	background: #60BEFC;
	padding: 0 32px;
	height: 30px;
	cursor: pointer;
	display: inline;
	font-family: inherit;
	font-size: inherit;
	font-style: inherit;
	font-weight: inherit;
	margin-top: 0px;
	margin-left: 60px;
}

.content {
	margin-bottom: 360px;
}
}
</style>

<div class="content" id="mainContent">
	<div class="breadcrumb">
		<a href="${ctx }/index.action">首页</a><span class="sep">&gt;</span><a
			href="${ctx }/category_list.do">论坛互动</a>
	</div>
	<div class="sidebar">
		<ul id="tabs" class="side-menu" style="margin-right: 200px">

			<li class="active"><a href="javascript:void(0)"
				onclick="selectTab('tabContent0',this)">个人信息</a></li>
			<li><a href="javascript:void(0)"
				onclick="selectTab('tabContent1',this)">我的发帖</a></li>
			<li><a href="javascript:void(0)"
				onclick="selectTab('tabContent2',this)">我的回帖</a></li>
		</ul>
	</div>

	<div id="tabContent">

		<div id="tabContent0" class="tabContent selectTab">

			<table>
				<tr>
					<td width="12%">账号：</td>
					<td><input type="text" value="${ person.account }"
						class="noBorder" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>昵称：</td>
					<td><input type="text" id="name" value="${ person.name }" /></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><select id="sex">
							<c:if test="${person.sex eq '男' }">
								<option value="男">男</option>
								<option value="女">女</option>
							</c:if>
							<c:if test="${person.sex eq '女' }">
								<option value="女">女</option>
								<option value="男">男</option>
							</c:if>
							<c:if test="${empty person.sex}">
								<option value="男">男</option>
								<option value="女">女</option>
							</c:if>
					</select></td>

				</tr>
				<tr>
					<td>电子邮件：</td>
					<td><input id="email" type="text" id="password"
						value="${ person.email }" /></td>
				</tr>
				<tr>
					<td>生日：</td>
					<td><input id="birthday" type="text"
						value="${ person.birthday }" name="HBegtime" class="Wdate"
						onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td><!--  HH:mm -->
				</tr>
				<tr>
					<td>注册时间：</td>
					<td><input type="text" id="password"
						value='<fmt:formatDate value="${ person.datecreated }" pattern="yyyy-MM-dd HH:mm:ss" />'
						class="noBorder" disabled="disabled" /></td>

				</tr>
				<tr>
					<td>上次登录时间：</td>
					<td><input class="noBorder" type="text" id="password"
						value='<fmt:formatDate value="${ person.datelastactived }" pattern="yyyy-MM-dd HH:mm:ss" />'
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input style="margin-left: 70px" id="modifyPersonalInfo" type="button" value="修改" /></td>
				</tr>
			</table>



		</div>

		<div id="tabContent1" class="tabContent">
			<table class="table table-striped">

				<tbody id="adminTbody">

				</tbody>
			</table>
			<div id="barcon" class="barcon">
				<div id="barcon1" class="barcon1"></div>
				<div id="barcon2" class="barcon2">
					<ul>
						<li><a href="###" id="firstPage">首页</a></li>
						<li><a href="###" id="prePage">上一页</a></li>
						<li><a href="###" id="nextPage">下一页</a></li>
						<li><a href="###" id="lastPage">尾页</a></li>
						<li><select id="jumpWhere">
						</select></li>
						<li><a href="###" id="jumpPage" onclick="jumpPage()">跳转</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div id="tabContent2" class="tabContent">

			<table class="table table-striped">

				<tbody id="adminTbody">

				</tbody>
			</table>
			<div id="barcon" class="barcon">
				<div id="barcon1" class="barcon1"></div>
				<div id="barcon2" class="barcon2">
					<ul>
						<li><a href="###" id="firstPage">首页</a></li>
						<li><a href="###" id="prePage">上一页</a></li>
						<li><a href="###" id="nextPage">下一页</a></li>
						<li><a href="###" id="lastPage">尾页</a></li>
						<li><select id="jumpWhere">
						</select></li>
						<li><a href="###" id="jumpPage" onclick="jumpPage()">跳转</a></li>
					</ul>
				</div>
			</div>

		</div>

	</div>

</div>

<jsp:include flush="true" page="../footer.jsp" />
<script type="text/javascript">
	function deleteThread(id) {
		if (confirm("确定要删除吗?")) {
			$.get("${ctx}/admin/forum/deleteThread.do?id=" + id, function(
					result) {
				alert("成功");
				//更新数据
				getMyPostThread();
			});
		}
	}

	function deleteReply(id) {
		if (confirm("确定要删除吗?")) {
			$.get("${ctx}/admin/forum/deleteReply.do?id=" + id,
					function(result) {
						alert("成功");
						//更新数据
						getMyReplyThread();
					});
		}
	}

	function selectTab(thisContent, thisObj) {

		thisObj.blur();

		var tab = document.getElementById("tabs").getElementsByTagName("li");

		var tablength = tab.length;

		for (i = 0; i < tablength; i++) {
			tab[i].className = "";
		}

		thisObj.parentNode.className = "active";

		for (i = 0; j = document.getElementById("tabContent" + i); i++) {
			j.style.display = "none";
		}

		document.getElementById(thisContent).style.display = "block";

		var tabName = document.getElementById(thisContent).getAttribute("id");
		switch (tabName) {
		case "tabContent0":
			break;
		case "tabContent1":
			getMyPostThread();

			break;
		case "tabContent2":
			getMyReplyThread();
			break;
		default:
			break;
		}

	}

	$("#modifyPersonalInfo").click(function() {

		var name = $("#name").val();
		var sex = $("#sex").val();
		var email = $("#email").val();
		var birthday = $("#birthday").val();

		var data = {
			"name" : name,
			"sex" : sex,
			"email" : email,
			"birthday" : birthday
		}

		$.ajax({
			type : 'POST',
			url : "${ctx}/modifyPersonalInfo.do",
			dataType : 'json',
			contentType : "application/json",
			data : JSON.stringify(data),
			success : function(result) {
				alert("修改成功");
			},
			error : function(xhr, type) {
				alert('数据加载失败');
			}
		});

	});

	function getMyPostThread() {
		$
				.ajax({
					type : 'POST',
					url : "${ctx}/getMyPostThread.do",
					contentType : "application/json",
					success : function(data) {
						tableList = '<tr><td>标题</td><td>点击</td><td>回复</td><td>创建时间</td><td>操作</td></tr>';
						$
								.each(
										data,
										function(i, item) {
											tableList += '<tr>'
													+ '<td width="40%"><a href=thread_list.do'
													+ '?id='
													+ item.id
													+ '>'
													+ item.title
													+ '</a></td><td width="15%">'
													+ item.hit
													+ '</td><td width="15%">'
													+ item.replycount
													+ '</td><td width="25%">'
													+ item.datecreated
													+ '</td><td width="5%"><a  onclick="deleteThread('
													+ item.id
													+ ')"><img style="height:20px;width:20px" title="删除"  src="${ctx }/images/forum/images/thread/delete.png"></a></td></tr>';
										});

						$('#tabContent1').find('tbody').html(tableList);

						goPage(1, 10);
					},
					error : function() {
						alert("查询失败");
					}

				});
	}

	function getMyReplyThread() {

		$
				.ajax({
					type : 'POST',
					url : "${ctx}/getMyReplyThread.do",
					contentType : "application/json",
					success : function(data) {
						tableList = '';
						tableList = '<tr><td>标题</td><td>回复内容</td><td>回复时间</td><td>操作</td></tr>';
						$
								.each(
										data,
										function(i, item) {
											var date = new Date(
													item.datecreated);
											var localDate = date
													.format("yyyy-MM-dd hh:mm:ss");

											tableList += '<tr>'
													+ '<td width="30%" ><a href=thread_list.do'
													+ '?id='
													+ item.thread_id
													+ '>'
													+ item.title
													+ '</a></td><td width="45%" >'
													+ item.content
													+ '</td><td width="20%">'
													+ localDate
													+ '</td><td width="5%"><a onclick="deleteReply('
													+ item.id
													+ ')"><img style="height:20px;width:20px" title="删除"  src="${ctx }/images/forum/images/thread/delete.png"></a></td></tr>';
										});

						$('#tabContent2').find('tbody').html(tableList);
						goPage(1, 10);

					},
					erro : function() {
						alert("查询失败");
					}

				});
	}

	// 对Date的扩展，将 Date 转化为指定格式的String
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
	// 例子：
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
	Date.prototype.format = function(fmt) {
		var o = {
			"M+" : this.getMonth() + 1, //月份
			"d+" : this.getDate(), //日
			"h+" : this.getHours(), //小时
			"m+" : this.getMinutes(), //分
			"s+" : this.getSeconds(), //秒
			"q+" : Math.floor((this.getMonth() + 3) / 3), //季度
			"S" : this.getMilliseconds()
		//毫秒
		};
		if (/(y+)/.test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		}
		for ( var k in o) {
			if (new RegExp("(" + k + ")").test(fmt)) {
				fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
						: (("00" + o[k]).substr(("" + o[k]).length)));
			}
		}
		return fmt;
	}
</script>


<script>
	/**
	 * 分页函数
	 * pno--页数
	 * psize--每页显示记录数
	 * 分页部分是从真实数据行开始，因而存在加减某个常数，以确定真正的记录数
	 * 纯js分页实质是数据行全部加载，通过是否显示属性完成分页功能
	 **/

	var pageSize = 0;//每页显示行数
	var currentPage_ = 1;//当前页全局变量，用于跳转时判断是否在相同页，在就不跳，否则跳转。
	function goPage(pno, psize) {
		var itable = document.getElementById("adminTbody");
		var num = itable.rows.length;//表格所有行数(所有记录数)

		pageSize = psize;//每页显示行数
		//总共分几页
		if (num / pageSize > parseInt(num / pageSize)) {
			totalPage = parseInt(num / pageSize) + 1;
		} else {
			totalPage = parseInt(num / pageSize);
		}
		var currentPage = pno;//当前页数
		currentPage_ = currentPage;
		var startRow = (currentPage - 1) * pageSize + 1;
		var endRow = currentPage * pageSize;
		endRow = (endRow > num) ? num : endRow;
		//遍历显示数据实现分页
		for (var i = 1; i < (num + 1); i++) {
			var irow = itable.rows[i - 1];
			if (i >= startRow && i <= endRow) {
				irow.style.display = "";
			} else {
				irow.style.display = "none";
			}
		}
		//我多减了1，因为我把表头也算一行了
		var tempStr = "共" + (num - 2) + "条记录 分" + totalPage + "页 当前第"
				+ currentPage + "页";
		document.getElementById("barcon1").innerHTML = tempStr;

		if (currentPage > 1) {
			$("#firstPage").on("click", function() {
				goPage(1, psize);
			}).removeClass("ban");
			$("#prePage").on("click", function() {
				goPage(currentPage - 1, psize);
			}).removeClass("ban");
		} else {
			$("#firstPage").off("click").addClass("ban");
			$("#prePage").off("click").addClass("ban");
		}

		if (currentPage < totalPage) {
			$("#nextPage").on("click", function() {
				goPage(currentPage + 1, psize);
			}).removeClass("ban")
			$("#lastPage").on("click", function() {
				goPage(totalPage, psize);
			}).removeClass("ban")
		} else {
			$("#nextPage").off("click").addClass("ban");
			$("#lastPage").off("click").addClass("ban");
		}
		var tempOption = "";
		for (var i = 1; i <= totalPage; i++) {
			tempOption += '<option value='+i+'>' + i + '</option>'
		}
		$("#jumpWhere").html(tempOption);
		$("#jumpWhere").val(currentPage);
	}

	function jumpPage() {
		var num = parseInt($("#jumpWhere").val());
		console.log(pageSize);
		if (num != currentPage_) {
			goPage(num, pageSize);
		}
	}
</script>


<script>
	var adaptHeight = $(document).height() + "px";
	document.getElementById("mainContent").style.height = adaptHeight;
</script>

