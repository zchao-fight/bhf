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
<script src="${ctx}/js/jquery.min.js"></script>
<script src="${ctx}/js/jquery.SuperSlide.js"></script>
<script src="${ctx}/js/dropdown.js"></script>

<style type="text/css">
td {
	padding: 5px;
}

#submitAll {
	padding: 0 32px;
	height: 30px;
	cursor: pointer;
	font-family: inherit;
	font-size: inherit;
	font-style: inherit;
	font-weight: inherit;
	margin-top: 30px;
	margin-right: 2px;
}
</style>


</head>
<body>
	<script type="text/javascript">
	function upload() {
		
		
		var fileObj = document.getElementById("filmInput").files[0];
		if(fileObj == undefined){
			alert("请选择影片");
			return;
		}
		console.log(fileObj)
		document.getElementById("progress").style.display = 'block';
		//创建xhr
		var xhr = new XMLHttpRequest();
		var url = "${ctx}/upload/uploadFilmFile.action";
		//FormData对象
		var fd = new FormData();
		fd.append("files", fileObj);
		fd.append("acttime", new Date().toString()); //本人喜欢在参数中添加时间戳，防止缓存（--、）
		xhr.open("POST", url, true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var result = xhr.responseText;
				document.getElementById("filmurl").value = result;
				document.getElementById("hiddenAfter").style.display = 'none';
				alert("上传成功，请点击提交按钮。");
				$('#submitAll').removeAttr('disabled');
				
			}
		}
		//进度条部分
		xhr.upload.onprogress = function(evt) {
			console.log(evt.loaded);
			if (evt.lengthComputable) {
				var percentComplete = Math.round(evt.loaded * 100 / evt.total);
				document.getElementById('progress').value = percentComplete;
			}
		};
		
		xhr.send(fd);
	}
