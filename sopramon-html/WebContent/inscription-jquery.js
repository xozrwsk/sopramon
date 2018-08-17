$('form').bind('submit', function() {
	let mySopramon = {
		nom : $('input[name="nom"]').val(),
		prenom : $('input[name="prenom"]').val(),
		username : $('input[name="username"]').val(),
		password : $('input[name="password"]').val(),
		dateNaissance : $('input[name="dateNaissance"]').val()
	};

	$.ajax({
		method : 'POST',
		url : 'http://192.168.1.100:8080/sopramon-web/api/sopramons',
		data : mySopramon,
		success : function(mySopramon) {
			console.log(mySopramon);
			alert("Vous êtes bien inscrit" + username);
		}

	});
	
	return false;
});
