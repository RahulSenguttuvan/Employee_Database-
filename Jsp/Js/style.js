function load(){
	
	for( var i = 1; i < 6; i++ ){
		document.getElementById(i).style.display = "none";
		document.getElementById("b"+i).style.background = "";
		document.getElementById("b"+i).style.fontSize = "100%";
		
	} 
}
function Open(name,button){
	load();
	document.getElementById("b"+name).style.background = "#FFA500";
	document.getElementById("b"+name).style.fontSize = "150%";
	document.getElementById("b"+name).style.bold;	
	document.getElementById(name).style.display = "";
}

function required(){

	var empt1 = document.forms["form2"]["firstname"].value;
	var empt2 = document.forms["form2"]["Age"].value;
	var empt3 = document.forms["form2"]["Mobile"].value;

	if( empt1=="" && empt2 == "" && empt3 == "" )
	{
		alert("You have not Updated anything, please enter in one field");
		return false;
	}
	else
		 return true;
}	

function call(){

	alert("Details have been Inserted!");
}
