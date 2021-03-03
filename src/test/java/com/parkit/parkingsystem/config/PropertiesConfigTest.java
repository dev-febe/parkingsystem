package com.parkit.parkingsystem.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PropertiesConfigTest {

    @Test
    public void getPropValuesWithFileFind() throws IOException {
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        assertNotNull(propertiesConfig.getConnectionURL());
        assertNotNull(propertiesConfig.getPassword());
        assertNotNull(propertiesConfig.getUsername());
    }
}
