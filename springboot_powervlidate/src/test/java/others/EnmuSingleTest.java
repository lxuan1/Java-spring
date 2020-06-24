package others;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/22 14:12
 * @Version 1.0.0
 * @Description
 **/
public class EnmuSingleTest {

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(EnumSingle.INC.hashCode());
                //EnumSingle.INC.test();
            }).start();
        }
    }
}
