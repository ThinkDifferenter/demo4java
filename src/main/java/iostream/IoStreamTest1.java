package iostream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description : IO流测试1
 *
 * @author : JunJiang
 * @date : 2021-10-28 19:34
 */
@SuppressWarnings("ALL")
public class IoStreamTest1 {

    @Test
    public void test1() {
        File file = new File("D:\\Codes\\Learning\\demo4java\\src\\main\\java\\iostream\\Test.txt");
        try (FileReader fr = new FileReader(file)) {
            int data = fr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        File file = new File("D:\\Codes\\Learning\\demo4java\\src\\main\\java\\iostream\\Test.txt");
        char[] buffer = new char[64];
        try (FileReader fr = new FileReader(file)) {
            int len = fr.read(buffer);
            while (len != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(buffer[i]);
                }
                len = fr.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        File file = new File("D:\\Codes\\Learning\\demo4java\\src\\main\\java\\iostream\\TestWriter.txt");
        int length = 100;
        try (FileWriter fw = new FileWriter(file, true)) {
            for (int i = 0; i < length; i++) {
                fw.write(i + '0');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        File fileDest = new File("D:\\Codes\\Learning\\demo4java\\src\\main\\java\\iostream\\TestWriter.txt");
        File fileSrc = new File("D:\\Codes\\Learning\\demo4java\\src\\main\\java\\iostream\\Test.txt");

        char[] buf = new char[64];
        int len;
        try (FileWriter fw = new FileWriter(fileDest, true);
             FileReader fr = new FileReader(fileSrc)) {
            while ((len = fr.read(buf)) != -1) {
                fw.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
