import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

/**
 * CreateDate:2016/7/28
 *
 * @version 1.0.
 * @auther XieChen
 */
public class JdbcTest {
    String url = "jdbc:mysql://localhost:3306/mes?user=test&password=test";

    @Test
    public void testMysql() throws SQLException {
        Connection connection = null;
        String sql;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url);
            sql = "select now() as CurrentTime;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            rs.last();
            int rowCount = rs.getRow();
            Assert.assertEquals(rowCount, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) connection.close();
        }
    }
}