</script>

	<%--使用公共的头部 start --%>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp"></jsp:include>
	<%--使用公共的头部 end --%>

	<!-- content -->
	<div class="content">
		<div class="breadcrumb">
			<a href="${ctx }/showAllFilms.do">戍边影院</a><span class="sep">&gt;</span><a
				href="${ctx }/upload.action">上传电影</a><span class="sep">&gt;</span>详情
		</div>
		<div class="sidebar">
			<ul class="side-menu">
				<c:if test="${_user.superAdmin }">
					<li class='active'><a href="${ctx }/upload.action">上传电影</a></li>
					<li class="${type == 2 ? 'active':'' }"><a
						href="${ctx }/delete.action">电影管理</a></li>
					<li class="${type == 3 ? 'active':'' }"><a
						href="${ctx }/manageCategory.action">类别管理</a></li>
				</c:if>

				<c:if test="${_user.superAdmin eq false }">
					<c:if test="${_user.uploadFilm == 1 }">
						<li class='active'><a href="${ctx }/upload.action">上传电影</a></li>
					</c:if>
					<c:if test="${_user.deleteFilm == 1 }">
						<li class="${type == 2 ? 'active':'' }"><a
							href="${ctx }/delete.action">电影管理</a></li>
					</c:if>
					<c:if test="${_user.manageFilmCategory == 1 }">
						<li class="${type == 3 ? 'active':'' }"><a
							href="${ctx }/manageCategory.action">类别管理</a></li>
					</c:if>
				</c:if>


			</ul>
		</div>
		<div class="main">

			<form action="filesUpload.action" method="post"
				enctype="multipart/form-data" onsubmit="return check()">
				<table>
					<tr>
						<td>片名：</td>
						<td><input type="text" name="title" id="title"></td>
						<td><input type="hidden" name="filmurl" id="filmurl"></td>
					</tr>
					<tr>
						<td>国家：</td>
						<td><input type="text" name="country" id="country"></td>
						<td></td>
					</tr>
					<tr>
						<td>时长：</td>
						<td><input type="text" id="during" name="during" id="during"
							onblur="isNumber()"></td>
						<td></td>
					</tr>
					<tr>
						<td>主演：</td>
						<td><input type="text" name="leadingrole" id="leadingrole"></td>
						<td></td>
					</tr>
					<tr>
						<td>类型：</td>
						<td><select name="type" id="type">
								<c:forEach var="item" items="${filmCategory }">
									<option value="${item.title }">${item.title }</option>
								</c:forEach>
						</select>
						<td></td>
					</tr>
					<tr>
						<td>选择封皮:</td>
						<td><input type="file" name="files" id="files"></td>

						<td></td>
					</tr>
					<tr>
						<td>选择电影:</td>
						<td><input type="file" id="filmInput" ><input
							style="height: 21px; padding-top: 1px;" id="hiddenAfter"
							type="button" value="上传" onClick="upload()"></td>
						<td width="400px">
							<!--进度条标签--> <progress value="0" max="100" id="progress"
								style="height: 20px; width: 100%; display: none"></progress>
						</td>
					</tr>
					<tr>
						<td colspan="3"><input style="margin-left: 200px"
							id="submitAll" disabled="disabled" type="submit" value="提交"></td>
					</tr>
				</table>
			</form>
			<c:if test="${not empty isSuccess }">
				<script>
			alert("添加成功");
		</script>
			</c:if>

		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp"></jsp:include>

	<script>
	
	function check() {
		
		var title = $("#title").val();
		console.log("title"+title);
		if(title == "") {
			alert("请填写片名");
			return false;
		}
	
		
		var country = $("#country").val();
		console.log("contry"+country);
		if(country == "") {
			alert("请填写国家");
			return false;
		}
		
		var during = $("#during").val();
		console.log("during"+during);
		if(during == "") {
			alert("请填写时长");
			return false;
		}
		
		
		var leadingrole = $("#leadingrole").val();
		console.log("leadingrole"+leadingrole);
		if(leadingrole == "") {
			alert("请填写主演");
			return false;
		}
		
		var type = $("#type").val();
		console.log("type"+type);
		if(type == "") {
			alert("请选择类型");
			return false;
		}
		
		var filmInput = $("#filmInput").val();
		console.log("filmInput"+filmInput);
		
		
		
		var pic = $('#files').val();
		
		if(pic == "") {
			alert("请选择封皮");
			return false;
		} else {
			var strTemp = pic.split(".");
			var strCheck = strTemp[strTemp.length-1];
			if (strCheck.toUpperCase() =="JPG" || strCheck.toUpperCase()=="JPEG" || strCheck.toUpperCase()=="PNG" ||
					strCheck.toUpperCase()=="GIF" || strCheck.toUpperCase()=="TIFF" || strCheck.toUpperCase()=="BMP") {
				
			} else {
				alert("您上传的封皮不是图片，请重新上传");
				return false;
			}
			console.log(pic);
		}
		return true;
	}

function isNumber() {
	value = $("#during").val();
    var patrn = /^(-)?\d+(\.\d+)?$/;
    if (patrn.exec(value) == null || value == "") {
       alert("请输入整数");
       $("#during").val("");
    } else {
    	 $("#during").val( $("#during").val()+"min");
    }
}
	</script>

	<script type="text/javascript">
var mainHeight = $(".main").height();
var screenHeight = window.screen.availHeight;
if (mainHeight < screenHeight) {
	$(".main").css("height", screenHeight);
}
</script>


	<script>
jQuery(".slide").slide({
  titCell:".hd ul",
  mainCell:".bd ul",
  effect:"left",
  autoPlay:true,
  autoPage:"<li><a></a></li>",
  interTime: 6000
});
jQuery(".slide-sm").slide({
  titCell:".hd ul",
  mainCell:".bd ul",
  effect:"left",
  autoPlay:true,
  autoPage:"<li><a></a></li>",
  interTime: 5000
});

//选项卡
function tab(obj){
  var $this = $(obj);
  var $tabmenu = $this.find(".tab-hd li");
  $tabmenu.on("click",function(){
    if ($(this).hasClass('active')) return
    $(this).addClass("active").siblings().removeClass("active");
    $this.find(".tab-item").eq($(this).index()).fadeIn().siblings().hide();
  })
}
//选项卡调用
tab(".panel-tab");
// 返回顶部

$("#return").click(function(){ 
  $('body,html').animate({scrollTop:0},500); 
})

$("#pageSelect").change(function(){
	var page = $(this).val();
	location.href = '${ctx}/${pageurl}'+page;
});
</script>
</body>
</html>