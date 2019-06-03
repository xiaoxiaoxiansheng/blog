package com.xiao.blog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ProjectName: blog
 * @ClassName: MailApplicationTests
 * @Description:
 * @Date 2019/6/2/002 22:05
 * @Author: liujia
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Test
    public void testMail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("99402615@qq.com");
        mailMessage.setText("hello,hello,hello,hello,hello,hello,hello,hello,hello,灵图一霸。");
        mailMessage.getSentDate();
        mailMessage.setSubject("灵图某某人");
        mailMessage.setFrom(username);

        mailSender.send(mailMessage);

        System.out.println("已发送。。。。。。。。。。。。。。");
    }

}
