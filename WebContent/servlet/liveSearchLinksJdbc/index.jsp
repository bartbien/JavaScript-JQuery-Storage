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
		str = "printAll";
	}
	
	xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function () 
	{
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
		{
			document.getElementById("responseID").innerHTML = xmlhttp.responseText;
		}
	};
	
	xmlhttp.open("GET", "linkSearchServlet?q=" + str, true);
	xmlhttp.send();
}

showHint("");

</script>

</head>
<body>

	<h3>Start typing a name in the input field below:</h3>
	<form action="">
		First name: <input type="text" id="txt1" onkeyup="showHint(this.value)" />
	</form>
	<br>
	<div>
		<div>Suggestions:</div> 
		<span id="responseID"></span>
	</div>
	
	

</body>
</html>