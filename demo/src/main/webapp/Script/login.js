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






