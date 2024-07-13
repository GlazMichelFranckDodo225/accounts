package com.dgmf.controller;

import com.dgmf.constants.AccountsConstants;
import com.dgmf.dto.CustomerDto;
import com.dgmf.dto.ResponseDto;
import com.dgmf.service.IAccountsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api/v1/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {
    private IAccountsService iAccountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(
            @RequestBody CustomerDto customerDto
    ) {
        iAccountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201
                    )
                );
    }
}
