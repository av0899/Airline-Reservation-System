package p1;
import p1.Search;
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
import javax.servlet.http.HttpSession;

@WebServlet("/Book")
public class Book extends HttpServlet {
	private String from,to,doj;
	private int seats;
	private static final long serialVersionUID = 1L;
       public void book_ticket(HttpSession ses,HttpServletRequest request,HttpServletResponse response,String from,String to,String clas,String promo,int id,int seats) throws IOException {
    	   ses.setAttribute("seats",seats);
			//int bus=Integer.parseInt(request.getParameter("num").toString());
			PrintWriter out=response.getWriter();
			//out.print((float) eco);
			String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	    	String root="root";
	    	String password="anandavishnu1";
	    	String sql="select company.company,airplane.start_time,airplane.dest_time,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where airplane.id=?";
			String sql1="select promocode.value from promocode where code=?";
	    	if(clas.equals("economy")) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
	    		java.sql.Connection con=DriverManager.getConnection(url, root, password);
	    		PreparedStatement st=con.prepareStatement(sql);
	    		PreparedStatement st1=con.prepareStatement(sql1);
	    		st.setInt(1, id);
	    		st1.setString(1, promo);
	    		ResultSet rs=st.executeQuery();
	    		ResultSet rs1=st1.executeQuery();
	    		if(rs.next() && rs1.next()) {
	    		float total= ((float)seats * rs.getFloat(4));
	    		System.out.println(total);
	    		float tax=(float) ((0.10)*total);
	    		float convienence=250;
	    		float tot=total+tax+convienence-rs1.getFloat(1);
	    		ses.setAttribute("company", rs.getString(1));
	    		ses.setAttribute("start_time", rs.getString(2));
	    		ses.setAttribute("end_time", rs.getString(3));
	    		ses.setAttribute("amount_paid", tot);
	    		//ses.setAttribute("eco", eco);
	    		//ses.setAttribute("bus", bus);
	    		ses.setAttribute("id", id);
	    		out.print("<html>"
   					+ "<head>"
   					+ "<style>"
   					+ "table {\r\n" + 
   					"  font-family: arial, sans-serif;\r\n" + 
   					"  border-collapse: collapse;\r\n" + 
   					"  width: 80%;\r\n" + 
   					"}\r\n" + 
   					"\r\n" + 
   					"td, th {\r\n" + 
   					"  border: 1px solid #dddddd;\r\n" + 
   					"  text-align: left;\r\n" + 
   					"  padding: 8px;\r\n" + 
   					"}\r\n" + 
   					"\r\n" + 
   					"tr:nth-child(even) {\r\n" + 
   					"  background-color: #dddddd;\r\n" + 
   					"}"
   					+ "#one{"
   					+ "color:green;}"
   					+ "#two{"
   					+ "color:red;}"
   					+ "</style>"
   					+"</head>"
   					+ "</html>");
   			
	    		
	    		out.print("<html>");
			out.print("<center><b><big><h2 style='margin-top:71px;position:absolute;margin-left:574px'>Final Confirmation</h2></big></b></center>");
			out.print("<table align='center'><tr>");
			out.print("<tr><td>Economy Class Price(foR one seat):</td>");
			out.print("<td>"+rs.getFloat(4)+"</td></br></tr>");
			out.print("<tr><td>Total Amount:(  "+(float)seats+" x "+rs.getFloat(4)+")"
					+ "</td>");
			out.print("<td>"+total+"</td></br></tr>");
			out.print("<tr><td>Total Tax:</td>");
			out.print("<td>+"+tax+"</td></br></tr>");
			out.print("<tr><td>Convienence:</td>");
			out.print("<td>+"+convienence+"</td></br></tr>");
			out.print("<tr><td>Promo Code Discount:</td>");
			out.print("<td>-"+rs1.getFloat(1)+"</td></br></tr>");
			
			out.print("<tr><td>Final Amount To be Paid:</td>");
			out.print("<td>"+tot+"</td></br></tr>");
			out.print("<tr>");
			out.print("<form action='Ticket' method='post'>");
			out.print("<input type='submit' style='padding:5px 10px;position:absolute;margin-top:250px;margin-left:615px' value='Generate Ticket'></tr></form>");
			
			out.print("</html>");}}
	    	catch(Exception e) {
				e.printStackTrace();
			}
	    	}
	    	
	    	
	    	if(clas.equals("business")) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
		    		java.sql.Connection con=DriverManager.getConnection(url, root, password);
		    		PreparedStatement st=con.prepareStatement(sql);
		    		PreparedStatement st1=con.prepareStatement(sql1);
		    		st.setInt(1, id);
		    		st1.setString(1, promo);
		    		ResultSet rs=st.executeQuery();
		    		ResultSet rs1=st1.executeQuery();
		    		if(rs.next() && rs1.next()) {
		    		float total= ((float)seats * rs.getFloat(5));
		    		System.out.println(total);
		    		float tax=(float) ((0.10)*total);
		    		float convienence=250;
		    		float tot=total+tax+convienence-rs1.getFloat(1);
		    		ses.setAttribute("company", rs.getString(1));
		    		ses.setAttribute("start_time", rs.getString(2));
		    		ses.setAttribute("end_time", rs.getString(3));
		    		ses.setAttribute("amount_paid", tot);
		    		//ses.setAttribute("eco", eco);
		    		//ses.setAttribute("bus", bus);
		    		ses.setAttribute("id", id);
		    		out.print("<html>"
	    					+ "<head>"
	    					+ "<style>"
	    					+ "table {\r\n" + 
	    					"  font-family: arial, sans-serif;\r\n" + 
	    					"  border-collapse: collapse;\r\n" + 
	    					"  width: 80%;\r\n" + 
	    					"}\r\n" + 
	    					"\r\n" + 
	    					"td, th {\r\n" + 
	    					"  border: 1px solid #dddddd;\r\n" + 
	    					"  text-align: left;\r\n" + 
	    					"  padding: 8px;\r\n" + 
	    					"}\r\n" + 
	    					"\r\n" + 
	    					"tr:nth-child(even) {\r\n" + 
	    					"  background-color: #dddddd;\r\n" + 
	    					"}"
	    					+ "#one{"
	    					+ "color:green;}"
	    					+ "#two{"
	    					+ "color:red;}"
	    					+ "</style>"
	    					+"</head>"
	    					+ "</html>");
	    			
		    		
		    		out.print("<html>");
				out.print("<center><b><big><h2 style='margin-top:71px;position:absolute;margin-left:574px'>Final Confirmation</h2></big></b></center>");
				out.print("<table align='center'><tr>");
				out.print("<tr><td>Business Class Price(for one seat):</td>");
				out.print("<td>"+rs.getFloat(5)+"</td></br></tr>");
				out.print("<tr><td>Total Amount:(  "+(float)seats+" x "+rs.getFloat(5)+")"
						+ "</td>");
				out.print("<td>"+total+"</td></br></tr>");
				out.print("<tr><td>Total Tax:</td>");
				out.print("<td>+"+tax+"</td></br></tr>");
				out.print("<tr><td>Convienence:</td>");
				out.print("<td>+"+convienence+"</td></br></tr>");
				out.print("<tr><td>Promo Code Discount:</td>");
				out.print("<td>-"+rs1.getFloat(1)+"</td></br></tr>");
				
				out.print("<tr><td>Final Amount To be Paid:</td>");
				out.print("<td>"+tot+"</td></br></tr>");
				out.print("<tr>");
				out.print("<form action='Ticket' method='post'>");
				out.print("<input type='submit' style='padding:5px 10px;position:absolute;margin-top:250px;margin-left:615px' value='Generate Ticket'></tr></form>");
				
				out.print("</html>");}}
		    	catch(Exception e) {
					e.printStackTrace();
				}
		
	    	}
       }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	
		HttpSession ses=request.getSession();
//			HttpSession ses=request.getSession();
			ses=request.getSession();
			if(ses.getAttribute("uname")==null){
				response.sendRedirect("signin.jsp");	
			}

			from= ses.getAttribute("from").toString();
			to= ses.getAttribute("to").toString();
			String clas=ses.getAttribute("class").toString();
			String promo=ses.getAttribute("promo").toString();
			int id=Integer.parseInt(ses.getAttribute("id").toString());
			 seats=Integer.parseInt(ses.getAttribute("seats").toString());
			 	book_ticket(ses,request,response,from,to,clas,promo,id,seats);
				}
	    	
	    	
	    	
	}