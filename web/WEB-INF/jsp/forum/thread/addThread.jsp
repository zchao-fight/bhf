<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include flush="true" page="../header.jsp"></jsp:include>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<style>
td a {
	font-size: 16px;
	font-weight: normal;
}
b {
	font-weight: normal;
}
</style>

<!-- TinyMCE -->
<script type="text/javascript" src="tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
	tinyMCE
			.init({
				// General options
				mode : "textareas",
				theme:"advanced",
				
				plugins : "safari,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",
				theme_advanced_toolbar_location : "top",
				theme_advanced_toolbar_align : "left",
				theme_advanced_statusbar_location : "bottom",
				theme_advanced_resizing : true,
				// Theme options
				/* theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
				theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
				theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
				theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak", */
				theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
				theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
				theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
				// Example content CSS (should be your site CSS)
				content_css : "${ctx}/tiny_mce/content.css",

				// Drop lists for link/image/media/template dialogs
				template_external_list_url : "lists/template_list.js",
				external_link_list_url : "lists/link_list.js",
				external_image_list_url : "lists/image_list.js",
				media_external_list_url : "lists/media_list.js",
				
				// Replace values for the template plugin
				template_replace_values : {
					username : "YunNan",
					staffid : "991234"
				}
				
			});
</script>

<div id="main">

	<div class="t3">
		<table cellspacing="0" cellpadding="0" width="100%" align="center">
			<tr>
				<td style="padding-top: 12px; text-align: left;"><img
					src="${pageContext.request.contextPath }/images/forum/images/index/home_menu1.jpg" align="absbottom" /> <b> <a
						href="<c:url value="category_list.do" />?id=${ board.category.id }">${board.category.name }</a>
						&raquo; <a href="<c:url value="board_list.do" />?id=${ board.id }">${board.name }</a>
				</b></td>
				<td align="left">
					<div class="fl">
						<div class="pages">${ pagination }</div>
					</div>
				</td>
				<td align="right" style="padding-bottom: .2em"><a
					href="<c:url value="thread_initAdd.do" />?action=initAdd&id=${ board.id }"
					style="margin-left: .5em"><img src="images/post.png"
						id="td_post" /> </a> &nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>
		<br />
	</div>

	<%-- <div class="t3">
		<table width="100%" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left">
					<div class="fl">
						<div class="pages">${ pagination }</div>
					</div>
				</td>
				<td align="right" style="padding-bottom: .2em"><a
					href="<c:url value="thread_initAdd.do" />?action=initAdd&id=${ board.id }"
					style="margin-left: .5em"><img src="images/post.png"
						id="td_post" /> </a></td>
			</tr>
		</table>
	</div> --%>

	<form:form action="thread_add.do" commandName="thread" method="post" onsubmit="return check()">
		<!-- Thread Start -->
		<form:hidden path="boardId" />
		<div class="t" style="margin-bottom: 0px; border: 0">
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<th class="h"
						style="background: #F0F0EE none repeat scroll 0 0; border: 0"><strong
						class="fl w"><b>发表帖子</b> </strong></th>
				</tr>
			</table>
		</div>

		<div class="t t2" style="boder: 0">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout: fixed; border-top: 0">
				<tr class="tr1">
					<th
						style="padding-left:30px;width: 10%; background: #F8F8F8 none repeat scroll 0 0; border-right: 0px solid #e1d5aa;"
						class="r_two">标&nbsp;&nbsp;题：</th>
					<th height="100%" class="r_one" valign="top" id="td_4900235"
						style="padding: 5px 15px 0 -15px; border: 0; width: 80%; overflow: hidden;">
						<form:input style="width:100%;text-align: left;font-size: 15px" path="title" id="title" />
					</th>
				</tr>
				<tr class="tr1 r_one">
					<th 
						style="padding-left:30px;width: 10%; background: #F8F8F8 none repeat scroll 0 0; float: none; border: 0;"
						class="r_two">内&nbsp;&nbsp;容：</th>
					<th style="vertical-align: bottom; padding-left: 0px; border: 0">
						<form:textarea style="width:100%;height:400px" id="content"
							path="content" />
					</th>
				</tr>
				<tr>
					<td style="background: #F8F8F8 none repeat scroll 0 0; width: 10%;">
						<!-- 占位 -->
						<span hidden="true">占位</span>
					</td>
					<td ><span
						style="float: left; color: #8A8A8A; margin-top: 0px; font-size: 14px; padding-left: 0px">请遵守德宏边防言论规则，不得违反国家法律法规</span>
						<input type="submit"
						style="color: #fff; background: #60BEFC;  padding: 0 32px; height: 30px; cursor: pointer; float: right; display: inline; font-family: inherit; font-size: inherit; font-style: inherit; font-weight: inherit; margin-top: 0px;
						margin-right:2px"
						value="发 &nbsp;表"></td>
				</tr>
			</table>
		</div>
	</form:form>
</div>


<script>

function sleep(numberMillis) {    
	var now = new Date();    
	var exitTime = now.getTime() + numberMillis;   
	while (true) { 
	now = new Date();       
	if (now.getTime() > exitTime) 
	return;    
	} 
}
</script>
<%-- <div>
	<c:if test="${flag }">
		<script type="text/javascript">
			sleep(100);
			alert("请输入内容");
		</script>
	</c:if>
</div> --%>
<jsp:include flush="true" page="../footer.jsp" />

<script>
function check() {
	
	var title =  document.getElementById("title").value;
	if (title == "") {
		alert("请输入帖子标题");
		return false;
	}
	var content = tinyMCE.get('content').getContent();
	if (content == "") {
		alert("请输入帖子内容");
		return false;
	}
	return true;
}
	
</script>

<script>
var mainHeight = $("#main").height();
var screenHeight = window.screen.availHeight;
if (mainHeight < screenHeight) {
	$("#main").css("height", screenHeight);
}

</script>
