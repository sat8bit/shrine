package co.iichi.shrine;

import co.iichi.shrine.account.Account;

/**
 * 口座を操作するインターフェース。
 */
public interface AccountService {
    /**
     * 口座の作成。
     * @return
     */
    Account create();

    /**
     * 口座の取得。
     * @param accountId
     * @return
     */
    Account get(String accountId);
}