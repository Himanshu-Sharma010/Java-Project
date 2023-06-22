<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.BookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Recent Book</title>
<%@include file="all_component/allCss.jsp"%>

<style type="text/css">


.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>


</head>
<body>
<%@include file="all_component/navbar.jsp"%>



<div class = "container-fluid ">
<div class="row p-3 ml-4">
	<%
				BookDaoImpl dao = new BookDaoImpl(DBConnect.getConn());
			List<BookDtls> list = dao.getAllOldBook();

			for (BookDtls b : list) {
			%>
			<div class="colo-md-3  ">

				<div class="card crd-ho mt-3 ml-2">
					<div class="card-body text-center ml-3 mr-2">
						<img alt="" src="book/<%=b.getPhotoName()%>"
							style="width: 100px; height: 150px;" class="img-thumblin">
						<p><%=b.getBookName()%></p>
						<p><%=b.getAuthor()%></p>
						<p>
							Categories:<%=b.getBookCategory()%></p>
						<div class="row text-center">
							<a href="view_books.jsp?bid=<%=b.getBookId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=b.getPrice()%> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>

			<%
				}
			%>


</div>
</div>

</body>
</html>