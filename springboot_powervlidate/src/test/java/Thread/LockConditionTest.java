package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/23 18:50
 * @Version 1.0.0
 * @Description  使用Condition 交替输出打印
 **/
public class LockConditionTest {
    public static void main(String[] args) {
        String str="交替打印！";
        Lock lock=new ReentrantLock();
        Condition condition1 = lock.newCondition(); //相当于队列
        Condition condition2 = lock.newCondition();

        new Thread(()->{
            try {
                for (int i=0;i<str.length();i++) {
                        lock.lock();
                        System.out.println(i);
                        condition2.signal();
                        condition1.await();
                }
                condition2.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"t1").start();

        new Thread(()->{
            try {
                for (int i=0;i<str.length();i++) {

                        lock.lock();
                        System.out.println(str.charAt(i));
                        condition1.signal();
                        condition2.await();
                }
                condition1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"t2").start();
    }
}
