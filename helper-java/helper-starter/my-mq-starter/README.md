# MyMqStarter使用

- 下载，安装，引用该依赖

```xml
<parent>
    <artifactId>my-mq-starter</artifactId>
    <groupId>lsl.mint</groupId>
    <version>1.0</version>
</parent>
```
- 配置如下
```yaml
spring:
  rabbitmq:
    addresses: localhost
    port: 5672
    virtual-host: vhost
    username: guest
    password: guest
    ## 使用该依赖需配置，不配则不生效
    publisher-confirm-type: CORRELATED ## 此处开启确认模式
    publisher-returns: true ## 此处使callback返回自己的消息内容
```
  
