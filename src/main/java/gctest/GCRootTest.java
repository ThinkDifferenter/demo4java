package gctest;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Description : GC Root 测试
 *
 * @author : JunJiang
 * @date : 2021-09-19 19:35
 */
public class GCRootTest {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        Date date = new Date();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
            Thread.sleep(10);
        }

        System.out.println("对象添加结束，按任意键继续！");
        new Scanner(System.in).nextLine();

        list = null;
        date = null;

        System.out.println("局部变量已置空，按任意键结束！");
        new Scanner(System.in).nextLine();
    }
}
