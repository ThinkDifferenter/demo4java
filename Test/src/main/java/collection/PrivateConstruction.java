package collection;

public class PrivateConstruction {

    private String name = "jiangjun";

    //私有构造函数
    private PrivateConstruction(){

    }


    public static void main(String[] args){

        PrivateConstruction p1 = new PrivateConstruction();

        PrivateConstruction p2 = new PrivateConstruction();

        System.out.println(p1 == p2);
        //System.out.println(p2.getClass());

    }

}
