package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cancel")
public class Cancel extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private int ticketid;
       public boolean cancelTicket(int tid) {
    	   String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	    	String root="root";
	    	String password="anandavishnu1";
	    	int prime=1;
	    	ticketid=tid;
	    	String sql1="delete from flight.ticket where ticket.random=?";
	    	String sql2="select ticket.airplane_id,ticket.seats,passanger.class from ticket inner join passanger on passanger.random=ticket.random where ticket.random=? and passanger.prime=?";
	    	String sql3=null;
	    	try {
	    		Class.forName("com.mysql.jdbc.Driver");
	    		java.sql.Connection con=DriverManager.getConnection(url, root, password);
	    		PreparedStatement st1=con.prepareStatement(sql1);
	    		PreparedStatement st2=con.prepareStatement(sql2);
	    		st2.setInt(1,tid);
	    		st2.setInt(2, prime);
	    		ResultSet rs=st2.executeQuery();
	    		if(rs.next()) {
	    			int a=rs.getInt(1);
	    			int b=rs.getInt(2);
	    			String c=rs.getString(3).toString();
	    			if(c.equals("economy")) {
	    				sql3="update flight.airplane set seat_eco=seat_eco+? where airplane.id=?";
	    			}
	    			else {
	    				sql3="update flight.airplane set seat_bus=seat_bus+? where airplane.id=?";
	    			}
	    			PreparedStatement st3=con.prepareStatement(sql3);
	    			st1.setInt(1, tid);
	    			int x=st1.executeUpdate();
	    			if(x>0) {
	    				st3.setInt(1, b);
	    				st3.setInt(2, a);
	    				int y=st3.executeUpdate();
	    				if(y>0) {
	    				return true;}
	    			}}}
	    		catch(Exception e) {
	    		}
    	   return false;
       }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tid=Integer.parseInt(request.getParameter("tid").toString());		
		PrintWriter out=response.getWriter();
		    				if(cancelTicket(tid)) {
		    					out.print("<script>window.alert('Successfully camcelled ticket');</script>");
		    					out.print("<script>window.location.href='index2.jsp';</script>");
		    				
		    				}
		    			}

}
