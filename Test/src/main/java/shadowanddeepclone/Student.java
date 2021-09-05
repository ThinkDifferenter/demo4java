package shadowanddeepclone;


public class Student implements Cloneable {
    private String name;
    private Integer age;

    //引用
    private Professor professor;

    public Student(String name, Integer age, Professor professor) {
        super();
        this.name = name;
        this.age = age;
        this.professor = professor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    //浅复制，复制该对象时该对象内的引用不被复制，而被多个对象所共享
    @Override
    public Student clone() {
        Object o = null;
        try {
            //Object中的clone()识别出你要复制的是哪一个对象
            o = super.clone();
            //对Student对象中的引用进行克隆
            ((Student) o).professor = professor.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return (Student) o;
    }
}
