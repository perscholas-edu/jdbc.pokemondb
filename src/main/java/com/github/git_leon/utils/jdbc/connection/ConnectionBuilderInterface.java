package com.github.git_leon.utils.jdbc.connection;

import java.sql.Connection;

/**
 * Created by leon on 3/13/18.
 */
public interface ConnectionBuilderInterface {
    ConnectionBuilderInterface setDatabaseName(String databaseName);

    ConnectionBuilderInterface setServerName(String serverName);

    ConnectionBuilderInterface setPort(int portNumber);

    ConnectionBuilderInterface setUser(String user);

    ConnectionBuilderInterface setPassword(String password);

    ConnectionBuilderInterface setServerTimezone(String serverTimezone);

    ConnectionBuilderInterface setUrl(String url);

    Connection build();

    public enum DatabaseProperty {
        NAME,
        PASSWORD,
        PORT_NUMBER,
        SERVER_NAME,
        SERVER_TIMEZONE,
        USER,
        URL;
    }
}
