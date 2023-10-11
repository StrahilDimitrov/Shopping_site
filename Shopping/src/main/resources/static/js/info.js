const backendLocation = 'http://localhost:8080/'
let productId = document.getElementById("productId").getAttribute("value");

fetch(backendLocation + "/product/info/" + productId)
	.then(response => response.json())
	.then(productInfo => {
		let placeholder = document.getElementById('information');
		let out = "";

		for (const element of productInfo) {
			console.log(element);
		}
	})