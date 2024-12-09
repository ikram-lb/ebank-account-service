package lablaida.ikram.ebank_account_service.dto;

import lablaida.ikram.ebank_account_service.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountRequestDTO {
    private Double balance;

    private String currency;
    private AccountType type;
}
