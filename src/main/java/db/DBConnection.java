package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbs?serverTimezone=Asia/Seoul"; // MySQL DB 주소
    private static final String USER = "root";                             // MySQL 사용자 이름
    private static final String PASSWORD = "0000";                 // MySQL 비밀번호

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC 드라이버 로드
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found.");
        }
    }
}
