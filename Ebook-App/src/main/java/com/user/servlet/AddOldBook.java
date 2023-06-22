package com.user.servlet;

import java.io.File;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DB.DBConnect;
import com.dao.BookDaoImpl;
import com.entity.BookDtls;


@WebServlet("/add_old_book")
@MultipartConfig//it is for sending the binary file
public class AddOldBook extends HttpServlet {
	
private static final long serialVersionUID = 1L;

	
	@Override
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		String bookName = request.getParameter("bname");
		String author = request.getParameter("author");
		String price = (request.getParameter("price"));
		String categories= "Old";
		String status = "Active";
		Part part = request.getPart("bimg");//Because of MultipartConfig part  is taking image otherwise it is null.
		String fileName = part.getSubmittedFileName();
		
		
		String useremail = request.getParameter("user");
		
		BookDtls b =new BookDtls(bookName,author,price,categories,status,fileName,useremail);
		
		BookDaoImpl dao = new BookDaoImpl(DBConnect.getConn());
		

      
		
		boolean f = dao.addBooks(b);
		
		HttpSession session = request.getSession();
		
		if(f) {
			//photoaddinfolderbook
			//start
			String path =getServletContext().getRealPath("")+"book";
	
	        File file= new File(path);
			part.write(path + File.separator + fileName);
	        //end
			
			
			session.setAttribute("succMsg", "Book Add Successfully");
			response.sendRedirect("sell_book.jsp");
		}else {
			session.setAttribute("failedMsg", "Something went wrong on server");
			response.sendRedirect("sell_book.jsp");
	
		}
		
		
		
		
		
		
	} catch (Exception e) {
           e.printStackTrace();
	}
	
	


}
	}
