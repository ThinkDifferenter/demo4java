package multithread;

/**
 * Description : 线程3
 *
 * @author : JunJiang
 * @date : 2021-10-20 09:50
 */
public class ThreadTest3 {

    public static void main(String[] args) {
        ThreadC threadC = new ThreadC();
        Thread t = new Thread(threadC);

        t.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "偶数 " + i);
                    }
                }
            }
        });
        thread.start();

        Thread th = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "偶数 " + i);
                }
            }
        });
        th.start();
    }
}

class ThreadC implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "偶数 " + i);
            }
        }
    }
}
