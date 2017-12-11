package org.dropbox.command.list;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import org.dropbox.command.CommandType;
import org.dropbox.command.DropBoxCommand;

import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public abstract class AbstractListCommand implements DropBoxCommand {

    protected abstract boolean preProcess(List<String> params);

    protected abstract String getPath(String name);

    protected abstract void printOutput(String name, ListFolderResult listFolderResult);

    @Override
    public void execute(List<String> params) {

        if (params == null || params.size() < 2)
            throw new RuntimeException("Parameters are not enough to execute this command!");

        if (!preProcess(params))
            return;

        String accessToken = params.get(0);
        String param = params.get(1);
        String locale = null;
        if(params.size()>2)
            locale = params.get(2);

        try {

            ListFolderResult listFolderResult = getFolderList(accessToken, param,locale);
            printOutput(param, listFolderResult);

        } catch (Exception e) {
            throw new RuntimeException("Error executing auth command!", e);
        }
    }


    public ListFolderResult getFolderList(String accessToken, String path, String locale) throws DbxException {

        if (accessToken == null || path == null ||
                accessToken.isEmpty() || path.isEmpty())
            throw new RuntimeException("Arguments are required!");

        path = getPath(path);

        DbxRequestConfig requestConfig = new DbxRequestConfig("list-file", locale);
        DbxClientV2 dbxClient = new DbxClientV2(requestConfig, accessToken);

        return dbxClient.files().listFolderBuilder(path).
                withRecursive(false).
                withIncludeMediaInfo(true).
                withIncludeMediaInfo(true).
                start();

    }

    @Override
    public boolean isSupport(String commandSymbol) {
        return CommandType.LIST.getValue().equals(commandSymbol);
    }

}
