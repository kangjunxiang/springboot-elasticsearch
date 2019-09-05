package com.sxw.elasticsearch;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 根据官方文档测试常用的api
 * 文档地址:https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(ElasticsearchApplicationTests.class);
}
