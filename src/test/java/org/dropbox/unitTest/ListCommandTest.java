package org.dropbox.unitTest;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.ListFolderResult;
import org.dropbox.command.list.ListFileCommand;
import org.dropbox.command.list.ListFolderCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */

//@RunWith(JUnit4.class)
public class ListCommandTest {

    ListFileCommand listFileCommand;
    ListFolderCommand listFolderCommand;

    //@Before
    public void setUp() {
        listFileCommand = new ListFileCommand();
        listFolderCommand = new ListFolderCommand();
    }

    //@Test
    public void getFolderListTest() throws DbxException {
        ListFolderResult listFolderResult = listFileCommand.getFolderList("12345","/Test/test/test.info",null);
        assert listFolderResult != null;
    }

    //@Test
    public void getFileListTest() throws DbxException {
        ListFolderResult listFolderResult = listFileCommand.getFolderList("1234","/Test/test/",null);
        assert listFolderResult != null;
    }

}
