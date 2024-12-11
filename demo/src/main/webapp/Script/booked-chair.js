document.addEventListener('DOMContentLoaded', function () {
    const seats = document.querySelectorAll('.seat:not(.booked)');
    const seatPrice = 55000;  // Giá mỗi ghế
    let totalAmount = 0; // Biến lưu tổng tiền
    let selectedSeats = [];

    seats.forEach(seat => {
        seat.addEventListener('click', () => {
            seat.classList.toggle('selected');
            const row = seat.getAttribute('data-row'); // Lấy hàng ghế (A, B, C...)
            const seatNumber = seat.getAttribute('data-seat'); // Lấy số ghế (1, 2, 3...)
            if (seat.classList.contains('selected')) {
                selectedSeats.push(`${row}${seatNumber}`);// Lưu thông tin ghế
            } else {
                const index = selectedSeats.indexOf(`${row}${seatNumber}`);
                if (index > -1) {
                    selectedSeats.splice(index, 1);
                }
            }
            if(selectedSeats.length > 8) {
                maxChair();
            }
            displaySelectedSeats();
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
        document.getElementById("total_need_pay").textContent=`${totalAmount.toLocaleString()} VNĐ`;
    }

    // Hàm để hiển thị các ghế đã chọn
    function displaySelectedSeats() {
        const selectedSeatsElement = document.getElementById("seats-select"); // Phần tử hiển thị danh sách ghế đã chọn
            selectedSeatsElement.textContent = `${selectedSeats.join(", ")}`; // Hiển thị danh sách ghế đã chọn

    }

    // giới hạn 8 ghế 1 lần mua
    function maxChair(){
        const lastSelectedSeat = selectedSeats[selectedSeats.length - 1]; // Lấy ghế vừa thêm vào
        selectedSeats.splice(selectedSeats.length - 1, 1); // Xóa ghế cuối khỏi danh sách đã chọn
        // Tìm ghế trong và bỏ trạng thái 'selected'
        seats.forEach(seat => {
            const row = seat.getAttribute('data-row');
            const seatNumber = seat.getAttribute('data-seat');
            if (`${row}${seatNumber}` === lastSelectedSeat) {
                seat.classList.remove('selected'); // Bỏ chọn ghế
            }
        });
        alert(`Bạn chỉ được chọn tối đa 8 ghế trong 1 lần mua!`);
    }
    document.getElementsByClassName("btn-book")[0].addEventListener('click', () => {
        localStorage.setItem('total_amout', totalAmount);
        localStorage.setItem('selected_seats', JSON.stringify(selectedSeats));
        window.location.href='../Pages/order-food.html';

    })
});

