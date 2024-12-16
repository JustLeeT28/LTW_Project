document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".book-button").forEach(button => {
        button.addEventListener('click', () => {
            window.location.href = basePath + "/Pages/book.jsp";
        });
    });
    document.querySelectorAll(".book-button.future").forEach(button => {
        button.addEventListener('click', () => {
            window.location.href = basePath + "/Pages/detail.jsp";
        });
    });
});
