package genericsuperandextends;

public class Pear extends Fruit {
    @Override
    public void message(){
        System.out.println("this is pear");
    }

    static {
        System.out.println("this is pear");
    }
}
