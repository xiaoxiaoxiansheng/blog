package com.xiao.blog.system.controller;

import com.xiao.blog.common.annotation.Log;
import com.xiao.blog.common.config.BlogConfig;
import com.xiao.blog.common.controller.BaseController;
import com.xiao.blog.common.utils.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private BlogConfig blogConfig;

    /**
    * @Description : 博客首页
    * @Author      : liujia
    * @date        : 2019/6/7/007
    * @Param       : 
    * @return      : 
    */
    @GetMapping({"/",""})
    String welcome(Model model){
        System.out.println("blog.............");
        return "redirect:/blog";
    }
    /**
    * @Description : 登录跳转，添加默认的用户名，密码
    * @Author      : liujia
    * @date        : 2019/6/7/007
    * @Param       : 
    * @return      : 
    */
    @GetMapping("/login")
    String login(Model model){
        model.addAttribute("username", blogConfig.getUsername());
        model.addAttribute("password", blogConfig.getPassword());
        return "login";
    }
    /**
    * @Description : 登录
    * @Author      : liujia
    * @date        : 2019/6/7/007
    * @Param       : 
    * @return      : 
    */
    @Log("登录")
    @PostMapping("login")
    @ResponseBody
    AjaxJson login(String username, String password, String verify, HttpServletRequest request){
        AjaxJson ajaxJson = new AjaxJson();

        try{
            String verifyCode = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
            if(StringUtils.isBlank(verify)){
                return AjaxJson.error("请输入验证码");
            }
            if(!verifyCode.equals(verify)){
                return AjaxJson.error("请输入正确的验证码");
            }
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return AjaxJson.error("验证码校验失败");
        }

        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            return AjaxJson.ok();
        }catch (AuthenticationException e){
            return AjaxJson.error("用户名或密码错误");
        }
    }

    /**
    * @Description : 登录主页
    * @Author      : liujia
    * @date        : 2019/6/7/007
    * @Param       : 
    * @return      : 
    */
    @GetMapping("index")
    String index(Model model){
        return "index";
    }

    /**
    * @Description : 获取验证码
    * @Author      : liujia
    * @date        : 2019/6/7/007
    * @Param       : 
    * @return      : 
    */
    @GetMapping("getVerify")
    void getVerify(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("image/jpeg");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCodeUtil = new RandomValidateCodeUtil();
            randomValidateCodeUtil.getRandcode(request, response);
        }catch (Exception e){
            logger.info("获取验证码失败！");
        }
    }

    /**
    * @Description : 登出,重定位到login页面
    * @Author      : liujia
    * @date        : 2019/6/8/008
    * @Param       : 
    * @return      : 
    */
    @GetMapping("loginOut")
    String loginOut(){
        try{
            ShiroUtils.logout();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/login";
    }

    @GetMapping("main")
    String main(){
        return "/main";
    }


}
