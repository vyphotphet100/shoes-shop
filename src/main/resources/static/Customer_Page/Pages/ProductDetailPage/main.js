function addProductToCart(producCode, quantity) {
    var orderItem = {
        listRequest: {
            'productCode': producCode,
            'quantity': parseInt(quantity)
        }
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

