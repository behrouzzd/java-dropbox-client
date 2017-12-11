package org.dropbox.command;

/**
 * Created by Behrouz-ZD on 12/10/2017.
 */
public enum CommandType {

    INFO("info"),
    LIST("list"),
    AUTH("auth"),
    HELP("help");

    private String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static CommandType fromValue(String value){
        for (CommandType ct:CommandType.values())
            if (ct.value.equals(value))
                return ct;
        return null;
    }

    public static boolean isValid(String value){
        for (CommandType ct:CommandType.values())
            if (ct.value.equals(value))
                return true;
        return false;
    }
}
