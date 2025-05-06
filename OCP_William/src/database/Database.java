package database;

import exceptions.DatabaseException;

public interface Database {
    void executeUpdate(String sql, Object... params) throws DatabaseException;
}
