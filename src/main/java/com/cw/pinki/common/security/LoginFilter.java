package com.cw.pinki.common.security;

import com.cw.pinki.common.vo.Brand;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        Brand brand = obtainBrand(request);

        UsernamePasswordAuthenticationToken authRequest = UsernamePasswordAuthenticationToken.unauthenticated(brand.getDesignerAccount(), brand.getDesignerPassword());
        // 進到service執行驗證
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    private Brand obtainBrand(HttpServletRequest request) throws IOException {
        // 前端傳遞JSON物件
        BufferedReader reader = request.getReader(); // 從請求體獲取數據
        StringBuffer sbf = new StringBuffer();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sbf.append(line);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Brand brand = objectMapper.readValue(sbf.toString(), Brand.class);
        return brand;
    }
}
