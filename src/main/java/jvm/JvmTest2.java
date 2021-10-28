package jvm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Description :
 *
 * @author :   JunJiang
 * @date : 2021-09-05 09:59
 */
public class JvmTest2 {

    public static void main(String[] args) {
        System.out.println("begin.....");

        try {
            Thread.sleep(1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("end.....");
    }

    @Test
    public void test1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(new Integer(1), new String("One"));
        map.put(new Integer(2), new String("Two"));

        /**
         * 弱引用哈希表中对象被回收，需要被回收对象不被其他对象强引用着
         */
        Map<Integer, String> wMap = new WeakHashMap<>();
        wMap.put(new Integer(3), new String("Three"));
        wMap.put(4, "Four");

        Integer integer = new Integer(5);
        String string = new String("Five");
        wMap.put(integer, string);
        integer = null;

        System.gc();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        map.forEach((k, v) -> System.out.println(k + ":" + v));
        wMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
