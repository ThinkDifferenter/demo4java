package reentrantlock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述: 阻塞队列实现
 *
 * @author junjiang
 * @date 2020-03-25 15:03
 */
public class BlockQueueImpl<E> {

    /**
     *
     */
    private int queueSize;

    /**
     *
     */
    private Lock lock = new ReentrantLock();

    /**
     *
     */
    private Condition empty = lock.newCondition();

    /**
     *
     */
    private Condition full = lock.newCondition();

    /**
     *
     */
    private LinkedList<E> linkedList = new LinkedList();


    public BlockQueueImpl(int queueSize) {
        this.queueSize = queueSize;
    }

    /**
     * 入队 - 队列满时阻塞
     * @param e 入队元素
     */
    public void enQueue(E e){
        lock.lock();
        try {
            // 队满一直等待
            while(linkedList.size() == queueSize){
                full.await();
            }

            linkedList.add(e);
            System.out.println("入队:" + e);

            // 通知队空的等待可以解除
            empty.signal();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 出队 - 队列空时阻塞
     * @return 出队元素
     */
    public E deQueue(){
        lock.lock();
        E e = null;
        try {
            //队空一直等待
            while(linkedList.size() == 0){
                empty.await();
            }

            e = linkedList.removeFirst();
            System.out.println("出队:" + e);

            // 通知队满的等待可以解除
            full.signal();
        } catch (InterruptedException ep) {
            ep.printStackTrace();
        }finally {
            lock.unlock();
        }
        return e;
    }

    public static void main(String[] args){

    }

}