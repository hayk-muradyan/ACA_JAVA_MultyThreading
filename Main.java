class MyThread extends Thread {

    MyThread(String name){
        super(name);
    }
    public void run(){
        while(!isInterrupted()){
            try {
                System.out.println("Hello");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        MyThread t = new MyThread("MyThread");
        t.start();
        try{
            Thread.sleep(2000);
            t.interrupt();
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}
