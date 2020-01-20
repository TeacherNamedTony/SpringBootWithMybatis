package cn.am.config;

import cn.am.intercepter.UserIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class UserConfig extends WebMvcConfigurationSupport {

    /**
     * user拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(new UserIntercepter()).addPathPatterns("/user/**");
    }

}
