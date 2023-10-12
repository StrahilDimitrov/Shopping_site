const backendLocation = 'http://localhost:8080/'
let productId = document.getElementById("productId").getAttribute("value");

let placeholder = document.getElementById('information');

fetch(backendLocation + "api/product/info/" + productId)
	.then(response => response.json())
	.then(productInfo => {

		let out = "";

		out += `<table>
			<tr>
				<th id = "pictures"><img src="${productInfo.image}" /></th>
				<th id = "productName"><stong>${productInfo.productName}</strong>
					</br></br>
					<span id = "productPrice">${productInfo.price} лв.</span>
				</th>
			</tr>
		</table>`

		console.log(productInfo);
		placeholder.innerHTML = out;
	})