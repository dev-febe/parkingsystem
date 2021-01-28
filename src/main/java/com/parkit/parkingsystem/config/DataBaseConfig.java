package com.parkit.parkingsystem.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;

/**
 * Database configuration
 * May concerns all about database configuration
 */
public class DataBaseConfig {
    private static final Logger logger = LogManager.getLogger(DataBaseConfig.class);

    /**
     * Get the database connection driver
     *
     * @return DriverManager
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        logger.info("Create DB connection");
        Class.forName("com.mysql.cj.jdbc.Driver");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        return DriverManager.getConnection(
                propertiesConfig.getConnectionURL(), propertiesConfig.getUsername(), propertiesConfig.getPassword());
    }

    /**
     * Close a given connection
     *
     * @param con connection
     */
    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
                logger.info("Closing DB connection");
            } catch (SQLException e) {
                logger.error("Error while closing connection", e);
            }
        }
    }

    /**
     * Close a given prepared statement
     *
     * @param ps prepared statement
     */
    public void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
                logger.info("Closing Prepared Statement");
            } catch (SQLException e) {
                logger.error("Error while closing prepared statement", e);
            }
        }
    }

    /**
     * Close result set
     *
     * @param rs result set
     */
    public void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                logger.info("Closing Result Set");
            } catch (SQLException e) {
                logger.error("Error while closing result set", e);
            }
        }
    }
}
