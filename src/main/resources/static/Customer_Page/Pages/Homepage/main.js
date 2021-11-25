var counter = 1;
setInterval(function(){
    document.getElementById('radio'+counter).checked = true;
    counter++;
    if (counter>4){
        counter=1;
    }
},6000);

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