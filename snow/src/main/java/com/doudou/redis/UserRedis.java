package com.doudou.redis;

import com.doudou.model.student.UserDto;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenjiaming on 2017/8/20.
 */
@Repository
public class UserRedis {

    @Resource(name = "template0")
    private RedisTemplate<String, Object> redisTemplate;

    public void setUser(String key, UserDto userDto) {
        redisTemplate.opsForValue().set(key, userDto, 30, TimeUnit.SECONDS);
    }

    public UserDto getUser(String key) {
        return (UserDto) redisTemplate.opsForValue().get(key);
    }

}