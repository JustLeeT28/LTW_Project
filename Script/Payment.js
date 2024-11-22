document.addEventListener("DOMContentLoaded", function() {
    const seatTotal = parseInt(localStorage.getItem("total_amout")) || 0;

    const foodTotal = parseInt(localStorage.getItem("foodTotal")) || 0;

    const grandTotal = seatTotal + foodTotal;

    const formattedGrandTotal = grandTotal.toLocaleString() + " VNĐ";

    // Hiển thị tổng tiền vào các phần tử liên quan
    document.getElementsByClassName('cost')[0].textContent = formattedGrandTotal;
    document.getElementsByClassName('cost')[1].textContent = formattedGrandTotal;
});
