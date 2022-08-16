package com.d2d.retailbank.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name= "T_CUSTOMER_ACCOUNT")
public class CustomerAccount {
    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "customer_first_name")
    private String userFirstName;
    @Column(name = "customer_last_name")
    private String userLastName;
    @Column(name = "customer_address")
    private String address;
    @Column(name = "customer_phone-number")
    private String phoneNumber;
    @Column(name = "customer_account_number")
    private String accountNumber;
}
