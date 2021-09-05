package reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 描述: ReentrantLock可重入锁测试
 *
 * @author junjiang
 * @date 2020-03-25 14:08
 */
public class ReentrantLockTest {

    public static void main(String[] args) {

        final int lockTimes = 3;

        // true公平锁
        Lock reentrantLock = new ReentrantLock(true);

        IntStream.range(0, lockTimes).forEach(i -> reentrantLock.lock());

        IntStream.range(0, lockTimes).forEach(i -> {
            try {

            } finally {
                reentrantLock.unlock();
            }
        });
    }
}