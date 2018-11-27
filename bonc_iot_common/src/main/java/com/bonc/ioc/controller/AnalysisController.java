package com.bonc.ioc.controller;

import com.bonc.ioc.service.IDataManagerService;
import com.bonc.ioc.core.exception.McpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.ioc.controller
 * @Description:
 * @Author: dreamcc
 * @Date: 2018/11/13 16:39
 * @Version: V1.0
 */
@RestController
@RequestMapping("/analysis")
public class AnalysisController {

	private IDataManagerService dataManagerService;

	@Autowired
	public AnalysisController(IDataManagerService dataManagerService) {
		this.dataManagerService = dataManagerService;
	}

	@PostMapping("/dataChange")
	public String getDeviceDataChange(HttpServletRequest request) throws McpException {
		StringBuffer jb = new StringBuffer();
		String line;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {

		}
		dataManagerService.insertData(jb.toString());
		return jb.toString();
	}
}
