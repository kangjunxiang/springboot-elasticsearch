## 基于SpringBoot整合ElasticSearch

### 1 [master分支](https://github.com/suxiongwei/springboot-elasticsearch)：使用Spring Data Elasticsearch实现对ES的基础操作

- 运行测试类：[ElasticsearchApplicationTests](https://github.com/suxiongwei/springboot-elasticsearch/blob/master/src/test/java/com/sxw/elasticsearch/ElasticsearchApplicationTests.java)

> 测试类记录了常用的操作API

- 官网文档地址：[Spring Data Elasticsearch](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/)

### 2 [elasticsearch-jest分支](https://github.com/suxiongwei/springboot-elasticsearch/tree/elasticsearch-jest): 使用 Jest 客户端实现的电影搜索网站

#### 2.1 电影数据的获取

爬取了豆瓣的不同类型的电影作为搜索的基础数据，数据在项目的文件夹下可以找到，大家学习的时候就不用再去爬取了，爬虫需谨慎。电影数据路径：https://github.com/suxiongwei/springboot-elasticsearch/tree/elasticsearch-jest/src/main/resources/data

#### 2.2 启动项目

1. 启动 ElasticSearch 6.X+
2. 修改 application.yml 中的 spring.elasticsearch.jest.uris 参数
3. 启动 SpringBoot 项目
4. 运行测试类[DouBanMovieTest](https://github.com/suxiongwei/springboot-elasticsearch/blob/elasticsearch-jest/src/test/java/com/sxw/elasticsearch/crawler/DouBanMovieTest.java)的savaMovieToES方法初始化数据到es中
5. 访问 localhost:8080 开始搜索

#### 2.3 演示效果

- 通过elasticsearch-head查看导入的数据

  ![电影基础数据](https://github.com/suxiongwei/springboot-elasticsearch/blob/elasticsearch-jest/src/main/resources/static/img/es_data.jpg)

- 搜索页面

  ![搜索页面](https://github.com/suxiongwei/springboot-elasticsearch/blob/elasticsearch-jest/src/main/resources/static/img/search.jpg)


### 其它
- 查看ik分词效果：
```
curl -H 'Content-Type:application/json' 'http://localhost:9200/douban_movie/_analyze?pretty=true' -d '
{
  "text":"中华人民共和国",
  "analyzer" : "ik_max_word"
 }'
```
返回结果
```json
{
  "tokens" : [
    {
      "token" : "中华人民共和国",
      "start_offset" : 0,
      "end_offset" : 7,
      "type" : "CN_WORD",
      "position" : 0
    },
    {
      "token" : "中华人民",
      "start_offset" : 0,
      "end_offset" : 4,
      "type" : "CN_WORD",
      "position" : 1
    },
    {
      "token" : "中华",
      "start_offset" : 0,
      "end_offset" : 2,
      "type" : "CN_WORD",
      "position" : 2
    },
    {
      "token" : "华人",
      "start_offset" : 1,
      "end_offset" : 3,
      "type" : "CN_WORD",
      "position" : 3
    },
    {
      "token" : "人民共和国",
      "start_offset" : 2,
      "end_offset" : 7,
      "type" : "CN_WORD",
      "position" : 4
    },
    {
      "token" : "人民",
      "start_offset" : 2,
      "end_offset" : 4,
      "type" : "CN_WORD",
      "position" : 5
    },
    {
      "token" : "共和国",
      "start_offset" : 4,
      "end_offset" : 7,
      "type" : "CN_WORD",
      "position" : 6
    },
    {
      "token" : "共和",
      "start_offset" : 4,
      "end_offset" : 6,
      "type" : "CN_WORD",
      "position" : 7
    },
    {
      "token" : "国",
      "start_offset" : 6,
      "end_offset" : 7,
      "type" : "CN_CHAR",
      "position" : 8
    }
  ]
}
```

- 查看pinyin分词效果：
```
curl -H 'Content-Type:application/json' 'http://localhost:9200/douban_movie/_analyze?pretty=true' -d '
{
  "text":"中华人民共和国",
  "analyzer" : "pinyin"
 }'
```
返回结果
```json
{
  "tokens" : [
    {
      "token" : "zhong",
      "start_offset" : 0,
      "end_offset" : 0,
      "type" : "word",
      "position" : 0
    },
    {
      "token" : "zhrmghg",
      "start_offset" : 0,
      "end_offset" : 0,
      "type" : "word",
      "position" : 0
    },
    {
      "token" : "hua",
      "start_offset" : 0,
      "end_offset" : 0,
      "type" : "word",
      "position" : 1
    },
    {
      "token" : "ren",
      "start_offset" : 0,
      "end_offset" : 0,
      "type" : "word",
      "position" : 2
    },
    {
      "token" : "min",
      "start_offset" : 0,
      "end_offset" : 0,
      "type" : "word",
      "position" : 3
    },
    {
      "token" : "gong",
      "start_offset" : 0,
      "end_offset" : 0,
      "type" : "word",
      "position" : 4
    },
    {
      "token" : "he",
      "start_offset" : 0,
      "end_offset" : 0,
      "type" : "word",
      "position" : 5
    },
    {
      "token" : "guo",
      "start_offset" : 0,
      "end_offset" : 0,
      "type" : "word",
      "position" : 6
    }
  ]
}
```