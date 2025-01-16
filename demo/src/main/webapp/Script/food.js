document.addEventListener('DOMContentLoaded', function () {
    const plusButtons = document.querySelectorAll('.icon-plus');
    const minusButtons = document.querySelectorAll('.icon-minus');
    const orderSummary = document.querySelector('.order-summary');

    plusButtons.forEach(button => {
        button.addEventListener('click', function (e) {
            e.preventDefault();
            const quantityElement = this.previousElementSibling;
            let quantity = parseInt(quantityElement.textContent);
            quantity++;

            // Cập nhật số lượng
            quantityElement.textContent = quantity;

            // Cập nhật giá trị ẩn trong input
            const hiddenInput = this.closest('.quantity').querySelector('input');
            hiddenInput.value = quantity;

            // Cập nhật order-summary
            updateOrderSummary();
        });
    });

    minusButtons.forEach(button => {
        button.addEventListener('click', function (e) {
            e.preventDefault();
            const quantityElement = this.nextElementSibling;
            let quantity = parseInt(quantityElement.textContent);
            if (quantity > 0) {
                quantity--;
                quantityElement.textContent = quantity;

                // Cập nhật giá trị ẩn trong input
                const hiddenInput = this.closest('.quantity').querySelector('input');
                hiddenInput.value = quantity;
            }

            // Cập nhật order-summary
            updateOrderSummary();
        });
    });

    function updateOrderSummary() {
        const foodItems = document.querySelectorAll('.food-item');
        let summaryContent = '';
        let totalPrice = 0;

        foodItems.forEach(item => {
            const quantity = parseInt(item.querySelector('.number').textContent);
            if (quantity > 0) {
                const name = item.querySelector('h3').textContent;
                const price = parseFloat(item.querySelector('.price').textContent.replace('đ', '').replace(',', ''));
                const itemTotal = quantity * price;
                totalPrice += itemTotal;

                // Thêm vào summary
                summaryContent += `<p>${name} x${quantity} - ${itemTotal.toLocaleString()} đ</p>`;
            }
        });

        // Hiển thị thông tin trong order-summary
        if (summaryContent) {
            orderSummary.innerHTML = summaryContent;
        } else {
            orderSummary.innerHTML = '<p>Chưa có combo nào được chọn.</p>';
        }

        // Cập nhật tổng tiền
        document.querySelector('.total .cost').textContent = totalPrice.toLocaleString() + ' đ';
    }
});
document.addEventListener('DOMContentLoaded', function () {
    const continueButton = document.querySelector('.btn-continue');

    continueButton.addEventListener('click', function (e) {
        e.preventDefault();  // Ngăn không cho trang chuyển hướng ngay lập tức

        // Lấy thông tin combo và số lượng từ các món ăn đã chọn
        let comboData = [];

        const foodItems = document.querySelectorAll('.food-item');
        foodItems.forEach(item => {
            const quantity = parseInt(item.querySelector('.number').textContent);
            const id = item.querySelector('.quantity').getAttribute('data-id');

            if (quantity > 0) {
                comboData.push({ id: id, quantity: quantity });
            }
        });

        // Lấy ID phim từ đối tượng `movie` (có thể thay đổi theo cách bạn lưu thông tin phim)
        const movieId = document.getElementById('movieId').value; // ID của movie hiện tại
        const roomID = document.getElementById('roomId').value; // ID của phòng chiếu hiện tại

        // Xây dựng query string cho comboId và quantity nếu có combo được chọn
        let queryString = `movieId=${movieId}&roomId=${roomID}`;
        comboData.forEach(data => {
            queryString += `&comboId=${data.id}&quantity=${data.quantity}`;
        });

        // Xây dựng URL cho trang checkout với các query parameters
        const checkoutUrl = `checkout?${queryString}`;

        // Chuyển hướng đến trang checkout
        window.location.href = checkoutUrl;
    });
});

