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

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends User {
	private String uname,password;
	private static final long serialVersionUID = 1L;
       public boolean add_flight(HttpServletRequest request,HttpServletResponse response) {
    	   int cid,rid,eco,bus,dom,mon,tue,wed,thu,fri,sat,sun;
    	   String start,end;
    	   float price1,price2;
    	   cid=Integer.parseInt(request.getParameter("cid").toString());
    	   rid=Integer.parseInt(request.getParameter("rid").toString());
    	   dom=Integer.parseInt(request.getParameter("dom").toString());
    	   mon=Integer.parseInt(request.getParameter("mon").toString());
    	   tue=Integer.parseInt(request.getParameter("tue").toString());
    	   wed=Integer.parseInt(request.getParameter("wed").toString());
    	   thu=Integer.parseInt(request.getParameter("thu").toString());
    	   fri=Integer.parseInt(request.getParameter("fri").toString());
    	   sat=Integer.parseInt(request.getParameter("sat").toString());
    	   sun=Integer.parseInt(request.getParameter("sun").toString());
    	   int mon_seats=Integer.parseInt(request.getParameter("mon_seats").toString());
    	   int tue_seats=Integer.parseInt(request.getParameter("tue_seats").toString());
    	   int wed_seats=Integer.parseInt(request.getParameter("wed_seats").toString());
    	   int thu_seats=Integer.parseInt(request.getParameter("thu_seats").toString());
    	   int fri_seats=Integer.parseInt(request.getParameter("fri_seats").toString());
    	   int sat_seats=Integer.parseInt(request.getParameter("sat_seats").toString());
    	   int sun_seats=Integer.parseInt(request.getParameter("sun_seats").toString());
    	   int mon_seats_bus=Integer.parseInt(request.getParameter("mon_seats_eco").toString());
    	   int tue_seats_bus=Integer.parseInt(request.getParameter("tue_seats_eco").toString());
    	   int wed_seats_bus=Integer.parseInt(request.getParameter("wed_seats_eco").toString());
    	   int thu_seats_bus=Integer.parseInt(request.getParameter("thu_seats_eco").toString());
    	   int fri_seats_bus=Integer.parseInt(request.getParameter("fri_seats_eco").toString());
    	   int sat_seats_bus=Integer.parseInt(request.getParameter("sat_seats_eco").toString());
    	   int sun_seats_bus=Integer.parseInt(request.getParameter("sun_seats_eco").toString());
    	   
    	   start=request.getParameter("start").toString();
    	   end=request.getParameter("end").toString();
    	   price1=Float.parseFloat(request.getParameter("price1").toString());
    	   price2=Float.parseFloat(request.getParameter("price2").toString());
    	   String sql="insert into flight.airplane(company_id,route_id,start_time,dest_time,seat_eco,seat_bus,price,domestic,mon,tue,wed,thu,fri,sat,sun,price2,mon_seats,tue_seats,wed_seats,thu_seats,fri_seats,sat_seats,sun_seats,mon_seats_bus,tue_seats_bus,wed_seats_bus,thu_seats_bus,fri_seats_bus,sat_seats_bus,sun_seats_bus) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	   try {
    		   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	    	String root="root";
    	    	String password="anandavishnu1";
    	    	Class.forName("com.mysql.jdbc.Driver");
        		java.sql.Connection con=DriverManager.getConnection(url, root, password);
        		PreparedStatement st=con.prepareStatement(sql);
        		st.setInt(1, cid);
        		st.setInt(2, rid);
        		st.setString(3, start);
        		st.setString(4, end);
        		st.setInt(5, 0);
        		st.setInt(6, 0);
        		st.setFloat(7, price1);
        		st.setInt(8, dom);
        		st.setInt(9, mon);
        		st.setInt(10, tue);
        		st.setInt(11, wed);
        		st.setInt(12, thu);
        		st.setInt(13, fri);
        		st.setInt(14, sat);
        		st.setInt(15, sun);
        		st.setFloat(16, price2);
        		st.setInt(17, mon_seats);
        		st.setInt(18, tue_seats);
        		st.setInt(19, wed_seats);
        		st.setInt(20, thu_seats);
        		st.setInt(21, fri_seats);
        		st.setInt(22, sat_seats);
        		st.setInt(23, sun_seats);
        		st.setInt(24, mon_seats_bus);
        		st.setInt(25, tue_seats_bus);
        		st.setInt(26, wed_seats_bus);
        		st.setInt(27, thu_seats_bus);
        		st.setInt(28, fri_seats_bus);
        		st.setInt(29, sat_seats_bus);
        		st.setInt(30, sun_seats_bus);
        		
        		
        		int x=st.executeUpdate();
        		if(x>0)
        			return true;
        		
    	   }
    	   catch(Exception e) {
    		   e.printStackTrace();
    	   }
    	   return false;
       }
       public boolean remove_flight(HttpServletRequest request, HttpServletResponse response) {
    	   int fid=Integer.parseInt(request.getParameter("fid").toString());
    	   String sql="delete from flight.airplane where airplane.id=?";
    	   try {
    		   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	    	String root="root";
    	    	String password="anandavishnu1";
    	    	Class.forName("com.mysql.jdbc.Driver");
        		java.sql.Connection con=DriverManager.getConnection(url, root, password);
        		PreparedStatement st=con.prepareStatement(sql);
        		st.setInt(1, fid);
        		int x=st.executeUpdate();
        		if(x>0) {
        			return true;
        		}
    	   }
    	   catch(Exception e) {
    		   
    	   }
    	   return false;
       }
       public boolean remove_user(HttpServletRequest request, HttpServletResponse response) {
    	   int fid=Integer.parseInt(request.getParameter("uid").toString());
    	   String sql="delete from flight.user where user.id=?";
    	   try {
    		   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	    	String root="root";
    	    	String password="anandavishnu1";
    	    	Class.forName("com.mysql.jdbc.Driver");
        		java.sql.Connection con=DriverManager.getConnection(url, root, password);
        		PreparedStatement st=con.prepareStatement(sql);
        		st.setInt(1, fid);
        		int x=st.executeUpdate();
        		if(x>0) {
        			return true;
        		}
    	   }
    	   catch(Exception e) {
    		   
    	   }
    	   return false;
       }
       public boolean add_company(HttpServletRequest request, HttpServletResponse response) {
    	   String name=request.getParameter("cname").toString();
    	   String sql="insert into flight.company(company) values(?)";
    	   try {
    		   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	    	String root="root";
    	    	String password="anandavishnu1";
    	    	Class.forName("com.mysql.jdbc.Driver");
        		java.sql.Connection con=DriverManager.getConnection(url, root, password);
        		PreparedStatement st=con.prepareStatement(sql);
        		st.setString(1, name);
        		int x=st.executeUpdate();
        		if(x>0) {
        			return true;
        		}
    	   }
    	   catch(Exception e) {
    		   
    	   }
    	   return false;
       }
       public boolean add_route(HttpServletRequest request, HttpServletResponse response) {
    	   String from=request.getParameter("from").toString();
    	   String to=request.getParameter("to").toString();
    	   float dist=Float.parseFloat(request.getParameter("dist").toString());
    	   String sql="insert into flight.route(distance,from1,to1) values(?,?,?) ";
    	   try {
    		   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	    	String root="root";
    	    	String password="anandavishnu1";
    	    	Class.forName("com.mysql.jdbc.Driver");
        		java.sql.Connection con=DriverManager.getConnection(url, root, password);
        		PreparedStatement st=con.prepareStatement(sql);
        		st.setFloat(1, dist);
        		st.setString(2, from);
        		st.setString(3, to);
        		int x=st.executeUpdate();
        		if(x>0) {
        			return true;
        		}
    	   }
    	   catch(Exception e) {
    		   
    	   }
    	   return false;
       }
       public boolean add_promo(HttpServletRequest request, HttpServletResponse response) {
    	   String from=request.getParameter("code").toString();
    	   String to=request.getParameter("value").toString();
    	   String sql="insert into flight.promocode(code,value) values(?,?) ";
    	   try {
    		   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	    	String root="root";
    	    	String password="anandavishnu1";
    	    	Class.forName("com.mysql.jdbc.Driver");
        		java.sql.Connection con=DriverManager.getConnection(url, root, password);
        		PreparedStatement st=con.prepareStatement(sql);
        		st.setString(1, from);
        		st.setString(2, to);
        		int x=st.executeUpdate();
        		if(x>0) {
        			return true;
        		}
    	   }
    	   catch(Exception e) {
    		   
    	   }
    	   return false;
       }
       public boolean update_seats(HttpServletRequest request,HttpServletResponse response) {
    	   String day=request.getParameter("day").toString();
    	   int fid=Integer.parseInt(request.getParameter("fid").toString());
    	   int seats1=Integer.parseInt(request.getParameter("seat1").toString());
    	   int seats2=Integer.parseInt(request.getParameter("seat2").toString());
    	   String sql="update flight.airplane set mon_seats=?,mon_seats_bus=? where airplane.id=?";
    	   if(day.equals("mon")) {
    		   sql="update flight.airplane set mon_seats=?,mon_seats_bus=? where airplane.id=?";
    	   }
    	   if(day.equals("tue")) {
    		   sql="update flight.airplane set tue_seats=?,tue_seats_bus=? where airplane.id=?";
    	   }
    	   if(day.equals("wed")) {
    		   sql="update flight.airplane set wed_seats=?,wed_seats_bus=? where airplane.id=?";
    	   }
    	   if(day.equals("thu")) {
    		   sql="update flight.airplane set thu_seats=?,thu_seats_bus=? where airplane.id=?";
    	   }
    	   if(day.equals("fri")) {
    		   sql="update flight.airplane set fri_seats=?,fri_seats_bus=? where airplane.id=?";
    	   }
    	   if(day.equals("sat")) {
    		   sql="update flight.airplane set sat_seats=?,sat_seats_bus=? where airplane.id=?";
    	   }
    	   if(day.equals("sun")) {
    		   sql="update flight.airplane set sun_seats=?,sun_seats_bus=? where airplane.id=?";
    	   }
    	   try {
    		   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	    	String root="root";
    	    	String password="anandavishnu1";
    	    	Class.forName("com.mysql.jdbc.Driver");
        		java.sql.Connection con=DriverManager.getConnection(url, root, password);
        		PreparedStatement st=con.prepareStatement(sql);
        		st.setInt(1, seats1);
        		st.setInt(2, seats2);
        		st.setInt(3, fid);
        		int x=st.executeUpdate();
        		if(x>0) {
        			return true;
        		}
    	   }
    	   catch(Exception e) {
    		   
    	   }
    	   
    	   return false;
       }
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String x=request.getParameter("s1");
    		HttpSession ses=request.getSession();
    		if(x.equals("signin")) {
    			uname=request.getParameter("username").toString();
    			password=request.getParameter("pass").toString();
    			if(signin(uname,password,"admin")) {
    				PrintWriter out=response.getWriter();
    				ses.setMaxInactiveInterval(600);
					out.print("<script>window.location.href='home.jsp';</script>");
				
    			}
    			else {
    				PrintWriter out=response.getWriter();
					out.print("<script>window.alert('problem in login');</script>");
					out.print("<script>window.location.href='index3.jsp';</script>");
				
    			}
    		}
    		if(x.equals("Add Flight")) {
    			if(add_flight(request,response)) {
    				PrintWriter out=response.getWriter();
    				out.println("<script>alert('Successfully added Flight')</script>");
    				out.print("<script>window.location.href='home.jsp';</script>");
				
    			}
    		}
    		if(x.equals("Remove Flight")) {
    			if(remove_flight(request,response)) {
    				PrintWriter out=response.getWriter();
    				out.println("<script>alert('Successfully removed Flight')</script>");
    				out.print("<script>window.location.href='home.jsp';</script>");
				
    			}
    		}
    		if(x.equals("Remove User")) {
    			if(remove_user(request,response)) {
    				PrintWriter out=response.getWriter();
    				out.println("<script>alert('Successfully removed User')</script>");
    				out.print("<script>window.location.href='home.jsp';</script>");
				
    			}
    		}
    		if(x.equals("Add company")) {
    			if(add_company(request,response)) {
    				PrintWriter out=response.getWriter();
    				out.println("<script>alert('Successfully added Company')</script>");
    				out.print("<script>window.location.href='home.jsp';</script>");
				
    			}
    		}
    		if(x.equals("Add Route")) {
    			if(add_route(request,response)) {
    				PrintWriter out=response.getWriter();
    				out.println("<script>alert('Successfully added Route')</script>");
    				out.print("<script>window.location.href='home.jsp';</script>");
				
    			}
    		}
    		if(x.equals("Add Promocode")) {
    			if(add_promo(request,response)) {
    				PrintWriter out=response.getWriter();
    				out.println("<script>alert('Successfully added Promo Code')</script>");
    				out.print("<script>window.location.href='home.jsp';</script>");
				
    			}
    		}
    		if(x.equals("Update Flight")) {
    			if(update_seats(request,response)) {
    				PrintWriter out=response.getWriter();
    				out.println("<script>alert('Successfully Updated Seats')</script>");
    				out.print("<script>window.location.href='home.jsp';</script>");
				}
    		}
    	
    	}

}
