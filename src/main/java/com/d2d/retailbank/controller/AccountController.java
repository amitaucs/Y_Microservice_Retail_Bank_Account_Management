package com.d2d.retailbank.controller;

import com.d2d.retailbank.dto.AccountDetails;
import com.d2d.retailbank.response.AccountResponse;
import com.d2d.retailbank.vo.RetailBankProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Tag(name = "${tagName}")
public class AccountController {

   private RetailBankProperties retailBankProperties;

   @GetMapping("/welcome")
   public String welcome(){
       return retailBankProperties.getMessage();
   }


    @Operation(summary = "Create a new bank account for customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @PostMapping("/createNewAccount")
    ResponseEntity<AccountResponse> createNewAccount(@RequestBody AccountDetails accountDetails) {

        var accountResponse = AccountResponse.builder()
                .message("create account development is in progress")
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @Operation(summary = "Get all bank accounts")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping("/getAllAccount")
    ResponseEntity<AccountResponse> getAllAccount() {

        var accountResponse = AccountResponse.builder()
                .message("get all account development is in progress")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);

    }

    @Operation(summary = "Get bank account details for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping("/getAccountForCustomer")
    ResponseEntity<AccountResponse> getAccountForCustomer(
            @Parameter(description = "Customer name for which bank account details is needed",
                     required = true)
            @RequestParam(value = "customerName") String customerName) {

        var accountResponse = AccountResponse.builder()
                .message("get  account development is in progress")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @Operation(summary = "Update bank account  for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @PutMapping("/updateAccount")
    ResponseEntity<AccountResponse> updateAccount(@RequestBody AccountDetails accountDetails) {

        var accountResponse = AccountResponse.builder()
                .message("Update  account development is in progress")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @Operation(summary = "Delete bank account  for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @DeleteMapping("/deleteAccount")
    ResponseEntity<AccountResponse> deleteAccount(@RequestBody AccountDetails accountDetails) {

        var accountResponse = AccountResponse.builder()
                .message("delete  account development is in progress")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }
}
