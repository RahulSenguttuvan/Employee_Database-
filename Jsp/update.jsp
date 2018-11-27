<%@  page import = "Employee.*, java.util.*, java.util.ArrayList" %>
<%
	 String name,number,age,mobile;
	 

	 obj ob = new obj();
	// ArrayList<obj> o = new ArrayList<obj>();

 	 number = request.getParameter("reg");
	 name = request.getParameter("firstname");
	 age = request.getParameter("Age");
	 mobile = request.getParameter("Mobile");

	 out.print(ob.get(number,name,age,mobile));
	 ob.mapread();
	 ob.objread();
	 ob.update();
	 out.print(ob.get1());
	 
	 // for( int i = 0; i < o.size(); i++ ){

	 //   			out.print(o.get(i));		
	 // }	
%>
