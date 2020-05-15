package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ticket")
public class Ticket extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
     public boolean add_to_mybookings(HttpServletRequest request,HttpServletResponse response,HttpSession ses,int seats,int airplane_id,String from,String to,String clas,String company,String start_time,String end_time,String uname,String date,int random,float amount) {
    	 String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	    	String root="root";
	    	String password="anandavishnu1";
	    	String x=ses.getAttribute("day").toString();
	    	String sql="select company.id from company where company.company=? ";
	    	String sql1="insert into flight.ticket(from2,to2,start_time,end_time,company,price,uname,date,seats,airplane_id,random) values(?,?,?,?,?,?,?,?,?,?,?)";
	    	String sql2="select airplane.mon_seats,airplane.mon_seats_bus from airplane where airplane.id=?";
	    	if(x.equals("mon")) {
	    		sql2="select airplane.mon_seats,airplane.mon_seats_bus from airplane where airplane.id=?";
	    	}
	    	if(x.equals("tue")) {
	    		sql2="select airplane.tue_seats,airplane.tue_seats_bus from airplane where airplane.id=?";
	    	}
	    	if(x.equals("wed")) {
	    		sql2="select airplane.wed_seats,airplane.wed_seats_bus from airplane where airplane.id=?";
	    	}
	    	if(x.equals("thu")) {
	    		sql2="select airplane.thu_seats,airplane.thu_seats_bus from airplane where airplane.id=?";
	    	}
	    	if(x.equals("fri")) {
	    		sql2="select airplane.fri_seats,airplane.fri_seats_bus from airplane where airplane.id=?";
	    	}
	    	if(x.equals("sat")) {
	    		sql2="select airplane.sat_seats,airplane.sat_seats_bus from airplane where airplane.id=?";
	    	}
	    	if(x.equals("sun")) {
	    		sql2="select airplane.sun_seats,airplane.sun_seats_bus from airplane where airplane.id=?";
	    	}
	    	
	    	String sql3=null;
	    	if(clas.equals("economy")) {
	    		if(x.equals("mon")) {
	    		sql3="update flight.airplane set mon_seats=? where airplane.id=? ";
	    		}
	    		if(x.equals("tue")) {
		    		sql3="update flight.airplane set tue_seats=? where airplane.id=? ";
		    	}
	    		if(x.equals("wed")) {
		    		sql3="update flight.airplane set wed_seats=? where airplane.id=? ";
		    	}
	    		if(x.equals("thu")) {
		    		sql3="update flight.airplane set thu_seats=? where airplane.id=? ";
		    	}
	    		if(x.equals("fri")) {
		    		sql3="update flight.airplane set fri_seats=? where airplane.id=? ";
		    	}
	    		if(x.equals("sat")) {
		    		sql3="update flight.airplane set sat_seats=? where airplane.id=? ";
		    	}
	    		if(x.equals("sun")) {
		    		sql3="update flight.airplane set sun_seats=? where airplane.id=? ";
		    	}
	    	}
	    	else if(clas.equals("business")) {
	    		if(x.equals("mon")) {
		    		sql3="update flight.airplane set mon_seats_bus=? where airplane.id=? ";
		    		}
		    		if(x.equals("tue")) {
			    		sql3="update flight.airplane set tue_seats_bus=? where airplane.id=? ";
			    	}
		    		if(x.equals("wed")) {
			    		sql3="update flight.airplane set wed_seats_bus=? where airplane.id=? ";
			    	}
		    		if(x.equals("thu")) {
			    		sql3="update flight.airplane set thu_seats_bus=? where airplane.id=? ";
			    	}
		    		if(x.equals("fri")) {
			    		sql3="update flight.airplane set fri_seats_bus=? where airplane.id=? ";
			    	}
		    		if(x.equals("sat")) {
			    		sql3="update flight.airplane set sat_seats_bus=? where airplane.id=? ";
			    	}
		    		if(x.equals("sun")) {
			    		sql3="update flight.airplane set sun_seats_bus=? where airplane.id=? ";
			    	}
	    		
		    		
	    	}
	    	//String sql4="select user.id,user.name from flight.user where user.uname=?";
	    	try {
				Class.forName("com.mysql.jdbc.Driver");
	    		java.sql.Connection con=DriverManager.getConnection(url, root, password);
	    		PreparedStatement st=con.prepareStatement(sql);
	    		PreparedStatement st1=con.prepareStatement(sql1);
	    		PreparedStatement st2=con.prepareStatement(sql2);
	    		PreparedStatement st3=con.prepareStatement(sql3);
	    		//PreparedStatement st4=con.prepareStatement(sql4);
			    
	    		st.setString(1, company);
	    		st2.setInt(1, airplane_id);
	    		//st4.setString(1,uname);
	    		ResultSet rs=st.executeQuery();
	    		ResultSet rs2=st2.executeQuery();
	    		//ResultSet rs4=st4.executeQuery();
	    		rs.next();
	    		rs2.next();
	    		/*int user_id=0;
	    		String user_name="";
	    		if(rs4.next()) {
	    			user_id=rs4.getInt(1);
		    		user_name=rs4.getString(2);
		    		ses.setAttribute("user_id", user_id);
		    		ses.setAttribute("user_name", user_name);
		    		
	    		}*/
	    		PrintWriter out=response.getWriter();
	    		
	    		int id=rs.getInt(1);
	    		int seats1=0;
	    		if(clas.equals("economy")) {
	    		seats1=rs2.getInt(1);}
	    		else if(clas.equals("business")) {
	    		 seats1=rs2.getInt(2);}
	    		seats1=seats1-seats;
	    		if(seats1<0) {
	    			out.print("<script>window.alert('Ticket Cannot be generated due to unsufficient seats');</script>");
					RequestDispatcher rd=request.getRequestDispatcher("Search");
					rd.forward(request, response);
					
	    		}
	    		st3.setInt(1, seats1);
	    		st3.setInt(2, airplane_id);
	    		st1.setString(1, from);
	    		st1.setString(2, to);
	    		st1.setString(3,start_time);
	    		st1.setString(4, end_time);
	    		st1.setInt(5, id);
	    		st1.setFloat(6, amount);
	    		st1.setString(7,uname);
	    		st1.setString(8, date);
	    		st1.setInt(9, seats);
	    		st1.setInt(10, airplane_id);
	    		st1.setInt(11, random);
	    		int x1=st1.executeUpdate();
	    		int y=st3.executeUpdate();
	    		if(x1>0 && y>0) {
	    				return true;
	    			
	    		}
	    		else {
	    			return false;
	    		}
	    	}
	    	catch(Exception e){
	    		e.printStackTrace();
	    	}

    	 return false;
     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession ses=request.getSession();
				ses=request.getSession();
				if(ses.getAttribute("uname")==null){
					response.sendRedirect("signin.jsp");	
				}

				PrintWriter out=response.getWriter();
				int seats=Integer.parseInt(ses.getAttribute("seats").toString());
				int airplane_id=Integer.parseInt(ses.getAttribute("id").toString());
				String from= ses.getAttribute("from").toString();
				String to=ses.getAttribute("to").toString();
				String clas=ses.getAttribute("class").toString();
				String company=ses.getAttribute("company").toString();
				String start_time=ses.getAttribute("start_time").toString();
				String end_time=ses.getAttribute("end_time").toString();
				String uname=ses.getAttribute("uname").toString();
				String date=ses.getAttribute("date").toString();
				int random=(Integer.parseInt(ses.getAttribute("random").toString()));
				float amount=Float.parseFloat(ses.getAttribute("amount_paid").toString());
				if(add_to_mybookings(request,response,ses,seats,airplane_id,from,to,clas,company,start_time,end_time,uname,date,random,amount)) {
				out.print("<script>window.alert('Ticket generated succesfully, Check Your Bookings for ticket');</script>");
				out.print("<script>window.location.href='index2.jsp';</script>");}
				else {
					out.print("<script>window.alert('Ticket not generated,please book again');</script>");
					out.print("<script>window.location.href='index.jsp';</script>");}
						
				}
			
				}


