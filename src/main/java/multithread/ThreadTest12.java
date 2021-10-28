package multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description : 线程测试12
 *
 * @author : JunJiang
 * @date : 2021-10-22 19:24
 */
@SuppressWarnings("ALL")
public class ThreadTest12 {

    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    /**
     * 使用Lock处理同步问题时，由于没有使用synchronize修饰符，线程间的通信方式不能再使用wait()、notify()等方法
     * 这时可以用属于该lock的条件对象Condition来实现线程间的通信
     */
    private final Condition condition = lock.newCondition();

    class Consumer implements Runnable {

        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        System.out.println("生产队列已空！");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.poll();
                    System.out.println("消费：生产队列中还有" + queue.size() + "个产品");
                    condition.signal();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class Producer implements Runnable {

        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                lock.lock();
                try {
                    if (queue.size() == MAX_LEN) {
                        System.out.println("生产队列已满！");
                        try {
                            condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.add(1);
                    System.out.println("生产：生产队列中还有" + queue.size() + "个产品");
                    condition.signal();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest12 pc = new ThreadTest12();
        // 成员内部类
        ThreadTest12.Producer producer = pc.new Producer();
        ThreadTest12.Consumer consumer = pc.new Consumer();
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}


