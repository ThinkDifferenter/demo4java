package interfacedefaultmethod;

public interface InterfaceB {
    default void method(){
        System.out.println("this is default method in interface B");
    }
}
