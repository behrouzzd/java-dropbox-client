package org.dropbox.command;

import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public interface DropBoxCommand {

    void execute(List<String> params);

    boolean isSupport(String commandSymbol);
}
