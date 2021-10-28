package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description : 线程测试10
 *
 * @author : JunJiang
 * @date : 2021-10-22 08:47
 */
public class ThreadTest10 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadAAA threadAAA = new ThreadAAA();
        ThreadBBB threadBBB = new ThreadBBB();

        executorService.execute(threadAAA);
        executorService.execute(threadBBB);

        executorService.shutdown();
    }
}


@SuppressWarnings("Duplicates")
class ThreadAAA extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "偶数：" + i);
            }
            if (i % 20 == 0) {
                Thread.yield();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

@SuppressWarnings("Duplicates")
class ThreadBBB extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "奇数 " + i);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

