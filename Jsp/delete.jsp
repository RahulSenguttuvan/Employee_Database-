<%@  page import = "Employee.*, java.util.*" %>
<%
	 String number, name, age, mobile;

	 obj ob = new obj();

 	 number = request.getParameter("deletereg");
 	 name = "";
 	 age = "";
 	 mobile = "";
	 ob.get(number,name,age,mobile);
	 ob.mapread();
	 ob.delete();	
	 ob.mapread();
	 out.print(ob.view());
	// response.sendRedirect("Employee.jsp");
%>
