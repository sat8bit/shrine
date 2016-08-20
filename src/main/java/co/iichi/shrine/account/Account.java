package co.iichi.shrine.account;

import co.iichi.shrine.util.ZonedDateTimeUtils;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * Account.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String accountId;
    private BigInteger value;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastAddedAt;
    private ZonedDateTime lastSubtractedAt;

    public Optional<ZonedDateTime> getLastAddedAt() {
        return Optional.ofNullable(lastAddedAt);
    }

    public Optional<ZonedDateTime> getLastSubtractedAt() {
        return Optional.ofNullable(lastSubtractedAt);
    }

}