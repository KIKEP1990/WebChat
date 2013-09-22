function call() {
	var msg = $('#form').serialize();
	$.ajax({
		type : 'POST',
		url : 'QuestionHandler',
		data : msg,
		success : function(data) {
			$("#inputMessage").val('');
			$("#inputMessage").focus();
		},
	});

}

function updateUsers() {
	$.ajax({
		type : "POST",
		url : "UpdateUsers",
		cache : false,
		success : function(data) {
			var users = document.getElementById('users');
			users.innerHTML = "<p>online users:</p>" + data;
		}
	});
}

function updateMessage() {
	$.ajax({
		type : "POST",
		url : "UpdateMessage",
		cache : false,
		success : function(data) {
			var message = document.getElementById('message');
			message.innerHTML = data;
		}
	});
}

function checkOnline() {
	$.ajax({
		type : "POST",
		url : "CheckOnline",
		cache : false,
		success : function(html) {

		}
	});
}

$(document).ready(function() {
	updateUsers();
	updateMessage();
	setInterval('updateMessage()', 1000);
	setInterval('checkOnline()', 10000);
	setInterval('updateUsers()', 30000);
});