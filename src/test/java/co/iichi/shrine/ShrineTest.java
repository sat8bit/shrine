package co.iichi.shrine;

import co.iichi.shrine.account.AccountServiceImpl;
import co.iichi.shrine.addition.Addition;
import co.iichi.shrine.addition.AdditionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;

/**
 * Created by sat8bit on 2016/07/10.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestApplication.class)
public class ShrineTest {
    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private AdditionServiceImpl additionService;

    @Test
    public void シナリオ1() {

        log.info("シナリオ1 口座開設から加算まで。");

        // 口座開設
        String accountId = accountService.create().getAccountId();
        log.info("Account created. AccountId is {}", accountId);

        // 口座確認
        log.info("Account is {}", accountService.get(accountId));

        // 加算の作成
        Addition addition = additionService.create(accountId, BigInteger.valueOf(5000), "シナリオ１", "CreditCard_00001");
        log.info("Addition created. Addition is {}", addition);

        // 残高確認
        log.info("Account is {}", accountService.get(accountId));

        // 加算の実行
        additionService.execute(accountId, addition.getAdditionId());

        // 加算の確認
        log.info("Addition executed. Addition is {}", additionService.get(accountId, addition.getAdditionId()));
    }


}
