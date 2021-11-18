$(document).ready(function() {
    $("#accountslide_bar").before(`
    <nav id="sidebar">
    <div class="p-5 pt-5">
        <h2 class="account__h2" style="text-transform: uppercase;">Account</h2>
        <ul class="list-unstyled components mb-5">
            <li>
                <a class="account__links" href="/customer/my-account/login">Login</a>
            <li>
                <a class="account__links" href="/customer/my-account/register">Register</a>
            </li>
            <li>
                <a class="account__links" href="/customer/my-account/account">My Account</a>
            </li>
            <li>
                <a class="account__links" href="/customer/my-account/order-history">Order History</a>
            </li>
            <li>
                <a class="account__links" href="/customer/my-account/create-seller">Become Our Seller</a>
            </li>
        </ul>
    </div>
    <div class="p-5" style="margin-top: -100px;">
        <h2 class="account__h2" style="text-transform: uppercase;">Information</h2>
        <ul class="list-unstyled components mb-5">
            <li>
                <a class="account__links" href="/customer/information/about-us">About Us</a>
            <li>
                <a class="account__links" href="/customer/information/privacy-policy">Privacy Policy</a>
            </li>
            <li>
                <a class="account__links" href="/customer/information/tearm-and-conditions">Terms & Conditions</a>
            </li>
            <li>
                <a class="account__links" href="/customer/information/contact-us">Contact Us</a>
            </li>
        </ul>
    </div>
</nav>
    `)
})