package interfacedefaultmethod;

public interface InterfaceA {
    default void method(){
        System.out.println("this is default method in interface A");
    }
}
