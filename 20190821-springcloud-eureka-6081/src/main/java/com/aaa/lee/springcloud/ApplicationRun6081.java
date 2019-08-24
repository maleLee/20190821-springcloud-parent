package com.aaa.lee.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/8/22 10:32
 * @Description
 *      EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
 *      eureka的自我保护机制
 *          在eureka中注册过的服务会定时向eureka发送心跳
 *          当网络故障/服务宕机的时候会长时间不向eureka发送心跳(90秒)
 *          eureka如果在90秒之后还没有接受到服务的心跳，则会把该服务剔除掉
 *          当eureka的网络故障，大批量心跳接收不到(也就是说所有的服务的心跳都接收不到)
 *          90秒之后，网络依然没有恢复，新的服务依然可以向eureka注册，eureka并不会剔除之前的服务
 *          为什么eureka不会剔除之前的服务？
 *              自我保护机制(尝试去做一段时间的等待(90s)，会把所有的服务保留，目的就是当消费者调用的时候不至于出现故障)
 *              最终eureka15分钟之后依然检测不到服务的心跳，会全部把服务剔除
 *          在eureka出现网络故障的时候，消费者还能否获取到生产者的服务？
 *              可以的
 *
 *      当关闭了eureka的自我保护机制:
 *          THE SELF PRESERVATION MODE IS TURNED OFF. THIS MAY NOT PROTECT INSTANCE EXPIRY IN CASE OF NETWORK/OTHER PROBLEMS.
 *
 *      eureka的集群配置:
 *          1.修改hosts
 *              eureka.instance.hostname=localhost
 *              只有一个目的就是分区开三台eureka
 *            127.0.0.1     localhost
 *            127.0.0.1     eureka01 eureka02 eureka03
 *            127.0.0.1     eureka02
 *            127.0.0.1     eureka03
 *          2.实现eureka的properties配置
 *              hostname=eureka01-03
 *              userZone=其他节点的地址信息
 *          3.eureka集群配置完毕后，启动，但是发现没有找到其他集群线索
 *              3.1.系统的hosts
 *                  有些系统是不支持127.0.0.1 eureka01 eureka02 eureka03
 *              3.2.注册自己和发现自己的问题
 *                  一定需要向集群中注册自己和发现自己
 *          4.需要分别在consumer和provider中进行配置
 *              service-url.defaultZone=分别配置eureka集群的信息，使用","隔开
 *
 *      @EnableEurekaServer:开启eureka的服务器端
 **/
@SpringBootApplication
@EnableEurekaServer
public class ApplicationRun6081 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun6081.class, args);
    }

}
