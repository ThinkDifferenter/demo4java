package synchronizedtest;

/**
 * 描述: synchronized测试
 *
 * @author junjiang
 * @date 2020-03-27 10:07
 */
public class SynchronizedTestOne implements Runnable {

    /**
     * 共享资源
     */
    private static int i = 0;

    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTestOne test = new SynchronizedTestOne();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}