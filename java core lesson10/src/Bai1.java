public class Bai1 {
    //Bai1:Cho số n = 10; mục tiêu tính tổng các số từ 1-10tạo ra
//2 thread với yêu cầu thread1: tính tổng các số từ 1-5thread2:
//tính tổng các số từ 6-10sử dụng hàm join(), để thread chính chờ 2 thread hoàn thành
//và tiếp tục chạy ex: thread1.join()
// thread chính sẽ chờ thread1 thực thi xong hàm run()của thread1.
// Thì thread chính mới chạy tiếp
    public static void main(String[] args) {
    sum thread1 = new sum(1,5);
    sum thread2 = new sum(6,10);
    thread1.start();
    thread2.start();
    try{
        thread1.join();
        thread2.join();
    }catch(Exception e){
        System.out.println(e);
    }
    int totalSum = thread1.getSum() + thread2.getSum();
        System.out.println("Tổng các số từ 1 đến 10 là"+totalSum);
    }
}
