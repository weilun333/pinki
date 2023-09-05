package com.cw.pinki.common.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    /*
     *successHandler：登入成功處理器
     * authentication.getPrincipal()：身份驗證的主體，通常是用戶名、用戶ID等
     * authentication.getAuthorities()：返回的是一個權限（角色）清單，您可以使用Java的Stream API或其他適當的方式來處理這個清單以檢查特定的權限
     * authentication.getCredentials()：返回用於身份驗證的憑證，通常是密碼或其他認證資訊
     * authentication.getDetails()：返回有關身份驗證的其他詳細信息，這可能包括IP地址、用戶代理等
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("login success");
        authentication.getPrincipal();
        authentication.getCredentials();
        authentication.getDetails();
        authentication.getAuthorities();
    }
}
