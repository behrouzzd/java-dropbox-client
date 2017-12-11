package org.dropbox.command.auth;

import com.dropbox.core.DbxWebAuth;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public class WebAuthorizationEntity {

    private DbxWebAuth dbxWebAuth;
    private String authorizeUrl;

    public WebAuthorizationEntity() {
    }

    public WebAuthorizationEntity(DbxWebAuth dbxWebAuth, String authorizeUrl) {
        this.dbxWebAuth = dbxWebAuth;
        this.authorizeUrl = authorizeUrl;
    }

    public DbxWebAuth getDbxWebAuth() {
        return dbxWebAuth;
    }

    public void setDbxWebAuth(DbxWebAuth dbxWebAuth) {
        this.dbxWebAuth = dbxWebAuth;
    }

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }
}
