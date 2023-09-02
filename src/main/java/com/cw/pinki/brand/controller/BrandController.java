package com.cw.pinki.brand.controller;

import com.cw.pinki.brand.service.BrandService;
import com.cw.pinki.common.vo.BankAccount;
import com.cw.pinki.common.vo.Brand;
import com.cw.pinki.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/register")
    @Operation(tags = "register", description = "品牌帳號註冊")
    public void brandRegister(HttpSession session, @Validated @RequestBody Brand brand) {
        int brandNo = brandService.register(brand);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setMemberType(2);
        bankAccount.setMemberNo(brandNo);
        bankAccount.setAccountNumber(brand.getBankAccount());
        bankAccount.setBankNo((String) session.getAttribute("bankNo"));
        bankAccount.setProcessUser(brand.getBrandName());
        paymentService.addBankAccount(bankAccount);
        log.info("品牌：{}帳號註冊成功", brand.getBrandName());
    }
}
