package com.cw.pinki.brand.controller;

import com.cw.pinki.brand.service.BrandService;
import com.cw.pinki.common.dto.BrandLoginDto;
import com.cw.pinki.common.vo.BankAccount;
import com.cw.pinki.common.vo.Brand;
import com.cw.pinki.common.token.VerificationToken;
import com.cw.pinki.payment.service.PaymentService;
import com.cw.pinki.schedule.BrandRegistrationCompleteEvent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/brand")
@Tag(name = "Brand Info Management", description = "品牌資訊管理")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private MessageSource messages;

    @PostMapping("/register")
    @Operation(tags = "register", description = "設計師帳號註冊")
    public void brandRegister(@Validated @RequestBody Brand brand, HttpServletRequest request) {
        Brand designer = brandService.register(brand);
        int brandNo = designer.getBrandNo();
        BankAccount bankAccount = new BankAccount();
        bankAccount.setMemberType(2);
        bankAccount.setMemberNo(brandNo);
        bankAccount.setAccountNumber(brand.getBankAccount());
        bankAccount.setBankNo(brand.getBankNo());
        bankAccount.setProcessUser(brand.getBrandName());
        paymentService.addBankAccount(bankAccount);
        String appUrl = request.getContextPath();
        eventPublisher.publishEvent(new BrandRegistrationCompleteEvent(designer, request.getLocale(), appUrl));
        log.info("設計師帳號{} 註冊成功", brand.getDesignerAccount());
    }

    @GetMapping("/registrationConfirm")
    @Operation(tags = "register", description = "啟用設計師帳號")
    public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token) {
        Locale locale = request.getLocale();
        VerificationToken verificationToken = brandService.getVerification(token);
        String message = null;
        if (verificationToken == null) {
            message = messages.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            log.error(message);
//            return "redirect:/badUser.html?lang=" + locale.getLanguage();
            return "The token isn't exist.";
        }
        Brand brand = verificationToken.getBrand();
        if (verificationToken.getExpiryDate().getMinute() - LocalDateTime.now().getMinute() <= 0) {
            message = messages.getMessage("auth.message.expired", null, locale);
            log.error(message);
//            return "redirect:/badUser.html?lang=" + locale.getLanguage();
            return "The token has been expired.";
        }
        brand.setDesignerStatus(true);
        brandService.enableDesignerAccount(brand);
//        return "redirect:/login.html?lang=" + locale.getLanguage();
        return "Your account has been successfully activated.";
    }

    @PostMapping("/login")
    @Operation(tags = "login", description = "設計師帳號登入")
    public void brandLogin(@Validated @RequestBody BrandLoginDto brandLoginDto) {
        brandService.login(brandLoginDto);
        log.info("設計師帳號{} 登入成功", brandLoginDto.getDesignerAccount());
    }

    @PostMapping("logout")
    @Operation(tags = "logout", description = "設計師帳號登出")
    public boolean brandLogout(@RequestBody Brand brand) {
        return brandService.logout(brand.getDesignerAccount());
    }

    @PostMapping("/restPassword")
    @Operation(tags = "rest password", description = "修改密碼")
    public int restPassword(@Validated @RequestBody BrandLoginDto brandLoginDto) {
        return 1;
    }
}
