<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import = "com.diycomputerscience.minesweeper.Board" %>
<%@ page import = "com.diycomputerscience.minesweeper.Square" %>
<%@ page import = "com.diycomputerscience.minesweeper.Point" %>
<%@ page import = "com.diycomputerscience.minesweeper.UncoveredMineException" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css" type="text/css">
<script type="text/javascript" language="javascript"  src="js/jquery-1.4.2.min.js"></script>
<title>Minesweeper</title>


</head>

<%
if("true".equals(request.getAttribute("gameOver"))) {
	out.print("<h3 class='gameOver'>Game Over !</h3>");
	out.print("<a href=\"./MinesweeperServe\">New game</a>");
}

%>

<body>
<div id="contents">
	<h2>Minesweeper</h2>
	<div id="board" oncontextmenu="return false;" ondrag="return false;" ondragstart="return false;">
		<table class="ms-grid">
			<tr>
				<td>Hello</td>
				<td>World</td>
			</tr>
		</table>
		<SCRIPT Language="JavaScript">
<!-- 
		document.write('<table class="gridtab"  border="1" cellspacing="1" cellpadding="5">');
		
		for(i=0;i<6;i++){
			 document.write('<tr>');
		for(j=0;j<6;j++){
			   document.write('<td class ="square" id="'+i+'-'+j+'">'+i+','+j +'</td>');
			   
		}
			   document.write('</tr>');
		}
		document.write('</table>');
		//-->
			</SCRIPT>
	
	</div>
</div>

<script type="text/javascript">
var gameOver = false;


$('.square').bind('click', function(e) {
	if(!gameOver) {
		var point = e.target.id.split("-");
		$.ajax({
	 		url: "MinesweeperServe",
	 		type: 'POST',
	 		dataType :'json',
	 		data:{	action : "leftClick",
	 				row: point[0],
	 			  	col: point[1],
	 			  	},
	 		error : function(jqXHR, textStatus, errorThrown) {
	 	        	alert(textStatus);
	 	    		},
	    	success: function(data) {
	    		$.each( data, function( key, value ) {
	   				
	   				mCount = value;
	    			if(mCount >= 1000){
	    				$('#'+e.target.id).html(" <img src='images/mine.jpg' />");
		   				gameOver = true;

	   				}
	   				else{
	   					$('#'+e.target.id).text(mCount);
	   				}
	   			});
	    	}
	    	});
		//post_to_url("leftClick", point[0], point[1]);
		} else {
		return false;
	}	
});



$('.square').bind('contextmenu', function(e){
    	if(!gameOver) {
    		var point = e.target.id.split("-");
    		$.ajax({
    	 		url: "MinesweeperServe",
    	 		type: 'POST',
    	 		dataType :'json',
    	 		data:{	action : "rightClick",
    	 				row: point[0],
    	 			  	col: point[1],
    	 			  	},
    	 		error : function(jqXHR, textStatus, errorThrown) {
    	 	        	alert(textStatus);
    	 	    		},
    	    	success: function(data) {
    	    		$.each( data, function( key, value ) {
    	   				$('#'+e.target.id).css('background-color', 'red');
    	   			});
    	    	}
    	    	});
    	    	
    	//post_to_url("rightClick", point[0], point[1]);
    	
    } else {
    	return false;
    }    
});


function post_to_url(action, row, col) {
	path = "${pageContext.request.contextPath}/MinesweeperServe";
    method = "post";
    
    // The rest of this code assumes you are not using a library.
    // It can be made less wordy if you use one.
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);
	
    var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "action");
	hiddenField.setAttribute("value", action);
	form.appendChild(hiddenField);

	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "row");
	hiddenField.setAttribute("value", row);
	form.appendChild(hiddenField);
	
	hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "col");
	hiddenField.setAttribute("value", col);
	form.appendChild(hiddenField);
    
    document.body.appendChild(form);
    form.submit();

}
</script>
</body>


</html>