<%@  page import = "Employee.*" %>
<%
	 String name,number,age,mobile;

	 obj ob = new obj();

 	 number = request.getParameter("reg");
	 name = request.getParameter("firstname");
	 age = request.getParameter("Age");
	 mobile = request.getParameter("Mobile");

	 out.print(ob.get(number,name,age,mobile));
	 out.print(ob.getvalue());
	 ob.mapread();
	 out.print(ob.object());
	 ob.mapwrite();


%>
