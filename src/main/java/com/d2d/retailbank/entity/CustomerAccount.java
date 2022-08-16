package com.d2d.retailbank.entity;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name= "T_CUSTOMER_ACCOUNT")
public class CustomerAccount {
    @Id
    @Column(name="account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "customerFirstName")
    private String userFirstName;
    @Column(name = "customerLastName")
    private String userLastName;
    @Column(name = "customerAddress")
    private String address;
    @Column(name = "customerPhoneNumber")
    private String phoneNumber;
    @Column(name = "customerAccountNumber")
    private String accountNumber;

}
