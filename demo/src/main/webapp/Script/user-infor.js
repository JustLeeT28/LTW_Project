document.addEventListener("DOMContentLoaded", function() {
    const nameDisplay = document.getElementById("name");
    const birthdayDisplay = document.getElementById("birthday");
    const emailDisplay = document.getElementById("email");
    const numPhoneDisplay = document.getElementById("numPhone");

    // Lấy dữ liệu từ localStorage
    const savedName = localStorage.getItem("name");
    const savedBirthday = localStorage.getItem("birthday");
    const savedEmail = localStorage.getItem("email");
    const savedNumPhone = localStorage.getItem("numPhone");

    // Hiển thị dữ liệu nếu tồn tại
    if (savedName) nameDisplay.textContent = savedName;
    if (savedBirthday) birthdayDisplay.textContent = savedBirthday;
    if (savedEmail) emailDisplay.textContent = savedEmail;
    if (savedNumPhone) numPhoneDisplay.textContent = savedNumPhone;
});
