function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imageResult')
                .attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

$(function () {
    $('#upload').on('change', function () {
        readURL(input);
    });
});


var input = document.getElementById( 'upload' );
var infoArea = document.getElementById( 'upload-label' );


function deleteCustomer(id) {
    if (!confirm('Are you sure to delete this user?'))
        return;

    var user = $.ajax({
        url: '/admin/customer/delete?id=' + id,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function(userEntity) {
            return userEntity;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    alert(user.message);
    window.location.reload();
}