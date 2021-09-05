package defualtmethod;

import org.junit.Test;

/**
 * 描述: 接口默认方法测试
 *
 * @author junjiang
 * @create 2019-08-08 13:30
 */
public class DefaultMethodTest implements OneInterface{


    @Override
    public double calculate(int a) {
        return sqrt(a);
    }

    @Test
    public void DefaultMethodTest(){
        System.out.println(sqrt(100));
        System.out.println(calculate(100));
    }
}