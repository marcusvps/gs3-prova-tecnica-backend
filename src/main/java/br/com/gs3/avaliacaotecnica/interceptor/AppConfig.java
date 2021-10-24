package br.com.gs3.avaliacaotecnica.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements  WebMvcConfigurer {


    @Bean
    public HandlerInterceptor getClienteInterceptor(){
        return new ClienteInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(getClienteInterceptor());
    }
}
