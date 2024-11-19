document.addEventListener("DOMContentLoaded", function() {
    const totalAmount = localStorage.getItem("total_amout");
    const formattedAmount = parseInt(totalAmount).toLocaleString();
    document.getElementsByClassName('cost')[0].textContent = formattedAmount + " VNĐ" ;
    document.getElementsByClassName('cost')[1].textContent = formattedAmount + ' VNĐ';

})