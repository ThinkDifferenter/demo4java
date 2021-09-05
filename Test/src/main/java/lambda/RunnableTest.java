package lambda;

import org.junit.Test;

public class RunnableTest {

    @Test
    public void beforeJavaEight(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类 实现线程");
            }
        }).start();
    }

    @Test
    public void afterJavaEight(){
        new Thread( () -> System.out.println("java8 lambda实现线程")).start();
    }

}
