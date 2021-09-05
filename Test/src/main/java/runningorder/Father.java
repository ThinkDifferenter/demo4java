package runningorder;

/**
 * 描述: 父类
 *
 * @author junjiang
 * @date 2020-03-24 19:53
 */
public class Father {
    static {
        System.out.println("Father静态块");
    }

    {
        System.out.println("Father构造块");
    }

    public Father() {
        System.out.println("Father构造函数");
    }

    void func1() {
        System.out.println("Father方法 1");
    }
}