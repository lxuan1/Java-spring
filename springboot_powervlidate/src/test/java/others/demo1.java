package others;


import com.sun.el.stream.StreamELResolver;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/11 16:05
 * @Version 1.0.0
 * @Description
 **/
public class demo1 {

    java.util.concurrent.atomic.AtomicInteger atomicInteger=new AtomicInteger(0);

    @Test
    public void sub() {

        //直接放在常量池中
        String str = "123";
        String str2 = "123";
        System.out.println(System.identityHashCode(str));
        System.out.println(System.identityHashCode(str2));
        //放在压缩堆中
        System.out.println("-------new 测试-----");
        String str3 = new String("123").intern();
        String str4 = new String("123");
        System.out.println(System.identityHashCode(str3));
        System.out.println(System.identityHashCode(str4));

        for (int i=0;i<10;i++){
            atomicInteger.addAndGet(1);
            System.out.println(1);

        }

    }


    @Test
    public void testMap() {
        HashMap<String, Object> stringObjectMap = new HashMap<>();

        stringObjectMap.put("1", "这是测试");

        Object creationTime = stringObjectMap.get("creationTime");
        System.out.println(creationTime);
       // Stream.of(System.getProperties().values().toArray()).forEach(x->System.err::println);
    }


    @Test
    public void testZuiShao(){
        List<int[]> list=new ArrayList<>();
        int[] a=new int[]{1,2,4,5,6};
        int[] b=new int[]{1};
        int[] c=new int[]{1,2,5,6};
        int[] d=new int[]{6,7,8};
        int[] e=new int[]{1,5,8};
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        List<int[]> collect = list.stream().sorted((x,y)->{
            return y.length-x.length;
        }).collect(Collectors.toList());


    }




}
