package com.msb.pojo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyConfigTest {
    @Autowired
    private User user;
    @Test
    void testUser() {
        System.out.println(user + "user");
    }
}
