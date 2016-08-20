package co.iichi.shrine.constraint;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TransactionResult {

    CREATED(Status.STATUS_CREATED, "0000"),
    SUCCEEDED(Status.STATUS_SUCCEEDED, "1000"),
    FAILED_SHORTAGE(Status.STATUS_FAILED, "9000"),
    FAILED_SYSTEM_ERROR(Status.STATUS_FAILED, "9999"),
    ;

    private String status;
    private String causeCode;

    public static TransactionResult of(String status, String causeCode) {
        for(TransactionResult transactionResult : values()) {
            if (transactionResult.status.equals(status) && transactionResult.causeCode.equals(causeCode)) {
                return transactionResult;
            }
        }

        throw new IllegalArgumentException("No such resultSet[" + status + "," + causeCode + "]");
    }

    private class Status {
        public static final String STATUS_CREATED = "created";
        public static final String STATUS_SUCCEEDED = "succeeded";
        public static final String STATUS_FAILED = "failed";
    }
}
