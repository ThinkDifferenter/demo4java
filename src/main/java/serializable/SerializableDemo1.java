package serializable;

import java.io.*;

/**
 * 描述: 序列化&反序列化测试
 *
 * @author junjiang
 * @date 2020-03-23 14:45
 */
public class SerializableDemo1 {

    public static void main(String[] args) throws Exception, IOException {
        //初始化对象
        User1 user = new User1();
        user.setName("jiang jun");
        user.setAge(23);
        user.setMyInfo(new Info(1.75f,65.0f));
        System.out.println(user);
        //序列化对象到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("template"));
        oos.writeObject(user);
        oos.close();
        //反序列化
        File file = new File("template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User1 newUser = (User1)ois.readObject();
        System.out.println(newUser.toString());
    }
}