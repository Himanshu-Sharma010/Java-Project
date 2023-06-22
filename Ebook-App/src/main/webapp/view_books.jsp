<%@page import="com.entity.User"%>
<%@page import="com.entity.BookDtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color:#f0f1f2;">
<%@include file="all_component/navbar.jsp"%>

<%
User u =(User) session.getAttribute("userobj");
	
%>

<%
int bid = Integer.parseInt (request.getParameter("bid"));

BookDaoImpl dao = new BookDaoImpl(DBConnect.getConn());
BookDtls b =dao.getBookById(bid);

%>



<div class="container p-3">

<div class="row ">
<div class="col-md-6 text-center p-5 border bg-white">
<img src="book/<%=b.getPhotoName() %>" style="height: 150px; width:100px"><br>
<h4 class="mt-3">Book Name: <span class="text-success"><%=b.getBookName() %></span></h4>
<h4>Author Name: <span class="text-success"><%=b.getAuthor() %></span></h4>
<h4>Category: <span class="text-success"><%=b.getBookCategory() %></span ></h4>

</div>

<div class="col-md-6 text-center p-5 border bg-white">
<h2><%=b.getBookName() %></h2>

<%
if("old".equalsIgnoreCase(b.getBookCategory()))
{%>
<h5 class="text-primary">Contact To Seller</h5>
<h5 class="text-primary"><i class="fa-regular fa-envelope"></i> Email: <%=b.getEmail() %></h5>
<%} 
%>


<div class="row">

<div class="col-md-4 text-danger text-center p-2" >
<i class="fa-solid fa-money-bill-wave fa-2x"></i>
<p>Cash On Delivery</p>
</div>

<div class="col-md-4 text-danger text-center p-2" >
<i class="fa-solid fa-rotate-left fa-2x"></i>
<p>Return Available</p>
</div>

<div class="col-md-4 text-danger text-center p-2" >
<i class="fa-solid fa-truck fa-2x"></i>
<p>Free Shipping</p>
</div>




</div>

<% 
if("old".equalsIgnoreCase(b.getBookCategory()))
{
%>
<div class="text-center p-3">
<a href="index.jsp" class="btn btn-success"><i class="fa-solid fa-cart-plus"></i> Continue Shopping</a>
<a href="" class="btn btn-danger"><i class="fa-solid fa-indian-rupee-sign"></i> 233</a>

</div>

<%
} else {
%>
<div class="text-center p-3">

			<%
						if(u==null)
						{%>
						<a href="login.jsp" class="btn btn-success btn-sm ml-2"><i
								class="fa-solid fa-cart-plus"></i>Add Cart</a>
						<%
						} else {
						%>
						
							<a href="cart?bid=<%=b.getBookId() %>&uid=<%=u.getId() %>" class="btn btn-success btn-sm ml-2"><i
								class="fa-solid fa-cart-plus"></i>Add Cart</a>
							
						
						<%
						} 
						%>

<a href="" class="btn btn-danger"><i class="fa-solid fa-indian-rupee-sign"></i> 233</a>

</div>
<%
}
%>


</div>
</div>
</div>
</body>
</html>