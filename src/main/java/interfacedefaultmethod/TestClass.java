package interfacedefaultmethod;

/**
 * 继承的类和实现的接口中包含的相同的方法时优先调用继承的类中的方法
 */
public class TestClass extends ClassA implements InterfaceA {

    public static void main(String[] args){
        TestClass test = new TestClass();
        test.method();
    }
}
