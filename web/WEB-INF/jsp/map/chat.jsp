<%--
  Created by IntelliJ IDEA.
  User: zc
  Date: 2018/1/10
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/js/jquery.min.js" charset="UTF-8"></script>
    <script>
        var username = '${sessionScope.username}';
        var ws;//一个ws对象就是一个通信管道 不要忘记加工程名
        var target = 'ws://127.0.0.1:8080/bhf/chatSocket?username=' + username;
        window.onload = function () {
            ws = new WebSocket(target);
            ws.onmessage = function (event) {

//                console.log(event.data);
//                var msg = JSON.parse(event.data);
//                console.log(msg);

                var msg =  eval('('+event.data+')');
               if (undefined !== msg.welcome) {
                   $('#content').append(msg.welcome+'<br>');
               }
               
               if (undefined !== msg.users) {
                   $('#userList').html('');
                   $.each(msg.users, function (i, entry) {
                       $('#userList').append("<input type=checkbox value='"+entry+"'>"+entry+"<br>")
                   })
               }

               if (undefined !== msg.content) {
                   $('#content').append(msg.content);
               }
            };

            ws.onclose=function(e){
                console.log(e);
//                alert('退出群聊');
//                ws.close(); //关闭TCP连接
            };
        };

        function  test() {

            ws.close();
            return "确认离开吗？";

        }

        function subSend() {
            var msg = $('#msg').val();
            var obj = null;
            if ($('#userList :checked').size() === 0) {
//                广播
                obj = {
                    msg : msg,
                    type : 1//广播 2单聊
                }
            } else {
//                单聊
                var to = $("#userList :checked").val();
                console.log(to);
                obj = {
                    to : to,
                    msg : msg,
                    type : 2//广播 2单聊
                }
            }

            ws.send(JSON.stringify(obj));
            $('#msg').val('');
        }

    </script>
</head>
<body onbeforeunload="return test()">
<div id="container" style="float: left;width:400px;height: 400px;border: dotted 1px black;">
    <div id="content" style="float: left;width:400px;height: 300px;border: dotted 1px black;">

    </div>
    <div style="float: left;width:400px;height: 100px;border: dotted 1px black;">
        <input id="msg" type="text">
        <input type="button" value="发送" onclick="subSend()">
        <input type="button" value="协同" onclick="subSend()">
    </div>

</div>
<div id="userList" style="float: left;width:200px;height: 400px;border: dotted 1px black;"></div>


</body>
</html>
