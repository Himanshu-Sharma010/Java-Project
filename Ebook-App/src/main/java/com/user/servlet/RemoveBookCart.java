package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.CartDaoImpl;


@WebServlet("/remove_book")
public class RemoveBookCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int bid = Integer.parseInt(request.getParameter("bid"));
	
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		CartDaoImpl dao = new CartDaoImpl(DBConnect.getConn());
		 boolean f = dao.deleteBook(bid,uid,cid);
	
	
		 HttpSession session = request.getSession();
		 
	
		 if(f) {
			 session.setAttribute("succMsg", "Book Removed From Cart");
			 response.sendRedirect("checkout.jsp");
		 }else {
			 session.setAttribute("failedMsg", "Something wrong on server");
			 response.sendRedirect("checkout.jsp");
		}
	}

}
