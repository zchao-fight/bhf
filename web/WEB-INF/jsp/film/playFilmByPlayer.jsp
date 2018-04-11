<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<title>${title }</title>
</head>
<body style="background-color: black; margin: 0 auto;width:1620px;">
	<div >
		<h4 style="color: white">
			<a style="text-decoration: none; color: #5DCFFF"
				href="${ctx }/showAllFilms.do">戍边影院</a>&gt;&gt;${film.title }
				<a style="text-decoration: none; color: #5DCFFF; float:right;"
				href="/upload/software/K-Lite_Codec_Pack_1335_Standard.exe">如无法播放，请点此下载解码器。
				</a>
		</h4>
		
		
	</div>
	<%-- <div class="evalVideo" style="float: center">
		<video src="${film.filmurl}"
			style="margin-left: 20%; width: 60%; margin-top: 10px" id="player1"
			poster="" controls="controls" preload="none"></video>
	</div> --%>
	<!-- classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA"> -->
	<div style="text-align: center ">
		 <object id="video" width="1620" height="880" border="0"
			
			
			classid="clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA">
			<param name="ShowDisplay" value="0">
			<param name="ShowControls" value="1">
			<param name="AutoStart" value="1">
			<param name="AutoRewind" value="0">
			<param name="PlayCount" value="0">
			<param name="Appearance" value="0">
			<param name="BorderStyle" value="0">

			<param name="MovieWindowHeight" value="240">
			<param name="MovieWindowWidth" value="320">
			<param name="FileName" value="戍边影院">

			<embed style="width: 1620px; margin-left: auto; margin-right: auto"
				height="880" border="0" showdisplay="0" showcontrols="1"
				autostart="1" autorewind="0" playcount="0" moviewindowheight="240"
				moviewindowwidth="320" filename="戍边影院"
				src="${film.filmurl}">

			</embed>
		</object> 
	<%-- 	
		<object type='application/x-vlc-plugin' classid='clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921' id='vlc' events='True' width="920" height="690"  >  
                <param name='mrl' value='${film.filmurl}' />  
                <param name='volume' value='50' />  
                <param name='autoplay' value='true' />  
                <param name="toolbar" value="true" />  
                <param name='loop' value='true' />  
                <param name='fullscreen' value='true' />  
            </object>   --%>
	</div>
</body>
</html>