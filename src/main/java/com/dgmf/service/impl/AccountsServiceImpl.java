package com.dgmf.service.impl;

import com.dgmf.dto.CustomerDto;
import com.dgmf.repository.AccountsRepository;
import com.dgmf.repository.CustomerRepository;
import com.dgmf.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    /**
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
