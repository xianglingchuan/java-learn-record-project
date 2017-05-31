<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE" />
<title>内容列表页面</title>
<link href="<%=basePath%>resource/css/all.css" rel="stylesheet"
	type="text/css" />
<script src="<%=basePath%>resource/js/common/jquery-1.8.0.min.js"></script>
<script src="<%=basePath%>resource/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
	<form action="save.action" id="mainForm" method="post">
		<div class="right">
			<div class="current">
				当前位置：<a href="javascript:void(0)" style="color: #6E6E6E;">内容管理</a>
				&gt; 内容列表
			</div>
			<div class="rightCont">
				<p class="g_title fix">
					内容列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
						class="btn03" href="javascript:deleteBatch('<%=basePath%>');">删
						除</a>
				</p>
				<div class="zixun fix">
					<table class="tab2" width="100%">
						<tbody>
							<tr>
								<td>指定：</td>
								<td align="left"><input type="text" id="command"
									name="command"
									style="border: 1px solid #000000; width: 150px; height: 25px; text-align: left;"
									value="<c:if test="${info.command!=null}">${info.command}</c:if>" /></td>
							</tr>

							<tr>
								<td>描述：</td>
								<td><textarea name="description" id="description"><c:if
											test="${info.description!=null}">${info.description}</c:if></textarea></td>
							</tr>

							<tr>
								<td>内容：</td>
								<td><textarea name="content" id="content"><c:if
											test="${info.content!=null}">${info.content}</c:if></textarea></td>
							</tr>

							<tr>
								<td><input type="submit" value="提交"></input> <input
									type="text" name="id"
									value="<c:if test="${info.id!=null}">${info.id}</c:if>" /></td>
								<td></td>
							</tr>

						</tbody>
					</table>

				</div>
			</div>
		</div>
	</form>
</body>
</html>