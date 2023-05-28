package ma.enset.digital_banking.services;

import ma.enset.digital_banking.dtos.BankAccountDTO;
import ma.enset.digital_banking.dtos.CurrentBankAccountDTO;
import ma.enset.digital_banking.dtos.CustomerDTO;
import ma.enset.digital_banking.dtos.SavingBankAccountDTO;
import ma.enset.digital_banking.entities.BankAccount;
import ma.enset.digital_banking.entities.CurrentAccount;
import ma.enset.digital_banking.entities.Customer;
import ma.enset.digital_banking.entities.SavingAccount;
import ma.enset.digital_banking.exceptions.BalanceNotSufficentException;
import ma.enset.digital_banking.exceptions.BankAccountNotFoundException;
import ma.enset.digital_banking.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    public CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomer();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficentException;
    void credit(String accountId,double amount,String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficentException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);
}
