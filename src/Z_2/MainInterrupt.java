package Z_2;

import java.util.Scanner;
public class MainInterrupt {
    public static void main(String[] args) {
        Thread controllerThread = new ControllerThread();
        controllerThread.start();
    }
}
class ControllerThread extends Thread{
    @Override
    public void run(){
        super.run();
        System.out.println("Напишите любые символы");
        String txt = new Scanner(System.in).nextLine();
        Thread outThread = new OutThread(txt); // без создания Объекта класса невозможно получить данные из консоли, иначе будет null
        outThread.start();
    }
}
class OutThread extends Thread{
    String txt;
    public OutThread(String txt) {
        this.txt = txt;
    }

    @Override
    public void run(){
        super.run();
        System.out.println(txt);
    }
}
