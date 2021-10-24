package stringtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : StringTest1
 *
 * @author :   JunJiang
 * @date : 2021-09-14 09:49
 */
public class StringTest1 {

    public static void main(String[] args) {
        // 保持引用，防止GC回收内存
        List<String> strings = new ArrayList<>();
        short i = 0;
        while (true) {
            strings.add(String.valueOf(i++).intern());
        }
    }

    @Test
    public void testOne() {
        String s = new String("hello");
        String s1 = s.intern();

        System.out.println(s == "hello");
        System.out.println(s1 == "hello");
        System.out.println(s == s1);
    }

    @Test
    public void testTwo() {
        String s = new String("hello") + "world";
        String s1 = s.intern();

        System.out.println(s == "helloworld");
        System.out.println(s1 == "helloworld");
        System.out.println(s == s1);
    }
}
