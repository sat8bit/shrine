package co.iichi.shrine.addition;

import co.iichi.shrine.constraint.TransactionResult;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Addition.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Addition implements Serializable {
    @Id
    private String accountId;

    @Id
    private String additionId;
    private BigInteger value;
    private String description;
    private String sourceTransactionId;
    private ZonedDateTime createdAt;
    private ZonedDateTime executedAt;
    private TransactionResult transactionResult;

    public Optional<ZonedDateTime> getExecutedAt() {
        return Optional.ofNullable(executedAt);
    }
}