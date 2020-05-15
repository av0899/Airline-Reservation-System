package p1;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.Enumeration;
public class User extends HttpServlet{
	private String UserId;
	private String name;
	private String password;
	private String role="customer";
	private String dob;
	private String gender,email,address;
	public boolean signin(String userid,String pass) {
		String sql1="select * from flight.user where uname=? and password=?";
    	String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	String root="root";
    	String password="anandavishnu1";
    	UserId=userid;
    	//password=pass;
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		java.sql.Connection con=DriverManager.getConnection(url, root, password);
    		PreparedStatement st=con.prepareStatement(sql1);
    		st.setString(1, userid);
    		st.setString(2, pass);
    		ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		return true;
    	}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return false;
	}
	public boolean signin(String userid,String pass,String role) {
		String sql1="select * from flight.admin where uname=? and password=?";
    	String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	String root="root";
    	String password="anandavishnu1";
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		java.sql.Connection con=DriverManager.getConnection(url, root, password);
    		PreparedStatement st=con.prepareStatement(sql1);
    		st.setString(1, userid);
    		st.setString(2, pass);
    		ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		return true;
    	}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return false;
	}
	
	public boolean signup(String name,String email,String uname,String pass) {
		String sql="insert into flight.user(name,email,uname,password)"+"values(?,?,?,?)";
    	//String sql1="select * from flight.user";
    	String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	String root="root";
    	String password="anandavishnu1";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(url,"root","anandavishnu1");
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, uname);
			st.setString(4, pass);
			int x=st.executeUpdate();
			if(x!=0) {
				return true;
			}
    	}
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	public boolean signout(HttpSession session) {
		session.removeAttribute("uname");
		session.invalidate();
		return true;
		
	}
	

}

