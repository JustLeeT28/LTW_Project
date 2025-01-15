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

function validatePasswords() {
		// Lấy các giá trị từ các trường input
		var email = document.getElementById("signup_user_email").value;
		var name = document.getElementById("signup_user_name").value;
		var password = document.getElementById("signup_user_pass").value;
		var confirmPassword = document.getElementById("signup_user_pass2").value;

		// Kiểm tra xem tất cả các trường có được điền hay không
		if (email === "" || name === "" || password === "" || confirmPassword === "") {
			alert("Vui lòng điền đầy đủ tất cả các trường.");
			return false;  // Dừng việc gửi form
		}

		// Kiểm tra định dạng email (đảm bảo có @ và domain hợp lệ)
		var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
		if (!emailRegex.test(email)) {
			alert("Email không hợp lệ, vui lòng nhập lại.");
			return false;  // Dừng việc gửi form
		}

		// Kiểm tra mật khẩu và xác nhận mật khẩu có khớp không
		if (password !== confirmPassword) {
			alert("Mật khẩu và xác nhận mật khẩu không khớp.");
			return false;  // Dừng việc gửi form
		}

		// Nếu tất cả các kiểm tra hợp lệ, gửi form
		document.getElementById("signupForm").submit();
}


// const users = [
//     { username: 'admin', password: 'admin123', role: 'admin' },
//     { username: 'user1', password: 'user123', role: 'user' }
// ];
// document.getElementById("loginForm").addEventListener("submit", (e) => {
//     e.preventDefault();
//     const usernameOrEmail = document.getElementById("user_login").value.trim();
//     const password = document.getElementById("user_pass_login").value;
//     const user = users.find(
//         (user) => user.username === usernameOrEmail && user.password === password
//     );
//     if (user) {
//         if (user.role === "admin") {
//             window.location.href = "../Admin/dashboard.jsp";
//         } else if (user.role === "user") {
//             window.location.href = "../index.jsp";
//         }
//     } else {
//         alert("Thông tin đăng nhập không hợp lệ. Vui lòng thử lại!");
//     }
// });






