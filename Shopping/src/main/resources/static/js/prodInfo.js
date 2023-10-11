const backendLocation = 'http://localhost:8080/'
let productId = document.getElementById("productId").getAttribute("value");

let placeholder = document.getElementById('information');

console.log("asdsdasdasda");

fetch(backendLocation + "api/product/info/" + productId)
	.then(response => response.json())
	.then(productInfo => {
		
		let out = "";

		console.log(productInfo.productName)
	})