package com.doudou.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.doudou.controller")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("夜幕接口")// 大标题
				.description("夜幕接口文档")// 详细描述
				.termsOfServiceUrl("/swagger-ui.html").contact("墨明棋妙的兜兜")// 作者
				.version("1.0")// 版本
				.build();
	}

}
