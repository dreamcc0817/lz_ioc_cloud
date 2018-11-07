package com.bonc.ioc.core.service.feign.impl;/**
 * Created by wo on 2018-09-25.
 */

import com.bonc.ioc.core.service.feign.TestFeignInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TestFeignInterfaceImpl模块
 *
 * @version 1.0
 * @Author
 * @Date 2018-09-25 15:21
 */
@Component
public class TestFeignInterfaceImpl implements TestFeignInterface{

    @Override
    public List<Map<String, Object>> findList() {
        return new ArrayList<Map<String,Object>>();
    }
}
