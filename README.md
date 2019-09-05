# springboot-elasticsearch

> 基于SpringBoot整合ElasticSearch,使用Spring Data Elasticsearch实现对ES的基础操作

## 运行测试类：[ElasticsearchApplicationTests](https://github.com/suxiongwei/springboot-elasticsearch/blob/master/src/test/java/com/sxw/elasticsearch/ElasticsearchApplicationTests.java)

测试类记录了常用的操作API

## 官网文档地址：[Spring Data Elasticsearch](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/)


使用 SpringBoot2.0 + ElasticSearch + Jest 实现的电影搜索网站

本地部署
启动 ElasticSearch 6.X+
修改 application.properties 中的 spring.elasticsearch.jest.uris 参数
启动 SpringBoot 项目
访问 localhost:8080/crawl 开启爬虫
访问 localhost:8080 开始搜索


在学习 ElasticSearch 的过程中，发现 ElasticSearch 的 Java 客户端选择太多，使用两种不同的通讯协议，而且 2.X 和 5.X+ 版本差异较大。
这种现象对于选择困难症患者来说不是非常友好，本来 spring-data-elasticsearch 应该是首要选择，但是我发现 SpringBoot 官方文档中首先推荐使用的是 Jest， 其次才是自家的 spring-data-elasticsearch。
深入使用后发现，spring-data-elasticsearch 基于 TransportClient，这个客户端使用 Java 序列化机制(9300 端口)通讯，ElasticSearch 官方准备废弃该客户端。
应该使用 REST 客户端(9200 端口)代替。这就让 Jest 成了该项目的首选。


