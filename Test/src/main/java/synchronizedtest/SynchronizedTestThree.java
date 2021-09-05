package synchronizedtest;

/**
 * 描述: 同步测试
 *
 * @author junjiang
 * @date 2020-03-27 10:44
 */
public class SynchronizedTestThree {

    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }


    public static void main(String[] args) {
        final SynchronizedTestThree test1 = new SynchronizedTestThree();
        final SynchronizedTestThree test2 = new SynchronizedTestThree();

        // 属于不同对象的锁互不影响
        new Thread(test1::method1).start();
        new Thread(test2::method2).start();
    }
}