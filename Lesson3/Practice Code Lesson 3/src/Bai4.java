public class Bai4 {
    public static void main(String[] args) {
//        bài 4)
//        Cần có tổng 200.000đ từ 3 loại giấy bạc 1000đ, 2000đ, và 5000đ.
//                Lập chương tình để tìm tất cả các phương án có thể
        int soLuongGiayBac1, soLuongGiayBac2, soLuongGiayBac5;
        int target = 200000;
        int soTienGiayBac1 = 1000;
        int soTienGiayBac2 = 2000;
        int soTienGiayBac5 = 5000;
        for (soLuongGiayBac1 = 0; soLuongGiayBac1 <= (target / 1000); soLuongGiayBac1++) {
            for (soLuongGiayBac2 = 0; soLuongGiayBac2 <= (target / 2000); soLuongGiayBac2++) {
                int remain = target - (soLuongGiayBac1 * 1000 + soLuongGiayBac2 * 2000);
                if (remain%5000 == 0 && remain > 0) {
                    soLuongGiayBac5 = remain / 5000;
                    System.out.println("Giấy bạc 1000đ: " + soLuongGiayBac1 + "," +"Giấy bạc 2000đ: "+
                            soLuongGiayBac2 + ","+ "Số lượng giấy bạc 5 là: "+soLuongGiayBac5);

                }

            }
        }

    }
}
