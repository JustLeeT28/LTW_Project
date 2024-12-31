const tickets = [];

// Thêm vé vào danh sách (dữ liệu mẫu)
function addTicket(ticket) {
    tickets.push(ticket);
    renderTickets();
}

// Hiển thị danh sách vé
function renderTickets() {
    const ticketTable = document.getElementById('ticketTable').getElementsByTagName('tbody')[0];
    ticketTable.innerHTML = '';

    tickets.forEach((ticket, index) => {
        const row = ticketTable.insertRow();
        row.insertCell(0).textContent = ticket.id;
        row.insertCell(1).textContent = ticket.customerName;
        row.insertCell(2).textContent = ticket.showtime;
        row.insertCell(3).textContent = ticket.seatNumber;
        row.insertCell(4).textContent = ticket.status;

        const actionCell = row.insertCell(5);

        // Nút hủy vé
        const cancelBtn = document.createElement('button');
        cancelBtn.textContent = 'Hủy';
        cancelBtn.onclick = () => cancelTicket(index);
        actionCell.appendChild(cancelBtn);
    });
}

// Hủy vé
function cancelTicket(index) {
    tickets[index].status = 'Đã hủy';
    renderTickets();
}

// Tìm kiếm vé
function searchTicket() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const filteredTickets = tickets.filter(ticket =>
        ticket.customerName.toLowerCase().includes(searchInput) ||
        ticket.id.toString().includes(searchInput) ||
        ticket.showtime.toLowerCase().includes(searchInput)
    );

    renderFilteredTickets(filteredTickets);
}

// Hiển thị vé đã lọc
function renderFilteredTickets(filteredTickets) {
    const ticketTable = document.getElementById('ticketTable').getElementsByTagName('tbody')[0];
    ticketTable.innerHTML = '';

    filteredTickets.forEach((ticket, index) => {
        const row = ticketTable.insertRow();
        row.insertCell(0).textContent = ticket.id;
        row.insertCell(1).textContent = ticket.customerName;
        row.insertCell(2).textContent = ticket.showtime;
        row.insertCell(3).textContent = ticket.seatNumber;
        row.insertCell(4).textContent = ticket.status;

        const actionCell = row.insertCell(5);
        const cancelBtn = document.createElement('button');
        cancelBtn.textContent = 'Hủy';
        cancelBtn.onclick = () => cancelTicket(index);
        actionCell.appendChild(cancelBtn);
    });
}

// Cập nhật giá vé
function updatePrices() {
    const regularPrice = document.getElementById('regularPrice').value;
    const vipPrice = document.getElementById('vipPrice').value;
    const specialPrice = document.getElementById('specialPrice').value;
    
    console.log('Giá vé được cập nhật:', { regularPrice, vipPrice, specialPrice });
}

function updatePrices() {
    const regularPrice = document.getElementById('regularPrice').value;
    const vipPrice = document.getElementById('vipPrice').value;
    const specialPrice = document.getElementById('specialPrice').value;

    fetch('/updateTicketPrices', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ regularPrice, vipPrice, specialPrice })
    })
        .then(response => {
            if (response.ok) alert('Cập nhật giá vé thành công');
            else throw new Error('Cập nhật thất bại');
        })
        .catch(error => console.error(error));
}


// Thêm dữ liệu mẫu
addTicket({ id: 1, customerName: "Nguyen Van A", showtime: "2023-11-08 19:00", seatNumber: "A1", status: "Đã thanh toán" });
addTicket({ id: 2, customerName: "Tran Thi B", showtime: "2023-11-08 21:00", seatNumber: "B2", status: "Chưa thanh toán" });
addTicket({ id: 3, customerName: "Le Van C", showtime: "2023-11-09 18:00", seatNumber: "C3", status: "Đã sử dụng" });
