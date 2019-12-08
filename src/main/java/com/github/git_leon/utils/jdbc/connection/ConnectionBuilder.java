package com.github.git_leon.utils.jdbc.connection;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import gitleon.utils.exceptionalfunctionalinterface.ExceptionalConsumer;
import gitleon.utils.exceptionalfunctionalinterface.ExceptionalSupplier;

import java.sql.Connection;


/**
 * Created by leon on 3/13/18.
 */
public class ConnectionBuilder implements ConnectionBuilderInterface {

    private final MysqlDataSource dataSource;

    public ConnectionBuilder() {
        this(new MysqlDataSource());
    }

    public ConnectionBuilder(MysqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ConnectionBuilderInterface setDatabaseName(String databaseName) {
        return setProperty(dataSource::setDatabaseName, databaseName, DatabaseProperty.NAME);
    }

    @Override
    public ConnectionBuilderInterface setServerName(String serverName) {
        return setProperty(dataSource::setServerName, serverName, DatabaseProperty.SERVER_NAME);
    }

    @Override
    public ConnectionBuilderInterface setPort(int portNumber) {
        return setProperty(dataSource::setPort, portNumber, DatabaseProperty.PORT_NUMBER);
    }

    @Override
    public ConnectionBuilderInterface setUser(String user) {
        return setProperty(dataSource::setUser, user, DatabaseProperty.USER);
    }

    @Override
    public ConnectionBuilderInterface setPassword(String password) {
        return setProperty(dataSource::setPassword, password, DatabaseProperty.PASSWORD);
    }

    @Override
    public ConnectionBuilderInterface setServerTimezone(String serverTimezone) {
        return setProperty(dataSource::setServerTimezone, serverTimezone, DatabaseProperty.SERVER_TIMEZONE);
    }


    @Override
    public ConnectionBuilderInterface setUrl(String url) {
        return setProperty(dataSource::setUrl, url, DatabaseProperty.URL);
    }

    private <E> ConnectionBuilderInterface setProperty(ExceptionalConsumer<E> setMethod, E valueToSetTo, DatabaseProperty property) {
        String error = "Failed to set property `%s` to `%s`";
        String errorMessage = String.format(error, property.name(), valueToSetTo);
        ExceptionalConsumer.tryInvoke(setMethod, valueToSetTo, errorMessage);
        return this;
    }

    @Override
    public Connection build() {
        String errorMessage = "Failed to build connection.";
        return ExceptionalSupplier.tryInvoke(dataSource::getConnection, errorMessage);
    }
}
