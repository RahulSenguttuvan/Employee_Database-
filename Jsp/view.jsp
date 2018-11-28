<%@  page import = "Employee.*, java.util.*, java.util.ArrayList" %>
<%
	 String number, name, age, mobile,abc,a;
	 int n = 0;
	 obj ob = new obj();
	 ArrayList<obj> o = new ArrayList<obj>();
	 number="";
 	 number = request.getParameter("viewreg");
 	 name = "";
 	 age = "";
 	 mobile = "";
	 ob.get(number,name,age,mobile);
	 ob.mapread();
	  o = ob.view();
	  n = Integer.parseInt(number);
	 for( int i = 0; i < o.size(); i++ )
 	 {
 		ob = (obj) o.get(i);
 		if ( ob.number == n ){
 			a = "Register No:"+ob.number+" Name:"+ob.name+" Age:"+ob.age+" Mobile:"+ob.mobile;
 			out.print("Register No:"+ob.number+" Name:"+ob.name+" Age:"+ob.age+" Mobile:"+ob.mobile);
 		}
 	 }
%>