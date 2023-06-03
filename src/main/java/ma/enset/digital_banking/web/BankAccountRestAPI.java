package ma.enset.digital_banking.web;

import lombok.AllArgsConstructor;
import ma.enset.digital_banking.dtos.AccountHistoryDTO;
import ma.enset.digital_banking.dtos.AccountOperationDTO;
import ma.enset.digital_banking.dtos.BankAccountDTO;
import ma.enset.digital_banking.exceptions.BankAccountNotFoundException;
import ma.enset.digital_banking.services.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;
    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }
    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public List<AccountOperationDTO> getAccountHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size",defaultValue = "5")int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
    }

}
