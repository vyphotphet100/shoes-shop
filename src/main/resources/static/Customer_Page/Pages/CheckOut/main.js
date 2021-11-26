function pay() {
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