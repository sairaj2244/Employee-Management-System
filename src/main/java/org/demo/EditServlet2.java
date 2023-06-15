package org.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2") 
public class EditServlet2 extends HttpServlet {  
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	            throws ServletException, IOException {  
	          response.setContentType("text/html");  
	          PrintWriter out=response.getWriter();  
	          

	          String sid=request.getParameter("id");  
	          int id=Integer.parseInt(sid);  
	          String name=request.getParameter("name");  
	          String password=request.getParameter("password");  
	          String email=request.getParameter("email");  
	          String country=request.getParameter("country");  
	          
	          Emp e=new Emp();  
	          e.setId(id);  
	          e.setName(name);  
	          e.setPassword(password);  
	          e.setEmail(email);  
	          e.setCountry(country);  
	          
	          
	          
	          int status=EmpDao.update(e);  
	          
	          
	          
	          if(status>0){  
	              response.sendRedirect("ViewServlet");  
	          }else{  
	              out.println("Sorry! unable to update record");  
	          }  
	            
	          out.close();
	          
	          
	    }
}