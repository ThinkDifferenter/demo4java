package iostream;

import java.io.File;

/**
 * Description : TestOne
 *
 * @author :   JunJiang
 * @date : 2021-09-14 14:35
 */
public class TestOne {

    public static void main(String[] args) {
        // 使用正斜杠在Windows、Linux平台均能正常使用
        File dir = new File("D:/Documents/");
        getFilesTree(dir, 0);

    }

    private static void getFilesTree(File dir, int level) {
        String preStr = "";
        for (int i = 0; i < level; i++) {
            preStr += "     ";
        }

        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(preStr + file.getName());
            if (file.isDirectory()) {
                getFilesTree(file, level + 1);
            }
        }
    }




}
