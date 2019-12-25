package com.youlaiyouqu.boss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
@SpringBootApplication
public class BossApplication {

    public static void main(String[] args) { SpringApplication.run(BossApplication.class, args); }

    //上线放开
//    public class BossApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里要指向原先用main方法执行的Application启动类
//        return builder.sources(BossApplication.class);
//    }

    //Page报错处理
    @Bean
    public ErrorPageFilter errorPageFilter() {
        return new ErrorPageFilter();
    }

    @Bean
    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    // 为null处理
//    @Bean
//    public HttpMessageConverters fastJsonConverters() {
//        FastJsonHttpMessageConverter4 fastConverter = new FastJsonHttpMessageConverter4();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.IgnoreNonFieldGetter,
//                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        List supportedMediaTypes = new ArrayList();
//        supportedMediaTypes.add(new MediaType("text", "json", Charset.forName("utf8")));
//        supportedMediaTypes.add(new MediaType("application", "json", Charset.forName("utf8")));
//        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
//        HttpMessageConverter<?> converter = fastConverter;
//        return new HttpMessageConverters(converter);
//    }
}
