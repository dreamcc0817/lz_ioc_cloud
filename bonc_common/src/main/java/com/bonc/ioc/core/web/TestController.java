package com.bonc.ioc.core.web;/**
 * Created by wo on 2018-09-25.
 */

import com.bonc.ioc.core.base.tips.AppReply;
import com.bonc.ioc.core.exception.McpException;
import com.bonc.ioc.core.page.PageResult;
import com.bonc.ioc.core.service.TestService;
import com.bonc.ioc.core.service.feign.TestFeignInterface;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * TestController模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-25 10:14
 */
@RestController
public class TestController {


    @Resource
    private TestService testService;

    @Resource
    private RedisTemplate  redisTemplate;
    @Resource
    private TestFeignInterface testFeignInterface;
    @RequestMapping("/testLog")
    public AppReply testLog() throws McpException{
        return AppReply.success();
    }
    @RequestMapping("/testPage")
    public AppReply testPage() throws McpException{
        //获取当前用户Id
//        String  tokenId=null;
//        redisTemplate.opsForValue().get(tokenId);
        PageResult pageResult=testService.selectByPage();
        return AppReply.success(pageResult);
    }

    @RequestMapping("/testRedis")
    public AppReply testRedis() throws McpException{
        redisTemplate.opsForValue().set("1",new HashMap<String,Object>());
        return AppReply.success(redisTemplate.opsForValue().get("1"));
    }

    @PutMapping
    @DeleteMapping
    @PostMapping("/{}")
    @GetMapping
     public AppReply testFeign() throws McpException{

        return AppReply.success(testFeignInterface.findList());
    }


}
