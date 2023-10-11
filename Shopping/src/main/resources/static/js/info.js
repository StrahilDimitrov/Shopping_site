fetch("test.json")
.then(response => response.json())
.then (productInfo => {
    let placeholder = document.getElementById('information');
    let out = "";

    for (const element of productInfo) {
        console.log(element);
    }
})