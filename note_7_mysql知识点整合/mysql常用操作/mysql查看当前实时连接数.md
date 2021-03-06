# mysql查看当前实时连接数

静态查看:

```sql
    SHOW PROCESSLIST;  
    SHOW FULL PROCESSLIST;  
    SHOW VARIABLES LIKE '%max_connections%';  
    SHOW STATUS LIKE '%Connection%';  
```

实时查看：

[![复制代码](../img/mysql查看当前实时连接数.assets/copycode.gif)](javascript:void(0);)

```sql
    mysql> show status like 'Threads%';  
    +-------------------+-------+  
    | Variable_name     | Value |  
    +-------------------+-------+  
    | Threads_cached    | 58    |  
    | Threads_connected | 57    |   --这个数值指的是打开的连接数  
    | Threads_created   | 3676  |  
    | Threads_running   | 4     |   --这个数值指的是激活的连接数，这个数值一般远低于connected数值  
    +-------------------+-------+  
       
    --Threads_connected 跟show processlist结果相同，表示当前连接数。准确的来说，Threads_running是代表当前并发数  
       
    --这是是查询数据库当前设置的最大连接数  
    mysql> show variables like '%max_connections%';  
    +-----------------+-------+  
    | Variable_name   | Value |  
    +-----------------+-------+  
    | max_connections | 100  |  
    +-----------------+-------+  
       
    --可以在/etc/my.cnf里面设置数据库的最大连接数  
    max_connections = 1000  
```