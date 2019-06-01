package com.xiao.blog.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 17:07
 * @Description:
 */
@Configuration
public class BeanLoad {

    /**
     * @Description: 设置redisTemplate key序列化
     * @auther: liuj
     * @date: 2019/6/1 11:51
     * @return:
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        //将key的序列化设置成StringRedisSerializer
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * @Description:springboot不会自动注册RestTemplate,需要自己注册bean
     * @auther: liuj
     * @date: 2019/6/1 11:54
     * @return:
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
    
    
}
