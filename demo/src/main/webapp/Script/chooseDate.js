document.addEventListener("DOMContentLoaded", function () {
    const clickableItems = document.querySelectorAll('.clickable');
    const form = document.getElementById('bookingForm');
    const hiddenDay = document.getElementById('selectedDay');
    const hiddenMonth = document.getElementById('selectedMonth');

    // Lấy query parameters từ URL
    const urlParams = new URLSearchParams(window.location.search);
    const selectedDay = urlParams.get('day');
    const selectedMonth = urlParams.get('month');

    // Đặt trạng thái ban đầu dựa trên URL
    clickableItems.forEach(item => {
        const itemDay = item.dataset.day;
        const itemMonth = item.dataset.month;

        if (itemDay === selectedDay && itemMonth === selectedMonth) {
            item.style.backgroundColor = '#fd6565';
            item.style.color = 'white';
        }
    });

    // Sự kiện click: đổi màu và cập nhật input ẩn
    clickableItems.forEach(item => {
        item.addEventListener('click', function () {
            // Loại bỏ trạng thái màu nền cũ
            clickableItems.forEach(i => {
                i.style.backgroundColor = '';
                i.style.color = '';
            });

            // Đặt màu nền và chữ cho mục được chọn
            this.style.backgroundColor = '#fd6565';
            this.style.color = 'white';

            // Cập nhật input ẩn
            hiddenDay.value = this.dataset.day;
            hiddenMonth.value = this.dataset.month;

            // Gửi form
            form.submit();
        });
    });
    const clickableTimes = document.querySelectorAll('.clickableTime');
    const Timeform = document.getElementById('bookingFormTime');
    const hiddenHour = document.getElementById('selectedHour');
    const hiddenMinute = document.getElementById('selectedMinute');
    const selectedHour = urlParams.get('hour');
    const selectedMinute = urlParams.get('minute');

    // Đặt trạng thái ban đầu dựa trên URL
    clickableTimes.forEach(item => {
        const itemHour = item.dataset.hour;
        const itemMinute = item.dataset.minute;

        if (itemHour === selectedHour && itemMinute === selectedMinute) {
            item.style.backgroundColor = '#fd6565';
            item.style.color = 'white';
        }
    });

    // Sự kiện click: đổi màu và cập nhật input ẩn
    clickableTimes.forEach(item => {
        item.addEventListener('click', function () {
            // Loại bỏ trạng thái màu nền cũ
            clickableTimes.forEach(i => {
                i.style.backgroundColor = '';
                i.style.color = '';
            });

            // Đặt màu nền và chữ cho mục được chọn
            this.style.backgroundColor = '#fd6565';
            this.style.color = 'white';

            // Cập nhật input ẩn
            hiddenHour.value = this.dataset.hour;
            hiddenMinute.value = this.dataset.minute;

            // Gửi form
            Timeform.submit();
        });
    });
});
