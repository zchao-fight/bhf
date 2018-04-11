<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="${ctx }/js/jquery.min.js"></script>
<script type="text/javascript">
 function requestJson() {
	 
	$.ajax({
		url : "${ctx}/getRequestUser.action",
		type : "post",
		contentType : "application/json;charset=utf-8",
		//请求json数据
		data: '{"name" : "zc", "age" : 19}',
		success : function(data) {
			
			alert(data.age);
		}
		
	});
}

function responseJson() {
	/* $.ajax({
		url : "${ctx}/getResponseUser.action",
		type : "post",
		//请求key/value数据
		data: "name=张超&age=27",
		success : function(data) {
			
			alert(data);
		}
		
	}); */
	
	$.post(
		"${ctx}/getResponseUser.action",
		{"name": "zc", "age": 17},
		function(data) {
			alert(data.age);
		},
		"json"
	);
} 


</script>
</head>
<body>
<input type="button" value="请求json响应json" onclick="requestJson()"></input>
<input type="button" value="请求key/value响应json" onclick="responseJson()"></input>
</body>
</html>