const backendLocation = 'http://localhost:8080/'
let productId = document.getElementById("productId").getAttribute("value");
let counter = 0;

let placeholder = document.getElementById('information');

fetch(backendLocation + "api/product/info/" + productId)
	.then(response => response.json())
	.then(productInfo => {

		let out = "";

		out += `<tr>
				<th id = "pictures"><img src="${productInfo.image}" /></th>
				<th id = "productName"><stong>${productInfo.productName}</strong>
					</br></br>
					<span id = "productPrice">${productInfo.price} лв.</span>
				</th>
			</tr>`

		for (const element of productInfo.specs) {
			if(counter % 2 === 0){
				out += `<tr id = "color">
					<th>${element.name}</th>
					<th>${element.value}</th>
				</tr>
			</table>`
			}
			else{
				out += `<tr>
					<th>${element.name}</th>
					<th>${element.value}</th>
				</tr>`
			}
			counter++;
		}
		placeholder.innerHTML = out;
	})