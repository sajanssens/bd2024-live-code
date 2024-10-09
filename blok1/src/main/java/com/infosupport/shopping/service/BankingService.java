package com.infosupport.shopping.service;

import java.math.BigDecimal;

public interface BankingService {
    BigDecimal getBalance(String accountNumber);

    void makePayment(String accountNumber, BigDecimal payment);

}
