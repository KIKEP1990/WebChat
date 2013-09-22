<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="css/loginPagaStyle.css" />

<title>The page of authorization</title>
</head>
<body>
	<script type="text/javascript">
		function checkField() {
			valueLogin = document.getElementById('user').value;
			var p = /^[a-zA-Z](.[a-zA-Z0-9_-]*)$/;
			if (p.test(valueLogin)) {
				return true;
			} else {
				var error = document.getElementById('error');
				error.innerHTML = "You entered an invalid user name, it must contain at least 2 characters and can not start with a digit";
				return false;
			}
		}
	</script>
	<div id="loginPage">
		<h1>Login:</h1>
		<p style="color: red;">
			&nbsp;
			<%
				String message = (String) request.getAttribute("error");
				if (message != null) {
					out.println(message);
				}
			%>
		</p>
		<p id="error" style="color: red;">&nbsp;</p>
		<form action="LoginHandler" method="post"
			onsubmit="return checkField();">
			<p>
				Input your login: <input type="text" name="user" id="user">
				<input type="submit" value="Enter">
			</p>
		</form>
	</div>
</body>
</html>