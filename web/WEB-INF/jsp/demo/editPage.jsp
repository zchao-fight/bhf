<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo</title>

<script src="${ ctx }/js/jquery.min.js"></script>
<script src="${ ctx }/js/ckeditor/ckeditor.js"></script>
<script src="${ ctx }/js/ckeditor/adapters/jquery.js"></script>
<!--引入CSS-->
<link rel="stylesheet" type="text/css" href="${ ctx }/js/webuploader/webuploader.css">
<!--引入JS-->
<script type="text/javascript" src="${ ctx }/js/webuploader/webuploader.js"></script>

<style>
td {
	border-width: 1px !important;
	border-color: #aaa ! important;
	border-style: solid;
}
</style>

</head>

<body>
	<form action="${ctx }/demo/saveWork.action" class="form-horizontal" enctype="multipart/form-data" method="post" id="addForm">
		<table>
			<tr>
				<td>标题</td>
				<td><input type="text" class="form-control" id="title" name="title" value=""></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><textarea id="editor1" name="content"></textarea></td>
			</tr>

			<tr>
				<td>封皮</td>
				<td><input type="file" name="coverPage" /></td>

			</tr>

			<tr>
				<td>多文件 :</td>
				<td>
					<div id="thelist" class="uploader-list"></div>
					<div class="btns">
						<div id="picker">选择附件</div>
						<input type="button" id="ctlBtn" onClick="attachUpload()" class="" value="上传附件" />
					</div>
				</td>
			</tr>

			<tr>
				<td>
				<input type="hidden" name="attachfiles" id="attachfiles">
				</td>
				<td><input type="submit" value="提交" /></td>
			</tr>

		</table>
	</form>
</body>

<script type="text/javascript">
	var editor;
	var uploadFileIds = [];
	$(function() {
		editor = CKEDITOR.replace('editor1', {
			filebrowserUploadUrl : '${ctx}/demo/ckeditor.action',
			height : "200px",
			width : "800px"
		});
	});

	var uploader = WebUploader.create({
		// swf文件路径
		swf : '${ ctx }/js/webuploader/Uploader.swf',
		// 文件接收服务端。
		server : '${ctx}/demo/uploadAttach.action',
		// 选择文件的按钮。可选。
		// 内部根据当前运行是创建，可能是input元素，也可能是flash.
		pick : '#picker',
		// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		resize : false
	});

	function attachUpload() {
		uploader.upload();
	}

	// 当有文件被添加进队列的时候
	uploader.on('fileQueued', function(file) {
		$("#thelist").append('<div id="' + file.id + '" class="item">' + '<h4 class="info">' + file.name + '</h4>' + '<p class="state">等待上传...</p>' + '</div>');
	});

	// 文件上传过程中创建进度条实时显示。
	uploader.on('uploadProgress', function(file, percentage) {
		var $li = $('#' + file.id), $percent = $li.find('.progress');
		// 避免重复创建
		if (!$percent.length) {
			$percent = $('<progress value="0" max="100" class="progress" style="height: 20px; width: 100%"></progress>').appendTo($li).find('.progress-bar');
		}
		$li.find('p.state').text('上传中');
		console.log(percentage)
		$percent.val(percentage * 100);
	});
	uploader.on('uploadSuccess', function(file) {
		$('#' + file.id).find('p.state').text('已上传');
	});
	uploader.on('uploadError', function(file) {
		$('#' + file.id).find('p.state').text('上传出错');
	});

	uploader.on('uploadComplete', function(file) {
		$('#' + file.id).find('.progress').fadeOut();
	});
	uploader.on('uploadAccept', function(object, ret) {
		if (ret.code == 0) {
			uploadFileIds.push(ret.data);
			$("#attachfiles").val(uploadFileIds.join(","))
		}
	});
</script>
</html>
