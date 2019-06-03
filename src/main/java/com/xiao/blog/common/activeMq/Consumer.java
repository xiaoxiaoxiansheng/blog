package com.xiao.blog.common.activeMq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: liuj
 * @Date: 2019/6/3 16:12
 * @Description:消费者
 */
@Component
public class Consumer {
    //接受queue类型的消息
    //destination对应配置类中ActiveMQQueue("springboot.queue")设置的名字
    @JmsListener(destination = "xiao.queue")
    public void ListenQueue(String msg){
        System.out.println("queue消息：" + msg);
    }

    //接收topic类型消息
    //destination对应配置类中ActiveMQTopic("springboot.topic")设置的名字
    //containerFactory对应配置类中注册JmsListenerContainerFactory的bean名称
    @JmsListener(destination = "xiao.topic", containerFactory = "jmsListenerContainerFactory")
    public void ListenTopic(String msg){
        System.out.println("topic消息：" + msg);
    }
}
