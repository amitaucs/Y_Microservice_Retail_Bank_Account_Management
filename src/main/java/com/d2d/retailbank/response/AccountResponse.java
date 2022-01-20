package com.d2d.retailbank.response;

import com.d2d.retailbank.dto.AccountDetails;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AccountResponse {
    @ApiModelProperty(notes = "Message related to account status")
    private String message;
    @ApiModelProperty(notes = "Account details of a customer")
    private AccountDetails accountDetails;
    @ApiModelProperty(notes = "List of all account details ")
    private List<AccountDetails> accountDetailsList;
}
