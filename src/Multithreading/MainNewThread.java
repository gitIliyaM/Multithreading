package Modul_2.Multithreading;

public class MainNewThread {
    public static void main(String[] args) {
        Data data = new Data();
        Thread thread = new NewThread(data);
        thread.start();

        thread = new Thread(() -> new RunnableImpl().run());
        thread.start();

        Thread threadInterface = new Thread(new RunnableImpl());
        Thread interFace = new InterFace(threadInterface);
        interFace.start();

        Runnable runnable = new RunnableImpl();
        runnable.run();
        Thread threadRun = new Thread(runnable);
        threadRun.start();
    }
}
class InterFace extends Thread {
    Runnable runnable;

    public InterFace(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        super.run();
        runnable.run();
    }
}
class NewThread extends Thread {
    int counterThread = 10;
    Data data;
    public NewThread(Data data) {
        this.data = data;
    }

    @Override
    public void run(){
        super.run();
        for (int i = 1; i < 101; i++) {
            if(counterThread == i){
                System.out.println(data.counter++);
                counterThread = counterThread + 10;
            } else if(i < 10){
                System.out.print(" "+data.counter++ +", " );
            } else {
                System.out.print(data.counter++ +", " );
            }
        }
    }
}
class Data {
    int counter = 1;
}
class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 10 == 0){
                System.out.println("---------");
                System.out.println(i + " это число делится на 10 без остатка");
                System.out.println("---------");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println(i + " это число не делится на 10 без остатка");
            }
        }
    }
}