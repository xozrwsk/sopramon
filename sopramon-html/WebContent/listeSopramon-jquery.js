function appendSopramon(sopramon) {
	let myRow = $("<tr/>");
	let myColNom = $("<td/>");
	let myColDateNaissance = $("<td/>");
	let myColExperience = $("<td/>");
	let myColNiveau = $("<td/>");
	let myColArgent = $("<td/>");
	
	// Affecter le contenu à mes colonnes
	myColNom.html(sopramon.nom);
	myColDateNaissance.html(sopramon.dateNais);
	myColExperience.html(sopramon.experience);
	myColNiveau.html(sopramon.niveau);
	myColArgent.html(sopramon.argent);
	
	// Donner les colonnes à la ligne
	myRow.append(myColNom);
	myRow.append(myColDateNaissance);
	myRow.append(myColExperience);
	myRow.append(myColNiveau);
	myRow.append(myColArgent);
	
	// Donner la ligne au tableau
	$('#sopramons tbody').append(myRow);
};

$.ajax({
	method: 'GET',
	url: 'http://192.168.1.100:8080/sopramon-web/api/sopramons',
	success: function(sopramons) {
		console.log(sopramons);
		
		// ajout de chaque sopramon
		for (let sopramon of sopramons){
			appendSopramon(sopramon);
		}
	}
});

// charger les sopramons
$('button.btn-load').bind('click', function(){


$.ajax({
	method: 'GET',
	url: 'http://192.168.1.100:8080/sopramon-web/api/sopramons',
	success: function(sopramons) {
		console.log(sopramons);
		//suppression des lignes
		$('tbody tr').remove();
		
		
		//ajout de chaque sopramon
		for (let sopramon of sopramons){
			appendSopramon(sopramon);
		}
	}
})

});
