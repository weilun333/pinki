package com.cw.pinki.payment.dao.impl;

import com.cw.pinki.common.vo.BankAccount;
import com.cw.pinki.payment.dao.PaymentDao;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;


public class PaymentDaoImpl implements PaymentDao {

    @PersistenceContext
    private Session session;

    public Session getSession() {
        return session;
    }

    @Override
    public void insertNewBankAccount(BankAccount bankAccount) {
        if(bankAccount != null && bankAccount.getAccountNo() == null){
            session.persist(bankAccount);
        }
    }
}
