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

function addProductToCart(producCode, quantity) {
    var orderItem = {
        listRequest: [producCode, parseInt(quantity)]
    }

    var result = $.ajax({
        url: '/customer/product/add-product-to-cart',
        type: 'POST',
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(orderItem),
        dataType: 'json',
        success: function(result) {
            return result;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    $('#announcement_content').text(result.message);
    $('#announcement').modal('show');
    // if (result.httpStatus == 'OK')
    //     window.location.reload();
}

function getProductItem() {
    window.location.href += '&limit=' + document.getElementById('show_value').value;
}





