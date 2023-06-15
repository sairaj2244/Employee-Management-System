package org.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet") 
public class ViewServlet extends HttpServlet{
	
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	            throws ServletException, IOException { 
		 
		 response.setContentType("text/html");  
	     PrintWriter out=response.getWriter();  
	     out.println("<a href='index.html'>Add New Employee</a>");  
	     out.println("<h1>Employees List</h1>");  
	     
	       List<Emp> list =EmpDao.getAllEmployees();
		
//		
//			 out.print("<table border='1' width='100%'");  
//		     out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");  
//		     for(Emp e:list){  
//		   out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
//		     }  
//		     out.print("</table>");  
//			
		
		
		

		
//			  for(Emp e1 : list) {
//				   out.print("<br>"+e1.getId());
//				   out.print("<br>"+e1.getName());
//				   out.print("<br>"+e1.getEmail());
//				   out.print("<br>"+e1.getPassword());
//				   out.print("<br>"+e1.getCountry());
//				  
//			  }
		
		    
		  out.print("<h1>Show details of employee</h1>");
			
		   out.print("<table border='1' width='100%'> ");
//			   hedings for tabe
		    out.print("<tr>");
		        out.print("<th>  Id  </th>");
		        out.print("<th>  Name   </th>");
		        out.print("<th>  password   </th>");
		        out.print("<th>  Email   </th>");
		        out.print("<th>  Country   </th>");
		        out.print("<th>  Edit   </th>");
		        out.print("<th>  Delete   </th>");
			     
		     
		    out.print("</tr>");
		    
//			      data of table 
		   for(Emp e1: list)
		   {
			   out.print("<tr>");
		       out.print("<td>"+ e1.getId() +"</td>");
		       out.print("<td>"+ e1.getName() +"</td>");
		       out.print("<td>"+ e1.getEmail() +"</td>");
		       out.print("<td>"+ e1.getPassword() +"</td>");
		       out.print("<td>"+ e1.getCountry() +"</td>");
//			             EditServlet?id=3
		       out.print("<td> <button><a href='EditServlet?id="+ e1.getId()+"'>  Edit  </a> </button>  </td>");
		       out.print("<td> <button><a href='DeleteServlet?id="+ e1.getId()+"'>  Delete  </a> </button>  </td>");
		      
		       out.print("</tr>");
			   
		   }
		   	   out.print("</table>");
	  
		 
		 
		 
	 } 

}