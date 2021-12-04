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


function deleteProduct(code) {
    if (!confirm('Are you sure to delete this product?'))
        return;

    var product = $.ajax({
        url: '/seller/product/delete?code=' + code,
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

function searchProduct() {
    if (document.getElementById("search-input").value.trim() == '')
        return;

    if (window.location.href.includes("?keyword"))
        window.location.href += "&keyword=" + document.getElementById("search-input").value;
    else
        window.location.href += "?keyword=" + document.getElementById("search-input").value;
}