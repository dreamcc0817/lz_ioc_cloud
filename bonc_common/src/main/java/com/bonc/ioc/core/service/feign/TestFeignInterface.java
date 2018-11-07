package com.bonc.ioc.core.service.feign;

import com.bonc.ioc.core.service.feign.impl.TestFeignInterfaceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by wo on 2018-09-25.
 */
@FeignClient(name="mcp-auth",fallback = TestFeignInterfaceImpl.class)
public interface TestFeignInterface {

    @GetMapping("/findList")
    public List<Map<String,Object>> findList();

}
