package com.tiza.mbp.mes.controller.account;

import com.tiza.mbp.mes.service.account.AccountService;
import com.tiza.mbp.utils.service.OperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * CreateDate:2016/7/29
 *
 * @version 1.0.
 * @auther XieChen
 */
@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(String loginName, String loginPassword) {
        OperationResult operationResult = accountService.login(loginName, loginPassword);
        if (operationResult.getResultType() == OperationResult.ResultType.Success){
            return new ModelAndView("console");
        }
        return new ModelAndView("home");
    }
}
