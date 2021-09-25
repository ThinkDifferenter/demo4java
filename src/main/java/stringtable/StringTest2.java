package stringtable;

import org.junit.Test;

/**
 * Description :
 *
 * @author :   JunJiang
 * @date : 2021-09-14 10:25
 */
public class StringTest2 {

    public static void main(String[] args) {
        String str1 = "a" + "b" + "c";
        String str2 = "abc";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }

    @Test
    public void test1() {
        String s1 = "jiang";
        String s2 = "zhang";

        String s3 = "jiangzhang";
        String s4 = s1 + "zhang";
        String s5 = "jiang" + s2;
        String s6 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);

        String s7 = s6.intern();
        System.out.println(s3 == s7);
    }

    @Test
    public void test2() {
        String string = "jiangzhang";
        final String str = "jiang";
        String str2 = str + "zhang";

        System.out.println(string == str2);
    }

}
