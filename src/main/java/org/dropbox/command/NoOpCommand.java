package org.dropbox.command;

import java.util.List;

/**
 * Created by Behrouz-ZD on 12/11/2017.
 */
public class NoOpCommand implements DropBoxCommand{


    @Override
    public void execute(List<String> params) {
        System.out.println("Command is invalid! for more information run 'help' command");
    }

    @Override
    public boolean isSupport(String commandSymbol) {
        return !CommandType.isValid(commandSymbol);
    }
}
