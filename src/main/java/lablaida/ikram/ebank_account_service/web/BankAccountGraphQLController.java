package lablaida.ikram.ebank_account_service.web;

import lablaida.ikram.ebank_account_service.entities.Customer;
import lablaida.ikram.ebank_account_service.repositories.BankAccountRepository;
import lablaida.ikram.ebank_account_service.repositories.CustomerRepository;
import lablaida.ikram.ebank_account_service.service.AccountService;
import lablaida.ikram.ebank_account_service.dto.BankAccountRequestDTO;
import lablaida.ikram.ebank_account_service.dto.BankAccountResponseDTO;
import lablaida.ikram.ebank_account_service.entities.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s[not found", id)));

    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id ,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id ) {
        bankAccountRepository.deleteById(id);

    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }


}


/*
    record BankAccountDTO(Double balance, String type, String currency) {
    }

 */
