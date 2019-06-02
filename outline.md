#springboot大纲 了解

##SpringBoot redis
 1. 简单命令
        redis-cli   :   连接本地的redis-cli服务
        redis-cli -h host -p port -a password : 连接远程服务器上执行命令
        auth password ： 输入密码
        set key value   ： 设置缓存
        get key ：   获取缓存
        keys  pattern  ： 获取所有key
        ping    ：   检查服务器是否还在，在会返回一个pong  
##springboot缓存
    如果没有引入其他缓存，springboot默认的ConcurrenMapCacheManager作为缓存管理器
    key支持 spel表达式
##springboot RestTemplate
1.  介绍 
        RestTemplate是spring提供的用于访问Rest服务的客户端，提供了多种便捷访问远程Http服务的方法，
    能够大大提高客户端的编程效率。
##springboot Aop
1. 切面即应用
2. 注解切面、包下所有方法切面

