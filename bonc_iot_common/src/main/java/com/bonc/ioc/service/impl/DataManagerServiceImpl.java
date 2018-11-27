package com.bonc.ioc.service.impl;

import com.bonc.ioc.dao.DataManagerDao;
import com.bonc.ioc.service.IDataManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.ioc.service.impl
 * @Description:
 * @Author: dreamcc
 * @Date: 2018/11/22 13:42
 * @Version: V1.0
 */
@Service("dataManagerService")
public class DataManagerServiceImpl implements IDataManagerService {

	@Autowired
	private DataManagerDao dataManagerDao;

	@Override
	public int insertData(String data) {
		return dataManagerDao.insertData(data);
	}
}
