package database;

import exceptions.DatabaseException;

public class MySQLDatabase implements Database {
    @Override
    public void executeUpdate(String sql, Object... params) throws DatabaseException {
        System.out.println("Executing SQL: " + sql);
    }
}
