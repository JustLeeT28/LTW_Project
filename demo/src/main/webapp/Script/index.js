document.addEventListener("DOMContentLoaded", function() {
    const more_btn_0 = document.getElementsByClassName('more-bttn')[0];
    const more_btn_1 = document.getElementsByClassName('more-bttn')[1];

    more_btn_0.addEventListener("click", function() {
        window.location.href = "demo_war_exploded//movieNow";
    })
    more_btn_1.addEventListener("click", function() {
        window.location.href = "demo_war_exploded//movieFuture";
    })
});