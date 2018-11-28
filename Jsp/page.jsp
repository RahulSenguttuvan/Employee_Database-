<%@  page import = "Employee.*, java.util.*" %>
<%
	 String option,setoption;
	 int op=0;
	 obj ob = new obj();
	 ArrayList<obj> o = new ArrayList<obj>();
 	 option = request.getParameter("selectoption");
 	 op = Integer.parseInt(option);
	 o = ob.viewAll(op);
	 //out.print(o);
	for( int i = 0; i < o.size(); i++ ){
		ob = (obj) o.get(i);
		out.println("<tr><td>"+ob.number+"</td><td>"+ob.name+"</td><td>"+ob.age+"</td><td>"+ob.mobile+"</td></tr>");
	}
 	 
%>
