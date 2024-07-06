package com.dgmf.service;

import com.dgmf.dto.CustomerDto;

public interface AccountsService {
    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);
}
