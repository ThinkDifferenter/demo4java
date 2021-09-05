package shadowanddeepclone;

public class Professor implements Cloneable{

    private String name;
    private Integer age;

    public Professor(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
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

    //深复制：被引用的对象自己也实现了clone方法
    @Override
    public Professor clone(){
        Object o = null;
        try{
            o = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return (Professor) o;
    }
}