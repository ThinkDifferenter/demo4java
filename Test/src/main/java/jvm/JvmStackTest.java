package jvm;

/**
 * Description : Jvm栈测试
 *
 * @author :   JunJiang
 * @date : 2021-09-05 10:00
 */
public class JvmStackTest {
    private static int cnt = 0;

    public static void main(String[] args) {
        cnt++;
        System.out.println(cnt);
        main(args);
    }
}
