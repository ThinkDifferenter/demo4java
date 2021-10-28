package multithread;


/**
 * Description : 线程测试8
 *
 * @author : JunJiang
 * @date : 2021-10-21 16:19
 */
public class ThreadTest8 {
    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number, "甲");
        Thread thread2 = new Thread(number, "乙");

        thread1.start();
        thread2.start();
    }
}

class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + "数" + number);
                    number++;
                } else {
                    break;
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
