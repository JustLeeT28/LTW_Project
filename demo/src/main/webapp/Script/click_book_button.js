document.addEventListener("DOMContentLoaded", function () {
    document.querySelectorAll(".book-button").forEach(button => {
        button.addEventListener('click', (event) => {
            // Lấy ID của phim từ phần tử cha (div .movie)
            const movieId = button.closest('.movie').querySelector('a').getAttribute('href').split('id=')[1];

            // Chuyển hướng đến trang book.jsp với id
            window.location.href = basePath + "book";
        });
    });

    document.querySelectorAll(".book-button.future").forEach(button => {
        button.addEventListener('click', () => {
            window.location.href = basePath + "/Pages/detail.jsp";
        });
    });
});
