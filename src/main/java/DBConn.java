import java.sql.*;

public class DBConn {
    private String database;

    public DBConn(String db) {
        this.database = db;
    }

    public Connection connect() {
        String url = "jdbc:sqlite:" + this.database;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public String getObjectFromDb() throws SQLException {
        String sql = "select * from flights where dep_delay = (select min(dep_delay) from flights);";
        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        String json = "";
        while (rs.next()) {
            json = "{'day_of_week': " + rs.getInt("day_of_week") +
                    ", 'dep_time': " + rs.getInt("dep_time") +
                    ", 'dep_delay': " + rs.getInt("dep_delay") +
                    ", 'arr_time': " + rs.getInt("arr_time") +
                    ", 'arr_delay': " + rs.getInt("arr_delay") +
                    ", 'cancelled': " + rs.getInt("cancelled") +
                    ", 'diverted': " + rs.getInt("diverted") +
                    ", 'air_time': " + rs.getInt("air_time") +
                    ", 'distance': " + rs.getInt("distance") +
                    "}";
        }
        return json;
    }
}
