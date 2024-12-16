document.addEventListener('DOMContentLoaded', function () {
    const foodItems = document.querySelectorAll('.food-item');
    const totalCostElement = document.querySelector('.total.cost');
    let totalCost = 0;
    const orderSummary = document.querySelector('.order-summary');
    // Lấy tổng tiền từ trang đặt ghế
    const seatTotal = parseInt(localStorage.getItem('total_amout')) || 0;
    totalCost = seatTotal; // Khởi tạo tổng tiền với giá trị từ đặt ghế
    updateDisplayTotal();

    let chairsSelected = document.getElementById('all-chairs-selected');
    const selectedSeats = JSON.parse(localStorage.getItem('selected_seats'));

    foodItems.forEach(item => {
        const minusBtn = item.querySelector('.icon-minum');
        const plusBtn = item.querySelector('.icon-plus');
        const quantityElement = item.querySelector('.number');
        const price = parseInt(item.querySelector('.price').textContent.replace(',', ''));

        minusBtn.addEventListener('click', (e) => {
            e.preventDefault();
            let quantity = parseInt(quantityElement.textContent);
            if (quantity > 0) {
                quantity--;
                quantityElement.textContent = quantity;
                totalCost -= price; // Trừ giá tiền combo
                updateDisplayTotal();
                updateOrderSummary();
            }
        });

        plusBtn.addEventListener('click', (e) => {
            e.preventDefault();
            let quantity = parseInt(quantityElement.textContent);
            quantity++;
            quantityElement.textContent = quantity;
            totalCost += price; // Cộng giá tiền combo
            updateDisplayTotal();
            updateOrderSummary();
        });
    });

    function updateDisplayTotal() {
        totalCostElement.textContent = `${totalCost.toLocaleString()} đ`;
    }

    function updateOrderSummary() {
        // Xóa tất cả combo cũ trong order summary
        orderSummary.innerHTML = '';
        // Duyệt qua tất cả các combo
        foodItems.forEach(item => {
            const quantity = parseInt(item.querySelector('.number').textContent);
            if (quantity > 0) {
                // Tạo phần tử hiển thị combo đã chọn
                const comboName = item.querySelector('h3').textContent;
                const comboSummaryItem = document.createElement('div');
                comboSummaryItem.classList.add('combo-summary-item');
                comboSummaryItem.innerHTML = `
                    ${comboName} - SL: <span class="combo-quantity">${quantity}</span>
                `;
                orderSummary.appendChild(comboSummaryItem);
            }
        });

        // Nếu không có combo nào, hiển thị thông báo
        if (orderSummary.children.length === 0) {
            orderSummary.innerHTML = '<p>Chưa có combo nào được chọn.</p>';
        }
    }

    chairsSelected = selectedSeats.join(", ");
    document.getElementById('all-chairs-selected').textContent = chairsSelected;

    // Lưu thông tin và chuyển hướng
    document.querySelector('.btn-continue').addEventListener('click', () => {
        const selectedItems = [];
        foodItems.forEach(item => {
            const quantity = parseInt(item.querySelector('.number').textContent);
            if (quantity > 0) {
                const comboName = item.querySelector('h3').textContent;
                selectedItems.push({ comboName, quantity });
            }
        });
        localStorage.setItem('selectedFood', JSON.stringify(selectedItems));
        localStorage.setItem('foodTotal', totalCost);
        localStorage.setItem('chairsSelected',chairsSelected);
        window.location.href = '../Pages/Payment.jsp';
    });
});




