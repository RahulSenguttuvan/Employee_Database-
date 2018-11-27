<%@  page import = "Employee.*, java.util.*, java.util.ArrayList" %>
<%
	 String number, name, age, mobile,abc;
	 int n = 0;
	 obj ob = new obj();
	 ArrayList<obj> o = new ArrayList<obj>();

 	 number = request.getParameter("reg");
 	 name = "";
 	 age = "";
 	 mobile = "";
	 ob.get(number,name,age,mobile);
	 ob.mapread();
	 //response.sendRedirect("Employee.jsp");
	 o = ob.view();
	 n = Integer.parseInt(number);
	 for( int i = 0; i < o.size(); i++ )
 	 {
 		ob = (obj) o.get(i);
 		if ( ob.number == n ){
 			out.print("<h1>Register No:"+ob.number+" Name:"+ob.name+" Age:"+ob.age+" Mobile:"+ob.mobile+"</h1>");
 			request.setAttribute("abc","Register No:"+ob.number+" Name:"+ob.name+" Age:"+ob.age+" Mobile:"+ob.mobile);
 		}
 	 }
 	

    RequestDispatcher dispatcher = request.getRequestDispatcher("Employee.jsp");
    if (dispatcher != null){
            dispatcher.forward(request, response);
    } 
%>