document.addEventListener("DOMContentLoaded", function() {
    const seatTotal = parseInt(localStorage.getItem("total_amout")) || 0;

    const foodTotal = parseInt(localStorage.getItem("foodTotal")) || 0;

    const grandTotal = foodTotal;

    const formattedGrandTotal = grandTotal.toLocaleString() + " VNĐ";

    // Lấy dữ liệu đã lưu trong localStorage
    const selectedFood = JSON.parse(localStorage.getItem('selectedFood')) || [];

    // Lấy phần tử hiển thị combo-food
    const comboFoodElement = document.getElementById('combo-food');

    // Nếu có món ăn được chọn, hiển thị chúng
    if (selectedFood.length > 0) {
        document.getElementById('combo-food').innerHTML = ""; // xóa text ban đầu
        selectedFood.forEach(item => {
            const comboSummaryItem = document.createElement('div');
            comboSummaryItem.classList.add('combo-summary-item');
            comboSummaryItem.innerHTML = `
                ${item.comboName} - SL: <span class="combo-quantity">${item.quantity}</span>
            `;
            comboFoodElement.appendChild(comboSummaryItem);
        });
    } else {
        // Nếu không có món ăn nào được chọn, hiển thị thông báo
        // comboFoodElement.innerHTML = '<p>Chưa có combo nào được chọn.</p>';
    }

    // Hiển thị tổng tiền vào các phần tử liên quan
    document.getElementsByClassName('cost')[0].textContent = formattedGrandTotal;
    document.getElementsByClassName('cost')[1].textContent = formattedGrandTotal;
});
