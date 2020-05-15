<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.DriverManager" import="java.sql.PreparedStatement" import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Ticket</title>
<style>


</style>
</head>
<body>

<form action="Cancel" method="post">
<h1><big><b><center>Cancel Ticket</center></b></big></h1>
<b>Enter Ticket Id</b>: <input type="number" name="tid" placeholder="Ticket Id">
<input type= "submit" value="Cancel Ticket"> 
</form>

<center><big><h1>My Bookings</h1></big></center>

<%
HttpSession ses=request.getSession();
String name=null;
if(ses.getAttribute("uname")==null){
	response.sendRedirect("signin.jsp");	
}
else{
	
	name=ses.getAttribute("uname").toString();
	//System.out.print(name);
}
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


%>
<%
String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	String root="root";
	String password="anandavishnu1";
try{
	String sql="select *,company.company,passanger.name from ticket inner join company on ticket.company=company.id inner join user on user.uname=ticket.uname inner join passanger on passanger.random=ticket.random where user.uname=? and passanger.prime=?";
	Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection(url, root, password);
	PreparedStatement st=con.prepareStatement(sql);
	
	st.setString(1,name);
	st.setInt(2,1);
	ResultSet rs=st.executeQuery();
	int i=0;
	while(rs.next()){
		if(i==0){
			out.print("<table align='center'>"
					+"<tr>"
					+"<th>Ticket Id</th>"
					+"<th>Primary Passanger Name</th>"
					+"<th>From</th>"
					+"<th>To</th>"
					+ "<th>Company</th>"
					+"<th>Class of journey</th>"
					+ "<th>Date of Journey(YYYY/MM/DD)</th>"
					+ "<th>Arrival Time</th>"
					+ "<th>Destination Time</th>"
					+"<th>Seats Booked</th>"
					+"<th>Amount Paid</th>"
					+ "</tr>"	
						
					);
			
			i=1;
		}
		
			out.print("<tr>"
					+"<td>"+rs.getInt(12)+"</td>"
					+"<td>"+rs.getString(21)+"</td>"
					+ "<td>"+rs.getString(2)+"</td>"
					+ "<td>"+rs.getString(3)+"</td>"
					+"<td>"
					+  rs.getString(14)
					+"</td>"
							+"<td>"
							+  rs.getString(24)
							+"</td>"
							
					+ "<td>"
					+rs.getString(9)+"</td>"
					+ "<td>"
					+rs.getString(4)+"</td>"	
							+ "<td>"+rs.getString(5)+"</td>"
									+ "<td>"+rs.getString(10)+"</td>"
									+"<td>"+rs.getString(7)+"</td>"
									+ "</tr>"
											);
			
		
		}
	out.print("</table>");
		
	
	
}
catch(Exception e){
	e.printStackTrace();
}

%>

</body>
</html>