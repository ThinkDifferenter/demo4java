package objectoriented;

/**
 * Description : 接口指向接口实现类
 *
 * @author : JunJiang
 * @date : 2021-10-28 15:58
 */
public class ObjectOrientedTest1 implements AInterface{

    public int number = 100;

    @Override
    public void show() {
        System.out.println("this is interface show method");
    }

    public void display(){
        System.out.println("this is class display method");
    }

    public static void main(String[] args) {
        AInterface aInterface = new ObjectOrientedTest1();

        // 接口引用只能访问接口实现类中接口所定义的字段和方法
        // aInterface.display(); aInterface.number; Error！
        aInterface.show();
        System.out.println(AInterface.NUMBER);

    }

}

interface AInterface {
    int NUMBER = 10;
    void show();
}
