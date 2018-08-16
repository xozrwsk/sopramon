
$('form').bind('submit', function() {
	let myConnexion = {
		username : $('input[name="usernameCo"]').val(),
		password : $('input[name="passwordCo"]').val()

	};

	
	$.ajax({
		method : 'POST',
		url : 'http://192.168.1.100:8080/sopramon-web/api/auth',
		data : myConnexion,

		success : function(myConnexion) {
			console.log(myConnexion);

			alert("Vous êtes bien connecté" + username);

		}
	});

	return false;
});
