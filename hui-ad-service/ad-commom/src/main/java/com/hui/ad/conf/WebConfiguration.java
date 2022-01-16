package com.hui.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 自定义消息转换器，消息转换器实现对数据流的序列化和反序列化
     * @RequestBody 和 @ResponseBody 这两个注解是用来标识当前的对象需要做序列化或反序列化。
     * @param converters SpringMVC 使用默认的消息转换器进行转换
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>>
                                                       converters) {
        //将转换器清空
        converters.clear();
        //MappingJackson2HttpMessageConverter 实现将java对象转换json对象
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}
