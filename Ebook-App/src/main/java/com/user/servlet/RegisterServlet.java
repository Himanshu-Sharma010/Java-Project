package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.UserDaoImpl;
import com.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String name=req.getParameter("fname");
			String email=req.getParameter("email");
			String phno=req.getParameter("phno");
			String password=req.getParameter("password");
			String check=req.getParameter("check");
		
//			System.out.println(name+" "+email+" "+phno+" "+password+" "+check);
		
		User us = new User();
		us.setName(name);
		us.setEmail(email);
		us.setPhno(phno);
		us.setPassword(password);
	 
		HttpSession session = req.getSession();
		
		
		
		if(check!=null) {
			UserDaoImpl dao = new UserDaoImpl(DBConnect.getConn());
		
			 boolean f2 = dao.checkUserEmail(email);
			 boolean f3 = dao.checkUserPhone(phno);
			
			 if (f2 && f3) {
					boolean f= dao.userRegister(us);
					
					if(f) {

						session.setAttribute("succMsg","Registration Done Successfully" );
						resp.sendRedirect("register.jsp");
						
					}
					else {
//			          System.out.println("something went wrong on server..");
					
						session.setAttribute("failedMsg","Something Wrong On Server" );
						resp.sendRedirect("register.jsp");
					
					}
			}else {
				if (f2==false && f3==false) {
					session.setAttribute("failedMsg","User already exist with same email id and phone number" );
					resp.sendRedirect("register.jsp");
				}
				else if (f2==false) {
					session.setAttribute("failedMsg","User already exist  with same email id" );
					resp.sendRedirect("register.jsp");
				}
				else if (f3==false) {
					session.setAttribute("failedMsg","User already exist with same Phone number" );
					resp.sendRedirect("register.jsp");
				}
				
				
			
			}
		}else {
//			System.out.println("please Agree Terms And Conditions");
			session.setAttribute("failedMsg","Please Agree Terms and Conditions" );
			resp.sendRedirect("register.jsp");
		
		
		}
		
		
		
		
		} catch (Exception e) {
             e.printStackTrace();
             
		}
	}

}
