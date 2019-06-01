package com.xiao.blog.test;

import com.xiao.blog.system.domain.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: liuj
 * @Date: 2019/6/1 12:00
 * @Description:测试RestTemplate
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateApplicationTests {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGetRequest(){
        //2种方法获取
        //1、直接获取响应内容,url必须可以当时访问，即项目启动
        String object = restTemplate.getForObject("http://localhost:8080/getString?name=liujia", String.class);
        System.out.println(object);

        //2、获取响应内容
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/getString?name=liujia", String.class);
        System.out.println("状态码 ： "  + entity.getStatusCode());
        System.out.println("头信息 ： " + entity.getHeaders());
        System.out.println("Body : " + entity.getBody());
    }

    @Test
    public void testPostRequest(){
        UserDO userDO = new UserDO();
        userDO.setId(1001);
        userDO.setEmail("151@qq.com");
        userDO.setName("liu");

        String object = restTemplate.postForObject("http://localhost:8080/getUser?",userDO,String.class);
        System.out.println(object);
    }

    @Test
    public void testPostHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json;charset=utf-8");

        UserDO userDO = new UserDO();
        userDO.setId(1001);
        userDO.setEmail("151@qq.com");
        userDO.setName("liu");

        HttpEntity<UserDO> httpEntity = new HttpEntity<UserDO>(userDO,httpHeaders);

        String object = restTemplate.postForObject("http://localhost:8080/getUser?",httpEntity,String.class);
        System.out.println(object);
    }


}
