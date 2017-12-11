package org.dropbox.command.list;

import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import org.apache.commons.io.FilenameUtils;

import java.util.List;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class ListFileCommand extends AbstractListCommand {

    @Override
    protected boolean preProcess(List<String> params) {

        if (FilenameUtils.getExtension(params.get(1)).isEmpty())
            return false;
        return true;
    }

    @Override
    protected String getPath(String input) {
        return FilenameUtils.getFullPath(input);
    }

    @Override
    protected void printOutput(String param, ListFolderResult listFolderResult) {

        if (listFolderResult.getEntries() == null && listFolderResult.getEntries().size() == 0) {
            System.out.print("Requested file could not found!");
            return;
        }

        System.out.print(FileMetadataUtils.formatFileMetadata(param, getFileMetadata(param,listFolderResult)));
    }

    private FileMetadata getFileMetadata(String param, ListFolderResult listFolderResult){

        for(Metadata metadata:listFolderResult.getEntries()){
            if(metadata instanceof FileMetadata && metadata.getPathLower().equals(param))
                return (FileMetadata)metadata;
        }

        return null;
    }
}
