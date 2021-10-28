package multithread;

/**
 * Description : 多线程2
 *
 * @author : JunJiang
 * @date : 2021-10-20 09:25
 */
public class ThreadTest2 {

    public static void main(String[] args) throws InterruptedException {
        ThreadAA threadAa = new ThreadAA();
        ThreadBB threadBb = new ThreadBB();

        threadBb.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 50){
                threadBb.join();
            }
        }

    }


}

@SuppressWarnings("Duplicates")
class ThreadAA extends Thread {
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
class ThreadBB extends Thread {
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