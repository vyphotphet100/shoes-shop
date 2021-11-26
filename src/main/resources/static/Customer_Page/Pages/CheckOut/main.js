function pay() {
    updateUserBeforePaying();

    var result = $.ajax({
        url: '/customer/paying/pay',
        type: 'POST',
        async: false,
        contentType: 'application/json',
        success: function(result) {
            return result;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    window.location.href = result.listResult[0];
}

function updateUserBeforePaying() {
    // get payment method
    var paymentMethodId = 3;
    for (var i=0; i<document.getElementsByName('paymentMethod').length; i++)
        if (document.getElementsByName('paymentMethod')[i].checked)
            paymentMethodId = i+1;

    var user = {
        listRequest: [
            $('#phone').val(),
            $('#address').val(),
            paymentMethodId
        ]
    }

    var resultUser = $.ajax({
        url: '/customer/paying/update-user-before-paying',
        type: 'PUT',
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(user),
        dataType: 'json',
        success: function(result) {
            return result;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;
}