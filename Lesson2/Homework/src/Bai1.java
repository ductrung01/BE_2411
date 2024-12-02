import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
//Viết chương trình Java tính điểm của sinh viên.
//Chương trình này sẽ đọc vào các loại điểm của sinh viên (điểm chuyên cần,
// điểm giữa kỳ, và điểm cuối kỳ) và xếp loại điểm theo quy luật sau:
//– if điểm trung bình >=9 =>loại=A
//– if điểm trung bình >= 7 và <9 => loại=B
//– if điểm trung bình>=5 and <7 =>loại=C
//– if điểm trung bình<5 =>loại=D
        Scanner sc = new Scanner(System.in);
        double diemChuyenCan, diemGiuaKi, diemCuoiKi;
        int heSo = 3;

        System.out.println("Nhập điểm chuyên cần của sinh viên:");
        diemChuyenCan = sc.nextDouble();
        System.out.println("Nhập điểm giữa kì của sinh viên:");
        diemGiuaKi = sc.nextDouble();
        System.out.println("Nhập điêm cuối kì của sinh viên:");
        diemCuoiKi = sc.nextDouble();
        double diemTrungBinh = (diemChuyenCan + diemGiuaKi + diemCuoiKi) / heSo;
        if (diemTrungBinh >= 9) {
            System.out.println("Sinh viên xếp loại A");
        } else if (diemTrungBinh >= 7 && diemTrungBinh < 9) {
            System.out.println("Sinh viên xếp loại B");
        } else if (diemTrungBinh >= 5 && diemTrungBinh < 7) {
            System.out.println("Sinh viên xếp loại C");
        } else if (diemTrungBinh < 5) {
            System.out.println("Sinh viên xếp loại D");
        }
    }
}
