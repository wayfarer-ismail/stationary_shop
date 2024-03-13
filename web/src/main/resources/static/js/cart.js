document.querySelectorAll('.increase-quantity').forEach(function (button) {
    button.addEventListener('click', function (event) {
        event.preventDefault();
        let id = this.getAttribute('data-id');
        fetch('/cart/increase/' + id, {method: 'PATCH'})
            .then(response => response.text())
            .then(() => {
                window.location.reload();
            });
    });
});

document.querySelectorAll('.decrease-quantity').forEach(function (button) {
    button.addEventListener('click', function (event) {
        event.preventDefault();
        let id = this.getAttribute('data-id');
        fetch('/cart/decrease/' + id, {method: 'PATCH'})
            .then(response => response.text())
            .then(() => {
                window.location.reload();
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
                    window.location.reload();
                } else {
                    console.error('Error:', response.statusText);
                }
            });
    });
});