document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".book-button").forEach(button => {
        button.addEventListener('click', () => {
            window.location.href = 'book.html';
        });
    });
    document.querySelectorAll(".book-button.future").forEach(button => {
        button.addEventListener('click', () => {
            window.location.href = 'detail.html';
        });
    });
});
