package org.dropbox.command.list;

import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.FolderMetadata;
import org.apache.commons.io.FilenameUtils;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class FileMetadataUtils {

    public static String formatFileMetadata(String param, FileMetadata fileMetadata) {

        if (fileMetadata == null || param == null || param.equals(""))
            return "";

        return fileMetadata.getPathLower() + "     : file, " +
                fileMetadata.getSize() + ", " +
                FilenameUtils.getExtension(param) + ", " +
                "modified at: " + fileMetadata.getClientModified();

    }

    // This API version does not support modified date for folder
    public static String formatFolderMetadata(FolderMetadata folderMetadata) {

        if (folderMetadata == null)
            return "";

        return folderMetadata.getPathLower() + "     : dir";

    }

}
