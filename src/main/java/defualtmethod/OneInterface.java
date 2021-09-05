package defualtmethod;

/**
 * 描述: 测试接口
 *
 * @author junjiang
 * @create 2019-08-08 13:32
 */
public interface OneInterface {

    /**
     * 计算
     * @param a
     * @return
     */
    double calculate(int a);


    /**
     * 接口默认方法，求平方根
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}