package com.bonc.iot;

import com.bonc.IotApplication;
import com.bonc.ioc.service.IDataManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: lz_ioc_cloud
 * @Package: com.bonc.iot
 * @Description:
 * @Author: dreamcc
 * @Date: 2018/11/22 13:58
 * @Version: V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IotApplication.class)
public class LZIOTTest {

	@Autowired
	IDataManagerService dataManagerService;

	@Test
	public void test() {
		Map<String, Object> detail = new HashMap<>();
		detail.put("1", new String[] {"2"});
		detail.put("3", new String[] {"6","8"});

		int a = dataManagerService.insertData("test");
		System.out.println("a = " + a);
	}
}
