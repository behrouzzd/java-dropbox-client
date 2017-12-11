package org.dropbox.command.help;

import org.dropbox.command.CommandType;
import org.dropbox.command.DropBoxCommand;

import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class HelpCommand implements DropBoxCommand {

    @Override
    public void execute(List<String> params) {

        System.out.println("Command list:");
        System.out.println("");
        System.out.println("auth {appKey:required} {appSecret:required}");
        System.out.println("info {accessToken:required} {locale:optional}");
        System.out.println("list {accessToken:required} {path} {locale:optional}");
        System.out.println("");
    }

    @Override
    public boolean isSupport(String commandSymbol) {
        return CommandType.HELP.getValue().equals(commandSymbol);
    }

}
