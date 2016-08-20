package co.iichi.shrine.account;

import co.iichi.shrine.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sat8bit on 2016/07/03.
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountFactory accountFactory;

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account create() {
        Account account = accountFactory.createNewAccount();
        accountDao.store(account);

        return account;
    }

    @Override
    public Account get(String accountId) {
        return accountDao.find(accountId);
    }
}
