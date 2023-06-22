package com.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.BookDaoImpl;
import com.entity.BookDtls;



@WebServlet("/editbooks")
public class EditBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id =Integer.parseInt(request.getParameter("id"));
			String bookName = request.getParameter("bname");
			String author = request.getParameter("author");
			String price = (request.getParameter("price"));
			String status = request.getParameter("status");
			
			BookDtls b = new BookDtls();
			b.setBookId(id);
			b.setBookName(bookName);
			b.setAuthor(author);
			b.setPrice(price);
			b.setStatus(status);
			
			BookDaoImpl dao = new BookDaoImpl(DBConnect.getConn());
			boolean f = dao.updateEditBooks(b);
		
			HttpSession session = request.getSession();
			if(f) {
				session.setAttribute("succMsg", "Book Update Successfullly..");
				response.sendRedirect("admin/all_books.jsp");
			}
			else {
				session.setAttribute("failedMsg", "Something wrong on server");
				response.sendRedirect("admin/all_books.jsp");
			}
			
		} catch (Exception e) {
                e.printStackTrace();
		}
		
	}

}
