package com.mikulovehe.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mikulovehe.Util.JwtTokenUtil;

import java.io.IOException;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 从请求头获取Token (格式：Bearer xxx)
        String token = request.getHeader("Authorization");
        System.out.println("拦截器从header获得token: " + token);
        if (token == null || !token.startsWith("Bearer ")){
            sendUnauthorizedResponse(response,"Token格式错误或缺失");
            return false;
        }
        // 2. 去掉"Bearer "前缀，保留纯Token
        String pureToken = token.substring(7);

        if (!jwtTokenUtil.validateToken(pureToken)) {
            System.out.println("身份信息过期或错误");
            sendUnauthorizedResponse(response,"身份信息过期或错误");
            return false;
        }

        // 5. 验证通过，放行请求
        return true;

    }

    private void sendUnauthorizedResponse(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(
                "{\"code\": 401, \"message\": \"" + message + "\", \"redirect\": \"/login.html\"}"
        );
    }
}
