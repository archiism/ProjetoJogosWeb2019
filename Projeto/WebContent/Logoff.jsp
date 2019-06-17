<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.logado != 'verdade'}">
	<c:redirect url="/index.jsp">/</c:redirect>
</c:if>
<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
	%>
	<%
session.invalidate();
%>
<jsp:forward page="/index.jsp"></jsp:forward>
</body>
</html>