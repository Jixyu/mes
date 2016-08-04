package com.tiza.mbp.mes.serviceImpl.account;

import com.tiza.mbp.utils.encrypt.MD5Util;
import com.tiza.mbp.utils.service.OperationResult;
import com.tiza.mbp.mes.dao.account.UserDao;
import com.tiza.mbp.mes.entity.account.User;
import com.tiza.mbp.mes.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.
 * @auther XieChen
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserDao userDao;

    public OperationResult registerUser(User user) {
        try {
            if (user == null) throw new Exception("要注册的用户信息不能为空。");
            if (userDao.hasLoginName(user.getLoginName()) > 0)
                throw new Exception("用户'" + user.getLoginName() + "'已经存在。");
            user.setLoginPassword(MD5Util.md5Encode(user.getLoginPassword()));
            userDao.insert(user);
            return new OperationResult(OperationResult.ResultType.Success);
        } catch (Exception e) {
            return new OperationResult(OperationResult.ResultType.Error, e.getMessage());
        }

    }

    public OperationResult login(String loginName, String loginPassword) {
        if (loginName == null || loginName == "" || loginPassword == null || loginPassword == "")
            return new OperationResult(OperationResult.ResultType.Error, "登录名或登录密码不能为空。");
        User user = userDao.getByLoginName(loginName);
        if (user == null) return new OperationResult(OperationResult.ResultType.QueryNull, "用户不存在。");
        try {
            String encodingPassword = MD5Util.md5Encode(loginPassword);
            if (!user.getLoginPassword().equals(encodingPassword)) {
                return new OperationResult(OperationResult.ResultType.Error, "登录密码不正确。");
            }
        } catch (Exception e) {
            //todo: log
        }
        return new OperationResult(OperationResult.ResultType.Success);
    }

    public OperationResult modifyUserInfo(User user) {
        try {
            if (user == null) throw new Exception("要更新的用户信息不能为空。");
            if (user.getLoginName() == null || user.getLoginName() == "" || user.getLoginPassword() == null || user.getLoginPassword() == "") {
                throw new Exception("登录名或登录密码不能为空。");
            }
            user.setLoginPassword(MD5Util.md5Encode(user.getLoginPassword()));
            userDao.update(user);
            return new OperationResult(OperationResult.ResultType.Success);
        } catch (Exception e) {
            return new OperationResult(OperationResult.ResultType.Error, e.getMessage());
        }
    }

    public OperationResult getUserByLoginName(String loginName) {
        try {
            if (loginName == null || loginName == "") {
                return new OperationResult(OperationResult.ResultType.Error, "登录名不能为空。");
            }
            User user = userDao.getByLoginName(loginName);
            if (user == null) {
                return new OperationResult(OperationResult.ResultType.QueryNull, "用户不存在。");
            }
            return new OperationResult(OperationResult.ResultType.Success, user, "查询用户成功。");
        } catch (Exception e) {
            return new OperationResult(OperationResult.ResultType.Error, e.getMessage());
        }
    }

    public OperationResult deleteUserByLoginName(String loginName) {
        try {
            if (loginName == null || loginName == "") {
                return new OperationResult(OperationResult.ResultType.Error, "登录名不能为空。");
            }
            User user = userDao.getByLoginName(loginName);
            if (user == null) {
                return new OperationResult(OperationResult.ResultType.QueryNull, "用户不存在。");
            }
            userDao.deleteById(user.getId());
            return new OperationResult(OperationResult.ResultType.Success);
        } catch (Exception e) {
            return new OperationResult(OperationResult.ResultType.Error, e.getMessage());
        }
    }
}
