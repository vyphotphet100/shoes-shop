function searchProduct() {
    var categoryCode = $('#category-header').val();
    var keyword = $('#search-product-input').val();

    if (categoryCode != '' && keyword != '' && keyword != null)
        window.location.href = "/customer/product/product-list?limit=12&categoryCode=" + categoryCode + "&keyword=" + keyword;
    else if (keyword != '' && keyword != null)
        window.location.href = "/customer/product/product-list?limit=12&keyword=" + keyword;

}


