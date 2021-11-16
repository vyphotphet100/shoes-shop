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

input.addEventListener( 'change', showFileName );
function showFileName( event ) {
  var input = event.srcElement;
  var fileName = input.files[0].name;
  infoArea.textContent = 'File name: ' + fileName;
}

function deleteCustomer(id) {
    if (!confirm('Are you sure to delete this user?'))
        return;

    var user = $.ajax({
        url: '/admin/customer/delete?id=' + id,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function(userEntity) {
            alert("Delete user successfully");
            window.location.href = '/admin/customer/customer-list';
        },
        error: function(error) {
            alert("Something went wrong")
        }
    });
}