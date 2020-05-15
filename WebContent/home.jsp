<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
body {margin:0;}

.navbar {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  width: 100%;
}

.navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.navbar a:hover {
  background: #ddd;
  color: black;
}

.main {
  padding: 16px;
  margin-top: 30px;
  height: 1500px; /* Used in this example to enable scrolling */
}
</style>
</head>
<body>
<script type="text/javascript">
function display1(){
	document.getElementById("two").style.display="none";
	document.getElementById("one").style.display="block";
	document.getElementById("zero").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	
}
function display2(){
	document.getElementById("zero").style.display="none";
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="block";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	
	}
function display3(){
	document.getElementById("zero").style.display="block";
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	
}
function display4(){
	document.getElementById("zero").style.display="none";
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("four").style.display="block";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	
}
function display5(){
	document.getElementById("zero").style.display="none";
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="block";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="none";
	
}
function display6(){
	document.getElementById("zero").style.display="none";
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="block";
	document.getElementById("seven").style.display="none";
	
}
function display7(){
	document.getElementById("zero").style.display="none";
	document.getElementById("one").style.display="none";
	document.getElementById("two").style.display="none";
	document.getElementById("four").style.display="none";
	document.getElementById("five").style.display="none";
	document.getElementById("six").style.display="none";
	document.getElementById("seven").style.display="block";
}



</script>
<div class="navbar">
  <a href="#one" onclick="display1()">Add Flight</a>
  <a href="#two" onclick="display2()">Remove Flight</a>
   <a href="#zero" onclick="display3()">Remove User</a>
  <a href="#four" onclick="display4()">Add company</a>
  <a href="#five" onclick="display5()">Add routes</a>
  <a href="#six" onclick="display6()">Add Promo Codes</a>
  <a href="#seven" onclick="display7()">Update Seats</a>
  
  <form action="Customer" method="post"><a style="float:right" name="s1" value="signout"><button style="background-color:transparent;border:none;color:white;cursor:pointer" name="s1" value="logout">Logout</button></a></form>
</div>

<div id="one" style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Add Flight</b></h2></center>
			<table align="center">
			<tr><td>Enter company Name:</td><td>
			
			
			
			 <select id="cid" name="cid" required="cannot be empty">
  <option value="None">None</option>
  
  <%
  String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	String root="root";
	String password="anandavishnu1";
	 
	 
  Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection(url, root, password);
	Statement st=con.createStatement();
	//st.setString(1, x);
	String sql1="select company.id,company.company from flight.company ";
	ResultSet rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getInt(1) %>>
	 <%=rs.getString(2) %>
	</option><%	
	}%>

  </select>
			
			
			
			
			
			</td></tr>
			<tr><td>Enter Route Details:</td><td>
			
						 <select id="rid" name="rid" required="cannot be empty">
  <option value="None">None</option>
  
  <%
    url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	  root="root";
	 password="anandavishnu1";
	 
	 
  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection(url, root, password);
	  st=con.createStatement();
	//st.setString(1, x);
	  sql1="select route.id,route.from1,route.to1 from flight.route ";
	  rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getInt(1) %>>
	 <%=rs.getString(2) %> - <%=rs.getString(3) %>
	</option><%	
	}%>

  </select>
			
			
			
			 </td></tr>
			<tr><td>Enter Start Time:</td><td><input type="text" name="start"></td></tr>
			<tr><td>Enter End Time:</td><td><input type="text" name="end"></td></tr>
			<tr><td>Enter Economy Price:</td><td><input type="number" name="price1"></td></tr>
			<tr><td>Enter Business Price:</td><td><input type="number" name="price2"></td></tr>
			<tr><td>Domestic or international flight</td><td>  
			
			<select id="dom" name="dom">
  <option value="0"> international</option>
  <option value="1">  Domestic</option>
   
