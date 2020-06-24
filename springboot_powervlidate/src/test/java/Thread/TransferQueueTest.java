package Thread;

import java.time.LocalDateTime;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/23 19:04
 * @Version 1.0.0
 * @Description
 **/
public class TransferQueueTest {
    static Lock lock=new ReentrantLock();
    public static void main(String[] args) {
        String str="transferQueue实现交替打印";
        TransferQueue<Object> transferQueue=new LinkedTransferQueue<>();
        try {
            lock.lock();
        }finally {
            lock.unlock();
        }

        new Thread(()->{
            try {
                for (int i=0;i<str.length();i++) {
                    transferQueue.transfer(str.charAt(i));
                    System.out.println(transferQueue.take());
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        },"t1").start();
        new Thread(()->{
            try {
                for (int i=0;i<str.length();i++) {
                    System.out.println(transferQueue.take());
                    transferQueue.transfer(i);

                }

            }catch (Exception e){
                e.printStackTrace();
            }

        },"t2").start();
    }



}
