package shadowanddeepclone;

public class TestClass {
    public static void main(String[] args) {

        User u = new User("xiaoming",20);
        User u2 = u.clone();
        u2.setName("lisi");
        u2.setAge(30);
        System.out.println("name="+u.getName()+","+"age="+u.getAge());
        System.out.println("name="+u2.getName()+","+"age="+u2.getAge());
    }
}
