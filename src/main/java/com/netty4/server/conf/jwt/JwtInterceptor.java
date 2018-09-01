package com.netty4.server.conf.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import com.netty4.server.entity.SysUser;
import com.netty4.server.exception.TokenTimeoutException;
import com.netty4.server.service.SysUserService;
import com.netty4.server.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class JwtInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtInterceptor.class);

    private JwtProperties jwtProperties;

    private SysUserService sysUserService;

    public JwtInterceptor(JwtProperties jwtProperties, SysUserService userService) {
        this.jwtProperties = jwtProperties;
        this.sysUserService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            //LOGGER.info("current url -> {}",request.getRequestURI());
            final String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            if ("OPTIONS".equals(request.getMethod())) {
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                if (Strings.isNullOrEmpty(token)) {
                    throw new LoginException("Token is empty");
                }
                if (jwtProperties == null) {
                    BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    jwtProperties = (JwtProperties) factory.getBean("jwtProperties");
                }
                DecodedJWT decodedJWT = JwtHelper.parseJWT(token, jwtProperties);
                if (decodedJWT == null) {
                    throw new LoginException("Token error");
                }
                if (new Date().after(decodedJWT.getExpiresAt())) {
                    throw new TokenTimeoutException("TokenTimeout");
                }
                String decode = CommonUtil.urlDecode(decodedJWT.getClaim(JwtHelper.CLAIM_USER).asString());

                long userId = JwtHelper.JSON_PARSER.parse(decode).getAsJsonObject().get(JwtHelper.CLAIM_USERID).getAsLong();
                SysUser user = sysUserService.getSysUserByPrimaryKey(userId);
//                if (!requiresPermissions(user, handler)) {
//                    throw new UnauthorizedException("没有权限访问该接口");
//                }
                request.setAttribute(JwtHelper.CLAIM_USER, user);
            }
        } catch (final Exception e) {
            throw new LoginException(e.getMessage());
        }
        return true;
    }



    /*
    private boolean requiresPermissions(SysUser user, Object handler) {
        Role quarters = user.getRole();
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if (handlerMethod.hasMethodAnnotation(RequiresPermissions.class)) {
                RequiresPermissions requiresPermissions = handlerMethod.getMethodAnnotation(RequiresPermissions.class);
                String[] value = requiresPermissions.value();
                if (value.length == 0) {
                    return true;
                }
                AtomicBoolean result = new AtomicBoolean(false);
                for (int i = 0; i < value.length; i++) {
                    if ((quarters.getMarks()).contains(value[i])) {
                        result.set(true);
                        break;
                    }
                }
                return result.get();
            }
        }
        return true;
    }
    */
}
