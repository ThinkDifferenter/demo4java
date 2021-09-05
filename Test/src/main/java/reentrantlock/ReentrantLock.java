package reentrantlock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述: ReentrantLock 互斥排他锁测试
 *
 * @author junjiang
 * @date 2020-03-26 10:24
 */
public class ReentrantLock {

    public static void main(String[] args){

        // 读读共享
        final ReadTask readTask = new ReadTask();

        Thread threadRead1 = new Thread(() -> readTask.read());
        threadRead1.setName("threadRead1");

        Thread threadRead2 = new Thread(() -> readTask.read());
        threadRead2.setName("threadRead2");

        System.out.println("=====================读读共享==================");
        threadRead1.start();
        threadRead2.start();

        // 写写互斥
        final WriteTask writeTask = new WriteTask();

        Thread threadWrite1 = new Thread(() -> writeTask.write());
        threadWrite1.setName("threadWrite1");

        Thread threadWrite2 = new Thread(() -> writeTask.write());
        threadWrite2.setName("threadWrite2");

        System.out.println("=====================写写互斥==================");
        threadWrite1.start();
        threadWrite2.start();

        // 读写互斥
        // 读线程
        Thread threadRead3 = new Thread(()->readTask.read());
        threadRead3.setName("threadRead3");

        // 写线程
        Thread threadWrite3= new Thread(()->writeTask.write());
        threadWrite3.setName("threadWrite3");

        System.out.println("=====================读写互斥==================");
        threadRead3.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadWrite3.start();


        // 写读互斥
        // 写线程
        Thread threadWrite4 = new Thread(()->writeTask.write());
        threadWrite4.setName("threadWrite4");

        // 读线程
        Thread threadRead4 = new Thread(()->readTask.read());
        threadRead4.setName("threadRead4");

        System.out.println("=====================写读互斥==================");
        threadWrite4.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadRead4.start();
    }
}


/**
 *读任务
 */
class ReadTask{

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            // 读锁 - 共享锁
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}


/**
 *写任务
 */
class WriteTask{

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void write() {
        try {
            // 写锁 - 排他锁
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}




