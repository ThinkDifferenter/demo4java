package reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述: 中断锁
 *
 * @author junjiang
 * @date 2020-03-25 14:26
 */
public class InterruptLock {

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        //该线程先获取锁1,再获取锁2
        Thread thread = new Thread(new ThreadDemo(lock1, lock2));
        //该线程先获取锁2,再获取锁1
        Thread thread1 = new Thread(new ThreadDemo(lock2, lock1));
        thread.start();
        thread1.start();
        thread.interrupt();//是第一个线程中断
    }

    static class ThreadDemo implements Runnable {
        Lock firstLock;
        Lock secondLock;

        ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            try {
                // 响应中断
                firstLock.lockInterruptibly();
                //更好的触发死锁
                TimeUnit.MILLISECONDS.sleep(10);
                secondLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束!");
            }
        }
    }
}