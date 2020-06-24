package Thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/23 18:14
 * @Version 1.0.0
 * @Description
 **/
public class LockSupportTest {
    static Thread t1,t2;
    public static void main(String[] args) {
        String a="我是卢大伟吗";

        t1=new Thread(()->{
            for (int i=0;i<a.length();i++){
                System.out.println(i);
                LockSupport.unpark(t2); //叫醒T2
                LockSupport.park(); //T1阻塞
            }
        });
        t2=new Thread(()->{  //注意线程叫醒顺序
            for (int i=0;i<a.length();i++){
                LockSupport.park();
                System.out.println(a.charAt(i));
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }
}
