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

@WebServlet("/delete")
public class BooksDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   try {
		
		   int id = Integer.parseInt(request.getParameter("id"));
	
		   BookDaoImpl dao = new BookDaoImpl(DBConnect.getConn());
		   boolean f = dao.deleteBooks(id);
	   
		   HttpSession session = request.getSession();
			if(f) {
				session.setAttribute("succMsg", "Book Delete Successfullly..");
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
