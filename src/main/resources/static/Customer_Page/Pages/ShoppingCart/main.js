function updateQuantity(orderItemId) {
    var quantity = $('#quantity_' + orderItemId).val();
    var orderItem = {
        id: orderItemId,
        quantityBought: quantity
    }

    var result = $.ajax({
        url: '/customer/paying/shopping-cart/update-quantity',
        type: 'PUT',
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(orderItem),
        dataType: 'json',
        success: function(result) {
            return result;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    if (result.message != null) {
        alert(result.message);
        return false;
    }

    return true;
}

function resetQuantity(orderItemId) {
    var result = $.ajax({
        url: '/customer/paying/shopping-cart/get-order-item?id=' + orderItemId,
        type: 'GET',
        async: false,
        contentType: 'application/json',
        success: function(result) {
            return result;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    $('#quantity_'+orderItemId).val(result.quantityBought);
    updateTotalPrice(orderItemId);
}

function deleteOrderItem(orderItemId) {
    if (!confirm("Are you sure to delete this order item?"))
        return;

    var result = $.ajax({
        url: '/customer/paying/shopping-cart/delete-order-item?id=' + orderItemId,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function(result) {
            return result;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    window.location.reload();
}

function updateTotalCost() {
    var totalCost = 0;

    for (var i=0; i<document.getElementsByName('pay_checkbox').length; i++) {
        if (document.getElementsByName('pay_checkbox')[i].checked) {
            var orderItemId = document.getElementsByName('pay_checkbox')[i].id.split('_')[1];
            totalCost += parseFloat($('#total_cost_'+orderItemId).val());
        }
    }

    $('#total_cost').val(totalCost);
    $('#total_cost_show').text('$' + totalCost);
}

function updateTotalPrice(orderItemId) {
    if ($('#quantity_'+orderItemId).val() == '') {
        $('#total_cost_show_'+orderItemId).text('$0');
        return;
    }

    var quantity = parseFloat($('#quantity_'+orderItemId).val());
    var totalPrice = quantity*parseFloat($('#price_'+orderItemId).val());
    $('#total_cost_'+orderItemId).val(totalPrice);
    $('#total_cost_show_'+orderItemId).text('$'+totalPrice);
    updateTotalCost();
}

function checkOut() {
    // get selected order item id
    var orderItemIds = [];
    for (var i=0; i<document.getElementsByName('pay_checkbox').length; i++) {
        if (document.getElementsByName('pay_checkbox')[i].checked) {
            var orderItemId = document.getElementsByName('pay_checkbox')[i].id.split('_')[1];
            orderItemIds.push(parseInt(orderItemId));
        }
    }

    if (orderItemIds.length == 0) {
        alert('You did not choose products to checkout');
        return;
    }

    // update quantity of each selected order item
    for (var i=0; i<orderItemIds.length; i++) {
        if (!updateQuantity(orderItemIds[i]))
            return;
    }

    // add order item to ready order item
    var orderItemEntity = {
        listRequest: {
            'orderItemIds' : orderItemIds
        }
    }

    var result = $.ajax({
        url: '/customer/paying/add-ready-order-item',
        type: 'POST',
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(orderItemEntity),
        dataType: 'json',
        success: function(result) {
            return result;
        },
        error: function(error) {
            return error;
        }
    }).responseJSON;

    window.location.href = '/customer/paying/checkout';
}