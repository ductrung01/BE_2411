 // <td><input type="checkbox"></td>
// <td><strong>${claim.code}</strong></td>
// <td>${claim.customerName}</td>
// <td>${claim.nameProduct}</td>
// <td>${claim.claimDate}</td>
// <td>${claim.coverageProduct}</td>
// <td>${claim.statusName}</td>

let claimData = [];
const PAGE_INIT = 0;
const SIZE_DEFAULT =3;
const BASE_URL = "http://localhost:8080"
async function searchClaim(){
    let claimCode = document.getElementById("search-ma-yeu-cau");
    let fromDate = document.getElementById("from-date");
    let toDate = document.getElementById("to-date");
    let status = document.getElementById("trang-thai-yeu-cau");
    // tachs nho rvafava truyen cac thong so vao
    let url =BASE_URL + "/api/claim";

    try {
        const response = await fetch(url);// goi api
        // kieemr tra phan hoi co thanh cong hay khong
        if(!response.ok){
            throw new Error('Network response was not ok');
        }
        const responseData = await response.json();
        claimData = responseData;
        renderClaim()
   }catch(error){
        console.error('Có lỗi xảy ra:', error);
    }
}
async  function renderClaim(){
    const tbody = document.getElementById("claimTableBody")
    tbody.innerHTML = "";
    for(datas of claimData.data){
        const row = document.createElement('tr'); // Tạo một hàng mới
        row.innerHTML = `
        <td><input type="checkbox"></td>
        <td><strong>${datas.code}</strong></td>
        <td>${datas.customerName}</td>
        <td>${datas.nameProduct}</td>
        <td>${datas.claimDate}</td>
        <td>${datas.coverageProduct}</td>
        <td>${datas.statusName}</td>
        `;
        tbody.appendChild(row); // Thêm hàng vào tbody

    }

}
async function searchClaim(page){
searchClaim(PAGE_INIT,SIZE_DEFAULT)

}

 window.onload = function() {
     searchClaim(PAGE_INIT,SIZE_DEFAULT)
 };