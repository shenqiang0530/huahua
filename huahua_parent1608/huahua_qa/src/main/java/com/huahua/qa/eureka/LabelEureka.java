package com.huahua.qa.eureka;

import huahua.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("huahua-base")
public interface LabelEureka {

    @RequestMapping(method = RequestMethod.GET,value = "/label/{labelId}")
    public Result queryById(@PathVariable("labelId") String labelId);
}
