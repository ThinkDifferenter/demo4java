package runningorder;

/**
 * 描述: 执行顺序测试
 *
 * @author junjiang
 * @date 2020-03-24 19:53
 */
public class Test {

    public static void main(String[] args){
        Son s = new Son();
        s.func1();
        s.func2();
    }
}