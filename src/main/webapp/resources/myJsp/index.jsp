<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*, java.util.*"%>
<%@ page import="com.learn.myJsp.viewlist.dao.ItemsDAO" %>
<%@ page import="com.learn.myJsp.viewlist.entity.Items" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品展示</title>
	<style type="text/css">
	   div{
	      float:left;
	      margin: 10px;
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
    <h1>商品展示</h1>
    <hr>
    <center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td width="100%">          
          <% 
          ArrayList<Items> arrayList = new ArrayList<Items>();
          ItemsDAO itemsDAO = new ItemsDAO();
          arrayList = itemsDAO.getItemsAll();
          if(arrayList!=null && arrayList.size() >=1){
        	  for(int i=0; i<arrayList.size(); i++){
        		  Items items = new Items();
        		  items = arrayList.get(i);
          %>
          <!-- 商品循环开始 -->        
          <div style="width:30%">
             <dl>
               <dt>
                 <a href="details.jsp?id=<%=items.getId() %>"><img src="images/<%=items.getPicture() %>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=items.getName() %></dd> 
               <dd class="dd_city">产地:<%=items.getCity() %>&nbsp;&nbsp;价格:￥<%=items.getPicture() %> </dd> 
             </dl>
          </div>
          <!-- 商品循环结束-->        
          <%
        	  }
          }          
          %>
        </td>
      </tr>
    </table>
    </center>
</body>
</html>