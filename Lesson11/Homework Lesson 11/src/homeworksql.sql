CREATE DATABASE StudentManagementAndCoursesManagement;
USE StudentManagementAndCoursesManagement;
create table Students(
                         id integer primary key auto_increment,
                         first_name varchar(50),
                         last_name varchar(50),
                         birth_date date,
                         email varchar(100)
);
INSERT INTO Students values
                         (1,'Vũ','Trung','2003-01-11','ductrungdz0111@gmail.com'),
                         (2,'Nguyễn','A','2002-12-12','A01@gmail.com'),
                         (3,'Nguyễn','B','2007-1-12','B01@gmail.com'),
                         (4,'Nguyễn','C','2009-12-1','C01@gmail.com'),
                         (5,'Nguyễn','D','2010-2-2','D01@gmail.com');
create table Courses(
                        id integer primary key auto_increment,
                        course_name varchar(100),
                        course_description longtext
);
INSERT INTO Courses values
                        (1,'Lập trình java','Khóa học rất hay và hữu ích'),
                        (2,'Lập trình C++','Khóa học rất hay '),
                        (3,'Lập trình PHP laravel','Khóa rất hay và có ích');


create table Enrollments(
                            id integer primary key auto_increment,
                            student_id integer,
                            course_id integer,
                            enrollment_date date
);
alter table Enrollments add foreign key (student_id) references Students(id);
alter  table Enrollments add foreign key (course_id) references Courses(id);
INSERT INTO Enrollments values
                            (1,1,1,'2024-2-8'),
                            (2,2,1,'2024-3-9'),
                            (3,3,2,'2024-10-10'),
                            (4,4,2,'2024-11-11'),
                            (5,5,3,'2024-12-12');
SELECT * FROM Enrollments;
# Truy vấn lấy tất cả thông tin sinh viên
SELECT last_name,first_name,email FROM Students;
# Truy vấn lấy tất cả khóa học(tên khóa học, mô tả
SELECT course_name,course_description FROM Courses;
# •	Truy vấn danh sách sinh viên cùng khóa học họ đăng ký
# (bao gồm tên sinh viên và tên khóa học).

# 4. Cập nhật dữ liệu:
# •	Cập nhật email của sinh viên có student_id = 1
# thành một địa chỉ email mới.
UPDATE Students set
                    email = 'trungdz0111@gmail.com'
where id = 1;
# •	Cập nhật mô tả của khóa học
# "Lập Trình Cơ Bản" thành mô tả mới.
UPDATE Courses set
                   course_description = 'Khóa học lập trình cơ bản'
where course_name LIKE '%Lập trình PHP laravel%';

# 5. Xóa dữ liệu:
# •	Xóa một sinh viên cụ thể khỏi bảng Students
# (chỉ xóa nếu sinh viên không có bất kỳ khóa học
# nào đã đăng ký).
DELETE  FROM Students WHERE id = 5 NOT IN (SELECT student_id from Enrollments );
SELECT * FROM Students;
