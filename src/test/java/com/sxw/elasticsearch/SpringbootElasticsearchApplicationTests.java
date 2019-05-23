package com.sxw.elasticsearch;

import com.sxw.elasticsearch.model.Item;
import com.sxw.elasticsearch.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootElasticsearchApplicationTests.class);
    @Autowired private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired private ItemRepository itemRepository;

    /**
     * @Description:创建索引，会根据Item类的@Document注解信息来创建
     */
    @Test
    public void testCreateIndex() {
        elasticsearchTemplate.createIndex(Item.class);
    }

    /**
     * 索引数据
     */
    @Test
    public void indexItem(){
        Item item = new Item();
        item.setId(1L);
        item.setTitle("MacBook Pro");
        item.setCategory("笔记本电脑");
        item.setBrand("苹果");
        item.setPrice(12999.0);
        item.setImages("https://www.apple.com/mac.png");

        Item item1 = new Item();
        item1.setId(2L);
        item1.setTitle("重构 改善既有代码的设计");
        item1.setCategory("程序设计");
        item1.setBrand("马丁·福勒(Martin Fowler)");
        item1.setPrice(118.00);
        item1.setImages("http://product.dangdang.com/26913154.html");

        Item item2 = new Item();
        item2.setId(3L);
        item2.setTitle("Python编程 从入门到实践");
        item2.setCategory("Python");
        item2.setBrand("埃里克·马瑟斯（Eric Matthes）");
        item2.setPrice(61.40);
        item2.setImages("http://bang.dangdang.com/books/bestsellers/01.54.00.00.00.00-recent7-0-0-1-1");

        Item item3 = new Item();
        item3.setId(4L);
        item3.setTitle("统计之美：人工智能时代的科学思维");
        item3.setCategory("数学");
        item3.setBrand("李舰");
        item3.setPrice(56.70);
        item3.setImages("http://product.dangdang.com/26915070.html");

        Item item4 = new Item();
        item4.setId(5L);
        item4.setTitle("机器学习");
        item4.setCategory("人工智能");
        item4.setBrand("周志华");
        item4.setPrice(61.60);
        item4.setImages("http://product.dangdang.com/23898620.html");


        itemRepository.index(item1);
        itemRepository.index(item2);
        itemRepository.index(item3);
        itemRepository.index(item4);
    }

    /**
     * 搜索
     */
    @Test
    public void testSearch(){
        List<Item> itemList = itemRepository.findByTitleLike("Mac");
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }

    /**
     * 返回实体数量
     */
    @Test
    public void testCount(){
        long count = itemRepository.count();
        System.out.println(count);
    }

    /**
     * 查找全部
     */
    @Test
    public void testFindAll(){
        Iterable<Item> items = itemRepository.findAll();
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()){
            logger.info(iterator.next().toString());
        }
    }

    /**
     * 返回由给定ID标识的实体
     */
    @Test
    public void testFindById(){
        Optional<Item> item = itemRepository.findById(1L);
        logger.info(item.get().toString());
    }

    /**
     * 指示是否存在具有给定ID的实体
     */
    @Test
    public void testExistsById(){
        logger.info(itemRepository.existsById(2L) + "");
    }


    /**
     * 测试分页
     */
    @Test
    public void testPage(){
        Page<Item> page = itemRepository.findAll(PageRequest.of(1, 3));
        // 总条数
        logger.info(page.getTotalElements() + "");

        Iterator<Item> iterator = page.iterator();
        while (iterator.hasNext()){
            logger.info(iterator.next().toString());
        }

        // 总页数
        logger.info(page.getTotalPages() + "");
    }

    @Test
    public void test4(){
        logger.info("");
    }

    @Test
    public void test5(){
        logger.info("");
    }

    @Test
    public void test6(){
        logger.info("");
    }

    @Test
    public void test7(){
        logger.info("");
    }

    @Test
    public void test8(){
        logger.info("");
    }
}
