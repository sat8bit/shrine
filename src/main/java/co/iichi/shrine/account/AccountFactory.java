package co.iichi.shrine.account;

import co.iichi.shrine.util.IdentifierUtils;
import co.iichi.shrine.util.ZonedDateTimeUtils;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Created by sat8bit on 2016/07/03.
 */
@Component
public class AccountFactory {
    public Account createNewAccount() {
        return createAccount(
                IdentifierUtils.generateAccountId(),
                BigInteger.ZERO,
                ZonedDateTimeUtils.now(),
                null,
                null
        );
    }

    public Account createAccount(
            String accountId,
            BigInteger value,
            ZonedDateTime createdAt,
            ZonedDateTime lastAddedAt,
            ZonedDateTime lastSubtractedAt
    ) {
        return new Account(
                accountId,
                value,
                createdAt,
                lastAddedAt,
                lastSubtractedAt
        );
    }
}