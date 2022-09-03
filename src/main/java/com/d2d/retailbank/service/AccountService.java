package com.d2d.retailbank.service;

import com.d2d.retailbank.dto.AccountDetails;
import com.d2d.retailbank.dto.AccountDetailsResponse;
import com.d2d.retailbank.entity.CustomerAccount;
import com.d2d.retailbank.repo.CustomerAccountRepo;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<AccountDetailsResponse> getAllAccount(){

       var accountList =  customerAccountRepo.findAll();
       var accountDetailResponseList = accountList.stream()
              .map(account -> entityToAccountResponse(account)).collect(Collectors.toList());
       return accountDetailResponseList;

    }

    public AccountDetailsResponse getAccountForCustomer(String firstName){

       var account =  customerAccountRepo.findAccountByUserFirstName(firstName);
       var accountResponse = entityToAccountResponse(account);
       return accountResponse;

    }

    private AccountDetailsResponse entityToAccountResponse(CustomerAccount customerAccount){
        var accountDetailsResponse = AccountDetailsResponse.builder().build();
        BeanUtils.copyProperties(customerAccount,accountDetailsResponse);
        return accountDetailsResponse;
    }



}
