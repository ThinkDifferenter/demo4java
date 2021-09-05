package serializable;

import java.io.Serializable;

/**
 * 描述: 序列化&反序列化测试
 *
 * @author junjiang
 * @date 2020-03-23 14:44
 */
public class User1 implements Serializable {

    private Info myInfo;
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Info getMyInfo() {
        return myInfo;
    }

    public void setMyInfo(Info myInfo) {
        this.myInfo = myInfo;
    }

    @Override
    public String toString() {
        return "User1{" +
                "myInfo=" + myInfo +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Info implements Serializable{
    private float tall;
    private float weight;

    public Info(float tall, float weigit) {
        this.tall = tall;
        this.weight = weigit;
    }

    public Info() { }

    public float getTall() {
        return tall;
    }

    public void setTall(float tall) {
        this.tall = tall;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Info{" +
                "tall=" + tall +
                ", weight=" + weight +
                '}';
    }
}