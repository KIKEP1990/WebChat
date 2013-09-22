<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="css/chatStyle.css" />
<script type="text/javascript" src="javaScript/jquery-1.10.2.js"></script>
<script type="text/javascript" src="javaScript/javaScript.js"></script>
<title>This is a chat</title>
</head>
<body>
	<div id="content">
		<div id="message"></div>
		<div id="users"></div>
		<div id="chat">
			<form method="POST" id="form" action="javascript:void(null);"
				onsubmit="call()">
				<p>
					Input your message: <input type="text" name="message" size="100"
						id="inputMessage" /> <input type="submit" value="send">
				</p>
			</form>
		</div>
	</div>
</body>
</html>