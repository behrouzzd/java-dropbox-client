package org.dropbox.unitTest;

import org.dropbox.command.auth.AuthCommand;
import org.dropbox.command.auth.WebAuthorizationEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
//@RunWith(JUnit4.class)
public class AuthCommandTest {

    AuthCommand authCommand;

    //@Before
    public void setUp() {
        authCommand = new AuthCommand();
    }

    //@Test
    public void getAuthorizedEntityTest() {

        List<String> args = new ArrayList<>();
        args.add("1234");
        args.add("12345");
        WebAuthorizationEntity webAuthorizationEntity = authCommand.getAuthorizedEntity("oh7y8uxtjs7liah", "oh7y8uxtjs7liah");

        assert webAuthorizationEntity != null;
        assert webAuthorizationEntity.getDbxWebAuth() != null;
        assert webAuthorizationEntity.getAuthorizeUrl() != null && !webAuthorizationEntity.getAuthorizeUrl().isEmpty();

    }

}
