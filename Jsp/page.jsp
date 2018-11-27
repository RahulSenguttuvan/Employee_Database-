<%@  page import = "Employee.*, java.util.*" %>
<%
	 String option,setoption;

	 obj ob = new obj();

 	 option = request.getParameter("selectoption");
 	 if(option != ""){
	 	 request.setAttribute("setoption",option);
	 	 
	 }
%>
