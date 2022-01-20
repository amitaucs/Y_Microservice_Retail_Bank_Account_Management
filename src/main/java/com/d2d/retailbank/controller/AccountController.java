package com.d2d.retailbank.controller;

import com.d2d.retailbank.dto.AccountDetails;
import com.d2d.retailbank.response.AccountResponse;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retailBank")
@Tag(name = "Retail Bank Account management application")
@Api(tags = "Retail Bank Account management application")
public class AccountController {

    @ApiOperation(value = "Create a new bank account for customer")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 200, message = "Ok", response = AccountResponse.class)})
    @PostMapping("/createNewAccount")
    ResponseEntity<AccountResponse> createNewAccount(@RequestBody AccountDetails accountDetails) {

        var accountResponse = AccountResponse.builder()
                .message("create account development is in progress")
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @ApiOperation(value = "Get all bank accounts")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 200, message = "Ok", response = AccountResponse.class)})
    @GetMapping("/getAllAccount")
    ResponseEntity<AccountResponse> getAllAccount() {

        var accountResponse = AccountResponse.builder()
                .message("get all account development is in progress")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);

    }

    @ApiOperation(value = "Get bank account details for a customer")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 200, message = "Ok", response = AccountResponse.class)})
    @GetMapping("/getAccountForCustomer")
    ResponseEntity<AccountResponse> getAccountForCustomer(
            @ApiParam(value = "Customer name for which bank account details is needed",
                    type = "String", required = true)
            @RequestParam(value = "customerName") String customerName) {

        var accountResponse = AccountResponse.builder()
                .message("get  account development is in progress")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @ApiOperation(value = "Update bank account  for a customer")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 200, message = "Ok", response = AccountResponse.class)})
    @PutMapping("/updateAccount")
    ResponseEntity<AccountResponse> updateAccount(@RequestBody AccountDetails accountDetails) {

        var accountResponse = AccountResponse.builder()
                .message("Update  account development is in progress")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }

    @ApiOperation(value = "Delete bank account  for a customer")
    @ApiResponses(value = {@ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 200, message = "Ok", response = AccountResponse.class)})
    @DeleteMapping("/deleteAccount")
    ResponseEntity<AccountResponse> deleteAccount(@RequestBody AccountDetails accountDetails) {

        var accountResponse = AccountResponse.builder()
                .message("delete  account development is in progress")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(accountResponse);
    }
}
