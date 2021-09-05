package synchronizedtest;

/**
 * 描述: 同步测试
 *
 * @author junjiang
 * @date 2020-03-27 10:34
 */
public class SynchronizedTestTwo {

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
        final SynchronizedTestTwo test = new SynchronizedTestTwo();

        new Thread(test::method1).start();
        new Thread(test::method2).start();
    }
}