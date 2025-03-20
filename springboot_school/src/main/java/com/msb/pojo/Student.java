package com.msb.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "student 쓰티레이")
public class Student implements Serializable {
    @Schema(description = "유저 아이디 primary key")
    private int id;
    @Schema(description = "유저 이름")
    @NotBlank(message = "name of user is not null")
    private String name;
    @Schema(description = "유저 반급")
    private Clazz clazz;
    @Schema(description = "유저 취미")
    List<Hobby> hobby;
}
