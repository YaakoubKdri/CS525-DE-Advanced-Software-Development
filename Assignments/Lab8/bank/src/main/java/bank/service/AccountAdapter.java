package bank.service;

import bank.domain.Account;
import bank.domain.AccountEntry;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter {
    public AccountDTO getAccountDTO(Account account){
        AccountDTO dto = new AccountDTO();
        dto.setAccountNumber(account.getAccountnumber());

        CustomerDTO customerDTO = new CustomerDTO(account.getCustomer().getName());
        dto.setCustomer(customerDTO);

        dto.setBalance(account.getBalance());

        List<AccountEntryDTO> entryDTOS = new ArrayList<>();
        for(AccountEntry entry : account.getEntryList()){
            AccountEntryDTO entryDTO = new AccountEntryDTO(
                    entry.getAmount(),
                    entry.getDate(),
                    entry.getDescription()
            );
            entryDTOS.add(entryDTO);
        }
        dto.setEntries(entryDTOS);
        return dto;
    }
}
