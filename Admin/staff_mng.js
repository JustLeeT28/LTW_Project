const employees = [];
const activities = [];

// Thêm nhân viên mới vào danh sách
function addEmployee() {
    const employeeName = document.getElementById('employeeName').value;
    const employeeRole = document.getElementById('employeeRole').value;

    const employee = {
        name: employeeName,
        role: employeeRole
    };

    employees.push(employee);
    logActivity(`${employeeName} đã được thêm với vai trò ${employeeRole}`);
    renderEmployees();
}

// Hiển thị danh sách nhân viên
function renderEmployees() {
    const employeeTable = document.getElementById('employeeTable').getElementsByTagName('tbody')[0];
    employeeTable.innerHTML = '';

    employees.forEach((employee, index) => {
        const row = employeeTable.insertRow();
        row.insertCell(0).textContent = employee.name;
        row.insertCell(1).textContent = employee.role;

        const actionCell = row.insertCell(2);
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Xóa';
        deleteBtn.onclick = () => {
            employees.splice(index, 1);
            logActivity(`Nhân viên ${employee.name} đã bị xóa`);
            renderEmployees();
        };
        actionCell.appendChild(deleteBtn);
    });
}

// Lưu lại hoạt động của nhân viên
function logActivity(action) {
    const timestamp = new Date().toLocaleString();
    activities.push({ action, timestamp });
    renderActivityLog();
}

// Hiển thị lịch sử hoạt động
function renderActivityLog() {
    const activityLog = document.getElementById('activityLog');
    activityLog.innerHTML = '';

    activities.forEach(activity => {
        const listItem = document.createElement('li');
        listItem.textContent = `${activity.timestamp} - ${activity.action}`;
        activityLog.appendChild(listItem);
    });
}

// Thêm dữ liệu mẫu
addEmployee({
    name: "Nguyễn Văn A",
    role: "Admin"
});
addEmployee({
    name: "Trần Thị B",
    role: "Quản lý Vé"
});
logActivity("Nhân viên Nguyễn Văn A đã được thêm");
logActivity("Nhân viên Trần Thị B đã được thêm");
