package com.xiao.blog.common.utils;

import org.aspectj.weaver.loadtime.Aj;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: liuj
 * @Date: 2019/6/5 17:08
 * @Description:
 */
public class AjaxJson extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public AjaxJson(){
        put("code", 0);
        put("msg", "操作成功");
    }

    public static AjaxJson error(){
        return error(1, "操作失败");
    }

    public static AjaxJson error(String msg){
        return error(500, msg);
    }

    public static AjaxJson error(int code, String msg){
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.put("code", code);
        ajaxJson.put("msg", msg);

        return ajaxJson;
    }

    public static AjaxJson ok(){
        return new AjaxJson();
    }

    public static AjaxJson ok(String msg){
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.put("msg", msg);

        return ajaxJson;
    }

    public static AjaxJson ok(Map<String, Object> map){
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.putAll(map);

        return ajaxJson;
    }

    public AjaxJson put(String key, Object value){
        super.put(key, value);
        return this;
    }
}
