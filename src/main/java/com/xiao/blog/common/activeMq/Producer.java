package com.xiao.blog.common.activeMq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Auther: liuj
 * @Date: 2019/6/3 16:19
 * @Description:生产者
 */
@RestController
public class Producer {
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //发送queue类型消息
    @GetMapping("/queue")
    public void sendQueueMsg(String msg){
        jmsMessagingTemplate.convertAndSend(queue, msg);
    }

    //发送topic类型消息
    @GetMapping("/topic")
    public void sendTopicMsg(String msg){
        jmsMessagingTemplate.convertAndSend(topic, msg);
    }
}
