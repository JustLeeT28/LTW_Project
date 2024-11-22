document.addEventListener('DOMContentLoaded', function () {
    const foodItems = document.querySelectorAll('.food-item');
    const totalCostElement = document.querySelector('.total.cost');
    let totalCost = 0;

    // Lấy tổng tiền từ trang đặt ghế
    const seatTotal = parseInt(localStorage.getItem('total_amout')) || 0;
    totalCost = seatTotal; // Khởi tạo tổng tiền với giá trị từ đặt ghế
    updateDisplayTotal();

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
            }
        });

        plusBtn.addEventListener('click', (e) => {
            e.preventDefault();
            let quantity = parseInt(quantityElement.textContent);
            quantity++;
            quantityElement.textContent = quantity;
            totalCost += price; // Cộng giá tiền combo
            updateDisplayTotal();
        });
    });

    function updateDisplayTotal() {
        totalCostElement.textContent = `${totalCost.toLocaleString()} đ`;
    }

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
        window.location.href = '../Pages/Payment.html';
    });
});