</select>
			
			</td></tr>
			<tr>
			<td>Monday Availability</td><td> 
			<select name="mon">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			
			 </td><td>Monday Available Economy Seats</td><td><input type="number" name="mon_seats">
			<td>Monday Available Business Seats</td><td><input type="number" name="mon_seats_eco">
			</tr>
			<tr>
			<td>Tuesday Availability</td>
			<td> 
			<select name="tue">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Tuesday Available Economy Seats</td><td><input type="number" name="tue_seats">
			<td>Tuesday Available Business Seats</td><td><input type="number" name="tue_seats_eco">
			</tr>
			<tr>
			<td>Wednesday Availability</td>
			<td> 
			<select name="wed">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Wednesday Available Economy Seats</td><td><input type="number" name="wed_seats">
			<td>Wednesday Available Business Seats</td><td><input type="number" name="wed_seats_eco">
			</tr>
			<tr>
			<td>Thursday Availability</td>
			<td> 
			<select name="thu">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Thursday Available Economy Seats</td><td><input type="number" name="thu_seats">
			<td>Thursday Available Business Seats</td><td><input type="number" name="thu_seats_eco">
			</tr>
			<tr>
			<td>Friday Availability</td>
			<td> 
			<select name="fri">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Friday Available Economy Seats</td><td><input type="number" name="fri_seats">
			<td>Friday Available Business Seats</td><td><input type="number" name="fri_seats_eco">
			</td></tr>
			<tr>
			<td>Saturday Availability</td>
			<td> 
			<select name="sat">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Saturday Available Economy Seats</td><td><input type="number" name="sat_seats">
			<td>Saturday Available Business Seats</td><td><input type="number" name="sat_seats_eco">
			</tr>
			<tr>
			<td>Sunday Availability</td>
			<td> 
			<select name="sun">
  			<option value="1"> available </option>
 			<option value="0"> unavailable </option>
 			</select>
			</td>
			<td>Sunday Available Economy Seats</td><td><input type="number" name="sun_seats">
			<td>Sunday Available Business Seats</td><td><input type="number" name="sun_seats_eco">
			</tr>
			
			</table>
			<center><input type="submit" value="Add Flight" name="s1"></center>
			
	</form>

</div>
<div id="two"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Remove Flight</b></h2></center>
			<table align="center">
			<tr><td>Enter Flight Details:</td><td> 
			
			<select id="vis" name="fid" required="cannot be empty">
  <option value="None">None</option>
  
  <%
    url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	  root="root";
	 password="anandavishnu1";
	 
	 
  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection(url, root, password);
	  st=con.createStatement();
	//st.setString(1, x);
	  sql1="select airplane.id,company.company,route.from1,route.to1,airplane.start_time,airplane.dest_time from flight.airplane inner join flight.route on airplane.route_id=route.id inner join company on airplane.company_id=company.id";
	  rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getInt(1) %>>
	 <%=rs.getString(1) %> : <%=rs.getString(2) %> ,  (<%=rs.getString(3) %> - <%=rs.getString(4) %>) , (<%=rs.getString(5) %> - <%=rs.getString(6) %>)  
	</option><%	
	}%>

  </select>
  
			
			</td></tr>
			</table>
			<center><input type="submit" value="Remove Flight" name="s1"></center>
			
	</form>
</div>
<div id="zero"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Remove User</b></h2></center>
			<table align="center">
			<tr><td>Enter User Id:</td><td>
		<select id="vis" name="uid" required="cannot be empty">
  <option value="None">None</option>
  
  <%
    url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	  root="root";
	 password="anandavishnu1";
	 
	 
  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection(url, root, password);
	  st=con.createStatement();
	//st.setString(1, x);
	  sql1="select user.id,user.name from flight.user";
	  rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getInt(1) %>>
	 <%=rs.getString(1) %> : <%=rs.getString(2) %> 
	</option><%	
	}%>

  </select>
  
			
			
			</td></tr>
			</table>
			<center><input type="submit" value="Remove User" name="s1"></center>
			
	</form>
