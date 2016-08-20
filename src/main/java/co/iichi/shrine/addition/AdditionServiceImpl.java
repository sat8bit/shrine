package co.iichi.shrine.addition;

import co.iichi.shrine.AccountService;
import co.iichi.shrine.AdditionService;
import co.iichi.shrine.account.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by sat8bit on 2016/07/03.
 */
@Slf4j
@Service
public class AdditionServiceImpl implements AdditionService {

    @Autowired
    private AdditionFactory additionFactory;

    @Autowired
    private AdditionDao additionDao;

    @Autowired
    private AccountServiceImpl accountService;

    @Override
    public Addition create(
            String accountId,
            BigInteger value,
            String description,
            String sourceTransactionId
    ) {
        if (accountService.get(accountId) == null) {
            log.info("not found.");
        }

        Addition addition = additionFactory.createNewAddition(accountId, value, description, sourceTransactionId);

        additionDao.store(addition);

        return addition;
    }

    @Override
    public Addition get(
            String accountId,
            String additionId
    ) {
        return null;
    }

    @Override
    public Addition execute(
            String accountId,
            String additionId
    ) {
        return null;
    }
}
