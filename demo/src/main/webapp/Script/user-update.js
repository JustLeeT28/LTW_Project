document.addEventListener("DOMContentLoaded", function() {
    const nameInput = document.getElementById("name");
    const birthdayInput = document.getElementById("birthday");
    const emailInput = document.getElementById("email");
    const numPhoneInput = document.getElementById("numPhone");
    const clearButton = document.getElementById("clearData");
    const saveButton = document.getElementById("saveData");

    clearButton.addEventListener("click", () => {
        nameInput.value = "";
        birthdayInput.value = "";
        emailInput.value = "";
        numPhoneInput.value = "";
    });
    // saveButton.addEventListener("click", () => {
    //     const valueName = nameInput.value.trim();
    //     const valueBirthday = birthdayInput.value.trim();
    //     const valueEmail = emailInput.value.trim();
    //     const valuePhone = numPhoneInput.value.trim();
    //
    //     // Kiểm tra định dạng email
    //     const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    //     if (valueEmail && !emailRegex.test(valueEmail)) {
    //         alert("Email không đúng định dạng!");
    //         return;
    //     }
    //     // Lưu vào localStorage nếu có giá trị
    //     if (valueName) localStorage.setItem("name", valueName);
    //     if (valueBirthday) localStorage.setItem("birthday", valueBirthday);
    //     if (valueEmail) localStorage.setItem("email", valueEmail);
    //     if (valuePhone) localStorage.setItem("numPhone", valuePhone);
    //
    //     alert("Cập nhập thông tin thành công!");
    // });
});
