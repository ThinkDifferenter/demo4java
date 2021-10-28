package multithread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Description : 线程测试13
 *
 * @author : JunJiang
 * @date : 2021-10-22 20:04
 */
@SuppressWarnings("All")
public class ThreadTest13 {

    private final int MAX_LEN = 10;
    private BlockingQueue<Integer> queue = new LinkedBlockingDeque<Integer>(MAX_LEN);

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                while (queue.size() == MAX_LEN) {
                    System.out.println("生产队列已满!");
                    Thread.yield();
                }
                try {
                    // BlockingQueue的put()方法通过lock的方式保证线程安全
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产：当前生产队列中有" + queue.size() + "产品");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                while (queue.size() == 0) {
                    System.out.println("生产队列已空！");
                    Thread.yield();
                }
                try {
                    // BlockingQueue的take()方法通过lock的方式保证线程安全
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费：当前生产队列中有" + queue.size() + "产品");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest13 pc = new ThreadTest13();
        // 成员内部类
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }

}
