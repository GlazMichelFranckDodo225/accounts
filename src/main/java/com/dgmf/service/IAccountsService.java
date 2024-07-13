package com.dgmf.service;

import com.dgmf.dto.CustomerDto;

public interface IAccountsService {
    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
}
