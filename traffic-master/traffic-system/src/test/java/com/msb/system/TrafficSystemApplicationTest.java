package com.msb.system;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan("com.msb.system")
class TrafficSystemApplicationTest {
  Logger logger = LoggerFactory.getLogger(TrafficSystemApplicationTest.class);

  @Test
  void contextLoads() {
      logger.error("test logger");
  }
}