import java.util.Scanner;

public  class Student {
    private int studentCode;
    private String fullName;
   private double testScore ;

    public Student(String fullName, double testScore, int studentCode) {
        this.fullName = fullName;
        this.testScore = testScore;
        this.studentCode = studentCode;
    }
    public Student() {
//        this.fullName = "Unknown";
//        this.testScore = 0;
//        this.studentCode = 0;
//
    }

    public void showInfo(){
        System.out.println("Student Code: " + this.studentCode);
        System.out.println("FullName: " + this.fullName);
        System.out.println("Test Score: " + this.testScore);
     
    }



    public void enterInfo(){
        System.out.println("Student Code: ");
        this.studentCode = new Scanner(System.in).nextInt();
        System.out.println("FullName: ");
        this.fullName = new Scanner(System.in).nextLine();
        System.out.println("Test Score: ");
        this.testScore = new Scanner(System.in).nextInt();


    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double gettestScore() {
        return testScore;
    }

    public void settestScore(int testScore) {
        this.testScore = testScore;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }
}
