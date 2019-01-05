package cn.com.bgy.ifc.bgy.task;

import cn.com.bgy.ifc.domain.interfaces.repair.RepairOrderDomain;
import cn.com.bgy.ifc.entity.po.repair.RepairOrder;
import cn.com.bgy.ifc.service.interfaces.inner.repair.RepairOrderService;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MQComsumer {

    @Autowired
    private RepairOrderService repairOrderService;


    @JmsListener(destination = "test")
    public void getQueue(String info){
        System.out.println("接收到mq消息："+info);
        //开始业务处理
        Integer extendId=1;
        RepairOrder repairOrder=repairOrderService.queryRepairOrderByExtendId(extendId);
        repairOrderService.updateRepairOrder(repairOrder);

    }
    /*    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

        private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;

        private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        ThreadLocal<MessageConsumer> threadLocal=new ThreadLocal<>();
        AtomicInteger atomicInteger=new AtomicInteger();
        public void init(){
            try{
               connectionFactory=new ActiveMQConnectionFactory();
               connection=connectionFactory.createConnection();
               connection.start();
            }catch (JMSException e){
                e.printStackTrace();
            }

        }

        public void geMessage(String disname){
            try {
                Queue queue = session.createQueue(disname);
                MessageConsumer consumer=null;
                if(threadLocal.get() !=null){
                 consumer=threadLocal.get();
                }else{
                    consumer=session.createConsumer(queue);
                    threadLocal.set(consumer);
                }
                while (true){
                       Thread.sleep(1000);
                       TextMessage message=(TextMessage)consumer.receive(50000);
                       if(message !=null){
                          message.acknowledge();
                           System.out.println(message.getText());
                       }else{
                           break;
                       }
                }
            }catch (JMSException e){
                e.printStackTrace();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }*/




}
