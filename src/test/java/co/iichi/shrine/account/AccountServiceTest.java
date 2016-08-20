package co.iichi.shrine.account;

import co.iichi.shrine.AccountService;
import co.iichi.shrine.TestApplication;
import co.iichi.shrine.account.Account;
import co.iichi.shrine.account.AccountDao;
import co.iichi.shrine.account.AccountFactory;
import co.iichi.shrine.account.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Created by sat8bit on 2016/07/03.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestApplication.class)
public class AccountServiceTest {

    @Autowired
    private  AccountServiceImpl accountService;

    @Test
    public void createTest() {
        Account account = accountService.create();

        log.info("account is {}", account);

        Assert.assertThat(account.getAccountId().length(), is(12));
        Assert.assertThat(account.getValue(), is(BigInteger.ZERO));
        Assert.assertThat(account.getCreatedAt(), is(notNullValue()));
        Assert.assertThat(account.getLastAddedAt(), is(Optional.empty()));
        Assert.assertThat(account.getLastSubtractedAt(), is(Optional.empty()));

        log.info("account is {}", accountService.get(account.getAccountId()));
    }
}
