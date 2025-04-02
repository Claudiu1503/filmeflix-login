package net.arhitecture.filmeflixlogin.DB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Test to verify that the DataSource is properly configured and can establish a connection.
     */
    @Test
    public void testDataSourceConnection() throws SQLException {
        // Ensure the DataSource is not null
        assertThat(dataSource).isNotNull();

        // Attempt to establish a connection using the DataSource
        try (Connection connection = dataSource.getConnection()) {
            assertThat(connection).isNotNull();
            assertThat(connection.isValid(5)).isTrue(); // Check if the connection is valid within 5 seconds
        }
    }

    /**
     * Test to verify that the JdbcTemplate can execute a simple query.
     */
    @Test
    public void testJdbcTemplateQuery() {
        // Execute a simple query to verify the connection
        String sql = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);

        // Assert that the query returns the expected result
        assertThat(result).isEqualTo(1);
    }
}