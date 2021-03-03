package com.parkit.parkingsystem.config;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class DataBaseConfigTest {
    Connection conn = mock(Connection.class);
    ResultSet rs = mock(ResultSet.class);
    PreparedStatement ps = mock(PreparedStatement.class);
    DataBaseConfig dataBaseConfig = new DataBaseConfig();

    @Test
    public void getConnection_shouldBeInstanceOfConnection() {
        try {
            dataBaseConfig.getConnection();
            assertNotNull(dataBaseConfig.getConnection());
        } catch (Exception e) {
            fail("got Exception");
        }
    }

    @Test
    public void closeConnection_shouldBeInstanceOfConnection() {
        try {
            dataBaseConfig.closeConnection(conn);
            verify(conn, (times(1))).close();
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void closePreparedStatement_shouldBeInstanceOfConnection() {
        try {
            dataBaseConfig.closePreparedStatement(ps);
            verify(ps, (times(1))).close();
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    public void closeResultSet_shouldBeInstanceOfConnection() {
        try {
            dataBaseConfig.closeResultSet(rs);
            verify(rs, (times(1))).close();
        } catch (Exception e) {
            fail(e);
        }
    }
}
