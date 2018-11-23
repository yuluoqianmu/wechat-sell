package com.maolin.bootlink;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by shaomaolin on 2018/11/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
        logger.info("info...");
        logger.debug("log debugger...");
        logger.error("log error...");
    }

}
