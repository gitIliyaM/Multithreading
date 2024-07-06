package Z_1;

public class NewThread extends Thread {
    String symbol = "1.";
    @Override
    public void run() {
        super.run();
        for(int i=0; i<100; i++){
            System.out.println(symbol+i);
        }
    }
}
