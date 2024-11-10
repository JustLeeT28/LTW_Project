document.addEventListener("DOMContentLoaded", function () {
    const listImage = document.querySelector(".list-img");
    const imgs = document.getElementsByClassName("slide-img");
    let currentIndex = 0;

    setInterval(() => {
        // Lấy chiều rộng của mỗi ảnh (tất cả ảnh có cùng chiều rộng)
        let width = imgs[0].offsetWidth;

        // Di chuyển sang ảnh tiếp theo
        currentIndex++;

        // Kiểm tra nếu đã đến ảnh cuối cùng, reset về đầu tiên
        if (currentIndex >= imgs.length) {
            currentIndex = 0;
        }

        // Chuyển `.list-img` để hiển thị ảnh tiếp theo
        listImage.style.transition = "transform 0.5s ease";  // Thêm hiệu ứng mượt mà khi di chuyển
        listImage.style.transform = `translateX(-${width * currentIndex}px)`;
    }, 2000);
});
