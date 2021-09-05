package bridgemethod;

public class Child extends Parent<String> {
    @Override
    public void sayHello(String value) {
        System.out.println("This is Child class, value is " + value);
    }
}
