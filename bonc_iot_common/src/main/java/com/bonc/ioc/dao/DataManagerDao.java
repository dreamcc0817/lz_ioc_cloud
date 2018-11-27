package com.bonc.ioc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.ioc.dao
 * @Description:
 * @Author: dreamcc
 * @Date: 2018/11/22 13:13
 * @Version: V1.0
 */
@Mapper
public interface DataManagerDao {
	int insertData(@Param("data") String data);
}
