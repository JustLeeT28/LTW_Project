const movies = [];
const schedules = [];

// Thêm phim mới
function addMovie() {
    const title = document.getElementById('title').value;
    const poster = document.getElementById('poster').value;
    const trailer = document.getElementById('trailer').value;
    const description = document.getElementById('description').value;
    const duration = document.getElementById('duration').value;
    const genre = document.getElementById('genre').value;
    const director = document.getElementById('director').value;
    const actors = document.getElementById('actors').value;
    const ageLimit = document.getElementById('ageLimit').value;
    const releaseDate = document.getElementById('releaseDate').value;

    const movie = { title, poster, trailer, description, duration, genre, director, actors, ageLimit, releaseDate };
    movies.push(movie);
    renderMovies();
}

// Hiển thị danh sách phim
function renderMovies() {
    const movieTable = document.getElementById('movieTable').getElementsByTagName('tbody')[0];
    movieTable.innerHTML = '';
    
    movies.forEach((movie, index) => {
        const row = movieTable.insertRow();
        row.insertCell(0).textContent = movie.title;
        row.insertCell(1).textContent = movie.genre;
        row.insertCell(2).textContent = `${movie.duration} phút`;
        row.insertCell(3).textContent = movie.releaseDate;
        const actionCell = row.insertCell(4);

        // Nút xóa
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Xóa';
        deleteBtn.classList.add('delete-btn');
        deleteBtn.onclick = () => deleteMovie(index);
        actionCell.appendChild(deleteBtn);
    });
}

// Xóa phim
function deleteMovie(index) {
    movies.splice(index, 1);
    renderMovies();
}

// Thêm lịch chiếu
function addSchedule() {
    const movieIndex = document.getElementById('scheduleMovie').selectedIndex;
    const movieTitle = movies[movieIndex].title;
    const showDate = document.getElementById('showDate').value;
    const showTime = document.getElementById('showTime').value;

    const schedule = { movieTitle, showDate, showTime };
    schedules.push(schedule);
    renderSchedules();
}

// Hiển thị lịch chiếu
function renderSchedules() {
    const scheduleList = document.getElementById('scheduleList');
    scheduleList.innerHTML = '';

    schedules.forEach((schedule, index) => {
        const scheduleItem = document.createElement('p');
        scheduleItem.textContent = `${schedule.movieTitle} - Ngày: ${schedule.showDate} Giờ: ${schedule.showTime}`;
        scheduleList.appendChild(scheduleItem);
    });
}
