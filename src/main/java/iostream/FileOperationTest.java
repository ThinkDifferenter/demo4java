package iostream;

import org.junit.Test;

import java.io.*;

/**
 * Description : 文件操作测试
 *
 * @author :   JunJiang
 * @date : 2021-09-15 20:33
 */
public class FileOperationTest {

    @Test
    public void testOne() {
        FileReader in = null;
        int b;
        try {
            in = new FileReader("C:\\Users\\Light_up\\Desktop\\Test\\Notes.txt");
            b = in.read();
            while (b != -1) {
                System.out.print((char) b);
                b = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTwo() {
        FileReader in;
        FileWriter out;
        int b;

        try {
            in = new FileReader("C:\\Users\\Light_up\\Desktop\\Test\\Notes.txt");
            out = new FileWriter("C:\\Users\\Light_up\\Desktop\\Test\\NotesDup.txt");
            while ((b = in.read()) != -1) {
                System.out.print((char) b);
                out.write(b);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThree() {
        FileWriter out;
        /**
         * char 2个字节 最大65535
         */
        final int charSize = 50000;
        try {
            out = new FileWriter("C:\\Users\\Light_up\\Desktop\\Test\\NotesUniChar.txt");
            for (int i = 0; i < charSize; i++) {
                out.write(i);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
