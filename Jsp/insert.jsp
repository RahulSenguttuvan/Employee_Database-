<%@  page import = "Employee.*" %>
<%
	 String name,number,age,mobile;

	 obj ob = new obj();

 	 number = request.getParameter("insertreg");
	 name = request.getParameter("insertfirstname");
	 age = request.getParameter("insertage");
	 mobile = request.getParameter("insertmobile");

	 out.print(number);
	 ob.get(number,name,age,mobile);
	 ob.getvalue();
	 ob.mapread();
	 ob.mapwrite();
	 ob.object();
	// response.sendRedirect("Employee.jsp");
%>
