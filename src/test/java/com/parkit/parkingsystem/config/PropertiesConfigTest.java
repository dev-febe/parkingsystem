package com.parkit.parkingsystem.config;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PropertiesConfigTest {

    @Test
    public void getPropValuesWithFileFind() throws IOException {
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        assertNotNull(propertiesConfig.getConnectionURL());
        assertNotNull(propertiesConfig.getPassword());
        assertNotNull(propertiesConfig.getUsername());
    }
}
