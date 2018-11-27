
<%@ page import="java.io.*, java.lang.String, java.util.Scanner, java.io.Serializable, java.util.ArrayList, java.util.HashMap, java.util.Map, java.awt.*, java.awt.event.*, javax.swing.*, javax.swing.border.Border, javax.swing.JTable, java.util.*, java.awt.FocusTraversalPolicy, javax.swing.SortingFocusTraversalPolicy, Employee.*" %>

<%! 
  // MyObject obj = new MyObject();
   obj o1 = new obj();
   String name,filename,newname;
   Vector<Vector> rowData = new Vector<Vector>();
   int age,number,count,newage,option = 0,counter=0,done=1,cc=0;
   long mobile,newmobile;
   boolean exists = false, filethere = false,n=false, f1 = false, f2 = false, f3 = false, f4 = false, f5 = false;
   ArrayList<obj> o = new ArrayList<obj>();
   HashMap<Integer, String> map = new HashMap<Integer, String>();

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
					<form id = "1" action = "insert.jsp" method = "post"> 
						<fieldset>
							<legend> Insert </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg" required><br> </div>	
							</div>
							<div class = "line2">
								<div class = "first" > <label id = "Name"> Name  </label> </div>
								<div class = "first"> <input name="firstname" type="text" required><br></div>
							</div>
							<div class = "line3">
								<div class = "first"><label id = "Age"> Age  </label> </div>
								<div class = "first"><input name="Age" type="number" required><br></div>
							</div>
							<div class = "line4">
								<div class = "first"><label id = "Mobile"> Mobile </label></div>
								<div class = "first"><input name="Mobile" type="number" required><br></div>	
							</div>
							<div class = "line5">
								<div class = "first"><input type = "submit" value = "Insert" name = "Insert" ></div>
								<!-- <div class = "first"><input type = "submit" value = "Clear" name = "Clear" ></div> -->
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
							</div>
						</fieldset>
					</form>
					<form id = "3"> 
						<fieldset>
							<legend> View </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg" required><br> </div>
							</div>
							<div class = "line2">
								<div class = "first"> <input type = "submit" value = "View" name = "View" > </div>
								<div class = "first"> <input type = "submit" value = "Clear" name = "Clear" > </div>
							</div>
							<div class = "line3">
								<div class = "area"> <input name="viewarea" type="text" id ="viewarea"><br> </div>
							</div>
						</fieldset>
					</form>
					<form id = "4"> 
						<fieldset>
								<table>
									<thead>
										<tr>
											<th> Register No  </th>
											<th> Name </th>
											<th> Age </th>
											<th> Mobile </th>
										</tr>
									</thead>
									<tbody>
										<tr> 

										</tr>
									</tbody>
									<tfoot>
										
									</tfoot>
								</table>
						</fieldset>
					</form>
					<form id = "5"> 
						<fieldset>
							<legend> Delete </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg" required><br></div>
							</div>
							<div class = "line2">
								<div class = "first"><input type = "submit" value = "Delete" name = "Delete" ></div>
								<div class = "first"><input type = "submit" value = "Clear" name = "Clear" ></div>
							</div>
							<div class = "line3">
								<div class = "area"> <input name="viewarea" type="text" id ="viewarea"><br> </div>
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
			</script>
		</section>
	</main>
	<footer>
			<p>footer</p>
	</footer>
</body>
</html>