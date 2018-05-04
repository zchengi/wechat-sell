package com.cheng;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cheng
 *         2018/5/4 11:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
// @Data
public class LoggerTest {

    // private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {

        String name = "cheng";
        String password = "zzz123";

        log.debug("debug...");
        log.info("name: " + name + ", password: " + password);
        log.info("name: {}, password: {}", name, password);
        log.error("error...");
        log.warn("warn...");
    }
}
