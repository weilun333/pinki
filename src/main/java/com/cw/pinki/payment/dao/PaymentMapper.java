package com.cw.pinki.payment.dao;

import com.cw.pinki.common.vo.BankAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMapper {
    int insertNewBankAccount(@Param("payment") BankAccount bankAccount);

}
