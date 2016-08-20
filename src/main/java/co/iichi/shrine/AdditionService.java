package co.iichi.shrine;

import co.iichi.shrine.addition.Addition;

import java.math.BigInteger;

/**
 * Created by sat8bit on 2016/07/03.
 */
public interface AdditionService {
    /**
     * 加算の作成。
     * @param accountId
     * @param value
     * @param description
     * @param sourceTransactionId
     * @return
     */
    Addition create(
            String accountId,
            BigInteger value,
            String description,
            String sourceTransactionId
    );

    /**
     * 加算の取得。
     * @param additionId
     * @return
     */
    Addition get(
            String accountId,
            String additionId
    );

    /**
     * 加算の実行。
     * @param additionId
     * @return
     */
    Addition execute(
            String accountId,
            String additionId
    );
}
