/**
 * 
 */
function cssrgc() {
	jQuery.fx.off = false;
	$('p').css('color', 'red');
	$('div b').css('color', 'green');
	$('li:eq(10)').css('color', 'blue');
	$('#top').fadeIn(2000);
	$('img').on('click', function(event) {
		var date = new Date(event.timeStamp);
		window.alert('il est ' + date);
	});
	$('.pleft:eq(0)').hide();
	$('.pleft:eq(0)').show(3000);
	$('.pleft:eq(1)').slideUp();
	$('.pleft:eq(2)').hide();
	$('.pleft:eq(2)').slideDown();
	$('.pleft:eq(3)').fadeOut('slow').delay('2000').fadeIn('fast');
	$('#load_top').on('click', function() {
		$('#top').load('top.html p', function() {
			$.getJSON('file/fichier.json', function(donnees) {
				$('#nom-prenom').html(donnees.nom_prenom);
				$('#titre-pro').html(donnees.titre_pro);
				$('#experience').html(donnees.experience);
				$('#coordonnee').html(donnees.coordonnee);
			})
		});
	});
	$('#load_top').button();
	$('.section').draggable();
}
