package io.magicianlib.fs.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatasourceValidator {
    private final DataSource dataSource;
    private static final Logger LOGGER = LogManager.getLogger(DatasourceValidator.class);

    public DatasourceValidator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void testConnect() {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("✅ Connected to: " + conn.getMetaData().getURL());
            System.out.println("✅ Driver: " + conn.getMetaData().getDriverName());
            System.out.println("✅ Version: " + conn.getMetaData().getDatabaseProductVersion());
        } catch (SQLException e) {
            LOGGER.error("⚠️ Connect databases fault: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}