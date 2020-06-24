package others;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.util.*;


/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/22 9:17
 * @Version 1.0.0
 * @Description
 **/
public class LayoutTest {
    private static volatile   Object o=new Object();
    public static void main(String[] args) {
        String s = ClassLayout.parseClass(Object.class).toPrintable(o);
        System.out.println(s);
        //System.gc();
        synchronized (o){
            System.out.println("--------------------------");
            s=ClassLayout.parseClass(Object.class).toPrintable(o);
            System.out.println(s);
        }
    }
}
