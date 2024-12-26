public class sum extends Thread{
    private int start;
    private int end;
    private int sum;
    public sum(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public void run(){
        sum = 0;
        for(int i = start; i <= end; i++){
            sum += i;
        }
        System.out.println("Tổng từ "+start+ "đến"+end+"là:"+sum);
    }
    public int getSum() {
        return sum;
    }
}
