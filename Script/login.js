jQuery(document).ready(function($) {
	tab = $('.tabs h3 a');

	tab.on('click', function(event) {
		event.preventDefault();
		tab.removeClass('active');
		$(this).addClass('active');

		tab_content = $(this).attr('href');
		$('div[id$="tab-content"]').removeClass('active');
		$(tab_content).addClass('active');
	});
});      
document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.querySelector(".login-form");

    loginForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const usernameOrEmail = document.getElementById("user_login").value;
        const password = document.getElementById("user_pass").value;
        if (usernameOrEmail === "admin" && password === "admin123") {
            window.location.href = "admin_dashboard.html"; //neu la admin
        } else if (usernameOrEmail === "user" && password === "user123") {
            window.location.href = "user_dashboard.html"; //neu la tk thuong
        } else {
            alert("Thông tin đăng nhập không hợp lệ. Vui lòng thử lại!");
        }
    });
});
