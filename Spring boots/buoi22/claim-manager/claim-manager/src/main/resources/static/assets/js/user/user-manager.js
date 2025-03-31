let currentPage = 0;
const pageSize = 20;

async function fetchUsers(pageIndex = 0) {
    const code = document.getElementById('search-ma-yeu-cau').value;
    const fromDate = document.getElementById('from-date').value;
    const toDate = document.getElementById('to-date').value;
    const phone = document.getElementById('phone').value;

    const queryParams = new URLSearchParams({
        code: code,
        fromDate: fromDate,
        toDate: toDate,
        phone: phone,
        pageIndex: pageIndex,
        pageSize: pageSize
    });

    try {
        const response = await fetch(`http://localhost:8080/api/user?${queryParams.toString()}`);
        const result = await response.json();
        if (result.code === 200) {
            populateTable(result.data);
            setupPagination(result.totalPages);
        } else {
            console.error('Error fetching users:', result.message);
        }
    } catch (error) {
        console.error('Fetch error:', error);
    }
}

function populateTable(users) {
    const bodyTableData = document.getElementById('bodyTableData');
    bodyTableData.innerHTML = '';

    users.forEach(user => {
        const row = document.createElement('tr');
        row.innerHTML = `
                <td><input type="checkbox"></td>
                <td>${user.code}</td>
                <td>${user.username}</td>
                <td>${user.fullName}</td>
                <td>${user.phone}</td>
                <td>${user.createdDate ? user.createdDate : 'Chưa có'}</td>
                <td>${user.address}</td>
            `;
        bodyTableData.appendChild(row);
    });
}

function setupPagination(totalPages) {
    const pagination = document.getElementById('pagination');
    pagination.innerHTML = '';

    for (let i = 0; i < totalPages; i++) {
        const button = document.createElement('button');
        button.innerText = i + 1;
        button.className = 'btn btn-secondary mx-1';
        button.onclick = () => {
            currentPage = i;
            fetchUsers(currentPage);
        };
        pagination.appendChild(button);
    }
}

document.addEventListener('DOMContentLoaded', () => {
    fetchUsers();
    document.getElementById('search-button').addEventListener('click', () => {
        currentPage = 0;
        fetchUsers(currentPage);
    });
});