package generic;

/**
 * Description : 泛型测试3
 *
 * @author : JunJiang
 * @date : 2021-10-28 15:21
 */
public class GenericTest3<E, T> extends AClass<E,T> {

    public GenericTest3(E field1, T field2) {
        super(field1, field2);
    }

    public static void main(String[] args) {

    }
}

class AClass<E, T> {
    private E field1;
    private T field2;

    public AClass(E field1, T field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public E getField1() {
        return field1;
    }

    public void setField1(E field1) {
        this.field1 = field1;
    }

    public T getField2() {
        return field2;
    }

    public void setField2(T field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "AClass{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                '}';
    }
}

