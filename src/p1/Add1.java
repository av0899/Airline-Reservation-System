package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Add1")
public class Add1 extends HttpServlet {
	private int age;
	private String name,gender;
	private static final long serialVersionUID = 1L;
       public boolean add(HttpServletRequest request,HttpSession ses,String uname,String clas,int prime,int random) {
    	   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
   		String root="root";
   		String password="anandavishnu1";
   		String sql1="insert into flight.passanger(name,age,gender,class,prime,uname,random) values(?,?,?,?,?,?,?)";
   		try{
   			Class.forName("com.mysql.jdbc.Driver");
   			java.sql.Connection con=DriverManager.getConnection(url, root, password);
   			PreparedStatement st1=con.prepareStatement(sql1);
   				name=request.getParameter("pname").toString();
   				 age=Integer.parseInt(request.getParameter("age").toString());
   				 gender=request.getParameter("gender").toString();
   			
   				st1.setString(1, name);
   				st1.setInt(2, age);
   				st1.setString(3, gender);
   				st1.setString(4, clas);
   				st1.setInt(5, prime);
   				st1.setString(6,uname);
   				st1.setInt(7, random);
   				int y=st1.executeUpdate();
   				if(y>0) {
   					return true;
   				}
   				
    	
       }
   		catch(Exception e) {
   			
   		}
   	  return false;
       }
       public boolean add(HttpServletRequest request,HttpSession ses,String uname,String clas,int random) {
    	   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
   		String root="root";
   		String password="anandavishnu1";
   		String sql1="insert into flight.passanger(name,age,gender,class,prime,uname,random) values(?,?,?,?,?,?,?)";
   		try{
   			Class.forName("com.mysql.jdbc.Driver");
   			java.sql.Connection con=DriverManager.getConnection(url, root, password);
   			PreparedStatement st1=con.prepareStatement(sql1);
   				String pname=request.getParameter("pname").toString();
   				int age=Integer.parseInt(request.getParameter("age").toString());
   				String gender=request.getParameter("gender").toString();
   			
   				st1.setString(1, pname);
   				st1.setInt(2, age);
   				st1.setString(3, gender);
   				st1.setString(4, clas);
   				st1.setInt(5,0);
   				st1.setString(6,uname);
   				st1.setInt(7, random);
   				int y=st1.executeUpdate();
   				if(y>0) {
   					return true;
   				}
   				
    	
       }
   		catch(Exception e) {
   			
   		}
   	  return false;
       }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		HttpSession ses=request.getSession();
		String x=request.getParameter("add").toString();
		String uname=ses.getAttribute("uname").toString();
		String clas=ses.getAttribute("class").toString();
		int random=Integer.parseInt(ses.getAttribute("random").toString());
				PrintWriter out=response.getWriter();
		if(x.equals("Add")) {
		if(add(request,ses,uname,clas,random)) {
			out.print("<script>alert('Secondary Passanger"
						+ " added successfully')</script>");
				out.print("<script>location.href='add.jsp'</script>");
		}}
		if(x.equals("add")) {
			if(add(request,ses,uname,clas,1,random)) {
				out.print("<script>alert('Primary Passanger"
							+ " added successfully')</script>");
					out.print("<script>location.href='add.jsp'</script>");
			}}
	}
}