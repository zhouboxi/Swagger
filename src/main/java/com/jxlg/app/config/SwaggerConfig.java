package com.jxlg.app.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration//这是springboot的配置文件注解
@EnableSwagger//这是swagger注解
@EnableWebMvc//这是mvc注解
//这是指定配置文件的作用范围
@ComponentScan(basePackages = {"com.jxlg.app"})
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    //导入对应的config
    @Resource
    private SpringSwaggerConfig springSwaggerConfig;

    @Bean//相当于给方法注册一个bean id为方法名也可自定义
    public SwaggerSpringMvcPlugin customImplementation(){

        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiInfo(apiInfo())
                .includePatterns(".*")
                .swaggerGroup("XmPlatform")
                .apiVersion("1.0.0");
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "我的API文档",
                "后台RESTful API",
                "",
                "bobo.@sun.com",
                "",
                "");
        return  apiInfo;
    }
}
