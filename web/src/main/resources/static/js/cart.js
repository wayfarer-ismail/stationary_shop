
document.querySelectorAll('.increase-quantity').forEach(function (button) {
    button.addEventListener('click', function (event) {
        event.preventDefault();
        let id = this.getAttribute('data-id');
        fetch('/cart/increase/' + id, {method: 'PATCH'})
            .then(response => response.text())
            .then(data => {
                // Update the quantity on the page
                // This assumes you have a span with the class 'quantity' inside your 'td' for quantity
                document.querySelector('.quantity[data-id="' + id + '"]').innerText = data;
            });
    });
});

document.querySelectorAll('.decrease-quantity').forEach(function (button) {
    button.addEventListener('click', function (event) {
        event.preventDefault();
        let id = this.getAttribute('data-id');
        fetch('/cart/decrease/' + id, {method: 'PATCH'})
            .then(response => response.text())
            .then(data => {
                // Update the quantity on the page
                // This assumes you have a span with the class 'quantity' inside your 'td' for quantity
                document.querySelector('.quantity[data-id="' + id + '"]').innerText = data;
            });
    });
});

document.querySelectorAll('.remove-item').forEach(function(button) {
button.addEventListener('click', function (event) {
    event.preventDefault();
    let id = this.getAttribute('data-id');
    fetch('/cart/remove/' + id, {method: 'DELETE'})
        .then(response => {
            if (response.ok) {
                // Remove the item row from the table
                // This assumes your 'tr' has a class 'item-row' and a data attribute 'data-id'
                document.querySelector('.item-row[data-id="' + id + '"]').remove();
            } else {
                console.error('Error:', response.statusText);
            }
        });
    });
});