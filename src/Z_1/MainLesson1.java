package Z_1;

public class MainLesson1 {
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            Thread threadMy = new NewThread();
            Thread myThread = new Thread(new NewThread1(), "myThread"+i);
            threadMy.start();
            myThread.start();
        }
    }
}
