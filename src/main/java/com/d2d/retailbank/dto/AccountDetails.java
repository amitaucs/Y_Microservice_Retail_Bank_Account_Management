package com.d2d.retailbank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountDetails {

    @Schema(description = "Account holder's first name")
    private String userFirstName;
    @Schema(description =  "Account holder's last name")
    private String userLastName;
    @Schema(description = "Account holder's address")
    private String address;
    @Schema(description =  "Account holder's phone number")
    private String phoneNumber;

}
