const customers = [];
const discounts = [];

// Thêm khách hàng vào danh sách (dữ liệu mẫu)
function addCustomer(customer) {
    customers.push(customer);
    renderCustomers();
}

// Hiển thị danh sách khách hàng
function renderCustomers() {
    const customerTable = document.getElementById('customerTable').getElementsByTagName('tbody')[0];
    customerTable.innerHTML = '';

    customers.forEach((customer, index) => {
        const row = customerTable.insertRow();
        row.insertCell(0).textContent = customer.id;
        row.insertCell(1).textContent = customer.name;
        row.insertCell(2).textContent = customer.email;
        row.insertCell(3).textContent = customer.phone;
        row.insertCell(4).textContent = customer.points;

        const actionCell = row.insertCell(5);
        const viewBtn = document.createElement('button');
        viewBtn.textContent = 'Xem';
        actionCell.appendChild(viewBtn);
    });
}

// Tìm kiếm khách hàng
function searchCustomer() {
    const searchValue = document.getElementById('searchCustomerInput').value.toLowerCase();
    const filteredCustomers = customers.filter(customer =>
        customer.name.toLowerCase().includes(searchValue) ||
        customer.email.toLowerCase().includes(searchValue) ||
        customer.phone.includes(searchValue)
    );
    renderCustomers(filteredCustomers);
}

// Thêm ưu đãi
function addDiscount() {
    const discountName = document.getElementById('discountName').value;
    const discountPercent = document.getElementById('discountPercent').value;

    if (discountName && discountPercent) {
        discounts.push({ name: discountName, percent: discountPercent });
        renderDiscounts();
    }
}

// Hiển thị danh sách ưu đãi
function renderDiscounts() {
    const discountList = document.getElementById('discountList');
    discountList.innerHTML = '';

    discounts.forEach((discount, index) => {
        const listItem = document.createElement('li');
        listItem.textContent = `${discount.name} - ${discount.percent}%`;
        
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Xóa';
        deleteBtn.onclick = () => {
            discounts.splice(index, 1);
            renderDiscounts();
        };
        
        listItem.appendChild(deleteBtn);
        discountList.appendChild(listItem);
    });
}

// Thêm dữ liệu mẫu
addCustomer({ id: 1, name: "Nguyen Van A", email: "a@gmail.com", phone: "123456789", points: 100 });
addCustomer({ id: 2, name: "Tran Thi B", email: "b@gmail.com", phone: "987654321", points: 150 });
