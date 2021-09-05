package synchronizedtest;

/**
 * 描述: 同步测试
 *
 * @author junjiang
 * @date 2020-03-27 10:45
 */
public class SynchronizedTestFour implements Runnable {

    /**
     * 共享资源
     */
    private static int i = 0;

    /**
     * synchronized 修饰静态实例方法
     */
    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 静态实例方法的锁属于类
        Thread t1 = new Thread(new SynchronizedTestFour());
        Thread t2 = new Thread(new SynchronizedTestFour());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}