document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".btn-pay").forEach(button => {
        button.addEventListener('click', () => {
            alert('Thanh toán thành công')
            window.location.href = 'index.html';
        });
    });

});
