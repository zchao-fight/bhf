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
<body style="background-color: black">
	<div style="margin-left:20%;" ><h4 style="color:white"><a style="text-decoration:none;color:#5DCFFF" href="${ctx }/showAllFilms.do">戍边影院</a>&gt;&gt;${film.title }</h4></div>
	 <div class="evalVideo" style="float:center">
           <video src="${film.filmurl}" style = "margin-left:20%;width:60%;margin-top:10px" id="player1" poster="" controls="controls" preload="none"></video>
     </div> 
</body>
</html>