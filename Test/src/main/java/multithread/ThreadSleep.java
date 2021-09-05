package multithread;

/**
 * 描述: 线程休眠 优先级调度
 *
 * @author junjiang
 * @create 2019-12-30 16:14
 */
public class ThreadSleep {

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        // Thread t2 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyDaemon());
        // 设置进程2为守护进程
        t2.setDaemon(true);


        // 设置线程优先级
        //t1.setPriority(10);
        //t2.setPriority(1);

        t2.start();
        t1.start();

//        for(int i = 0; i<30; i++){
//
//            System.out.println("主线程第" + i + "次执行！");
//            if (i > 2) {
//                try {
//                    //t1线程合并到主线程中，主线程停止执行过程，转而执行t1线程，直到t1执行完毕后继续。
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}


/**
 * 通过继承Thread类实现多线程
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("线程1第" + i + "次执行！");
            try {
                // 谁调用sleep谁休眠
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * 通过实现Runnable接口实现多线程
 */
class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("线程2第" + i + "次执行！");
            // 线程的让步使用Thread.yield()方法，yield() 为静态方法，功能是让出该线程CPU，单CPU重新调度时可能又选择了该线程
            Thread.yield();
            try {
                // 谁调用sleep谁休眠
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * 守护线程
 */
class MyDaemon implements Runnable {

    @Override
    public void run() {
        for (long i = 0; i < 9999999L; i++) {
            System.out.println("后台守护线程第" + i + "次执行！");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}