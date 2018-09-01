package com.netty4.server.conf;

import com.netty4.server.anotation.UserParam;
import com.netty4.server.conf.jwt.JwtHelper;
import com.netty4.server.conf.jwt.JwtInterceptor;
import com.netty4.server.conf.jwt.JwtProperties;
import com.netty4.server.entity.SysUser;
import com.netty4.server.exception.ParamNullException;
import com.netty4.server.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author M_Sir
 */
@Configuration
@EnableConfigurationProperties({JwtProperties.class})
public  class CustomWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private SysUserService sysUserService;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        JwtInterceptor jwtInterceptor = new JwtInterceptor(jwtProperties, sysUserService);
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/sys/**")
                .excludePathPatterns("/sys/user/login", "/sys/user/register");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new HandlerMethodArgumentResolver() {

            @Override
            public boolean supportsParameter(MethodParameter parameter) {
                return parameter.hasParameterAnnotation(UserParam.class);
            }

            @Override
            public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
                SysUser user = (SysUser) webRequest.getAttribute(JwtHelper.CLAIM_USER, NativeWebRequest.SCOPE_REQUEST);
                if (user == null) {
                    throw new ParamNullException(parameter.getParameterName());
                }
                return user;
            }
        });
    }
}