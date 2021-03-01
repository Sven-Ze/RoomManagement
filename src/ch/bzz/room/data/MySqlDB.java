package ch.bzz.room.data;

import ch.bzz.room.service.Config;
import ch.bzz.room.util.Result;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author Endrit Kukalaj
 * @version 1.0
 * @since 01.03.21
 */

public class MySqlDB {
    private static Connection connection = null;
    private static PreparedStatement prepStmt;
    private static ResultSet resultSet;

    static synchronized Result sqlSave (String sqlQuery, Map<Integer, String> values) {
        try {
            setPrepStmt(getConnection().prepareStatement(sqlQuery));
            setValues(values);

            int affectedRows = prepStmt.executeUpdate();
            if (affectedRows <= 2) {
                return Result.SUCCESS;
            } else if (affectedRows == 0) {
                return Result.NOACTION;
            } else {
                return Result.ERROR;
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            throw new RuntimeException();
        }

    }

    static synchronized ResultSet sqlSelect(String sqlQuery) {
        return sqlSelect(sqlQuery, null);
    }

    static synchronized ResultSet sqlSelect(String sqlQuery, Map<Integer, String> values) {
        try{
            setPrepStmt(getConnection().prepareStatement(sqlQuery));
            if (values != null && !values.isEmpty()) {
                setValues(values);
            }
            setResultSet(getPrepStmt().executeQuery());
        }catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new RuntimeException();
        }
        return getResultSet();
    }

    private static void setValues(Map<Integer, String>values) throws SQLException{
        for (Integer i=1; values.containsKey(i); i= i+1) {
            getPrepStmt().setString(i, values.get(i));
        }
    }

    /**
     * default constructor: defeat instantiation
     */
    private MySqlDB() {
    }

    /**
     * Close resultSet and prepared statement
     */
    static void sqlClose() {
        try {
            if (getResultSet() != null) getResultSet().close();
            if (getPrepStmt() != null) getPrepStmt().close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    /**
     * Gets the connection: open new connection if needed
     *
     * @return connection
     */
    static Connection getConnection() {
        try {
            if (connection == null || !connection.isValid(2)) {
                InitialContext initialContext = new InitialContext();
                DataSource dataSource = (DataSource) initialContext.lookup(
                        Config.getProperty("jdbcRessource")
                );
                setConnection(dataSource.getConnection());
            }
        } catch (NamingException namingException) {
            namingException.printStackTrace();
            throw new RuntimeException();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            throw new RuntimeException();
        }

        return connection;
    }

    /**
     * Sets the connection
     *
     * @param connection the value to set
     */

    private static void setConnection(Connection connection) {
        MySqlDB.connection = connection;
    }

    /**
     * Gets the prepStmt
     *
     * @return value of prepStmt
     */
    private static PreparedStatement getPrepStmt() {
        return prepStmt;
    }

    /**
     * Sets the prepStmt
     *
     * @param prepStmt the value to set
     */

    public static void setPrepStmt(PreparedStatement prepStmt) {
        MySqlDB.prepStmt = prepStmt;
    }

    /**
     * Gets the resultSet
     *
     * @return value of resultSet
     */
    public static ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * Sets the resultSet
     *
     * @param resultSet the value to set
     */

    public static void setResultSet(ResultSet resultSet) {
        MySqlDB.resultSet = resultSet;
    }
}
