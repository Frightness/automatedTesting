package task4;

public class HelloWorldThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Hello, world!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HelloWorldThread thread = new HelloWorldThread();
        thread.start();
    }
}
