package com.xiao.blog.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJcaListenerContainerFactory;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;


/**
 * @Auther: liuj
 * @Date: 2019/6/3 14:41
 * @Description:ActiveMQ
 * 说明：无法导入@EnableJms，ActiveMQQueue，查看maven的配置文件，修改导入源
 */
@Configuration
@EnableJms
public class ActiveMQConfig {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("xiao.queue");
    }

    //springboot默认只配置queue类型消息，如果要使用topic类型的消息，则需要配置该bean
    @Bean
    public JmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //这里必须设置为true，false则表示是queue类型
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("xiao.topic");
    }
}
