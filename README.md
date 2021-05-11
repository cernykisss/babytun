直接访问数据库吞吐量400
用声明式redis：@EnableCaching 和 @Cacheable 把商品存入redis 提高吞吐量 可以提高到2000
页面静态化：通过把页面静态化到本地服务器 用户通过nginx读取本地页面
使用@EnableScheduling 和@Scheduled 实现页面自动静态化 sql语句 select * from t_goods where last_update_time >= now() -interval 5 minute
动静分离架构：浏览器-->nginx<-->tomcat<-->mysql
                    11
                    11 ajax
                    HTML
                    
redis 特点：单线程模型 内存存储高达10w qps 天生分布式支持
具体实现：把秒杀商品预先加载进redis 使用list key："seckill:count:" + 秒杀id value为10个秒杀商品id
        秒杀时先预减商品 如果成功再往userSet里存 "seckill:user" + 秒杀id set里的值为userid 
rabbitmq 实现异步下单：exchange-order queue-order 配置文件中设置prefetch对流量进行削峰：定义消费者最多处理多少个消息。OrderConsumer异步创建订单，插入数据库
    点击抢购按钮后， 前台传到controller用户id，service层判断是否还有库存且用户set中isExisted， 如果没有则创建订单，生成订单编号，前台不断刷新订单状态，如果有则返回订单页面， 如果没有则停留再waiting页面 等待后台创建订单
    
nginx六种负载均衡策略：1.default:轮询策略 2.weighted 权重策略 3.least connected 最少连接策略
4. fair 按响应时间 5. IP Hash 6. url Hash
nginx 心跳检查机制 max_fails = 3; fail_timeout = 30s
开放8001~8004四个port 然后在nginx.config 中设置upstream和server （nginx通过80端口提供服务） 