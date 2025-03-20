package com.msb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class SpringDocConfig {
    public OpenAPI restfulOpenAPI() {
        Info info = new Info().title("School 썅무").description("학교에 관한 썅뮤").version("1.0.0");
        return new OpenAPI().info(info);
    }
}
