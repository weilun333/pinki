package com.cw.pinki.payment.dao;

import com.cw.pinki.common.vo.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao {
    void insertNewBankAccount(BankAccount bankAccount);

}
