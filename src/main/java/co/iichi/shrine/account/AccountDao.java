package co.iichi.shrine.account;

import lombok.Cleanup;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

/**
 * Created by sat8bit on 2016/07/10.
 */
@Component
public class AccountDao {

    @PersistenceContext(unitName = "shrineUnit")
    private EntityManager em;

    @Transactional
    public void store(Account account) {
        em.persist(account);
    }

    public Account find(String accountId) {
        return em.find(Account.class, accountId);
    }
}
