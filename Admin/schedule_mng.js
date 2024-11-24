const schedules = [];

// Lên lịch chiếu mới
function addSchedule() {
    const movie = document.getElementById('movieSelect').value;
    const room = document.getElementById('roomSelect').value;
    const showDate = document.getElementById('showDate').value;
    const showTime = document.getElementById('showTime').value;

    const newSchedule = {
        movie,
        room,
        showDate,
        showTime,
        seatsAvailable: 100  // Ví dụ: số lượng chỗ ngồi mặc định là 100
    };

    schedules.push(newSchedule);
    renderSchedules();
}

// Hiển thị danh sách lịch chiếu
function renderSchedules() {
    const scheduleTable = document.getElementById('scheduleTable').getElementsByTagName('tbody')[0];
    scheduleTable.innerHTML = '';

    schedules.forEach((schedule, index) => {
        const row = scheduleTable.insertRow();
        row.insertCell(0).textContent = schedule.movie;
        row.insertCell(1).textContent = schedule.room;
        row.insertCell(2).textContent = schedule.showDate;
        row.insertCell(3).textContent = schedule.showTime;
        row.insertCell(4).textContent = schedule.seatsAvailable + " chỗ";

        const actionCell = row.insertCell(5);

        // Nút xóa
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Xóa';
        deleteBtn.onclick = () => deleteSchedule(index);
        actionCell.appendChild(deleteBtn);
    });
}

// Xóa lịch chiếu
function deleteSchedule(index) {
    schedules.splice(index, 1);
    renderSchedules();
}

// Khởi tạo danh sách phim mẫu
function loadMovies() {
    const movies = ["Phim A", "Phim B", "Phim C"];
    const movieSelect = document.getElementById('movieSelect');

    movies.forEach(movie => {
        const option = document.createElement('option');
        option.value = movie;
        option.textContent = movie;
        movieSelect.appendChild(option);
    });
}

// Tải dữ liệu ban đầu
document.addEventListener("DOMContentLoaded", loadMovies);
