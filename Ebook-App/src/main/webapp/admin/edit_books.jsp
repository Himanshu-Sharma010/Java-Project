<%@page import="com.entity.BookDtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	 <%@page isELIgnored="false" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Add Books</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Books</h4>
						
					
						
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						BookDaoImpl dao = new BookDaoImpl(DBConnect.getConn());
						BookDtls b =dao.getBookById(id);
						%>

						<form action="../editbooks" method="post" >
                               <input type="hidden" name="id" value="<%=b.getBookId()%>">
                               
							<div class="form-group">
								<label for="exampleInputEmail1">Book Name*</label> <input
									name="bname" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="email-help" value="<%=b.getBookName() %>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Author Name*</label> <input
									name="author" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="email-help" value="<%=b.getAuthor() %>">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input
									name="price" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="email-help" value="<%=b.getPrice() %>">
							</div>

							


							<div class="form-group">
								<label for="inputState">Book Status</label><select
									id="inputState" name="status" class="form-control">
									<% 
									if("Active".equals(b.getStatus())){
									%>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<%
									} else{%>
									<option value="inactive">inactive</option>
									<option value="Active">Active</option>
									
									<%}
									%>
									
								</select>
							</div>


							

							<button type="submit" class="btn btn-primary">Update</button>

						</form>


					</div>

				</div>

			</div>

		</div>

	</div>

	<div style="margin-top: 20px;">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>