function saveChange() {
    var passwordInfo = {
        listRequest: {
            'oldPassword': $('#oldPassword').val(),
            'newPassword' : $('#newPassword').val(),
            'confirmPassword' : $('#confirmPassword').val()
        }
    }

    var resultUser = $.ajax({
        url: '/customer/my-account/change-password',
        type: 'PUT',
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(passwordInfo),
        dataType: 'json',
        success: function(result) {
            return result;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    alert(resultUser.message);
    if (resultUser.httpStatus == 'OK')
        window.location.reload();
}