package stringtable;

import org.junit.Test;

/**
 * Description : 到底创建了多少个对象
 *
 * @author : JunJiang
 * @date : 2021-09-18 14:56
 */
public class StringNewTest {

    @Test
    public void testOne() {
        String str1 = "Java";
        String str2 = new String("Java").intern();
        // true
        System.out.println(str1 == str2);

        String str3 = "Java";
        String str4 = new String("Java");
        str4.intern();
        // false
        System.out.println(str3 == str4);

        String str5 = new String("Java").intern();
        String str6 = "Java";
        // true
        System.out.println(str5 == str6);

        String str7 = new String("Java");
        str7.intern();
        String str8 = "Java";
        // false
        System.out.println(str7 == str8);
    }

    /**
     * 比较两种String创建方式共创建了多少个对象
     * Java6 & Java7及以后，向字符串常量池中添加字符串的方式不同！
     */
    @Test
    public void testTwo() {
        // 该语句执行后会在字符串常量池中创建字符串常量
        String str1 = new String("Java");
        str1.intern();
        String str2 = "Java";
        // false
        System.out.println(str1 == str2);

        // 该语句执行后不会在字符串常量池中创建字符串常量
        String str3 = new String("Jiang") + new String("Zhang");
        str3.intern();
        String str4 = "JiangZhang";
        // true
        System.out.println(str3 == str4);
    }

    @Test
    public void testThree(){
        String str3 = new String("Jiang") + new String("Zhang");
        String str4 = "JiangZhang";
        str3.intern();
        // false
        System.out.println(str3 == str4);
    }

    @Test
    public void testFour(){
        String str3 = new String("Jiang") + new String("Zhang");
        String str4 = str3.intern();

        System.out.println(str3 == "JiangZhang");
        System.out.println(str4 == "JiangZhang");
    }

    @Test
    public void testFive(){
        final int MAX_SIZE = 100000;
        for (int i=0;i<MAX_SIZE;i++){
            String.valueOf(i).intern();
        }
    }

}
