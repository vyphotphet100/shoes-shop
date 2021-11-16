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

function deleteProduct(code) {
    if (!confirm('Are you sure to delete this product?'))
        return;

    var product = $.ajax({
        url: '/admin/product/delete?code=' + code,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function(productDto) {
            return productDto;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    alert(product.message);
    window.location.reload();
}