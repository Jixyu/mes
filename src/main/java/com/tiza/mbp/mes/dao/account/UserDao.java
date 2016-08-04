package com.tiza.mbp.mes.dao.account;

import com.tiza.mbp.mes.entity.account.User;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0.
 * @auther XieChen
 */
@Repository
public interface UserDao {
    int hasLoginName(String loginName);

    void insert(User user);

    User getByLoginName(String loginName);

    void update(User user);

    void deleteById(long id);
}
