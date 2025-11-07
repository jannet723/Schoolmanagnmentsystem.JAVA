// Sample student data
let students = [
    {
        studentId: 1,
        firstName: "Michael",
        lastName: "Gaitho",
        classId: 101,
        gender: "Male",
        dateOfBirth: "2000-01-01",
        address: "nakuru",
        phone: "0712345678"
    },
    {
        studentId: 2,
        firstName: "Jane",
        lastName: "Chepkoech",
        classId: 102,
        gender: "Female",
        dateOfBirth: "2001-05-15",
        address: "nakuru",
        phone: "0712345678"
    },
    {
        studentId: 3,
        firstName: "Michael",
        lastName: "Kipchumba",
        classId: 101,
        gender: "Male",
        dateOfBirth: "1999-11-20",
        address: "nakuru",
        phone: "0712345678"
    },
    {
        studentId: 4,
        firstName: "Emily",
        lastName: "Mathenge",
        classId: 103,
        gender: "Female",
        dateOfBirth: "2000-08-30",
        address: "nakuru",
        phone: "0712345678"
    },
    {
        studentId: 5,
        firstName: "David",
        lastName: "Rotich",
        classId: 102,
        gender: "Male",
        dateOfBirth: "2001-03-12",
        address: "nakuru",
        phone: "0712345678"
    }
];

let editingStudentId = null;

// DOM Elements
const studentsGrid = document.getElementById('studentsGrid');
const modal = document.getElementById('studentModal');
const addStudentBtn = document.getElementById('addStudentBtn');
const closeBtn = document.querySelector('.close');
const cancelBtn = document.getElementById('cancelBtn');
const studentForm = document.getElementById('studentForm');
const searchInput = document.getElementById('searchInput');
const modalTitle = document.getElementById('modalTitle');

// Initialize
document.addEventListener('DOMContentLoaded', () => {
    renderStudents(students);
    updateStats();
});

// Render students
function renderStudents(studentsToRender) {
    if (studentsToRender.length === 0) {
        studentsGrid.innerHTML = `
            <div class="empty-state">
                <h2>📚 No Students Found</h2>
                <p>Add your first student to get started!</p>
            </div>
        `;
        return;
    }

    studentsGrid.innerHTML = studentsToRender.map(student => `
        <div class="student-card">
            <div class="student-header">
                <div class="student-avatar">
                    ${student.firstName.charAt(0)}${student.lastName.charAt(0)}
                </div>
                <div class="student-name">
                    <h3>${student.firstName} ${student.lastName}</h3>
                    <div class="student-id">ID: ${student.studentId}</div>
                </div>
            </div>
            <div class="student-details">
                <div class="detail-row">
                    <span class="detail-icon">🏫</span>
                    <span class="detail-label">Class:</span>
                    <span class="detail-value">${student.classId}</span>
                </div>
                <div class="detail-row">
                    <span class="detail-icon">${student.gender === 'Male' ? '👨' : student.gender === 'Female' ? '👩' : '👤'}</span>
                    <span class="detail-label">Gender:</span>
                    <span class="detail-value">${student.gender}</span>
                </div>
                <div class="detail-row">
                    <span class="detail-icon">🎂</span>
                    <span class="detail-label">DOB:</span>
                    <span class="detail-value">${formatDate(student.dateOfBirth)}</span>
                </div>
                <div class="detail-row">
                    <span class="detail-icon">📍</span>
                    <span class="detail-label">Address:</span>
                    <span class="detail-value">${student.address}</span>
                </div>
                <div class="detail-row">
                    <span class="detail-icon">📞</span>
                    <span class="detail-label">Phone:</span>
                    <span class="detail-value">${student.phone}</span>
                </div>
            </div>
            <div class="student-actions">
                <button class="btn btn-edit" onclick="editStudent(${student.studentId})">
                    ✏️ Edit
                </button>
                <button class="btn btn-danger" onclick="deleteStudent(${student.studentId})">
                    🗑️ Delete
                </button>
            </div>
        </div>
    `).join('');
}

// Update statistics
function updateStats() {
    const totalStudents = students.length;
    const maleCount = students.filter(s => s.gender === 'Male').length;
    const femaleCount = students.filter(s => s.gender === 'Female').length;
    const classCount = new Set(students.map(s => s.classId)).size;

    document.getElementById('totalStudents').textContent = totalStudents;
    document.getElementById('maleCount').textContent = maleCount;
    document.getElementById('femaleCount').textContent = femaleCount;
    document.getElementById('classCount').textContent = classCount;
}

// Format date
function formatDate(dateString) {
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', { year: 'numeric', month: 'short', day: 'numeric' });
}

// Open modal for adding student
addStudentBtn.addEventListener('click', () => {
    editingStudentId = null;
    modalTitle.textContent = 'Add New Student';
    studentForm.reset();
    modal.style.display = 'block';
});

// Close modal
closeBtn.addEventListener('click', () => {
    modal.style.display = 'none';
});

cancelBtn.addEventListener('click', () => {
    modal.style.display = 'none';
});

window.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.style.display = 'none';
    }
});

// Edit student
function editStudent(studentId) {
    const student = students.find(s => s.studentId === studentId);
    if (!student) return;

    editingStudentId = studentId;
    modalTitle.textContent = 'Edit Student';
    
    document.getElementById('studentId').value = student.studentId;
    document.getElementById('firstName').value = student.firstName;
    document.getElementById('lastName').value = student.lastName;
    document.getElementById('classId').value = student.classId;
    document.getElementById('gender').value = student.gender;
    document.getElementById('dateOfBirth').value = student.dateOfBirth;
    document.getElementById('address').value = student.address;
    document.getElementById('phone').value = student.phone;
    
    document.getElementById('studentId').disabled = true;
    modal.style.display = 'block';
}

// Delete student
function deleteStudent(studentId) {
    if (confirm('Are you sure you want to delete this student?')) {
        students = students.filter(s => s.studentId !== studentId);
        renderStudents(students);
        updateStats();
    }
}

// Submit form
studentForm.addEventListener('submit', (e) => {
    e.preventDefault();
    
    const studentData = {
        studentId: parseInt(document.getElementById('studentId').value),
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        classId: parseInt(document.getElementById('classId').value),
        gender: document.getElementById('gender').value,
        dateOfBirth: document.getElementById('dateOfBirth').value,
        address: document.getElementById('address').value,
        phone: document.getElementById('phone').value
    };

    if (editingStudentId !== null) {
        // Update existing student
        const index = students.findIndex(s => s.studentId === editingStudentId);
        if (index !== -1) {
            students[index] = studentData;
        }
    } else {
        // Add new student
        if (students.some(s => s.studentId === studentData.studentId)) {
            alert('Student ID already exists!');
            return;
        }
        students.push(studentData);
    }

    renderStudents(students);
    updateStats();
    modal.style.display = 'none';
    studentForm.reset();
    document.getElementById('studentId').disabled = false;
});

// Search functionality
searchInput.addEventListener('input', (e) => {
    const searchTerm = e.target.value.toLowerCase();
    const filteredStudents = students.filter(student => 
        student.firstName.toLowerCase().includes(searchTerm) ||
        student.lastName.toLowerCase().includes(searchTerm) ||
        student.studentId.toString().includes(searchTerm) ||
        student.classId.toString().includes(searchTerm)
    );
    renderStudents(filteredStudents);
});
