function redirectToPage(event) {
    if (event.key === "Enter") {
        // window.location.href = "Search.jsp"; // Replace with your target page
        event.preventDefault(); // Ngăn hành động mặc định khi nhấn Enter
        document.getElementById('searchForm').submit(); // Submit form
    }
}