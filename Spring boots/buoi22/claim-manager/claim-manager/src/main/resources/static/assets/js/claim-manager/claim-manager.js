let claimsData = []; // Biến toàn cục để lưu trữ dữ liệu yêu cầu

async function fetchData() {
    try {
        const response = await fetch('http://localhost:8080/api/claim');
        if (!response.ok) {
            throw new Error('Mã trạng thái không hợp lệ');
        }
        const responseData = await response.json();
        claimsData = responseData.data; // Lưu trữ dữ liệu vào biến toàn cục
        renderTable(claimsData); // Gọi hàm để hiển thị bảng
    } catch (error) {
        console.log("Lỗi: " + error);
    }
}

function renderTable(data) {
    const tbody = document.getElementById("claimTableBody");
    tbody.innerHTML = ''; // Xóa nội dung cũ trước khi thêm mới

    for (const claim of data) {
        const row = document.createElement('tr');
        row.innerHTML = `
                <td><input type="checkbox"></td>
                <td><strong>${claim.code}</strong></td>
                <td>${claim.customerName}</td>
                <td>${claim.nameProduct}</td>
                <td>${claim.claimDate}</td>
                <td>${claim.coverageProduct}</td>
                <td>${claim.statusName}</td>
            `;
        tbody.appendChild(row); // Thêm hàng vào bảng
    }
}

async function searchClaim() {
    try {
        const response = await fetch('http://localhost:8080/api/claim');
        if (!response.ok) {
            throw new Error('Mã trạng thái không hợp lệ');
        }
        const responseData = await response.json();
        const searchMaYeuCau = document.getElementById('search-ma-yeu-cau').value.toLowerCase();
        const fromDate = document.getElementById('from-date').value;
        const toDate = document.getElementById('to-date').value;
        const trangThaiYeuCau = document.getElementById('trang-thai-yeu-cau').value;

        // Lọc dữ liệu dựa trên điều kiện người dùng nhập
        const filteredClaims = responseData.data.filter(claim => {
            const maYeuCauMatch = claim.code.toLowerCase().includes(searchMaYeuCau);
            const ngayGuiYeuCau = new Date(claim.claimDate);
            const fromDateMatch = !fromDate || ngayGuiYeuCau >= new Date(fromDate);
            const toDateMatch = !toDate || ngayGuiYeuCau <= new Date(toDate);
            const trangThaiMatch = !trangThaiYeuCau || claim.statusName === trangThaiYeuCau;

            return maYeuCauMatch && fromDateMatch && toDateMatch && trangThaiMatch;
        });

        renderTable(filteredClaims); // Hiển thị bảng với dữ liệu đã lọc
    } catch (error) {
        alert("Lỗi: " + error);
    }
}

document.addEventListener('DOMContentLoaded', function () {
    fetchData(); // Gọi hàm fetchData khi DOM đã được tải
});