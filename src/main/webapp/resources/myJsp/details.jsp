<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*, java.util.*"%>
<%@ page import="com.learn.myJsp.viewlist.dao.ItemsDAO" %>
<%@ page import="com.learn.myJsp.viewlist.entity.Items" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品详情展示</title>
    <style type="text/css">
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	</style>
</head>
<body>
    <h1>商品详情展示</h1>
    <hr>


   <center>
      <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
        
          <%
          int id = Integer.parseInt(request.getParameter("id"));         
          ItemsDAO itemsDAO = new ItemsDAO();
          Items items = itemsDAO.getItmesById(id);
          String sViewList = "";
          if(items!=null){
          %>
          <!-- 商品详情开始 -->
          <td width="70%" valign="top">
             <table>
               <tr>
                 <td rowspan="4"><img src="images/<%=items.getPicture() %>" width="200" height="160"/></td>
               </tr>
               <tr>
                 <td><B><%=items.getName() %></B></td> 
               </tr>
               <tr>
                 <td>产地：<%=items.getCity() %></td>
               </tr>
               <tr>
                 <td>价格：<%=items.getPrice() %>￥</td>
               </tr> 
               
               <tr>
               <td><a href="index.jsp">返回首页</a></td>
               </tr>
               
             </table>
          </td>
          <!-- 商品详情结束 -->
          <%
	          //记录商品ID号到Cookie中去
	          Cookie[] cookies = request.getCookies();
              
	          if(cookies!=null && cookies.length>=1){
	               //获取cookies的内容
	               for(Cookie c:cookies){
	            	   if(c.getName().equals("cookieViewList")){
	            		   sViewList = c.getValue(); 
	            		   System.out.println("sViewList:"+sViewList);
	            	   }
	               }	        	  
	          }
	          
	          //如果保存的历史记录ID号已经大于100条，那么清空记录信息
/*	          String[] aViewList = sViewList.split(","); 
	          if(sViewList!=null && aViewList!=null){
	        	  if(aViewList.length>=100){
	        		  sViewList = "";
	        	  }	        	  
	          }*/
	          
	          //保存新的ID号到参数中去
	          sViewList = sViewList+""+id+",";
	          
	          System.out.println("sViewList:"+sViewList);
	          
	          //保存记录字符串到Cookie中去
	          Cookie cookie = new Cookie("cookieViewList", sViewList);
	          response.addCookie(cookie);
	      }
          %>
          
          

        
          <!-- 浏览过的商品 -->
          <td width="30%" bgcolor="#CCC" align="center">
             <br>
             <b>您浏览过的商品</b><br>
	          <% 
	          //从Cookie读取商品ID号
	          ArrayList<Items> aViewList =itemsDAO.getViewList(sViewList);
	          if(aViewList!=null && aViewList.size()>=1){
	        	  for(Items cItems:aViewList){
	          %>             
             <!-- 循环开始 -->
             <div>
             <dl>
               <dt>
                 <a href="details.jsp?id="><img src="images/<%=cItems.getPicture() %>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=cItems.getName() %></dd> 
               <dd class="dd_city">产地:<%=cItems.getCity() %>&nbsp;&nbsp;价格:<%=cItems.getPrice() %>￥ </dd> 
             </dl>
             </div>             
             <!-- 循环结束 -->
             <% } 
	          }
             %>
          </td>
        </tr>
      </table>
    </center>
    
    
  

</body>
</html>