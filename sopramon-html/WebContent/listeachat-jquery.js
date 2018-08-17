
function appendProduit(produit) {
	let myRow = $("<tr />");
	let myColNom = $("<td />");
	let myColPrix = $("<td />");
	let myColAction = $("<td />");
	let myButton = $("<button />");
	
	//AFFECTER LE CONTENU A MES COLONNES
	myColNom.html(produit.nom);
	myColPrix.html(produit.prix);
	myColAction.append(myButton);
	
	//GESTION DU BOUTON
	myButton.html("ACHETER");
	myButton.bind('click', function() {
		alert("Article " + produit.nom +" achete !");
	});
	
	//DONNER LES COLONNES A LA LIGNE
	myRow.append(myColNom);
	myRow.append(myColPrix);
	myRow.append(myColAction);
	
	//DONNER LA LIGNE AU TABLEAU
	$('#produits tbody').append(myRow);
}


//CHARGER LES PRODUITS
$('button.btn-load').bind('click', function() {
	$('tbody tr').remove();
	$.ajax({
		method: 'GET',
		url: 'http://192.168.1.100:8080/sopramon-web/api/items',
		success: function(produits) {
			console.log(produits);
			
			//AJOUT DE CHAQUE PRODUIT
			for (let produit of produits) {
				appendProduit(produit);
			}
		}
	});
});