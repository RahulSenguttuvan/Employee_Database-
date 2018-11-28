<%@  page import = "Employee.*, java.util.*, java.util.ArrayList" %>
<%
	 String name,number,age,mobile;

	 obj ob = new obj();

 	 number = request.getParameter("updatereg");
	 name = request.getParameter("updatefirstname");
	 age = request.getParameter("updateage");
	 mobile = request.getParameter("updatemobile");

	 ob.get(number,name,age,mobile);
	 ob.mapread();
	 ob.objread();
	 ob.update();
	 //response.sendRedirect("Employee.jsp");
%>
