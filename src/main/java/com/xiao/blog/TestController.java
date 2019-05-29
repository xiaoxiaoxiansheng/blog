package com.xiao.blog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
