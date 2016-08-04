package com.tiza.mbp.mes.service.account;

import com.tiza.mbp.utils.service.OperationResult;
import com.tiza.mbp.mes.entity.account.User;

/**
 * @version 1.0.
 * @auther XieChen
 */
public interface AccountService {
    OperationResult registerUser(User user);

    OperationResult login(String loginName, String loginPassword);

    OperationResult modifyUserInfo(User user);

    OperationResult getUserByLoginName(String loginName);

    OperationResult deleteUserByLoginName(String loginName);
}
