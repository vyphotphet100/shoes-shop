function saveChange() {
    var user = {
        firstName : $('#firstName').val(),
        lastName : $('#lastName').val(),
        birthday : $('#birthday').val(),
        phone : $('#phone').val(),
        email: $('#email').val()
    }

    var resultUser = $.ajax({
        url: '/customer/my-account/edit-account',
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

    alert(resultUser.message);
}