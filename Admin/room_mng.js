const rooms = [];

// Thêm phòng chiếu mới
function addRoom() {
    const roomName = document.getElementById('roomName').value;
    const seatCount = parseInt(document.getElementById('seatCount').value);

    if (roomName && seatCount > 0) {
        const newRoom = {
            name: roomName,
            seatCount,
            status: "Đang hoạt động", // Mặc định trạng thái là "Đang hoạt động"
            seatMap: generateSeatMap(seatCount)
        };

        rooms.push(newRoom);
        renderRooms();
    } else {
        alert("Vui lòng nhập đúng thông tin phòng chiếu.");
    }
}

// Tạo sơ đồ chỗ ngồi với các loại ghế khác nhau
function generateSeatMap(seatCount) {
    const seatMap = [];
    for (let i = 0; i < seatCount; i++) {
        let seatType = "regular";
        if (i < 5) seatType = "vip";
        if (i >= seatCount - 5) seatType = "special";
        seatMap.push({ id: i + 1, type: seatType, occupied: false });
    }
    return seatMap;
}

// Hiển thị danh sách phòng chiếu
function renderRooms() {
    const roomTable = document.getElementById('roomTable').getElementsByTagName('tbody')[0];
    roomTable.innerHTML = '';

    rooms.forEach((room, index) => {
        const row = roomTable.insertRow();
        row.insertCell(0).textContent = room.name;
        row.insertCell(1).textContent = room.seatCount;
        row.insertCell(2).textContent = room.status;

        const actionCell = row.insertCell(3);

        // Nút xóa phòng
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Xóa';
        deleteBtn.onclick = () => deleteRoom(index);
        actionCell.appendChild(deleteBtn);

        // Nút hiển thị sơ đồ chỗ ngồi
        const viewSeatsBtn = document.createElement('button');
        viewSeatsBtn.textContent = 'Xem sơ đồ';
        viewSeatsBtn.onclick = () => renderSeatMap(room.seatMap);
        actionCell.appendChild(viewSeatsBtn);
    });
}

// Xóa phòng chiếu
function deleteRoom(index) {
    rooms.splice(index, 1);
    renderRooms();
}

// Hiển thị sơ đồ chỗ ngồi
function renderSeatMap(seatMap) {
    const seatMapDiv = document.getElementById('seatMap');
    seatMapDiv.innerHTML = '';

    seatMap.forEach(seat => {
        const seatDiv = document.createElement('div');
        seatDiv.classList.add('seat', seat.type);
        seatDiv.textContent = seat.id;
        seatDiv.title = seat.type === "regular" ? "Ghế thường" : seat.type === "vip" ? "Ghế VIP" : "Ghế đặc biệt";
        seatMapDiv.appendChild(seatDiv);
    });
}

// Tải dữ liệu ban đầu
document.addEventListener("DOMContentLoaded", renderRooms);
