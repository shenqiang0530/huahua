package huahua.common;

import lombok.Data;

@Data
public class Result {

    private boolean flag;//是否成功

    private Integer code;//状态码

    private String message;//请求信息

    private Object data;//请求的数据/相应的数据

    public Result() {
    }

    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
