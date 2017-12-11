package org.dropbox.command.info;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;
import com.dropbox.core.v2.users.Name;
import org.dropbox.command.CommandType;
import org.dropbox.command.DropBoxCommand;

import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class AccountInfoCommand implements DropBoxCommand {

    @Override
    public void execute(List<String> params) {

        if (params == null || params.size() == 0)
            throw new RuntimeException("Parameters are not enough to execute this command!");

        String cmd = params.get(0);
        String locale = null;
        if (params.size() > 1)
            locale = params.get(1);

        FullAccount dbxAccountInfo;
        try {
            dbxAccountInfo = getFullAccount(cmd, locale);
        } catch (DbxException ex) {

            throw new RuntimeException("Error making API call", ex);
        }

        Name name = dbxAccountInfo.getName();

        System.out.println("User ID:        " + dbxAccountInfo.getAccountId());
        System.out.println("Display name:   " + name.getDisplayName());
        System.out.println("Name:           " + name.getGivenName() + " " + name.getSurname() + " " + name.getFamiliarName());
        System.out.println("Email:          " + dbxAccountInfo.getEmail());
        System.out.println("Country:        " + dbxAccountInfo.getCountry());
        System.out.println("Referral link:  " + dbxAccountInfo.getReferralLink());
    }

    public FullAccount getFullAccount(String accessToken, String locale) throws DbxException {

        DbxRequestConfig requestConfig = new DbxRequestConfig("account-info", locale);
        DbxClientV2 dbxClient = new DbxClientV2(requestConfig, accessToken);

        return dbxClient.users().getCurrentAccount();
    }

    @Override
    public boolean isSupport(String commandSymbol) {
        return CommandType.INFO.getValue().equals(commandSymbol);
    }

}
