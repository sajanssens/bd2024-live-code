package com.infosupport.shopping.repository;

import java.math.BigDecimal;
import com.infosupport.shopping.User;

public interface UserRepository {
    User getUser(String username);

    void addPaymentHistory(String username, BigDecimal payment);
}
