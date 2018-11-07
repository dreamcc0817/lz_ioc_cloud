package com.bonc.ioc.core.test;/**
 * Created by wo on 2018-09-26.
 */

import com.bonc.ioc.core.base.model.TestModel;
import com.bonc.ioc.core.dao.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JUnitTest模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-26 14:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JUnitTest {


    @Autowired
    private TestMapper testMapper;
    @Test
    public void testSimpleMail() throws Exception{
         HashMap<String, Object> paramMap=new HashMap<>();
        paramMap.put("pageSize",10);
        paramMap.put("pageNumber",1);
        List<TestModel> list=testMapper.selectByPage(paramMap);
       // System.out.println("list = " + list);

    }
}
