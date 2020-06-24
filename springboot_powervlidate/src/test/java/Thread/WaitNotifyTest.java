package Thread;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/23 18:14
 * @Version 1.0.0
 * @Description
 *
 *
 *  想掉wait方法 则必须要用锁
 *
 *  注意  一定是先notify  唤醒其他线程，再wait
 **/
public class WaitNotifyTest {
    public static void main(String[] args) {
        final Object o=new Object();
        String str="这是一个测试数据！";

        new Thread(()->{
            synchronized (o){
                for (int i=0;i<str.length();i++){
                    System.out.print(i+"\n");
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    o.notifyAll();
                }
            }
        },"t1").start();


        new Thread(()->{
            synchronized (o){
                for (int i=0;i<str.length();i++){
                    System.out.print(str.charAt(i)+"\n");
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notifyAll();
            }
        },"t2").start();

//        new Thread(()->{
//            for (int i=0;i<100;i++)
//                System.out.println("111111");
//        }).start();
    }
}
