package multithread;

/**
 * Description : 线程测试5
 *
 * @author : JunJiang
 * @date : 2021-10-21 08:37
 */
@SuppressWarnings("Duplicates")
public class ThreadTest5 {

    public static void main(String[] args) {
        Windows2 windows2 = new Windows2();
        Thread thread1 = new Thread(windows2);
        Thread thread2 = new Thread(windows2);
        Thread thread3 = new Thread(windows2);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Windows2 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            sale();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票：" + ticket);
            ticket--;
        } else {
            System.exit(0);
        }
    }
}
