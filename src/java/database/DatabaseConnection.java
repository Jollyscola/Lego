package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseConnection extends MysqlDataSource {
/**
 * Method for setting up connection to Server.
 */
    public DatabaseConnection() {
//        setServerName("localhost");
//        setPort(3306);
//        setDatabaseName("CupCakes");
//        setUser("root");
//        setPassword("beograd05");
        setServerName("159.89.23.227");
        setPort(3306);
        setDatabaseName("lego");
        setUser("jollys");
        setPassword("google2018");
    }
}
