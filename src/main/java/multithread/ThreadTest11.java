package multithread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description : 线程测试11
 *
 * @author : JunJiang
 * @date : 2021-10-22 15:38
 */
@SuppressWarnings("All")
public class ThreadTest11 {

    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();

    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) {
                        System.out.println("生产队列已满!");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    System.out.println("生产：当前生产队列中有" + queue.size() + "产品");
                    queue.notify();

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                synchronized (queue) {
                    while (queue.size() == 0) {
                        System.out.println("生产队列已空！");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    System.out.println("消费：当前生产队列中有" + queue.size() + "产品");
                    queue.notify();

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest11 pc = new ThreadTest11();
        // 成员内部类
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}

