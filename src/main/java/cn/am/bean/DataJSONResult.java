package cn.am.bean;

public class DataJSONResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;


    private String ok;    // 不使用

    public static DataJSONResult build(Integer status, String msg, Object data) {
        return new DataJSONResult(status, msg, data);
    }

    public static DataJSONResult ok(Object data) {
        return new DataJSONResult(data);
    }

    public static DataJSONResult ok() {
        return new DataJSONResult(null);
    }

    public static DataJSONResult errorMsg(String msg) {
        return new DataJSONResult(500, msg, null);
    }

    public static DataJSONResult errorMap(Object data) {
        return new DataJSONResult(501, "error", data);
    }

    public static DataJSONResult errorTokenMsg(String msg) {
        return new DataJSONResult(502, msg, null);
    }

    public static DataJSONResult errorException(String msg) {
        return new DataJSONResult(555, msg, null);
    }

    public DataJSONResult() {

    }

    public DataJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public DataJSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}
