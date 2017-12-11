package org.dropbox.command.auth;

import com.dropbox.core.*;
import org.dropbox.command.CommandType;
import org.dropbox.command.DropBoxCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class AuthCommand implements DropBoxCommand {

    @Override
    public void execute(List<String> params) {

        if (params == null || params.size() != 2)
            throw new RuntimeException("Parameters are not enough to execute this command!");


        WebAuthorizationEntity authorizationEntity = getAuthorizedEntity(params.get(0), params.get(1));

        System.out.println("1. Go to " + authorizationEntity.getAuthorizeUrl());
        System.out.println("2. Click \"Allow\" (you might have to log in first).");
        System.out.println("3. Copy the authorization code.");
        System.out.print("Enter the authorization code here: ");


        String code;
        try {
            code = new BufferedReader(new InputStreamReader(System.in)).readLine();

            if (code == null || code.isEmpty()) {
                throw new RuntimeException("authorization code could not be empty!");
            }

            String accessToken = getAccessToken(code.trim(), authorizationEntity.getDbxWebAuth());

            System.out.println("Your access token: " + accessToken);

        } catch (Exception e) {
            throw new RuntimeException("Error executing auth command!", e);
        }
    }

    public WebAuthorizationEntity getAuthorizedEntity(String appKey, String appSecret) {

        if (appKey == null || appSecret == null || appKey.isEmpty() || appSecret.isEmpty())
            throw new RuntimeException("Arguments are required!");

        DbxAppInfo appInfo = new DbxAppInfo(appKey, appSecret);
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-authorize");
        DbxWebAuth webAuth = new DbxWebAuth(requestConfig, appInfo);
        DbxWebAuth.Request webAuthRequest = DbxWebAuth.newRequestBuilder()
                .withNoRedirect()
                .build();

        String authorizedUrl = webAuth.authorize(webAuthRequest);
        return new WebAuthorizationEntity(webAuth, authorizedUrl);
    }


    public String getAccessToken(String authorizationCode, DbxWebAuth dbxWebAuth) throws DbxException {

        DbxAuthFinish authFinish = null;
        authFinish = dbxWebAuth.finishFromCode(authorizationCode);
        return authFinish.getAccessToken();
    }

    @Override
    public boolean isSupport(String commandSymbol) {
        return CommandType.AUTH.getValue().equals(commandSymbol);
    }

}
