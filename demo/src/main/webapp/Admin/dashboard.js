document.addEventListener('DOMContentLoaded', () => {
    // Biểu đồ doanh thu
    const ctx = document.getElementById('revenueChart').getContext('2d');
    const revenueChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ['Ngày 1', 'Ngày 2', 'Ngày 3', 'Ngày 4', 'Ngày 5', 'Ngày 6', 'Ngày 7'],
            datasets: [
                {
                    label: 'Doanh thu (triệu VND)',
                    data: [50, 75, 60, 90, 100, 120, 80],
                    borderColor: '#1abc9c',
                    backgroundColor: 'rgba(26, 188, 156, 0.2)',
                    fill: true,
                },
            ],
        },
        options: {
            responsive: true,
            scales: {
                x: {
                    title: {
                        display: true,
                        text: 'Ngày',
                    },
                },
                y: {
                    title: {
                        display: true,
                        text: 'Doanh thu (triệu VND)',
                    },
                    beginAtZero: true,
                },
            },
        },
    });
});
