package co.iichi.shrine.addition;

import co.iichi.shrine.AdditionService;
import co.iichi.shrine.TestApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Created by sat8bit on 2016/07/09.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestApplication.class)
public class AdditionServiceTest {

    @Autowired
    private AdditionServiceImpl additionService;

    @Test
    public void createTest() {
        String accountId = "ac_0000000000001";
        BigInteger value = BigInteger.valueOf(500);
        String description = "Addition description";
        String sourceTransactionId = "CreditCard_0000000001";

        Addition addition = additionService.create(
                accountId,
                value,
                description,
                sourceTransactionId
        );

        log.debug("addition is {}", addition);

        Assert.assertThat(addition.getAccountId(), is(accountId));
        Assert.assertThat(addition.getAdditionId().length(), is(12));
        Assert.assertThat(addition.getValue(), is(value));
        Assert.assertThat(addition.getDescription(), is(description));
        Assert.assertThat(addition.getSourceTransactionId(), is(sourceTransactionId));
        Assert.assertThat(addition.getCreatedAt(), is(notNullValue()));
    }

}
