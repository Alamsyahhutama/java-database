package alamsyahhutama.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transactiontest {
    @Test
    void testCommit() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);

        String sql = "INSERT INTO comments (email, comment) VALUES (?, ?)";



        for (int i = 0;  i < 100_000 ; i++){
            PreparedStatement preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "alamsyah@test.com");
            preparedStatement.setString(2, "test");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        connection.commit();
        connection.close();
    }

    @Test
    void testRollback() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);

        String sql = "INSERT INTO comments (email, comment) VALUES (?, ?)";



        for (int i = 0;  i < 100 ; i++){
            PreparedStatement preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "hutama@test.com");
            preparedStatement.setString(2, "test");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        connection.rollback();
        connection.close();
    }
}
