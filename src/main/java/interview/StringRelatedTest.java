package interview;

import org.junit.Test;

/**
 * Description : 字符串相关
 *
 * @author : JunJiang
 * @date : 2021-10-23 16:33
 */
public class StringRelatedTest {

    @Test
    public void test1() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        /**
         * StringBuffer的append()方法对于null对象的添加底层调用的是AbstractStringBuilder的appendNull()方法
         appendNull方法将null进行拆分在分别添加
         */
        sb.append(str);

        System.out.println(sb);
        System.out.println(sb.length());

        // NullPointerException
        // StringBuffer stringBuffer = new StringBuffer(str);
        // System.out.println(stringBuffer);
    }

    @Test
    public void test2() {
        String str = new String("jiang") + new String("zhang");
        str.intern();
        String str2 = "jiangzhang";
        /**
         * 1.字符串连接符两端存在字符串边量，此时不会向字符串常量池中写入对应的字符串常量
         * 2.对于向字符串常量池中写入一个字符串常量，在Java6及以前会在方法区(永久代实现)中的字符串常量池里创建一个字符串常量
         * 在Java7及以后只会在字符串常量池中创建一个字符串常量引用指向堆空间中对应的字符串对象，即该字符串常量的地址就为堆空
         * 间中对象的地址，这样做可以大大节约存储空间。至于为什么有这样的转变，是因为在Java7及以后版本，字符串常量池的存储位
         * 置由方法区移至堆空间，这样字符串常量就与实例对象同在堆空间中，使得字符串常量池中存储指向字符串对象的引用变成可能。
         */
        // true
        System.out.println(str == str2);
    }
}
