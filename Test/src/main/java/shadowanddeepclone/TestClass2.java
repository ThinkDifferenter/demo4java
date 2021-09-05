package shadowanddeepclone;

public class TestClass2 {
    public static void main(String[] args) {

        Professor p = new Professor("wangwu", 50);
        Student s1 = new Student("xiaoming",20,p);
        Student s2 =  s1.clone();
        s2.getProfessor().setName("wangxiaowu");
        s2.getProfessor().setAge(30);
        System.out.println("name="+s1.getProfessor().getName()+","+"age="+s1.getProfessor().getAge());
        System.out.println("name="+s2.getProfessor().getName()+","+"age="+s2.getProfessor().getAge());
    }
}
