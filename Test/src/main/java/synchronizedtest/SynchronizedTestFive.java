package synchronizedtest;

/**
 * 描述: 同步测试
 *
 * @author junjiang
 * @date 2020-03-27 10:49
 */
public class SynchronizedTestFive implements Runnable {


    private static SynchronizedTestFive instance = new SynchronizedTestFive();

    private static int i = 0;

    @Override
    public void run() {

        // 省略其他耗时操作....
        // 使用同步代码块对变量i进行同步操作
        // 锁对象为instance
        // 在某些情况下，我们编写的方法体可能比较大，同时存在一些比较耗时的操作，而需要同步的代码又只有一小部分，
        // 如果直接对整个方法进行同步操作，可能会得不偿失，此时我们可以使用同步代码块的方式对需要同步的代码进行包裹，
        // 这样就无需对整个方法进行同步操作了
        //this,当前实例对象锁
        /**
        synchronized(this){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }

        //class对象锁
        synchronized(AccountingSync.class){
            for(int j=0;j<1000000;j++){
                i++;
            }
        }*/
        synchronized (instance) {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}