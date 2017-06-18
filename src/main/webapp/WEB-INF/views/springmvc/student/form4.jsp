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
  
  

    
    <form:form modelAttribute="validatorBookInfo" method="post">  
    
    <form:errors path="*"></form:errors><br/><br/>
    
    
      <%--   <h1><form:errors path="username" /></h1>
        <h1><form:errors path="password" /></h1>
        <form:input path="username" /><br/>
        <form:input path="password" /><br/> --%>
        
        图书标题: <form:input path="validatorBook.title" /><br/>
        <h1><form:errors path="validatorBook.title" /></h1>
        学生姓名: <form:input path="validatorStudent.name" /><br/>
        <h1><form:errors path="validatorStudent.name" /></h1>
        
        
        <input type="submit" value="提交"/>
    </form:form>
  </body>
</html>