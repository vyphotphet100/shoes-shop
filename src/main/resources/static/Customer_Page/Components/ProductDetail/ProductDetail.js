import {style} from "./style.js";

const template = document.createElement('template');
template.innerHTML = `
    <style>
        ${style}
    </style>
    <div class="product__detail">
        <div class="product__name">
            <h2></h2>
        </div>
        <div class="product__detail__container">
            <div class="product__detail__image">
                <img>
            </div>
            <div class="product__detail__booking">
                <div class="booking__top">
                    <h1></h1>
                    <div class="product__rating">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                            <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                        </svg>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                            <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                        </svg>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                            <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                        </svg>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                            <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                        </svg>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16">
                            <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>
                        </svg>
                    </div>
                    <br>
                </div>
                <div class="booking__product__detail">
                    <br>
                    <p>Brand: <span id='brand'></span></p>
                    <p>Category: <span id='model'></p>
                    <p>Availability: <span id="stock"></p>
                    <br>
                </div>
                <div class="booking__price">
                    <br>
                    <p>Price:</p>
                    <h2><span id='price'></span></h2>
                    <br>
                </div>
                <div class="booking">
                    <br>
                    <label>Quantity</label>
                    <div class="booking__adjust">
                        <div class="quantity__adjust">
                            <div class='quantity__container'>
                                <button class='reduce__qty' id='reduce'><span>-</span></button>
                                <input value='1' class='qty__value' id='qty__value'>
                                <button class='add__qty' id='add'><span>+</span></button>
                            </div>
                        </div>
                        <div class="add__to__cart">
                            <button id="add_to_cart" class="add__cart__btn" data-toggle="modal" data-target="#announcement">ADD TO CART</button>
                        </div>
                    </div>
                    <input type="hidden" id="product_code">
                </div>
            </div>
        </div>
        <div class="product__description">
            <h2>DESCRIPTION</h2>
            <br>
            <div class="paragraph">
                <p>
                <br>
                    <span id='description'></span>
                <br>
                </p>
            </div>
        </div>
    </div>
`;

class ProductDetail extends HTMLElement {
    constructor() {
        super();

        this.attachShadow({mode: 'open'});
        this.shadowRoot.appendChild(template.content.cloneNode(true));
        this.shadowRoot.querySelector('h2').innerText = this.getAttribute('productName');
        this.shadowRoot.querySelector('h1').innerText = this.getAttribute('productName');
        this.shadowRoot.querySelector('#price').innerText = this.getAttribute('productPrice');
        this.shadowRoot.querySelector('#brand').innerText = this.getAttribute('brand');
        this.shadowRoot.querySelector('#model').innerText = this.getAttribute('model');
        if (this.getAttribute('stock') == 'true')
            this.shadowRoot.querySelector('#stock').innerText = 'In Stock';
        else
            this.shadowRoot.querySelector('#stock').innerText = 'Out of Stock';
        this.shadowRoot.querySelector('#description').innerText = this.getAttribute('description');
        this.shadowRoot.querySelector('img').src = this.getAttribute('productImage');
        this.shadowRoot.querySelector('#product_code').value = this.getAttribute('productCode');

        this.shadowRoot.querySelector('#add').addEventListener('click', () => this.addQty());
        this.shadowRoot.querySelector('#reduce').addEventListener('click', () => this.reduceQty());
        this.shadowRoot.querySelector('#add_to_cart').addEventListener('click', () => this.addToCart());
    }

    reduceQty() {
        var value = this.shadowRoot.querySelector('#qty__value').value;
        if (value == 1 || value == '1')
            return;
        value =  parseInt(value) - 1;;
        this.shadowRoot.querySelector('#qty__value').value = value;
        //console.log('123');
    }

    addQty() {
        var value = this.shadowRoot.querySelector('#qty__value').value;
        value = parseInt(value) + 1;
        this.shadowRoot.querySelector('#qty__value').value = value;
        //console.log('123');
    }

    addToCart() {
        var quantity = this.shadowRoot.querySelector('#qty__value').value;
        var productCode = this.shadowRoot.querySelector('#product_code').value;
        addProductToCart(productCode, quantity);
    }

    connectedCallBack() {
        this.shadowRoot.querySelector('#reduce').addEventListener('click', () => this.reduceQty());
        this.shadowRoot.querySelector('#add').addEventListener('click', () => this.addQty());
    }
}

window.customElements.define('product-detail', ProductDetail);