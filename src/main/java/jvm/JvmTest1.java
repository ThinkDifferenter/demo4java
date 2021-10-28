package jvm;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description :
 *
 * @author :   JunJiang
 * @date : 2021-09-05 09:56
 */
public class JvmTest1 {

    @Test
    public void test1() {
        List<HeapInstance> list = new ArrayList<>();
        while (true) {
            list.add(new HeapInstance(new Random().nextInt(10) * 1024 * 1024));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        System.out.println("Simple Test");

        long initSize = Runtime.getRuntime().totalMemory() / 1024 / 1024;

        long maxSize = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("初始堆内存：" + initSize);

        System.out.println("最大堆内存：" + maxSize);

        System.out.println("系统物理内存：" + initSize * 64);

        System.out.println("系统物理内存：" + maxSize * 4);
    }

}

class HeapInstance {
    private byte[] bytes;

    public HeapInstance(int length) {
        this.bytes = new byte[length];
    }
}
