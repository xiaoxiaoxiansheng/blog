package com.xiao.blog.system.controller;

import com.xiao.blog.common.config.BlogConfig;
import com.xiao.blog.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: blog
 * @ClassName: LoginController
 * @Description:
 * @Date 2019/6/4/004 21:37
 * @Author: liujia
 * @Version: 1.0
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    private BlogConfig blogConfig;

    @GetMapping({"/",""})
    String welcome(Model model){
        System.out.println();
        return "redirect:/blog";
    }
    @GetMapping("/login")
    String login(Model model){
        model.addAttribute("username", blogConfig.getUsername());
        model.addAttribute("password", blogConfig.getPassword());
        return "login";
    }
}
