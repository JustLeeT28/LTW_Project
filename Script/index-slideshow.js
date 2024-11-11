document.addEventListener("DOMContentLoaded", function () {
    const listImage = document.querySelector(".list-img");
    const imgs = document.getElementsByClassName("slide-img");
    const dots = document.querySelectorAll(".dot");
    let currentIndex = 0;

    function updateSlideShow() {
        let width = imgs[0].offsetWidth;
        listImage.style.transition = "transform 0.5s ease";
        listImage.style.transform = `translateX(-${width * currentIndex}px)`;

        dots.forEach((dot, index) => {
            if (index === currentIndex) {
                dot.classList.add("active");
            } else {
                dot.classList.remove("active");
            }
        });
    }

    let autoSlide = setInterval(() => {
        currentIndex++;
        if (currentIndex >= imgs.length) {
            currentIndex = 0;
        }
        updateSlideShow();
    }, 2000);

    const btnLeft = document.querySelector(".btn-left");
    btnLeft.addEventListener("click", function () {
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = imgs.length - 1;
        }
        updateSlideShow();
        resetAutoSlide();
    });

    const btnRight = document.querySelector(".btn-right");
    btnRight.addEventListener("click", function () {
        currentIndex++;
        if (currentIndex >= imgs.length) {
            currentIndex = 0;
        }
        updateSlideShow();
        resetAutoSlide();
    });

    function resetAutoSlide() {
        clearInterval(autoSlide);
        autoSlide = setInterval(() => {
            currentIndex++;
            if (currentIndex >= imgs.length) {
                currentIndex = 0;
            }
            updateSlideShow();
        }, 2000);
    }

    if (dots.length > 0) {
        dots[0].classList.add("active");
    }
});
