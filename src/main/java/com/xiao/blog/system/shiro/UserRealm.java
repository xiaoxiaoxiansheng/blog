package com.xiao.blog.system.shiro;

import com.xiao.blog.common.config.ApplicationContextRegister;
import com.xiao.blog.system.dao.UserDao;
import com.xiao.blog.system.domain.UserDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: blog
 * @ClassName: UserRealm
 * @Description:
 * @Date 2019/6/5/005 22:41
 * @Author: liujia
 * @Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       String username = (String) authenticationToken.getPrincipal();
        Map<String, Object> map = new HashMap<>(16);
        map.put("username", username);
        String password = new String((char[]) authenticationToken.getCredentials());

        UserDao userDao = ApplicationContextRegister.getBean(UserDao.class);
        UserDO user = userDao.selectByUsername(username);
        if (user == null){
            throw new UnknownAccountException("账号或密码不正确");
        }

        if (!password.equals(user.getPassword())){
            throw new IncorrectCredentialsException("账号或密码错误");
        }

        if(user.getStatus() == 0){
            throw new LockedAccountException("账号已经被锁定");
        }

        SimpleAuthenticationInfo  simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password, getName());
        return simpleAuthenticationInfo;
    }
}
