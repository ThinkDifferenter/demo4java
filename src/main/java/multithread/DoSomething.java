package multithread;

/**
 * 描述: Runnable 接口 实现多线程
 *
 * @author junjiang
 * @create 2019-12-25 16:13
 */
public class DoSomething {

    private String name;

    private static final long ROUND = 100000000L;

    public DoSomething(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            for (long k = 0; k < ROUND; k++) {
                System.out.println(name + ": " + i);
            }
        }
    }

}