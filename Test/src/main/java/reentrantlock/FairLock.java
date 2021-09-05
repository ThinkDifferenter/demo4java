package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述: 公平所
 *
 * @author junjiang
 * @date 2020-03-25 14:15
 */
public class FairLock {

    private static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        final int threadNum = 5;
        for (int i = 0; i < threadNum; i++) {
            new Thread(new ThreadDemo(i)).start();
        }
    }

    static class ThreadDemo implements Runnable {
        Integer id;

        ThreadDemo(Integer id) {
            this.id = id;
        }

        @Override

        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("获得锁的线程：" + id);
                lock.unlock();
            }
        }
    }

}