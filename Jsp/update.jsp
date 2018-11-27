<%@  page import = "Employee.*, java.util.*, java.util.ArrayList" %>
<%
	 String name,number,age,mobile;

	 obj ob = new obj();

 	 number = request.getParameter("reg");
	 name = request.getParameter("firstname");
	 age = request.getParameter("Age");
	 mobile = request.getParameter("Mobile");

	 ob.get(number,name,age,mobile);
	 ob.mapread();
	 ob.objread();
	 ob.update();
	 response.sendRedirect("Employee.jsp");
%>
