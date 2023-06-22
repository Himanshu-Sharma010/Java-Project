package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.BookDaoImpl;
import com.dao.CartDaoImpl;
import com.entity.BookDtls;
import com.entity.Cart;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int bid = Integer.parseInt(request.getParameter("bid"));
			int uid = Integer.parseInt(request.getParameter("uid"));
			
			
			BookDaoImpl dao = new BookDaoImpl(DBConnect.getConn());
			 BookDtls b = dao.getBookById(bid);
			
			 
			 Cart c = new Cart();
			 c.setBid(bid);
			 c.setUserId(uid);
			 c.setBookName(b.getBookName());
			 c.setAuthor(b.getAuthor());
			 c.setPrice(Double.parseDouble(b.getPrice()));
			 c.setTotalPrice(Double.parseDouble(b.getPrice()));
			 
			 CartDaoImpl dao2 = new CartDaoImpl(DBConnect.getConn());
			boolean f = dao2.addCart(c);
			 
			HttpSession session = request.getSession();
			
			
			if(f) {
				session.setAttribute("addCart", "Book Added To Cart");
				response.sendRedirect("all_new_book.jsp");
			}else {

				session.setAttribute("failed", "Something wrong on server");
				response.sendRedirect("all_new_book.jsp");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
	
	}

}
