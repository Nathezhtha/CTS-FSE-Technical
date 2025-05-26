import java.sql.*;

public class MoneyTransfer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_db";
        String user = "root";
        String pass = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("UPDATE accounts SET balance = balance - 500 WHERE id = 1");
            stmt.executeUpdate("UPDATE accounts SET balance = balance + 500 WHERE id = 2");

            conn.commit();
            System.out.println("Transfer successful.");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Connection conn = DriverManager.getConnection(url, user, pass);
                conn.rollback();
                System.out.println("Transaction rolled back.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}