package test;

/**
 * 描述: 主测试
 *
 * @author junjiang
 * @date 2020-03-20 16:07
 */
public class Main {

    private static int cnt = 0;

    public static void main(String[] args) {
        int number = 10;
        System.out.println("number = " + number);
        method1();
        System.out.println("main method end");
    }

    public static void method1() {
        System.out.println("method one");
        method2();
    }

    public static int method2() {
        System.out.println("method two");
        int i = 0;
        return i;
    }
}