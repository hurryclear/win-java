
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("jiang");
        t2.setName("lin");
        t1.start();
        t2.start();
    }
}
