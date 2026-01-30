import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/car_pooling";
            String user = "postgres";
            String password = "Shalini19jan";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("PostgreSQL Connected!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}