package com.cw.pinki.common.listener;

import com.cw.pinki.brand.service.BrandService;
import com.cw.pinki.common.vo.Brand;
import com.cw.pinki.schedule.BrandRegistrationCompleteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationListener implements ApplicationListener<BrandRegistrationCompleteEvent> {

    @Autowired
    private MessageSource message;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private BrandService brandService;

    private void confirmRegistration(BrandRegistrationCompleteEvent event) {
        Brand brand = event.getBrand();
        String token = UUID.randomUUID().toString();
        brandService.createVerification(brand, token);

        String recipientAddress = brand.getDesignerAccount();
        String subject = "品牌註冊成功確認信件";
        String confirmationUrl = event.getAppUrl() + "/registrationConfirm?token" + token;
        String mes = message.getMessage("registration.succ", null, event.getLocale());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(mes + "\r\n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
        log.info("帳號{}：註冊信件寄送成功", brand.getDesignerAccount());
    }

    @Override
    public void onApplicationEvent(BrandRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }
}
