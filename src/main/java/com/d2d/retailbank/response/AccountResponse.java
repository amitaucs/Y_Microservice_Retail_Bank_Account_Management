package com.d2d.retailbank.response;

import com.d2d.retailbank.dto.AccountDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AccountResponse {
    @Schema(description =  "Message related to account status")
    private String message;
    @Schema(description =  "Account details of a customer")
    private AccountDetails accountDetails;
    @Schema(description =  "List of all account details ")
    private List<AccountDetails> accountDetailsList;
}
