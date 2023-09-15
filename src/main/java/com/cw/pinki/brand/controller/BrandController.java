package com.cw.pinki.brand.controller;

import com.cw.pinki.brand.service.BrandService;
import com.cw.pinki.common.dto.BrandLoginDto;
import com.cw.pinki.common.vo.BankAccount;
import com.cw.pinki.common.vo.Brand;
import com.cw.pinki.payment.service.PaymentService;
import com.cw.pinki.schedule.RegistrationCompleteEvent;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/register")
    @Operation(tags = "register", description = "設計師帳號註冊")
    public void brandRegister(@Validated @RequestBody Brand brand, HttpServletRequest request) {
        int brandNo = brandService.register(brand);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setMemberType(2);
        bankAccount.setMemberNo(brandNo);
        bankAccount.setAccountNumber(brand.getBankAccount());
        bankAccount.setBankNo(brand.getBankNo());
        bankAccount.setProcessUser(brand.getBrandName());
        paymentService.addBankAccount(bankAccount);
        String appUrl = request.getContextPath();
//        eventPublisher.publishEvent(new RegistrationCompleteEvent());
        log.info("設計師帳號{} 註冊成功", brand.getDesignerAccount());
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
