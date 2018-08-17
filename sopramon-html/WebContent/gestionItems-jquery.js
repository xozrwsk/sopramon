function appendItem(item) {
	let myRow = $("<tr/>");
	let myColNom = $("<td/>");
	let myColPrix = $("<td/>");
	let myColPV = $("<td/>");
	let myColAttaque = $("<td/>");
	let myColDefense = $("<td/>");
	let myColEsquive = $("<td/>");
	let myVitesse = $("<td/>");
	let myButtonDelete = $("<button/>");
	
	
	// Affecter le contenu à mes colonnes
	myColNom.html(item.nom);
	myColPrix.html(item.prix);
	myColPV.html(item.PV);
	myColAttaque.html(item.attaque);
	myColDefense.html(item.defense);
	myColEsquive.html(item.esquive);
	myVitesse.html(item.vitesse);
	myColAction.append(myButtonDelete);
	
	// Gestion du bouton
	myButtonDelete.html("SUPPRIMER");
	myButtonDelete.bind('click', function(){
		$(this).closest('tr').remove();
	});
	
	// Donner les colonnes à la ligne
	myRow.append(myColNom);
	myRow.append(myColPrix);
	myRow.append(myColPV);
	myRow.append(myColAttaque);
	myRow.append(myColDefense);
	myRow.append(myColEsquive);
	myRow.append(myColVitesse);
	myRow.append(myColAction);
	
	// Donner la ligne au tableau
	$('#items tbody').append(myRow);
}