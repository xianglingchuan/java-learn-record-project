<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp获取web项目路径</h1>
1、根目录所对应的绝对路径：request.getRequestURI()；<BR>
<%=request.getRequestURI() %><BR>

2、当前web应用的绝对路径：application.getRealPath("/")<BR>
<%=application.getRealPath("/") %><BR>

3、获取当前所有项目的路径：request.getContextPath()<BR>
<%=request.getContextPath() %>



</body>
</html>