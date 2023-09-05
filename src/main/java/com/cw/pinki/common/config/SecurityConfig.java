package com.cw.pinki.common.config;

import com.cw.pinki.common.security.LoginFailureHandler;
import com.cw.pinki.common.security.LoginFilter;
import com.cw.pinki.common.security.LoginSuccessHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity // 開啟SpringSecurity 會大量註冊過濾器filter → SecurityFilterChain
public class SecurityConfig {
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*authorizeHttpRequests：針對http請求進行授權配置
         * login登入頁面需匿名訪問
         * permitAll：具有所有權限 包含可以匿名訪問
         * anyRequest：任何請求 所有請求
         * authenticated：認證(登入)
         * loginPage登入頁面
         * loginProcessingUrl：指定登入api 過濾器
         * defaultSuccessUrl：登入成功後跳轉頁面
         * successHandler：登入成功處理器
         * failureHandler：登入失敗處理器
         */

        http
                .authorizeHttpRequests(authorize -> authorize
                        // 角色
//                        .requestMatchers("/admin/api").hasRole("admin") // 必須有admin角色才可訪問
//                        .requestMatchers("user/api").hasAnyRole("admin", "user") // 多個角色訪問
//                        // 權限
//                        .requestMatchers("/admin/api").hasAuthority("admin:api") //必須有admin:api權限才能訪問
//                        .requestMatchers("/user/api").hasAnyAuthority("admin:api","user:api")// 有這兩個權限的都能訪問
//                        // 匹配模式
//                        .requestMatchers("/admin/api/?").hasAuthority("admin:api")
//                        .requestMatchers("/admin/api/*").hasAuthority("admin:api")
//                        .requestMatchers("/admin/api/**").hasAuthority("admin:api")

//                        .requestMatchers("/login").permitAll() // 匿名訪問
                        .requestMatchers("/brand/register").permitAll()
                        .requestMatchers("/csrf").permitAll()
                        .anyRequest().authenticated()
                )
//                .formLogin(formLogin -> formLogin
//                        .loginProcessingUrl("/login").permitAll()
//                        .successHandler(new LoginSuccessHandler())
//                        .failureHandler(new LoginFailureHandler())
//                )
//                .rememberMe(withDefaults())
                ;
        // 借助異常處理配置一個未授權頁面 實際上應捕獲異常訊息後 通過異常類型來判斷是甚麼異常
        // 未授權報錯頁面
//        http.exceptionHandling(e -> e.accessDeniedPage("/noAuth"));

        // 配置自定義登入過濾器
        // 將UsernamePasswordAuthenticationFilter替換
//        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable(); // 跨域漏洞防禦：關閉
        http.cors().disable(); // 跨域攔截關閉
//        http.logout(logout -> logout.invalidateHttpSession(true)); // 登出後session失效 // 須為post請求

        return http.build();
    }

//    @Autowired
//    AuthenticationConfiguration authenticationConfiguration;
//
//    @Bean
//    public LoginFilter loginFilter() throws Exception {
//        LoginFilter loginFilter = new LoginFilter();
//        loginFilter.setAuthenticationSuccessHandler(new LoginSuccessHandler());
//        loginFilter.setAuthenticationFailureHandler(new LoginFailureHandler());
//        loginFilter.setAuthenticationManager(authenticationConfiguration.getAuthenticationManager());
//        return loginFilter;
//    }

    /*
     * PasswordEncorder：加密編碼
     * 實際開發中開發環境一般是明文加密 在生產環境中多是密文加密 也可以配置多種加密方式
     * NoOpPasswordEncoder.getInstance() → 明文加密
     * BCryptPasswordEncoder → 加鹽加密【隨機鹽】ex: 12345 → abdef12345 → fsaegjebnethe
     * PasswordEncoderFactories：內有多種加密方法，默認是bcrypt
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
