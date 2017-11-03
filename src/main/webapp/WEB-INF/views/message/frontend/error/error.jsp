<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>应用程序异常 (500)</title>
</head>
<body>
	<div>
		<h1>应用程序异常</h1>
		<p>抱歉！您访问的页面出现异常，请稍后重试或联系管理员。</p>
		<p>
			<a href="#">详 情</a> <a href="javascript:history.back(-1)">返 回</a>
		</p>
		<div style="display: none; text-align: left;" id="err">${exception }</div>
	</div>
</body>
</html>