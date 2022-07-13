package com.nttdata.bank.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig {

    public LettuceConnectionFactory redisConnectionFactory(){
        return  new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }
}
