import java.util.Scanner;

public class StudentManager {
    private Student[] students;

    private int currentStudent = 0;

    private int totalStudent  ;

    private final int DEFAULT_NEW_SIZE = 10;
    public boolean isstudentCodeExist(int studentCode) {
        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getStudentCode() == studentCode) {
                return true;
            }

        }
        return false;
    }
    public StudentManager() {
        this.totalStudent = 10;  // Khởi tạo tổng số sinh viên ban đầu
        this.students = new Student[totalStudent];  // Khởi tạo mảng sinh viên với kích thước ban đầu
    }
    public void addStudent(){

        System.out.println("Nhập để thêm học sinh");
        Scanner sc = new Scanner(System.in);
        int type = 0;


        do {
           System.out.println("-----Menu Nhập Học Sinh-----");
           System.out.println("1. Nhập thông tin học sinh");
           System.out.println("2. Dừng nhập!");
           System.out.print("Chọn chức năng: ");
           type = sc.nextInt();
           switch (type) {
               case 1:
                   Student student = new Student();
                   System.out.println("Nhập thông tin học sinh");
                   student.enterInfo();
                   if (isstudentCodeExist(student.getStudentCode())) {
                       System.out.println("Mã sinh viên " + student.getStudentCode() + " đã tồn tại. Không thể thêm sinh viên!!!.");
                   } else {

                       reSizeArrayStudent();
                       this.students[currentStudent] = student;
                       currentStudent++;
                       System.out.println("Đã thêm học sinh thứ :" + currentStudent + " thành công");
                   }
                   break;
               case 2:
                   System.out.println(" Dừng nhập học sinh !");
                   break;
               default:
                   System.out.println("Nhập sai định dạng, đề nghị nhập lại");
           }





        }while (type  !=2);


    }
    public void reSizeArrayStudent(){

        if (currentStudent == totalStudent){

            this.totalStudent = this.totalStudent + DEFAULT_NEW_SIZE;

            this.students = copyArray(totalStudent,this.students);
        }
    }
    public Student[] copyArray(int newSize, Student[] oldArray) {

        Student[] newArray = new Student[newSize];


        if (oldArray != null) {
            for (int i = 0; i < oldArray.length && i < newSize; i++) {
                newArray[i] = oldArray[i];
            }
        }

        return newArray;
    }
    public void deleteStudentByStudentCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào mã sinh viên mà bạn muốn xóa:");
        int studentCode = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < currentStudent; i++) {
            if (students[i].getStudentCode() == studentCode) {
                found = true;

                for (int j = i; j < currentStudent - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[currentStudent - 1] = null;
                this.currentStudent--;
                System.out.println("Đã xóa sinh viên với mã " + studentCode + " thành công!");
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên với mã " + studentCode);
        }
    }

    public void updateStudentByStudentCode(){
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Nhập vao mã sinh viên mà bạn muốn sửa:" );
        int studentCode = sc.nextInt();
        boolean found = false;
       for(int i = 0; i <currentStudent; i++){
           if (studentCode == students[i].getStudentCode()){
               System.out.println("Sinh viên với mã: "+studentCode+"đã được tìm thấy!");
               students[i].enterInfo();
               found = true;
                break;
           }

       }
       if (!found){
           System.out.println("Không tìm thấy sinh viên với mã " + studentCode);
       }
    }

    public void searchStudentByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên sinh viên bạn muốn tìm: ");
        String name = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < currentStudent; i++) {
            if (name.equalsIgnoreCase(students[i].getFullName())) {
                System.out.println("Đã tìm thấy tại index: " + i);
                students[i].showInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên với tên " + name);
        }
    }

    public void showAllStudent(){
        for (int i = 0; i < currentStudent; i++) {
            if (students[i] == null){
                continue;
            }
            System.out.println("------------- Student: " + i);
            students[i].showInfo();
        }
    }
}
