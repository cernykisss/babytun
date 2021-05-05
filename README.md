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