package com.huahua.qa.client;

import com.huahua.qa.client.impl.LabelClientImpl;
import huahua.common.Result;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "huahua_base",fallback = LabelClientImpl.class)
public interface LabelClient {
    Result findById(String id);
}
