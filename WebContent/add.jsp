<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" import="java.io.*" import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Passangers</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
HttpSession ses=request.getSession();
int i=Integer.parseInt(ses.getAttribute("i").toString());
String clas=ses.getAttribute("class").toString();
int seats=0;
int j;
int random=(int) (Math.random()*1000+ 1);
System.out.print(i);
if(i==0){
	seats=Integer.parseInt(request.getParameter("num").toString());
	int id=Integer.parseInt(request.getParameter("id").toString());
	String promo=request.getParameter("promo").toString();
	ses.setAttribute("id",id);
	ses.setAttribute("seats",seats);
	if(promo.equals(""))
	ses.setAttribute("promo", "zero");
	else{
		ses.setAttribute("promo",promo);
	}
	j=0;
	ses.setAttribute("j",j);
	ses.setAttribute("random", random);
}
else if(i>0){
seats=Integer.parseInt(ses.getAttribute("seats").toString());
i++;
ses.setAttribute("i",i);

}
int prime=1;
int nonprime=0;
%>
<%if(i==0){ %>
<h2>Enter Primary Passanger Details</h2>
<form action='Add1' method='post' id="one">
Name: <input type='text' name='pname' required>
Age: <input type='number' name='age' required>
Gender: <select name="gender" required><option value='Male'>Male</option><option value='Female'>Female</option></select>
Class:<%= clas %>
<%
i++;
ses.setAttribute("i",i);
%>
<input type='submit' value='add' name='add'>
</form>
<%}%>

<%
j=Integer.parseInt(ses.getAttribute("j").toString());
i=Integer.parseInt(ses.getAttribute("i").toString());
if(j<seats-1 && i>1){
%>
<h2>Enter Secondary Passanger Details</h2>
<h2>Enter Passanger <%= j+1%> Details</h2>
<form action='Add1' method='post' id="two">
Name: <input type='text' name='pname' required>
Age: <input type='number' name='age' required>
Gender: <select name="gender" required><option value='Male'>Male</option><option value='Female'>Female</option></select>
Class:<%= clas %>
<%
j++;
i++;
ses.setAttribute("j", j);
ses.setAttribute("i", i);
%>
<input type='submit' value='Add' name='add'>
</form>
<%} %>
<%
if(j>=seats-1){
	out.print("<script>document.getElementById('two')='none'</script>");
%>
<form action="Book" method="post">
<input type="submit" value="Proceed">
</form>
<% 
}
%>

</body>
</html>