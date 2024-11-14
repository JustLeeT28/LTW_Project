document.addEventListener('DOMContentLoaded', function () {
    const seats = document.querySelectorAll('.seat:not(.booked)');
    seats.forEach(seat => {
        seat.addEventListener('click', () => {
            seat.classList.toggle('selected');
        });
    });
});
