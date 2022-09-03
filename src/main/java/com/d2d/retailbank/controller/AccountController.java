package com.d2d.retailbank.controller;

import com.d2d.retailbank.dto.AccountDetails;
import com.d2d.retailbank.dto.AccountDetailsResponse;
import com.d2d.retailbank.response.AccountResponse;
import com.d2d.retailbank.service.AccountService;
import com.d2d.retailbank.vo.RetailBankProperties;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "${tagName}")
@Slf4j
public class AccountController {

    private RetailBankProperties retailBankProperties;
    private AccountService accountService;

    public AccountController(RetailBankProperties retailBankProperties, AccountService accountService) {
        this.retailBankProperties = retailBankProperties;
        this.accountService = accountService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestHeader Map<String, String> headers) {
        log.info("###### header value is : {}", headers.get("retailbank"));
        log.info("###### pre filter header value is : {}", headers.get("retailbankprefilter"));
        return ResponseEntity.status(HttpStatus.OK).body(retailBankProperties.getMessage());

    }


    @Operation(summary = "Create a new bank account for customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @PostMapping("/createNewAccount")
    ResponseEntity<AccountResponse> createNewAccount(@RequestBody AccountDetails accountDetails) {

        AccountResponse accountResponse;
        if (null == accountDetails) {
            accountResponse = AccountResponse.builder()
                    .message("Account details are empty")
                    .build();
        } else {
            accountService.createAccount(accountDetails);
            accountResponse = AccountResponse.builder()
                    .message("Customer Account has been created")
                    .build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @Operation(summary = "Get all bank accounts")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping("/getAllAccount")
    ResponseEntity<List<AccountDetailsResponse>> getAllAccount() {

        var accountResponses = accountService.getAllAccount();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponses);

    }

    @Operation(summary = "Get bank account details for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping("/getAccountForCustomer")
    ResponseEntity<AccountDetailsResponse> getAccountForCustomer(
            @Parameter(description = "Customer name for which bank account details is needed",
                    required = true)
            @RequestParam(value = "customerName") String customerName) {

        var accountResponse = accountService.getAccountForCustomer(customerName);
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @Operation(summary = "Update bank account  for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @PutMapping("/updateAccount")
    ResponseEntity<String> updateAccount(@RequestBody AccountDetails accountDetails) {

        if(null == accountDetails){
            return ResponseEntity.badRequest().body("Account details is empty");
        }else{
           var response = accountService.updateCustomerAccount(accountDetails);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

    }

    @Operation(summary = "Delete bank account  for a customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @DeleteMapping("/deleteAccount")
    ResponseEntity<String> deleteAccount(@RequestBody AccountDetails accountDetails) {

        if(null == accountDetails){
            return ResponseEntity.badRequest().body("Account details is empty");
        }else{
            var response = accountService.deleteCustomerAccount(accountDetails);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
}
