package com.bonc.ioc.core.service;/**
 * Created by wo on 2018-09-25.
 */

import com.bonc.ioc.core.base.model.TestModel;
import com.bonc.ioc.core.base.service.BaseService;
import com.bonc.ioc.core.dao.TestMapper;
import com.bonc.ioc.core.exception.McpException;
import com.bonc.ioc.core.page.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * TestService模块
 *
 * @version 1.0
 * @Author chenxiaoyang
 * @Date 2018-09-25 10:29
 */

@Service
@Transactional
public class TestService extends BaseService {
    @Resource
    private TestMapper testMapper;

    public PageResult selectByPage() throws McpException {
        HashMap<String, Object> map = getParamMap();
        List<TestModel> list = testMapper.selectByPage(map);
        return new PageResult(map, list);
    }
 }
