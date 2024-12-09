package lablaida.ikram.ebank_account_service.service;

import lablaida.ikram.ebank_account_service.dto.BankAccountRequestDTO;
import lablaida.ikram.ebank_account_service.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
