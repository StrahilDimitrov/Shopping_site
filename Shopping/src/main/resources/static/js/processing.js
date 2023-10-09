fetch("http://localhost:8080/api/products")
    .then(response => response.json())
    .then(function (processing) {
        let placeholder = document.querySelector('#info');
        let out = "";

        for (const product of processing) {
            out += `<tr>
<td><img src="${product.image}"></td>
<td>${product.productName}</td>
<td>${product.price}</td>
</tr>`;
        }
        placeholder.innerHTML = out;
    })