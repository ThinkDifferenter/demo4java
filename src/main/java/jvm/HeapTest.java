package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 *
 * @author :   JunJiang
 * @date : 2021-09-05 15:16
 */
public class HeapTest {

    protected int j;

    static class Test {
        int[] arr = new int[1024 * 1024];
    }

    public HeapTest(){
        System.out.println("this is father constructor");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Test> testArr = new ArrayList<>();
        while (true) {
            testArr.add(new Test());
            Thread.sleep(1000);
        }
    }

}

class HeapTestSub extends HeapTest {
    private int i;

    public void show() {
        System.out.println("this is sub class");
        super.j = 10;
    }

    public HeapTestSub(){
        System.out.println("this is son constructor method");
    }

    public static void main(String[] args) {
        System.out.println("this is sub class main method");
        HeapTestSub heapTestSub = new HeapTestSub();
    }
}