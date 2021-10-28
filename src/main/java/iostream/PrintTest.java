package iostream;

import java.io.PrintStream;

/**
 * Description : 输入输出流测试
 *
 * @author : JunJiang
 * @date : 2021-10-23 15:04
 */
public class PrintTest {

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        swap(i, j);
    }

    public static void swap(int i, int j) {
        System.setOut(new PrintStream(System.out) {
            @Override
            public void println() {
                System.out.println("i=" + (i * 10));
                System.out.println("i=" + (j * 10));
            }
        });
        System.out.println();
    }
}
