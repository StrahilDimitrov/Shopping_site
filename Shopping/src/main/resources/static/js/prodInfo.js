const backendLocation = 'http://localhost:8080/'
let productId = document.getElementById("productId").getAttribute("value");

let placeholder = document.getElementById('information');

fetch(backendLocation + "api/product/info/" + productId)
	.then(response => response.json())
	.then(productInfo => {

		let out = "";

		out += `<table>
	<tr>
	<td><img src="${productInfo.image}"</td>
	<td><h1>Офис настолен компютър${productInfo.productName}</h1></td>
</tr>
<tr>
<th>${productInfo.price}</th>
</tr>
</table>`

		placeholder.innerHTML = out;
	})