</div>
<div id="four"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Add Company</b></h2></center>
			<table align="center">
			<tr><td>Enter Company Name:</td><td><input type="text" name="cname"></td></tr>
			</table>
			<center><input type="submit" value="Add company" name="s1"></center>
			
	</form>
</div>
<div id="five"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Add Route</b></h2></center>
			<table align="center">
			<tr><td>Enter Distance:</td><td><input type="number" name="dist"></td></tr>
			<tr><td>Enter From:</td><td>

  <select id="vis" name="from" required="cannot be empty">
  <option value="None">None</option>
  
  <%
   url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	 root="root";
	 password="anandavishnu1";
	 
	/*if(i==1){
 	sql1="select international.place from flight.international where domestic=1 and international=1";
	}
	else{
		sql1="select international.place from flight.international";
	}*/
  Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection(url, root, password);
	 st=con.createStatement();
	//st.setString(1, x);
	sql1="select international.place from flight.international where international=1";
	 rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>

  </select>
  	</td>
</tr>
			<tr><td>Enter To:</td><td>

  <select id="vis" name="to" required="cannot be empty">
  <option value="None">None</option>
  
  <%
   url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	 root="root";
	 password="anandavishnu1";
	 
	/*if(i==1){
 	sql1="select international.place from flight.international where domestic=1 and international=1";
	}
	else{
		sql1="select international.place from flight.international";
	}*/
  Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection(url, root, password);
	 st=con.createStatement();
	//st.setString(1, x);
	sql1="select international.place from flight.international where international=1";
	 rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>

  </select>
  	</td>
</tr>
			</table>
			<center><input type="submit" value="Add Route" name="s1"></center>
	</form>
</div>
<div id="six"  style="display:none">
	<form action="Admin" method="post">
			<center><h2><b>Add Promo Code</b></h2></center>
			<table align="center">
			<tr><td>Enter Code:</td><td><input type="text" name="code"></td></tr>
			<tr><td>Enter Value:</td><td><input type="number" name="value"></td></tr>
			</table>
			<center><input type="submit" value="Add Promocode" name="s1"></center>
	</form>
</div>
<div id="seven" style="display:none">
	<form action="Admin" method="post">
	<center><h2><b>Update Seats</b></h2></center>
			<table align="center">
			<tr>
			<td>Enter Flight Details:</td><td> 
			
			<select id="vis" name="fid" required="cannot be empty">
  <option value="None">None</option>
  
  <%
    url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	  root="root";
	 password="anandavishnu1";
	 
	 
  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection(url, root, password);
	  st=con.createStatement();
	//st.setString(1, x);
	  sql1="select airplane.id,company.company,route.from1,route.to1,airplane.start_time,airplane.dest_time from flight.airplane inner join flight.route on airplane.route_id=route.id inner join company on airplane.company_id=company.id";
	  rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getInt(1) %>>
	 <%=rs.getString(1) %> : <%=rs.getString(2) %> ,  (<%=rs.getString(3) %> - <%=rs.getString(4) %>) , (<%=rs.getString(5) %> - <%=rs.getString(6) %>)  
	</option><%	
	}%>

  </select>
  
			
			</td>
			</tr>
			<tr>
			<td>Enter day to be updated:</td>
			<td><select name="day" id="how">
				<option value="mon">Monday</option>
				<option value="tue">Tuesday</option>
				<option value="wed">Wednesday</option>
				<option value="thu">Thursday</option>
				<option value="fri">Friday</option>
				<option value="sat">Saturday</option>
				<option value="sun">Sunday</option>
			</select></td>
			</tr>
			<tr>
			<td>Enter Economy seats:</td><td><input type="number" name="seat1"></td></tr>
			<tr><td>Enter Business seats:</td><td><input type="number" name="seat2"></td>
			</tr>
			<tr><td><input type="submit" name="s1" value="Update Flight"></td></tr>
		</form>


</div>


</body>
</html>

