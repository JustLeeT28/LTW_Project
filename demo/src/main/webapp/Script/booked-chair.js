document.addEventListener('DOMContentLoaded', function () {
    const seatPriceElement = document.getElementById('seatPrice');
    const seatPrice = seatPriceElement.getAttribute('data-seatPrice');  // Lấy giá mỗi ghế từ JSP
    let totalAmount = 0; // Biến lưu tổng tiền
    let selectedSeats = [];
    let seatsId = []; // Mảng chứa các seatId đã chọn

    const seats = document.querySelectorAll('.seat:not(.booked)');
    seats.forEach(seat => {
        seat.addEventListener('click', () => {
            seat.classList.toggle('selected');
            const row = seat.getAttribute('data-row'); // Lấy hàng ghế (A, B, C...)
            const seatNumber = seat.getAttribute('data-seat'); // Lấy số ghế (1, 2, 3...)
            const seatId = seat.getAttribute('data-seatId'); // Lấy seatId

            if (seat.classList.contains('selected')) {
                selectedSeats.push(`${row}${seatNumber}`); // Lưu thông tin ghế
                seatsId.push(seatId);  // Lưu seatId vào mảng
            } else {
                const index = selectedSeats.indexOf(`${row}${seatNumber}`);
                if (index > -1) {
                    selectedSeats.splice(index, 1);
                    seatsId.splice(index, 1); // Xóa seatId tương ứng khi bỏ chọn ghế
                }
            }

            if (selectedSeats.length > 8) {
                maxChair();
            }

            displaySelectedSeats();
            calculateTotal();  // Tính tổng tiền
        });
    });

    function calculateTotal() {
        totalAmount = 0;
        seats.forEach(seat => {
            if (seat.classList.contains('selected')) {
                totalAmount += parseFloat(seatPrice);  // Cộng giá mỗi ghế vào tổng tiền
            }
        });
        document.getElementById("total_need_pay").textContent = `${totalAmount.toLocaleString()} VNĐ`;
    }

    // Hàm để hiển thị các ghế đã chọn
    function displaySelectedSeats() {
        const selectedSeatsElement = document.getElementById("seats-select");
        selectedSeatsElement.textContent = `${selectedSeats.join(", ")}`;
    }

    // Giới hạn tối đa 8 ghế
    function maxChair() {
        const lastSelectedSeat = selectedSeats[selectedSeats.length - 1];
        selectedSeats.splice(selectedSeats.length - 1, 1);
        seatsId.splice(seatsId.length - 1, 1);

        seats.forEach(seat => {
            const row = seat.getAttribute('data-row');
            const seatNumber = seat.getAttribute('data-seat');
            if (`${row}${seatNumber}` === lastSelectedSeat) {
                seat.classList.remove('selected');
            }
        });
        alert(`Bạn chỉ được chọn tối đa 8 ghế trong 1 lần mua!`);
    }

    // Khi nhấn "Đặt vé", tạo URL và điều hướng đến trang mới
    document.getElementsByClassName("btn-book")[0].addEventListener('click', () => {
        const movieId = document.getElementById('movieId').value;
        const showtimeId = document.getElementById('showtimeId').value;
        const roomId = document.getElementById('roomId').value;
        const seatsIdJson = seatsId.join(",");

        const url = `orderFood?mId=${movieId}&showtimeId=${showtimeId}&roomId=${roomId}&seatsId=${seatsIdJson}`;

        window.location.href = url;
    });
});
