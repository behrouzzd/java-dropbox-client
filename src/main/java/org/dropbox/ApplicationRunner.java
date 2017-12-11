package org.dropbox;

import org.dropbox.command.DropBoxInvoker;
import org.dropbox.command.NoOpCommand;
import org.dropbox.command.auth.AuthCommand;
import org.dropbox.command.help.HelpCommand;
import org.dropbox.command.info.AccountInfoCommand;
import org.dropbox.command.list.ListFileCommand;
import org.dropbox.command.list.ListFolderCommand;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class ApplicationRunner {

    public static void main(String[] args) throws IOException {

        DropBoxInvoker dropBoxInvoker = new DropBoxInvoker();
        dropBoxInvoker.addCommand(new HelpCommand());
        dropBoxInvoker.addCommand(new AuthCommand());
        dropBoxInvoker.addCommand(new AccountInfoCommand());
        dropBoxInvoker.addCommand(new ListFileCommand());
        dropBoxInvoker.addCommand(new ListFolderCommand());
        dropBoxInvoker.addCommand(new NoOpCommand());

        if (args.length >= 1)
            dropBoxInvoker.execute(args[0], Arrays.asList(args).subList(1, args.length));
        else
            System.out.println("Argument required for command. run 'help' command for more information");

    }

}
