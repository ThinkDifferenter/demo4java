package multithread;

/**
 * 描述: 守护线程
 *
 * @author junjiang
 * @create 2019-12-25 15:04
 */
public class DaemonThread {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 线程休眠
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                    System.out.println("我是子线程...");
                }
            }
        });

        // 将线程设置为守护线程并开启线程
        thread.setDaemon(true);
        thread.start();

        // main() -> 主线程
        for (int i = 0; i < 10; i++) {
            try {
                // 主线程休眠
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            System.out.println("我是主线程");
        }

        System.out.println("主线程执行完毕!");
    }
}