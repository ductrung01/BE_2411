const PAGE_INIT = 0;
const SIZE_DEFAULT = 3;
const BASE_URL = 'http://localhost:8080/';
var totalPage = 0;

function redirectPageCreateUser() {
    window.location.href = "http://localhost:8080/cms/create-user";
}

function search(page, size) {
    let code = document.getElementById("search-ma-yeu-cau").value;
    let fromDate = document.getElementById("from-date").value;
    let toDate = document.getElementById("to-date").value;
    let phone = document.getElementById("phone").value;

    let url = BASE_URL + `api/users?page=${page}&size=${size}&code=${code}&fromDate=${fromDate}&toDate=${toDate}&phone=${phone}`;
    console.log("Calling API:", url); // Log URL gọi API

    fetch(url)
    .then(response => {
        console.log("Response Status:", response.status); // Log mã trạng thái phản hồi
        if (!response.ok) {
            console.error('API call error:', response.statusText);
            throw new Error('Call API error');
        }
        return response.json();
    })
    .then(dataResponse => {
        console.log("Data Response:", dataResponse); // Log dữ liệu nhận được
        if (!dataResponse.data) {
            console.error("No data found in response");
            return; // Dừng nếu không có dữ liệu
        }
        renderTable(dataResponse.data);
        renderPaging(dataResponse);
    })
    .catch(error => {
        console.error("Fetch error:", error);
    });
}

function renderTable(data) {
    let bodyTable = document.getElementById('bodyTableData');
    bodyTable.innerHTML = ''; // Xóa dữ liệu cũ

    for (let i = 0; i < data.length; i++) {
        let dto = data[i];
        let urlDetail = BASE_URL + 'cms/detail-user/' + dto.id;
        let rowTable = `<tr>
                            <td><input type="checkbox" class="recordCheckbox"></td>
                            <td><a href="${urlDetail}"><strong>${getValueDto(dto.code)}</strong></a></td>
                            <td>${getValueDto(dto.username)}</td>
                            <td>${getValueDto(dto.firstName) + ' ' + getValueDto(dto.lastName)}</td>
                            <td>${getValueDto(dto.phone)}</td>
                            <td>${getValueDto(dto.createdDate)}</td>
                            <td>${getValueDto(dto.address)}</td>
                        </tr>`;
        bodyTable.innerHTML += rowTable;
    }
}

function getValueDto(data) {
    return data == undefined || data == null ? '' : data;
}

function renderPaging(response) {
    totalPage = response.totalPage;
    let pageIndex = response.pageIndex;

    let pageBody = document.getElementById("paginationId");
    pageBody.innerHTML = ''; // Reset pagination

    if (pageIndex > 0) {
        pageBody.innerHTML += `<li class="page-item">
                                   <a class="page-link" onclick="changePage(${pageIndex - 1})" aria-label="Previous">
                                       <span aria-hidden="true">&laquo;</span>
                                   </a>
                               </li>`;
    }

    for (let i = 0; i < totalPage; i++) {
        let classPage = 'page-item' + (i === pageIndex ? ' active' : '');
        pageBody.innerHTML += `<li class="${classPage}"><a class="page-link" onclick="changePage(${i})">${i + 1}</a></li>`;
    }

    if (pageIndex < totalPage - 1) {
        pageBody.innerHTML += `<li class="page-item">
                                   <a class="page-link" onclick="changePage(${pageIndex + 1})" aria-label="Next">
                                       <span aria-hidden="true">&raquo;</span>
                                   </a>
                               </li>`;
    }
}

function changePage(pageIndex) {
    if (pageIndex < 0) {
        pageIndex = 0;
    } else if (pageIndex >= totalPage) {
        pageIndex = totalPage - 1;
    }
    search(pageIndex, SIZE_DEFAULT);
}

function actionSearch() {
    search(PAGE_INIT, SIZE_DEFAULT);
}

// Khi toàn bộ dữ liệu tại window đã load xong
window.onload = function () {
    search(PAGE_INIT, SIZE_DEFAULT);
}
