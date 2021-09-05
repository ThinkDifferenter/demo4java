package runningorder;

/**
 * 描述: 子类
 *
 * @author junjiang
 * @date 2020-03-24 19:54
 */
public class Son extends Father{
    static {
        System.out.println("Son静态快");
    }

    {
        System.out.println("Son构造块");
    }

    public Son(){
        System.out.println("Son构造函数");
    }

    @Override
    public void func1(){
        System.out.println("子类方法1");
    }

    public void func2(){
        System.out.println("子类方法2");
    }
}