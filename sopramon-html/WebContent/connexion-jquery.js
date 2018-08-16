
function appenConnexion() {
	let myConnexion = {
		usernameCo: $('input[name="usernameCo"]').val(),
		passwordCo: $('input[name="passwordCo"]').val(),
	};
	};

function addConnexion(){

$('sumbit').bind('click', function() {
$.ajax({
	method: 'POST',
	url: 'http://192.168.1.100:8080/sopramon-web/api/auth',
	 type : "POST",
	data: {
	attr: 'usernameCo',
	attr2: 'passwordCo'
	},
	success: function(myConnexion) {
		console.log(myConnexion);
		 
		alert("Vous êtes bien connecté" + usernameCo); 
	}
	});
});
}	


