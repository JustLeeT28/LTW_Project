const promotions = [];

// Thêm khuyến mãi mới vào danh sách
function addPromotion() {
    const promoName = document.getElementById('promoName').value;
    const promoCode = document.getElementById('promoCode').value;
    const discountValue = document.getElementById('discountValue').value;
    const promoStartDate = document.getElementById('promoStartDate').value;
    const promoEndDate = document.getElementById('promoEndDate').value;
    const promoConditions = document.getElementById('promoConditions').value;

    const promotion = {
        name: promoName,
        code: promoCode,
        discount: `${discountValue}%`,
        period: `${promoStartDate} - ${promoEndDate}`,
        conditions: promoConditions,
        usageCount: 0
    };

    promotions.push(promotion);
    renderPromotions();
}

// Hiển thị danh sách khuyến mãi
function renderPromotions() {
    const promotionTable = document.getElementById('promotionTable').getElementsByTagName('tbody')[0];
    promotionTable.innerHTML = '';

    promotions.forEach((promotion, index) => {
        const row = promotionTable.insertRow();
        row.insertCell(0).textContent = promotion.name;
        row.insertCell(1).textContent = promotion.code;
        row.insertCell(2).textContent = promotion.discount;
        row.insertCell(3).textContent = promotion.period;
        row.insertCell(4).textContent = promotion.conditions;
        row.insertCell(5).textContent = promotion.usageCount;

        const actionCell = row.insertCell(6);
        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Xóa';
        deleteBtn.onclick = () => {
            promotions.splice(index, 1);
            renderPromotions();
        };
        actionCell.appendChild(deleteBtn);
    });
}

// Thêm dữ liệu mẫu
addPromotion({
    name: "Giảm giá mùa lễ",
    code: "HOLIDAY20",
    discount: "20%",
    period: "2024-12-01 - 2024-12-31",
    conditions: "Áp dụng cho tất cả các phim trong tháng 12",
    usageCount: 5
    });