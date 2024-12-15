import java.util.Scanner;

public  class Student {
    private String fullName;
    private int age;
    private int studentCode;
    public Student(String fullName, int age, int studentCode) {
        this.fullName = fullName;
        this.age = age;
        this.studentCode = studentCode;
    }
    public Student() {
//        this.fullName = "Unknown";
//        this.age = 0;
//        this.studentCode = 0;
//
    }

    public void showInfo(){
        System.out.println("FullName: " + this.fullName);
        System.out.println("Age: " + this.age);
        System.out.println("Student Code: " + this.studentCode);
    }



    public void enterInfo(){
        System.out.println("FullName: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.println("Age: ");
        this.age = new Scanner(System.in).nextInt();
        System.out.println("Student Code: ");
        this.studentCode = new Scanner(System.in).nextInt();

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }
}
