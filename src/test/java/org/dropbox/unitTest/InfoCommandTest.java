package org.dropbox.unitTest;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.users.FullAccount;
import org.dropbox.command.info.AccountInfoCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
//@RunWith(JUnit4.class)
public class InfoCommandTest {

    AccountInfoCommand accountInfoCommand;

    //@Before
    public void setUp() {
        accountInfoCommand = new AccountInfoCommand();
    }

    //@Test
    public void getFullAccountTest() throws DbxException {

        FullAccount fullAccount = accountInfoCommand.getFullAccount("EJSZAWImE3EJjW1veIk-LRbeujs43-9YSEFGSAE",null);

        assert fullAccount != null;
        assert !isEmpty(fullAccount.getAccountId());
        assert !isEmpty(fullAccount.getCountry());
        assert !isEmpty(fullAccount.getEmail());
        assert !isEmpty(fullAccount.getLocale());
        assert fullAccount.getName() != null;

    }

    private boolean isEmpty(String input) {
        if (input == null || input.isEmpty())
            return true;
        return false;
    }
}
