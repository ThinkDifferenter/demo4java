package multithread;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Description : 线程测试7
 *
 * @author : JunJiang
 * @date : 2021-10-21 15:43
 */
public class ThreadTest7 {

    public static void main(String[] args) {
        Windows3 windows = new Windows3();
        Thread thread1 = new Thread(windows, "窗口1");
        Thread thread2 = new Thread(windows, "窗口2");
        Thread thread3 = new Thread(windows, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class Windows3 implements Runnable {

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
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
            } finally {
                lock.unlock();
            }

        }
    }
}



