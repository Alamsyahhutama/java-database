package alamsyahhutama.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {
    @Test
    void testStatement () throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement =  connection.createStatement();
        String sql = "INSERT INTO comments (email, comment) VALUES ('alams@test.com', 'hiii')";

        for (int i = 0;  i < 10000 ; i++){
            statement.addBatch(sql);
        }

        statement.executeBatch();

        connection.close();
    }

    @Test
    void testPreparedStatement () throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments (email, comment) VALUES (?, ?)";
        PreparedStatement preparedStatement =  connection.prepareStatement(sql);


        for (int i = 0;  i < 10000 ; i++){
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "alamsyah@test.com");
            preparedStatement.setString(2, "test");
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();
    }
}
