package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.AccountDto;
import diyor.adawev.radios.dto.AddressDto;
import diyor.adawev.radios.model.Account;
import diyor.adawev.radios.model.Address;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepo accountRepo;

    public List<Account> getAll() {
        return accountRepo.findAll();
    }
    public Account getById(Integer id) {
        return accountRepo.findById(id).get();
    }

    public Result create(AccountDto accountDto) {
        Account account = new Account();
        account.setName(accountDto.getName());
        account.setEmail(accountDto.getEmail());
        account.setPassword(accountDto.getPassword());
        accountRepo.save(account);
        return new Result(true, "Account created");
    }
    public Result update(Integer id, AccountDto accountDto) {
        Optional<Account> byId = accountRepo.findById(id);
        if (byId.isPresent()) {
            Account account = byId.get();
           account.setName(accountDto.getName());
           account.setEmail(accountDto.getEmail());
           account.setPassword(accountDto.getPassword());
            accountRepo.save(account);
            return new Result(true, "Account updated");
        }
        return new Result(true, "Account not found");
    }
    public Result delete(Integer id) {
        Optional<Account> byId = accountRepo.findById(id);
        if (byId.isPresent()) {
            accountRepo.delete(byId.get());
            return new Result(true, "Account deleted");
        }
        return new Result(true, "Account not found");
    }
}
