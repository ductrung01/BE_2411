// async function fetchUsers() {
//     try {
//         const response = await fetch('http://localhost:8080/api/user');
//         const result = await response.json();
//         if (result.code === 200) {
//             populateTable(result.data);
//         } else {
//             console.error('Error fetching users:', result.message);
//         }
//     } catch (error) {
//         console.error('Fetch error:', error);
//     }
// }
//
// function populateTable(users) {
//     const bodyTableData = document.getElementById('bodyTableData');
//     bodyTableData.innerHTML = ''; // Clear existing data
//
//     users.forEach(user => {
//         const row = document.createElement('tr');
//         row.innerHTML = `
//                 <td><input type="checkbox"></td>
//                 <td>${user.code}</td>
//                 <td>${user.username}</td>
//                 <td>${user.fullName}</td>
//                 <td>${user.phone}</td>
//                 <td>${user.createdDate ? user.createdDate : 'Chưa có'}</td>
//                 <td>${user.address}</td>
//             `;
//         bodyTableData.appendChild(row);
//     });
// }
//
// document.addEventListener('DOMContentLoaded', fetchUsers);