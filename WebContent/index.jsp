<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.*" import="java.sql.*" import="p1.Customer"%>
  <%ResultSet resultset =null;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/date.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans|Permanent+Marker" rel="stylesheet">
<title>Book a Ticket</title>
<style>
@import url('https://fonts.googleapis.com/css?family=Open+Sans|Permanent+Marker');
img{
background-position:center;
background-repeat:no-repeat;
background-size:cover;
position:absolute;
width:100%;
height:100%;
z-index:-1;
 filter: blur(3px);
  -webkit-filter: blur(3px);
}

div .one{text-align : center;bgcolor:yellow;
  padding-top: 30px;padding-left:40px;
  }

input{
font-size:large;
font-family: 'sans-serif';
font-weight:bold;
}
#you
{
padding:8px 16px;
border-radius:30px;
outline:none;
background-colour:olive;
border-color:olive;
margin-left:550px;
cursor:pointer;
}
#you1{
padding:8px 14px;
border-radius:30px;
outline:none;
background-colour:olive;
border-color:olive;
margin-left:425px;
cursor:pointer;
}
select{
margin-left:5px;
padding:9px 40px;
border:none;
outline:none;
font-size:medium;
font-weight:bold;

}
#vis1{
margin-left:45px;
padding:11px 40px;
border:none;
outline:none;
border-bottom:2px solid black;
background:transparent;
font-size:medium;
font-weight:bold;
cursor:pointer;
}
option{
padding:11px 60px;
background:transparent;
}
#vis{
margin-left:45px;
padding:9px 40px;
border:none;
outline:none;
border-bottom:2px solid black;
background:transparent;
font-size:medium;
font-weight:bold;
cursor:pointer;
}
th{
margin-left:15px;
}


</style>
</head>
<body>
<%
session=request.getSession();
if(session.getAttribute("uname")==null){
	response.sendRedirect("signin.jsp");	
}
%>
<!--  <img src="images/flight8.jpg">-->
<div style="margin-left:90px;margin-bottom:10px;margin-top:10px;">
<form action="Customer" method="post">
<b></b><big style="margin-left:450px;font-size:xx-large;margin-bottom:30px;">Search Domestic Flights</b></big>

<input type="submit" value="logout" id="you1" name="s1">
</form>
</div>
<hr style="border-bottom:2px solid black"><br><br><br>
<form action="Search" method="post">
<div class="one" style="margin-left:0%">
<div class="page">
  <div class="page__demo">
  <table>
  <tr height="">
  	<th><u>Type of Journey</u></th>
  	<th><u>From</u></th>
  	<th><u>To</u></th>
  	<th><u>Date Of Journey</u></th>
  	<th><u>Class of journey</u></th>
  	<th><u>Return journey</u></th>
  	<th id="visible"><u>Return Date</u></th>
  </tr>
  
  <tr>
   <td>
	<b><input type="text" value="Domestic" id="vis1" style="cursor:none" readonly></b>
  	<td>

  <select id="vis" name="from" required="cannot be empty">
  <option value="None">None</option>
  
  <%
  String url="jdbc:mysql://localhost:3306/flight?useSSL=false";
	String root="root";
	String password="anandavishnu1";
	 
	/*if(i==1){
 	sql1="select international.place from flight.international where domestic=1 and international=1";
	}
	else{
		sql1="select international.place from flight.international";
	}*/
  Class.forName("com.mysql.jdbc.Driver");
	java.sql.Connection con=DriverManager.getConnection(url, root, password);
	Statement st=con.createStatement();
	//st.setString(1, x);
	String sql1="select international.place from flight.international where domestic=1 and international=1";
	ResultSet rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>

  </select>
  	</td>
  	<td>
  	<select id="vis" name="to" required="cannot be empty">
  	
  <option value="None">None</option>
  <%
 	
 	//sql1="select international.place from flight.international";
	
  Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection(url, root, password);
	 st=con.createStatement();
	//st.setString(1, x);
	rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>
	
  </select></td>
  	<td>
  		<input type="date" name="date" id="vis" required>
  	</td>
  	<td>
  	<select id="vis" name="clas" required>
  <option value="economy">Economy</option>
  <option value="business">Business</option>
</select>
  
  	
  	</td>
  <td>
  	<select id="vis" name="return" onclick="return yes()" required>
  <option value="yes">Yes</option>
  <option value="no">No</option>
</select>
  <script type="text/javascript">
  		function yes(){
  			String x=document.getElementByName("return").value;
  			if(x=="yes"){
  				document.getElementByName("ret_date").style.display="none";
  			}
  		}
  
  </script>
  	
  	</td>
  	<td>
  	<input type="Date" name="ret_date" id="vis">
  	
  	</td>
  	
  </tr>
  </table>
  <br>
  <input type="submit" value="Search Domestic" id="you" name="ty" style="margin-bottom:70px">
</form>
  </div>
</div>
</div>
<marquee behavior='scroll' direction='left'><b style='color:red'><h3>Advanced Bookings can be made for only one week from current date</h3></b></marquee>

<div style="margin-left:90px;margin-bottom:10px;margin-top:10px;">
<form action="Customer" method="post">
<b></b><big style="margin-left:425px;font-size:xx-large;margin-bottom:30px;">Search International Flights</b></big>

</form>
</div>
<hr style="border-bottom:2px solid black"><br><br><br>
<form action="Search" method="post">
<div class="one" style="margin-left:2%">
<div class="page">
  <div class="page__demo">
  <table>
  <tr height="">
  	<th><u>Type of Journey</u></th>
  	<th><u>From</u></th>
  	<th><u>To</u></th>
  	<th><u>Date Of Journey</u></th>
  	<th><u>Class of journey</u></th>
  	
  </tr>
  
  <tr>
   <td>
	<b><input type="text" value="International" style="cursor:none" id="vis" readonly></b>
  	<td>

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
  	<td>
  	<select id="vis" name="to" required="cannot be empty">
  	
  <option value="None">None</option>
  <%
 	
 	//sql1="select international.place from flight.international";
	
  Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection(url, root, password);
	 st=con.createStatement();
	//st.setString(1, x);
	rs=st.executeQuery(sql1);
	while(rs.next()){%>
	<option value=<%= rs.getString(1) %>>
	<%=rs.getString(1) %>
	</option><%	
	}%>
	
  </select></td>
  	<td>
  		<input type="date" name="date" id="vis" required>
  	</td>
  	<td>
  	<select id="vis" name="clas" required>
  <option value="economy">Economy</option>
  <option value="business">Business</option>
</select>
  
  	
  	</td>
  	
  	
  	
  </tr>
  </table>
  <br>
  <input type="submit" value="Search International" name="ty" id="you">
</form>
  </div>
</div>
</div>



</body>
</html>