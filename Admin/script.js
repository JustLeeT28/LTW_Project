document.addEventListener('DOMContentLoaded', () => {
    const links = document.querySelectorAll('.sidebar nav ul li a');
    const sections = document.querySelectorAll('.section');

    links.forEach(link => {
        link.addEventListener('click', (event) => {
            event.preventDefault();

            // Xóa lớp "active" khỏi tất cả các section
            sections.forEach(section => section.style.display = 'none');

            // Lấy section tương ứng
            const sectionId = link.getAttribute('data-section');
            const section = document.getElementById(sectionId);

            // Hiển thị section tương ứng
            section.style.display = 'block';
        });
    });
});
