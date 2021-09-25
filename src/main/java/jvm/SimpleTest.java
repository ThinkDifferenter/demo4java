package jvm;


/**
 * Description :
 *
 * @author :   JunJiang
 * @date : 2021-09-05 14:41
 */
public class SimpleTest {

    public static void main(String[] args) {
        System.out.println("Simple Test");

        long initSize = Runtime.getRuntime().totalMemory() / 1024 / 1024;

        long maxSize = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("初始堆内存：" + initSize);

        System.out.println("最大堆内存：" + maxSize);

        System.out.println("系统物理内存：" + initSize * 64);

        System.out.println("系统物理内存：" + maxSize * 4);

    }
}
