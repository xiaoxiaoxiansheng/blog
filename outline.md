#springboot大纲 了解
##springboot 配置
1. 在application.yml设置属性值，
	在实体类中@Value("bean,name")取值
	在实体类直接注解@ConfigurationProperties(prefix = "bean")赋值属性
2. 在实体类上配置文件@PropertySource("classpath:test.properties")
3. 使用Environment获取属性配置
4. 外部配置， java -jar xxx.jar --server.port=8088
5. 加载其他配置文件
6. 多环境配置
##springboot 加载bean
1. springboot无xml配置，会自动扫描启动类所在包以及子包中所有的带有@Controller、@Service、@Repository，@component注解的类
2. 如果包不在这个范围内，则配置启动类，添加配置文件
##springboot 日志级别
1. 默认使用Logback作为日志，日志配置惠济路INFO级别以上的消息输出到控制台
2. 日志的具体内容：
	日期和时间
	日志级别：ERROR,WARN,INFO,DEBUG,TRACE
	进程ID
	---
	线程名称，方括号括起来
	记录器名称
	日志消息
3. 配置日志文件
	logging.file
	logging.path
4. 标准名称：log-config.xml加载
##springboot mysql
1. 引入依赖
2. 配置文件application.yml
3. JdbcTemplate接口调用SQL方法
##springboot mybatis
1. 引入依赖
2. 配置 application.yml添加
3. 实体类
4. Mapper映射（dao）
5. Mapper文件 ，对于目录下实体类的映射文件
6. 启动类加上MapperScan("")注解
7. 调用查询
##springboot 事务控制
1. Mapper类（dao），
	添加注解@update("SQL:select * from ")
	Mapper映射xml文件，添加SQL
2. Service文件，添加注解@Transactional(rollbackFor = RuntimeException.class)
3. 启动类添加注解@EnableTrancactionManagement

##SpringBoot redis
 1. Redis安装 https://github.com/MSOpenTech/redis/releases
 2. 简单命令
        redis-cli   :   连接本地的redis-cli服务
        redis-cli -h host -p port -a password : 连接远程服务器上执行命令
        auth password ： 输入密码
        set key value   ： 设置缓存
        get key ：   获取缓存
        keys  pattern  ： 获取所有key
        ping    ：   检查服务器是否还在，在会返回一个pong  
 3. 开启服务
 4. 引入依赖
 5. 修改配置文件
 6. 测试Redis缓存
##springboot缓存
    如果没有引入其他缓存，springboot默认的ConcurrenMapCacheManager作为缓存管理器
    key支持 spel表达式
1. 引入缓存依赖
2. 设置缓存类型，比如redis
3. 启动类开启缓存@EnableCaching
4. service缓存应用
	@Cacheable(value="",key="")
	@CachePut(value="",key="")
	@CacheEvict(value="",key="")
5. 应用
##springboot RestTemplate
1.  介绍 
        RestTemplate是spring提供的用于访问Rest服务的客户端，提供了多种便捷访问远程Http服务的方法，
    能够大大提高客户端的编程效率。
2. 注册bean，springboot不会自动注册RestTemplate
3. 应用RestTemplate.getForObjOBect("", String.class)
##springboot Aop
1. 切面即应用
2. 注解切面、包下所有方法切面
3. 引入依赖
4. execution表达式
5. 切面类，对某类接口实现切面
5. 创建注解，新建注解的切面类
##springboot定时任务
1. 启动类开启@EnableScheduling
2. 创建定时任务类，注解@Scheduled（cron表达式或者时间）
## springboot邮件
1. 引入依赖 
2. 修改application.yml配置
    spring:
      mail:
        default-encoding: UTF-8
        host: smtp.163.com（ping smtp.163.com,获取IP地址）
        port: 465
        username: 用户名（邮箱）
        password: 密码 （开启smtp服务的授权码，在邮箱的设置中查看）
        properties:
          mail.smtp.ssl.enable: true
3. JavaMailSender
##
