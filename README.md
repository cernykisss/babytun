直接访问数据库吞吐量400
用声明式redis：@EnableCaching 和 @Cacheable 把商品存入redis 提高吞吐量 可以提高到2000
页面静态化：通过把页面静态化到本地服务器 用户通过nginx读取本地页面
使用@EnableScheduling 和@Scheduled 实现页面自动静态化 sql语句 select * from t_goods where last_update_time >= now() -interval 5 minute