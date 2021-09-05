package lombok;

/**
 * Description : 人类
 *
 * @author :   JunJiang
 * @date : 2020-04-23 17:38
 */
public class PersonWithoutLombok {
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String address;
    /**
     *
     */
    private Integer age;
    /**
     *
     */
    private String hobbit;
    /**
     *
     */
    private String phone;

    public PersonWithoutLombok(String name, String address, Integer age, String hobbit, String phone) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.hobbit = hobbit;
        this.phone = phone;
    }

    public PersonWithoutLombok() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobbit() {
        return hobbit;
    }

    public void setHobbit(String hobbit) {
        this.hobbit = hobbit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PersonWithoutLombok{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", hobbit='" + hobbit + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
