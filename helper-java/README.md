# helper
小助手系统
## 准备工作
- idea、mysql8.0.11、springboot2.1.5、MyBatisPlus3.1.1、druid1.1.16、swagger2.9.2

## 日志记录
- 20191128 邮件发送功能
- 20191209 用户注册、登录功能、 \
  新增swagger-bootstrap-ui功能，访问 http://localhost:9000/doc.html \
  个性化参数中，去启用SwaggerBootstrapUi提供的增强功能\
  可与原来swagger-ui共存，访问 http://localhost:9000/swagger-ui.html \
  两者可以共存，swagger-ui不支持排序，swagger-bootstrap-ui支持排序
- 20200117 策略模式、工厂模式实现邮件、手机号发送验证码，（支持扩展）
- 20200122 定时任务功能
- 20200709 增加布隆过滤器示例、增加Redis分布式锁示例
- 20200711 lua脚本实现redis（Jedis）分布式id，lua脚本在配置中，\
  每次重启服务上传一次（防止lua脚本被改动还需要改代码,只针对单机redis \
  对于集群的话生产分布式id，每台机器需要单独处理）。
- 20200716 增加本地redis配置
- 20200818 雪花算法、公用包提取
- 20201029 设计模式学习

  
