package jvm;

/**
 * Description : 类变量测试
 *
 * @author :   JunJiang
 * @date : 2021-09-07 15:06
 */
public class StaticFieldTest {

    private static int number = 10;

    public static void main(String[] args) {
        StaticFieldTest staticFieldTest = null;
        staticFieldTest.hello();
        System.out.println(staticFieldTest.number);
    }

    public static void hello() {
        System.out.println("hello");
    }
}
