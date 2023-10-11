const backendLocation = 'http://localhost:8080/'
let productId = document.getElementById("productId").getAttribute("value");

console.log(productId);

fetch(backendLocation + "api/product/info/" + productId)
	.then(response => response.json())
	.then(productInfo => {
		let placeholder = document.getElementById('information');
		let out = "";

		console.log(productInfo)
	})