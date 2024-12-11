// Mô phỏng dữ liệu báo cáo doanh thu
const revenueData = {
    daily: [100, 200, 150, 300, 250, 400],
    weekly: [1200, 1400, 1100, 1600],
    monthly: [5000, 6000, 5500],
    yearly: [70000, 80000, 75000]
};

// Dữ liệu thống kê khách hàng
const customerStats = {
    newCustomers: 150,
    loyalCustomers: 45,
    bookingTrend: "Xu hướng đặt vé vào cuối tuần"
};

// Dữ liệu báo cáo hiệu quả phim và tỷ lệ ghế
const moviePerformance = [
    { title: "Phim A", ticketsSold: 100 },
    { title: "Phim B", ticketsSold: 150 },
    { title: "Phim C", ticketsSold: 80 }
];
const seatOccupancyRate = 78; // Tỷ lệ ghế đã đặt

// Tạo biểu đồ doanh thu
function generateRevenueReport() {
    const period = document.getElementById("revenuePeriod").value;
    const data = revenueData[period];
    const revenueChart = document.getElementById("revenueChart");
    revenueChart.innerHTML = `Doanh thu (${period}): ${data.join(", ")} VND`;
}

// Hiển thị dữ liệu khách hàng
function loadCustomerStatistics() {
    document.getElementById("newCustomers").textContent = customerStats.newCustomers;
    document.getElementById("loyalCustomers").textContent = customerStats.loyalCustomers;
    document.getElementById("bookingTrend").textContent = customerStats.bookingTrend;
}

// Tạo báo cáo tổng hợp
function loadSummaryReport() {
    const moviePerformanceChart = document.getElementById("moviePerformance");
    moviePerformanceChart.innerHTML = "Hiệu quả phim:<br>" +
        moviePerformance.map(movie => `${movie.title}: ${movie.ticketsSold} vé bán`).join("<br>");
    document.getElementById("seatOccupancyRate").textContent = `${seatOccupancyRate}%`;
}

// Tải báo cáo
window.onload = function() {
    generateRevenueReport();
    loadCustomerStatistics();
    loadSummaryReport();
};
