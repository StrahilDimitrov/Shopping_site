let searchForm = document.querySelector('.search-form');
document.querySelector('#search').onclick = () => {
    searchForm.classList.toggle('active');
    shoppingCart.classList.remove('active');
    logIn.classList.remove('active');
    menu.classList.remove('active');
}

let shoppingCart = document.querySelector('.shopping-cart');
document.querySelector('#cart').onclick = () => {
    shoppingCart.classList.toggle('active');
    searchForm.classList.remove('active');
    logIn.classList.remove('active');
    menu.classList.remove('active')
}

let logIn = document.querySelector('.login');
document.querySelector('#user').onclick = () => {
    logIn.classList.toggle('active');
    searchForm.classList.remove('active');
    shoppingCart.classList.remove('active');
    menu.classList.remove('active')
}

let menu = document.querySelector('.navbar');
document.querySelector('#menu').onclick = () => {
    menu.classList.toggle('active');
    searchForm.classList.remove('active');
    shoppingCart.classList.remove('active');
    logIn.classList.remove('active');

}

window.onscroll = () => {
    searchForm.classList.remove('active');
    shoppingCart.classList.remove('active');
    logIn.classList.remove('active');
    menu.classList.remove('active');
}