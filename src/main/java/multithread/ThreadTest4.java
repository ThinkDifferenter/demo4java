package multithread;

/**
 * Description : 线程测试4
 *
 * @author : JunJiang
 * @date : 2021-10-21 08:21
 */
public class ThreadTest4 {

    public static void main(String[] args) {
        Windows1 windows1 = new Windows1();
        Thread thread1 = new Thread(windows1);
        Thread thread2 = new Thread(windows1);
        Thread thread3 = new Thread(windows1);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Windows1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
                    ticket--;
                } else {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
