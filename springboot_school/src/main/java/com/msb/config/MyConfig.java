package com.msb.config;

import com.msb.pojo.Car;
import com.msb.pojo.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
public class MyConfig {
    @Bean
    public User getUser(@Qualifier("car2") Car userCar) {
        User user = new User();
        user.setId(11);
        user.setUsername("testBean");
        user.setPassword("123456");
        user.setUsercar(userCar);
        return user;
    }
    @Bean("car1")
    public Car getCar() {
        Car userCar = new Car();
        userCar.setId(1);
        userCar.setBrand("doyota1");
        userCar.setModel("camry1");
        return userCar;
    }
    @Bean("car2")
    public Car getCar1() {
        Car userCar = new Car();
        userCar.setId(2);
        userCar.setBrand("doyota2");
        userCar.setModel("camry2");
        return userCar;
    }
}
