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