package generic;

/**
 * 描述: 泛型实例
 *
 * @author junjiang
 * @create 2019-11-04 14:36
 */
public class Pair<T> {

    private T one;
    private T two;


    public Pair(T one, T two) {
        this.one = one;
        this.two = two;
    }

    public T getOne() {
        return one;
    }

    public void setOne(T one) {
        this.one = one;
    }

    public T getTwo() {
        return two;
    }

    public void setTwo(T two) {
        this.two = two;
    }
}