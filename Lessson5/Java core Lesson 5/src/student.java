import java.util.Scanner;

public class student {
//   Tạo lớp mô tả sinh viên bao gồm họ tên, điểm và các phương thức
//        nhập, xuất và xếp loại học lực

   private String fullName;
   private int point;

   public String getFullName() {
      return fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   public void setPoint(int point) {
      this.point = point;
   }

   public int getPoint() {
      return point;
   }

   public void input(){
Scanner sc = new Scanner(System.in);
System.out.println("Enter the full name: ");
fullName = sc.nextLine();
System.out.println("Enter the point: ");
point = sc.nextInt();
   }
   public void output(){
System.out.println("Full Name: " + this.fullName);
System.out.println("Point: " + this.point);
   }
   public void xepLoai(){
      if (point >= 8) {
         System.out.println("Giỏi") ;
      } else if (point >= 6.5) {
         System.out.println("Khá") ;

      } else if (point >= 5) {
         System.out.println("Trung bình") ;
      } else {
         System.out.println("yếu") ;
      }
   }

}
