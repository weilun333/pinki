package com.cw.pinki.common.listener;

import com.cw.pinki.common.vo.Brand;
import com.cw.pinki.schedule.BrandRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;

public class RegistrationListener implements ApplicationListener<BrandRegistrationCompleteEvent> {

    @Autowired
    private MessageSource message;

    @Autowired
    private JavaMailSender mailSender;

    private void confirmRegistration(BrandRegistrationCompleteEvent event) {
        Brand brand = event.getBrand();
        String token = UUID.randomUUID().toString();
        // TODO:createToken
        String recipientAddress = brand.getDesignerAccount();
        String subject = "品牌註冊成功確認信件";
        String confirmationUrl = event.getAppUrl() + "/registrationConfirm?token" + token;
        String mes = message.getMessage("message.regSucc", null, event.getLocale());
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(mes +"\r\n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }

    @Override
    public void onApplicationEvent(BrandRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }
}
