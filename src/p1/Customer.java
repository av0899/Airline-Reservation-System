package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Customer
 */
@WebServlet("/Customer")
public class Customer extends User {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String x=request.getParameter("s1").toString();
    		User u=new User();
    		if(x.equals("signup")) {
    			String nam=request.getParameter("name").toString();
    	    	String email=request.getParameter("email").toString();
    	    	String uname=request.getParameter("username").toString();
    	    	String pass=request.getParameter("pass").toString();
    	    	String rpass=request.getParameter("repeat-pass").toString();
    	    	if(!pass.equals(rpass)) {
    	    		PrintWriter out=response.getWriter();
    	    		out.print("<script>window.alert('Password and repeat password has to be same');</script>");
					out.print("<script>window.location.href='signup.jsp';</script>");
				
    	    	}
    	    		if(u.signup(nam,email,uname,pass)) {
    					//System.out.print(x);
    					PrintWriter out=response.getWriter();
    					out.print("<script>window.alert('succesfully created an account');</script>");
    					out.print("<script>window.location.href='signin.jsp';</script>");
    				
    					}
    				else {
    					PrintWriter out=response.getWriter();
    					out.print("<script>window.alert('Problem in creating an account');</script>");
    					out.print("<script>window.location.href='signup.jsp';</script>");
    				}
    			
    		}
    		if(x.equals("signin")) {
    			String uname=request.getParameter("username").toString();
    			String pass=request.getParameter("pass").toString();
    				if(u.signin(uname,pass)) {
    	    			HttpSession session=request.getSession();
    	    			session.setAttribute("uname", uname);
    	    			//session.setAttribute(pass, rs.getString(2));
    	    			response.sendRedirect("index2.jsp");
    	    			session.setMaxInactiveInterval(600);
    	    		}
    	    		else {
    	    			PrintWriter out=response.getWriter();
    	    			out.print("<script>alert('please signup you dont have an account');"
    	    						+"window.location.href='signup.jsp';"
    	    					);
    	    			out.print("</script>");
    	    			
    	    			
    	    		}
    	    	
    		}
    		if(x.equals("logout")) {
    			HttpSession ses=request.getSession();
    			if(u.signout(ses)) {
    				response.sendRedirect("main_page.jsp");
    			}
    		}
    		
    	
    	}
public String getName(HttpServletRequest request,HttpServletResponse response) throws IOException {
	HttpSession ses=request.getSession();
	return ses.getAttribute("uname").toString();
}}
