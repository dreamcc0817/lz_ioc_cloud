package com.bonc.ioc.core.dao;/**
 * Created by wo on 2018-09-25.
 */

import com.bonc.ioc.core.base.mapper.BaseDao;
import com.bonc.ioc.core.base.model.TestModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * TestMapper模块
 *
 * @version 1.0
 * @Author
 * @Date 2018-09-25 10:37
 */
@Mapper
public interface TestMapper  extends BaseDao<TestModel> {


}
