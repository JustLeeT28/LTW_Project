document.addEventListener('DOMContentLoaded', function () {
    const seats = document.querySelectorAll('.seat:not(.booked)');
    const seatPrice = 55000;  // Giá mỗi ghế
    let totalAmount = 0; // Biến lưu tổng tiền
    seats.forEach(seat => {
        seat.addEventListener('click', () => {
            seat.classList.toggle('selected');
            calculateTotal();
        });
    });
    function calculateTotal(){
        totalAmount = 0;
        seats.forEach(seat => {
            if(seat.classList.contains('selected')){
                totalAmount += seatPrice;
            }
        })
        document.getElementById("total_need_pay").textContent=totalAmount.toLocaleString() +" VNĐ";
    }
});

