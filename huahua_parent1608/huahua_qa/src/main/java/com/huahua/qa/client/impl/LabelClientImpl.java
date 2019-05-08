package com.huahua.qa.client.impl;

import com.huahua.qa.client.LabelClient;
import huahua.common.Result;
import huahua.common.StatusCode;
import org.springframework.stereotype.Component;

@Component
public class LabelClientImpl implements LabelClient {

    @Override
    public Result findById(String id){
        return new Result(false, StatusCode.ERROR,"熔断器启动了");
    }
}
