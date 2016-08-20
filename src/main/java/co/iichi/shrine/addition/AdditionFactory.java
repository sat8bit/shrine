package co.iichi.shrine.addition;

import co.iichi.shrine.constraint.TransactionResult;
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
public class AdditionFactory {
    public Addition createNewAddition(
            String accountId,
            BigInteger value,
            String description,
            String sourceTransactionId
    ) {
        return createAddition(
                accountId,
                IdentifierUtils.generateAdditionId(),
                value,
                description,
                sourceTransactionId,
                ZonedDateTimeUtils.now(),
                null,
                TransactionResult.CREATED
        );
    }

    public Addition createAddition(
            String accountId,
            String additionId,
            BigInteger value,
            String description,
            String sourceTransactionId,
            ZonedDateTime createdAt,
            ZonedDateTime executedAt,
            TransactionResult transactionResult
    ) {
        return new Addition(
                accountId,
                additionId,
                value,
                description,
                sourceTransactionId,
                createdAt,
                executedAt,
                transactionResult
        );
    }
}
