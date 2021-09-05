package bridgemethod;

public class Main {

    public static void main(String args[]){
        Child child = new Child();
        Parent<String> parent = child;
        parent.sayHello("This is a string");
    }
}