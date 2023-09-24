package com.cw.pinki.payment.service.impl;

import com.cw.pinki.common.vo.BankAccount;
import com.cw.pinki.payment.dao.PaymentMapper;
import com.cw.pinki.payment.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentDao;

    @Override
    public int addBankAccount(BankAccount bankAccount) {
        // 新增銀行帳號
        if(!bankAccount.getAccountNumber().isEmpty() && !bankAccount.getBankNo().isEmpty()){
            bankAccount.setPaymentMethodNo(1);
            bankAccount.setIsUsualAccount(bankAccount.getIsUsualAccount() == null);
            paymentDao.insertNewBankAccount(bankAccount);
            log.info("會員新增銀行帳號成功");
            return 1;
        }
        return 0;
    }
}
