package com.xiao.blog;

import com.xiao.blog.config.Print;
import com.xiao.blog.system.domain.UserDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: blog
 * @ClassName: TestController
 * @Description:
 * @Date 2019/5/27/027 21:57
 * @Author: liujia
 * @Version: 1.0
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello,xiao";
    }

    @GetMapping("getString")
    public String getString(String name){
        return "Hello, " + name;
    }

    @PostMapping("getUser")
    public String getUser(@RequestBody UserDO userDO){
        return userDO.toString();
    }

    @Print(value = "testprint")
    @GetMapping("print")
    public String print(String str){
        return str;
    }

    @GetMapping("testSetSession")
    public String testSetSession(String name, HttpServletRequest request){
        System.out.println("............" + name);
        request.getSession().setAttribute("name", name);

        return "true";
    }

    @GetMapping("testgetSession")
    public String testgetSession(HttpServletRequest request){
        System.out.println("name : " + request.getSession().getAttribute("name"));

        return "true";
    }
}
