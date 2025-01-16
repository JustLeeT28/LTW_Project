let selectedSeatsCount = 0; // Đếm số ghế đã chọn

// Hàm xử lý khi click vào ghế
function selectSeat(seatElement) {
    const maxSeats = 8;  // Số ghế tối đa
    const errorMessage = document.getElementById('error-message');

    // Kiểm tra nếu ghế đã được chọn thì bỏ chọn, ngược lại chọn
    if (seatElement.classList.contains('selected')) {
        seatElement.classList.remove('selected');
        updateSelectedSeats(seatElement, 'remove');
        selectedSeatsCount--;  // Giảm số lượng ghế đã chọn
        errorMessage.style.display = 'none'; // Ẩn thông báo lỗi khi số ghế hợp lệ
    } else {
        // Kiểm tra số ghế đã chọn
        if (selectedSeatsCount < maxSeats) {
            seatElement.classList.add('selected');
            updateSelectedSeats(seatElement, 'add');
            selectedSeatsCount++;  // Tăng số lượng ghế đã chọn
        } else {
            errorMessage.style.display = 'block';  // Hiển thị thông báo lỗi khi vượt quá 8 ghế
        }
    }
}

// Hàm cập nhật danh sách ghế đã chọn
function updateSelectedSeats(seatElement, action) {
    const seatNumber = seatElement.innerText;

    const seatsSelectDiv = document.getElementById('seats-select');
    if (action === 'add') {
        const seatItem = document.createElement('div');
        seatItem.classList.add('selected-seat');
        seatItem.innerText = `Ghế số: ${seatNumber}`;
        seatsSelectDiv.appendChild(seatItem);
    } else if (action === 'remove') {
        const seatItems = seatsSelectDiv.getElementsByClassName('selected-seat');
        for (let seatItem of seatItems) {
            if (seatItem.innerText === `Ghế số: ${seatNumber}`) {
                seatsSelectDiv.removeChild(seatItem);
                break;
            }
        }
    }
}
