package p1;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import p1.Airplane;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search1")
public class Search1 extends HttpServlet {
	String from,to,doj,no_of_persons,clas,type;
	String promo=null;
	public ArrayList<Airplane> search_flights(String type,String from,String to,String date,String clas,HttpServletRequest request) {
		ArrayList<Airplane> flights=new ArrayList<Airplane>();
		try {
		HttpSession ses=request.getSession();
		Date date1=new Date();
		Date date2=new SimpleDateFormat("yyyy-mm-dd").parse(date);  
		Date d = null;
		d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		
		SimpleDateFormat s=new SimpleDateFormat("E");
		String x=s.format(d);
		x=x.toLowerCase();
		ses.setAttribute("day", x);
		//System.out.println(s.format(d));
		String sql="select airplane.id,company.company,route.distance,airplane.start_time,airplane.dest_time,airplane.mon_seats,airplane.mon_seats_bus,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where route.from1=? and route.to1=? and mon=1";
		if(x.equals("mon"))
		 sql="select  airplane.id,company.company,route.distance,airplane.start_time,airplane.dest_time,airplane.mon_seats,airplane.mon_seats_eco,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where route.from1=? and route.to1=? and mon=1";
		if(x.equals("tue"))
			sql="select  airplane.id,company.company,route.distance,airplane.start_time,airplane.dest_time,airplane.tue_seats,airplane.tue_seats_bus,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where route.from1=? and route.to1=? and tue=1";
		if(x.equals("wed"))
			sql="select  airplane.id,company.company,route.distance,airplane.start_time,airplane.dest_time,airplane.wed_seats,airplane.wed_seats_bus,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where route.from1=? and route.to1=? and wed=1";
		if(x.equals("thu"))
			sql="select  airplane.id,company.company,route.distance,airplane.start_time,airplane.dest_time,airplane.thu_seats,airplane.thu_seats_bus,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where route.from1=? and route.to1=? and thu=1";
		if(x.equals("fri"))
			sql="select  airplane.id,company.company,route.distance,airplane.start_time,airplane.dest_time,airplane.fri_seats,airplane.fri_seats_bus,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where route.from1=? and route.to1=? and fri=1";
		if(x.equals("sat"))
			sql="select  airplane.id,company.company,route.distance,airplane.start_time,airplane.dest_time,airplane.sat_seats,airplane.sat_seats_bus,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where route.from1=? and route.to1=? and sat=1";
		if(x.equals("sun"))
			sql="select  airplane.id,company.company,route.distance,airplane.start_time,airplane.dest_time,airplane.sun_seats,airplane.sun_seats_bus,airplane.price,airplane.price2 from airplane inner join company on company.id=airplane.company_id inner join route on route.id=airplane.route_id where route.from1=? and route.to1=? and sun=1";
		    	    	
		String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
    	String root="root";
    	String password="anandavishnu1";
    	String css="<link rel='stylesheet' href='WebContent/css/1.css'>";
    	String sql1="select code,value from flight.promocode";
		
    		Class.forName("com.mysql.jdbc.Driver");
    		java.sql.Connection con=DriverManager.getConnection(url, root, password);
    		PreparedStatement st=con.prepareStatement(sql);
    		Statement st1=(Statement) con.createStatement();
    		ResultSet rs1=st1.executeQuery(sql1);
    		st.setString(1, from);
    		st.setString(2, to);
    		int eco,bus,seats;
    		ResultSet rs=st.executeQuery();
    		while(rs.next()) {
    			Airplane a=new Airplane(rs.getInt(1),rs.getString(2),rs.getFloat(3),from,to,rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getFloat(9));
    			flights.add(a);
    		}
    		String promo="";
    		while(rs1.next()) {
    			if(!(rs1.getString(1).equals("zero"))) {
    			promo=promo+"use code "+rs1.getString(1)+" and get flat Rs."+rs1.getFloat(2)+" off, ";
    		}}
    		ses.setAttribute("promo", promo);
    		System.out.println(promo);
    		
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		return flights;
    	
	}
	
	private static final long serialVersionUID = 1L;   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	
    	PrintWriter out=response.getWriter();
    	HttpSession ses=request.getSession();
		//out.println("Sorry no flights available on this date ...showing flight on nearest dates");
    			String type=request.getParameter("ty");
    			String from=request.getParameter("from").toString();
    			String to=request.getParameter("to").toString();
    			if(from.equals(to)) {
    				out.print("<html><script>alert('From and To places cannot be same')</script>");
	    			out.print("<script>location.href='index.jsp'</script></html>");
    			}
    			String date=request.getParameter("date").toString();
    			String clas=request.getParameter("clas").toString();
    			System.out.println(date);
    			System.out.println(from);
    			System.out.println(to);
    			Date date2=new Date();
    			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
                 String strDate = dateFormat.format(date2); 
    			try {
    				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		        Date d1 = sdf.parse(date);  //input  date
    		        System.out.println(d1);
    		        Date d2 = sdf.parse(strDate);
    		        System.out.println(d2);
    		        int e=d1.compareTo(d2);
    		        //System.out.println(e);
    		        Date f1=new Date(); //todays date
       			 DateFormat g1 = new SimpleDateFormat("yyyy-MM-dd");  
       			Calendar c = Calendar.getInstance();
       	        c.setTime(f1);
       	     c.add(Calendar.DATE, 7);
       	     Date c1=c.getTime(); //date after 7 days
       	   
    		        if(d1.compareTo(d2)<0) {
    		        	out.print("<html><script>alert('Date out of scope')</script>");
    	    			out.print("<script>location.href='index.jsp'</script></html>");
    		        }
    		        else if(f1.compareTo(d1)*d1.compareTo(c1)<0){
    		        	out.print("<html><script>alert('Date out of scope')</script>");
    	    			out.print("<script>location.href='index.jsp'</script></html>");
    		        }
    		     
				}
					catch(Exception e) {
					
				}
    			int i=0;
    			ses.setAttribute("i", i);
    			ses.setAttribute("class", clas);
    			int num_eco=0;
    			int num_bus=0;
    			out=response.getWriter();
    			String val=null;
    			if(type.equals("Search Domestic")) {
    				val="domestic";
    			}
    			else {
    				val="international";
    			}
    			System.out.println(val);
    			Date f1=new Date();
    			Calendar c = Calendar.getInstance();
       	       	Calendar d=Calendar.getInstance();
    			c.setTime(f1);
    			d.setTime(f1);
       	        int j=Integer.parseInt(ses.getAttribute("j").toString());
       	        d.add(Calendar.DATE, 3);//make number changes here to get date
       	        c.add(Calendar.DATE, 5);//make number changes here to get date
       	     Date c1=c.getTime(); //date after 7 days
       	     Date d1=d.getTime();
       	     DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");  
          String strDate1 = dateFormat.format(c1); 
          DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");  
          String strDate2 = dateFormat.format(d1); 
       	   System.out.println(strDate1);
       	 System.out.println(strDate2);
    	    	ArrayList<Airplane> a=search_flights(val,from,to,strDate1,clas,request);
    	     	ArrayList<Airplane> b=search_flights(val,from,to,strDate2,clas,request);
        		
    	    	if(a.size()==0) {
    					ses.setAttribute("j", j+1);
    	    			RequestDispatcher rd=request.getRequestDispatcher("Search1");
    	    			rd.forward(request, response);
    	    		}
    	    		else {
    	    			out.print("<html><head><style>#you\r\n" + 
    	    					"{\r\n" + 
    	    					"padding:8px 16px;\r\n" + 
    	    					"border-radius:30px;\r\n" + 
    	    					"outline:none;\r\n" + 
    	    					"background-colour:olive;\r\n" + 
    	    					"border-color:olive;\r\n" + 
    	    					"float:right;\r\n" + 
    	    					"cursor:pointer;\r\n" + 
    	    					"}\r\n" + 
    	    					"</style></head></style>");
    	    			out.print("<form action='Customer' method='post'><input id='you' type='submit' value='logout' name='s1'></form>");
    	    			Iterator itr=a.iterator();
    	    			Iterator itr1=b.iterator();
    	    			while(itr.hasNext()) {
    	    				Airplane ap=(Airplane) itr.next();
    	    				
    	    				if(i==0) {
    	    					out.print("<html>"
    	    	    					+ "<head>"
    	    	    					+ "<style>"
    	    	    					+ "table {\r\n" + 
    	    	    					"  font-family: arial, sans-serif;\r\n" + 
    	    	    					"  border-collapse: collapse;\r\n" + 
    	    	    					"  width: 100%;\r\n" + 
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
    	    	    					+ "</style>"
    	    	    					+"</head>"
    	    	    					+ "</html>");
    	    	    			out.print("<table>"
    	    	    					+"<tr>"
    	    	    					+"<th>Flight Id</th>"
    	    	    					+"<th>From</th>"
    	    	    					+"<th>To</th>"
    	    	    					+ "<th>Company</th>"
    	    	    					+ "<th>Distance</th>"
    	    	    					+ "<th>Date of Journey(YYYY/MM/DD)</th>"
    	    	    					+ "<th>Arrival Time</th>"
    	    	    					+ "<th>Destination Time</th>"
    	    	    					+ "<th>Economy Seat Price</th>"
    	    	    					+"<th>Business Seat Price</th>"
    	    	    					+ "<th>Availability(Economy)</th>"
    	    	    					+ "<th>Availability(Business)</th>"
    	    	    					+ "</tr>"	
    	    	    						
    	    	    					);
    	    	    			
    	    	    			i=1;
    	    				}
    	    				int eco=ap.seat_eco;
        	    			int bus=ap.seat_bus;
        	    			int seats=eco+bus;
        	    			out.print("<html>"
        	    					+ "<head>"
        	    					+ "<style>"
        	    					+ "table {\r\n" + 
        	    					"  font-family: arial, sans-serif;\r\n" + 
        	    					"  border-collapse: collapse;\r\n" + 
        	    					"  width: 100%;\r\n" + 
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
        	    			out.print("<tr>"
        	    					+"<td>"+ap.id+"</td>"
        	    					+ "<td>"+from+"</td>"
        	    					+ "<td>"+to+"</td>"
        	    					+"<td>"
        	    					+ ap.company
        	    					+"</td>"
        	    					+ "<td>"
        	    					+ap.distance+"km</td>"
        	    					+ "<td>"
        	    					+strDate2+"</td>"	
        	    							+ "<td>"+ap.start_time+"</td>"
        	    									+ "<td>"+ap.end_time+"</td>"
        	    									 +"<td>"+ap.price+"</td>"
        	    									 + "<td>"+ap.price2+"</td>"
        	    											);
        	    			ses.setAttribute("from", from);
        	    			ses.setAttribute("to", to);
        	    			ses.setAttribute("date", date);
        	    			ses.setAttribute("eco1", eco);
        	    			ses.setAttribute("bus1", bus);
        	    			if(eco>0) {	
        	    	    		out.print("<td id='one'><b><big>"
        	    	    				+ eco+" seats available</big></b></td>"
        	    	    			);
        	    	    		}
        	    	    		else {
        	    	    			out.print("<td id='two'><b><big>Seats Unavailable</big></b></td>");
        	    	    		}
        	    	    		if(bus>0) {	
        	        	    		out.print("<td id='one'><b><big>"
        	        	    				+ bus+" seats available</big></b></td></tr>"
        	        	    			);
        	        	    		}
        	        	    		else {
        	        	    			out.print("<td id='two'><b><big>Seats Unavailable</big></b></td></tr>");
        	        	    		}	
        	    	    			
        	    	    		}
    	    			while(itr1.hasNext()) {
    	    				Airplane ap1=(Airplane) itr1.next();
    	    				
    	    			int eco=ap1.seat_eco;
    	    			int bus=ap1.seat_bus;
    	    			int seats=eco+bus;
    	    			out.print("<html>"
    	    					+ "<head>"
    	    					+ "<style>"
    	    					+ "table {\r\n" + 
    	    					"  font-family: arial, sans-serif;\r\n" + 
    	    					"  border-collapse: collapse;\r\n" + 
    	    					"  width: 100%;\r\n" + 
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
    	    			out.print("<tr>"
    	    					+"<td>"+ap1.id+"</td>"
    	    					+ "<td>"+from+"</td>"
    	    					+ "<td>"+to+"</td>"
    	    					+"<td>"
    	    					+ ap1.company
    	    					+"</td>"
    	    					+ "<td>"
    	    					+ap1.distance+"km</td>"
    	    					+ "<td>"
    	    					+strDate1+"</td>"	
    	    							+ "<td>"+ap1.start_time+"</td>"
    	    									+ "<td>"+ap1.end_time+"</td>"
    	    									 +"<td>"+ap1.price+"</td>"
    	    									 + "<td>"+ap1.price2+"</td>"
    	    											);
    	    			ses.setAttribute("from", from);
    	    			ses.setAttribute("to", to);
    	    			ses.setAttribute("date", date);
    	    			ses.setAttribute("eco1", eco);
    	    			ses.setAttribute("bus1", bus);
    	    			if(eco>0) {	
    	    	    		out.print("<td id='one'><b><big>"
    	    	    				+ eco+" seats available</big></b></td>"
    	    	    			);
    	    	    		}
    	    	    		else {
    	    	    			out.print("<td id='two'><b><big>Seats Unavailable</big></b></td>");
    	    	    		}
    	    	    		if(bus>0) {	
    	        	    		out.print("<td id='one'><b><big>"
    	        	    				+ bus+" seats available</big></b></td></tr>"
    	        	    			);
    	        	    		}
    	        	    		else {
    	        	    			out.print("<td id='two'><b><big>Seats Unavailable</big></b></td></tr>");
    	        	    		}	
    	    	    			
    	    	    		}
    	    	    	
    	    			
    	    			
        	    	    			if(clas.equals("economy")) {
        	    	    				out.println("<center><tr><form action='add.jsp' method='post'>"
        	        		    				+ "<b><big style='margin-left:30px'>Flight Id:</big></b>"
        	        		    				+ "<input type='number' name='id' style='padding:5px 10px;margin-right:15px;' placeholder='Enter Flight Id'><br><br>");
        	        	    			
        	    	    				out.print("<b><big style='margin-left:30px' id='1'>Enter Economy Class Seats:</big></b>"
        	    		    				+ "<input type='number' name='num' style='padding:5px 10px;margin-right:15px;' placeholder='Enter economy'>");
        	    	    				out.print("<b><big style='margin-left:20px'>Have a promo code:</big></b><input type='text' name='promo' style='padding:5px 10px;margin-right:15px;' placeholder='Promo Code'>"
        	        		    				+ "	<input type='submit' style='padding:5px 10px' value='Book'></form><br><br></tr></center></table>");

        	    	    			}
        	    	    			else {
        	    	    				out.println("<center><tr><form action='add.jsp' method='post'>"
        	        		    				+ "<b><big style='margin-left:30px'>Flight Id:</big></b>"
        	        		    				+ "<input type='number' name='id' style='padding:5px 10px;margin-right:15px;' placeholder='Enter Flight Id'><br><br>");	
        	    	    			
        	    	    			out.print("<b><big id='2'>Enter Business Class Seats:</big></b>"
        	    		    				+ "<input type='number' name='num' style='padding:5px 10px;margin-right:15px;' placeholder='Enter number of seats'>");
        	    	    			out.print("<b><big style='margin-left:20px'>Have a promo code:</big></b><input type='text' name='promo' style='padding:5px 10px;margin-right:15px;' placeholder='Promo Code'>"
        	    		    				+ "	<input type='submit' style='padding:5px 10px' value='Book'></form><br><br></tr></center></table>");

        	    	    			}
        	    	    			String promo=ses.getAttribute("promo").toString();
        	    	    			System.out.println(promo);
        	    	    			out=response.getWriter();
        	    	    			out.print("<br><br><marquee behavior='scroll' direction='left'><b style='color:red'><h3>Promo Codes:"
        	    	    					+promo
        	    	    					+ "</h3></b></marquee>");
        	    	    				    
        	    			
    	    				
    	    			}
    	    		}
    	} 		

