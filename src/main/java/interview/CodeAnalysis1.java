package interview;

/**
 * Description : 代码分析
 *
 * @author : JunJiang
 * @date : 2021-10-23 17:05
 */
public class CodeAnalysis1 {

    public static void main(String[] args) {
        Accumulate1 accumulate1 = new Accumulate1();
        Accumulate2 accumulate2 = new Accumulate2();

        accumulate1.sum(new double[]{1,2,3,4,5});
        accumulate2.sum(new double[]{1,2,3,4,5});
    }

}

/**
 * 这种方式对数组的元素进行累加，在每次累加时都会对result进行更新
 * 从而导致在多个线程同时访问result时会很不安全，因为result在累加的过程中频繁的改变
 */
class Accumulate1 {

    private int result = 0;

    public void sum(double[] arr) {
        for (double t : arr) {
            result += t;
        }
    }
}


/**
 * 这种方式对数组的元素进行累加，由于引入中间变量sum，在对数组元素累加完后才会对result进行更新
 * 因此，这种方式在多线程的环境下相对安全，因为result的值在每次调用sum方法后才会更新。
 * 另一方面，在方法中引入局部变量去记录累加的中间结果，而不是每次去更新成员变量，这样的代码在执行效率上更高
 * 局部变量存储在方法对应栈帧的局部变量表中，相比对成员变量访问，更为快速。
 * **永远慎用成员变量！！！**
 */
class Accumulate2 {

    private int result = 0;

    public void sum(double[] arr) {
        int sum = 0;
        for (double t : arr) {
            sum += t;
        }
        result += sum;
    }
}