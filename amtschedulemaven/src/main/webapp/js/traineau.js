/**
 * 
 */
(function($) {
	var jour;
	var debut;
	var fin;

	function modifier() {
		jour = $('#jour').val();
		debut = $('#debut').val();
		fin = $('#fin').val();
		params = {
			opt : 'modifier',
			matricule : '16w2182',
			num : 101,
			jour : jour,
			debut : debut,
			fin : fin
		};

		$.post('traineaux', params, function(data) {
			alert(data);
		});
	}

	function supprimer() {
		params = {
			opt : 'supprimer',
			matricule : '16w2182',
			num : 101
		};

		$.post('traineaux', params, function(data) {
			if (data == 'succes') {
				alert(data);
			}
		});
	}

	function ajouter() {
		jour = $('#jour').val();
		debut = $('#debut').val();
		fin = $('#fin').val();
		params = {
			opt : 'ajouter',
			matricule : '16w2182',
			jour : jour,
			debut : debut,
			fin : fin
		};

		$.post('traineaux', params, function(data) {
			alert(data);
		});
	}

	$('#modifier').on('click', modifier);
	$('#supprimer').on('click', supprimer);
	$('#ajouter').on('click', ajouter);
})(jQuery);