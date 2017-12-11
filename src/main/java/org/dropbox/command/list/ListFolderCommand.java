package org.dropbox.command.list;

import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import org.apache.commons.io.FilenameUtils;

import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class ListFolderCommand extends AbstractListCommand {

    @Override
    protected boolean preProcess(List<String> params) {

        if (!FilenameUtils.getExtension(params.get(1)).isEmpty())
            return false;
        return true;

    }

    @Override
    protected String getPath(String input) {
        return input;
    }

    @Override
    protected void printOutput(String param, ListFolderResult listFolderResult) {

        if (listFolderResult.getEntries() == null && listFolderResult.getEntries().size() == 0) {
            System.out.print("Requested folder could not found!");
            return;
        }

        for (Metadata metadata : listFolderResult.getEntries()) {
            if (metadata instanceof FileMetadata)
                System.out.println(FileMetadataUtils.formatFileMetadata(param, (FileMetadata) metadata));
            else if (metadata instanceof FolderMetadata)
                System.out.println(FileMetadataUtils.formatFolderMetadata((FolderMetadata) metadata));
        }
    }
}
