package com.qiafan.web4j.qiafan.config;

import com.qiafan.web4j.qiafan.interceptor.ContextPathInterceptor;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by ZhangYao
 * Date 2019/4/10 Time 16:05
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ContextPathInterceptor()).addPathPatterns("/*");
    }
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                .configure()
                .addProperty( "hibernate.validator.fail_fast", "true" )
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        return validator;
    }
//
//    @Bean("multipartResolver")
//    public CommonsMultipartResolver resolver(){
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setMaxUploadSize(5*1024*1024);
//        commonsMultipartResolver.setDefaultEncoding("utf-8");
//        commonsMultipartResolver.setPreserveFilename(false);
//        return commonsMultipartResolver;
//    }
}
