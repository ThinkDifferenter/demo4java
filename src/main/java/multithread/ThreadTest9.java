package multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description : 线程测试9
 *
 * @author : JunJiang
 * @date : 2021-10-21 17:36
 */
public class ThreadTest9 {

    public static void main(String[] args) {
        A a = new A();
        FutureTask task = new FutureTask(a);

        new Thread(task).start();

        try {
            System.out.println("总和："+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class A implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}