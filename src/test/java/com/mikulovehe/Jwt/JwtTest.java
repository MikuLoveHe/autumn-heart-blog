package com.mikulovehe.Jwt;

import com.mikulovehe.DTO.UserDTO;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import com.mikulovehe.Util.JwtTokenUtil;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@SpringBootTest
public class JwtTest {
    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    public void test() {
        UserDTO userDTO = new UserDTO("zhangsan", "3333");

        HashMap<String, Object> claims = new HashMap<>();
        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(userDTO.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        System.out.println(token);
    }

    @Test
    public void test2() {
        SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64Key = java.util.Base64.getEncoder().encodeToString(SECRET_KEY.getEncoded());
        System.out.println(base64Key);

    }

    @Test
    public void test3() {
        System.out.println(new Date().getTime());
    }


    // 生成token
    @Test
    public void test4() {
        System.out.println(jwtTokenUtil.generateToken("zhangsan"));
        //eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6aGFuZ3NhbiIsImlhdCI6MTc1MDU5MjY5MSwiZXhwIjoxNzUwNTkyNzIxfQ.NQAuSoykq9YGpgAYNClfEbYUthEBoyTQtw1Xdm-XYyY
    }

    // 解析token获取用户名
    @Test
    public void test5() {
        System.out.println(jwtTokenUtil.getUsernameFromToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6aGFuZ3NhbiIsImlhdCI6MTc1MDU5MjExMCwiZXhwIjoxNzUwNjc4NTEwfQ.tbbeIy_Bl_heNMdYEAp_0dqmskepFzgqbl79StwPYX8"));
    }

    // 认证token
    @Test
    public void test6() {
        System.out.println(jwtTokenUtil.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ6aGFuZ3NhbiIsImlhdCI6MTc1MDU5MjY5MSwiZXhwIjoxNzUwNTkyNzIxfQ.NQAuSoykq9YGpgAYNClfEbYUthEBoyTQtw1Xdm-XYyY"));
    }

}
