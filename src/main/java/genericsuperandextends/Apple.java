package genericsuperandextends;


public class Apple extends Fruit {
    String str;

    public String getStr() {
        return str;
    }

    @Override
    public void message(){
        System.out.println("this is apple");
    }

    public Apple(String str){
        this.str = str;
    }

    public Apple(){
        ;
    }


}
