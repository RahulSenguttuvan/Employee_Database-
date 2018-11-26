<html>
<head>
	<title>JSP Pages</title>
	<link rel="stylesheet" type="text/css" href="Css/style.css">
	<!-- <script type = "text/javascript" src = "Js/style.js"></script> -->
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
					<button type = "button" id = "b1" class = "button" onclick="Open('1')"> Insert </button>
					<button type = "button" id = "b2" class = "button" onclick="Open('2')"> Update </button>
					<button type = "button" id = "b3" class = "button" onclick="Open('3')"> View 	</button>
					<button type = "button" id = "b4" class = "button" onclick="Open('4')"> ViewAll</button>
					<button type = "button" id = "b5" class = "button" onclick="Open('5')"> Delete </button>
				</nav>
			</section>
			<section class = "line">
			</section>
			<section class = "panel1">
					<form id = "1"> 
						<fieldset>
							<legend> Enter Employee Details </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg"><br> </div>	
							</div>
							<div class = "line2">
								<div class = "first" > <label id = "Name"> Name  </label> </div>
								<div class = "first"> <input name="firstname" type="text"><br></div>
							</div>
							<div class = "line3">
								<div class = "first"><label id = "Age"> Age  </label> </div>
								<div class = "first"><input name="Age" type="number"><br></div>
							</div>
							<div class = "line4">
								<div class = "first"><label id = "Mobile"> Mobile </label></div>
								<div class = "first"><input name="Mobile" type="number"><br></div>	
							</div>
							<div class = "line5">
								<div class = "first"><input type = "submit" value = "Insert" name = "Insert" ></div>
								<div class = "first"><input type = "submit" value = "Clear" name = "Clear" ></div>
							</div>
						</fieldset>
					</form>
					<form id = "2"> 
						<fieldset>
							<legend> Update Employee Details </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg"><br></div>
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
								<div class = "first"> <input type = "submit" value = "Insert" name = "Update" > </div>
								<div class = "first"> <input type = "submit" value = "Clear" name = "Clear" > </div>
							</div>
						</fieldset>
					</form>
					<form id = "3"> 
						<fieldset>
							<legend> View Employee Details </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg"><br> </div>
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
							
						</fieldset>
					</form>
					<form id = "5"> 
						<fieldset>
							<legend> Detail Employee Details </legend>
							<div class = "line1">
								<div class = "first"> <label id = "Reg"> Register No  </label> </div>
								<div class = "first"> <input name="reg" type="number" id ="reg"><br></div>
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
				function load(){
					document.getElementById("1").style.display = "none";
					document.getElementById("2").style.display = "none";
					document.getElementById("3").style.display = "none";
					document.getElementById("4").style.display = "none";
					document.getElementById("5").style.display = "none";
				}
				function Open(name){
					load();
					document.getElementById(name).style.display = "";
				}

			</script>
		</section>
	</main>
	<footer>
			<p>footer</p>
	</footer>
</body>
</html>