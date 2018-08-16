	 
function addConnexion(){
	
	let myConnexion = {
			usernameCo: $('input[name="usernameCo"]').val(),
			passwordCo: $('input[name="passwordCo"]').val(),
			};
	$.ajax({
		  type: "POST",
		  url: 'http://192.168.1.100:8080/sopramon-web/api/auth',
		  contentType: 'application/json',
		  data: JSON.stringify(myConnexion),
			  success: function(connexion) {
			  appendConnexion(connexion);
				
		  }
			
});
}

	function appendConnexion(connexion){

		let myRow = $("<tr />");
		let myColusername = $("<td />");
		let myColpassword = $("<td />");
		
				
		 myColusername.html(connexion.usernameCo);
		 myColpassword.html(connexion.passwordCo);
				 
				 
		 myRow.append(myColusername);
		 myRow.append(myColpassword);
				 		 		
		 $('#connexion tbody').append(myRow);
	}
	


	$('form').bind('submit', function() {
		addConnexion();
		return false;
	});
	

	