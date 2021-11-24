(function($) {

	"use strict";

	var fullHeight = function() {

		$('.js-fullheight').css('height', $(window).height());
		$(window).resize(function(){
			$('.js-fullheight').css('height', $(window).height());
		});

	};
	fullHeight();

})(jQuery);

function refineSearch() {
	// get price value
	var price = 0;
	for (var i=0; i<document.getElementsByName('price').length; i++) {
		if (document.getElementsByName('price')[i].checked) {
			price = document.getElementsByName('price')[i].value;
			break;
		}
	}

	// get size value
	var size = 0;
	for (var i=0; i<document.getElementsByName('size').length; i++) {
		if (document.getElementsByName('size')[i].checked) {
			size = document.getElementsByName('size')[i].value;
			break;
		}
	}

	window.location.href += '&price=' + price + '&size=' + size;
}