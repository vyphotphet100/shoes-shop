$(document).ready(function() {
    $("#side__bar").before(`
    <nav id="sidebar">
    <div class="sidebar-header">
        <h3>Noriva Admin</h3>
    </div>
    <div class="sidebar__list sticky-top">
        <p>APPLICATION</p>
        <ul class="list-unstyled components">
            <li class="active">
                <a style="font-size: 14px;" href="#catalog" data-toggle="collapse" aria-expanded="false"
                    class="dropdown-toggle"><i style="padding: 7px 5px;" class="fas fa-database"></i>
                    Catalog</a>
                <ul class="collapse list-unstyled" id="catalog">
                    <li>
                        <a href="#">Product List</a>
                    </li>
                    <li>
                        <a href="#">Edit Product</a>
                    </li>
                    <li>
                        <a href="#">Category List</a>
                    </li>
                </ul>
            </li>
            <li class="active">
                <a style="font-size: 14px;" href="#customer" data-toggle="collapse" aria-expanded="false"
                    class="dropdown-toggle"><i style="padding: 7px 5px;" class="far fa-user"></i> Customers</a>
                <ul class="collapse list-unstyled" id="customer">
                    <li>
                        <a href="#">Customer List</a>
                    </li>
                    <li>
                        <a href="#">Customer</a>
                    </li>
                </ul>
            </li>
            <li class="active">
                <a style="font-size: 14px;" href="#orders" data-toggle="collapse" aria-expanded="false"
                    class="dropdown-toggle"> <i style="padding: 7px 5px;" class="fas fa-shopping-cart"></i>
                    Orders</a>
                <ul class="collapse list-unstyled" id="orders">
                    <li>
                        <a href="#">Orders List</a>
                    </li>
                    <li>
                        <a href="#">Order Details</a>
                    </li>
                </ul>
            </li>
            <li class="active">
                <a style="font-size: 14px;" href="#sellers" data-toggle="collapse" aria-expanded="false"
                    class="dropdown-toggle"> <i style="padding: 7px 5px;" class="fas fa-user-tie"></i>
                    Sellers</a>
                <ul class="collapse list-unstyled" id="sellers">
                    <li>
                        <a href="#">Sellers List</a>
                    </li>
                    <li>
                        <a href="#">Seller</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

    `)
})