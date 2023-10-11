const backendLocation = 'http://localhost:8080/'
let productId = document.getElementById("productId").getAttribute("value");

let placeholder = document.getElementById('information');

fetch(backendLocation + "api/product/info/" + productId)
	.then(response => response.json())
	.then(productInfo => {
		
		let out = "";

		out += `<table>
	<tr>
	<td class="good"><img src="${productInfo.image}"</td>
	<td class="good">${productInfo.productName}</td>
</tr>
</table>`

		placeholder.innerHTML = out;
	})