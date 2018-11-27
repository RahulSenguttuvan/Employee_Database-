<%@  page import = "Employee.*" %>
<%
	 String name,number,age,mobile;

	 obj ob = new obj();

 	 number = request.getParameter("reg");
	 name = request.getParameter("firstname");
	 age = request.getParameter("Age");
	 mobile = request.getParameter("Mobile");

	 ob.get(number,name,age,mobile);
	 ob.getvalue();
	 ob.mapread();
	 ob.mapwrite();
	 ob.object();
	 response.sendRedirect("Employee.jsp");
%>
