package com.d2d.retailbank.repo;

import com.d2d.retailbank.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepo extends JpaRepository<CustomerAccount,Long> {

    CustomerAccount findAccountByUserFirstName(String firstName);
}
