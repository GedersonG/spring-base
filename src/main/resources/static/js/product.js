function getFormData() {
    const data = {};

    data.name = document.getElementById('name').value;
    data.description = document.getElementById('description').value;
    data.price = document.getElementById('price').value;
    data.stock = document.getElementById('stock').value;

    return data;
}

async function addProduct() {
    try {
        const data = getFormData();

        const response = await fetch('api/products', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert('Product created!');
            window.location.href = 'index.html';
        } else {
            const errorData = await response.json();
            throw new Error(errorData.message);
        }
    } catch (error) {
        console.error('Error:', error.message);
        alert('An error occurred while creating the product.');
    }
}
