package com.d2d.retailbank.service;

import com.d2d.retailbank.dto.AccountDetails;
import com.d2d.retailbank.entity.CustomerAccount;
import com.d2d.retailbank.repo.CustomerAccountRepo;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@Setter
@Slf4j
public class AccountService {

    private CustomerAccountRepo customerAccountRepo;

    public AccountService(CustomerAccountRepo customerAccountRepo) {
        this.customerAccountRepo = customerAccountRepo;
    }

    public void createAccount(AccountDetails accountDetails){

        var customerAccount = new CustomerAccount();
        BeanUtils.copyProperties(accountDetails,customerAccount);
        customerAccount.setAccountNumber(UUID.randomUUID().toString());
        customerAccountRepo.save(customerAccount);

    }
}
