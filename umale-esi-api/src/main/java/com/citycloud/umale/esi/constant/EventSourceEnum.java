package com.citycloud.umale.esi.constant;

/**
 * @author zq
 * @date 2019/5/6
 */
public enum EventSourceEnum {


    XCFX("5","巡查发现"),
    SSHPT("3","省四化平台"),
    SZCG("2","数字城管"),
    JLSYL("1","96310"),
    SJJB("4","上级交办");
    private String code;
    private String msg;

    EventSourceEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public static String getMsgForCode(String code) {
        for (EventSourceEnum item : EventSourceEnum.values()) {
            if (item.code.equals(code)) {
                return item.getMsg();
            }
        }
        return "";
    }
}
