package statictest;

/**
 * 描述: static关键字测试
 *
 * @author junjiang
 * @create 2019-08-08 15:40
 */
public class StaticTest {

    static {
        System.out.println("Static block output...\n");
    }


    public StaticTest(){
        System.out.println("Constructor method output...\n");
    }

    public static void main(String[] args) {

        StaticTest staticTest = new StaticTest();

    }
}