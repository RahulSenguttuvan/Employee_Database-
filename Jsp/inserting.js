 $(function() {

    $(".insertbutton").click(function() {

       $(this).css('background-color', 'green');
	   var reg = $("input#insertreg").val();
	   var name = $("input#insertfirstname").val();
	   var age = $("input#insertage").val();
	   var mobile = $("input#insertmobile").val();

       var dataString = 'insertreg='+reg+'&insertfirstname='+name+'&insertage='+age+'&insertmobile='+mobile;
       	$.ajax({
		    type: "POST",
		    url: "insert.jsp",
		    data:dataString,
		    success: function() {
		     alert("Success!");
		     $("#insertreg").val('');
		     $("#insertfirstname").val('');
		     $("#insertage").val('');
		     $("#insertmobile").val('');
		    }
		  });
       	return false;
    });

	 $(".updatebutton").click(function() {

	   var reg = $("input#updatereg").val();
	   var name = $("input#updatefirstname").val();
	   var age = $("input#updateage").val();
	   var mobile = $("input#updatemobile").val();

	   var dataString = 'updatereg='+reg+'&updatefirstname='+name+'&updateage='+age+'&updatemobile='+mobile;
	   //alert(dataString);return false;

	   	$.ajax({
		    type: "POST",
		    url: "update.jsp",
		    data:dataString,
		    success: function() {
		     alert("Success!");
		     $("#updatereg").val('');
		     $("#updatefirstname").val('');
		     $("#updateage").val('');
		     $("#updatemobile").val('');
		    }
		  });
	   	return false;
	});


	$(".deletebutton").click(function() {

	   var reg = $("input#deletereg").val();

	   var dataString = 'deletereg='+reg;
	   //alert(dataString);return false;

	   	$.ajax({
		    type: "POST",
		    url: "delete.jsp",
		    data:dataString,
		    success: function() {
		     alert("Success!");
		     $("#deletereg").val('');
		    }
		  });
	   	return false;
	});

	$(".viewbutton").click(function() {

	   var reg = $("input#viewreg").val();

       var dataString = 'viewreg='+reg;
       	$.ajax({
		    type: "POST",
		    url: "view.jsp",
		    data:dataString,
		    success: function(data) {
		      $("#viewreg").val('');
		      $("#viewarea").val(data);
		    }
		  });
       	return false;
    });
var optionSelected;
var valueSelected;
	$('select').on('change',function() {

		optionSelected = $("option:selected", this);
    	valueSelected = this.value;
		var dataString = 'selectoption='+valueSelected;

		//alert(dataString);return false;

		$.ajax({
		    type: "POST",
		    url: "page.jsp",
		    data:dataString,
		    success: function(data) {
		    // alert(data);
		     $("#body").html(data);
		    }
		  });

       	return false;

	});

	$(".nextbutton").click(function() {

	   // var optionSelected = $("option:selected", this);
    //    var valueSelected = this.value;
	   var dataString = 'selectoption='+valueSelected;
	   //alert(dataString); return false;

       	$.ajax({
		    type: "POST",
		    url: "next.jsp",
		    data:dataString,
		    success: function(data) {
		    	alert(data);
		      $("#body").html(data);
		    }
		  });
       	return false;
    });

  });