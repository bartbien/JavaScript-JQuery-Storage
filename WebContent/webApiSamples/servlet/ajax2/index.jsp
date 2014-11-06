<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function showHint(str) 
{
	var xmlhttp;
	
	if (str.length == 0) 
	{
		document.getElementById("responseID").innerHTML = "";
		return;
	}
	
	if (window.XMLHttpRequest) 
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else 
	{
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function () 
	{
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
		{
			document.getElementById("responseID").innerHTML = xmlhttp.responseText;
		}
	};
	
	xmlhttp.open("GET", "ajaxServlet2?q=" + str, true);
	xmlhttp.send();
}

function showHint2(str) 
{
	var xmlhttp;
	
	if (str.length == 0) 
	{
		document.getElementById("secondID").innerHTML = "";
		return;
	}
	
	if (window.XMLHttpRequest) 
	{
		// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else 
	{
		// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.onreadystatechange = function () 
	{
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
		{
			document.getElementById("secondID").innerHTML = xmlhttp.responseText;
		}
	};
	
	xmlhttp.open("GET", "ajaxServletJson?q=" + str, true);
	xmlhttp.send();
}

</script>


</head>
<body>

	<!-- -------------------------------- -->
	<h3>Ajax2</h3>
	<form action="">
		First name: <input type="text" id="txt1" onkeyup="showHint(this.value)" />
	</form>
	<p>
		Suggestions: <span id="responseID"></span>
	</p>
	
	<p> -------------------------------- </p>
	<!-- -------------------------------- -->
	<form action="ajaxServlet2" method="post">
		
		<input type="submit" value="Accept"/>
	</form>
	
	<p> -------------------------------- </p>
	<!-- -------------------------------- -->
	<form action="">
		First name: <input type="text" id="txt1" onkeyup="showHint2(this.value)" />
	</form>
	<p>
		Suggestions: <span id="secondID"></span>
	</p>
	
	<!-- -------------------------------- -->

</body>
</html>