
<%@ page import="java.io.*, java.lang.String, java.util.Scanner, java.io.Serializable, java.util.ArrayList, java.util.HashMap, java.util.Map, java.awt.*, java.awt.event.*, javax.swing.*, javax.swing.border.Border, javax.swing.JTable, java.util.*, java.awt.FocusTraversalPolicy, javax.swing.SortingFocusTraversalPolicy, Employee.*" %>
<%! public String number = "", name = "", age = "" , mobile = "";
    public int n = 0, option;
	obj ob = new obj();
	public ArrayList<obj> o = new ArrayList<obj>();
 %>

<html>
<head>
	<title>JSP Pages</title>
	<link rel="stylesheet" type="text/css" href="Css/style.css">
	<script async type = "text/javascript" src = "Js/style.js"></script>
	<script defer type = "text/javascript" src = "Js/style.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<header>
			<h1> Employee Data Manipulation </h1>
	</header>
	<main>
		<section class = "main">
			<section class = "Controls">
				<nav>
					<button type = "button" id = "b1" class = "button" onclick="Open('1','b1')"> Insert </button>
					<button type = "button" id = "b2" class = "button" onclick="Open('2','b2')"> Update </button>
					<button type = "button" id = "b3" class = "button" onclick="Open('3','b3')"> View 	</button>
					<button type = "button" id = "b4" class = "button" onclick="Open('4','b4')"> ViewAll</button>
					<button type = "button" id = "b5" class = "button" onclick="Open('5','b5')"> Delete </button>
				</nav>
			</section>
			<section class = "line">
			</section>
			<section class = "panel1">
					<form id = "1" action = "insert.jsp" method = "post" onsubmit = "call()"> 
						<fieldset>
							<legend> Insert </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="insertreg" required><br> </div>	
							</div>
							<div class = "line2">
								<div class = "first" > <label id = "Name"> Name  </label> </div>
								<div class = "first"> <input name="firstname" id = "insertfirstname" type="text" required><br></div>
							</div>
							<div class = "line3">
								<div class = "first"><label id = "Age"> Age  </label> </div>
								<div class = "first"><input name="Age" type="number" id = "insertAge" required><br></div>
							</div>
							<div class = "line4">
								<div class = "first"><label id = "Mobile"> Mobile </label></div>
								<div class = "first"><input name="Mobile" type="number" id = "insertmobile" required><br></div>	
							</div>
							<div class = "line5">
								<div class = "first"><input type = "submit" value = "Insert" name = "Insert"></div>
								<div class = "first"><input type = "Reset" value = "clear" name = "Insert"></div>
							</div>				
						</fieldset>
					</form>
					<form id = "2" name = "form2" action = "update.jsp" method = "post" onsubmit="required()" > 
						<fieldset>
							<legend> Update </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg" required><br></div>
							</div>
							<div class = "line2">
								<div class ="first"> <label id = "Name"> Name  </label> </div>
								<div class ="first"> <input name="firstname" type="text"><br> </div>
							</div>
							<div class = "line3">
								<div class = "first"> <label id = "Age"> Age  </label> </div>
								<div class = "first"> <input name="Age" type="number"><br> </div>
							</div>
							<div class = "line4">
								<div class = "first"> <label id = "Mobile"> Mobile  </label> </div>
								<div class = "first"> <input name="Mobile" type="number"><br> </div>
							</div>
							<div class = "line5">
								<div class = "first"> <input type = "submit" value = "Update" name = "Update" > </div>
								<div class = "first"><input type = "Reset" value = "clear" name = "Insert"></div>
							</div>
						</fieldset>
					</form>
					<form id = "3" action = "view.jsp" method = "post"> 
						<fieldset>
							<legend> View </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg" required onchange="get()"><br> </div>
							</div>
							<div class = "line3">
								<div class = "area"><input id = "t" type = "text" value = '<% out.println(request.getAttribute("abc")); %>' style = "min-width: 30vw;"/></div>
							</div>
							<div class = "line2">
								<div class = "first"> <input type = "submit" value = "View" name = "View" > </div>
								<div class = "first"> <input type = "Reset" value = "clear" name = "Clear"> </div>
							</div>
						</fieldset>
					</form>
					<form name = "table" id = "4" action="page.jsp" method = "post"> 
							<div class = "pagination">  
								<div class = "page" ><button type = "button" class = "tbutton" > Previous </button> </div>

								<div class = "page">
									<select name = "selectoption" onchange="change()">
									  <option value="5">5</option>
									  <option value="10">10</option>
									  <option value="15">15</option>
									  <option value="20">20</option>
									</select> 
								</div>

								<div class = "page" ><button type = "button" class = "tbutton"> Next </button></div>
							</div>
							<div class = "pagination">
								<table>
									<thead>
										<tr>
											<th> Register No </th>
											<th> Name </th>
											<th> Age </th>
											<th> Mobile </th>
										</tr>
									</thead>
									<tbody>
										<%
											if(request.getAttribute("setoption") != null){
												option = Integer.parseInt(request.getAttribute("setoption").toString());
											}
											else
												option = 5;
											
											out.print(option);
											o = ob.viewAll(option);
											//out.print(o);
											for( int i = 0; i < o.size(); i++ ){
												ob = (obj) o.get(i);
										%>

										<tr>
											<td><% out.print(ob.number); %></td>
											<td><% out.print(ob.name); %></td>
											<td><% out.print(ob.age); %></td>
											<td><% out.print(ob.mobile); %></td>
										</tr>

										<%
											}
										%>
									</tbody>
									<tfoot>
										
									</tfoot>
								</table>
							</div>
					</form>

					<script type="text/javascript">
						
						function change(){

							table.submit();

						}
					</script>

					<form id = "5" action = "delete.jsp" method = "post"> 
						<fieldset>
							<legend> Delete </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg" required><br></div>
							</div>
							<div class = "line2">
								<div class = "first"><input type = "submit" value = "Delete" name = "Delete" ></div>
								<div class = "first"><input type = "Reset" value = "clear" name = "Insert"></div>
							</div>
						</fieldset>
					</form>		
			</section>
			<script>
				document.getElementById("1").style.display = "none";
				document.getElementById("2").style.display = "none";
				document.getElementById("3").style.display = "none";
				document.getElementById("4").style.display = "none";
				document.getElementById("5").style.display = "none";
				//document.getElementById("t").value = "";
			</script>
		</section>
	</main>
	<footer>
			<p>footer</p>
	</footer>
</body>
</html>