/**
 * 
 */
(function($) {
	var jour;
	var debut;
	var fin;
	var titre;
	var contenance;
	var niveau;

	function supprimer() {
		params = {
			opt : 'supprimer',
			matricule : '16w2182',
			jour : jour,
			debut : debut,
			fin : fin
		};

		$.post('evenements', params, function(data) {
			alert(data);
		});
	}

	function ajouter() {
		jour = $('#jour').val();
		debut = $('#debut').val();
		fin = $('#fin').val();
		titre = $('#titre').val();
		contenance = $('#contenance').val();
		niveau = $('#niveau').val();
		params = {
			opt : 'ajouter',
			matricule : '16w2182',
			jour : jour,
			debut : debut,
			fin : fin,
			niveau : niveau,
			titre : titre,
			contenance : contenance
		};

		$.post('evenements', params, function(data) {
			alert(data);
		});
	}

	$('#supprimer').on('click', supprimer);
	$('#ajouter').on('click', ajouter);
})(jQuery);