import com.tiza.mbp.mes.entity.account.User;
import com.tiza.mbp.mes.service.account.AccountService;
import com.tiza.mbp.utils.service.OperationResult;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * CreateDate:2016/7/29
 *
 * @version 1.0.
 * @auther XieChen
 */
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceUnitTest {
    @Autowired
    AccountService accountService;

    @Test
    public void registerUser() {
        String loginName = RandomStringUtils.randomAlphanumeric(10);
        User user = new User();
        user.setLoginName(loginName);
        user.setRealName(loginName);
        user.setLoginPassword(loginName);
        OperationResult result = accountService.registerUser(user);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
    }

    @Test
    public void registerQueryModifyDelete() {
        String loginName = RandomStringUtils.randomAlphanumeric(10);
        //插入用户
        User user = new User();
        user.setLoginName(loginName);
        user.setRealName(loginName);
        user.setLoginPassword(loginName);
        OperationResult result = accountService.registerUser(user);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
        //验证插入&&查询用户
        result = accountService.getUserByLoginName(loginName);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
        User queriedUser = (User) result.getResultData();
        Assert.assertEquals(queriedUser.getLoginName(), loginName);
        //更新用户
        loginName = RandomStringUtils.randomAlphanumeric(10);
        queriedUser.setLoginName(loginName);
        queriedUser.setRealName(loginName);
        queriedUser.setLoginPassword(loginName);
        result = accountService.modifyUserInfo(queriedUser);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
        //验证更新
        result = accountService.getUserByLoginName(loginName);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
        User queriedModifiedUser = (User) result.getResultData();
        Assert.assertEquals(queriedModifiedUser.getLoginName(), loginName);
        //删除用户
        result = accountService.deleteUserByLoginName(loginName);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
        //验证删除
        result = accountService.getUserByLoginName(loginName);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.QueryNull);
    }

    @Test
    public void login() {
        String loginName = RandomStringUtils.randomAlphanumeric(10);
        //插入用户
        User user = new User();
        user.setLoginName(loginName);
        user.setRealName(loginName);
        user.setLoginPassword(loginName);
        OperationResult result = accountService.registerUser(user);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
        //验证插入&&查询用户
        result = accountService.getUserByLoginName(loginName);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
        User queriedUser = (User) result.getResultData();
        Assert.assertEquals(queriedUser.getLoginName(), loginName);
        //login
        Assert.assertEquals(accountService.login(loginName,loginName).getResultType(), OperationResult.ResultType.Success);
        //删除用户
        result = accountService.deleteUserByLoginName(loginName);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.Success);
        //验证删除
        result = accountService.getUserByLoginName(loginName);
        Assert.assertEquals(result.getResultType(), OperationResult.ResultType.QueryNull);
    }
}
