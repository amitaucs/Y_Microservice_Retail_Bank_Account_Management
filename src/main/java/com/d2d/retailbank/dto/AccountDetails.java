package com.d2d.retailbank.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountDetails {

    @ApiModelProperty(notes = "Account holder's first name")
    private String userFirstName;
    @ApiModelProperty(notes = "Account holder's last name")
    private String userLastName;
    @ApiModelProperty(notes = "Account holder's address")
    private String address;
    @ApiModelProperty(notes = "Account holder's phone number")
    private String phoneNumber;
    @ApiModelProperty(notes = "Account holder's account number")
    private String accountNumber;
}
