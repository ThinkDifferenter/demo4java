package multithread;

/**
 * 描述: 方法同步
 *
 * @author junjiang
 * @create 2019-12-30 20:42
 */
public class MethodSynchronization {

    public static void main(String[] args) {
        User u = new User("张三", 100);
        MyThreadOne t1 = new MyThreadOne("线程A", u, 20);
        MyThreadOne t2 = new MyThreadOne("线程B", u, -60);
        MyThreadOne t3 = new MyThreadOne("线程C", u, -80);
        MyThreadOne t4 = new MyThreadOne("线程D", u, -30);
        MyThreadOne t5 = new MyThreadOne("线程E", u, 32);
        MyThreadOne t6 = new MyThreadOne("线程F", u, 21);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

}

class MyThreadOne extends Thread {
    private User u;
    private int y = 0;

    MyThreadOne(String name, User u, int y) {
        super(name);
        this.u = u;
        this.y = y;
    }

    @Override
    public void run() {
        u.oper(y);
    }
}

class User {
    private String code;
    private int cash;

    User(String code, int cash) {
        this.code = code;
        this.cash = cash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 业务方法
     * @param x 添加x万元
     */
    public synchronized void oper(int x) {
        try {
            Thread.sleep(10L);
            this.cash += x;
            System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x + "”，当前用户账户余额为：" + cash);
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", cash=" + cash +
                '}';
    }
}