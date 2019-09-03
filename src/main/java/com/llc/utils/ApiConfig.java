package com.llc.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class ApiConfig {

    @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any()).build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("大师兄集成Swagger的接口测试")
                .description("问道有先后，术业有专攻")
                .termsOfServiceUrl("http://blog.csdn.net/qq_27093465?viewmode=contents")
                .contact(new Contact("刘隆昌","https://blog.csdn.net/u013560319","1040719208@qq.com"))
                .license("")
                .licenseUrl("")
                .version("1.0.0")
                .build();
    }




}
