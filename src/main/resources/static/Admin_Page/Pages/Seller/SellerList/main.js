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

function deleteSeller(id) {
    if (!confirm('Are you sure to delete this user?'))
        return;

    $.ajax({
        url: '/admin/seller/delete?id=' + id,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function(userEntity) {
            alert("Delete user successfully");
            window.location.reload();
        },
        error: function(error) {
            alert("Something went wrong")
        }
    });
}