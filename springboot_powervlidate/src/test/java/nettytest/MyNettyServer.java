package nettytest;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/18 15:23
 * @Version 1.0.0
 * @Description
 **/
@Component
public class MyNettyServer {
    private final EventLoopGroup boosGroup=new NioEventLoopGroup();
    private final EventLoopGroup workGroup=new NioEventLoopGroup();
    static Thread t1,t2;
    public static void main(String[] args) throws Exception {

    }


}
