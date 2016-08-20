package co.iichi.shrine.addition;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sat8bit on 2016/07/10.
 */
@Component
public class AdditionDao {

    @PersistenceContext(unitName = "shrineUnit")
    private EntityManager em;

    @Transactional
    public void store(Addition addition) {
        em.persist(addition);
    }

    @Transactional
    public void find(String accountId, String additionId) {

    }

}
