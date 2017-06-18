<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Java验证框架测试</title>
  </head>

  <body>
    <form:form modelAttribute="contentModel" method="post">
    
    
       <h1>错误信息:<form:errors path="ValidatorBean.username" /></h1>
     <%--    <h1><form:errors path="password" /></h1> --%>
     <%--    <form:input path="username" /><br/>
        <form:input path="password" /><br/> --%>
        <input type="submit" value="提交"/>
    </form:form>
  </body>
</html>