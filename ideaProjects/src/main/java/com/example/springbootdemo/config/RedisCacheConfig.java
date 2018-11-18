package com.example.springbootdemo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration//SpringBoot注解，启动时会注入
@EnableCaching //启用缓存
class RedisCacheConfig extends CachingConfigurerSupport {
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(factory);
        //key序列化方式，在定义了key生成策略之后再加以下代码
//    	RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//    	redisTemplate.setKeySerializer(redisSerializer);
//    	redisTemplate.setHashKeySerializer(redisSerializer);
        return redisTemplate;
    }
    /**
     * 缓存管理器
     * @param redisTemplate
     * @return
     */
/*    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate,RedisConnectionFactory connectionFactory) {

        RedisCacheManager rcm = new RedisCacheManager(connectionFactory,redisTemplate);
        return rcm;
    }*/

    /**
     * redis模板操作类
     * @param factory 由springboot注入
     * @return
     */

}
