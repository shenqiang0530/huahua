package com.huahua.sms.send;

import com.huahua.sms.utils.HttpUtils;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class SmsSendCode {
    public static void sendCode(String appCode, String mobile, String tplid, String code) {
        String host = "http://yzx.market.alicloudapi.com";
        String path = "/yzx/sendSms";
        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + "0608b45d53a7411383bddfbabaa51c96");
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "18500348106");
        querys.put("param", "code:"+code);
        querys.put("tpl_id", "TP1710262");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
