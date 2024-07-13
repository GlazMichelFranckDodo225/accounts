package com.dgmf.service.impl;

import com.dgmf.constants.AccountsConstants;
import com.dgmf.dto.CustomerDto;
import com.dgmf.entity.Accounts;
import com.dgmf.entity.Customer;
import com.dgmf.exception.CustomerAlreadyExistsException;
import com.dgmf.mapper.CustomerMapper;
import com.dgmf.repository.AccountsRepository;
import com.dgmf.repository.CustomerRepository;
import com.dgmf.service.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    /**
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer =
                customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException(
                    "Customer already registered with given mobileNumber "
                    + customerDto.getMobileNumber())
            ;
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        Customer savedCustomer = customerRepository.save(customer);
        // Create a New Bank Account for the New Customer
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous");

        return newAccount;
    }
}
