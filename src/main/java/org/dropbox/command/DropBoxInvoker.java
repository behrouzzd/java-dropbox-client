package org.dropbox.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class DropBoxInvoker {

    private List<DropBoxCommand> dropBoxCommands;

    public void addCommand(DropBoxCommand dropBoxCommand) {
        if (dropBoxCommands == null)
            dropBoxCommands = new ArrayList<>();
        dropBoxCommands.add(dropBoxCommand);
    }

    public void execute(String command, List<String> params) {

        dropBoxCommands.stream().
                filter(dropBoxCommand -> dropBoxCommand.isSupport(command)).
                forEach(cmd -> cmd.execute(params));

    }

}
