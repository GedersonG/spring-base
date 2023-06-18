async function getProductById(id) {
    const response = await fetch(`api/products/${id}`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    return await response.json();
}

function populateFields(product) {
    document.getElementById('name').value = product.name;
    document.getElementById('description').value = product.description;
    document.getElementById('price').value = product.price;
    document.getElementById('stock').value = product.stock;
}

async function chargeProduct() {
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    const product = await getProductById(id);
    populateFields(product);
}

async function updateProduct() {
    let data = {};
    data.name = document.getElementById('name').value;
    data.description = document.getElementById('description').value;
    data.price = document.getElementById('price').value;
    data.stock = document.getElementById('stock').value;

    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    await fetch(`api/products/update/${id}`, {
        method: 'PATCH',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    alert('Product updated!');
    window.location.href = 'index.html';
}

chargeProduct();
