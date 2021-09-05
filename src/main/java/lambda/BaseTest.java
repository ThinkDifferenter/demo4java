package lambda;

public class BaseTest {

    final static String salutation = "Hello! ";

    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");

        Adding opAdd = (int a,int b) -> a+b;
        System.out.println(opAdd.add(1,2));

        SaySomeThing say = (message) -> "I am jiangjun:" + message;
        System.out.println(say.saySomeThing("I love programming"));

        Number num  = () -> 5;
        System.out.println(num.number());
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    interface  Adding{
        int add(int a,int b);
    }

    interface SaySomeThing{
        String saySomeThing(String message);
    }

    interface Number{
        int number();
    }
}


