package jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description : 堆实例测试
 *
 * @author :   JunJiang
 * @date : 2021-09-05 20:43
 */
public class HeapInstanceTest {
    static int numbers = 0;
    static String str ="jiang";

    byte[] buffer = new byte[new Random().nextInt(1024 * 1024)];

    public static void main(String[] args) throws InterruptedException {
        List<HeapInstanceTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInstanceTest());
            Thread.sleep(100);
        }
    }
}
