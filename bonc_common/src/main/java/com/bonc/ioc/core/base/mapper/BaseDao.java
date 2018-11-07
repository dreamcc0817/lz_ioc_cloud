package com.bonc.ioc.core.base.mapper;

import com.bonc.ioc.core.exception.McpException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;


public interface BaseDao<T> {

	/**
	 * 根据主键id获取T信息
	 * @param id 主键id
	 * @return T实体对象
	 * @throws Exception 数据库访问异常
	 */
	public T findById(@RequestParam("id") String id) throws McpException;


	/**
	 * 查询T列表
	 * @param paramMap
	 * @return T列表
	 * @throws Exception 数据库访问异常
	 */
	public List<T> selectByPage(HashMap<String, Object> paramMap) throws McpException;

	/**
	 * 保存T信息
	 * @param obj T对象
	 * @return
	 * @throws Exception 数据库访问异常
	 */
	public int save(T obj) throws McpException;

	/**
	 * 修改T信息
	 * @param obj T对象
	 * @return
	 * @throws Exception 数据库访问异常
	 */
	public int update(T obj) throws McpException;


	/**
	 * 删除T信息
	 * @param id 主键
	 * @return
	 * @throws Exception 数据库访问异常
	 */
	public int delete(@RequestParam("id") String id) throws McpException;

}
