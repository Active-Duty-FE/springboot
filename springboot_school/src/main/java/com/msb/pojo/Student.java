package com.msb.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
@Data
public class Student implements Serializable {
    private int id;
    private String name;
    private Clazz clazz;
    private Hobby hobby;
}
