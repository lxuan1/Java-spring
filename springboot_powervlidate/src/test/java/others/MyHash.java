package others;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/19 18:06
 * @Version 1.0.0
 * @Description
 **/
public class MyHash {

//    public static void main(String[] args) {
//        int a[]=new int[]{1,6,7,5,4,8,3,8};
//        sored(a);
//        for (int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
//    }

    public static void sored(int a[]){
        if (a.length==0)
            return;
        int len=a.length;
         for (int i=0;i<len;i++){
             for (int j=i+1;j<len;j++){
                 //System.out.println(j);
                 int temp=a[j];
                 if (temp<a[i]){
                     a[j]=a[i];
                    a[i]=temp;

                 }
             }
         }
    }
}
