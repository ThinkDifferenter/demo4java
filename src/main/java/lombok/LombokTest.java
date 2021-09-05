package lombok;

import lombok.extern.slf4j.Slf4j;

/**
 * Description : lombok 学习
 *
 * @author :   JunJiang
 * @date : 2020-04-23 17:37
 */
public class LombokTest {

    public static void main(String[] args) {
        PersonWithLombok personWithLombok = new PersonWithLombok();
        PersonWithoutLombok personWithoutLombok = new PersonWithoutLombok();
    }
}
