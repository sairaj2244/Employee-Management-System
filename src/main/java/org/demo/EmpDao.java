package org.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost/EmployeeDB";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    public static Connection getConnection(){  
		 Connection con=null;  
	        try{  
 
	        	// Register JDBC driver
		         Class.forName("com.mysql.jdbc.Driver");

		         // Open a connection
		          con = DriverManager.getConnection(DB_URL, USER, PASS);
		          
	        }catch(Exception e){
	        	System.out.println(e);
	        	}  
	        return con;  
	    }  

    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into user(name,password,email,country) values (?,?,?,?)");  
            
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        	}  
          
        return status;  
    }

    
    
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps;
			try {
				ps = con.prepareStatement("select * from user");
			
            
            ResultSet rs=ps.executeQuery();
            
               while(rs.next())
               {
            	     Emp e1=new Emp();
            	     
            	     e1.setId(rs.getInt(1));
            	     e1.setName(rs.getString(2));
            	     e1.setEmail(rs.getString(3));
            	     e1.setPassword(rs.getString(4));
            	     e1.setCountry(rs.getString(5));
            	   
            	     list.add(e1);
            	   
               }
             
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            
            
			return list;  
    
    }
	
    
    
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user where id=?");  
            
            ps.setInt(1,id);  
//            ps.setInt(1,3)
             
            ResultSet rs=ps.executeQuery();   
            
            while(rs.next()){  
            	
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }

	public static int update(Emp e) {
	
		int status =0;
		  Connection con=EmpDao.getConnection();  
          try {
			PreparedStatement ps=con.prepareStatement(  
			               "update user set name=?,password=?,email=?,country=? where id=?");
		
			
			   	ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getCountry());  
	            ps.setInt(5,e.getId());  
			
	            status=ps.executeUpdate();  
	              
			
			
			
		
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return status; 
	}

    public static int delete(int id){  
   int status=0;  
   try{  
       Connection con=EmpDao.getConnection();  
       PreparedStatement ps=con.prepareStatement("delete from user where id=?");  
       ps.setInt(1,id);  
       status=ps.executeUpdate();  
         
       con.close();  
   }catch(Exception e){e.printStackTrace();}  
      return status;  
}  
    
    
    
}
